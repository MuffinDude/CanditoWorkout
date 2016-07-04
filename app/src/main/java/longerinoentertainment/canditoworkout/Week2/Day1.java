package longerinoentertainment.canditoworkout.Week2;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class Day1 extends Fragment {
    Button squat1;
    Button sqt1;
    Button sqt2;
    Button sqt3;
    Button sqt4;
    Button sqt5;
    ImageButton info;
    Button stopper;
    Chronometer chronometer;
    private long timeWhenStopped = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day12, container, false);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        sqt1 = (Button) infoTab.findViewById(R.id.squat1);
        sqt2 = (Button) infoTab.findViewById(R.id.squat2);
        sqt3 = (Button) infoTab.findViewById(R.id.squat3);
        sqt4 = (Button) infoTab.findViewById(R.id.squat4);
        sqt5 = (Button) infoTab.findViewById(R.id.squat5);
        stopper = (Button) infoTab.findViewById(R.id.stopperButton);
        chronometer = (Chronometer) infoTab.findViewById(R.id.chronometer);
        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }
        });
        sqt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        sqt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        sqt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        sqt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        sqt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt5.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        info = (ImageButton) infoTab.findViewById(R.id.infoButton);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),
                        "Still complete the 5 sets of 3 reps regardless even if you do perform less than 8 reps on the MR10 set", Toast.LENGTH_LONG).show();
            }
        });

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        double squatNumber = round(values[1]);

        String squatText = Double.toString(squatNumber) + "x10MR";
        String squatTextSixty = Double.toString(squatNumber + 2.5) + "x3";
        squat1.setText(squatText);
        sqt1.setText(squatTextSixty);
        sqt2.setText(squatTextSixty);
        sqt3.setText(squatTextSixty);
        sqt4.setText(squatTextSixty);
        sqt5.setText(squatTextSixty);

        return infoTab;
    }
    public String[] readFromFile(File file){
        String[] values = new String[9];
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
