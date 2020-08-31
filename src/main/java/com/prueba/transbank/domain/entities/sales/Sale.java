package com.prueba.transbank.domain.entities.sales;

import com.prueba.transbank.domain.entities.error.SaleDataErrorException;

public class Sale {

    private int producId;
    private String name;
    private double price;
    private int amount;


    public Sale(int producId, String name, double price, int amount) {
        this.producId = producId;
        this.name = name;
        this.price = price;
        this.amount = amount;

        validate();

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

    private void validate(){

        if( this.producId <= 0){
            throw  new SaleDataErrorException(": product id must be greater than 0");
        }

        if( this.name == null || this.name.isEmpty() ){
            throw  new SaleDataErrorException(": name is null or empty");
        }

        if( this.amount <= 0){
            throw  new SaleDataErrorException(": amount must be greater than 0");
        }

        if( this.price <= 0){
            throw  new SaleDataErrorException(": price must be greater than 0");
        }

    }

    @Override
    public String toString() {
        return "Sale{" +
                "producId=" + producId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
