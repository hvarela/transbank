package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.port.GetProductsSoldsDataProvider;

import java.util.List;

public class GetProductsSoldsRepository implements GetProductsSoldsDataProvider {

    @Override
    public List<Sale> getAllProductsSolds() {
        return null;
    }
}
