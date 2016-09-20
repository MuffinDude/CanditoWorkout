package longerinoentertainment.canditoworkout.Week5;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import longerinoentertainment.canditoworkout.R;

public class Day1 extends Fragment {

    Button squat1;
    Button dead1;
    Button dead2;
    Button dead3;
    RelativeLayout optional1;
    RelativeLayout optional2;
    TextView optionalOne;
    TextView optionalTwo;
    Button stopper;
    Chronometer chronometer;
    private long timeWhenStopped = 0;
    static double decimeterPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day15, container, false);

        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        dead1 = (Button) infoTab.findViewById(R.id.deadText1);
        dead2 = (Button) infoTab.findViewById(R.id.deadText2);
        dead3 = (Button) infoTab.findViewById(R.id.deadText3);
        stopper = (Button) infoTab.findViewById(R.id.stopperButton);
        chronometer = (Chronometer) infoTab.findViewById(R.id.chronometer);
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

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        if (values[3].equals("1")) decimeterPoint = 2.5;
        if (values[3].equals("0")) decimeterPoint = 5;
        double deadNumber1 = round(values[2], decimeterPoint, 0.675);
        double deadNumber2 = round(values[2], decimeterPoint, 0.7);
        double deadNumber3 = round(values[2], decimeterPoint, 0.725);
        double squatNumber = round(values[1], decimeterPoint, 0.975);

        String deadText1 = format.format(deadNumber1)+ " x4";
        String deadText2 = format.format(deadNumber2)+ " x4";
        String deadText3 = format.format(deadNumber3)+ " x2";
        String squatText = format.format(squatNumber) + " x1-4";
        squat1.setText(squatText);
        dead1.setText(deadText1);
        dead2.setText(deadText2);
        dead3.setText(deadText3);

        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
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
    public static double round(String valueString, double units, double specialNumber) {
        double value = Math.round(Math.round(Double.parseDouble(valueString)/units)*units * specialNumber/units)*units;
        return value;
    }
}