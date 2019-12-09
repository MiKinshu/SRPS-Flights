package com.example.android.querymaster;
import android.util.Log;

import java.util.*;

//class Graph {
//    private Map<String, Vertex> MapOfVertices;
//    private Map<String, List<Edge>> graph;
//    private String prevTime = "0";
//    private String prevDate = "";
//    private Map<String, Boolean> Visited = new TreeMap<>();
//    private List<List<Flight>> ListOfSeriesOfFlights = new ArrayList<>();
//    private List<Flight> SeriesOfFlights = new ArrayList<>();
//    private Map<String, Boolean> VisitedFlight = new TreeMap<>();
//    String TAG="Sanky";
//
//    public Graph() {
//        MapOfVertices = new TreeMap<>();
//        graph = new TreeMap<>();
//    }
//
//    public List<Flight> traverseGraph (String Date, Flight flight, String From, String To) {
//        if (From.compareTo(To) == 0) {
//            //System.out.println("3. " + Path);
//            VisitedFlight.remove(flight.getCode());
//            return SeriesOfFlights;
//        }
//        if (graph.containsKey(From)) {
//
//            for (Edge e : graph.get(From)) {
//                if (!Visited.get(e.getTo())) {
//                    Log.d(TAG, "inside traverse " + e.getFrom() + " " + e.getTo() + " " + e.getListOfFlights().size());
//                    Visited.put(e.getTo(), false);
//                    //System.out.println("1. " + Path);
//                    for (Flight f : e.getListOfFlights()) {
//                        //f.getFlightDetails();
//                        if (!VisitedFlight.containsKey(f.getCode())) {
//                            //System.out.println("inin");
//                            VisitedFlight.put(f.getCode(), true);
//                            if (f.getStartTime().compareTo(prevTime) > 0 && f.getDateOfJourney().compareTo(Date) == 0 && f.getSeatAvailable() > 0) {
//                                //Path += e.getTo() + " ";
//                                //System.out.println("2. " + Path);
//                                prevTime = f.getEndTime();
//                                prevDate = f.getDateOfJourney();
//                                //System.out.println(e.getTo());
//                                SeriesOfFlights.add(f);
//                                for (Flight lf:SeriesOfFlights) {
//                                    Log.d(TAG, "inside traverse : Flight "+lf.getFrom()+" "+lf.getTo()+" "+lf.getCode());
//                                }
//                                return traverseGraph(Date, f, e.getTo(), To);
//
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public List<List<Flight>> getIndirectFlights(String Date, String From, String To) {    // mum,   kol
//        Log.d(TAG, "from and to in getIndirectFlights" + From + " " + To);
//        ListOfSeriesOfFlights.clear();
//        for (Edge e : graph.get(From)) {
//            Log.d(TAG, "edge details in getIndirectFlights" + e.getFrom() + " " + e.getTo() + " " + e.getListOfFlights().size());
//            for (Flight f : e.getListOfFlights()) {
//                SeriesOfFlights = null;
//                SeriesOfFlights = new ArrayList<>();
//                setVisited();
//                prevTime = "0";
//                prevDate = Date;
//                List<Flight> temp = traverseGraph(prevDate, null, From, To);
//                if (temp!=null) {
//                    for (Flight fi : temp) {
//                        Log.d(TAG, fi.getFrom() + " " + f.getTo() + " " + fi.getCode());
//                    }
//                }
//                Log.d(TAG, "null");
//                int i, cnt = 0;
//                if (temp != null) {
//                    if (ListOfSeriesOfFlights.size()==0) {
//                        ListOfSeriesOfFlights.add(temp);
//                    } else {
//                        for (List<Flight> list : ListOfSeriesOfFlights) {
//                            Log.d(TAG, "getIndirectFlights: temp size is "+temp.size()+" list size is "+list.size());
//                            for (i = 0; i < temp.size(); i++) {
//                                if (list.get(i).getCode().compareTo(temp.get(i).getCode()) == 0) {
//                                    break;
//                                }
//                            }
//                            if (i < temp.size()) {
//                                break;
//                            }
//                            cnt++;
//                        }
//                        if (cnt == ListOfSeriesOfFlights.size()) {
//                            ListOfSeriesOfFlights.add(temp);
//                        }
//                    }
//                }
//            }
//        }
//        return ListOfSeriesOfFlights;
//    }
//
//    public ArrayList<Flight> getModifiedListOfFlights(List<List<Flight>> ListOfSeriesFlights) {
//        ArrayList<Flight> ModifiedListOfFlights = new ArrayList<>();
//        for (List<Flight> lf:ListOfSeriesFlights) {
//            String from = "";
//            String ModifiedAirline = "";
//            String ModifiedDuration = "0";
//            int TotalCost = 0;
//            String to = lf.get(lf.size()-1).getTo();
//            for (int i = 0; i < lf.size(); i++) {
//                from += lf.get(i).getFrom();
//                ModifiedAirline += lf.get(i).getAirlineName();
//                ModifiedDuration = Integer.toString(Integer.parseInt(ModifiedDuration) + Integer.parseInt(lf.get(i).getDurationOfFlight()));
//                TotalCost += lf.get(i).getCost();
//                if (i!=lf.size()-1) {
//                    from += "->";
//                    ModifiedAirline += "->";
//                }
//            }
//            Flight f = new Flight("mixed", ModifiedAirline, from, to, ModifiedDuration, lf.get(0).getStartTime(), lf.get(lf.size()-1).getEndTime(), TotalCost, lf.get(0).getDateOfJourney());
//            ModifiedListOfFlights.add(f);
//        }
//        return ModifiedListOfFlights;
//    }
//
//    public ArrayList<Flight> getDirectFlights(String Date, String From, String To) {
//        ArrayList<Flight> list = new ArrayList<>();
//        if (graph.containsKey(From)) {
//            for (Edge e : graph.get(From)) {
//                if (e.getTo().compareTo(To) == 0) {
//                    for (Flight f:e.getListOfFlights()) {
//                        if (f.getDateOfJourney().compareTo(Date)==0) {
//                            list.add(f);
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }
//
//    public Map<String, Vertex> getMapOfVertices() {
//        return MapOfVertices;
//    }
//
//    public Map<String, List<Edge>> getGraph() {
//        return graph;
//    }
//
//
//    public String getPrevTime() {
//        return prevTime;
//    }
//
//    public void setVisited() {
//        for (String s:MapOfVertices.keySet()) {
//            Visited.put(s, false);
//        }
//    }
//
//    public void addNewFlight(Flight flight) {
////        addNewEdge(new Edge(flight.getFrom(), flight.getTo(), 456, ));
//        for (Edge e : graph.get(flight.getFrom())) {
//            if (e.getTo().compareTo(flight.getTo()) == 0) {
//                if (e.getListOfFlights() == null) {
//                    ArrayList<Flight> temp = new ArrayList<>();
//                    temp.add(flight);
//                    e.setListOfFlights(temp);
//                    break;
//                } else {
//                    e.getListOfFlights().add(flight);
//                    break;
//                }
//            }
//        }
//    }
//
//    public void addNewEdge(Edge edge) {
//        if (graph.containsKey(edge.getFrom())) {
//            graph.get(edge.getFrom()).add(edge);
//        } else {
//            List<Edge> temp = new ArrayList<>();
//            temp.add(edge);
//            graph.put(edge.getFrom(), temp);
//        }
//    }
//
//    public void addNewAirport(Vertex airport) {
//        MapOfVertices.put(airport.getName(), airport);
//    }
//
//    public void deleteAirport(Vertex airport) {
//        MapOfVertices.remove(airport.getName());
//    }
//
//    public void deleteFlight(Flight flight) {
//        boolean flag = false;
//        for (Edge e:graph.get(flight.getFrom())) {
//            for (Flight f:e.getListOfFlights()) {
//                if (f.getCode().compareTo(flight.getCode())==0) {
//                    e.getListOfFlights().remove(f);
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                break;
//            }
//        }
//    }
//
//    public void bookTicket(Flight flight, String DateOfJourney, int NumberOfPassengers) {
//        for (Edge e:graph.get(flight.getFrom())) {
//            for (Flight f:e.getListOfFlights()) {
//                if (f.getCode().compareTo(flight.getCode())==0) {
//                    f.setSeatAvailable(f.getSeatAvailable() - NumberOfPassengers);
//                }
//            }
//        }
//    }
//
//    public void cancelTicket(Flight flight, String DateOfJourney, int NumberOfPassengers) {
//        for (Edge e:graph.get(flight.getFrom())) {
//            for (Flight f:e.getListOfFlights()) {
//                if (f.getCode().compareTo(flight.getCode())==0) {
//                    f.setSeatAvailable(f.getSeatAvailable() + NumberOfPassengers);
//                }
//            }
//        }
//    }
//    // add new flight(flight)
//    // add new airport(vertex)
//    // delete airport(vertex)
//    // delete flight(flight)
//    // book ticket - to reduce a seat by 1(flight, DOJ)
//    // cancel ticket - +1
//}

class Graph {
    private Map<String, Vertex> MapOfVertices;
    private Map<String, List<Edge>> graph;
    private String prevTime = "0";
    private String prevDate = "";
    private Map<String, Boolean> isVisited = new TreeMap<>();
    private List<List<Flight>> ListOfSeriesOfFlights = new ArrayList<>();
    private List<Flight> SeriesOfFlights = new ArrayList<>();
    private Map<String, Boolean> isVisitedFlight = new TreeMap<>();

    public Graph() {
        MapOfVertices = new TreeMap<>();
        graph = new TreeMap<>();
    }

    public void traverseGraph(String Date, Flight flight, String From, String To) {
        if (From.compareTo(To) == 0) {
            isVisited.put(From, false);
            isVisitedFlight.put(flight.getCode(), false);
            List<Flight> temp = new ArrayList<>();
            for (Flight f:SeriesOfFlights) {
                temp.add(f);
            }
            ListOfSeriesOfFlights.add(temp);
            return;
        }
        if (graph.containsKey(From)) {
            for (Edge e : graph.get(From)) {
                if (!isVisited.get(e.getTo())) {
                    for (Flight f : e.getListOfFlights()) {
                        if (!isVisitedFlight.get(f.getCode())) {
                            isVisitedFlight.put(f.getCode(), true);

                            if (Integer.parseInt(f.getStartTime()) > Integer.parseInt(prevTime) && f.getDateOfJourney().compareTo(Date) == 0 && f.getSeatAvailable() > 0) {
                                String preTime = prevTime;
                                String preDate = prevDate;
                                prevTime = f.getEndTime();
                                prevDate = f.getDateOfJourney();

                                SeriesOfFlights.add(f);
                                traverseGraph(Date, f, e.getTo(), To);
                                SeriesOfFlights.remove(f);
                                prevDate = preDate;
                                prevTime = preTime;
                            }
                        }
                    }
                }
            }
        }
        isVisited.put(From, false);
    }

    public List<List<Flight>> getIndirectFlights(String Date, String From, String To) {    // mum,   kol
        ListOfSeriesOfFlights = new ArrayList<>();
        if (graph.containsKey(From)) {
            for (Edge e : graph.get(From)) {
                SeriesOfFlights = new ArrayList<>();
                setVisited();
                prevTime = "0";
                prevDate = Date;
                traverseGraph(prevDate, null, From, To);
            }
        }
        return ListOfSeriesOfFlights;
    }

    public ArrayList<Flight> getModifiedListOfFlights(List<List<Flight>> ListOfSeriesFlights) {
        Set<List<Flight>> SetOfIndirectFlights = new HashSet<>(ListOfSeriesFlights);
        ListOfSeriesFlights = new ArrayList<>();
        ListOfSeriesFlights.addAll(SetOfIndirectFlights);
        ArrayList<Flight> ModifiedListOfFlights = new ArrayList<>();
        for (List<Flight> lf:ListOfSeriesFlights) {
            if (lf != null && lf.size() > 1) {
                String from = "";
                String ModifiedAirline = "";
                String ModifiedDuration = "0";
                String ModifiedCode="";
                int TotalCost = 0;
                String to = lf.get(lf.size() - 1).getTo();
                for (int i = 0; i < lf.size(); i++) {
                    from += lf.get(i).getFrom();
                    ModifiedAirline += lf.get(i).getAirlineName();
                    ModifiedCode+=lf.get(i).getCode();
                    ModifiedDuration = Integer.toString(Integer.parseInt(ModifiedDuration) + Integer.parseInt(lf.get(i).getDurationOfFlight()));
                    TotalCost += lf.get(i).getCost();
                    if (i != lf.size() - 1) {
                        from += "->";
                        ModifiedAirline += "->";
                        ModifiedCode+=" ";
                    }
                }
                Flight f = new Flight(ModifiedCode, ModifiedAirline, from, to, ModifiedDuration, lf.get(0).getStartTime(), lf.get(lf.size() - 1).getEndTime(), TotalCost, lf.get(0).getDateOfJourney());
                ModifiedListOfFlights.add(f);
            }
        }
        return ModifiedListOfFlights;
    }

    public ArrayList<Flight> getDirectFlights(String Date, String From, String To) {
        ArrayList<Flight> list = new ArrayList<>();
        if (graph.containsKey(From)) {
            for (Edge e : graph.get(From)) {
                if (e.getTo().compareTo(To) == 0) {
                    for (Flight f:e.getListOfFlights()) {
                        if (f.getDateOfJourney().compareTo(Date)==0 && f.getSeatAvailable() > 0) {
                            list.add(f);
                        }
                    }
                }
            }
        }
        return list;
    }

    public Map<String, Vertex> getMapOfVertices() {
        return MapOfVertices;
    }

    public Map<String, List<Edge>> getGraph() {
        return graph;
    }


    public String getPrevTime() {
        return prevTime;
    }

    public void setVisited() {
        for (String s:MapOfVertices.keySet()) {
            isVisited.put(s, false);
            if (graph.containsKey(s)) {
                for (Edge e:graph.get(s)) {
                    for (Flight f:e.getListOfFlights()) {
                        isVisitedFlight.put(f.getCode(), false);
                    }
                }
            }
        }
    }

    public void addNewEdge(Edge edge) {
        if (graph.containsKey(edge.getFrom())) {
            int cnt = 0;
            for (Edge e:graph.get(edge.getFrom())) {
                if (e.getTo().compareTo(edge.getTo())==0) {
                    return;
                }
                cnt++;
            }
            if (cnt==graph.get(edge.getFrom()).size()) {
                graph.get(edge.getFrom()).add(edge);
            }
        } else {
            List<Edge> temp = new ArrayList<>();
            temp.add(edge);
            graph.put(edge.getFrom(), temp);
        }
    }

    public void addNewFlight(Flight flight) {
        addNewEdge(new Edge(flight.getFrom(), flight.getTo(), 500, null));
        for (Edge e : graph.get(flight.getFrom())) {
            if (e.getTo().compareTo(flight.getTo()) == 0) {
                if (e.getListOfFlights() == null) {
                    ArrayList<Flight> temp = new ArrayList<>();
                    temp.add(flight);
                    e.setListOfFlights(temp);
                    break;
                } else {
                    e.getListOfFlights().add(flight);
                    break;
                }
            }
        }
    }

    public void addNewAirport(Vertex airport) {
        MapOfVertices.put(airport.getName(), airport);
    }


    public void deleteAirport(Vertex airport) {
        MapOfVertices.remove(airport.getName());
        if (graph.keySet().contains(airport.getName())) {
            graph.remove(airport.getName());
        }
        for (List<Edge> le:graph.values()) {
            for (Edge e:le) {
                if (e.getTo().compareTo(airport.getName())==0) {
                    le.remove(e);
                }
            }
        }
    }

    public void deleteFlight(Flight flight) {
        boolean flag = false;
        for (Edge e:graph.get(flight.getFrom())) {
            for (Flight f:e.getListOfFlights()) {
                if (f.getCode().compareTo(flight.getCode())==0) {
                    e.getListOfFlights().remove(f);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public int bookTicket(Flight flight, String DateOfJourney, int NumberOfPassengers) {
        if (flight.getCode().contains(" ")) {
            String words[]=flight.getCode().split(" ");
            for(String s: words){
                int flag = 0;
                for(List<Edge>le:graph.values()) {
                    for (Edge e:le) {
                        for (Flight f:e.getListOfFlights()) {
                            if (f.getCode().compareTo(s)==0) {
                                f.setSeatAvailable(f.getSeatAvailable() - NumberOfPassengers);
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
        } else {
            for (Edge e : graph.get(flight.getFrom())) {
                for (Flight f : e.getListOfFlights()) {
                    if (f.getCode().compareTo(flight.getCode()) == 0) {
                        if (f.getSeatAvailable() - NumberOfPassengers > 0) {
                            f.setSeatAvailable(f.getSeatAvailable() - NumberOfPassengers);
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public void cancelTicket(Flight flight, String DateOfJourney, int NumberOfPassengers) {
        if (flight.getCode().contains(" ")) {
            String[] words = flight.getCode().split(" ");
            for(String s: words){
                int flag = 0;
                for(List<Edge>le:graph.values()) {
                    for (Edge e:le) {
                        for (Flight f:e.getListOfFlights()) {
                            if (f.getCode().compareTo(s)==0) {
                                f.setSeatAvailable(f.getSeatAvailable() + NumberOfPassengers);
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
        } else {
            int flag = 0;
            for (Edge e : graph.get(flight.getFrom())) {
                for (Flight f : e.getListOfFlights()) {
                    if (f.getCode().compareTo(flight.getCode()) == 0) {
                        f.setSeatAvailable(f.getSeatAvailable() + NumberOfPassengers);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
        }
    }
    // add new flight(flight)
    // add new airport(vertex)
    // delete airport(vertex)
    // delete flight(flight)
    // book ticket - to reduce a seat by 1(flight, DOJ)
    // cancel ticket - +1
}
