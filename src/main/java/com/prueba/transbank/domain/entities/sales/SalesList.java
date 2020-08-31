package com.prueba.transbank.domain.entities.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesList {

    private List<Sale> sales;

    public SalesList(){
        sales = new ArrayList<Sale>();
    }

    public SalesList(List<Sale> sales){
        this.sales = new ArrayList<Sale>(sales);
    }

    public List<Sale> getSales(){
        return this.sales;
    }

    public void addSale(Sale sale){
        this.sales.add(sale);
    }

    public void  clearList(){
        this.sales.clear();
    }
}
