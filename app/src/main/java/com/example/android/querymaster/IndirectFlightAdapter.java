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

public class IndirectFlightAdapter extends RecyclerView.Adapter<IndirectFlightAdapter.ViewHolder> {


    IndirectFlightAdapter.itemclicked1 activity;
    private ArrayList<Flight> indirectflights;
    public interface itemclicked1{
        void onItemClicked1(int indexOf);
    }

    public IndirectFlightAdapter(Context context, ArrayList<Flight> flights){
        indirectflights=flights;
        activity=(itemclicked1)context;
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
                    activity.onItemClicked1(indirectflights.indexOf((Flight)itemView.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public IndirectFlightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IndirectFlightAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(indirectflights.get(i));
        viewHolder.TVairlinename.setText(indirectflights.get(i).getAirlineName());
        viewHolder.TVsource.setText("Source: "+indirectflights.get(i).getFrom());
        viewHolder.TVdestination.setText("Dest: "+indirectflights.get(i).getTo());
        viewHolder.TVduration.setText("Time: "+indirectflights.get(i).getDurationOfFlight()+" hr");
        viewHolder.TVdeparture.setText(" Depart:"+indirectflights.get(i).getStartTime()+" hr");
        viewHolder.TVarrival.setText("Arri: "+indirectflights.get(i).getEndTime()+" hr");
        viewHolder.TVcost.setText("Cost: Rs."+indirectflights.get(i).getCost()+"");
    }

    @Override
    public int getItemCount() {
        return indirectflights.size();
    }
}
