package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.port.SalesRecordsDataProvider;
import com.prueba.transbank.fixture.SaleFixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;



import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SalesListRecordsTest {

    private SalesRecords salesRecords;

    @Mock
    private SalesRecordsDataProvider salesRecordsDataProvider;

    @Before
    public void init(){
        salesRecords = new SalesRecords(salesRecordsDataProvider);
    }

    @Test
    public void shouldRecordSaleSuccessfully(){
        Sale sale = SaleFixture.create()
                .withName("papas")
                .withAmount(2)
                .withPrice(4.8)
                .withProductId(2313)
                .build();

        when( salesRecordsDataProvider.saveSales(any(Sale.class))).thenReturn(31);

        assertEquals( 31, salesRecords.saleRecord(sale));

    }


}