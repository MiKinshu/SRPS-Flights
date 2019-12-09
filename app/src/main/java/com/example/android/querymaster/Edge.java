package com.example.android.querymaster;

import java.util.ArrayList;
import java.util.List;

class Edge {
    private String From;
    private String To;
    private int distance;
    private ArrayList<Flight> ListOfFlights = new ArrayList<>();

    public Edge(String from, String to, int distance, ArrayList<Flight> listOfFlights) {
        From = from;
        To = to;
        this.distance = distance;
        ListOfFlights = listOfFlights;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public int getDistance() {
        return distance;
    }

    public List<Flight> getListOfFlights() {
        return ListOfFlights;
    }

    public void setFrom(String from) {
        From = from;
    }

    public void setTo(String to) {
        To = to;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setListOfFlights(ArrayList<Flight> listOfFlights) {
        ListOfFlights = listOfFlights;
    }
}
