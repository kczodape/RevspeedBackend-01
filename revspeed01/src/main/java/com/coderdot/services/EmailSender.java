package com.coderdot.services;

import com.coderdot.dto.CustomerServiceLinkIndividualDTO;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.repository.CustomerServiceLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    CustomerServiceLinkRepository customerServiceLinkRepository;

    @Autowired
    CustomerRepository customerRepository;

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

    public void sendEmailforSignup(String toEmail, String subject, String body) {
        try {
            if (toEmail != null) {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom("revspeed.org@gmail.com");
                mailMessage.setTo(toEmail);
                System.out.println(mailMessage);
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
    public void sendEmailforSub(String toEmail, String subject, CustomerServiceLinkIndividualDTO ok) {
        try {
            if (toEmail != null) {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom("revspeed.org@gmail.com");
                mailMessage.setTo(toEmail);
                System.out.println(mailMessage);
                mailMessage.setText(ok.toString());
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

    @Scheduled(fixedRate = 600000000)
    // Schedule the task to run daily at 12 PM
    public void sendSubscriptionReminderEmails() {
        LocalDate twoDaysBefore = LocalDate.now();
        LocalDate twoBefore = LocalDate.now().minusDays(2);

//        List<CustomerServiceLink> expiringCustomers = customerServiceLinkRepository.findBySubscriptionEndDate(twoDaysBefore);
        List<String> emails = customerServiceLinkRepository.findBySubscriptionEndDate(twoDaysBefore);
        List<String> emailok = customerServiceLinkRepository.findBySubscriptionBeforeEndDate(twoBefore);
        System.out.println(emails);
        System.out.println(emailok);
        System.out.println(twoBefore);
        System.out.println("ok");

        for(String m : emails) {
            try {
                Long n = Long.parseLong(m);
                String email = customerRepository.findById(n)
                        .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + n))
                        .getEmail();
                sendEmail(email, "Subscription Expiry Reminder",
                        "Dear Customer, your subscription is ended. Please renew your subscription.");
            } catch (NumberFormatException e) {
                System.out.println("Error parsing customer ID: " + m);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        for(String m : emailok) {
            try {
                Long n = Long.parseLong(m);
                String emaill = customerRepository.findById(n)
                        .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + n))
                        .getEmail();
                sendEmail(emaill, "Subscription Expiry Reminder",
                        "Dear Customer, your subscription is ending in 2 days. Please renew your subscription.");
            } catch (NumberFormatException e) {
                System.out.println("Error parsing customer ID: " + m);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
