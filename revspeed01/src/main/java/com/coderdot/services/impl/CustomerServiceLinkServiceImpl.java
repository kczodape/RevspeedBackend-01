package com.coderdot.services.impl;

import com.coderdot.dto.*;
import com.coderdot.entities.*;
import com.coderdot.repository.*;
import com.coderdot.services.CustomerServiceLinkService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceLinkServiceImpl implements CustomerServiceLinkService{
  private final CustomerServiceLinkRepository customerServiceLinkRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;
    private final EnglishRepository englishRepository;
    private final HindiRepository hindiRepository;
    private final TamilRepository tamilRepository;
    private final IndividualRepository individualRepository;
    private final DurationRepository durationRepository;
  @Autowired
  public CustomerServiceLinkServiceImpl(CustomerServiceLinkRepository customerServiceLinkRepository, DurationRepository durationRepository, CustomerRepository customerRepository, IndividualRepository individualRepository, BusinessRepository businessRepository, EnglishRepository englishRepository, HindiRepository hindiRepository, TamilRepository tamilRepository, CustomerRepository customerRepository1, BusinessRepository businessRepository1, EnglishRepository englishRepository1, HindiRepository hindiRepository1, TamilRepository tamilRepository1, IndividualRepository individualRepository1, DurationRepository durationRepository1) {
      this.customerServiceLinkRepository = customerServiceLinkRepository;
      this.customerRepository = customerRepository1;
      this.businessRepository = businessRepository1;
      this.englishRepository = englishRepository1;
      this.hindiRepository = hindiRepository1;
      this.tamilRepository = tamilRepository1;
      this.individualRepository = individualRepository1;
      this.durationRepository = durationRepository1;
  }


    @Override
    public Double getGrandTotalRevenue() {
        return customerServiceLinkRepository.getGrandTotalPrice();
    }

    @Override
    public List<CustomerSubscriptionDTO> getSubscriptionDetails() {
        // Use the repository method directly
        List<CustomerServiceLinkRepository.MonthlySubscribers> monthlySubscribers = customerServiceLinkRepository.findTotalSubscribersByMonth();

        // Convert the result to DTOs using the repository's conversion method
        return customerServiceLinkRepository.convertToDTOs(monthlySubscribers);
    }

    @Override
    public List<BroadbandReveneuDTO> getTotalRevenueByServiceType() {
        List<Object[]> result = customerServiceLinkRepository.getTotalRevenueByServiceType();

        List<BroadbandReveneuDTO> dtos = new ArrayList<>();

        for (Object[] row : result) {
            BroadbandReveneuDTO dto = new BroadbandReveneuDTO();
            dto.setServiceType((String) row[0]);
            dto.setTotalRevenue((Double) row[1]);
            dtos.add(dto);
        }

        return dtos;
    }


    @Override
    public List<DthReveneuDTO> getTotalRevenueByDthServiceType() {
        List<Object[]> result = customerServiceLinkRepository.getTotalRevenueByDthServiceType();

        List<DthReveneuDTO> revenueList = new ArrayList<>();

        for (Object[] row : result) {
            DthReveneuDTO revenueDTO = new DthReveneuDTO();
            revenueDTO.setTotalEnglishAmount((Double) row[0]);
            revenueDTO.setTotalHindiAmount((Double) row[1]);
            revenueDTO.setTotalTamilAmount((Double) row[2]);
            revenueList.add(revenueDTO);
        }

        return revenueList;
    }


    @Override
    public Object getBroadbandStatusCount() {
        return customerServiceLinkRepository.getBroadbandStatusCount();
    }

    @Override
    public Object getDTHStatusCount() {
        return customerServiceLinkRepository.getDTHStatusCount();
    }

    @Override
    public void saveCustomerServiceLinkIndividualWithDates(Long customerId, Long individualId, int durationDays, boolean customerStatus) {
        // Step 1: Fetch entities based on provided IDs
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Individual individual = individualRepository.findById(individualId).orElseThrow(() -> new EntityNotFoundException("Individual not found"));
        // Step 2: Calculate subscription start and end dates
        LocalDate subscriptionStartDate = LocalDate.now();
        LocalDate subscriptionEndDate = subscriptionStartDate.plusDays(durationDays);

        // Step 3: Create and save CustomerServiceLink entity
        CustomerServiceLink customerServiceLink = new CustomerServiceLink();
        customerServiceLink.setCustomer(customer);
        customerServiceLink.setIndividual(individual);
        customerServiceLink.setSubscriptionStartDate(subscriptionStartDate);
        customerServiceLink.setSubscriptionEndDate(subscriptionEndDate);
        customerServiceLink.setCustomerStatus(customerStatus);

        customerServiceLinkRepository.save(customerServiceLink);
    }

    @Override
    public void saveCustomerServiceLinkBusinessWithDates(Long customerId, Long businessId, int durationDays, boolean customerStatus) {
        // Step 1: Fetch entities based on provided IDs
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Business business = businessRepository.findById(businessId).orElseThrow(() -> new EntityNotFoundException("Business not found"));
        // Step 2: Calculate subscription start and end dates
        LocalDate subscriptionStartDate = LocalDate.now();
        LocalDate subscriptionEndDate = subscriptionStartDate.plusDays(durationDays);

        // Step 3: Create and save CustomerServiceLink entity
        CustomerServiceLink customerServiceLink = new CustomerServiceLink();
        customerServiceLink.setCustomer(customer);
        customerServiceLink.setBusiness(business);
        customerServiceLink.setSubscriptionStartDate(subscriptionStartDate);
        customerServiceLink.setSubscriptionEndDate(subscriptionEndDate);
        customerServiceLink.setCustomerStatus(customerStatus);

        customerServiceLinkRepository.save(customerServiceLink);
    }

    @Override
    public void saveCustomerServiceLinkEnglishWithDates(Long customerId, Long englishId, int durationDays, boolean customerStatus) {
        // Step 1: Fetch entities based on provided IDs
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        English english = englishRepository.findById(englishId).orElseThrow(() -> new EntityNotFoundException("Business not found"));
        // Step 2: Calculate subscription start and end dates
        LocalDate subscriptionStartDate = LocalDate.now();
        LocalDate subscriptionEndDate = subscriptionStartDate.plusDays(durationDays);

        // Step 3: Create and save CustomerServiceLink entity
        CustomerServiceLink customerServiceLink = new CustomerServiceLink();
        customerServiceLink.setCustomer(customer);
        customerServiceLink.setEnglish(english);
        customerServiceLink.setSubscriptionStartDate(subscriptionStartDate);
        customerServiceLink.setSubscriptionEndDate(subscriptionEndDate);
        customerServiceLink.setCustomerStatus(customerStatus);

        customerServiceLinkRepository.save(customerServiceLink);
    }

    @Override
    public void saveCustomerServiceLinkHindiWithDates(Long customerId, Long hindiId, int durationDays, boolean customerStatus) {
        // Step 1: Fetch entities based on provided IDs
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Hindi hindi = hindiRepository.findById(hindiId).orElseThrow(() -> new EntityNotFoundException("Business not found"));
        // Step 2: Calculate subscription start and end dates
        LocalDate subscriptionStartDate = LocalDate.now();
        LocalDate subscriptionEndDate = subscriptionStartDate.plusDays(durationDays);

        // Step 3: Create and save CustomerServiceLink entity
        CustomerServiceLink customerServiceLink = new CustomerServiceLink();
        customerServiceLink.setCustomer(customer);
        customerServiceLink.setHindi(hindi);
        customerServiceLink.setSubscriptionStartDate(subscriptionStartDate);
        customerServiceLink.setSubscriptionEndDate(subscriptionEndDate);
        customerServiceLink.setCustomerStatus(customerStatus);

        customerServiceLinkRepository.save(customerServiceLink);
    }

    @Override
    public void saveCustomerServiceLinkTamilWithDates(Long customerId, Long tamilId, int durationDays, boolean customerStatus) {
        // Step 1: Fetch entities based on provided IDs
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Tamil tamil = tamilRepository.findById(tamilId).orElseThrow(() -> new EntityNotFoundException("Business not found"));
        // Step 2: Calculate subscription start and end dates
        LocalDate subscriptionStartDate = LocalDate.now();
        LocalDate subscriptionEndDate = subscriptionStartDate.plusDays(durationDays);

        // Step 3: Create and save CustomerServiceLink entity
        CustomerServiceLink customerServiceLink = new CustomerServiceLink();
        customerServiceLink.setCustomer(customer);
        customerServiceLink.setTamil(tamil);
        customerServiceLink.setSubscriptionStartDate(subscriptionStartDate);
        customerServiceLink.setSubscriptionEndDate(subscriptionEndDate);
        customerServiceLink.setCustomerStatus(customerStatus);

        customerServiceLinkRepository.save(customerServiceLink);
    }

//    saveCustomerServiceLinkHindiWithDates
}
