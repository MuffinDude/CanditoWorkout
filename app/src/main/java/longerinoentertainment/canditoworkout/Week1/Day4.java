package longerinoentertainment.canditoworkout.Week1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class Day4 extends Fragment {
    Button stopper;
    Button squat1;
    Button squat2;
    Button squat3;
    Button squat4;
    Button dead1;
    Button dead2;
    Chronometer chronometer;
    private long timeWhenStopped = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day4, container, false);

        stopper = (Button) infoTab.findViewById(R.id.stopperButton);
        chronometer = (Chronometer) infoTab.findViewById(R.id.chronometer);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        squat2 = (Button) infoTab.findViewById(R.id.squatText2);
        squat3 = (Button) infoTab.findViewById(R.id.squatText3);
        squat4 = (Button) infoTab.findViewById(R.id.squatText4);
        dead1 = (Button) infoTab.findViewById(R.id.deadText1);
        dead2 = (Button) infoTab.findViewById(R.id.deadText2);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        double deadNumber = round(values[2])-12.5;
        double squatNumber = round(values[1])-5;

        String deadText = Double.toString(deadNumber)+ "x8";
        String squatText = Double.toString(squatNumber) + "x8";
        squat1.setText(squatText);
        squat2.setText(squatText);
        squat3.setText(squatText);
        squat4.setText(squatText);
        dead1.setText(deadText);
        dead2.setText(deadText);

        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }


        });

        return infoTab;
    }
    public String[] readFromFile(File file){
        String[] values = new String[11];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null){
                values[i] = line;
                i++;
            }
            br.close();
        }
        catch (IOException ignored){
        }
        return values;
    }
    public static double round(String valueString) {
        double value = Math.round(Math.round(Double.parseDouble(valueString)/2.5)*2.5 * 0.8/2.5)*2.5;
        return value;
    }

}