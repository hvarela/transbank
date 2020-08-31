package com.prueba.transbank.infrastructure.schedulingtasks;

import com.prueba.transbank.infrastructure.entitys.SalesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class FillJmsWithSales {


    private final Logger log = LoggerFactory.getLogger(FillJmsWithSales.class);

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private JmsTemplate jmsTemplate;

    private int cant;

    private Random random;

    public FillJmsWithSales(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
        this.random = new Random();
        this.cant = 0;
    }


    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        if( this.cant++ > 20)
            return;
        log.info("The time is now {}", dateFormat.format(new Date()));
        jmsTemplate.convertAndSend("salesChannels", new SalesEntity(random.nextInt(100)+1, random.nextInt(1000)+1,"casa", random.nextDouble()+1 ,random.nextInt(10) +1 ));
    }

}
