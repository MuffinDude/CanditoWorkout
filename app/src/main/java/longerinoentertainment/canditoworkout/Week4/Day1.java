package longerinoentertainment.canditoworkout.Week4;

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
    Button squat2;
    Button squat3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day14, container, false);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        squat2 = (Button) infoTab.findViewById(R.id.squatText2);
        squat3 = (Button) infoTab.findViewById(R.id.squatText3);


        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        double squatNumber = round(values[1]);

        String squatText1 = Double.toString(squatNumber+5) + "x3";
        String squatText2 = Double.toString(squatNumber+7.5) + "x3";
        String squatText3 = Double.toString(squatNumber+10) + "x3";
        squat1.setText(squatText1);
        squat2.setText(squatText2);
        squat3.setText(squatText3);
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