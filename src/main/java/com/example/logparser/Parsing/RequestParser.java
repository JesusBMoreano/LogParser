package com.example.logparser.Parsing;

import java.util.ArrayList;

public class RequestParser extends LogParser{
    private Parser nextParse;
    private String[] keywords = {"metric", "value"};
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

    public int percentileCal() {
        return 0;
    }
}
