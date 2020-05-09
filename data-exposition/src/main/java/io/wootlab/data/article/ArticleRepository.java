package io.wootlab.data.article;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import io.wootlab.data.article.model.Article;
import io.wootlab.data.article.model.ArticleContent;
import io.wootlab.data.article.model.Comment;
import io.wootlab.data.article.model.Tag;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Singleton
public class ArticleRepository {
    @Inject
    FirestoreClient db;

    public Optional<Article> findArticleByUrl(String url) {
        ApiFuture<QuerySnapshot> future = db.getFirestore().collection("article").whereEqualTo("url", url).get();
        try {
            QuerySnapshot query = future.get();
            if (query.getDocuments() != null && query.getDocuments().size() > 0) {
                var documents = query.getDocuments();
                var document = documents.get(0);
                if(document.get("published").equals(true)) {
                    return Optional.of(document.toObject(Article.class));
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<String> findContentByPath(String path) {
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

    public List<QueryDocumentSnapshot> search() {
        var query = db.getFirestore().collection("article").whereEqualTo("published", true).orderBy("date", Query.Direction.DESCENDING);
        ApiFuture<QuerySnapshot> future = query.get();

        QuerySnapshot queryResult = null;
        try {
            queryResult = future.get();
        } catch (InterruptedException | ExecutionException e) {
            return Collections.emptyList();
        }
        if (queryResult.getDocuments() != null && queryResult.getDocuments().size() > 0) {
            return queryResult.getDocuments();
        }

        return Collections.emptyList();
    }

    public void registerComment(Comment comment) {
        try {
            db.getFirestore().collection("comments").add(comment).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public List<QueryDocumentSnapshot> findCommentsByUrl(String url) {
        var future =
                db.getFirestore().collection("comments").whereEqualTo("articleUrl", url).orderBy("publishDate", Query.Direction.DESCENDING).get();

        QuerySnapshot queryResult = null;
        try {
            queryResult = future.get();
            if (queryResult.getDocuments() != null && queryResult.getDocuments().size() > 0) {
                return queryResult.getDocuments();
            }
        }catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Optional<DocumentSnapshot> findCommentById(String commentId) {
        var future =
                db.getFirestore().collection("comments").document(commentId).get();

        DocumentSnapshot queryResult = null;
        try {
            queryResult = future.get();
            if (queryResult!= null) {
                return Optional.of(queryResult);
            }
        }catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void deleteComment(String commentId) throws ExecutionException, InterruptedException {
        db.getFirestore().collection("comments").document(commentId).delete().get();
    }
}
