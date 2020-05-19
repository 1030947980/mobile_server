package com.ssm.pojo;

public class Replay {
    private int replay_id;
    private int user_id;
    private String comment_user;
    private int comment_id;
    private String comment_content;
    private int replayUser_id;
    private String replay_user;
    private String replay_content;
    private String replay_time;
    private int replay_state;

    public int getReplay_id() {
        return replay_id;
    }

    public void setReplay_id(int replay_id) {
        this.replay_id = replay_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_user() {
        return comment_user;
    }

    public void setComment_user(String comment_user) {
        this.comment_user = comment_user;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public int getReplayUser_id() {
        return replayUser_id;
    }

    public void setReplayUser_id(int replayUser_id) {
        this.replayUser_id = replayUser_id;
    }

    public String getReplay_user() {
        return replay_user;
    }

    public void setReplay_user(String replay_user) {
        this.replay_user = replay_user;
    }

    public String getReplay_content() {
        return replay_content;
    }

    public void setReplay_content(String replay_content) {
        this.replay_content = replay_content;
    }

    public String getReplay_time() {
        return replay_time;
    }

    public void setReplay_time(String replay_time) {
        this.replay_time = replay_time;
    }

    public int getReplay_state() {
        return replay_state;
    }

    public void setReplay_state(int replay_state) {
        this.replay_state = replay_state;
    }
}
