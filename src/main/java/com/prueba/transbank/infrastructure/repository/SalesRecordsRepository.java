package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.ventas.Sale;
import com.prueba.transbank.domain.usecase.port.SalesRecordsDataProvider;
import org.springframework.stereotype.Repository;

@Repository
public class SalesRecordsRepository implements SalesRecordsDataProvider {

    @Override
    public int saveSales(Sale sale) {
        return 0;
    }
}
