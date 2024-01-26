package com.coderdot.repository;

import com.coderdot.entities.CustomerServiceLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}
