package com.prueba.transbank.infrastructure.entrypoints.translator;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.fixture.SalesEntityFixture;
import com.prueba.transbank.infrastructure.entitys.SalesEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SalesEntityTranslaterTest {

    @Test
    public void ShouldTranslateSalesEntity2Sale(){

        SalesEntity salesEntity = SalesEntityFixture.create().build();

        Sale sale = SalesEntityTranslater.translate(salesEntity);

        assertEquals(Integer.valueOf(sale.getAmount()), salesEntity.getAmount() );
        assertEquals(Integer.valueOf(sale.getId()), salesEntity.getId() );
        assertEquals(sale.getName(), salesEntity.getName() );
        assertTrue( Double.compare(sale.getPrice(), salesEntity.getPrice() )== 0);
        assertEquals(Integer.valueOf(sale.getProducId()), salesEntity.getProducId() );
    }

    @Test
    public void ShouldPrintSaleEntityWhenCallMethodToString(){

        SalesEntity salesEntity = SalesEntityFixture.create()
                .withAmount(6)
                .withName("test")
                .withPrice(34.2)
                .withProductId(213).build();

        String s = salesEntity.toString();

        assertTrue( s.contains("SalesEntity{"));
        assertTrue( s.contains("name='test'"));
        assertTrue( s.contains("amount=6"));
        assertTrue( s.contains("producId=213"));
        assertTrue( s.contains("price=34.2"));
        assertTrue( s.contains("}"));
    }
}