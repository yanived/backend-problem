package com.example.ageera.controller;

import com.example.ageera.model.configuration.Configuration;
import com.example.ageera.model.configuration.Site;
import com.example.ageera.repository.ConfigurationRepository;
import com.example.ageera.service.ConfigurationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/site")
public class ConfigurationController {
    @Autowired
    private ConfigurationService configurationService;

    @PostMapping("add")
    public Site addSite(@Valid @RequestBody Site site) {
        return configurationService.addSite(site);
    }

    @PutMapping("config/{siteId}")
    public Site configSite(@PathVariable Integer siteId, @Valid @RequestBody Configuration configuartion) {
        return configurationService.configSite(siteId, configuartion);
    }

    @GetMapping("list")
    public List<Site> listSites() {
        List<Site> sites = configurationService.listSites();
        return sites;
    }

    @GetMapping("details/{siteId}")
    public Site getSite(@PathVariable Integer siteId) {
        return configurationService.getSite(siteId);
    }
}
