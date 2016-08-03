package longerinoentertainment.canditoworkout.Week6;

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

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import longerinoentertainment.canditoworkout.R;

public class Option4 extends Fragment {
    TextView benchOld;
    TextView squatOld;
    TextView deadOld;
    TextView benchNew;
    TextView deadNew;
    TextView squatNew;
    TextView squatIncrease;
    TextView deadIncrease;
    TextView benchIncrease;
    EditText benchTimes;
    EditText squatTimes;
    EditText deadTimes;
    Button calculate;
    Button save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View options = inflater.inflate(R.layout.activity_option4, container, false);

        benchOld = (TextView) options.findViewById(R.id.oldBench);
        squatOld = (TextView) options.findViewById(R.id.oldSquat);
        deadOld = (TextView) options.findViewById(R.id.oldDead);
        deadNew = (TextView) options.findViewById(R.id.deadNew);
        squatNew = (TextView) options.findViewById(R.id.squatNew);
        benchNew = (TextView) options.findViewById(R.id.benchNew);
        benchIncrease= (TextView) options.findViewById(R.id.benchIncrease);
        squatIncrease = (TextView) options.findViewById(R.id.squatIncrease);
        deadIncrease = (TextView) options.findViewById(R.id.deadIncrease);
        benchTimes = (EditText) options.findViewById(R.id.benchTimes);
        deadTimes = (EditText) options.findViewById(R.id.deadTimes);
        squatTimes = (EditText) options.findViewById(R.id.squatTimes);
        calculate = (Button) options.findViewById(R.id.calculateButton);
        save = (Button) options.findViewById(R.id.saveButton);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));

        benchOld.setText(values[0]);
        squatOld.setText(values[1]);
        deadOld.setText(values[2]);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat oneDigit = new DecimalFormat("#,##0.0");//format to 1 decimal place
                int squatCalculate = Integer.parseInt(squatTimes.getText().toString());
                double squatOldInt = Double.parseDouble(String.valueOf(squatOld.getText()));
                int deadCalculate = Integer.parseInt(deadTimes.getText().toString());
                double deadOldInt = Double.parseDouble(String.valueOf(deadOld.getText()));
                int benchCalculate = Integer.parseInt(benchTimes.getText().toString());
                double benchOldInt = Double.parseDouble(String.valueOf(benchOld.getText()));

                if (squatCalculate == 2) squatNew.setText(Double.toString(Double.valueOf(oneDigit.format(squatOldInt*1.03))));
                if (squatCalculate == 3) squatNew.setText(Double.toString(Double.valueOf(oneDigit.format(squatOldInt*1.06))));
                if (squatCalculate >= 4) squatNew.setText(Double.toString(Double.valueOf(oneDigit.format(squatOldInt*1.09))));
                if (squatCalculate <= 1) squatNew.setText(squatOld.getText());

                if (deadCalculate == 2) deadNew.setText(Double.toString(Double.valueOf(oneDigit.format(deadOldInt*1.03))));
                if (deadCalculate == 3) deadNew.setText(Double.toString(Double.valueOf(oneDigit.format(deadOldInt*1.06))));
                if (deadCalculate >= 4) deadNew.setText(Double.toString(Double.valueOf(oneDigit.format(deadOldInt*1.09))));
                if (deadCalculate <= 1) deadNew.setText(deadOld.getText());

                if (benchCalculate == 2) benchNew.setText(Double.toString(Double.valueOf(oneDigit.format(benchOldInt*1.03))));
                if (benchCalculate == 3) benchNew.setText(Double.toString(Double.valueOf(oneDigit.format(benchOldInt*1.06))));
                if (benchCalculate >= 4) benchNew.setText(Double.toString(Double.valueOf(oneDigit.format(benchOldInt*1.09))));
                if (benchCalculate <= 1) benchNew.setText(benchOld.getText());

                benchIncrease.setText(Double.toString(Double.valueOf(oneDigit.format(Double.parseDouble(benchNew.getText().toString()) - benchOldInt))));
                deadIncrease.setText(Double.toString(Double.valueOf(oneDigit.format(Double.parseDouble(deadNew.getText().toString()) - deadOldInt))));
                squatIncrease.setText(Double.toString(Double.valueOf(oneDigit.format(Double.parseDouble(squatNew.getText().toString()) - squatOldInt))));
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final File file = new File(dir, "savedFile.txt");

                String benchString = String.valueOf(benchNew.getText());
                String squatString = String.valueOf(squatNew.getText());
                String deadString = String.valueOf(deadNew.getText());

                try {
                    updateLine(file, benchString, squatString, deadString);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        return options;
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
}