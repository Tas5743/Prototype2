package com.group7.prototype.model;

public class Item {

    //Instance data
    private Integer barcode;
    private String name;
    private Integer quantity;
    private Integer lQuantity;
    private Float price;

    public Item(Integer barcode, String name, Integer quantity, Integer lQuantity, Float price) {
        this.barcode = barcode;
        this.name = name;
        this.quantity = quantity;
        this.lQuantity = lQuantity;
        this.price = price;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
