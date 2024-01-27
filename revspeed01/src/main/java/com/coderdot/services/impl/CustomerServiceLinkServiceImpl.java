package com.coderdot.services.impl;

import com.coderdot.dto.ActiveCustomersDTO;
import com.coderdot.dto.BroadbandReveneuDTO;
import com.coderdot.dto.CustomerSubscriptionDTO;
import com.coderdot.dto.DthReveneuDTO;
import com.coderdot.repository.CustomerServiceLinkRepository;
import com.coderdot.services.CustomerServiceLinkService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
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

}
