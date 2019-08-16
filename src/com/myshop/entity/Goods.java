package com.myshop.entity;

public class Goods {
    private Integer g_id;
    private String g_name;//商品名
    private String introduce;//商品描述
    private double price;//价格
    private Integer number;//数量
    private Integer id_delete;//是否被删除
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId_delete() {
        return id_delete;
    }

    public void setId_delete(Integer id_delete) {
        this.id_delete = id_delete;
    }
}
