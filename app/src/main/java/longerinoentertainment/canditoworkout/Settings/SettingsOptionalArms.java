package longerinoentertainment.canditoworkout.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import longerinoentertainment.canditoworkout.R;

public class SettingsOptionalArms extends AppCompatActivity {
    private RadioGroup g1;
    private RadioGroup g2;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_optional_arms);

        save = (Button) findViewById(R.id.saveButton);
        g1 = (RadioGroup) findViewById(R.id.exGroup1);
        g2 = (RadioGroup) findViewById(R.id.exGroup2);

        final File dir = new File(getBaseContext().getFilesDir() + "/CanditoWorkoutApp");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));

        if (Objects.equals(values[9], "Lateral Dumbbell Raise"))g1.check(R.id.radioButton36);
        if (Objects.equals(values[9], "Incline Chest Fly"))g1.check(R.id.radioButton37);
        if (Objects.equals(values[9], "One Armed Tricep Extension"))g1.check(R.id.radioButton38);
        if (Objects.equals(values[9], "Bicep Cable/Machine Movements"))g1.check(R.id.radioButton39);
        if (Objects.equals(values[9], "Preacher Curl"))g1.check(R.id.radioButton40);
        if (Objects.equals(values[9], "Skullcrushers"))g1.check(R.id.radioButton41);
        if (Objects.equals(values[9], "Hammer Curl (if not used as main accessory)"))g1.check(R.id.radioButton42);
        if (Objects.equals(values[9], "Bicep Curl"))g1.check(R.id.radioButton43);
        if (Objects.equals(values[9], "None"))g1.check(R.id.radioButton44);

        if (Objects.equals(values[10], "Lateral Dumbbell Raise"))g2.check(R.id.radioButton11);
        if (Objects.equals(values[10], "Incline Chest Fly"))g2.check(R.id.radioButton12);
        if (Objects.equals(values[10], "One Armed Tricep Extension"))g2.check(R.id.radioButton13);
        if (Objects.equals(values[10], "Bicep Cable/Machine Movements"))g2.check(R.id.radioButton14);
        if (Objects.equals(values[10], "Preacher Curl"))g2.check(R.id.radioButton15);
        if (Objects.equals(values[10], "Skullcrushers"))g2.check(R.id.radioButton16);
        if (Objects.equals(values[10], "Hammer Curl (if not used as main accessory)"))g2.check(R.id.radioButton17);
        if (Objects.equals(values[10], "Bicep Curl"))g2.check(R.id.radioButton18);
        if (Objects.equals(values[10], "None"))g2.check(R.id.radioButton19);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final File file = new File(dir, "savedFile.txt");

                int selectedId = g1.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                assert radioButton != null;
                String ex1 = String.valueOf(radioButton.getText());
                int selectedId2 = g2.getCheckedRadioButtonId();
                RadioButton radioButton2 = (RadioButton) findViewById(selectedId2);
                assert radioButton2 != null;
                String ex2 = String.valueOf(radioButton2.getText());

                try {
                    updateLine(file, ex1, ex2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    private void updateLine(File data, String ex1, String ex2) throws IOException {
        String values[] = readFromFile(data);
        values[9] = ex1;
        values[10] = ex2;

        FileWriter fw = new FileWriter(data);
        for (String value : values) {
            fw.write(value + "\n");
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
