package io.wootlab.data;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.wootlab.data.model.Article;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class Endpoints {

    @Inject
    private ArticlesService articlesService;

    @Get("/articles/{url}")
    public HttpResponse<Article> getArticle(String url) throws IOException, ExecutionException, InterruptedException {
        return articlesService.findArticleByUrl(url)
                .map(content -> HttpResponse.ok(content))
                .orElse(HttpResponse.notFound());
    }

    @Get("/articles")
    public HttpResponse<List<Article>> findArticlesByTag(@Nullable @QueryValue(value = "tag") String tag) throws IOException, ExecutionException, InterruptedException {
        return
                HttpResponse.ok(
                        tag != null ?
                            articlesService.findArticlesByTag(tag) :
                                articlesService.findArticles()
                );
    }
}
