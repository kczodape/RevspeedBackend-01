package com.coderdot.repository;

import com.coderdot.entities.ChannelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelCategoryRepository extends JpaRepository<ChannelCategory, Long> {
}
