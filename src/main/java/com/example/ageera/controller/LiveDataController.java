package com.example.ageera.controller;

import com.example.ageera.model.live.LiveData;
import com.example.ageera.service.LiveDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/live-data")
public class LiveDataController {
    @Autowired
    LiveDataService liveDataService;

    @PutMapping("add")
    public LiveData addLiveData(@Valid @RequestBody LiveData liveData) {
        return liveDataService.addLiveData(liveData);
    }

    @GetMapping("latest")
    public LiveData getLatest() {
        return liveDataService.getLatest();
    }
}
