package io.wootlab.data.article;

import com.google.api.client.util.ArrayMap;
import io.micronaut.security.utils.DefaultSecurityService;
import io.wootlab.data.article.model.*;
import io.wootlab.data.article.model.CommentDraft;
import io.wootlab.data.article.representation.ArticleRepresentation;
import io.wootlab.data.article.representation.SearchArticleResultRepresentation;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Singleton
public class ArticlesService {

    @Inject
    ArticleRepository repository;

    @Inject
    DefaultSecurityService securityService;

    public Optional<ArticleRepresentation> findArticleByUrl(String url) {
       return repository.findArticleByUrl(url)
                .map(article -> {
                    ArticleRepresentation representation = new ArticleRepresentation(article);
                    representation.setContent(repository.findContentByPath(article.getPath()));
                    representation.setComments(findCommentsByUrl(url));
                    return Optional.of(representation);
                })
                .orElse(Optional.empty());
    }

    public Optional<String> findArticleTitleByUrl(String url) {
       return repository.findArticleTitleByUrl(url);
    }

    public SearchArticleResultRepresentation findArticles(Optional<Integer> page, Optional<String> tag) {
        var result = new SearchArticleResultRepresentation();
        int startIndex = page.isPresent() && page.get() > 0 ? (page.get()-1) * 8 : 0;

        var documents = repository.search();
        if(documents.size() > 0) {
            if(tag.isPresent()){
                documents = documents.stream().filter(doc -> doc.get("tag").equals(tag.get())).collect(Collectors.toList());
            }
            result.setTotalPages((documents.size() / 8) + ((documents.size() % 8) > 0 ? 1 : 0));
            final int documentsSize = documents.size();
            var validIndexes = IntStream.range(startIndex, startIndex + 8).filter(index -> index < documentsSize).boxed().collect(Collectors.toList());

            for(int index : validIndexes){
                result.getArticles().add(documents.get(index).toObject(Article.class));
            }
        }else{
            result.setTotalPages(0);
        }
        return result;
    }

    public List<Tag> findTags() {
       return repository.findTags();
    }

    public boolean addComment(String url, CommentDraft commentDraft) {
        var auth = securityService.getAuthentication();
        if (commentDraft.getValue().length() >= 10 && auth != null) {
            var article = findArticleByUrl(url);
            if (article.isPresent()) {
                var attr = auth.get().getAttributes();
                ArrayMap am = (ArrayMap) attr.get("firebase");
                ArrayMap identities = (ArrayMap) am.get("identities");
                var id = (ArrayList)identities.get("github.com");

                var displayName = attr.get("name").toString();
                Comment comment = new Comment(commentDraft);
                comment.setArticleUrl(url);
                comment.setAuthorId(id.get(0).toString());
                comment.setPublishDate(new Date());
                comment.setAuthorName(displayName);
                repository.registerComment(comment);
                return true;
            }
        }
        return false;
    }

    public List<Comment> findCommentsByUrl(String url) {
        return repository.findCommentsByUrl(url).stream().map(
                document -> {
                    var article = document.toObject(Comment.class);
                    article.setId(document.getId());
                    return article;
                }
        ).collect(Collectors.toList());
    }

    public boolean deleteComment(String commentId) {
        var auth = securityService.getAuthentication();
        if (auth != null) {
            var attr = auth.get().getAttributes();
            ArrayMap am = (ArrayMap) attr.get("firebase");
            ArrayMap identities = (ArrayMap) am.get("identities");
            var id = ((ArrayList)identities.get("github.com")).get(0).toString();
            var commentToDelete = repository.findCommentById(commentId);
            if (commentToDelete.isPresent() && id.equals(commentToDelete.get().get("authorId"))) {
                try {
                    repository.deleteComment(commentId);
                    return true;
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
