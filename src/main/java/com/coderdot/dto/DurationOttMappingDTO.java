package com.coderdot.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DurationOttMappingDTO {
    private String durationName;
    private Map<Long, String> ottPlatformsNameMap;
}