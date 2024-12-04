package com.example.logparser.Calculators;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;

public class Calculator {
    private DescriptiveStatistics stats;

    public Calculator(ArrayList<Integer> nums){
        // Convert ArrayList to array
        double[] data = nums.stream().mapToDouble(Integer::doubleValue).toArray();

        // Using Apache Commons Math
        stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
    }

    public double average(){
        return stats.getMean();
    }
    public double min(){
        return stats.getMin();
    }

    public double max(){
        return stats.getMax();
    }
    public double median(){
        return stats.getPercentile(50);  // 50th percentile is the median
    }
    public double getPercentileNinety(){
        return stats.getPercentile(90);
    }

    public double getPercentileNinetyFive() {
        return stats.getPercentile(95);
    }

    public double getPercentileNinetyNine() {
        return stats.getPercentile(99);
    }

}
