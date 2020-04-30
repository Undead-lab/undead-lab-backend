package io.wootlab.data;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.wootlab.data.model.Article;
import io.wootlab.data.model.SearchArticleResult;
import io.wootlab.data.model.Tag;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
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

    @Get("/articles/{url}/title")
    public HttpResponse<String> findArticles(String url) {
        return
                articlesService.findArticleTitleByUrl(url)
                        .map(content -> HttpResponse.ok(content))
                        .orElse(HttpResponse.notFound());
    }

    @Get("/articles")
    public HttpResponse<SearchArticleResult> findArticles(@Nullable @QueryValue(value = "tag") String tag, @Nullable @QueryValue(value = "page") Integer page) {
        return
                HttpResponse.ok(articlesService.findArticles(Optional.ofNullable(page), Optional.ofNullable(tag)));
    }

    @Get("/tags")
    public HttpResponse<List<Tag>> findTags(){
        return HttpResponse.ok(articlesService.findTags());
    }

    @Get("/ping")
    public HttpResponse<String> ping(){
        return HttpResponse.ok("ok");
    }
}
