package com.prueba.transbank.infrastructure.entrypoints.rest;



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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

import java.util.ArrayList;
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
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    @ApiOperation(value = "login de usuario. retorna un token para ser usado como autorization Bearer",
            response = LoginResponse.class, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = LoginResponse.class),
            @ApiResponse(code = 400, message = "Invalid params"),
            @ApiResponse(code = 401, message = "usuario no autorizado"),
            @ApiResponse(code = 500, message = "Service Error"),
    })
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
        logger.info( String.format("login  request [%s] pass[%s]", loginRequest.getName(), loginRequest.getPassword()) );

        User user = UserRequestTranslator.translate(loginRequest);

        String token = loginUser.login(user);

        return  new ResponseEntity<LoginResponse>(new LoginResponse(token), HttpStatus.OK);

    }

    @RequestMapping(
            value= "/sales",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    @ApiImplicitParam(name = "Authorization", value = "Bearer Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer {{token}}")
    @ApiOperation(value = "agrega una venta , retornando el producto almacenado en BD",
             produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Producto ingresado", response = SaleResponse.class),
            @ApiResponse(code = 400, message = "Invalid paramater"),
            @ApiResponse(code = 401, message = "usuario no autorizado"),
            @ApiResponse(code = 500, message = "Service Error"),
    })
    public  ResponseEntity<SaleResponse> addSales(@RequestBody SaleRequest saleRequest){
         int id = salesRecords.saleRecord(SaleTranslator.translate(saleRequest));

        logger.info("agrega venta");


        return  new ResponseEntity<SaleResponse>(SaleTranslator.translate( SaleTranslator.translate(saleRequest), id) , HttpStatus.CREATED);
    }


    @RequestMapping(
            value= "/sales",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ApiImplicitParam(name = "Authorization", value = "Bearer Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer {{token}}")
    @ApiOperation(value = "Retorna una lista de productos vendidos ",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "retorna lista de productos vendidos",  response = SaleResponse.class, responseContainer="List"),
            @ApiResponse(code = 401, message = "usuario no autorizado"),
            @ApiResponse(code = 500, message = "Service Error"),
    })
    public ResponseEntity<List<SaleResponse>> getSales(){

        logger.info("obtiene  ventas del dia");

        List<SaleResponse> allSales= new ArrayList<>();

        getProductsSolds.getAllSales().stream().forEach((sale) ->{
            allSales.add(  SaleTranslator.translate(sale));
        });



        logger.info( String.format("cantidad ventas [%d]", allSales.size()));

        return new ResponseEntity<List<SaleResponse>>(allSales, HttpStatus.OK);

    }



}
