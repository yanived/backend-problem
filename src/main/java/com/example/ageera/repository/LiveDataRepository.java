package com.example.ageera.repository;

import com.example.ageera.model.live.LiveData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LiveDataRepository extends MongoRepository<LiveData, Integer> {
    LiveData findFirstByOrderByDtStampDesc();
}
