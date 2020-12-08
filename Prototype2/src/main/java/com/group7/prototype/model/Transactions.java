package com.group7.prototype.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Transactions {


    @Id
    @GeneratedValue
    private Integer index;
    private String date;
    private Double total;
    @OneToMany(mappedBy = "transactions")
    private List<Sales> sales = new ArrayList<>();


    public Transactions(String date, Double total, List<Sales> sales) {
        this.date = date;
        this.total = total;
        this.sales = sales;
    }

    public Transactions() {

    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public Double getTotal() {
        return total;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public String dPrice() {
        return new DecimalFormat("$#.###").format(this.total) ;
    }
}
