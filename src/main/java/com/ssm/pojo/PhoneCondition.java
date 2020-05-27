package com.ssm.pojo;

public class PhoneCondition {
    private int pricelow;
    private int priceup;
    private double sizelow;
    private double sizeup;
    private String phonecpu;
    private String phonetype;
    private String phonenetwork;
    private String phoneappearance;
    private int currentIndex;
    private int pageSize;

    public int getPricelow() {
        return pricelow;
    }

    public void setPricelow(int pricelow) {
        this.pricelow = pricelow;
    }

    public int getPriceup() {
        return priceup;
    }

    public void setPriceup(int priceup) {
        this.priceup = priceup;
    }

    public double getSizelow() {
        return sizelow;
    }

    public void setSizelow(double sizelow) {
        this.sizelow = sizelow;
    }

    public double getSizeup() {
        return sizeup;
    }

    public void setSizeup(double sizeup) {
        this.sizeup = sizeup;
    }

    public String getPhonecpu() {
        return phonecpu;
    }

    public void setPhonecpu(String phonecpu) {
        this.phonecpu = phonecpu;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenetwork() {
        return phonenetwork;
    }

    public void setPhonenetwork(String phonenetwork) {
        this.phonenetwork = phonenetwork;
    }

    public String getPhoneappearance() {
        return phoneappearance;
    }

    public void setPhoneappearance(String phoneappearance) {
        this.phoneappearance = phoneappearance;
    }

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
}
