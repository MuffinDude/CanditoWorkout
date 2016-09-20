package longerinoentertainment.canditoworkout.Week3;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
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
import java.text.DecimalFormat;

import longerinoentertainment.canditoworkout.R;

public class Day3 extends Fragment {
    Button squat1;
    Button stopper;
    Chronometer chronometer;
    private long timeWhenStopped = 0;
    static double decimeterPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day33, container, false);
        squat1 = (Button) infoTab.findViewById(R.id.squatText1);

        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);
        stopper = (Button) infoTab.findViewById(R.id.stopperButton);
        chronometer = (Chronometer) infoTab.findViewById(R.id.chronometer);
        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }
        });
        if (values[3].equals("1")) decimeterPoint = 2.5;
        if (values[3].equals("0")) decimeterPoint = 5;
        double squatNumber = round(values[1], decimeterPoint)+decimeterPoint*3;

        String squatText = format.format(squatNumber) + " x4-6";
        squat1.setText(squatText);
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