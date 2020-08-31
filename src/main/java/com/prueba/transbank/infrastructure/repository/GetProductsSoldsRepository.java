package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.port.GetProductsSoldsDataProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetProductsSoldsRepository implements GetProductsSoldsDataProvider {

    @Override
    public List<Sale> getAllProductsSolds() {
        return null;
    }
}
