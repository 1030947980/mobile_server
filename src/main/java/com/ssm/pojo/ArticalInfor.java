package com.ssm.pojo;

public class ArticalInfor {
    private int artical_id;
    private int user_id;
    private String user_nickname;
    private String artical_title;
    private String artical_describe;
    private String artical_content;
    private String artical_imgUrl;
    private String artical_time;
    private int artical_collection;
    private int artical_views;
    private int artical_state;

    public int getArtical_views() {
        return artical_views;
    }

    public void setArtical_views(int artical_views) {
        this.artical_views = artical_views;
    }

    public String getArtical_describe() {
        return artical_describe;
    }

    public void setArtical_describe(String artical_describe) {
        this.artical_describe = artical_describe;
    }

    public int getArtical_id() {
        return artical_id;
    }

    public void setArtical_id(int artical_id) {
        this.artical_id = artical_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getArtical_title() {
        return artical_title;
    }

    public void setArtical_title(String artical_title) {
        this.artical_title = artical_title;
    }

    public String getArtical_content() {
        return artical_content;
    }

    public void setArtical_content(String artical_content) {
        this.artical_content = artical_content;
    }

    public String getArtical_imgUrl() {
        return artical_imgUrl;
    }

    public void setArtical_imgUrl(String artical_imgUrl) {
        this.artical_imgUrl = artical_imgUrl;
    }

    public String getArtical_time() {
        return artical_time;
    }

    public void setArtical_time(String artical_time) {
        this.artical_time = artical_time;
    }

    public int getArtical_collection() {
        return artical_collection;
    }

    public void setArtical_collection(int artical_collection) {
        this.artical_collection = artical_collection;
    }

    public int getArtical_state() {
        return artical_state;
    }

    public void setArtical_state(int artical_state) {
        this.artical_state = artical_state;
    }
}
