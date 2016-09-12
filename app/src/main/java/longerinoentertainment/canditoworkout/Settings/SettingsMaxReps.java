package longerinoentertainment.canditoworkout.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class SettingsMaxReps extends AppCompatActivity {
    EditText bench;
    EditText squat;
    EditText deadlift;
    Button save;
    Switch weightUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_max_reps);

        save = (Button) findViewById(R.id.saveButton);
        bench = (EditText) findViewById(R.id.benchText);
        squat = (EditText) findViewById(R.id.squatText);
        deadlift = (EditText) findViewById(R.id.deadText);
        weightUnit = (Switch) findViewById(R.id.switch1);

        weightUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("KG!");
                } else {
                    System.out.println("LBS!");
                }
            }
        });

        weightUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("It's on now bitch!");
                } else {
                    System.out.println("ARE YOU FUCKING SORRY?");
                }
            }
        });

        final File dir = new File(getBaseContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();
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
                String benchString = String.valueOf(Double.parseDouble(bench));
                String squatString = String.valueOf(squat.getText());
                String deadString = String.valueOf(deadlift.getText());

                try {
                    updateLine(file, benchString, squatString, deadString);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
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
