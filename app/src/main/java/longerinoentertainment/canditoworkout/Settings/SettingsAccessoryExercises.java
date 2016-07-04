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

public class SettingsAccessoryExercises extends AppCompatActivity {
    private RadioGroup g1;
    private RadioGroup g2;
    private RadioGroup g3;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_accessory_exercises);

        save = (Button) findViewById(R.id.saveButton);
        g1 = (RadioGroup) findViewById(R.id.radioGroup1);
        g2 = (RadioGroup) findViewById(R.id.radioGroup2);
        g3 = (RadioGroup) findViewById(R.id.radioGroup3);

        final File dir = new File(getBaseContext().getFilesDir() + "/CanditoWorkoutApp");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        if (Objects.equals(values[6], "Dumbbell Row"))g1.check(R.id.radioButton26);
        if (Objects.equals(values[6], "Barbell Row"))g1.check(R.id.radioButton27);
        if (Objects.equals(values[6], "Machine Row"))g1.check(R.id.radioButton28);

        if (Objects.equals(values[7], "Seated Dumbbell OHP"))g2.check(R.id.radioButton29);
        if (Objects.equals(values[7], "Standing Dumbbell OHP"))g2.check(R.id.radioButton30);
        if (Objects.equals(values[7], "Military Press"))g2.check(R.id.radioButton31);
        if (Objects.equals(values[7], "Lateral Dumbbell Raise"))g2.check(R.id.radioButton32);

        if (Objects.equals(values[8], "Weighted Pull-up"))g3.check(R.id.radioButton33);
        if (Objects.equals(values[8], "Weighted Chin-up"))g3.check(R.id.radioButton34);
        if (Objects.equals(values[8], "Lat Pulldown"))g3.check(R.id.radioButton35);

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
                int selectedId3 = g3.getCheckedRadioButtonId();
                RadioButton radioButton3 = (RadioButton) findViewById(selectedId3);
                assert radioButton3 != null;
                String ex3 = String.valueOf(radioButton3.getText());

                try {
                    updateLine(file, ex1, ex2, ex3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    private void updateLine(File data, String ex1, String ex2, String ex3) throws IOException {
        String values[] = readFromFile(data);
        values[6] = ex1;
        values[7] = ex2;
        values[8] = ex3;

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
