package com.tradinos.mzn.models;

import java.util.ArrayList;

public class Category {

    private String name;
    private String subtitle;
    private ArrayList<Arrangement> arrangementsList;
    private boolean expanded = false;

    public Category(String name, String subtitle, ArrayList<Arrangement> arrangementsList) {
        this.name = name;
        this.subtitle = subtitle;
        this.arrangementsList = arrangementsList;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public ArrayList<Arrangement> getArrangementsList() {
        return arrangementsList;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
