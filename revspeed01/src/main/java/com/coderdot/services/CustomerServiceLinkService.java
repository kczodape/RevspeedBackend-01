package com.coderdot.services;

import com.coderdot.dto.*;

import java.util.List;

public interface CustomerServiceLinkService {
    Double getGrandTotalRevenue();

    List<CustomerSubscriptionDTO> getSubscriptionDetails();
    List<BroadbandReveneuDTO> getTotalRevenueByServiceType();

    List<DthReveneuDTO> getTotalRevenueByDthServiceType();

    Object getBroadbandStatusCount();

    Object getDTHStatusCount();
    void saveCustomerServiceLinkIndividualWithDates(Long customerId, Long individualId, int durationDays, boolean customerStatus);
    void saveCustomerServiceLinkBusinessWithDates(Long customerId, Long businessId, int durationDays, boolean customerStatus);
    void saveCustomerServiceLinkEnglishWithDates(Long customerId, Long englishId, int durationDays, boolean customerStatus);
    void saveCustomerServiceLinkHindiWithDates(Long customerId, Long hindiId, int durationDays, boolean customerStatus);
    void saveCustomerServiceLinkTamilWithDates(Long customerId, Long tamilId, int durationDays, boolean customerStatus);

    List<CustomerHistoryDTO> getCustomerHistoryDetails(Long customerId);

}
