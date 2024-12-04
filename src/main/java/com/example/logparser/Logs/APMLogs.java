package com.example.logparser.Logs;

import java.util.ArrayList;

public class APMLogs {

    private ArrayList<APMLog> logs;
    public APMLogs(){
        logs = new ArrayList<>();
    }

    public void addAPMLog(APMLog newLog){
        logs.add(newLog);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n"); // Start the outer JSON-like structure

        // Iterate through the logs list and process each APMLog object
        for (APMLog apmLog : logs) {
            sb.append(apmLog.toString());
        }

        // Remove the trailing comma if the last entry exists
        if (sb.charAt(sb.length() - 2) == ',') {
            sb.delete(sb.length() - 2, sb.length()); // Remove last comma
        }

        sb.append("\n}");
        return sb.toString();
    }


}
