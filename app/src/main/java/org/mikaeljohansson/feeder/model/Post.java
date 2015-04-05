package org.mikaeljohansson.feeder.model;

public class Post {
    private String mUrl;
    private String mTitle;
    private boolean mRead;

    public boolean isRead() {
        return mRead;
    }

    public void setRead(boolean read) {
        mRead = read;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
