package com.example.logparser.Parsing;

abstract class LogParser implements Parser{
    private Parser nextParse;
    private String[] keywords = {};
    private String[] logs = new String[]{};
    private String[] translated;

    @Override
    public void setNext(Parser p){
        nextParse = p;
    }

    @Override
    public void createJSON() {

    }
}
