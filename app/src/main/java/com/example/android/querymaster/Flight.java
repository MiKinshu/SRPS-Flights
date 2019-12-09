package com.example.android.querymaster;

import java.util.Map;
import java.util.TreeMap;

class Flight {
    private String Code;
    private String AirlineName;
    private String From;
    private String To;
    private String DurationOfFlight;
    private String StartTime;
    private String EndTime;
    private int Cost;
    private String DateOfJourney;
    private int SeatAvailable;

    public Flight(String code, String airlineName, String from, String to, String durationOfFlight, String startTime, String endTime, int cost, String dateOfJourney) {
        Code = code;
        AirlineName = airlineName;
        From = from;
        To = to;
        DurationOfFlight = durationOfFlight;
        StartTime = startTime;
        EndTime = endTime;
        Cost = cost;
        DateOfJourney = dateOfJourney;
        SeatAvailable = 10;
    }

    public String getCode() {
        return Code;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public String getDurationOfFlight() {
        return DurationOfFlight;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public int getCost() {
        return Cost;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setAirlineName(String airlineName) {
        AirlineName = airlineName;
    }

    public void setFrom(String from) {
        From = from;
    }

    public void setTo(String to) {
        To = to;
    }

    public void setDurationOfFlight(String durationOfFlight) {
        DurationOfFlight = durationOfFlight;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public void setDateOfJourney(String dateOfJourney) {
        DateOfJourney = dateOfJourney;
    }

    public void setSeatAvailable(int seatAvailable) {
        SeatAvailable = seatAvailable;
    }

    public String getDateOfJourney() {
        return DateOfJourney;
    }

    public int getSeatAvailable() {
        return SeatAvailable;
    }

    public void getFlightDetails () {
        System.out.println(this.getFrom() + " "  + this.getTo() + " " + this.getCode() + " " + this.getAirlineName() + " " + this.getDateOfJourney() + " " +this.getStartTime() + " " + this.getEndTime() + " " + this.getDurationOfFlight());
    }
}