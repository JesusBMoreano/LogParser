package com.example.logparser.Parsing;
import java.util.ArrayList;

import java.util.HashMap; // import the HashMap class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.logparser.Logs.APMLog;
import com.example.logparser.Logs.APMLogs;

import com.example.logparser.Calculators.APMCalculator;

public class APMParser extends LogParser {
    private Parser nextParse;
    private String[] keywords = {"metric", "value"};
    private ArrayList<String> logs = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> translated = new HashMap<>();

    @Override
    public void setNext(Parser p){
        nextParse = p;
    }

    @Override
    public boolean handle(String textLine) {
        for(int i = 0; i < keywords.length; i++){
            if(!textLine.contains(keywords[i])){
                return false;
            }
        }
        logs.add(textLine);
        return true;
    }

    /**
     * Gathers all the Data of each type and storing the values
     */
    private void orderAllAPM(){
        translated = new HashMap<>();

        // Regex to match "metric=" and "value" followed by a word
        String regex1 = "metric=([^\\s]+)";
        String regex2 = "value=([^\\s]+)";

        //Convert every text to APM JSON format
        for (String text: logs) {
            // Compile the regex pattern
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(text);

            String metric = matcher1.group(1);
            System.out.println(metric);

            // If data type is not in the Hash Map
            if(!translated.containsKey(text)){
                translated.put(metric, new ArrayList<Integer>());
            }

            Pattern pattern2 = Pattern.compile(regex1);
            Matcher matcher2 = pattern2.matcher(text);

            int value = Integer.parseInt(matcher2.group(1));
            System.out.println(value);

            translated.get(metric).add(value);

        }
    }

    /**
     *
     * @return
     */
    private APMLogs calculations(){
        APMLogs allLogs = new APMLogs();
        for (String dataType: translated.keySet()) {
            APMCalculator cal = new APMCalculator(translated.get(dataType));
            double average = cal.average();
            double median = cal.median();
            double min = cal.min();
            double max = cal.max();
            APMLog log = new APMLog(dataType, median, average, min, max);
            allLogs.addAPMLog(log);
        }

        return allLogs;
    }

}
