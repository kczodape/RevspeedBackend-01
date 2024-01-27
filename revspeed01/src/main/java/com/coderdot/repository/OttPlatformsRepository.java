package com.coderdot.repository;

import com.coderdot.entities.OttPlatforms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OttPlatformsRepository extends JpaRepository<OttPlatforms, Long> {
    Optional<OttPlatforms> findByOttPlatformsName(String ottPlatformsName);

}
