package com.example.stokl.tennisscore;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private TextView p1g;
    private TextView p2g;
    private TextView p1s;
    private TextView p2s;
    private TextView p1S;
    private TextView p2S;
    private Button p1b;
    private Button p2b;
    private Button reset;

    Court court = new Court();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Game TextBoxes
        p1g = findViewById(R.id.p1g);
        p2g = findViewById(R.id.p2g);
        //Set TextBoxes
        p1s = findViewById(R.id.p1s);
        p2s = findViewById(R.id.p2s);
        //Serve TextBoxes
        p1S = findViewById(R.id.p1S);
        p2S = findViewById(R.id.p2S);
        //Buttons
        p2b = findViewById(R.id.p2b);
        p1b = findViewById(R.id.p1b);
        reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                court.reset();
                p1g.setText(court.getPlayerOneScore());
                p2g.setText(court.getPlayerTwoScore());
                p1s.setText(court.getPlayerOneGameScore());
                p2s.setText(court.getPlayerTwoGameScore());
                setServe();

            }
        });

        p1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1g.setText(court.playerOneScored());
                p2g.setText(court.getPlayerTwoScore());
                p1s.setText(court.getPlayerOneGameScore());
                p2s.setText(court.getPlayerTwoGameScore());
                setServe();
            }
        });
        p2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2g.setText(court.playerTwoScored());
                p1g.setText(court.getPlayerOneScore());
                p1s.setText(court.getPlayerOneGameScore());
                p2s.setText(court.getPlayerTwoGameScore());
                setServe();
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
    private void setServe(){
        if (court.whoServes()==1){
            p1S.setVisibility(View.VISIBLE);
            p2S.setVisibility(View.GONE);
        } else{
            p1S.setVisibility(View.GONE);
            p2S.setVisibility(View.VISIBLE);
        }
    }
}
