package com.example.android.querymaster;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import static com.example.android.querymaster.MainActivity.user;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {


    BookingAdapter.itemclicked2 activity;
    private ArrayList<Booking> bookings;

    public interface itemclicked2{
        void onItemClicked2(int indexOf);
    }

    public BookingAdapter(Context context, ArrayList<Booking> flights){
        bookings=flights;
        activity=(itemclicked2)context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView TVairlinename,TVsource, TVdestination, TVduration, TVdeparture, TVarrival, TVcost, TVDOJ, TVnop,TVstatus;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            TVairlinename=itemView.findViewById(R.id.textView4);
            TVsource=itemView.findViewById(R.id.textView5);
            TVdestination=itemView.findViewById(R.id.textView6);
            TVDOJ=itemView.findViewById(R.id.textView7);
            TVdeparture=itemView.findViewById(R.id.textView8);
            TVarrival=itemView.findViewById(R.id.textView9);
            TVduration=itemView.findViewById(R.id.textView10);
            TVcost=itemView.findViewById(R.id.textView11);
            TVnop=itemView.findViewById(R.id.textView12);
            TVstatus=itemView.findViewById(R.id.textView13);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked2(user.getBookedflights().indexOf((Booking) itemView.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public BookingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bookinglistitem,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(user.getBookedflights().get(i));
        viewHolder.TVairlinename.setText(user.getBookedflights().get(i).getAirline());
        viewHolder.TVsource.setText("Source: "+user.getBookedflights().get(i).getFromVertex());
        viewHolder.TVdestination.setText("Dest: "+user.getBookedflights().get(i).getToVertex());
        viewHolder.TVduration.setText("Time: "+user.getBookedflights().get(i).getDuration() + " hr");
        viewHolder.TVdeparture.setText("Depart: "+user.getBookedflights().get(i).getDeparture() +" hr");
        viewHolder.TVarrival.setText("Arri: "+user.getBookedflights().get(i).getArrival() + " hr");
        viewHolder.TVcost.setText("Cost: Rs."+user.getBookedflights().get(i).getFare()+"");
        viewHolder.TVDOJ.setText("DOJ: "+user.getBookedflights().get(i).getDateOfJourney());
        String s;
        if(user.getBookedflights().get(i).getBooked()){
            s="Booked";
        }
        else
            s="Cancelled";
        viewHolder.TVstatus.setText(s);
        viewHolder.TVnop.setText("No Of P: "+user.getBookedflights().get(i).getNoOfPassengers());
    }

    @Override
    public int getItemCount() {
        return user.getBookedflights().size();
    }
}
