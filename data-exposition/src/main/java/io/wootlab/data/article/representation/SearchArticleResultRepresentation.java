package io.wootlab.data.article.representation;

import io.wootlab.data.article.model.Article;

import java.util.ArrayList;
import java.util.List;

public class SearchArticleResultRepresentation {
    private int totalPages;
    private List<Article> articles;

    public SearchArticleResultRepresentation() {
        articles = new ArrayList<>();
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
