package com.creditsuisse.assignments.eventAnomalyDetection;

import com.creditsuisse.assignments.eventAnomalyDetection.Managers.ServerLogEntryProcessingManager;
import com.creditsuisse.assignments.eventAnomalyDetection.Servers.HSQLDBServer;

import java.io.FileNotFoundException;
import java.sql.SQLException;


public class main {

    public static void main(String[] args) throws FileNotFoundException, SQLException {

        if (args.length != 1){
            System.out.println("Please specify one argument with path to JSON file.");
            System.exit(-1);
        }

        String json_path = args[0];
        System.out.println("Trying to fetch JSON from " + json_path);

        HSQLDBServer hsqldbserver = HSQLDBServer.createInstance();

        //Multi-threaded solution to handle HSQLDB Server in parallel
        hsqldbserver.run();

        //Processing log entries
        ServerLogEntryProcessingManager slepm = new ServerLogEntryProcessingManager(json_path);
        slepm.processLogEntries();
    }

}
