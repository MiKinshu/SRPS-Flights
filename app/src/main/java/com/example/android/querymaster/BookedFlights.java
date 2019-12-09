package com.example.android.querymaster;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.querymaster.MainActivity.graph;
import static com.example.android.querymaster.MainActivity.user;

public class BookedFlights extends AppCompatActivity implements BookingAdapter.itemclicked2 {


    RecyclerView recyclerview;
    RecyclerView.Adapter myadapter;
    RecyclerView.LayoutManager layoutManager;

    final ArrayList<Booking> ListOfBooking = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_flights);
        recyclerview = (RecyclerView) findViewById(R.id.booked);
        recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(myadapter);

        myadapter = new BookingAdapter(BookedFlights.this, ListOfBooking);
        recyclerview.setAdapter(myadapter);
    }

    @Override
    public void onItemClicked2(final int indexOf) {
        if (user.getBookedflights().get(indexOf).getBooked() == false) {
            Toast.makeText(this, "This ticket has already been cancelled once.", Toast.LENGTH_SHORT).show();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Cancel Booking")
                    .setMessage("Are you sure you want to Cancel this flight")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                            user.getBookedflights().get(indexOf).setBooked(Boolean.FALSE);
                            graph.cancelTicket(new Flight(user.getBookedflights().get(indexOf).getFlightCode(), "asd", user.getBookedflights().get(indexOf).getFromVertex(), "asd", "asd", "asd", "asd", 0, "asd"), user.getBookedflights().get(indexOf).getDateOfJourney(), user.getBookedflights().get(indexOf).getNoOfPassengers());
                            myadapter.notifyDataSetChanged();
                            Toast.makeText(BookedFlights.this, "Cancelled", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
