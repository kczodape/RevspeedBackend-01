package com.coderdot.repository;

import com.coderdot.entities.Duration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository extends JpaRepository<Duration, Long> {
}
