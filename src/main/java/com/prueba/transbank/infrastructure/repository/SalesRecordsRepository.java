package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.port.SalesRecordsDataProvider;
import com.prueba.transbank.infrastructure.entitys.SalesEntity;
import com.prueba.transbank.infrastructure.repository.RDBMS.SalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SalesRecordsRepository implements SalesRecordsDataProvider {

    Logger logger = LoggerFactory.getLogger(SalesRecordsRepository.class);

    private SalesRepository salesRepository;


    public SalesRecordsRepository(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    @Override
    public int saveSales(Sale sale) {

        SalesEntity salesEntity = new SalesEntity(sale.getProducId(), sale.getName(),sale.getPrice(),sale.getAmount());

        salesEntity =  salesRepository.save(salesEntity);

        logger.debug("guarda venta ",salesEntity.toString());

        return salesEntity.getId();

    }
}
