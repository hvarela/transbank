package com.prueba.transbank.infrastructure.entrypoints.translator;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.infrastructure.entitys.SalesEntity;

public class SalesEntityTranslater {

    public static Sale translate(SalesEntity salesEntity){
        return new Sale(salesEntity.getId(), salesEntity.getProducId(), salesEntity.getName(), salesEntity.getPrice(),salesEntity.getAmount() );
    }
}
