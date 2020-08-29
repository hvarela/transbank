package com.prueba.transbank.infrastructure.entrypoints.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);


    @RequestMapping(
            value= "/login",
            method = RequestMethod.POST
    )
    void loginUser(){
        logger.info("login");
    }

    @RequestMapping(
            value= "/sales",
            method = RequestMethod.POST
    )
    void addSales(){
        logger.info("agrega venta");
    }


    @RequestMapping(
            value= "/sales",
            method = RequestMethod.GET
    )
    void getSales(){
        logger.info("obtiene  ventas del dia");
    }

}
