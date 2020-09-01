package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SaleRequestTest {

    @Test
    public void validesConstructinSaleRequest(){
        SaleRequest saleRequest = new SaleRequest();

        saleRequest.setAmount(12);
        saleRequest.setName("tito");
        saleRequest.setPrice(4.4);
        saleRequest.setProducId(123);

        assertEquals( 123, saleRequest.getProducId() );
        assertEquals( "tito", saleRequest.getName());
        assertEquals( 12, saleRequest.getAmount());
        assertTrue( Double.compare( 4.4, saleRequest.getPrice()) == 0);

    }

}