package com.tradinos.mzn.models;

public class TimeBlock {

    private int id;
    private String start;
    private String end;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getAsString(){
        return start.substring(0,2) + " To " + end.substring(0,2);
    }
}
