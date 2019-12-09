package com.example.android.querymaster;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.querymaster.MainActivity.graph;
import static com.example.android.querymaster.MainActivity.user;


public class FindFlights extends AppCompatActivity implements FlightAdapter.itemclicked, IndirectFlightAdapter.itemclicked1{

    RecyclerView recyclerview;
    RecyclerView.Adapter myadapter;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerview1;
    RecyclerView.Adapter myadapter1;
    RecyclerView.LayoutManager layoutManager1;

    EditText ETsource;
    EditText ERdestination;
    EditText BTNdate;
    Button Search;
    String TAG="lawda mera";
    String date;
    final ArrayList<Flight> ListOfDirectFlights=new ArrayList<>();
    final ArrayList<Flight> ListOfIndirectFlights= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_flights);
        recyclerview = (RecyclerView) findViewById(R.id.list);
        recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(myadapter);

        recyclerview1 = (RecyclerView) findViewById(R.id.indirectflights);
        recyclerview1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this);
        recyclerview1.setLayoutManager(layoutManager1);
        recyclerview1.setHasFixedSize(true);
        recyclerview1.setAdapter(myadapter1);


        ETsource=findViewById(R.id.ETsource);
        ERdestination=findViewById(R.id.ETdestination);
        BTNdate=findViewById(R.id.date);
        Search=findViewById(R.id.button5);


        myadapter = new FlightAdapter(FindFlights.this,ListOfDirectFlights);
        recyclerview.setAdapter(myadapter);

        myadapter1= new IndirectFlightAdapter(FindFlights.this,ListOfIndirectFlights);
        recyclerview1.setAdapter(myadapter1);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromv=ETsource.getText().toString();
                String tov=ERdestination.getText().toString();
                date=BTNdate.getText().toString();

                ListOfDirectFlights.clear();
                myadapter.notifyDataSetChanged();

                ArrayList<Flight> temp=graph.getDirectFlights(date,fromv, tov);
                graph.setVisited();
                ListOfDirectFlights.addAll(temp);
                myadapter.notifyDataSetChanged();

//                for(Flight f : ListOfIndirectFlights){
//                    f=null;
//                }
                ListOfIndirectFlights.clear();
                Log.d(TAG, "onClick: Cleared. size is "+ListOfIndirectFlights.size());
                myadapter1.notifyDataSetChanged();
                Log.d(TAG, "onClick: fromv is "+fromv+" tov is "+tov);
//                Log.d(TAG, "onClick: Size of indeirectm ights is "+graph.getIndirectFlights(date, fromv, tov).size());
//                List<List<Flight>> listoflst=graph.getIndirectFlights(date, fromv, tov);
//                for(List<Flight> l : listoflst){
//                    for(Flight lf : l){
//                        Log.d(TAG, "onClick: Flightd "+lf.getFrom()+" "+lf.getTo()+" "+lf.getCode());
//                    }
//                }
                ListOfIndirectFlights.addAll(graph.getModifiedListOfFlights(graph.getIndirectFlights(date, fromv, tov)));
                //ListOfIndirectFlights.removeAll(ListOfDirectFlights);
                Log.d(TAG, "onClick: Cleared size is "+ListOfIndirectFlights.size());
                myadapter1.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void onItemClicked(final int index) {
//        new AlertDialog.Builder(this)
//                .setTitle("Make Booking")
//                .setMessage("Are you sure you want to Book this flight")
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Continue with delete operation
//                        Booking booking = new Booking(true,ListOfDirectFlights.get(index).getFrom(),ListOfDirectFlights.get(index).getTo(),
//                                ListOfDirectFlights.get(index).getDateOfJourney(),date,ListOfDirectFlights.get(index).getCost(),
//                                ListOfDirectFlights.get(index).getDurationOfFlight(),"Paise_hee_paisa",ListOfDirectFlights.get(index).getCode(),ListOfDirectFlights.get(index).getAirlineName(),ListOfDirectFlights.get(index).getStartTime(),
//                                ListOfDirectFlights.get(index).getEndTime(),1);
//                        user.getBookedflights().add(booking);
//
//                    }
//                })
//                .setNegativeButton(android.R.string.no, null)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show();
        Intent intent = new Intent(FindFlights.this, com.example.android.querymaster.ConfirmBooking.class);
        intent.putExtra("type", "DI");
        intent.putExtra("from", ListOfDirectFlights.get(index).getFrom());
        intent.putExtra("to",ListOfDirectFlights.get(index).getTo());
        intent.putExtra("doj",ListOfDirectFlights.get(index).getDateOfJourney());
        intent.putExtra("fare",ListOfDirectFlights.get(index).getCost()+"");
        intent.putExtra("duration",ListOfDirectFlights.get(index).getDurationOfFlight());
        intent.putExtra("code",ListOfDirectFlights.get(index).getCode());
        intent.putExtra("airline",ListOfDirectFlights.get(index).getAirlineName());
        intent.putExtra("starttime",ListOfDirectFlights.get(index).getStartTime());
        intent.putExtra("endtime",ListOfDirectFlights.get(index).getEndTime());
        startActivity(intent);
    }

    @Override
    public void onItemClicked1(final int index) {
//        new AlertDialog.Builder(this)
//                .setTitle("Make Booking")
//                .setMessage("Are you sure you want to Book this flight")
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Continue with delete operation
//                            Booking booking = new Booking(true,ListOfIndirectFlights.get(index).getFrom(),ListOfIndirectFlights.get(index).getTo(),
//                                    ListOfIndirectFlights.get(index).getDateOfJourney(),date,ListOfIndirectFlights.get(index).getCost(),
//                                    ListOfIndirectFlights.get(index).getDurationOfFlight(),"Paise_hee_paisa",ListOfIndirectFlights.get(index).getCode(),
//                                    ListOfIndirectFlights.get(index).getAirlineName(),ListOfIndirectFlights.get(index).getStartTime(),
//                                    ListOfIndirectFlights.get(index).getEndTime(),1);
//                            user.getBookedflights().add(booking);
//                    }
//                })
//                .setNegativeButton(android.R.string.no, null)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show();

        Intent intent = new Intent(FindFlights.this, com.example.android.querymaster.ConfirmBooking.class);
        intent.putExtra("type", "IND");
        intent.putExtra("from", ListOfIndirectFlights.get(index).getFrom());
        intent.putExtra("to",ListOfIndirectFlights.get(index).getTo());
        intent.putExtra("doj",ListOfIndirectFlights.get(index).getDateOfJourney());
        intent.putExtra("fare",ListOfIndirectFlights.get(index).getCost()+"");
        intent.putExtra("duration",ListOfIndirectFlights.get(index).getDurationOfFlight());
        intent.putExtra("code",ListOfIndirectFlights.get(index).getCode());
        intent.putExtra("airline",ListOfIndirectFlights.get(index).getAirlineName());
        intent.putExtra("starttime",ListOfIndirectFlights.get(index).getStartTime());
        intent.putExtra("endtime",ListOfIndirectFlights.get(index).getEndTime());
        startActivity(intent);
    }
}
