package longerinoentertainment.canditoworkout.FirstTime;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class FirstOptionalLegs extends Fragment {
    Button hypertrophy1;
    Button explosiveness1;
    Button explosiveness2;
    Button hypertrophy2;
    Button save;
    CheckBox none;
    CheckBox none2;
    LinearLayout ex1;
    LinearLayout ex2;
    TextView rightNow;
    final int[] numero = {0,1};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View beginnerTab = inflater.inflate(R.layout.activity_first_optional_legs, container, false);
        hypertrophy1 = (Button) beginnerTab.findViewById(R.id.hypertrophyButton1);
        hypertrophy2 = (Button) beginnerTab.findViewById(R.id.hypertrophyButton2);
        explosiveness1 = (Button) beginnerTab.findViewById(R.id.explosivenessButton1);
        explosiveness2 = (Button) beginnerTab.findViewById(R.id.explosivenessButton2);
        rightNow = (TextView) beginnerTab.findViewById(R.id.rightNow);
        save = (Button) beginnerTab.findViewById(R.id.saveButton);
        none = (CheckBox) beginnerTab.findViewById(R.id.noneBox);
        none2 = (CheckBox) beginnerTab.findViewById(R.id.noneBox2);
        ex1 = (LinearLayout) beginnerTab.findViewById(R.id.ex1Layout);
        ex2 = (LinearLayout) beginnerTab.findViewById(R.id.ex2Layout);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        String[] values = readFromFile(new File(dir, "savedFile.txt"));
        rightNow.setText("Right now you have chosen: " + values[4] + " and " + values[5]);




        hypertrophy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(hypertrophy1);
                getActivity().openContextMenu(hypertrophy1);
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
                getActivity().openContextMenu(explosiveness1);
                explosiveness1.setBackgroundColor(0xFF3399ff);
                hypertrophy1.setBackgroundColor(0xFF000000);
                hypertrophy1.setText(R.string.hypertrophy);
                numero[0]= 2;
            }
        });

        hypertrophy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(hypertrophy2);
                getActivity().openContextMenu(hypertrophy2);
                hypertrophy2.setBackgroundColor(0xFF3399ff);
                explosiveness2.setBackgroundColor(0xFF000000);
                explosiveness2.setText(R.string.explosiveness);
                numero[1] = 1;
            }
        });
        explosiveness2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(explosiveness2);
                getActivity().openContextMenu(explosiveness2);
                explosiveness2.setBackgroundColor(0xFF3399ff);
                hypertrophy2.setBackgroundColor(0xFF000000);
                hypertrophy2.setText(R.string.hypertrophy);
                numero[1]= 2;
            }
        });

        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero[0]=0;
                numero[1]=0;
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
                numero[1]=0;
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
        return beginnerTab;
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
    final int CONTEXT_MENU_2EX1 =15;
    final int CONTEXT_MENU_2EX2 =16;
    final int CONTEXT_MENU_2EX3 =17;
    final int CONTEXT_MENU_2EX4 =18;
    final int CONTEXT_MENU_2EX5 =19;
    final int CONTEXT_MENU_2EX6 =20;
    final int CONTEXT_MENU_2EX7 =21;
    final int CONTEXT_MENU_2EEX1 =22;
    final int CONTEXT_MENU_2EEX2 =23;
    final int CONTEXT_MENU_2EEX3 =24;
    final int CONTEXT_MENU_2EEX4 =25;
    final int CONTEXT_MENU_2EEX5 =26;
    final int CONTEXT_MENU_2EEX6 =27;
    final int CONTEXT_MENU_2EEX7 =28;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Context menu
        if (v.getId() == R.id.hypertrophyButton1){
            menu.setHeaderTitle("Hypertrophy");
            menu.add(Menu.NONE, CONTEXT_MENU_EX1, Menu.NONE, R.string.calfLeg);
            menu.add(Menu.NONE, CONTEXT_MENU_EX2, Menu.NONE, R.string.otherCalf);
            menu.add(Menu.NONE, CONTEXT_MENU_EX3, Menu.NONE, R.string.legCurl);
            menu.add(Menu.NONE, CONTEXT_MENU_EX4, Menu.NONE, R.string.legExtension);
            menu.add(Menu.NONE, CONTEXT_MENU_EX5, Menu.NONE, R.string.isolationGlutes);
            menu.add(Menu.NONE, CONTEXT_MENU_EX6, Menu.NONE, R.string.singleLegPress);
            menu.add(Menu.NONE, CONTEXT_MENU_EX7, Menu.NONE, R.string.singleLegCurl);
        }else if (v.getId() == R.id.hypertrophyButton2){
            menu.setHeaderTitle("Hypertrophy");
            menu.add(Menu.NONE, CONTEXT_MENU_2EX1, Menu.NONE, R.string.calfLeg);
            menu.add(Menu.NONE, CONTEXT_MENU_2EX2, Menu.NONE, R.string.otherCalf);
            menu.add(Menu.NONE, CONTEXT_MENU_2EX3, Menu.NONE, R.string.legCurl);
            menu.add(Menu.NONE, CONTEXT_MENU_2EX4, Menu.NONE, R.string.legExtension);
            menu.add(Menu.NONE, CONTEXT_MENU_2EX5, Menu.NONE, R.string.isolationGlutes);
            menu.add(Menu.NONE, CONTEXT_MENU_2EX6, Menu.NONE, R.string.singleLegPress);
            menu.add(Menu.NONE, CONTEXT_MENU_2EX7, Menu.NONE, R.string.singleLegCurl);
        }else if (v.getId() == R.id.explosivenessButton2){
            menu.setHeaderTitle("Explosiveness");
            menu.add(Menu.NONE, CONTEXT_MENU_2EEX1, Menu.NONE, R.string.boxJumps);
            menu.add(Menu.NONE, CONTEXT_MENU_2EEX2, Menu.NONE, R.string.jumpSquats);
            menu.add(Menu.NONE, CONTEXT_MENU_2EEX3, Menu.NONE, R.string.powercleans);
            menu.add(Menu.NONE, CONTEXT_MENU_2EEX4, Menu.NONE, R.string.deepSquatJumps);
            menu.add(Menu.NONE, CONTEXT_MENU_2EEX5, Menu.NONE, R.string.singleLegBoxJumps);
            menu.add(Menu.NONE, CONTEXT_MENU_2EEX6, Menu.NONE, R.string.medBallThrows);
            menu.add(Menu.NONE, CONTEXT_MENU_2EEX7, Menu.NONE, R.string.explosiveSinglePress);
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
                explosiveness1.setText(R.string.boxJumps);
            }
            break;
            case CONTEXT_MENU_EEX2:{
                explosiveness1.setText(R.string.jumpSquats);
            }
            break;
            case CONTEXT_MENU_EEX3:{
                explosiveness1.setText(R.string.powercleans);
            }
            break;
            case CONTEXT_MENU_EEX4:{
                explosiveness1.setText(R.string.deepSquatJumps);
            }
            break;
            case CONTEXT_MENU_EEX5:{
                explosiveness1.setText(R.string.singleLegBoxJumps);
            }
            break;
            case CONTEXT_MENU_EEX6:{
                explosiveness1.setText(R.string.medBallThrows);
            }
            break;
            case CONTEXT_MENU_EEX7:{
                explosiveness1.setText(R.string.explosiveSinglePress);
            }
            break;
            case CONTEXT_MENU_2EX1:{
                hypertrophy2.setText(R.string.calfLeg);
            }
            break;
            case CONTEXT_MENU_2EX2:{
                hypertrophy2.setText(R.string.otherCalf);
            }
            break;
            case CONTEXT_MENU_2EX3:{
                hypertrophy2.setText(R.string.legCurl);
            }
            break;
            case CONTEXT_MENU_2EX4:{
                hypertrophy2.setText(R.string.legExtension);
            }
            break;
            case CONTEXT_MENU_2EX5:{
                hypertrophy2.setText(R.string.isolationGlutes);
            }
            break;
            case CONTEXT_MENU_2EX6:{
                hypertrophy2.setText(R.string.singleLegPress);
            }
            break;
            case CONTEXT_MENU_2EX7:{
                hypertrophy2.setText(R.string.singleLegCurl);
            }
            break;
            case CONTEXT_MENU_2EEX1:{
                explosiveness2.setText(R.string.boxJumps);
            }
            break;
            case CONTEXT_MENU_2EEX2:{
                explosiveness2.setText(R.string.jumpSquats);
            }
            break;
            case CONTEXT_MENU_2EEX3:{
                explosiveness2.setText(R.string.powercleans);
            }
            break;
            case CONTEXT_MENU_2EEX4:{
                explosiveness2.setText(R.string.deepSquatJumps);
            }
            break;
            case CONTEXT_MENU_2EEX5:{
                explosiveness2.setText(R.string.singleLegBoxJumps);
            }
            break;
            case CONTEXT_MENU_2EEX6:{
                explosiveness2.setText(R.string.medBallThrows);
            }
            break;
            case CONTEXT_MENU_2EEX7:{
                explosiveness2.setText(R.string.explosiveSinglePress);
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

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                // TODO: This shit does not work, make it work.
                Log.d("MyFragment", "Not visible anymore.  Saving data.");
                final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
                final File file = new File(dir, "savedFile.txt");

                String ex1,ex2;
                if (numero[0]== 1){
                    ex1= (String) hypertrophy1.getText();
                } else if (numero[0] == 0){
                    ex1="None";
                }else{
                    ex1= (String) explosiveness1.getText();
                }
                if (numero[1]==1){
                    ex2 = (String) hypertrophy2.getText();
                }else if (numero[1]==0){
                    ex2="None";
                }else{
                    ex2 = (String) explosiveness2.getText();
                }
                try {
                    updateLine(file, ex1, ex2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
