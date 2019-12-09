package com.example.android.querymaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //request codes for ActivityResult
    private static final int RC_SIGN_IN = 1;
    Boolean LoggedIn=false;
    String TAG="MyLOGS";
    public static Graph graph = new Graph();
    Map<String, List<Edge>> MapOfEdges = graph.getGraph();
    Map<String, Vertex> ListOfVertices = graph.getMapOfVertices();
    Button BTNSearch,BTNadmin,BTNbookings,BTNlogout;
    public static HashMap<String ,UserCredential> RegUsers= new HashMap<>();
    public static UserCredential user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RegUsers.put("test1",new Admin("test1","123456","techodope@gmail.com",69,696969,6967,true));
        RegUsers.put("test2",new Admin("test2","123456","techodope@gmail.com",69,696969,6967,false));
        {
            //addind dummy data
            graph.addNewAirport(new Vertex("Mumbai", "MUM"));
            graph.addNewAirport(new Vertex("Delhi", "NDLS"));
            graph.addNewAirport(new Vertex("Kolkata", "KOL"));
            graph.addNewAirport(new Vertex("Chennai","CHN"));
            graph.addNewAirport(new Vertex("Bhopal", "BPL"));

            graph.addNewFlight(new Flight("f11", "Vistara", "Mumbai", "Delhi", "2", "1", "3", 1200, "27:11:2019"));
            graph.addNewFlight(new Flight("f12", "Vistara", "Mumbai", "Delhi", "2", "2", "4", 1200, "28:11:2019"));
            graph.addNewFlight(new Flight("f13", "Vistara", "Mumbai", "Delhi", "2", "1", "3", 1200, "28:11:2019"));
            graph.addNewFlight(new Flight("f14", "Vistara", "Mumbai", "Delhi", "2", "1", "3", 1200, "29:11:2019"));
            graph.addNewFlight(new Flight("f15", "Vistara", "Mumbai", "Delhi", "2", "2", "4", 1200, "30:11:2019"));

            graph.addNewFlight(new Flight("f21", "IndiGo", "Delhi", "Kolkata", "3", "5", "8", 1500, "27:11:2019"));
            graph.addNewFlight(new Flight("f22", "IndiGo", "Delhi", "Kolkata","3", "5", "8", 1500, "28:11:2019"));
            graph.addNewFlight(new Flight("f23", "IndiGo", "Delhi", "Kolkata","3", "6", "9", 1500, "28:11:2019"));

            graph.addNewFlight(new Flight("f31", "Jet", "Mumbai", "Chennai", "2", "2", "4", 1800, "27:11:2019"));
            graph.addNewFlight(new Flight("f32", "Jet", "Mumbai", "Chennai", "3", "5", "8", 1800, "28:11:2019"));
            graph.addNewFlight(new Flight("f33", "Jet", "Mumbai", "Chennai", "2", "6", "8", 1800, "29:11:2019"));

            graph.addNewFlight(new Flight("f41", "GoAir", "Chennai", "Kolkata", "3", "5", "8", 1500, "27:11:2019"));
            graph.addNewFlight(new Flight("f42", "GoAir", "Chennai", "Kolkata", "3", "5", "8", 1500, "28:11:2019"));
            graph.addNewFlight(new Flight("f43", "GoAir", "Chennai", "Kolkata", "2", "6", "8", 1500, "28:11:2019"));

            graph.addNewFlight(new Flight("f51", "GoAir", "Delhi", "Bhopal", "3", "8", "11", 1500, "27:11:2019"));
            graph.addNewFlight(new Flight("f52", "GoAir", "Delhi", "Bhopal", "3", "8", "11", 1500, "28:11:2019"));
            graph.addNewFlight(new Flight("f53", "GoAir", "Delhi", "Bhopal", "3", "8", "11", 1500, "28:11:2019"));
            graph.addNewFlight(new Flight("f54", "GoAir", "Delhi", "Bhopal", "3", "7", "10", 1500, "27:11:2019"));

            graph.addNewFlight(new Flight("f61", "Jet", "Mumbai", "Kolkata", "3", "7", "10", 1500, "27:11:2019"));

        }
        if(!LoggedIn) {
            Intent intent = new Intent(MainActivity.this, com.example.android.querymaster.Login_Activity.class);
            startActivityForResult(intent, RC_SIGN_IN);
        }
        BTNSearch=findViewById(R.id.button);
        BTNSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.android.querymaster.FindFlights.class);
                startActivity(intent);
            }
        });

        BTNadmin=findViewById(R.id.button3);
        BTNadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.IsAdmin) {
                    Intent intent = new Intent(MainActivity.this, com.example.android.querymaster.AdminAct.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Sorry, only Admins can access this feature.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BTNbookings=findViewById(R.id.button2);
        BTNbookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.android.querymaster.BookedFlights.class);
                startActivity(intent);
            }
        });

        BTNlogout=findViewById(R.id.button7);
        BTNlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.android.querymaster.Login_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult: In ActivityResult.");
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            if(resultCode==RESULT_CANCELED) {
                Toast.makeText(this, "Cannot work until you Sign-In", Toast.LENGTH_SHORT).show();
                finish();
            }
            if(resultCode==RESULT_OK){
                Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT).show();
                LoggedIn=true;
            }
        }
        Log.d(TAG, "onActivityResult: Exiting ActivityResult");
    }
}
