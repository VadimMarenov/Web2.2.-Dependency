package ru.maren.model;

import com.google.gson.annotations.Expose;
public class Post {
    @Expose
    private long id;
    @Expose
    private String content;


    private boolean isRemoved;

    public Post() {
    }

    public Post(long id, String content, boolean isRemoved) {
        this.id = id;
        this.content = content;
        this.isRemoved = isRemoved;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
