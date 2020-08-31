package com.prueba.transbank.infrastructure.entrypoints.rest;


import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.GetProductsSolds;
import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.domain.usecase.SalesRecords;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginResponse;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleResponse;
import com.prueba.transbank.infrastructure.entrypoints.translator.SaleTranslator;
import com.prueba.transbank.infrastructure.entrypoints.translator.UserRequestTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    private LoginUser loginUser;
    private SalesRecords salesRecords;
    private GetProductsSolds getProductsSolds;


    @Autowired
    public Controller(LoginUser loginUser, SalesRecords salesRecords, GetProductsSolds getProductsSolds) {
        this.loginUser = loginUser;
        this.salesRecords = salesRecords;
        this.getProductsSolds = getProductsSolds;
    }

    @RequestMapping(
            value= "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
        logger.info( String.format("login  request [%s] pass[%s]", loginRequest.getName(), loginRequest.getPassword()) );

        User user = UserRequestTranslator.translate(loginRequest);

        String token = loginUser.login(user);

        return  new ResponseEntity<LoginResponse>(new LoginResponse(token), HttpStatus.OK);

    }

    @RequestMapping(
            value= "/sales",
            method = RequestMethod.POST
    )
    public  ResponseEntity<SaleResponse> addSales(@RequestBody SaleRequest saleRequest){

        Sale sale = SaleTranslator.translate(saleRequest);

        int id = salesRecords.saleRecord(sale);

        logger.info("agrega venta");

        return  new ResponseEntity<SaleResponse>(SaleTranslator.translate(sale, id) , HttpStatus.OK);
    }


    @RequestMapping(
            value= "/sales",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Sale>> getSales(){

        logger.info("obtiene  ventas del dia");

        List<Sale> allSales = getProductsSolds.getAllSales();

        logger.info( String.format("cantidad ventas [%d]", allSales.size()));

        if( allSales.isEmpty()){
            return new ResponseEntity<List<Sale>>(allSales, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<List<Sale>>(allSales, HttpStatus.OK);
        }
    }

}
