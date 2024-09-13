package com.coca2.producer;

import com.coca2.payload.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("sendRequest",message);
    }

    public void sendPersonJson(Person person){
        Message<Person> message =
                MessageBuilder.
                        withPayload(person)
                        .setHeader(KafkaHeaders.TOPIC, "sendRequest")
                        .build();
        kafkaTemplate.send(message);
    }
}
