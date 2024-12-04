package com.example.logparser.Parsing;

public interface Parser {
    public void setNext(Parser p);
    public boolean handle(String textLine);
    public void createJSON();
}
