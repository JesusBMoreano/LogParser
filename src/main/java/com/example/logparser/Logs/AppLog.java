package com.example.logparser.Logs;

public class AppLog implements Log{
    private String cond;
    private int count;

    public AppLog(String cond, int count){
        this.cond = cond;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    @Override
    public String toString() {
        return cond + ": " +count;
    }
}
