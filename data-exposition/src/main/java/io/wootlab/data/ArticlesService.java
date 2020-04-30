package io.wootlab.data;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import io.wootlab.data.model.Article;
import io.wootlab.data.model.ArticleContent;
import io.wootlab.data.model.SearchArticleResult;
import io.wootlab.data.model.Tag;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Singleton
public class ArticlesService {
    @Inject
    FirestoreClient db;

    public Optional<Article> findArticleByUrl(String url) {
        ApiFuture<QuerySnapshot> future = db.getFirestore().collection("article").whereEqualTo("url", url).get();
        try {
            QuerySnapshot query = future.get();
            if (query.getDocuments() != null && query.getDocuments().size() > 0) {
                var documents = query.getDocuments();
                var document = documents.get(0);
                var article = document.toObject(Article.class);
                article.setContent(findContentByPath(article.getPath()));
                return Optional.of(article);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<String> findArticleTitleByUrl(String url) {
        ApiFuture<QuerySnapshot> future = db.getFirestore().collection("article").whereEqualTo("url", url).get();
        try {
            QuerySnapshot query = future.get();
            if (query.getDocuments() != null && query.getDocuments().size() > 0) {
                var documents = query.getDocuments();
                var document = documents.get(0);
                var article = document.toObject(Article.class);
                return Optional.of(article.getTitle());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<String> findContentByPath(String path) {
        ApiFuture<QuerySnapshot> future = db.getFirestore().collection("htmlContent").whereEqualTo("path", path).get();
        try {
            QuerySnapshot query = future.get();
            if (query.getDocuments() != null && query.getDocuments().size() > 0) {
                var documents = query.getDocuments();
                var document = documents.get(0);
                var content = document.toObject(ArticleContent.class);
                return Optional.of(content.getContent());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public SearchArticleResult findArticles(Optional<Integer> page, Optional<String> tag) {
        var result = new SearchArticleResult();

        int startIndex = page.isPresent() && page.get() > 0 ? (page.get()-1) * 8 : 0;

        var query = db.getFirestore().collection("article").whereEqualTo("published", true).orderBy("date", Query.Direction.DESCENDING);

        ApiFuture<QuerySnapshot> future = query.get();

        try {
            QuerySnapshot queryResult = future.get();
            if (queryResult.getDocuments() != null && queryResult.getDocuments().size() > 0) {
                var documents = queryResult.getDocuments();
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
            e.printStackTrace();
        }
        return result;
    }

    public List<Tag> findTags() {
        ApiFuture<QuerySnapshot> future = db.getFirestore().collection("article").whereEqualTo("published", true).get();
        QuerySnapshot queryResult = null;
        try {
            queryResult = future.get();
            if (queryResult.getDocuments() != null && queryResult.getDocuments().size() > 0) {
                return queryResult.getDocuments().stream()
                        .collect(Collectors.groupingBy(e -> e.get("tag").toString()))
                        .entrySet().stream()
                        .map(entry -> new Tag(entry.getKey(), entry.getValue().size()))
                        .filter(tag -> !tag.getTag().isEmpty())
                        .collect(Collectors.toList());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
