package com.creditsuisse.assignments.eventAnomalyDetection.Entities;

import javax.persistence.*;

@Entity
@Table
public class ServerLogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sle_id;
    private String id = null;
    private String state = null;
    private String type = null;
    private String host = null;
    private Long timestamp = null;
    private Boolean alert = null;

    public Boolean getAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    public ServerLogEntry(String id, String state, String type, String host, Long timestamp, Boolean alert) {
        super( );
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
        this.alert = alert;
    }

    @Override
    public String toString() {
        return "ServerLogEntry [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp=" + timestamp + "]";
    }

    public ServerLogEntry( ) {
        super();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


}
/* some getters and setters... */