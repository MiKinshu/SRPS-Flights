package com.example.android.querymaster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.querymaster.MainActivity.graph;
import static com.example.android.querymaster.MainActivity.user;

public class ConfirmBooking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    int NoOfPassengers;
    int cost=12;
    TextView TVtotalcost;
    Button OKAY, CANCEL;
    int TC;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        String type=intent.getStringExtra("type");
        final String from=intent.getStringExtra("from");
        final String to=intent.getStringExtra("to");
        final String doj=intent.getStringExtra("doj");
        cost=Integer.parseInt(intent.getStringExtra("fare"));
        final String duration=intent.getStringExtra("duration");
        final String code=intent.getStringExtra("code");
        final String airline=intent.getStringExtra("airline");
        final String ST=intent.getStringExtra("starttime");
        final String ET=intent.getStringExtra("endtime");

        setContentView(R.layout.activity_confirm_booking);
        Spinner spinner= findViewById(R.id.spinner);
        TVtotalcost=findViewById(R.id.TVtotalcost);
        OKAY=findViewById(R.id.button6);
        CANCEL=findViewById(R.id.button4);
        String[] spinnerBatchlist={"1","2","3","4","5","6"};
        ArrayAdapter<String> spinnerBatchAdapter= new ArrayAdapter<>(ConfirmBooking.this, android.R.layout.simple_list_item_1,spinnerBatchlist);
        spinnerBatchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerBatchAdapter);
        spinner.setOnItemSelectedListener(this);

        OKAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(graph.bookTicket(new Flight(code,"",from,"","","","",0,""),doj,NoOfPassengers)==1){
                    Booking booking = new Booking(true,from,to,
                            doj,"AAJkidinank",TC,
                            duration,"Paise_hee_paisa",code,
                            airline,ST,
                            ET,NoOfPassengers);
                    user.getBookedflights().add(booking);

                    Toast.makeText(ConfirmBooking.this, "Booked. हमारी सेवा का प्रयोग करने के लिए धन्यवाद|", Toast.LENGTH_SHORT).show();
                    ConfirmBooking.this.finish();
                }
                else {
                    new AlertDialog.Builder(ConfirmBooking.this)
                            .setTitle("Seat Unavailable")
                .setMessage("The asked no of seats are not available. Please look for alternative flight.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
                }

            }
        });

        CANCEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmBooking.this.finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId()==R.id.spinner){
            NoOfPassengers=Integer.parseInt(parent.getItemAtPosition(position).toString());
            TC=NoOfPassengers*cost;
            TVtotalcost.setText("Total cost is :"+TC+" Rs. ");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
