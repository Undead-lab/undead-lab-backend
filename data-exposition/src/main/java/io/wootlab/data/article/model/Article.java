package io.wootlab.data.article.model;

import java.util.Optional;

public class Article {
    private String title;
    private String description;
    private String url;
    private String tag;
    private String date;
    private String author;
    private boolean published;
    private Images images;
    private String path;
    private String next;
    private String previous;
    private String content;

    public Article() {
    }

    public Article(String title, String description, String url, String tag, String date, String author, boolean published, Images images, String path, String next, String previous, String content) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.tag = tag;
        this.date = date;
        this.author = author;
        this.published = published;
        this.images = images;
        this.path = path;
        this.next = next;
        this.previous = previous;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setContent(Optional<String> optionalContent){
        content = optionalContent.isPresent() ? optionalContent.get() : null;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getTag() {
        return tag;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public Images getImages() {
        return images;
    }

    public String getContent() {
        return content;
    }

    public boolean isPublished() {
        return published;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }
}
