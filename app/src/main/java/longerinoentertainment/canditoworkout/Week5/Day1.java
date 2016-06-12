package longerinoentertainment.canditoworkout.Week5;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class Day1 extends Fragment {

    Button squat1;
    Button dead1;
    Button dead2;
    Button dead3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day15, container, false);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        dead1 = (Button) infoTab.findViewById(R.id.deadText1);
        dead2 = (Button) infoTab.findViewById(R.id.deadText2);
        dead3 = (Button) infoTab.findViewById(R.id.deadText3);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        double deadNumber = round(values[2]);
        double squatNumber = round(values[1]);

        String deadText1 = Double.toString(deadNumber-12.5)+ "x4";
        String deadText2 = Double.toString(deadNumber-10)+ "x4";
        String deadText3 = Double.toString(deadNumber-7.5)+ "x2";
        String squatText = Double.toString(squatNumber+12.5) + "x1-4";
        squat1.setText(squatText);
        dead1.setText(deadText1);
        dead2.setText(deadText2);
        dead3.setText(deadText3);
        return infoTab;
    }

    public String[] readFromFile(File file){
        String[] values = new String[3];
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