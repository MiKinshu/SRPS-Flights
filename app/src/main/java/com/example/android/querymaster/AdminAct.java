package com.example.android.querymaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.android.querymaster.MainActivity.user;

public class AdminAct extends AppCompatActivity {


    EditText ETFlightCode,ETFlightname, ETfrom, ETto, ETdeparture, ETarrival, ETcost, ETdate, ETAIrportname, ETAirportcode;
    Button BTNaddflight, BTNaddairport, BTNdeleteflight, BTNdeleteairport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ETarrival=findViewById(R.id.ETarrival);
        ETFlightCode=findViewById(R.id.ETcode);
        ETFlightname=findViewById(R.id.ETairline);
        ETfrom=findViewById(R.id.ETto);
        ETto=findViewById(R.id.ETfrom);
        ETdeparture=findViewById(R.id.ETdeparture);
        ETcost=findViewById(R.id.ETcost);
        ETdate=findViewById(R.id.ETdate);
        ETAIrportname=findViewById(R.id.ETairportname);
        ETAirportcode=findViewById(R.id.ETairportcode);
        BTNaddairport=findViewById(R.id.BTNaddairport);
        BTNaddflight=findViewById(R.id.BTNaddFlight);
        BTNdeleteflight=findViewById(R.id.BTNdeleteflight);
        BTNdeleteairport=findViewById(R.id.BTNdeleteairport);
        BTNaddairport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ETAIrportname.getText().toString();
                String code= ETAirportcode.getText().toString();
                ((Admin)user).addNewAirport(name,code);
                Toast.makeText(AdminAct.this, "Airport Added!", Toast.LENGTH_SHORT).show();
            }
        });

        BTNaddflight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arrival=Integer.parseInt(ETarrival.getText().toString());
                String flightcode=ETFlightCode.getText().toString();
                String flightname=ETFlightname.getText().toString();
                String from=ETfrom.getText().toString();
                String to=ETto.getText().toString();
                int departure=Integer.parseInt(ETdeparture.getText().toString());
                int cost=Integer.parseInt(ETcost.getText().toString());
                String date=ETdate.getText().toString();
                ((Admin)user).addNewFlight(flightcode,flightname,from,to,arrival-departure+"",departure+"",arrival+"",cost,date);
                Toast.makeText(AdminAct.this, "Flight Added!", Toast.LENGTH_SHORT).show();
            }
        });

        BTNdeleteflight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arrival=Integer.parseInt(ETarrival.getText().toString());
                String flightcode=ETFlightCode.getText().toString();
                String flightname=ETFlightname.getText().toString();
                String from=ETfrom.getText().toString();
                String to=ETto.getText().toString();
                int departure=Integer.parseInt(ETdeparture.getText().toString());
                int cost=Integer.parseInt(ETcost.getText().toString());
                String date=ETdate.getText().toString();
                ((Admin)user).deleteFlight(flightcode,flightname,from,to,departure-arrival+"",departure+"",arrival+"",cost,date);
                Toast.makeText(AdminAct.this, "Flight Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        BTNdeleteairport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ETAIrportname.getText().toString();
                String code= ETAirportcode.getText().toString();
                ((Admin)user).deleteAirport(name,code);
                Toast.makeText(AdminAct.this, "Airport Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
