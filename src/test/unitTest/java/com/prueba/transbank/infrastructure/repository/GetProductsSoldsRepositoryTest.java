package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.fixture.SaleFixture;
import com.prueba.transbank.infrastructure.entrypoints.listener.SoldsProductsListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetProductsSoldsRepositoryTest {

    private GetProductsSoldsRepository getProductsSoldsRepository;

    @Mock
    private SoldsProductsListener soldsProductsListener;

    @Before
    public void init(){
        getProductsSoldsRepository = new GetProductsSoldsRepository(soldsProductsListener);
    }


    @Test
    public void shouldReturnEmpyList(){

        when( soldsProductsListener.getSaleList()).thenReturn( new ArrayList<>());

        List<Sale> response = getProductsSoldsRepository.getAllProductsSolds();

        assertTrue( response.isEmpty());

    }


    @Test
    public void shouldReturnListWithSaleProduct(){

        List<Sale> saleList =Arrays.asList(SaleFixture.create()
                .withName("casa")
                .withAmount(1)
                .withPrice(2.3)
                .withProductId(21323).build());

        when( soldsProductsListener.getSaleList()).thenReturn( saleList );

        List<Sale> response = getProductsSoldsRepository.getAllProductsSolds();

        assertTrue( response.size() == 1);

    }
}