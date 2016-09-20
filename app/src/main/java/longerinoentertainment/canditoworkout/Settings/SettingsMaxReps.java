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
import java.text.DecimalFormat;

import longerinoentertainment.canditoworkout.R;

public class SettingsMaxReps extends AppCompatActivity {
    EditText bench, squat, deadlift;
    Double squatForConversion, benchForConversion, deadliftForConversion;
    Button save;
    Switch weightUnit;
    String kilogram;
    ToggleButton benchToggle, squatToggle, deadToggle;
    TextView weightConfirmation;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_max_reps);

        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        save = (Button) findViewById(R.id.saveButton);
        bench = (EditText) findViewById(R.id.benchText);
        squat = (EditText) findViewById(R.id.squatText);
        deadlift = (EditText) findViewById(R.id.deadText);
        weightUnit = (Switch) findViewById(R.id.switch1);
        benchToggle = (ToggleButton) findViewById(R.id.benchToggle);
        squatToggle = (ToggleButton) findViewById(R.id.squatToggle);
        deadToggle = (ToggleButton) findViewById(R.id.deadToggle);
        weightConfirmation = (TextView) findViewById(R.id.weightAssuranceText);

        final File dir = new File(getBaseContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();
        final String[] values = readFromFile(new File(dir, "savedFile.txt"));
        double immideateBench = Double.parseDouble(values[0]);
        double immideateSquat = Double.parseDouble(values[1]);
        double immideateDead = Double.parseDouble(values[2]);
        bench.setText(format.format(immideateBench), TextView.BufferType.EDITABLE);
        squat.setText(format.format(immideateSquat), TextView.BufferType.EDITABLE);
        deadlift.setText(format.format(immideateDead), TextView.BufferType.EDITABLE);

        benchForConversion = Double.parseDouble(values[0]);
        squatForConversion = Double.parseDouble(values[1]);
        deadliftForConversion = Double.parseDouble(values[2]);
        benchToggle.setText("Click here if you failed a set of bench press");
        squatToggle.setText("Click here if you failed a set of squats");
        deadToggle.setText("Click here if you failed a set of deadlifts");

        //see ei tee praegu komasid millegi pärast
        double benchCalculation = Math.round(Double.parseDouble(values[0]) * 0.975*100)/100;
        double squatCalculation = Math.round(Double.parseDouble(values[1]) * 0.975*100)/100;
        double deadCalculation = Math.round(Double.parseDouble(values[2]) * 0.975*100)/100;
        final String lowerBench = format.format(benchCalculation);
        final String lowerSquat = format.format(squatCalculation);
        final String lowerDead = format.format(deadCalculation);

        benchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bench.setText(lowerBench);
                    benchToggle.setTextOn("Bench press weights lowered");
                } else {
                    bench.setText(values[0]);
                    benchToggle.setTextOff("Weights back on");
                }
            }
        });
        squatToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    squat.setText(lowerSquat);
                    squatToggle.setTextOn("Squat weights lowered");
                } else {
                    squat.setText(values[1]);
                    squatToggle.setTextOff("Weights back on");
                }
            }
        });
        deadToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    deadlift.setText(lowerDead);
                    deadToggle.setTextOn("Deadlift weights lowered");
                } else {
                    deadlift.setText(values[2]);
                    deadToggle.setTextOff("Weights back on");
                }
            }
        });
        // check if it's in kg or lbs mode
        if (values[3].equals("0")){
            weightUnit.setChecked(false);
            kilogram = "0";
            weightConfirmation.setText("Weights are in Pounds");

        } else {
            weightUnit.setChecked(true);
            kilogram = "1";
        }

        weightUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("KG!");
                    kilogram = "1";
                    weightConfirmation.setText("Weights are in Kilograms");
                } else {
                    System.out.println("LBS");
                    kilogram = "0";
                    weightConfirmation.setText("Weights are in Pounds");

                }
            }
        });

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
                    updateLine(file, benchString, squatString, deadString, kilogram);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void updateLine(File data, String bench, String squat, String dead, String weightUnits) throws IOException {
        String values[] = readFromFile(data);
        values[0] = bench;
        values[1] = squat;
        values[2] = dead;
        values[3] = weightUnits;

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
