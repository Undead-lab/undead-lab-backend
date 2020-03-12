package io.wootlab.data;

import com.google.cloud.Tuple;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import io.wootlab.data.model.Article;
import io.wootlab.data.model.ArticleContent;
import io.wootlab.data.model.SearchArticleResult;
import io.wootlab.data.model.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Singleton
public class ArticlesService {
    private static final String ARTICLES_COLLECTION = "articles";
    private static final String ARTICLES_HTML_COLLECTION = "articlesHtmlContent";
    private static final Logger log = LoggerFactory.getLogger(ArticlesService.class);

    @Inject
    FirestoreClient db;

    public Optional<Article> findArticleByUrl(String url) {
        try {
            var documents = queryFirestore(ARTICLES_COLLECTION, Optional.of(Tuple.of("url", url)), Optional.empty());
            if (documents != null && documents.size() > 0) {
                var document = documents.get(0);
                if (documents.size() > 1){
                    log.warn("More than 1 article found for this url : {}, returning the first result...", url);
                }
                if (!document.get("published", Boolean.class)){
                    return Optional.empty();
                }
                var article = document.toObject(Article.class);
                article.setContent(findContentByPath(article.getPath()));
                return Optional.of(article);
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error(String.format("Error while searching / converting article url : {}", url), e);
        }
        return Optional.empty();
    }

    private Optional<String> findContentByPath(String path) {
        try {
            var documents = queryFirestore(ARTICLES_HTML_COLLECTION, Optional.of(Tuple.of("path", path)), Optional.empty());
            if (documents != null && documents.size() > 0) {
                if (documents.size() > 1){
                    log.warn("More than 1 article html content found for this path : {}, returning the first result...", path);
                }
                var document = documents.get(0);
                var content = document.toObject(ArticleContent.class);
                return Optional.of(content.getContent());
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error(String.format("Error while searching article html content for path : {}", path), e);
        }
        return Optional.empty();
    }

    public SearchArticleResult findArticles(Optional<Integer> page, Optional<String> tag) {
        var result = new SearchArticleResult();
        int startIndex = computeStartIndex(page);

        try {
            var documents = queryFirestore(ARTICLES_COLLECTION, Optional.of(Tuple.of("published", true)),  Optional.of(Tuple.of("date",  Query.Direction.DESCENDING)));
            if (documents != null && documents.size() > 0) {
                if(tag.isPresent()){
                    documents = documents.stream().filter(doc -> doc.get("tag").equals(tag.get())).collect(Collectors.toList());
                }
                result.setTotalPages((documents.size() / 8) + ((documents.size() % 8) > 0 ? 1 : 0));
                final int documentsSize = documents.size();
                var validIndexes = IntStream.range(startIndex, startIndex + 8).filter(index -> index < documentsSize).boxed().collect(Collectors.toList());

                for(int index : validIndexes){
                    result.getArticles().add(documents.get(index).toObject(Article.class));
                }
            }else{
                result.setTotalPages(0);
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error(String.format("Error while searching articles with filters : page:{}, tag:{}", page, tag), e);
        }
        return result;
    }

    public List<Tag> findTags() {
        try {
            var documents = queryFirestore(ARTICLES_COLLECTION, Optional.of(Tuple.of("published", true)), Optional.empty());
            if (documents != null && documents.size() > 0) {
                return documents.stream()
                        .collect(Collectors.groupingBy(e -> e.get("tag").toString()))
                        .entrySet().stream()
                        .map(entry -> new Tag(entry.getKey(), entry.getValue().size()))
                        .filter(tag -> !tag.getTag().isEmpty())
                        .collect(Collectors.toList());
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error while getting tags", e);
        }
        return Collections.emptyList();
    }

    private  List<QueryDocumentSnapshot>  queryFirestore(String collection, Optional<Tuple<String, Object>> optWhereEqual, Optional<Tuple<String, Query.Direction>> optOrderBy) throws ExecutionException, InterruptedException {
        var request = db.getFirestore().collection(collection);
        if(optWhereEqual.isPresent()){
            var whereEqual = optWhereEqual.get();
            request.whereEqualTo(whereEqual.x(), whereEqual.y());
        }

        if(optOrderBy.isPresent()){
            var orderBy = optOrderBy.get();
            request.orderBy(orderBy.x(), orderBy.y());
        }

        return request.get().get().getDocuments();
    }

    private int computeStartIndex(Optional<Integer> page) {
        return page.isPresent() && page.get() > 0 ? (page.get()-1) * 8 : 0;
    }
}
