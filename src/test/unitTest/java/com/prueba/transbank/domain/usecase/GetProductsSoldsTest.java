package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.port.GetProductsSoldsDataProvider;
import com.prueba.transbank.fixture.SaleFixture;
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

        when(getProductsSoldsDataProvider.getAllProductsSolds()).thenReturn( new ArrayList<Sale>());

        List<Sale> allSales = getProductsSolds.getAllSales();

        assertTrue( allSales.isEmpty());

    }


    @Test
    public void SholdReturnListWith2Sales(){

        List<Sale>  saleList =  Arrays.asList( SaleFixture.create()
                .withName("roca").build(),
                SaleFixture.create()
                        .withName("rosas").build() );
        when(getProductsSoldsDataProvider.getAllProductsSolds()).thenReturn( saleList);

        List<Sale> allSales = getProductsSolds.getAllSales();

        assertTrue( allSales.size() == 2);

    }

}