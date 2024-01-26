package com.coderdot.controllers;

import com.coderdot.entities.BroadbandPlans;
import com.coderdot.services.BroadBandPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/broadband-plans")
public class BroadbandPlansController {

    private final BroadBandPlansService broadBandPlansService;

    @Autowired
    public BroadbandPlansController(BroadBandPlansService broadBandPlansService) {
        this.broadBandPlansService = broadBandPlansService;
    }

    @GetMapping
    public List<BroadbandPlans> getAllPlans(){
        return broadBandPlansService.getAllPlans();
    }
}
