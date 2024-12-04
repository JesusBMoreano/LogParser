package com.example.logparser.Logs;

public class APMLog implements Log{
    private String metricName;
    private double median;
    private double average;
    private double min;
    private double max;

    public APMLog(String metricName, double median, double average, double min, double max){
        this.metricName = metricName;
        this.median = median;
        this.average = average;
        this.max = max;
        this.min = min;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return String.format("\"%s\": {\n" +
                "        \"minimum\": %.2f,\n" +
                "        \"median\": %.2f,\n" +
                "        \"average\": %.2f,\n" +
                "        \"max\": %.2f\n" +
                "    }", metricName, min, median, average, max);    }
}

