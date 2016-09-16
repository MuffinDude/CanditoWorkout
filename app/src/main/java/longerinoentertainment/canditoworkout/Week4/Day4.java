package longerinoentertainment.canditoworkout.Week4;

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

import longerinoentertainment.canditoworkout.R;

public class Day4 extends Fragment {
    Button bench1;
    Button bench2;
    Button bench3;
    Button stopper;
    RelativeLayout optional1;
    RelativeLayout optional2;
    TextView optionalOne;
    TextView optionalTwo;
    TextView accessoryOne;
    TextView accessoryTwo;
    TextView accessoryThree;
    Chronometer chronometer;
    private long timeWhenStopped = 0;
    static double decimeterPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day44, container, false);

        bench1 = (Button) infoTab.findViewById(R.id.benchText1);
        bench2 = (Button) infoTab.findViewById(R.id.benchText2);
        bench3 = (Button) infoTab.findViewById(R.id.benchText3);
        stopper = (Button) infoTab.findViewById(R.id.stopperButton);
        chronometer = (Chronometer) infoTab.findViewById(R.id.chronometer);
        optional1 = (RelativeLayout) infoTab.findViewById(R.id.optional1);
        optional2 = (RelativeLayout) infoTab.findViewById(R.id.optional2);
        optionalOne = (TextView) infoTab.findViewById(R.id.optionalOne);
        optionalTwo = (TextView) infoTab.findViewById(R.id.optionalTwo);
        accessoryOne = (TextView) infoTab.findViewById(R.id.accessoryOne);
        accessoryTwo = (TextView) infoTab.findViewById(R.id.accessoryTwo);
        accessoryThree = (TextView) infoTab.findViewById(R.id.accessoryThree);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        if (values[3].equals("1")) decimeterPoint = 2.5;
        if (values[3].equals("0")) decimeterPoint = 5;
        double benchNumber1 = round(0.875, values[0], decimeterPoint);
        double benchNumber2 = round(0.9, values[0], decimeterPoint);
        double benchNumber3 = round(0.95, values[0], decimeterPoint);

        String benchText1 = Double.toString(benchNumber1) + " x3";
        String benchText2 = Double.toString(benchNumber2) + " x2-4";
        String benchText3 = Double.toString(benchNumber3) + " x1-2";
        bench1.setText(benchText1);
        bench2.setText(benchText2);
        bench3.setText(benchText3);

        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }
        });

        accessoryOne.setText(values[6]);
        accessoryTwo.setText(values[7]);
        accessoryThree.setText(values[8]);

        if (values[9].equals("None")){
            optional1.setVisibility(View.GONE);
            optional2.setVisibility(View.GONE);
        }else if(values[10].equals("None")){
            optional2.setVisibility(View.GONE);
            optionalOne.setText(values[9]);
        }else {
            optionalOne.setText(values[9]);
            optionalTwo.setText(values[10]);
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
    public static double round(double number, String valueString, double units) {
        double value = Math.floor(Math.floor(Double.parseDouble(valueString)/units)*units * number/units)*units;
        return value;
    }
}