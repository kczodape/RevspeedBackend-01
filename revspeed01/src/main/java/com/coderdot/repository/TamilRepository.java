package com.coderdot.repository;

import com.coderdot.entities.Tamil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamilRepository extends JpaRepository<Tamil, Long> {
}
