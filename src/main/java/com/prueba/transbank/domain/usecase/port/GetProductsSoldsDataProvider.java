package com.prueba.transbank.domain.usecase.port;

import com.prueba.transbank.domain.entities.sales.Sale;

import java.util.List;

public interface GetProductsSoldsDataProvider {

    List<Sale> getAllProductsSolds();
}
