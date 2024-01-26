package com.coderdot.repository;

import com.coderdot.entities.English;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnglishRepository extends JpaRepository<English, Long> {
}
