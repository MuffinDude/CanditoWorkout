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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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

        final File dir = new File(getFilesDir() + "/CanditoWorkoutApp");

        hypertrophy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(hypertrophy1);
                openContextMenu(hypertrophy1);
                hypertrophy1.setBackgroundColor(0xFF3399ff);
                explosiveness1.setBackgroundColor(0xFF000000);
                explosiveness1.setText(R.string.explosiveness);
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
            }
        });

        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                }else{
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    ex2.setForeground(drawable);
                    hypertrophy2.setVisibility(View.VISIBLE);
                    explosiveness2.setVisibility(View.VISIBLE);
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 22.06.2016 saves all the stuff
                finish();
            }
        });
    }

    final int CONTEXT_MENU_VIEW =1;
    final int CONTEXT_MENU_EDIT =2;
    final int CONTEXT_MENU_ARCHIVE =3;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        //Context menu
        if (v.getId() == R.id.explosivenessButton1){
            menu.setHeaderTitle("My Context Menu");
            menu.add(Menu.NONE, CONTEXT_MENU_VIEW, Menu.NONE, "Add");
            menu.add(Menu.NONE, CONTEXT_MENU_EDIT, Menu.NONE, "Edit");
            menu.add(Menu.NONE, CONTEXT_MENU_ARCHIVE, Menu.NONE, "Delete");
        }else{
            menu.setHeaderTitle("My Context Menu");
            menu.add(Menu.NONE, CONTEXT_MENU_VIEW, Menu.NONE, "asdsdd");
            menu.add(Menu.NONE, CONTEXT_MENU_EDIT, Menu.NONE, "asdsadit");
            menu.add(Menu.NONE, CONTEXT_MENU_ARCHIVE, Menu.NONE, "Deledgdge");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case CONTEXT_MENU_VIEW:{
                hypertrophy1.setText("view");
            }
            break;

            case CONTEXT_MENU_EDIT:{
                hypertrophy1.setText("edit");
            }
            break;

            case CONTEXT_MENU_ARCHIVE:{
                hypertrophy1.setText("archive");
            }
            break;
        }
        return super.onContextItemSelected(item);
    }

    private void updateLine(File data, String toUpdate, String updated) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(data));
        String line;
        String input = "";

        while ((line = file.readLine()) != null)
            input += line + System.lineSeparator();

        //okei, teeb muutujad mis salvestavad avamisel kohe ära algsed andmed ja pärast, salvestamisel, leiab algsed andmed ja asendab uute andmetega, yaaas

        //Checking the contents of the text file
        System.out.println(input);
        input = input.replace(toUpdate, updated);

        FileOutputStream os = new FileOutputStream(data);
        os.write(input.getBytes());

        file.close();
        os.close();
    }
}
