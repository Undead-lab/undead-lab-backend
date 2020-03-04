package io.wootlab.data;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import io.wootlab.data.model.Article;
import io.wootlab.data.model.ArticleContent;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

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

    public List<Article> findArticlesByTag(String tag) {
        var result = new ArrayList<Article>();

        var query = db.getFirestore().collection("article").whereEqualTo("tag", tag);

        ApiFuture<QuerySnapshot> future = query.get();

        try {
            QuerySnapshot queryResult = future.get();
            if (queryResult.getDocuments() != null && queryResult.getDocuments().size() > 0) {
                for (QueryDocumentSnapshot queryDocument : queryResult.getDocuments()) {
                    var article = queryDocument.toObject(Article.class);
                    if (article.isPublished()) {
                        result.add(article);
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Article> findArticles() {
        var result = new ArrayList<Article>();

        var query = db.getFirestore().collection("article").whereEqualTo("published", true).limit(10);

        ApiFuture<QuerySnapshot> future = query.get();

        try {
            QuerySnapshot queryResult = future.get();
            if (queryResult.getDocuments() != null && queryResult.getDocuments().size() > 0) {
                for (QueryDocumentSnapshot queryDocument : queryResult.getDocuments()) {
                    result.add(queryDocument.toObject(Article.class));
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
