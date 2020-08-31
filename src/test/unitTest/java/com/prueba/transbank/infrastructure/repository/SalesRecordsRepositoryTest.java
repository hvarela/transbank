package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.fixture.SaleFixture;
import com.prueba.transbank.infrastructure.entitys.SalesEntity;
import com.prueba.transbank.infrastructure.repository.RDBMS.SalesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SalesRecordsRepositoryTest {

    private SalesRecordsRepository salesRecordsRepository;

    @Mock
    private SalesRepository salesRepository;

    @Before
    public void init(){
        salesRecordsRepository = new SalesRecordsRepository(salesRepository);
    }

    @Test
    public void shouldSaveSaleSucess(){

        SalesEntity salesEntity = new SalesEntity(1,213,"roca",312.9,1);

        when( salesRepository.save(any(SalesEntity.class))).thenReturn(salesEntity);

        int id = salesRecordsRepository.saveSales(SaleFixture.create().withName("roca").withProductId(213).withAmount(3).withPrice(313).build());

        assertEquals( 1, id);

    }
}