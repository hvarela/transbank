package com.prueba.transbank.fixture;


import com.prueba.transbank.domain.entities.ventas.Sale;

public class SaleFixture extends AbstractFixture<Sale> {

    private static final  String  DEFAULT_NAME= "";
    private static final  int  DEFAULT_PRODUC_ID= 123;
    private static final  int  DEFAULT_AMOUNT= 1;
    private static final  double  DEFAULT_PRICE= 1.0;

    private String name;
    private int productId;
    private int amount;
    private double price;


    private SaleFixture(String name, int productId, int amount, double price){
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.productId = productId;
    }

    public static SaleFixture create(){
        return new SaleFixture(DEFAULT_NAME, DEFAULT_PRODUC_ID, DEFAULT_AMOUNT, DEFAULT_PRICE);
    }

    public SaleFixture withName(String name){
        this.name = name;
        return this;
    }

    public SaleFixture withProductId(int productId){
        this.productId = productId;
        return this;
    }

    public SaleFixture withPrice(double price){
        this.price = price;
        return this;
    }

    public SaleFixture withAmount(int amount){
        this.amount = amount;
        return this;
    }

    public Sale build() {
        return new Sale(this.productId, this.name,  this.price, this.amount);
    }
}
