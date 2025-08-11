package com.zxk.entity;

import lombok.Data;

@Data
public class Car {
    private String cheNum;
    private String xinXi;
    private boolean isZl;
    private Integer price;
    private String pictureUrl;

    public String getCheNum() {
        return cheNum;
    }

    public void setCheNum(String cheNum) {
        this.cheNum = cheNum;
    }

    public String getXinXi() {
        return xinXi;
    }

    public void setXinXi(String xinXi) {
        this.xinXi = xinXi;
    }

    public boolean isZl() {
        return isZl;
    }

    public void setZl(boolean zl) {
        isZl = zl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

}
