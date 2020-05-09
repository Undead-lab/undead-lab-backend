package io.wootlab.data.article;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.wootlab.data.article.model.Comment;
import io.wootlab.data.article.model.CommentDraft;
import io.wootlab.data.article.representation.SearchArticleResultRepresentation;
import io.wootlab.data.article.model.Tag;
import io.wootlab.data.article.representation.ArticleRepresentation;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleEndpoint {

    @Inject
    private ArticlesService articlesService;

    @Get("/articles/{url}")
    public HttpResponse<ArticleRepresentation> getArticle(String url) {
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
    public HttpResponse<SearchArticleResultRepresentation> findArticles(@Nullable @QueryValue(value = "tag") String tag, @Nullable @QueryValue(value = "page") Integer page) {
        return
                HttpResponse.ok(articlesService.findArticles(Optional.ofNullable(page), Optional.ofNullable(tag)));
    }


    @Get("/articles/{url}/comments")
    public HttpResponse<List<Comment>> getComments(String url){
        return HttpResponse.ok(articlesService.findCommentsByUrl(url));
    }

    @Put("/articles/{url}/comments")
    public HttpResponse postComment(String url,@Body CommentDraft commentDraft){
        if (articlesService.addComment(url, commentDraft)) {
         return HttpResponse.ok();
        }
        return HttpResponse.badRequest();
    }

    @Delete("/articles/comments/{commentId}")
    public HttpResponse deleteComment(String commentId){
        if (articlesService.deleteComment(commentId)) {
            return HttpResponse.ok();
        }
        return HttpResponse.badRequest();
    }

    @Get("/articles/tags")
    public HttpResponse<List<Tag>> findTags(){
        return HttpResponse.ok(articlesService.findTags());
    }
}
