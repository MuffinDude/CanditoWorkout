package longerinoentertainment.canditoworkout;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
    private RadioGroup g1;
    private RadioGroup g2;
    private RadioGroup g3;
    private RadioGroup gLegs1;
    private RadioGroup gLegs2;
    public Button save;
    public Switch weightSwitch;
    public EditText editTextBench;
    public EditText editTextSquat;
    public EditText editTextDeadlift;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View insertTab = inflater.inflate(R.layout.activity_main_tab_insert, container, false);

        save = (Button) insertTab.findViewById(R.id.saveButton);
        editTextBench = (EditText) insertTab.findViewById(R.id.editTextBench);
        editTextSquat = (EditText) insertTab.findViewById(R.id.editTextSquat);
        editTextDeadlift = (EditText) insertTab.findViewById(R.id.editTextDeadlift);
        g1 = (RadioGroup) insertTab.findViewById(R.id.radioGroup1);
        g2 = (RadioGroup) insertTab.findViewById(R.id.radioGroup2);
        g3 = (RadioGroup) insertTab.findViewById(R.id.radioGroup3);
        gLegs1 = (RadioGroup) insertTab.findViewById(R.id.radioGroupLegs1);
        gLegs2 = (RadioGroup) insertTab.findViewById(R.id.radioGroupLegs2);
        weightSwitch = (Switch) insertTab.findViewById(R.id.weightSwitch);
        weightSwitch.setShowText(true);


        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        dir.mkdirs();
        String[] values = readFromFile(new File(dir, "savedFile.txt"));

        if (values.length >= 3) {
            editTextBench.setText(values[0], TextView.BufferType.EDITABLE);
            editTextSquat.setText(values[1], TextView.BufferType.EDITABLE);
            editTextDeadlift.setText(values[2], TextView.BufferType.EDITABLE);
        } else {
            editTextBench.setText(R.string.hundred);
            editTextSquat.setText(R.string.hundred);
            editTextDeadlift.setText(R.string.hundred);
        }
        /*TEKSTIFAIL
        0 rida - bench
        1 rida - squat
        2 rida - dead
        3 rida - kg(1) või lbs(0)
        4 rida - leg optional 1
        5 rida - leg optional 2
        6 rida - arm accessory 1
        7 rida - arm accessory 2
        8 rida - arm accessory 3
        9 rida - arm optional 1
        10 rida - arm optional 2
        */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final File file = new File(dir, "savedFile.txt");
                String[] saveText = new String[9];

                saveText[0] = String.valueOf(editTextBench.getText());
                saveText[1] = String.valueOf(editTextSquat.getText());
                saveText[2] = String.valueOf(editTextDeadlift.getText());

                if(weightSwitch.isChecked()){
                    saveText[3] = "LBS";
                }else{
                    saveText[3] = "KG";
                }

                int legsId1 = gLegs1.getCheckedRadioButtonId();
                RadioButton legs1 = (RadioButton) insertTab.findViewById(legsId1);
                saveText[4] = String.valueOf(legs1.getText());
                int legsId2 = gLegs2.getCheckedRadioButtonId();
                RadioButton legs2 = (RadioButton) insertTab.findViewById(legsId2);
                saveText[5] = String.valueOf(legs2.getText());

                int selectedId = g1.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) insertTab.findViewById(selectedId);
                saveText[6] = String.valueOf(radioButton.getText());
                int selectedId2 = g2.getCheckedRadioButtonId();
                RadioButton radioButton2 = (RadioButton) insertTab.findViewById(selectedId2);
                saveText[7] = String.valueOf(radioButton2.getText());
                int selectedId3 = g3.getCheckedRadioButtonId();
                RadioButton radioButton3 = (RadioButton) insertTab.findViewById(selectedId3);
                saveText[8] = String.valueOf(radioButton3.getText());

                saveData(file, saveText);
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
                readFromFile(file);
            }
        });
        return insertTab;
    }

    public static void saveData(File file, String[] data){

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
                }// fos.write(' ');

            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally{
            try{
                assert fos != null;
                for (int i = 0; i < fos.toString().length(); i++){
                    //why the fuck ta nii palju kordi seda kõike välja prindib
                    System.out.println(data[0]);
                    System.out.println(data[1]);
                    System.out.println(data[2]);
                    System.out.println(data[3]);
                    System.out.println(data[4]);
                    System.out.println(data[5]);
                    System.out.println(data[6]);
                    System.out.println(data[7]);
                    System.out.println(data[8]);
                }
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
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
