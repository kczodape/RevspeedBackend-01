package com.coderdot.services.impl;

import com.coderdot.repository.CustomerServiceLinkRepository;
import com.coderdot.services.CustomerServiceLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceLinkServiceImpl implements CustomerServiceLinkService{
  private final CustomerServiceLinkRepository customerServiceLinkRepository;

  @Autowired
  public CustomerServiceLinkServiceImpl(CustomerServiceLinkRepository customerServiceLinkRepository) {
      this.customerServiceLinkRepository = customerServiceLinkRepository;
  }

    @Override
    public Double getGrandTotalRevenue() {
        return customerServiceLinkRepository.getGrandTotalPrice();
    }
}
