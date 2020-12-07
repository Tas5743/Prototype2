package com.group7.prototype.model;

import java.text.DecimalFormat;

public class Item {

    //Instance data
    private Integer barcode;
    private String name;
    private Integer quantity;
    private Integer lQuantity;
    private Double price;
    private String iInfo;
    private String iDesc;
    private String imageRef;

    public Item(Integer barcode, String name, Integer quantity, Integer lQuantity, Double price) {
        this.barcode = barcode;
        this.name = name;
        this.quantity = quantity;
        this.lQuantity = lQuantity;
        this.price = price;
        this.iInfo = "";
        this.iDesc = "";
        this.imageRef = "";
    }

    public Item(Integer barcode, String name, Integer quantity, Integer lQuantity, Double price, String pInfo, String pDesc, String imageRef) {
        this.barcode = barcode;
        this.name = name;
        this.quantity = quantity;
        this.lQuantity = lQuantity;
        this.price = price;
        this.iInfo = pInfo;
        this.iDesc = pDesc;
        this.imageRef = imageRef;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getlQuantity() {
        return lQuantity;
    }

    public void setlQuantity(Integer lQuantity) {
        this.lQuantity = lQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String dPrice() {return new DecimalFormat("$#.###").format(this.price);
    }

    public String getiInfo() {
        return iInfo;
    }

    public void setiInfo(String iInfo) {
        this.iInfo = iInfo;
    }

    public String getiDesc() {
        return iDesc;
    }

    public void setiDesc(String iDesc) {
        this.iDesc = iDesc;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }
}
