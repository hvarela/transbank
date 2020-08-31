package com.prueba.transbank.fixture;


import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleRequest;

public class SaleRequestFixture extends AbstractFixture<SaleRequest> {

    private static final  String  DEFAULT_NAME= "Casa";
    private static final  int  DEFAULT_PRODUC_ID= 123;
    private static final  int  DEFAULT_AMOUNT= 1;
    private static final  double  DEFAULT_PRICE= 1.0;

    private String name;
    private int productId;
    private int amount;
    private double price;


    private SaleRequestFixture(String name, int productId, int amount, double price){
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.productId = productId;
    }

    public static SaleRequestFixture create(){
        return new SaleRequestFixture(DEFAULT_NAME, DEFAULT_PRODUC_ID, DEFAULT_AMOUNT, DEFAULT_PRICE);
    }

    public SaleRequestFixture withName(String name){
        this.name = name;
        return this;
    }

    public SaleRequestFixture withProductId(int productId){
        this.productId = productId;
        return this;
    }

    public SaleRequestFixture withPrice(double price){
        this.price = price;
        return this;
    }

    public SaleRequestFixture withAmount(int amount){
        this.amount = amount;
        return this;
    }

    public SaleRequest build() {
        return new SaleRequest(this.productId, this.name,  this.price, this.amount);
    }
}
