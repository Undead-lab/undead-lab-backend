package io.wootlab.data;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Singleton
public class FirestoreClient {

    private Firestore firestore;

    @PostConstruct
    public void init() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(FirestoreClient.class.getResourceAsStream("/google-credentials.json"));
        firestore = new FirestoreOptions.DefaultFirestoreFactory()
                .create(
                        FirestoreOptions.newBuilder()
                                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                                .build());
    }

    public Optional<String> getArticleContent(){
        DocumentReference docRef = firestore.collection("htmlContent").document("articles-florian.md");
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = null;

        try {
            document = future.get();
            if (document.exists()) {
                 return Optional.of(document.toObject(ArticleContent.class).getContent());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

}
