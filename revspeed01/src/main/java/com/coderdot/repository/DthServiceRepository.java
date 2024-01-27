package com.coderdot.repository;

import com.coderdot.entities.DthService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DthServiceRepository extends JpaRepository<DthService, Long> {
    // Fetch all Entertainment channels from a specific language
    @Query("SELECT c FROM #{#entityName} c " +
            "JOIN c.englishChannels e " +
            "JOIN e.channelCategory cc " +
            "WHERE cc.channelCategoryName = :category AND c.dthLanguage = :language")
    List<DthService> getChannelsByCategoryAndLanguage(
            @Param("category") String category,
            @Param("language") String language
    );
}
