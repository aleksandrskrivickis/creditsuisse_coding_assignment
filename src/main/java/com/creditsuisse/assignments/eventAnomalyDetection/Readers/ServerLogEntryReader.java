package com.creditsuisse.assignments.eventAnomalyDetection.Readers;

import com.creditsuisse.assignments.eventAnomalyDetection.Entities.ServerLogEntry;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ServerLogEntryReader {

    private static final Type LOG_ENTRY_TYPE = new TypeToken<ArrayList<ServerLogEntry>>() {}.getType();

    public List<ServerLogEntry> readServerLogEntry(String p_path) throws FileNotFoundException {
        Gson gson = new Gson();
        com.google.gson.stream.JsonReader reader = new com.google.gson.stream.JsonReader(new FileReader(p_path));
        List<ServerLogEntry> data = gson.fromJson(reader, LOG_ENTRY_TYPE);
        return data;
    }

}
