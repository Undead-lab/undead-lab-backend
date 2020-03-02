package io.wootlab.data;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import io.wootlab.data.model.Article;

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

    public Optional<Article> findArticleByUrl(String url){
        ApiFuture<QuerySnapshot> future = db.getFirestore().collection("articles").whereEqualTo("url", url).get();
        try {
            QuerySnapshot query = future.get();
            if (query.getDocuments() != null && query.getDocuments().size() < 0) {
                var documents = query.getDocuments();
                var document = documents.get(0);
                return Optional.of(document.toObject(Article.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Article> findArticleByTag(String tag){
        var result = new ArrayList<Article>();
        ApiFuture<QuerySnapshot> future =  db.getFirestore().collection("articles").whereEqualTo("tag", tag).get();

        try {
            QuerySnapshot query = future.get();
            if (query.getDocuments() != null && query.getDocuments().size() < 0) {
                for (QueryDocumentSnapshot queryDocument: query.getDocuments()) {
                    result.add(queryDocument.toObject(Article.class));
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
