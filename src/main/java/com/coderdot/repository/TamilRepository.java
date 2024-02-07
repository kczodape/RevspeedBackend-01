package com.coderdot.repository;

import com.coderdot.entities.Tamil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.Channel;
import java.util.List;

@Repository
public interface TamilRepository extends JpaRepository<Tamil, Long> {
}
