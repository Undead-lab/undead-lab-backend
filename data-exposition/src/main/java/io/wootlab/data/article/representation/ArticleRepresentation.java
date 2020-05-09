package io.wootlab.data.article.representation;

import io.wootlab.data.article.model.Article;
import io.wootlab.data.article.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepresentation extends Article {
    private List<Comment> comments = new ArrayList<>();

    public ArticleRepresentation(Article article) {
        super(article.getTitle(), article.getDescription(), article.getUrl(), article.getTag(), article.getDate(), article.getAuthor(), article.isPublished(),
                article.getImages(), article.getPath(), article.getNext(), article.getPrevious(), article.getContent());
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
