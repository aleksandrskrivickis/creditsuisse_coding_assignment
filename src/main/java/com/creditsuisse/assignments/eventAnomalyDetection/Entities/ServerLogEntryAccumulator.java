package com.creditsuisse.assignments.eventAnomalyDetection.Entities;

import static java.lang.Math.abs;

public class ServerLogEntryAccumulator {

    private String id = null;
    private Long timestamp = null;

    public ServerLogEntryAccumulator(String id, Long timestamp){
        this.id = id;
        this.timestamp = timestamp;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
