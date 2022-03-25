package com.pietrofreire.project.model;

import javax.persistence.*;

@Entity
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Order order;

    public Trader(String code, String name, Order order) {
        this.code = code;
        this.name = name;
        this.order = order;
    }

    public Trader() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
