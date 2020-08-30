package com.prueba.transbank.infrastructure.entrypoints.rest;


import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.UserRequest;
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

    @Autowired
    Controller(LoginUser loginUser){
        this.loginUser = loginUser;
    }

    @RequestMapping(
            value= "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<String> loginUser(@RequestBody UserRequest userRequest){
        logger.info( String.format("login  request [%s] pass[%s]", userRequest.getName(), userRequest.getPassword()) );

        User user = UserRequestTranslator.translate(userRequest);

        loginUser.login(user);

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
