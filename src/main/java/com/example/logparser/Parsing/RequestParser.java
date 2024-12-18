package com.example.logparser.Parsing;

import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class

//HashMap<String, int> capitalCities = new HashMap<String, int>();

public class RequestParser implements Parser{
    private Parser nextParse;
    private String[] keywords = {"request_method", "request_url",
            "response_status", "response_time_ms"};
    ArrayList<String> logs = new ArrayList<>();
    private String[] translated;

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

    private String[] translateAllAPM(){
        translated = new String[]{};

        //Convert every text to APM JSON format
        for (String text: logs) {

        }
        return translated;
    }


}
