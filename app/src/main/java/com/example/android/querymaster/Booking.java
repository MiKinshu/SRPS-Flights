package com.example.android.querymaster;

public class Booking {
    Boolean Booked;
    String FromVertex, ToVertex, DateOfJourney, DateOfBooking;
    int Fare;
    String Duration;
    String TransactionID;
    String FlightCode;
    String Airline;
    String Departure, Arrival;
    int NoOfPassengers;

    public Booking(Boolean booked, String fromVertex, String toVertex, String dateOfJourney, String dateOfBooking, int fare, String duration, String transactionID, String flightCode, String airline, String departure, String arrival, int noOfPassengers) {
        Booked = booked;
        FromVertex = fromVertex;
        ToVertex = toVertex;
        DateOfJourney = dateOfJourney;
        DateOfBooking = dateOfBooking;
        Fare = fare;
        Duration = duration;
        TransactionID = transactionID;
        FlightCode = flightCode;
        Airline = airline;
        Departure = departure;
        Arrival = arrival;
        NoOfPassengers = noOfPassengers;
    }

    public Boolean getBooked() {
        return Booked;
    }

    public void setBooked(Boolean booked) {
        Booked = booked;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public String getFromVertex() {
        return FromVertex;
    }

    public void setFromVertex(String fromVertex) {
        FromVertex = fromVertex;
    }

    public String getToVertex() {
        return ToVertex;
    }

    public void setToVertex(String toVertex) {
        ToVertex = toVertex;
    }

    public String getDateOfJourney() {
        return DateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        DateOfJourney = dateOfJourney;
    }

    public String getDateOfBooking() {
        return DateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        DateOfBooking = dateOfBooking;
    }

    public int getFare() {
        return Fare;
    }

    public void setFare(int fare) {
        Fare = fare;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        TransactionID = transactionID;
    }

    public String getFlightCode() {
        return FlightCode;
    }

    public void setFlightCode(String flightCode) {
        FlightCode = flightCode;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public int getNoOfPassengers() {
        return NoOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        NoOfPassengers = noOfPassengers;
    }
}
