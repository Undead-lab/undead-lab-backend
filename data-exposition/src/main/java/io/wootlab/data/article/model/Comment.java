package io.wootlab.data.article.model;

import java.util.Date;

public class Comment extends CommentDraft {
    private String id;
    private String authorId;
    private Date publishDate;
    private String articleUrl;
    private String authorName;
    private String avatar;

    public Comment() {
    }

    public Comment(CommentDraft draft) {
        this.value = draft.value;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
