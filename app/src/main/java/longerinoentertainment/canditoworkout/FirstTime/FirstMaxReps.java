package longerinoentertainment.canditoworkout.FirstTime;

import android.provider.Settings;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnTouchListener;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class FirstMaxReps extends Fragment {
    EditText bench;
    EditText squat;
    EditText deadlift;
    Switch weightUnit;
    String kilogram = "1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View beginnerTab = inflater.inflate(R.layout.activity_first_max_reps, null, false);


        bench = (EditText) beginnerTab.findViewById(R.id.benchText);
        squat = (EditText) beginnerTab.findViewById(R.id.squatText);
        deadlift = (EditText) beginnerTab.findViewById(R.id.deadText);
        weightUnit = (Switch) beginnerTab.findViewById(R.id.switch1);

        weightUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("KG!");
                    kilogram = "1";
                } else {
                    System.out.println("LBS");
                    kilogram = "0";
                }
            }
        });

        File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();
        return beginnerTab;
    }


    private void updateLine(File data, String bench, String squat, String dead) throws IOException {
        String values[] = readFromFile(data);
        values[0] = bench;
        values[1] = squat;
        values[2] = dead;
        values[3] = kilogram;

        FileWriter fw = new FileWriter(data);
        for (int j = 0; j < values.length; j++) {
            fw.write(values[j] + "\n");
        }
        fw.close();
    }

    public static String[] readFromFile(File file){
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
        catch (IOException ignored){}
        return values;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
                File file = new File(dir, "savedFile.txt");

                Editable benchText = bench.getText();
                String bench = benchText.toString();
                String benchString = String.valueOf(Double.parseDouble(bench));
                String squatString = String.valueOf(squat.getText());
                String deadString = String.valueOf(deadlift.getText());

                try {
                    updateLine(file, benchString, squatString, deadString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
