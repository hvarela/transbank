package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.ventas.Sale;
import com.prueba.transbank.domain.usecase.port.SalesRecordsDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalesRecords {

    private Logger logger = LoggerFactory.getLogger(LoginUser.class);

    private SalesRecordsDataProvider salesRecordsDataProvider;

    public SalesRecords(SalesRecordsDataProvider salesRecordsDataProvide){
        this.salesRecordsDataProvider = salesRecordsDataProvide;
    }

    public int saleRecord(Sale sale){

        int id = salesRecordsDataProvider.saveSales(sale);
        logger.info( String.format("se guarda la venta con id [%d]  %s",id,sale.toString()));

        return id;
    }
}
