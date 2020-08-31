package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.port.GetProductsSoldsDataProvider;

import java.util.List;

public class GetProductsSolds {

    private  GetProductsSoldsDataProvider getProductsSoldsDataProvider;

    public GetProductsSolds(GetProductsSoldsDataProvider getProductsSoldsDataProvider){
        this.getProductsSoldsDataProvider = getProductsSoldsDataProvider;
    }

    public List<Sale> getAllSales(){

        List<Sale> allSolds = getProductsSoldsDataProvider.getAllProductsSolds();

        return allSolds;
    }
}
