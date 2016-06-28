package longerinoentertainment.canditoworkout.Settings;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class SettingsOptionalLegs extends AppCompatActivity {
    Button hypertrophy1;
    Button explosiveness1;
    Button explosiveness2;
    Button hypertrophy2;
    Button save;
    CheckBox none;
    CheckBox none2;
    LinearLayout ex1;
    LinearLayout ex2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_optional_legs);
        hypertrophy1 = (Button) findViewById(R.id.hypertrophyButton1);
        hypertrophy2 = (Button) findViewById(R.id.hypertrophyButton2);
        explosiveness1 = (Button) findViewById(R.id.explosivenessButton1);
        explosiveness2 = (Button) findViewById(R.id.explosivenessButton2);
        save = (Button) findViewById(R.id.saveButton);
        none = (CheckBox) findViewById(R.id.noneBox);
        none2 = (CheckBox) findViewById(R.id.noneBox2);
        ex1 = (LinearLayout) findViewById(R.id.ex1Layout);
        ex2 = (LinearLayout) findViewById(R.id.ex2Layout);

        final int[] numero = {0,1};
        final File dir = new File(getFilesDir() + "/CanditoWorkoutApp");

        hypertrophy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(hypertrophy1);
                openContextMenu(hypertrophy1);
                hypertrophy1.setBackgroundColor(0xFF3399ff);
                explosiveness1.setBackgroundColor(0xFF000000);
                explosiveness1.setText(R.string.explosiveness);
                numero[0] = 1;
            }
        });
        explosiveness1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(explosiveness1);
                openContextMenu(explosiveness1);
                explosiveness1.setBackgroundColor(0xFF3399ff);
                hypertrophy1.setBackgroundColor(0xFF000000);
                hypertrophy1.setText(R.string.hypertrophy);
                numero[0]= 2;
            }
        });

        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero[0]=0;
                if (none.isChecked()){
                    final int color = 0x80000000;
                    final Drawable drawable = new ColorDrawable(color);
                    ex1.setForeground(drawable);
                    hypertrophy1.setVisibility(View.GONE);
                    explosiveness1.setVisibility(View.GONE);
                    ex2.setVisibility(View.GONE);
                }else{
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    ex1.setForeground(drawable);
                    hypertrophy1.setVisibility(View.VISIBLE);
                    explosiveness1.setVisibility(View.VISIBLE);
                    ex2.setVisibility(View.VISIBLE);
                }
            }
        });
        none2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (none2.isChecked()){
                    final int color = 0x80000000;
                    final Drawable drawable = new ColorDrawable(color);
                    ex2.setForeground(drawable);
                    hypertrophy2.setVisibility(View.GONE);
                    explosiveness2.setVisibility(View.GONE);
                    numero[1]=1;
                }else{
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    ex2.setForeground(drawable);
                    hypertrophy2.setVisibility(View.VISIBLE);
                    explosiveness2.setVisibility(View.VISIBLE);
                    numero[1]=2;
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 22.06.2016 saves all the stuff and reads all the stuffs
                final File file = new File(dir, "savedFile.txt");

                String ex1,ex2;
                if (numero[0]== 1){
                    ex1= (String) hypertrophy1.getText();
                } else if (numero[0] == 0){
                    ex1="none";
                }else{
                    ex1= (String) explosiveness1.getText();
                }
                if (numero[1]==1){
                    ex2 = (String) hypertrophy2.getText();
                }else{
                    ex2 = (String) explosiveness2.getText();
                }
                try {
                    updateLine(file, ex1, ex2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                finish();
                finish();
            }
        });
    }

    final int CONTEXT_MENU_EX1 =1;
    final int CONTEXT_MENU_EX2 =2;
    final int CONTEXT_MENU_EX3 =3;
    final int CONTEXT_MENU_EX4 =4;
    final int CONTEXT_MENU_EX5 =5;
    final int CONTEXT_MENU_EX6 =6;
    final int CONTEXT_MENU_EX7 =7;
    final int CONTEXT_MENU_EEX1 =8;
    final int CONTEXT_MENU_EEX2 =9;
    final int CONTEXT_MENU_EEX3 =10;
    final int CONTEXT_MENU_EEX4 =11;
    final int CONTEXT_MENU_EEX5 =12;
    final int CONTEXT_MENU_EEX6 =13;
    final int CONTEXT_MENU_EEX7 =14;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        //Context menu
        if (v.getId() == R.id.explosivenessButton1){
            menu.setHeaderTitle("Hypertrophy");
            menu.add(Menu.NONE, CONTEXT_MENU_EX1, Menu.NONE, R.string.calfLeg);
            menu.add(Menu.NONE, CONTEXT_MENU_EX2, Menu.NONE, R.string.otherCalf);
            menu.add(Menu.NONE, CONTEXT_MENU_EX3, Menu.NONE, R.string.legCurl);
            menu.add(Menu.NONE, CONTEXT_MENU_EX4, Menu.NONE, R.string.legExtension);
            menu.add(Menu.NONE, CONTEXT_MENU_EX5, Menu.NONE, R.string.isolationGlutes);
            menu.add(Menu.NONE, CONTEXT_MENU_EX6, Menu.NONE, R.string.singleLegPress);
            menu.add(Menu.NONE, CONTEXT_MENU_EX7, Menu.NONE, R.string.singleLegCurl);
        }else{
            menu.setHeaderTitle("Explosiveness");
            menu.add(Menu.NONE, CONTEXT_MENU_EEX1, Menu.NONE, R.string.boxJumps);
            menu.add(Menu.NONE, CONTEXT_MENU_EEX2, Menu.NONE, R.string.jumpSquats);
            menu.add(Menu.NONE, CONTEXT_MENU_EEX3, Menu.NONE, R.string.powercleans);
            menu.add(Menu.NONE, CONTEXT_MENU_EEX4, Menu.NONE, R.string.deepSquatJumps);
            menu.add(Menu.NONE, CONTEXT_MENU_EEX5, Menu.NONE, R.string.singleLegBoxJumps);
            menu.add(Menu.NONE, CONTEXT_MENU_EEX6, Menu.NONE, R.string.medBallThrows);
            menu.add(Menu.NONE, CONTEXT_MENU_EEX7, Menu.NONE, R.string.explosiveSinglePress);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case CONTEXT_MENU_EX1:{
                hypertrophy1.setText(R.string.calfLeg);
            }
            break;
            case CONTEXT_MENU_EX2:{
                hypertrophy1.setText(R.string.otherCalf);
            }
            break;
            case CONTEXT_MENU_EX3:{
                hypertrophy1.setText(R.string.legCurl);
            }
            break;
            case CONTEXT_MENU_EX4:{
                hypertrophy1.setText(R.string.legExtension);
            }
            break;
            case CONTEXT_MENU_EX5:{
                hypertrophy1.setText(R.string.isolationGlutes);
            }
            break;
            case CONTEXT_MENU_EX6:{
                hypertrophy1.setText(R.string.singleLegPress);
            }
            break;
            case CONTEXT_MENU_EX7:{
                hypertrophy1.setText(R.string.singleLegCurl);
            }
            break;
            case CONTEXT_MENU_EEX1:{
                hypertrophy1.setText(R.string.boxJumps);
            }
            break;
            case CONTEXT_MENU_EEX2:{
                hypertrophy1.setText(R.string.jumpSquats);
            }
            break;
            case CONTEXT_MENU_EEX3:{
                hypertrophy1.setText(R.string.powercleans);
            }
            break;
            case CONTEXT_MENU_EEX4:{
                hypertrophy1.setText(R.string.deepSquatJumps);
            }
            break;
            case CONTEXT_MENU_EEX5:{
                hypertrophy1.setText(R.string.singleLegBoxJumps);
            }
            break;
            case CONTEXT_MENU_EEX6:{
                hypertrophy1.setText(R.string.medBallThrows);
            }
            break;
            case CONTEXT_MENU_EEX7:{
                hypertrophy1.setText(R.string.explosiveSinglePress);
            }
            break;
        }
        return super.onContextItemSelected(item);
    }

    private void updateLine(File data, String ex1, String ex2) throws IOException {
        String values[] = readFromFile(data);
        values[4] = ex1;
        values[5] = ex2;

        FileWriter fw = new FileWriter(data);
        for (int j = 0; j < values.length; j++) {
            fw.write(values[j] + "\n");
        }
        fw.close();
    }

    public static String[] readFromFile(File file){
        String[] values = new String[9];
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
