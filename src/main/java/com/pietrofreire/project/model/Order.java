package com.pietrofreire.project.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ticker;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Trader trader;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Trade trade;

    public Order(long id, int ticker, Trader trader, Trade trade) {
        this.id = id;
        this.ticker = ticker;
        this.trader = trader;
        this.trade = trade;
    }

    public Order() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTicker() {
        return ticker;
    }

    public void setTicker(int ticker) {
        this.ticker = ticker;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

}