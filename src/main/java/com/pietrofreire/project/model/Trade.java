package com.pietrofreire.project.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timeStamp;
    private int quantity;
    private double price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Order order;

    public Trade(Long id, Timestamp timeStamp, int quantity, double price, Order order) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public Trade() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp  getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp  timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double total(){
        return this.price * this.quantity;
    }

}
