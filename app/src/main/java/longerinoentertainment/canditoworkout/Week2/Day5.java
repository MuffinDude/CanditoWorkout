package longerinoentertainment.canditoworkout.Week2;

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

public class Day5  extends Fragment {

    Button bench1;
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
        final View infoTab = inflater.inflate(R.layout.activity_day52, container, false);

        bench1 = (Button) infoTab.findViewById(R.id.benchText1);
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
        double benchNumber1 = round(values[0], decimeterPoint)-decimeterPoint;

        String benchText1 = Double.toString(benchNumber1) + " xMR";
        bench1.setText(benchText1);

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

        accessoryOne.setText(values[6]);
        accessoryTwo.setText(values[7]);
        accessoryThree.setText(values[8]);

        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }
        });

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
    public static double round(String valueString, double units) {
        double value = Math.round(Math.round(Double.parseDouble(valueString)/units)*units * 0.8/units)*units;
        return value;
    }
}