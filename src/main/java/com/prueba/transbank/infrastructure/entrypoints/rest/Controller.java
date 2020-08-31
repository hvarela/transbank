package com.prueba.transbank.infrastructure.entrypoints.rest;


import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.entities.sales.Sale;
import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.domain.usecase.SalesRecords;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginResponse;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleRequest;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.SaleResponse;
import com.prueba.transbank.infrastructure.entrypoints.rest.translator.SaleTranslator;
import com.prueba.transbank.infrastructure.entrypoints.rest.translator.UserRequestTranslator;
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

@RestController
@RequestMapping("/restaurant")
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    private LoginUser loginUser;
    private SalesRecords salesRecords;

    @Autowired
    public Controller(LoginUser loginUser, SalesRecords salesRecords) {
        this.loginUser = loginUser;
        this.salesRecords = salesRecords;
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
    public void getSales(){
        logger.info("obtiene  ventas del dia");
    }

}
