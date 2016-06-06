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
import android.widget.TextView;
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
    public EditText editTextBench;
    public EditText editTextSquat;
    public EditText editTextDeadlift;

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CanditoWorkoutApp";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View insertTab = inflater.inflate(R.layout.activity_main_tab_insert, container, false);

        save = (Button) insertTab.findViewById(R.id.saveButton);
        editTextBench = (EditText) insertTab.findViewById(R.id.editTextBench);
        editTextSquat = (EditText) insertTab.findViewById(R.id.editTextSquat);
        editTextDeadlift = (EditText) insertTab.findViewById(R.id.editTextDeadlift);


        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();

        String[] values = readFromFile(new File(dir, "savedFile.txt"));

        if (values.length == 3) {
            System.out.println("readfromfile1");
            editTextBench.setText(values[0], TextView.BufferType.EDITABLE);
            editTextSquat.setText(values[1], TextView.BufferType.EDITABLE);
            editTextDeadlift.setText(values[2], TextView.BufferType.EDITABLE);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final File file = new File(dir, "savedFile.txt");
                //String [] saveText = String.valueOf(editTextBench.getText()).split(System.getProperty("line.separator"));
                String[] saveText = new String[3];
                saveText[0] = String.valueOf(editTextBench.getText());
                saveText[1] = String.valueOf(editTextSquat.getText());
                saveText[2] = String.valueOf(editTextDeadlift.getText());



                Save(file, saveText);
                Toast.makeText(getContext(), "Saved" + editTextBench.getText(), Toast.LENGTH_SHORT).show();
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
                    System.out.println(data[i] + "vaata mind pls");
                    fos.write(data[i].getBytes());
                    if (i < data.length-1){
                        fos.write("\n".getBytes());
                    }
                }// fos.write(' ');

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
        benchPress = Double.parseDouble(values[0]);
        squat = Double.parseDouble(values[1]);
        deadlift = Double.parseDouble(values[2]);
    }
    catch (IOException e){

    }
        System.out.println(benchPress + " bench press");
        System.out.println(squat + " squat");
        System.out.println(deadlift + " deadlift");
    return values;
    }

}
