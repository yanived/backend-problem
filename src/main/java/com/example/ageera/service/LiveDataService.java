package com.example.ageera.service;

import com.example.ageera.model.configuration.Site;
import com.example.ageera.model.live.LiveData;
import com.example.ageera.repository.LiveDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LiveDataService {
    @Autowired
    LiveDataRepository liveDataRepository;

    public LiveData addLiveData(LiveData liveData) {
        if (liveData.getDtStamp() == null) {
            liveData.setDtStamp(LocalDateTime.now());
        }
        return liveDataRepository.save(liveData);
    }

    public LiveData getLatest() {
        return liveDataRepository.findFirstByOrderByDtStampDesc();
    }
}
