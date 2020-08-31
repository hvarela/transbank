package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SaleResponse implements Serializable {

    @ApiModelProperty(dataType = "int",value = "Id en BD", example = "1321",  readOnly =true, required=true)
    private int id;
    @ApiModelProperty(dataType = "int", value = "Id del producto", example = "1321", readOnly =true,  required=true)
    private int producId;
    @ApiModelProperty(value = "nombre del producto", example = "jose", readOnly =true, required=true)
    private String name;
    @ApiModelProperty(dataType = "double", value = "precio del producto", example = "23.4", readOnly =true, required=true)
    private double price;
    @ApiModelProperty(dataType = "int", value = "cantiad del producto vendidos", example = "2", readOnly =true, required=true)
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
