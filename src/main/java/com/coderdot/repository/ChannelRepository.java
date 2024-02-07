package com.coderdot.repository;

import com.coderdot.dto.ChannelDTO;
import com.coderdot.entities.ChannelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.nio.channels.Channel;
import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelCategory, Long> {
    @Query("SELECT new com.coderdot.dto.ChannelDTO(e.englishId, e.englishChannelName, cc.channelCategoryName, e.price) FROM English e " +
            "JOIN ChannelCategory cc ON e.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'Entertainment'")
    List<ChannelDTO> getEnglishEntertainmentChannels();

    @Query("SELECT new com.coderdot.dto.ChannelDTO(e.englishId, e.englishChannelName, cc.channelCategoryName, e.price) FROM English e " +
            "JOIN ChannelCategory cc ON e.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'Sport'")
    List<ChannelDTO> getEnglishSportChannels();

    @Query("SELECT new com.coderdot.dto.ChannelDTO(e.englishId, e.englishChannelName, cc.channelCategoryName, e.price) FROM English e " +
            "JOIN ChannelCategory cc ON e.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'News'")
    List<ChannelDTO> getEnglishNewsChannels();

    // Similar queries for Hindi and Tamil channels in different categories

    @Query("SELECT new com.coderdot.dto.ChannelDTO(h.hindiId, h.hindiChannelName, cc.channelCategoryName, h.price) FROM Hindi h " +
            "JOIN ChannelCategory cc ON h.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'Entertainment'")
    List<ChannelDTO> getHindiEntertainmentChannels();

    @Query("SELECT new com.coderdot.dto.ChannelDTO(h.hindiId, h.hindiChannelName, cc.channelCategoryName, h.price) FROM Hindi h " +
            "JOIN ChannelCategory cc ON h.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'Sport'")
    List<ChannelDTO> getHindiSportChannels();

    @Query("SELECT new com.coderdot.dto.ChannelDTO(h.hindiId, h.hindiChannelName, cc.channelCategoryName, h.price) FROM Hindi h " +
            "JOIN ChannelCategory cc ON h.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'News'")
    List<ChannelDTO> getHindiNewsChannels();

    // Similar queries for Tamil channels in different categories

    @Query("SELECT new com.coderdot.dto.ChannelDTO(t.tamilId, t.tamilChannelName, cc.channelCategoryName, t.price) FROM Tamil t " +
            "JOIN ChannelCategory cc ON t.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'Entertainment'")
    List<ChannelDTO> getTamilEntertainmentChannels();

    @Query("SELECT new com.coderdot.dto.ChannelDTO(t.tamilId, t.tamilChannelName, cc.channelCategoryName, t.price) FROM Tamil t " +
            "JOIN ChannelCategory cc ON t.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'Sport'")
    List<ChannelDTO> getTamilSportChannels();

    @Query("SELECT new com.coderdot.dto.ChannelDTO(t.tamilId, t.tamilChannelName, cc.channelCategoryName, t.price) FROM Tamil t " +
            "JOIN ChannelCategory cc ON t.channelCategory.channelCategoryId = cc.channelCategoryId " +
            "WHERE cc.channelCategoryName = 'News'")
    List<ChannelDTO> getTamilNewsChannels();
}
