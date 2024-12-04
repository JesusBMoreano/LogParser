package com.example.logparser.RequestComponents;

import java.util.ArrayList;

import com.example.logparser.Calculators.Calculator;

public class ResponseTimes {
    private ArrayList<Integer> nums;
    private Calculator cal;
    private int min;
    private int max;
    private double fifty;
    private double ninety;
    private double ninetyFive;
    private double ninetyNine;


    public ResponseTimes(ArrayList<Integer> nums){
        this.nums = nums;
        cal = new Calculator(nums);
        min = (int) Math.round(cal.min());
        max = (int) Math.round(cal.max());
        fifty = cal.average();
        ninety = cal.percentileNinety();
        ninetyFive = cal.getPercentileNinetyFive();
        ninetyNine = cal.getPercentileNinetyNine();
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getFifty() {
        return fifty;
    }
    public double getNinety() {
        return ninety;
    }

    public double getNinetyFive() {
        return ninetyFive;
    }

    public double getNinetyNine() {
        return ninetyNine;
    }

    @Override
    public String toString() {
        return "\"response_times\": {\n" +
                "    \"min\": " + min + ",\n" +
                "    \"50_percentile\": " + fifty + ",\n" +
                "    \"90_percentile\": " + ninety + ",\n" +
                "    \"95_percentile\": " + ninetyFive + ",\n" +
                "    \"99_percentile\": " + ninetyNine + ",\n" +
                "    \"max\": " + max + "\n" +
                "}";
    }
}
