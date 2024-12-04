package com.example.logparser.Calculators;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;

public class APMCalculator {
    private DescriptiveStatistics stats;

    public APMCalculator(ArrayList<Integer> nums){
        // Convert ArrayList to array
        double[] data = nums.stream().mapToDouble(Integer::doubleValue).toArray();

        // Using Apache Commons Math
        stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
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

    public double average(){
        return stats.getMean();
    }
}
