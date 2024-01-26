package com.coderdot.repository;

import com.coderdot.entities.BroadbandService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadbandServiceRepository extends JpaRepository<BroadbandService, Long> {
}
