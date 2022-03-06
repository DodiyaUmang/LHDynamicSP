package com.likeheart.lhdynamicsp;

public class DataModel {

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    boolean cb_like;
    boolean cb_heart;

    public boolean isCb_like() {
        return cb_like;
    }

    public void setCb_like(boolean cb_like) {
        this.cb_like = cb_like;
    }

    public boolean isCb_heart() {
        return cb_heart;
    }

    public void setCb_heart(boolean cb_heart) {
        this.cb_heart = cb_heart;
    }
}
