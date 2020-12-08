package com.group7.prototype.model;
import java.text.DecimalFormat;

public class Cart {

    //
    private Integer index;
    private String name;
    private Double price;
    private Integer quantity;



    public Cart(Integer index, String name, Double price, Integer quantity) {
        this.index = index;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Cart() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String dPrice() {
        return new DecimalFormat("$#.###").format(this.price * this.quantity);
    }

}
