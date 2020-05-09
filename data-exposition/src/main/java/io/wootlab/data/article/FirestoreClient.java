package io.wootlab.data.article;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class FirestoreClient {

    private Firestore firestore;

    public Firestore getFirestore() {
        return firestore;
    }

    @PostConstruct
    public void init() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(FirestoreClient.class.getResourceAsStream("/google-credentials.json"));
        firestore = new FirestoreOptions.DefaultFirestoreFactory()
                .create(
                        FirestoreOptions.newBuilder()
                                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                                .build());
    }
}
