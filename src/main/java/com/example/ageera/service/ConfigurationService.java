package com.example.ageera.service;

import com.example.ageera.model.configuration.Configuration;
import com.example.ageera.model.configuration.ConfigurationHistory;
import com.example.ageera.model.configuration.Site;
import com.example.ageera.repository.ConfigurationHistoryRepository;
import com.example.ageera.repository.ConfigurationRepository;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ConfigurationService {
    @Autowired
    private ConfigurationRepository configurationRepository;
    @Autowired
    private ConfigurationHistoryRepository configurationHistoryRepository;

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    @Autowired
    private MongoClient client;

    public Site addSite(Site site) {
        return configurationRepository.insert(site);
    }

    private <T, R> R withTransaction(Function<T, R> execute, T data) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> execute.apply(data), txnOptions);
        }
    }

    private record ConfigSiteData(Integer siteId, Configuration configuration) {}

    public Site configSite(Integer siteId, Configuration configuration) {
        return withTransaction(this::configSiteRaw, new ConfigSiteData(siteId, configuration));
    }

    private Site configSiteRaw(ConfigSiteData configSiteData) {
        Optional<Site> byId = configurationRepository.findById(configSiteData.siteId);
        Site site = byId.orElseThrow();
        Configuration oldConfiguration = site.getConfiguration();
        ConfigurationHistory configurationHistory = new ConfigurationHistory();
        configurationHistory.setSiteId(configSiteData.siteId);
        configurationHistory.setUpdateTime(LocalDateTime.now());
        configurationHistory.setConfiguration(oldConfiguration);
        configurationHistoryRepository.save(configurationHistory);
        site.setConfiguration(configSiteData.configuration);
        return configurationRepository.save(site);
    }

    public List<Site> listSites() {
        return configurationRepository.findAll();
    }

    public Site getSite(Integer siteId) {
        Optional<Site> byId = configurationRepository.findById(siteId);
        return byId.orElseThrow();
    }
}
