package com.prueba.transbank.infrastructure.entrypoints.rest;


import com.prueba.transbank.domain.entities.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    @RequestMapping(
            value= "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<String> loginUser(@RequestBody User user){
        logger.info( String.format("login  user [%s] pass[%s]", user.getName(), user.getPassword()) );
        user.validate();

        return  new ResponseEntity<>("", HttpStatus.NO_CONTENT);
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
