package com.prueba.transbank.infrastructure.entrypoints.rest.request;

public class SaleRequest {


    private int producId;
    private String name;
    private double price;
    private int amount;

    public SaleRequest(){}

    public SaleRequest(int producId, String name, double price, int amount) {
        this.producId = producId;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getProducId() {
        return this.producId;
    }

    public void setProducId(int producId) {
        this.producId = producId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
