package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SaleRequest implements Serializable {


    @ApiModelProperty(dataType = "int", value = "Id del producto", example = "1321. nota: debe ser mayor 0",  allowEmptyValue = false, required=true)
    private int producId;
    @ApiModelProperty(value = "nombre del producto", example = "jose",  allowEmptyValue = false, required=true)
    private String name;
    @ApiModelProperty(dataType = "double", value = "precio del producto", example = "2311.  nota: debe ser mayor 0",  allowEmptyValue = false, required=true)
    private double price;
    @ApiModelProperty(dataType = "int", value = "cantiad del producto vendidos", example = "2. nota: debe ser mayor 0",  allowEmptyValue = false, required=true)
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
