package longerinoentertainment.canditoworkout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

import longerinoentertainment.canditoworkout.FirstTime.FirstTime;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        File dir = new File(getBaseContext().getFilesDir() + "/CanditoWorkoutApp");
        File file = new File(dir, "savedFile.txt");

        if(file.exists()) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }else{
            Intent i = new Intent(this, FirstTime.class);
            startActivity(i);
            finish();
        }
    }
}
