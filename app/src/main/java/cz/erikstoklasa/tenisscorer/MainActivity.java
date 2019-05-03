package cz.erikstoklasa.tenisscorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Agame;
    int Apoint;
    int Bgame;
    int Bpoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increacePointsA(View view) {
        if (Agame < 45)
            Agame += 15;
        else {
            Apoint += 1;
            Agame = 0;
            Bgame = 0;
        }
        display("A");
        display("B");
    }
    public void increacePointsB(View view) {
        if (Bgame < 45)
            Bgame += 15;
        else {
            Bpoint += 1;
            Bgame = 0;
            Agame = 0;
        }
        display("A");
        display("B");
    }
    private void display(String player){
        int resID = this.getResources().getIdentifier("player"+player+"score", "id", getPackageName());
        TextView tv = (TextView) findViewById(resID);
        if (player == "A"){
            tv.setText(Apoint+" P "+Agame+" G");
        }
        if (player == "B"){
            tv.setText(Bpoint+" P "+Bgame+" G");
        }
    }
    public void resetPoints(View view){
        Bgame = 0;
        Bpoint = 0;
        display("B");
        Agame = 0;
        Apoint = 0;
        display("A");
    }
}
