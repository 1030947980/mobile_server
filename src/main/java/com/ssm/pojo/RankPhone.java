package com.ssm.pojo;

public class RankPhone {
    private int phone_id;
    private int rank_sequence;
    private String phone_model;
    private String rank_score;
    private String phone_price;
    private String phone_market;

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public int getRank_sequence() {
        return rank_sequence;
    }

    public void setRank_sequence(int rank_sequence) {
        this.rank_sequence = rank_sequence;
    }

    public String getPhone_model() {
        return phone_model;
    }

    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model;
    }

    public String getRank_score() {
        return rank_score;
    }

    public void setRank_score(String rank_score) {
        this.rank_score = rank_score;
    }

    public String getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(String phone_price) {
        this.phone_price = phone_price;
    }

    public String getPhone_market() {
        return phone_market;
    }

    public void setPhone_market(String phone_market) {
        this.phone_market = phone_market;
    }
}
