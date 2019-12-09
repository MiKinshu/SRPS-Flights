package com.example.android.querymaster;

import static com.example.android.querymaster.MainActivity.graph;

public class Admin extends UserCredential {

    public Admin(String username, String password, String email, int age, int dateOfBirth, int contactNo, Boolean isAdmin) {
        Username = username;
        Password = password;
        Email = email;
        Age = age;
        DateOfBirth = dateOfBirth;
        ContactNo = contactNo;
        IsAdmin = isAdmin;
    }

    void addNewFlight(String code, String airlineName, String from, String to, String durationOfFlight, String startTime, String endTime, int cost, String date){
        Flight flight= new Flight(code,airlineName,from,to,durationOfFlight,startTime,endTime,cost,date);
        //calling graph methods
        graph.addNewFlight(flight);
    }

    void addNewAirport(String name, String code){
        Vertex vertex=new Vertex(name,code);
        //calling graph methods
        graph.addNewAirport(vertex);
    }

    void deleteAirport(String name, String code){
        Vertex vertex= new Vertex(name,code);
        //calling graph methods
        graph.deleteAirport(vertex);
    }

    void deleteFlight(String code, String airlineName, String from, String to, String durationOfFlight, String startTime, String endTime, int cost, String date){
        Flight flight= new Flight(code,airlineName,from,to,durationOfFlight,startTime,endTime,cost,date);
        //calling graph methods
        graph.deleteFlight(flight);
    }
}
