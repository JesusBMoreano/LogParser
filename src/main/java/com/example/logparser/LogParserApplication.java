package com.example.logparser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class LogParserApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LogParserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input;
        String fileName = null;

        boolean correctFmt = false;

        // Prompt the user to enter the file name in the correct format
        while (!correctFmt) {
            System.out.print("Please enter the file to parse in the format '-- filename.txt': ");
            input = scanner.nextLine();

            // Validate the input format
            if (input.startsWith("-- ") && input.split(" ").length == 2) {
                fileName = input.split(" ")[1]; // Extract the file name
                if (!fileName.endsWith(".txt")) {
                    System.err.println("Error: The file must have a .txt extension. Try again.");
                } else {
                    correctFmt = true; // Input is valid
                }
            } else {
                System.err.println("Error: Invalid format. Please type '-- filename.txt'.");
            }
        }

        System.out.println("Processing file: " + fileName);

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
