package com.example.android.querymaster;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.querymaster.R;

import java.util.ArrayList;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder> {


    FlightAdapter.itemclicked activity;
    private ArrayList<Flight> directflights;
    public interface itemclicked{
        void onItemClicked(int index);
    }

    public FlightAdapter(Context context, ArrayList<Flight> flights){
        directflights=flights;
        activity=(itemclicked)context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView TVairlinename,TVsource, TVdestination, TVduration, TVdeparture, TVarrival, TVcost;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            TVairlinename=itemView.findViewById(R.id.TVairlinename);
            TVsource=itemView.findViewById(R.id.TVsource);
            TVdestination=itemView.findViewById(R.id.TVdestination);
            TVduration=itemView.findViewById(R.id.TVduration);
            TVdeparture=itemView.findViewById(R.id.TVdeparture);
            TVarrival=itemView.findViewById(R.id.TVarrival);
            TVcost=itemView.findViewById(R.id.TVcost);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(directflights.indexOf((Flight)itemView.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public FlightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(directflights.get(i));
        viewHolder.TVairlinename.setText(directflights.get(i).getAirlineName());
        viewHolder.TVsource.setText("Source: "+directflights.get(i).getFrom());
        viewHolder.TVdestination.setText("Dest: "+directflights.get(i).getTo());
        viewHolder.TVduration.setText("Time: "+directflights.get(i).getDurationOfFlight() + " hr");
        viewHolder.TVdeparture.setText("Depart: "+directflights.get(i).getStartTime() + " hr");
        viewHolder.TVarrival.setText("Arri: "+directflights.get(i).getEndTime() + " hr");
        viewHolder.TVcost.setText("Cost: Rs."+directflights.get(i).getCost()+"");
    }

    @Override
    public int getItemCount() {
        return directflights.size();
    }
}
