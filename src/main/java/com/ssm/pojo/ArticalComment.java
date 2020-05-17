package com.ssm.pojo;

public class ArticalComment {
    private int comment_id;
    private int artical_id;
    private String artical_title;
    private int user_id;
    private String user_nickname;
    private String comment_content;
    private String comment_time;
    private int comment_state;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getArtical_id() {
        return artical_id;
    }

    public void setArtical_id(int artical_id) {
        this.artical_id = artical_id;
    }

    public String getArtical_title() {
        return artical_title;
    }

    public void setArtical_title(String artical_title) {
        this.artical_title = artical_title;
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

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public int getComment_state() {
        return comment_state;
    }

    public void setComment_state(int comment_state) {
        this.comment_state = comment_state;
    }
}
