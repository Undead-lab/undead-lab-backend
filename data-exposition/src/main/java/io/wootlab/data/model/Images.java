package io.wootlab.data.model;

public class Images {
    private String miniatureUrl;
    private String highResolutionUrl;
    private String credits;

    public void setMiniatureUrl(String miniatureUrl) {
        this.miniatureUrl = miniatureUrl;
    }

    public void setHighResolutionUrl(String highResolutionUrl) {
        this.highResolutionUrl = highResolutionUrl;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getMiniatureUrl() {
        return miniatureUrl;
    }

    public String getHighResolutionUrl() {
        return highResolutionUrl;
    }

    public String getCredits() {
        return credits;
    }
}
