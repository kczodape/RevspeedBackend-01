package com.coderdot.services.impl;

import com.coderdot.dto.ChannelDTO;
import com.coderdot.repository.ChannelRepository;
import com.coderdot.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public List<ChannelDTO> getEnglishEntertainmentChannels() {
        return channelRepository.getEnglishEntertainmentChannels();
    }

    @Override
    public List<ChannelDTO> getEnglishSportChannels() {
        return channelRepository.getEnglishSportChannels();
    }

    @Override
    public List<ChannelDTO> getEnglishNewsChannels() {
        return channelRepository.getEnglishNewsChannels();
    }

    @Override
    public List<ChannelDTO> getHindEntertainmentChannels() {
        return channelRepository.getHindiEntertainmentChannels();
    }

    @Override
    public List<ChannelDTO> getHindiportChannels() {
        return channelRepository.getHindiSportChannels();
    }

    @Override
    public List<ChannelDTO> getHindiNewsChannels() {
        return channelRepository.getHindiNewsChannels();
    }

    @Override
    public List<ChannelDTO> getTamilEntertainmentChannels() {
        return channelRepository.getTamilEntertainmentChannels();
    }

    @Override
    public List<ChannelDTO> getTamilSportChannels() {
        return channelRepository.getTamilSportChannels();
    }

    @Override
    public List<ChannelDTO> getTamilNewsChannels() {
        return channelRepository.getTamilNewsChannels();
    }
}
