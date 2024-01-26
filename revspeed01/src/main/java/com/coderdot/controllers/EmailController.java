package com.coderdot.controllers;

import com.coderdot.dto.EmailRequest;
import com.coderdot.services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailSender emailSender;

    @PostMapping("/send")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> sendEmail(@RequestBody EmailRequest emailRequest){
        emailSender.sendEmail(emailRequest.getToEmail(), emailRequest.getSubject(), emailRequest.getBody());
        System.out.println("Email send success fully !");
        return ResponseEntity.ok().body("{\"message\": \"Email send success fully !\"}");
    }
}