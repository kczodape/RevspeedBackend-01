package com.coderdot.services;

import com.coderdot.dto.ChannelDTO;

import java.util.List;

public interface ChannelService {
    List<ChannelDTO> getEnglishEntertainmentChannels();

    List<ChannelDTO> getEnglishSportChannels();

    List<ChannelDTO> getEnglishNewsChannels();

    List<ChannelDTO> getHindEntertainmentChannels();

    List<ChannelDTO> getHindiportChannels();

    List<ChannelDTO> getHindiNewsChannels();

    List<ChannelDTO> getTamilEntertainmentChannels();

    List<ChannelDTO> getTamilSportChannels();

    List<ChannelDTO> getTamilNewsChannels();
}
