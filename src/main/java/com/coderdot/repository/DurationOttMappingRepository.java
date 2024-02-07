package com.coderdot.repository;

import com.coderdot.entities.DurationOttMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DurationOttMappingRepository extends JpaRepository<DurationOttMapping, Long> {
    @Query("SELECT d.durationName, o.ottPlatformsName FROM DurationOttMapping m JOIN m.duration d JOIN m.ottPlatforms o")
    List<Object[]> findAllWithDurationAndOttPlatforms();
}
