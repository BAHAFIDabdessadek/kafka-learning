package com.coca2.controller;

import com.coca2.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/")
public class SendRequestController {

    public final Producer producer;

    @PostMapping("sendRequest")
    public ResponseEntity<String> sendRequest(
            @RequestBody String message
    ){
        try {
            producer.sendMessage(message);
            return ResponseEntity.ok("Message sent Successfully");

        }catch (Exception e){
           return ResponseEntity.internalServerError().body("Something went wrong, message not sent.");
        }
    }
}
