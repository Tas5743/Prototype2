package com.group7.prototype.model;

import java.util.Date;
import java.util.List;

public class Transactions {

    private Integer index;
    private List<Cart> order;
    private String date;
    private Double total;

    public Transactions(Integer index, List<Cart> order, String date, Double total) {
        this.index = index;
        this.order = order;
        this.date = date;
        this.total = total;
    }

    public Integer getIndex() {
        return index;
    }

    public List<Cart> getOrder() {
        return order;
    }

    public String getDate() {
        return date;
    }

    public Double getTotal() {
        return total;
    }
}
