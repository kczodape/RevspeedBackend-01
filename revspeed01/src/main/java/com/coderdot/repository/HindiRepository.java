package com.coderdot.repository;

import com.coderdot.entities.Hindi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HindiRepository extends JpaRepository<Hindi, Long> {
}
