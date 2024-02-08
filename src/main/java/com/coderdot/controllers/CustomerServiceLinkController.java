package com.coderdot.controllers;

import com.coderdot.dto.*;
import com.coderdot.entities.BroadbandPlans;
import com.coderdot.entities.Customer;
import com.coderdot.entities.Individual;
import com.coderdot.repository.BroadbandPlansRepository;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.repository.IndividualRepository;
import com.coderdot.services.CustomerServiceLinkService;
import com.coderdot.services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerServiceLinkController {
    private final CustomerServiceLinkService customerServiceLinkService;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    IndividualRepository individualRepository;

    @Autowired
    BroadbandPlansRepository broadbandPlansRepository;
    @Autowired
    EmailSender emailSender;

    @Autowired
    public CustomerServiceLinkController(CustomerServiceLinkService customerServiceLinkService) {
        this.customerServiceLinkService = customerServiceLinkService;
    }

    @GetMapping("/totalReveneu")
    public Double getGrandTotalReveneu(){
        return customerServiceLinkService.getGrandTotalRevenue();
    }

    @GetMapping("/monthlySubscribers")
    public List<CustomerSubscriptionDTO> getSubscriptionDetails() {
        return customerServiceLinkService.getSubscriptionDetails();
    }

    @GetMapping("/total-revenue-by-broadband-service-type")
    public List<BroadbandReveneuDTO> getTotalRevenueByServiceType() {
        return customerServiceLinkService.getTotalRevenueByServiceType();
    }

    @GetMapping("/total-revenue-by-dth-service-type")
    public List<DthReveneuDTO> getTotalRevenueByDthServiceType() {
        return customerServiceLinkService.getTotalRevenueByDthServiceType();
    }

    @GetMapping("/active-broadband-customers")
    public Object getBroadbandStatusCount() {
        return customerServiceLinkService.getBroadbandStatusCount();
    }

    @GetMapping("/active-dth-customers")
    public Object getDTHStatusCount() {
        return customerServiceLinkService.getDTHStatusCount();
    }


    @PostMapping("/individual/create")
    public ResponseEntity<String> createCustomerServiceLinkIndividual(@RequestBody CustomerServiceLinkIndividualDTO requestDTO) {
        try {
            Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                    .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " +requestDTO.getCustomerId()));
            customerServiceLinkService.saveCustomerServiceLinkIndividualWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getIndividualId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );


//            BroadbandPlans broadbandPlans=broadbandPlansRepository.findById(individual.get); changed

            String k="Hello you Subscribe to individual plan for"+" "+requestDTO.getDurationDays()+" "+"days. Thanks";

            emailSender.sendEmailforSignup(customer.getEmail()," Your New Internet Subscription is Confirmed!",k);
//            emailSender.sendSubscriptionReminderEmails();
            System.out.println("Email send success fully !");

            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/business/create")
    public ResponseEntity<String> saveCustomerServiceLinkBusinessWithDates(@RequestBody CustomerServiceLinkBusinessDTO requestDTO) {
        try {
            Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                    .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " ));
            customerServiceLinkService.saveCustomerServiceLinkBusinessWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getBusinessId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            String k="Hello you Subscribe to business plan for"+" "+requestDTO.getDurationDays()+" "+" days. Thanks";
            emailSender.sendEmailforSignup(customer.getEmail()," Your New Internet Subscription is Confirmed!",k);
            System.out.println("Email send success fully !");
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/english/create")
    public ResponseEntity<String> saveCustomerServiceLinkEnglishWithDates(@RequestBody CustomerServiceLinkEnglishDTO requestDTO) {
        try {
            Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                    .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " ));
            customerServiceLinkService.saveCustomerServiceLinkEnglishWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getEnglishId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );

            String k="Hello you Subscribe to english plan for"+" "+requestDTO.getDurationDays()+" "+" days. Thanks";
            System.out.println(customer.getEmail());
            emailSender.sendEmailforSignup(customer.getEmail()," Your New Internet Subscription is Confirmed!",k);
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/hindi/create")
    public ResponseEntity<String> saveCustomerServiceLinkHindiWithDates(@RequestBody CustomerServiceLinkHindiDTO requestDTO) {
        try {
            Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                    .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " ));
            customerServiceLinkService.saveCustomerServiceLinkHindiWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getHindiId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            String k="Hello you \n" +
                    " You have Subscribe to hindi plan for"+" "+requestDTO.getDurationDays()+" "+" days. \n" +
                    "Thanks";
            emailSender.sendEmailforSignup(customer.getEmail()," Your New Internet Subscription is Confirmed!",k);
            System.out.println("Email send success fully !");
            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/tamil/create")
    public ResponseEntity<String> saveCustomerServiceLinkTamilWithDates(@RequestBody CustomerServiceLinkTamilDTO requestDTO) {
        try {
            Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                    .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " ));

            customerServiceLinkService.saveCustomerServiceLinkTamilWithDates(
                    requestDTO.getCustomerId(),
                    requestDTO.getTamilId(),
                    requestDTO.getDurationDays(),
                    requestDTO.isCustomerStatus()
            );
            String k="Hello you Subscribe to tamil plan for"+" "+requestDTO.getDurationDays()+" "+"Thanks";
            emailSender.sendEmailforSignup(customer.getEmail()," Your New Internet Subscription is Confirmed!",k);
            System.out.println("Email send success fully !");

            return new ResponseEntity<>("Customer Service Link created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating Customer Service Link: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/validity/{cid}")
    public ResponseEntity<String> updateCustomerStatusBySubscriptionEndDate(@PathVariable Long cid){
        customerServiceLinkService.updateCustomerStatusBySubscriptionEndDate(cid);
        return new ResponseEntity<>("Customer status updated",HttpStatus.CREATED);
    }

    @GetMapping("/history/{customerId}")
    public List<CustomerHistoryDTO> getServiceDetails(@PathVariable Long customerId) {
        return customerServiceLinkService.getCustomerHistoryDetails(customerId);
    }
}
