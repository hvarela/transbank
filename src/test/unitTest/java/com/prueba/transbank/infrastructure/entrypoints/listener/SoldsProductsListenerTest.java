package com.prueba.transbank.infrastructure.entrypoints.listener;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.fixture.SalesEntityFixture;
import com.prueba.transbank.infrastructure.configuration.JmsConfiguration;
import com.prueba.transbank.infrastructure.entitys.SalesEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SoldsProductsListenerTest {

    private SoldsProductsListener soldsProductsListener;


    @Before
    public void init(){
        soldsProductsListener = new SoldsProductsListener();

    }

    @Test
    public  void shoulRetunEmpyList(){

        List<Sale> saleList = soldsProductsListener.getSaleList();

        assertTrue( saleList.isEmpty());

    }

    @Test
    public  void shoulRetunListWithSale(){

        soldsProductsListener.getSale( SalesEntityFixture.create().build());
        List<Sale> saleList = soldsProductsListener.getSaleList();

        assertTrue( saleList.size() == 1);

    }



}