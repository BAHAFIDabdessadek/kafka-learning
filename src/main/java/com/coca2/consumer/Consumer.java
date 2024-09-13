package com.coca2.consumer;

import com.coca2.payload.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {


    @KafkaListener(topics = "sendRequest",groupId = "group1")
    public void getMessage(String message){
        log.info(String.format("Our message is ::  { }"),message);
    }

   // @KafkaListener(topics = "sendRequest",groupId = "group1")
    public void getPersonJson(Person person){
        log.info(String.format("Our person got from Producer to our consumer :: His name :: {} " ,person.getName()));
    }


}
