package longerinoentertainment.canditoworkout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SecretInfo extends AppCompatActivity {

    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_info);

        counter = (TextView) findViewById(R.id.counter);

        final File dir = new File(getBaseContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();
        final String[] values = readFromFile(new File(dir, "weeks.txt"));

        counter.setText(values[5]);

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