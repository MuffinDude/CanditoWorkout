package longerinoentertainment.canditoworkout;

import android.content.Context;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MainTabInsert extends Fragment {
    public static double benchPress;
    public static double squat;
    public static double deadlift;
    public Button save;
    public EditText editText;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CanditoWorkoutApp";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View insertTab = inflater.inflate(R.layout.activity_main_tab_insert, container, false);

        save = (Button) insertTab.findViewById(R.id.saveButton);
        editText = (EditText) insertTab.findViewById(R.id.editText);
        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final File file = new File(dir, "savedFile.txt");
                String [] saveText = String.valueOf(editText.getText()).split(System.getProperty("line.separator"));




                Save(file, saveText);
                Toast.makeText(getContext(), "Saved" + editText.getText(), Toast.LENGTH_SHORT).show();
                readFromFile(file);
            }
        });

        return insertTab;
    }

    public static void Save(File file, String[] data){
        FileOutputStream fos = null;
        try{

            // empty the contents of file. holy shit this is a bad solution
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            fos = new FileOutputStream(file, true);

        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try{
            try{
                for (int i = 0; i<data.length; i++){
                    assert fos != null;
                    fos.write(data[i].getBytes());
                    if (i < data.length-1){
                        fos.write("\n".getBytes());
                    }
                } fos.write(' ');
                System.out.println("salvestas h2sti");

            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally{
            try{
                assert fos != null;
                for (int i = 0; i < fos.toString().length(); i++){
                    System.out.println(data[0]);
                    System.out.println(data.length);
                }
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }

    public static void readFromFile(File file){
    StringBuilder text = new StringBuilder();
    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null){
            text.append(line);
            text.append('\n');
        }
        br.close();
        benchPress = Double.parseDouble(text.toString());

    }
    catch (IOException e){

    }
        System.out.println(benchPress + "hahahahahahaha");
    }

}
