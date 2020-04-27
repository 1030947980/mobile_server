package com.ssm.pojo;


public class ChatMessage {
    private int chat_id;
    private int from_id;
    private int to_id;
    private String message;
    //头像都是发送者的 与用户表连接获取信息
    private long chat_time;
    private String user_name;
    private String user_avatar;

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getFrom_id() {
        return from_id;
    }

    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }

    public int getTo_id() {
        return to_id;
    }

    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getChat_time() {
        return chat_time;
    }

    public void setChat_time(long chat_time) {
        this.chat_time = chat_time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }
}
