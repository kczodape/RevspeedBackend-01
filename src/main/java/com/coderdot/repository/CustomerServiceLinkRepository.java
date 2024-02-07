package com.coderdot.repository;

import com.coderdot.dto.*;
import com.coderdot.entities.CustomerServiceLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface CustomerServiceLinkRepository extends JpaRepository<CustomerServiceLink, Long> {

    @Query(value = "SELECT COALESCE(SUM(total_price), 0) AS grand_total_price FROM ( " +
            "SELECT " +
            "   csl.customer_id, " +
            "   COALESCE(SUM(i.price), 0) + " +
            "   COALESCE(SUM(b.price), 0) + " +
            "   COALESCE(SUM(e.price), 0) + " +
            "   COALESCE(SUM(h.price), 0) + " +
            "   COALESCE(SUM(t.price), 0) AS total_price " +
            "FROM " +
            "   customer_service_link csl " +
            "   LEFT JOIN individual i ON csl.individual_id = i.individual_id " +
            "   LEFT JOIN business b ON csl.business_id = b.business_id " +
            "   LEFT JOIN english e ON csl.english_id = e.english_id " +
            "   LEFT JOIN hindi h ON csl.hindi_id = h.hindi_id " +
            "   LEFT JOIN tamil t ON csl.tamil_id = t.tamil_id " +
            "GROUP BY " +
            "   csl.customer_id " +
            ") AS customer_totals", nativeQuery = true)
    Double getGrandTotalPrice();

    // Projection Interface
    public interface MonthlySubscribers {
        String getMonth();
        Long getTotalSubscribers();
    }

    // Modified Repository Query
    @Query(value = "SELECT DATE_FORMAT(subscription_start_date, '%M') AS month, COUNT(DISTINCT customer_id) AS totalSubscribers FROM customer_service_link WHERE customer_status = 1 GROUP BY DATE_FORMAT(subscription_start_date, '%M')", nativeQuery = true)
    List<MonthlySubscribers> findTotalSubscribersByMonth();

    // DTO Conversion Method (Optional, if needed)
    default List<CustomerSubscriptionDTO> convertToDTOs(List<MonthlySubscribers> results) {
        // Implement the conversion logic based on the structure of your projection result
        // For example:
        List<CustomerSubscriptionDTO> dtos = new ArrayList<>();
        for (MonthlySubscribers result : results) {
            CustomerSubscriptionDTO dto = new CustomerSubscriptionDTO();
            dto.setMonth(result.getMonth());
            dto.setTotalSubscribers(result.getTotalSubscribers());
            // Set other properties accordingly
            dtos.add(dto);
        }
        return dtos;
    }

    @Query("SELECT 'Individual' AS serviceType, COALESCE(SUM(i.price), 0) AS totalRevenue " +
            "FROM CustomerServiceLink csl " +
            "LEFT JOIN Individual i ON csl.individual.individualId = i.individualId AND csl.customerStatus = true " +
            "UNION " +
            "SELECT 'Business' AS serviceType, COALESCE(SUM(b.price), 0) AS totalRevenue " +
            "FROM CustomerServiceLink csl " +
            "LEFT JOIN Business b ON csl.business.businessId = b.businessId AND csl.customerStatus = true")
    List<Object[]> getTotalRevenueByServiceType();


    @Query(nativeQuery = true, value = "SELECT " +
            "SUM(e.price) AS total_english_amount, " +
            "SUM(h.price) AS total_hindi_amount, " +
            "SUM(t.price) AS total_tamil_amount " +
            "FROM customer_service_link csl " +
            "LEFT JOIN english e ON csl.english_id = e.english_id " +
            "LEFT JOIN hindi h ON csl.hindi_id = h.hindi_id " +
            "LEFT JOIN tamil t ON csl.tamil_id = t.tamil_id")
    List<Object[]> getTotalRevenueByDthServiceType();

    @Query("SELECT 'Broadband' AS status, COUNT(DISTINCT csl.customer.id) AS count " +
            "FROM CustomerServiceLink csl " +
            "WHERE csl.customerStatus = true AND (csl.individual.id != 0 OR csl.business.id != 0)")
    Object getBroadbandStatusCount();

    @Query("SELECT 'DTH' AS status, COUNT(DISTINCT csl.customer.id) AS count " +
            "FROM CustomerServiceLink csl " +
            "WHERE csl.customerStatus = true AND (csl.english.id != 0 OR csl.hindi.id != 0 OR csl.tamil.id != 0)")
    Object getDTHStatusCount();

    @Query(value = "SELECT csl.customer_service_link_id, csl.individual_id, csl.business_id, csl.english_id, csl.hindi_id, csl.tamil_id, " +
            "CASE WHEN csl.individual_id IS NOT NULL THEN 'Individual Broadband Service' " +
            "WHEN csl.business_id IS NOT NULL THEN 'Business Broadband Service' " +
            "WHEN csl.english_id IS NOT NULL THEN 'English DTH Service' " +
            "WHEN csl.hindi_id IS NOT NULL THEN 'Hindi DTH Service' " +
            "WHEN csl.tamil_id IS NOT NULL THEN 'Tamil DTH Service' " +
            "ELSE 'No Service Purchased' END AS purchasedService, " +
            "COALESCE(i.price, b.price, e.price, h.price, t.price) AS servicePrice " +
            "FROM customer_service_link csl " +
            "LEFT JOIN individual i ON csl.individual_id = i.individual_id " +
            "LEFT JOIN business b ON csl.business_id = b.business_id " +
            "LEFT JOIN english e ON csl.english_id = e.english_id " +
            "LEFT JOIN hindi h ON csl.hindi_id = h.hindi_id " +
            "LEFT JOIN tamil t ON csl.tamil_id = t.tamil_id " +
            "WHERE csl.customer_id = :customerId", nativeQuery = true)
    List<Object[]> getCustomerHistoryDetails(@Param("customerId") Long customerId);

    @Query("SELECT csl.customer.id FROM CustomerServiceLink csl WHERE csl.subscriptionEndDate = :subscriptionEndDate")
    List<String> findBySubscriptionEndDate(@Param("subscriptionEndDate") LocalDate subscriptionEndDate);

    @Query("SELECT csl.customer.id FROM CustomerServiceLink csl WHERE csl.subscriptionEndDate = :subscriptionEndDate")
    List<String> findBySubscriptionBeforeEndDate(@Param("subscriptionEndDate") LocalDate subscriptionEndDate);

    @Modifying
    @Query("UPDATE CustomerServiceLink c SET c.customerStatus = false WHERE  c.subscriptionEndDate= CURRENT_DATE AND c.customer.id = :customerId")
    void updateCustomerStatusBySubscriptionEndDate(@Param( "customerId") Long customerId);
}

