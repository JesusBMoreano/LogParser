package com.example.logparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

@SpringBootApplication
public class LogParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogParserApplication.class, args);
    }

    public static void readFile(){
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
