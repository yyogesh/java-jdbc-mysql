package com.product;

import java.util.Date;

public class Product {
    private int id;
    private String title;
    private Date registed_date;

    public Product(int id, String title, Date registed_date) {
        this.id = id;
        this.title = title;
        this.registed_date = registed_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRegisted_date() {
        return registed_date;
    }

    public void setRegisted_date(Date registed_date) {
        this.registed_date = registed_date;
    }

    public Product(String title, Date registed_date) {
        this.title = title;
        this.registed_date = registed_date;
    }

    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", registed_date=" + registed_date +
                '}';
    }
}
