package com.smarts.SmartS.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String emertimi;
    private float price;
    @ManyToOne
    @JoinColumn(name = "idcateg_id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmertimi() {
        return emertimi;
    }

    public void setEmertimi(String emertimi) {
        this.emertimi = emertimi;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
