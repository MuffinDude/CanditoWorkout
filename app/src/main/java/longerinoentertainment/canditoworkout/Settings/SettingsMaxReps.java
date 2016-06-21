package longerinoentertainment.canditoworkout.Settings;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import longerinoentertainment.canditoworkout.R;

public class SettingsMaxReps extends AppCompatActivity {
    EditText bench;
    EditText squat;
    EditText deadlift;
    Button save;
    final Context context = getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_max_reps);

        save = (Button) findViewById(R.id.saveButton);
        bench = (EditText) findViewById(R.id.benchText);
        squat = (EditText) findViewById(R.id.squatText);
        deadlift = (EditText) findViewById(R.id.deadText);

        final File dir = new File(context.getFilesDir() + "/CanditoWorkoutApp");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        if (values.length >= 3) {
            bench.setText(values[0]+1, TextView.BufferType.EDITABLE);
            squat.setText(values[1], TextView.BufferType.EDITABLE);
            deadlift.setText(values[2], TextView.BufferType.EDITABLE);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final File file = new File(dir, "savedFile.txt");

                Editable benchText = bench.getText();
                String bench = benchText.toString();
                String benchString = String.valueOf(Double.parseDouble(bench)-1);
                String squatString = String.valueOf(squat.getText());
                String deadString = String.valueOf(deadlift.getText());

                Save(file, benchString, squatString, deadString);
                Toast toast = Toast.makeText(context,"Changes made", Toast.LENGTH_LONG);
                toast.show();
                readFromFile(file);

                finish();
            }
        });
    }




    public void Save(File file, String bench, String squat, String dead){
        // TODO: 21.06.2016
    }

    public static String[] readFromFile(File file){
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
        catch (IOException ignored){}
        return values;
    }
}
