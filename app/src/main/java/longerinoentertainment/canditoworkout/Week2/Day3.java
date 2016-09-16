package longerinoentertainment.canditoworkout.Week2;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import longerinoentertainment.canditoworkout.R;

public class Day3  extends Fragment {

    Button squat1;
    Button sqt1;
    Button sqt2;
    Button sqt3;
    Button sqt4;
    Button sqt5;
    Button sqt6;
    Button sqt7;
    Button sqt8;
    Button sqt9;
    Button sqt10;
    Button calculate;
    TextView repsMade, failureText, completionText;
    RelativeLayout optional1;
    RelativeLayout optional2;
    TextView optionalOne;
    TextView optionalTwo;
    LinearLayout backoffSets;
    Button stopper;
    Chronometer chronometer;
    private long timeWhenStopped = 0;
    static double decimeterPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day32, container, false);

        squat1 = (Button) infoTab.findViewById(R.id.squatText1);
        sqt1 = (Button) infoTab.findViewById(R.id.squat1);
        sqt2 = (Button) infoTab.findViewById(R.id.squat2);
        sqt3 = (Button) infoTab.findViewById(R.id.squat3);
        sqt4 = (Button) infoTab.findViewById(R.id.squat4);
        sqt5 = (Button) infoTab.findViewById(R.id.squat5);
        sqt6 = (Button) infoTab.findViewById(R.id.squat6);
        sqt7 = (Button) infoTab.findViewById(R.id.squat7);
        sqt8 = (Button) infoTab.findViewById(R.id.squat8);
        sqt9 = (Button) infoTab.findViewById(R.id.squat9);
        sqt10 = (Button) infoTab.findViewById(R.id.squat10);
        stopper = (Button) infoTab.findViewById(R.id.stopperButton);
        chronometer = (Chronometer) infoTab.findViewById(R.id.chronometer);
        optional1 = (RelativeLayout) infoTab.findViewById(R.id.optional1);
        optional2 = (RelativeLayout) infoTab.findViewById(R.id.optional2);
        optionalOne = (TextView) infoTab.findViewById(R.id.optionalOne);
        optionalTwo = (TextView) infoTab.findViewById(R.id.optionalTwo);
        Button optionalB1 = (Button) infoTab.findViewById(R.id.button23);
        Button optionalB2 = (Button) infoTab.findViewById(R.id.button24);
        Button optionalB3 = (Button) infoTab.findViewById(R.id.button25);
        Button optionalB4 = (Button) infoTab.findViewById(R.id.button27);
        Button optionalB5 = (Button) infoTab.findViewById(R.id.button28);
        Button optionalB6 = (Button) infoTab.findViewById(R.id.button30);
        calculate = (Button) infoTab.findViewById(R.id.calculateButton);
        repsMade = (TextView) infoTab.findViewById(R.id.completedReps);
        backoffSets = (LinearLayout) infoTab.findViewById(R.id.backoffSets);
        failureText = (TextView) infoTab.findViewById(R.id.failureText);
        completionText = (TextView) infoTab.findViewById(R.id.completionText);

        backoffSets.setVisibility(View.GONE);
        failureText.setVisibility(View.GONE);

        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }
        });

        final File dir = new File(getContext().getFilesDir() + "/CanditoWorkoutApp");
        final File file = new File(dir, "savedFile.txt");
        final String[] values = readFromFile(new File(dir, "savedFile.txt"));
        readFromFile(file);

        if (values[3].equals("1")) decimeterPoint = 2.5;
        if (values[3].equals("0")) decimeterPoint = 5;
        double squatNumber = round(values[1], decimeterPoint);
        final double failureNumber = squatNumber*0.025;


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You can only rest 60 seconds after each set of X3",
                        Toast.LENGTH_LONG).show();
                completionText.setVisibility(View.GONE);
                String gottenReps = repsMade.getText().toString();
                int repCount;
                if (gottenReps.equals("")){
                    repCount=0;
                    repsMade.setText("0");
                }else{
                    repCount= Integer.parseInt(gottenReps);
                }
                if (repCount >=10 ){
                    backoffSets.setVisibility(View.VISIBLE);
                    failureText.setVisibility(View.GONE);
                    sqt1.setVisibility(View.VISIBLE);
                    sqt2.setVisibility(View.VISIBLE);
                    sqt3.setVisibility(View.VISIBLE);
                    sqt4.setVisibility(View.VISIBLE);
                    sqt5.setVisibility(View.VISIBLE);
                    sqt6.setVisibility(View.VISIBLE);
                    sqt7.setVisibility(View.VISIBLE);
                    sqt8.setVisibility(View.VISIBLE);
                    sqt9.setVisibility(View.VISIBLE);
                    sqt10.setVisibility(View.VISIBLE);
                }else if (repCount==8 || repCount==9){
                    backoffSets.setVisibility(View.VISIBLE);
                    sqt1.setVisibility(View.VISIBLE);
                    sqt2.setVisibility(View.VISIBLE);
                    sqt3.setVisibility(View.VISIBLE);
                    sqt4.setVisibility(View.VISIBLE);
                    sqt5.setVisibility(View.VISIBLE);
                    sqt6.setVisibility(View.VISIBLE);
                    sqt7.setVisibility(View.VISIBLE);
                    sqt8.setVisibility(View.VISIBLE);
                    sqt10.setVisibility(View.GONE);
                    sqt9.setVisibility(View.GONE);
                    failureText.setVisibility(View.GONE);
                }else if (repCount==7){
                    backoffSets.setVisibility(View.VISIBLE);
                    sqt1.setVisibility(View.VISIBLE);
                    sqt2.setVisibility(View.VISIBLE);
                    sqt3.setVisibility(View.VISIBLE);
                    sqt4.setVisibility(View.VISIBLE);
                    sqt5.setVisibility(View.VISIBLE);
                    sqt10.setVisibility(View.GONE);
                    sqt9.setVisibility(View.GONE);
                    sqt8.setVisibility(View.GONE);
                    sqt7.setVisibility(View.GONE);
                    sqt6.setVisibility(View.GONE);
                    failureText.setVisibility(View.GONE);
                }else{
                    backoffSets.setVisibility(View.GONE);
                    failureText.setVisibility(View.VISIBLE);
                    failureText.setText("Reduce the max Squat in the Settings by " + failureNumber);
                }
            }
        });

        String squatText = Double.toString(squatNumber+decimeterPoint) + " x10MR";
        String squatTextSixty = Double.toString(squatNumber-decimeterPoint) + " x3";
        squat1.setText(squatText);
        sqt1.setText(squatTextSixty);
        sqt2.setText(squatTextSixty);
        sqt3.setText(squatTextSixty);
        sqt4.setText(squatTextSixty);
        sqt5.setText(squatTextSixty);
        sqt6.setText(squatTextSixty);
        sqt7.setText(squatTextSixty);
        sqt8.setText(squatTextSixty);
        sqt9.setText(squatTextSixty);
        sqt10.setText(squatTextSixty);

        squat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                squat1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt5.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt6.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt7.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt8.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt9.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });
        sqt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqt10.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
                Toast.makeText(getActivity(), "Stopper started", Toast.LENGTH_SHORT).show();
            }
        });

        if (values[4].equals("None")){
            optional1.setVisibility(View.GONE);
            optional2.setVisibility(View.GONE);
        }else if (values[5].equals("None")){
            optional2.setVisibility(View.GONE);

            if (values[4].substring(values[4].length()-1).equals("E")){
                optionalOne.setText(values[4].substring(0,values[4].length()-1));
                optionalB1.setText("x4");
                optionalB2.setText("x4");
                optionalB3.setText("x4");
            }else{
                optionalOne.setText(values[4]);
                optionalB1.setText("x7-10");
                optionalB2.setText("x7-10");
                optionalB3.setText("x7-10");
            }
        }else{
            if (values[4].substring(values[4].length()-1).equals("E")){
                optionalOne.setText(values[4].substring(0,values[4].length()-1));
                optionalB1.setText("x4");
                optionalB2.setText("x4");
                optionalB3.setText("x4");
            }else{
                optionalOne.setText(values[4]);
                optionalB1.setText("x7-10");
                optionalB2.setText("x7-10");
                optionalB3.setText("x7-10");
            }
            if (values[5].substring(values[5].length()-1).equals("E")){
                optionalTwo.setText(values[5].substring(0,values[5].length()-1));
                optionalB4.setText("x4");
                optionalB5.setText("x4");
                optionalB6.setText("x4");
            }else{
                optionalTwo.setText(values[5]);
                optionalB4.setText("x7-10");
                optionalB5.setText("x7-10");
                optionalB6.setText("x7-10");
            }
        }

        return infoTab;
    }
    public String[] readFromFile(File file){
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
        catch (IOException ignored){
        }
        return values;
    }
    public static double round(String valueString, double units) {
        double value = Math.round(Math.round(Double.parseDouble(valueString)/units)*units * 0.8/units)*units;
        return value;
    }
}
