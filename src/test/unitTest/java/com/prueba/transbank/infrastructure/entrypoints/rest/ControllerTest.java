package com.prueba.transbank.infrastructure.entrypoints.rest;

import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.GetProductsSolds;
import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.domain.usecase.SalesRecords;
import com.prueba.transbank.fixture.SaleFixture;
import com.prueba.transbank.fixture.SaleRequestFixture;
import com.prueba.transbank.fixture.UserRequestFixture;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginResponse;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    private static final String DEFAULT_NAME = "tito";
    private static final String DEFAULT_PASSWORD = "12345";

    @Mock
    LoginUser loginUser;

    @Mock
    SalesRecords salesRecords;

    @Mock
    GetProductsSolds getProductsSolds;

    private Controller controller;

    @Before
    public void init(){
        controller = new Controller(loginUser, salesRecords, getProductsSolds);
    }

    @Test
    public void testVerifyLoginSuccess() {

        String token="dasdakdmkmda";

        LoginRequest loginRequest = UserRequestFixture.create()
                .withName(DEFAULT_NAME)
                .withPassword(DEFAULT_PASSWORD)
                .build();


        when( loginUser.login(any(User.class) ) ).thenReturn(token);

        ResponseEntity<LoginResponse> responseEntity = controller.loginUser(loginRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(token, Objects.requireNonNull(responseEntity.getBody()).getToken());
    }

    @Test
    public void testSalesRecordSucesss(){

        SaleRequest saleRequest = SaleRequestFixture.create().build();

        when( salesRecords.saleRecord( any(Sale.class))).thenReturn( 2);

        ResponseEntity<SaleResponse> responseEntity = controller.addSales(saleRequest);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(saleRequest.getName(), responseEntity.getBody().getName());
        assertEquals(saleRequest.getAmount(), responseEntity.getBody().getAmount());
        assertTrue( Double.compare(saleRequest.getPrice(), responseEntity.getBody().getPrice()) ==0);
        assertEquals(saleRequest.getProducId(), responseEntity.getBody().getProducId());
        assertEquals(2,responseEntity.getBody().getId());
    }


    @Test
    public void sholdReturnEmpyListWhenCallGetProductSolds(){
        when( getProductsSolds.getAllSales()).thenReturn( new ArrayList<Sale>());

        ResponseEntity<List<Sale>> responseEntity = controller.getSales();


        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
       assertTrue(responseEntity.getBody().isEmpty() );
    }

    @Test
    public void sholdReturnListwithElementsWhenCallGetProductSolds(){

        List<Sale> saleList =Arrays.asList(SaleFixture.create().withName("casa").build(), SaleFixture.create().withName("papas").build());

        when( getProductsSolds.getAllSales()).thenReturn(saleList);

        ResponseEntity<List<Sale>> responseEntity = controller.getSales();


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2,responseEntity.getBody().size() );
    }
}