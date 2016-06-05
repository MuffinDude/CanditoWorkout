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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainTabInsert extends Fragment {
    public Button save;
    public EditText editText;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CanditoWorkoutApp";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View insertTab = inflater.inflate(R.layout.activity_main_tab_insert, container, false);

        save = (Button) insertTab.findViewById(R.id.saveButton);
        editText = (EditText) insertTab.findViewById(R.id.editText);
        File dir = new File(path);
        dir.mkdirs();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(path, "/savedFile.txt");
                String [] saveText = String.valueOf(editText.getText()).split(System.getProperty("line.separator"));


                Toast.makeText(getContext(), "Saved" + editText.getText(), Toast.LENGTH_SHORT).show();

                Save(file, saveText);
            }
        });

        return insertTab;
    }

    public static void Save(File file, String[] data){
        FileOutputStream fos = null;
        try{
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
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally{
            try{
                assert fos != null;
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }

}
