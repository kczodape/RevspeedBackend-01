package com.coderdot.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ChannelCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long channelCategoryId;

    private String channelCategoryName;

    @OneToMany(mappedBy = "channelCategory")
    private List<English> englishChannels;

    @OneToMany(mappedBy = "channelCategory")
    private List<Hindi> hindiChannels;

    @OneToMany(mappedBy = "channelCategory")
    private List<Tamil> tamilChannels;
}

