package com.tradinos.mzn.models;

import java.util.ArrayList;

public class FormData {


    ArrayList <FormData.EventType> event_types;
    ArrayList <FormData.Service> services;
    private float VAT;
    private String start;
    private String end;
    ArrayList <CardType> cards;
    ArrayList <City> city;
    ArrayList <TimeBlock> time_blocks;
    ArrayList <FormData.AreaOfVase> areas_of_vase;

    public ArrayList<FormData.EventType> getEvent_types() {
        return event_types;
    }

    public void setEvent_types(ArrayList<FormData.EventType> event_types) {
        this.event_types = event_types;
    }

    public ArrayList<FormData.Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<FormData.Service> services) {
        this.services = services;
    }

    public float getVAT() {
        return VAT;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
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

    public ArrayList<CardType> getCardTypes() {
        return cards;
    }

    public void setCardTypes(ArrayList<CardType> cardTypes) {
        this.cards = cardTypes;
    }

    public ArrayList<City> getCity() {
        return city;
    }

    public void setCity(ArrayList<City> city) {
        this.city = city;
    }

    public ArrayList<TimeBlock> getTime_blocks() {
        return time_blocks;
    }

    public void setTime_blocks(ArrayList<TimeBlock> time_blocks) {
        this.time_blocks = time_blocks;
    }

    public ArrayList<FormData.AreaOfVase> getAreas_of_vase() {
        return areas_of_vase;
    }

    public void setAreas_of_vase(ArrayList<FormData.AreaOfVase> areas_of_vase) {
        this.areas_of_vase = areas_of_vase;
    }

    class EventType{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Service{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    class AreaOfVase{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
}
