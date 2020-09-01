package com.prueba.transbank.fixture;


import com.prueba.transbank.infrastructure.entitys.SalesEntity;

public class SalesEntityFixture extends AbstractFixture<SalesEntity> {

    private static final  int  DEFAULT_ID= 12;
    private static final  String  DEFAULT_NAME= "roca";
    private static final  int  DEFAULT_PRODUC_ID= 123;
    private static final  int  DEFAULT_AMOUNT= 1;
    private static final  double  DEFAULT_PRICE= 1.0;

    private int id;
    private String name;
    private int productId;
    private int amount;
    private double price;


    private SalesEntityFixture(int id, String name, int productId, int amount, double price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.productId = productId;
    }

    public static SalesEntityFixture create(){
        return new SalesEntityFixture(DEFAULT_ID, DEFAULT_NAME, DEFAULT_PRODUC_ID, DEFAULT_AMOUNT, DEFAULT_PRICE);
    }

    public SalesEntityFixture withId(int id){
        this.id = id;
        return this;
    }


    public SalesEntityFixture withName(String name){
        this.name = name;
        return this;
    }

    public SalesEntityFixture withProductId(int productId){
        this.productId = productId;
        return this;
    }

    public SalesEntityFixture withPrice(double price){
        this.price = price;
        return this;
    }

    public SalesEntityFixture withAmount(int amount){
        this.amount = amount;
        return this;
    }

    public SalesEntity build() {
        return new SalesEntity(this.id, this.productId, this.name,  this.price, this.amount);
    }
}
