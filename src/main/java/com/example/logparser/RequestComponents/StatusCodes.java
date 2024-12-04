package com.example.logparser.RequestComponents;

import java.util.HashMap;

public class StatusCodes {
    private HashMap<String,Integer> nums;

    private static String[] KEYS = {"2XX", "4XX", "5XX"};

    public StatusCodes(HashMap<String, Integer> nums){
        this.nums = nums;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\"status_codes\": {\n");
        for (int i = 0; i < KEYS.length; i++) {
            String key = KEYS[i];
            Integer value = nums.getOrDefault(key, 0); // Use default value 0 if key is not present
            result.append("    \"").append(key).append("\": ").append(value);
            if (i < KEYS.length - 1) {
                result.append(",\n"); // Add a comma except for the last key-value pair
            } else {
                result.append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
