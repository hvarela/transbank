package com.prueba.transbank.domain.usecase.port;

import com.prueba.transbank.domain.entities.sales.Sale;

public interface SalesRecordsDataProvider {

    int saveSales(Sale sale);
}
