package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.sales.SalesList;
import com.prueba.transbank.domain.usecase.port.GetProductsSoldsDataProvider;
import com.prueba.transbank.fixture.SalesListFixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetProductsSoldsTest {

    private GetProductsSolds getProductsSolds;

    @Mock
    private GetProductsSoldsDataProvider getProductsSoldsDataProvider;

    @Before
    public void init(){
        getProductsSolds = new GetProductsSolds(getProductsSoldsDataProvider);

    }

    @Test
    public void SholdReturnEmptyList(){

        when(getProductsSoldsDataProvider.getAllProductsSolds()).thenReturn(SalesListFixture.create().build());

        SalesList allSales = getProductsSolds.getAllSales();

        assertTrue( allSales.getSales().isEmpty());

    }

}