package io.wootlab.data.model;

import java.util.ArrayList;
import java.util.List;

public class SearchArticleResult {
    private int totalPages;
    private List<Article> articles;

    public SearchArticleResult() {
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
