package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.sales.SalesList;
import com.prueba.transbank.domain.usecase.port.GetProductsSoldsDataProvider;

public class GetProductsSolds {

    private  GetProductsSoldsDataProvider getProductsSoldsDataProvider;

    public GetProductsSolds(GetProductsSoldsDataProvider getProductsSoldsDataProvider){

    }

    public SalesList getAllSales(){

        return null;
    }
}
