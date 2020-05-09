package io.wootlab.data.security;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.token.validator.TokenValidator;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.IOException;

@Singleton
public class FirebaseTokenValidator implements TokenValidator {

    private FirebaseApp app = FirebaseApp.initializeApp(
            new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(
                            FirebaseTokenValidator.class.getResourceAsStream("/firebase-service-account.json")))
                    .setDatabaseUrl("https://wootlab-io-production.firebaseio.com")
                    .build()
    );

    public FirebaseTokenValidator() throws IOException {
    }

    @Override
    public Publisher<Authentication> validateToken(String token) {
        try {
            FirebaseToken firebaseToken = FirebaseAuth.getInstance(app).verifyIdToken(token);
            return Flowable.just(new FirebaseAuthentication(firebaseToken));
        } catch (FirebaseAuthException ex) {
            return Flowable.empty();
        }
    }
}