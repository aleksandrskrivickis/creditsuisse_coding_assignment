package com.creditsuisse.assignments.eventAnomalyDetection.Servers;

import com.creditsuisse.assignments.eventAnomalyDetection.Configuration.HSQLDBServerConfiguration;
import org.hsqldb.Server;

public class HSQLDBServer {

    public static HSQLDBServer singleInstance = null;

    private HSQLDBServer(){

    }

    public static HSQLDBServer createInstance()
    {
        if (singleInstance == null)
            singleInstance = new HSQLDBServer();
        return singleInstance;
    }


    public void run(){
        Server hsqlServer = new Server();

        hsqlServer.setLogWriter(null);
        hsqlServer.setSilent(true);

        hsqlServer.setDatabaseName(0, HSQLDBServerConfiguration.DATABASE_NAME);
        hsqlServer.setDatabasePath(0, HSQLDBServerConfiguration.DATABASE_PATH);

        // Start the database!
        hsqlServer.start();
    }
}
