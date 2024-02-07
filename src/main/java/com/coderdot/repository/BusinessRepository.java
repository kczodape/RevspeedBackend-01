package com.coderdot.repository;

import com.coderdot.dto.BusinessDTO;
import com.coderdot.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
//    @Query("SELECT new com.coderdot.dto.BusinessDTO(bs.broadbandServicePlansName AS planName, d.durationName, d.days, bp.broadbandPlansName AS planType, b.speed, b.price) " +
//            "FROM Business b " +
//            "JOIN BroadbandService bs ON b.broadbandService.broadbandServiceId = bs.broadbandServiceId " +
//            "JOIN Duration d ON b.duration.durationId = d.durationId " +
//            "JOIN BroadbandPlans bp ON b.broadbandPlans.broadbandPlansId = bp.broadbandPlansId")
//    List<BusinessDTO> findBusinessDetails();
}
