package longerinoentertainment.canditoworkout.FirstTime;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    Button save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View beginnerTab = inflater.inflate(R.layout.activity_first_max_reps, container, false);


        save = (Button) beginnerTab.findViewById(R.id.saveButton);
        bench = (EditText) beginnerTab.findViewById(R.id.benchText);
        squat = (EditText) beginnerTab.findViewById(R.id.squatText);
        deadlift = (EditText) beginnerTab.findViewById(R.id.deadText);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        bench.setText(values[0], TextView.BufferType.EDITABLE);
        squat.setText(values[1], TextView.BufferType.EDITABLE);
        deadlift.setText(values[2], TextView.BufferType.EDITABLE);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final File file = new File(dir, "savedFile.txt");

                Editable benchText = bench.getText();
                String bench = benchText.toString();
                //kui nümbrid ei ole korras siis epab -1 kirjutamisel võtma ja pärast +1 lisama doe
                String benchString = String.valueOf(Double.parseDouble(bench));
                String squatString = String.valueOf(squat.getText());
                String deadString = String.valueOf(deadlift.getText());

                try {
                    updateLine(file, benchString, squatString, deadString);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        return beginnerTab;
    }
    private void updateLine(File data, String bench, String squat, String dead) throws IOException {
        String values[] = readFromFile(data);
        values[0] = bench;
        values[1] = squat;
        values[2] = dead;

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
}
