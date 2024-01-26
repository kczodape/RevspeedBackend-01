package com.coderdot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        try {
            if (toEmail != null) {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom("revspeed.org@gmail.com");
                mailMessage.setTo(toEmail);
                mailMessage.setText(body);
                mailMessage.setSubject(subject);

                javaMailSender.send(mailMessage);
                System.out.println("Mail sent successfully!");
            } else {
                System.out.println("Error: To email address is null.");
            }
        } catch (Exception e) {
            System.out.println("Error while sending email: " + e.getMessage());
        }
    }
}
