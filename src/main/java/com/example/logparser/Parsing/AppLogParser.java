package com.example.logparser.Parsing;

import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppLogParser implements Parser{
    private Parser nextParse;
    private String[] keywords = {"level"};
    private ArrayList<String> logs = new ArrayList<>();
    private HashMap<String, Integer> translated = new HashMap<>();

    @Override
    public void setNext(Parser p){
        nextParse = p;
    }

    @Override
    public boolean handle(String textLine) {
        for(int i = 0; i < keywords.length; i++){
            if(textLine.contains(keywords[i])){
                return false;
            }
        }
        logs.add(textLine);
        return true;
    }

    private void translateAllAppLogParser(){
        String regex = "level=([^\\s]+)";
        //Convert every text to APM JSON format
        for (String text: logs) {
            // Compile the regex pattern
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            String metric = matcher.group(1);
            System.out.println(metric);

            if(!translated.containsKey(text)){// If metric name is not in the Hash Map
                translated.put(metric, 0);
            }
            else{ // update that specific metric by 1
                translated.replace(metric, translated.get(metric) + 1);
            }
        }
    }
}

