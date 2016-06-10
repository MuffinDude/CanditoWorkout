package longerinoentertainment.canditoworkout.Week1;

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
    Button squat4;
    Button dead1;
    Button dead2;
    double squat;
    double deadlift;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day1, container, false);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        squat2 = (Button) infoTab.findViewById(R.id.squatText2);
        squat3 = (Button) infoTab.findViewById(R.id.squatText3);
        squat4 = (Button) infoTab.findViewById(R.id.squatText4);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();
        final File file = new File(dir, "savedFile.txt");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        squat1.setText(values[1] +" x6");
        squat2.setText(values[1] +" x6");
        squat3.setText(values[1] +" x6");
        squat4.setText(values[1] +" x6");
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
            squat = Double.parseDouble(values[1]);
            deadlift = Double.parseDouble(values[2]);
        }
        catch (IOException e){

        }
        System.out.println(squat + " squat");
        System.out.println(deadlift + " deadlift");
        return values;
    }
}