package io.wootlab.data;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
public class Endpoints {

    @Inject
    private FirestoreClient client;

    @Get("/article/{url}")
    public HttpResponse<String> initialize(String url) throws IOException, ExecutionException, InterruptedException {
        return client.getArticleContent()
                .map(content -> HttpResponse.ok(content))
                .orElse(HttpResponse.notFound());
    }
}
