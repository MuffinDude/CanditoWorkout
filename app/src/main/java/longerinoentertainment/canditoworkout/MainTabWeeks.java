package longerinoentertainment.canditoworkout;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import longerinoentertainment.canditoworkout.Week1.Week1;
import longerinoentertainment.canditoworkout.Week2.Week2;
import longerinoentertainment.canditoworkout.Week3.Week3;
import longerinoentertainment.canditoworkout.Week4.Week4;
import longerinoentertainment.canditoworkout.Week5.Week5;
import longerinoentertainment.canditoworkout.Week6.Week6;


public class MainTabWeeks extends Fragment {
    public Button week1, week2, week3, week4, week5, week6, newCycle;
    public ToggleButton weekToggle1, weekToggle2, weekToggle3, weekToggle4, weekToggle5;
    LinearLayout w1, w2, w3, w4, w5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View weekTab = inflater.inflate(R.layout.activity_main_tab_weeks, container, false);

        week1 = (Button) weekTab.findViewById(R.id.week1Button);
        week2 = (Button) weekTab.findViewById(R.id.week2Button);
        week3 = (Button) weekTab.findViewById(R.id.week3Button);
        week4 = (Button) weekTab.findViewById(R.id.week4Button);
        week5 = (Button) weekTab.findViewById(R.id.week5Button);
        week6 = (Button) weekTab.findViewById(R.id.week6Button);
        newCycle = (Button) weekTab.findViewById(R.id.newCycleButton);
        w1 = (LinearLayout) weekTab.findViewById(R.id.weekLayout1);
        w2 = (LinearLayout) weekTab.findViewById(R.id.weekLayout2);
        w3 = (LinearLayout) weekTab.findViewById(R.id.weekLayout3);
        w4 = (LinearLayout) weekTab.findViewById(R.id.weekLayout4);
        w5 = (LinearLayout) weekTab.findViewById(R.id.weekLayout5);
        weekToggle1 = (ToggleButton) weekTab.findViewById(R.id.weekToggle1);
        weekToggle2 = (ToggleButton) weekTab.findViewById(R.id.weekToggle2);
        weekToggle3 = (ToggleButton) weekTab.findViewById(R.id.weekToggle3);
        weekToggle4 = (ToggleButton) weekTab.findViewById(R.id.weekToggle4);
        weekToggle5 = (ToggleButton) weekTab.findViewById(R.id.weekToggle5);

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "weeks.txt");
        String[] values = readFromFile(new File(dir, "weeks.txt"));
        readFromFile(file);

        if (Integer.parseInt(values[0]) == 1) {
            weekToggle1.setChecked(true);
            w1.setBackgroundColor(Color.parseColor("#7b5454"));
            weekToggle1.setText("DONE");
        }else weekToggle1.setText("DONE?");
        if (Objects.equals(values[1], "1")) {
            weekToggle2.setChecked(true);
            w2.setBackgroundColor(Color.parseColor("#7b5454"));
            weekToggle2.setText("DONE");
        }else weekToggle2.setText("DONE?");
        if  (Objects.equals(values[2], "1")) {
            weekToggle3.setChecked(true);
            w3.setBackgroundColor(Color.parseColor("#7b5454"));
            weekToggle3.setText("DONE");
        }else weekToggle3.setText("DONE?");
        if  (Objects.equals(values[3], "1")) {
            weekToggle4.setChecked(true);
            w4.setBackgroundColor(Color.parseColor("#7b5454"));
            weekToggle4.setText("DONE");
        }else weekToggle4.setText("DONE?");
        if  (Objects.equals(values[4], "1")) {
            weekToggle5.setChecked(true);
            w5.setBackgroundColor(Color.parseColor("#7b5454"));
            weekToggle5.setText("DONE");
        }else weekToggle5.setText("DONE?");

        weekToggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    w1.setBackgroundColor(Color.parseColor("#7b5454"));
                    weekToggle1.setTextOn("DONE");
                    try {
                        updateLine("one", 1, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    w1.setBackgroundColor(Color.parseColor("#5c5c5c"));
                    weekToggle1.setTextOff("DONE?");
                    try {
                        updateLine("one", 0, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        weekToggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    w2.setBackgroundColor(Color.parseColor("#7b5454"));
                    weekToggle2.setTextOn("DONE");
                    try {
                        updateLine("two", 1, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    w2.setBackgroundColor(Color.parseColor("#5c5c5c"));
                    weekToggle2.setTextOff("DONE?");
                    try {
                        updateLine("two", 0, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        weekToggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    w3.setBackgroundColor(Color.parseColor("#7b5454"));
                    weekToggle3.setTextOn("DONE");
                    try {
                        updateLine("three", 1, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    w3.setBackgroundColor(Color.parseColor("#5c5c5c"));
                    weekToggle3.setTextOff("DONE?");
                    try {
                        updateLine("three", 0, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        weekToggle4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    w4.setBackgroundColor(Color.parseColor("#7b5454"));
                    weekToggle4.setTextOn("DONE");
                    try {
                        updateLine("four", 1, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    w4.setBackgroundColor(Color.parseColor("#5c5c5c"));
                    weekToggle4.setTextOff("DONE?");
                    try {
                        updateLine("four", 0, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        weekToggle5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    w5.setBackgroundColor(Color.parseColor("#7b5454"));
                    weekToggle5.setTextOn("DONE");
                    try {
                        updateLine("five", 1, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    w5.setBackgroundColor(Color.parseColor("#5c5c5c"));
                    weekToggle5.setTextOff("DONE?");
                    try {
                        updateLine("five", 0, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        newCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.setBackgroundColor(Color.parseColor("#5c5c5c"));
                w2.setBackgroundColor(Color.parseColor("#5c5c5c"));
                w3.setBackgroundColor(Color.parseColor("#5c5c5c"));
                w4.setBackgroundColor(Color.parseColor("#5c5c5c"));
                w5.setBackgroundColor(Color.parseColor("#5c5c5c"));
                weekToggle1.setChecked(false);
                weekToggle2.setChecked(false);
                weekToggle3.setChecked(false);
                weekToggle4.setChecked(false);
                weekToggle5.setChecked(false);

                try {
                    updateLine("one", 0, file);
                    updateLine("two", 0, file);
                    updateLine("three", 0, file);
                    updateLine("four", 0, file);
                    updateLine("five", 0, file);
                    updateLine("counter", 1, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Week1.class);
                startActivity(i);
            }
        });
        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Week2.class);
                startActivity(i);
            }
        });
        week3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Week3.class);
                startActivity(i);
            }
        });
        week4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Week4.class);
                startActivity(i);
            }
        });
        week5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Week5.class);
                startActivity(i);
            }
        });
        week6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Week6.class);
                startActivity(i);
            }
        });

        return weekTab;
    }

    private void updateLine(String weekDay, int doneOrNot, File data) throws IOException {
        String values[] = readFromFile(data);

        if (Objects.equals(weekDay, "one"))values[0]=Integer.toString(doneOrNot);
        if (Objects.equals(weekDay, "two"))values[1]=Integer.toString(doneOrNot);
        if (Objects.equals(weekDay, "three"))values[2]=Integer.toString(doneOrNot);
        if (Objects.equals(weekDay, "four"))values[3]=Integer.toString(doneOrNot);
        if (Objects.equals(weekDay, "five"))values[4]=Integer.toString(doneOrNot);
        if (Objects.equals(weekDay, "counter")) {
            if (Objects.equals(values[5], "null"))values[5]="0";
            values[5]=Integer.toString(Integer.parseInt(values[5])+ doneOrNot);
        }
        System.out.println("COUNTER ON HETKEL: " + values[5]);
        /*
        values[0] = week1;
        values[1] = week2;
        values[2] = week3;
        values[3] = week4;
        values[4] = week5;
        values[5] = counter;
        */

        FileWriter fw = new FileWriter(data);
        for (int j = 0; j < values.length; j++) {
            fw.write(values[j] + "\n");
        }
        fw.close();
    }

    public static String[] readFromFile(File file){
        String[] values = new String[6];
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
