package com.ssm.pojo;

public class Bussiness {
    private String bussiness1;
    private String bussiness2;
    private int currentIndex;
    private int pageSize;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getBussiness1() {
        return bussiness1;
    }

    public void setBussiness1(String bussiness1) {
        this.bussiness1 = bussiness1;
    }

    public String getBussiness2() {
        return bussiness2;
    }

    public void setBussiness2(String bussiness2) {
        this.bussiness2 = bussiness2;
    }
}
