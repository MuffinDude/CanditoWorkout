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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import longerinoentertainment.canditoworkout.R;

public class Day1 extends Fragment {
    Button squat1;
    Button sqt1;
    Button sqt2;
    Button sqt3;
    Button sqt4;
    Button sqt5;
    RelativeLayout optional1;
    RelativeLayout optional2;
    TextView optionalOne, optionalTwo, failureText, repsMade, calculateInfo;
    LinearLayout backoffSets;
    Button stopper, calculate;
    Chronometer chronometer;
    private long timeWhenStopped = 0;
    private double decimeterPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day12, container, false);

        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        sqt1 = (Button) infoTab.findViewById(R.id.squat1);
        sqt2 = (Button) infoTab.findViewById(R.id.squat2);
        sqt3 = (Button) infoTab.findViewById(R.id.squat3);
        sqt4 = (Button) infoTab.findViewById(R.id.squat4);
        sqt5 = (Button) infoTab.findViewById(R.id.squat5);
        optional1 = (RelativeLayout) infoTab.findViewById(R.id.optional1);
        optional2 = (RelativeLayout) infoTab.findViewById(R.id.optional2);
        optionalOne = (TextView) infoTab.findViewById(R.id.optionalOne);
        optionalTwo = (TextView) infoTab.findViewById(R.id.optionalTwo);
        Button optionalB1 = (Button) infoTab.findViewById(R.id.button23);
        Button optionalB2 = (Button) infoTab.findViewById(R.id.button24);
        Button optionalB3 = (Button) infoTab.findViewById(R.id.button25);
        Button optionalB4 = (Button) infoTab.findViewById(R.id.button27);
        Button optionalB5 = (Button) infoTab.findViewById(R.id.button28);
        Button optionalB6 = (Button) infoTab.findViewById(R.id.button30);
        stopper = (Button) infoTab.findViewById(R.id.stopperButton);
        chronometer = (Chronometer) infoTab.findViewById(R.id.chronometer);
        calculate = (Button) infoTab.findViewById(R.id.calculateButton);
        repsMade = (TextView) infoTab.findViewById(R.id.completedReps);
        backoffSets = (LinearLayout) infoTab.findViewById(R.id.backoffSets);
        failureText = (TextView) infoTab.findViewById(R.id.failureText);
        calculateInfo = (TextView) infoTab.findViewById(R.id.completionText);

        backoffSets.setVisibility(View.GONE);
        failureText.setVisibility(View.GONE);

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
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt5.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        if (values[3].equals("1")) decimeterPoint = 2.5;
        if (values[3].equals("0")) decimeterPoint = 5;
        double squatNumber = round(values[1], decimeterPoint);

        final double failureNumber = squatNumber*0.025;
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gottenReps = repsMade.getText().toString();
                Toast.makeText(getActivity(), "You can only rest 60 seconds after each set of X3",
                        Toast.LENGTH_LONG).show();
                calculateInfo.setVisibility(View.GONE);
                int repCount;
                if (gottenReps.equals("")){
                    repCount=0;
                    repsMade.setText("0");
                }else{
                    repCount= Integer.parseInt(gottenReps);
                }
                if (repCount >=8){
                    backoffSets.setVisibility(View.VISIBLE);
                    failureText.setVisibility(View.GONE);
                }else{
                    failureText.setVisibility(View.VISIBLE);
                    backoffSets.setVisibility(View.VISIBLE);
                    failureText.setText("Reduce the max Squat in the Settings by " + failureNumber + " and continue.");
                }
            }
        });

        if (values[4].equals("None")){
            optional1.setVisibility(View.GONE);
            optional2.setVisibility(View.GONE);
        }else if (values[5].equals("None")){
            optional2.setVisibility(View.GONE);

            if (values[4].substring(values[4].length()-1).equals("E")){
                optionalOne.setText(values[4].substring(0,values[4].length()-1));
                optionalB1.setText("x4");
                optionalB2.setText("x4");
                optionalB3.setText("x4");
            }else{
                optionalOne.setText(values[4]);
                optionalB1.setText("x7-10");
                optionalB2.setText("x7-10");
                optionalB3.setText("x7-10");
            }
        }else{
            if (values[4].substring(values[4].length()-1).equals("E")){
                optionalOne.setText(values[4].substring(0,values[4].length()-1));
                optionalB1.setText("x4");
                optionalB2.setText("x4");
                optionalB3.setText("x4");
            }else{
                optionalOne.setText(values[4]);
                optionalB1.setText("x7-10");
                optionalB2.setText("x7-10");
                optionalB3.setText("x7-10");
            }
            if (values[5].substring(values[5].length()-1).equals("E")){
                optionalTwo.setText(values[5].substring(0,values[5].length()-1));
                optionalB4.setText("x4");
                optionalB5.setText("x4");
                optionalB6.setText("x4");
            }else{
                optionalTwo.setText(values[5]);
                optionalB4.setText("x7-10");
                optionalB5.setText("x7-10");
                optionalB6.setText("x7-10");
            }
        }

        String squatText = format.format(squatNumber) + " x10MR";
        String squatTextSixty = format.format(squatNumber + decimeterPoint) + " x3";
        squat1.setText(squatText);
        sqt1.setText(squatTextSixty);
        sqt2.setText(squatTextSixty);
        sqt3.setText(squatTextSixty);
        sqt4.setText(squatTextSixty);
        sqt5.setText(squatTextSixty);

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
    public static double round(String valueString, double units) {
        double value = Math.round(Math.round(Double.parseDouble(valueString)/units)*units * 0.8/units)*units;
        return value;
    }
}
