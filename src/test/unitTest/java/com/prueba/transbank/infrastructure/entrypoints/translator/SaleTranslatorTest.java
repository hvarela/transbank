package com.prueba.transbank.infrastructure.entrypoints.translator;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.fixture.SaleFixture;
import com.prueba.transbank.fixture.SaleRequestFixture;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class SaleTranslatorTest {

   @Test
    public void shoudlTranslateSale2SaleResponse(){

       Sale sale = SaleFixture.create().build();

       SaleResponse saleResponse = SaleTranslator.translate(sale);

       assertEquals(sale.getAmount(), saleResponse.getAmount() );
       assertEquals(sale.getId(), saleResponse.getId() );
       assertEquals(sale.getName(), saleResponse.getName() );
       assertTrue( Double.compare(sale.getPrice(), saleResponse.getPrice() )== 0);
       assertEquals(sale.getProducId(), saleResponse.getProducId() );
   }

    @Test
    public void shoudlTranslateSale2SaleResponseWithId(){

        Sale sale = SaleFixture.create().build();

        SaleResponse saleResponse = SaleTranslator.translate(sale,9);

        String s = sale.toString();

        assertEquals(1,sale.getId());

    }

    @Test
    public void shoudlTranslateSaleRequest2Sale(){

        SaleRequest saleRequest = SaleRequestFixture.create().build();

        Sale sale = SaleTranslator.translate(saleRequest);

        assertEquals(sale.getAmount(), saleRequest.getAmount() );
        assertEquals(sale.getName(), saleRequest.getName() );
        assertTrue( Double.compare(sale.getPrice(), saleRequest.getPrice() )== 0);
        assertEquals(sale.getProducId(), saleRequest.getProducId() );
    }


}