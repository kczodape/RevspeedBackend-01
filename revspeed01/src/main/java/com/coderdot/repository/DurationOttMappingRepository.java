package com.coderdot.repository;

import com.coderdot.entities.DurationOttMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationOttMappingRepository extends JpaRepository<DurationOttMapping, Long> {
}
