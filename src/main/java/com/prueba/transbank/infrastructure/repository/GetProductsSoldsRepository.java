package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.port.GetProductsSoldsDataProvider;
import com.prueba.transbank.infrastructure.entrypoints.translator.SoldsProductsListener;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetProductsSoldsRepository implements GetProductsSoldsDataProvider {

    private SoldsProductsListener soldsProductsListener;

    public GetProductsSoldsRepository(SoldsProductsListener soldsProductsListener){
        this.soldsProductsListener = soldsProductsListener;
    }

    @Override
    public List<Sale> getAllProductsSolds() {

        List<Sale> saleList = soldsProductsListener.getSaleList();

        return saleList;
    }


}
