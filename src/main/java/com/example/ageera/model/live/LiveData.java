package com.example.ageera.model.live;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class LiveData {
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "dt-stamp")
    private LocalDateTime dtStamp;
    @Min(0L)
    @Max(100L)
    private int soc;
    @JsonProperty(value = "load_kwh")
    @PositiveOrZero
    private int loadKwh;
    @JsonProperty(value = "net_load_kwh")
    @PositiveOrZero
    private int netLoadKwh;
    @JsonProperty(value = "pv_notification")
    private boolean pvNotification;
    @JsonProperty(value = "bio_notification")
    private boolean bioNotification;
    @JsonProperty(value = "cro_notification")
    private boolean croNotification;

    public LocalDateTime getDtStamp() {
        return dtStamp;
    }

    public void setDtStamp(LocalDateTime dtStamp) {
        this.dtStamp = dtStamp;
    }

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
    }

    public int getLoadKwh() {
        return loadKwh;
    }

    public void setLoadKwh(int loadKwh) {
        this.loadKwh = loadKwh;
    }

    public int getNetLoadKwh() {
        return netLoadKwh;
    }

    public void setNetLoadKwh(int netLoadKwh) {
        this.netLoadKwh = netLoadKwh;
    }

    public boolean isPvNotification() {
        return pvNotification;
    }

    public void setPvNotification(boolean pvNotification) {
        this.pvNotification = pvNotification;
    }

    public boolean isBioNotification() {
        return bioNotification;
    }

    public void setBioNotification(boolean bioNotification) {
        this.bioNotification = bioNotification;
    }

    public boolean isCroNotification() {
        return croNotification;
    }

    public void setCroNotification(boolean croNotification) {
        this.croNotification = croNotification;
    }
}
