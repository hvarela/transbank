package com.prueba.transbank.infrastructure.entrypoints.translator;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleResponse;

public class SaleTranslator {
    public  static Sale translate(SaleRequest saleRequest){
        return  new Sale(saleRequest.getProducId(), saleRequest.getName(), saleRequest.getPrice(), saleRequest.getAmount());
    }

    public  static SaleResponse translate(Sale sale, int id){
        return  new SaleResponse(id, sale.getProducId(), sale.getName(), sale.getPrice(), sale.getAmount());

    }
}
