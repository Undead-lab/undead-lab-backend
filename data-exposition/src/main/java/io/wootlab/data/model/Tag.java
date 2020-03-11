package io.wootlab.data.model;

public class Tag {
    private String tag;
    private int size;

    public Tag(String tag, int size) {
        this.tag = tag;
        this.size = size;
    }

    public String getTag() {
        return tag;
    }

    public int getSize() {
        return size;
    }
}
