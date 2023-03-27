package com.example.ageera.repository;

import com.example.ageera.model.configuration.Site;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ConfigurationRepository extends MongoRepository<Site, Integer> {}
