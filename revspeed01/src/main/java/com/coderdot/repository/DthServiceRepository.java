package com.coderdot.repository;

import com.coderdot.entities.DthService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DthServiceRepository extends JpaRepository<DthService, Long> {
}
