package com.coderdot.controllers;

import com.coderdot.dto.DurationOttMappingDTO;
import com.coderdot.services.DurationOttMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/durationOttMappings")
public class DurationOttMappingController {

    private final DurationOttMappingService durationOttMappingService;

    @Autowired
    public DurationOttMappingController(DurationOttMappingService durationOttMappingService) {
        this.durationOttMappingService = durationOttMappingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DurationOttMappingDTO>> getAllDurationOttMappings() {
        List<DurationOttMappingDTO> durationOttMappings = durationOttMappingService.getAllDurationOttMappings();
        return new ResponseEntity<>(durationOttMappings, HttpStatus.OK);
    }
}