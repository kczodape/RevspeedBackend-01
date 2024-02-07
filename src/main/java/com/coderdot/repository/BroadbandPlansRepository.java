package com.coderdot.repository;

import com.coderdot.entities.BroadbandPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadbandPlansRepository extends JpaRepository<BroadbandPlans, Long> {
}
