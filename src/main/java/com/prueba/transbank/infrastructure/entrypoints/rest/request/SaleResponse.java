package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import java.io.Serializable;

public class SaleResponse implements Serializable {

    private int id;
    private int producId;
    private String name;
    private double price;
    private int amount;

    public SaleResponse(int id, int producId, String name, double price, int amount) {
        this.id = id;
        this.producId = producId;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getId(){
        return this.id;
    }

    public int getProducId() {
        return this.producId;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

}
