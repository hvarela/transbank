package com.prueba.transbank.infrastructure.entrypoints.listener;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.infrastructure.entitys.SalesEntity;
import com.prueba.transbank.infrastructure.entrypoints.translator.SalesEntityTranslater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SoldsProductsListener {

    private Logger logger = LoggerFactory.getLogger(SoldsProductsListener.class);

    private List<Sale> saleList;

    public SoldsProductsListener(){
        saleList = Collections.synchronizedList(new ArrayList<Sale>());
    }

    @JmsListener(destination = "salesChannels", containerFactory = "myFactory")
    private void getSale(SalesEntity salesEntity) {

        Sale sale = SalesEntityTranslater.translate(salesEntity);
        logger.debug(" listener recibe  ", sale.toString());
        saleList.add(sale);
    }

    public List<Sale> getSaleList(){
       List<Sale >  sales =  saleList.stream()
               .collect( Collectors.toList());
       return sales;
    }


}
