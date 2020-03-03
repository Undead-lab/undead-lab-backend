package io.wootlab.data.model;

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
    private String content;

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
}
