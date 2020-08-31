package com.prueba.transbank.domain.entities.ventas;

import com.prueba.transbank.domain.entities.error.SaleDataErrorException;
import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.fixture.SaleFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SaleTest {

    private Sale sale;

    @Test
    public void shouldThrowExeption4Price(){

        Exception exception = assertThrows(SaleDataErrorException.class, () -> {
            sale = SaleFixture.create()
                    .withAmount(21)
                    .withName("rosas")
                    .withProductId(323)
                    .withPrice(0).build();
        });

        String expectedMessage = "invalid sale data: price must be greater than 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void shouldThrowExeption4Name(){

        Exception exception = assertThrows(SaleDataErrorException.class, () -> {
            sale = SaleFixture.create()
                    .withAmount(21)
                    .withName("")
                    .withProductId(323)
                    .withPrice(31).build();
        });

        String expectedMessage = "invalid sale data: name is null or empty";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void shouldThrowExeption4ProductId(){

        Exception exception = assertThrows(SaleDataErrorException.class, () -> {
            sale = SaleFixture.create()
                    .withAmount(21)
                    .withName("rosas")
                    .withProductId(-34)
                    .withPrice(31).build();
        });

        String expectedMessage = "invalid sale data: product id must be greater than 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test( expected =  SaleDataErrorException.class)
    public void shouldCreateSaleSuccess() {


        sale = SaleFixture.create()
                .withAmount(21)
                .withName("rosas")
                .withProductId(34)
                .withPrice(31).build();

        assertEquals("rosa", sale.getName());
        assertEquals(21, sale.getAmount());
        assertEquals(34, sale.getProducId());
        assertTrue(Double.compare(31, sale.getPrice())==0);

    }

    @Test
    public void shouldThrowExeption4Amount(){

        Exception exception = assertThrows(SaleDataErrorException.class, () -> {
            sale = SaleFixture.create()
                    .withAmount(0)
                    .withName("rosas")
                    .withProductId(34)
                    .withPrice(31).build();
        });

        String expectedMessage = "invalid sale data: amount must be greater than 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }


    @Test
    public void shouldPrintSaleWithCallMethodToString(){

       sale = SaleFixture.create()
                    .withAmount(9)
                    .withName("rosas")
                    .withProductId(34)
                    .withPrice(31).build();

        String s = sale.toString();

        assertTrue( s.contains("name='rosas'"));
    }

}