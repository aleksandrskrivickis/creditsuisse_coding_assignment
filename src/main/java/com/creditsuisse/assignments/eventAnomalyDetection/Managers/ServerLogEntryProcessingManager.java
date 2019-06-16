package com.creditsuisse.assignments.eventAnomalyDetection.Managers;

import com.creditsuisse.assignments.eventAnomalyDetection.Configuration.AnomalyDetectionRules;
import com.creditsuisse.assignments.eventAnomalyDetection.Entities.ServerLogEntry;
import com.creditsuisse.assignments.eventAnomalyDetection.Entities.ServerLogEntryAccumulator;
import com.creditsuisse.assignments.eventAnomalyDetection.Readers.ServerLogEntryReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.abs;

public class ServerLogEntryProcessingManager {

    EntityManagerFactory emfactory;
    EntityManager entitymanager;
    ServerLogEntryReader sler;
    List<ServerLogEntry> serverLogEntries;
    HashMap<String, ServerLogEntryAccumulator> map;

    public ServerLogEntryProcessingManager(String p_json_path) throws FileNotFoundException {
        this.emfactory = Persistence.createEntityManagerFactory( "anomalyDetectorJpa" );
        this.entitymanager = emfactory.createEntityManager();
        this.sler = new ServerLogEntryReader();
        this.serverLogEntries = sler.readServerLogEntry(p_json_path);

        this.map= new HashMap<>();
    }

    public void processLogEntries(){
        for (ServerLogEntry x : serverLogEntries){
            if (map.containsKey(x.getId())){
                //Setting abs to handle in case if events flow is not properly arranged and start time entry is physically located after stop
                if (abs(x.getTimestamp() - map.get(x.getId()).getTimestamp()) > AnomalyDetectionRules.ANOMALY_DELAY_THRESHOLD){
                    x.setAlert(true);
                }
                entitymanager.getTransaction().begin();
                entitymanager.persist(x);
                entitymanager.getTransaction().commit();
            } else {
                map.put(x.getId(), new ServerLogEntryAccumulator(x.getId(), x.getTimestamp()));
                entitymanager.getTransaction().begin();
                entitymanager.persist(x);
                entitymanager.getTransaction().commit();
            }
        }

        entitymanager.close();
        emfactory.close( );
    }

}


