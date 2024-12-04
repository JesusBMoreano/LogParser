package com.example.logparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LogParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogParserApplication.class, args);
    }


    public static void readFile(String fileName){
        BufferedReader reader;

        // StringBuilder to hold the entire file content
        StringBuilder fileContent = new StringBuilder();

        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                fileContent.append(line).append("\n");
                line = reader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // Regex to capture log entries
        String regex = "(timestamp=[^\\n]*?)(?=timestamp=|$)";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(fileContent.toString());

        // List to every timestamp entry
        ArrayList<String> logEntries = new ArrayList<>();

        // Find matches
        while (matcher.find()) {
            logEntries.add(matcher.group(1).trim());
        }


        for (String entry : logEntries) {

        }
    }





}
