package com.prueba.transbank.fixture;


import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.entities.sales.SalesList;

public class SalesListFixture extends AbstractFixture<SalesList> {


    private SalesList salesList;

    private SalesListFixture(){
        salesList = new SalesList();
    }

    public static SalesListFixture create(){
        return new SalesListFixture();
    }

    public SalesListFixture clearList(){
        this.salesList.clearList();
        return this;
    }

    public SalesListFixture addSale(Sale sale){
        this.salesList.addSale(sale);
        return this;
    }


    public SalesList build() {
        return new SalesList();
    }
}
