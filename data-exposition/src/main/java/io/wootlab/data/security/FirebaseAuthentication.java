package io.wootlab.data.security;

import com.google.firebase.auth.FirebaseToken;
import io.micronaut.security.authentication.Authentication;

import java.util.Collections;
import java.util.Map;

public class FirebaseAuthentication implements Authentication {
    private FirebaseToken firebaseToken;

    public FirebaseAuthentication(FirebaseToken firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    @Override
    public Map<String, Object> getAttributes() {
        var toREturn = Collections.unmodifiableMap(firebaseToken.getClaims());
        return toREturn;
    }

    @Override
    public String getName() {
        return firebaseToken.getUid();
    }
}
