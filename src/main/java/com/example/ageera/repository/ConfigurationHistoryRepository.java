package com.example.ageera.repository;

import com.example.ageera.model.configuration.ConfigurationHistory;
import com.example.ageera.model.live.LiveData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigurationHistoryRepository extends MongoRepository<ConfigurationHistory, ObjectId> {
}
