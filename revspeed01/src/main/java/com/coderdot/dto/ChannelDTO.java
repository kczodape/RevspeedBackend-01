package com.coderdot.dto;


import lombok.*;

import java.nio.channels.Channel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChannelDTO {

    private Long channelId;
    private String channelName;
    private String channelCategory;
    private double price;
}