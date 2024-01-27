package com.coderdot.controllers;

import com.coderdot.dto.ChannelDTO;
import com.coderdot.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/channels")
public class ChannelController {


    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/english/entertainment")
    public List<ChannelDTO> getEnglishEntertainmentChannels() {
        return channelService.getEnglishEntertainmentChannels();
    }

    @GetMapping("/english/sport")
    public List<ChannelDTO> getEnglishSportChannels() {
        return channelService.getEnglishSportChannels();
    }

    @GetMapping("/english/news")
    public List<ChannelDTO> getEnglishNewsChannels() {
        return channelService.getEnglishNewsChannels();
    }

    @GetMapping("/hindi/entertainment")
    public List<ChannelDTO> getHindiEntertainmentChannels() {
        return channelService.getHindEntertainmentChannels();
    }

    @GetMapping("/hindi/sport")
    public List<ChannelDTO> getHindiSportChannels() {
        return channelService.getHindiportChannels();
    }

    @GetMapping("/hindi/news")
    public List<ChannelDTO> getHindiNewsChannels() {
        return channelService.getHindiNewsChannels();
    }
    @GetMapping("/tamil/entertainment")
    public List<ChannelDTO> getTamilEntertainmentChannels() {
        return channelService.getTamilEntertainmentChannels();
    }

    @GetMapping("/tamil/sport")
    public List<ChannelDTO> getTamilSportChannels() {
        return channelService.getTamilSportChannels();
    }

    @GetMapping("/tamil/news")
    public List<ChannelDTO> getTamilNewsChannels() {
        return channelService.getTamilNewsChannels();
    }
}
