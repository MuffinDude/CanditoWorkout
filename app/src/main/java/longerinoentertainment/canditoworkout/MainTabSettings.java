package longerinoentertainment.canditoworkout;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import longerinoentertainment.canditoworkout.Settings.SettingsAccessoryExercises;
import longerinoentertainment.canditoworkout.Settings.SettingsMaxReps;
import longerinoentertainment.canditoworkout.Settings.SettingsOptionalArms;
import longerinoentertainment.canditoworkout.Settings.SettingsOptionalLegs;

public class MainTabSettings extends Fragment {
    Button maxReps,accessory, optionalArms, optionalLegs;
    ImageButton superSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View settingsTab = inflater.inflate(R.layout.activity_main_tab_settings, container, false);

        maxReps = (Button) settingsTab.findViewById(R.id.maxRepsButton);
        accessory = (Button) settingsTab.findViewById(R.id.accessoryButton);
        optionalArms = (Button) settingsTab.findViewById(R.id.optionalArmsButton);
        optionalLegs = (Button) settingsTab.findViewById(R.id.optionalLegsButton);
        superSettings = (ImageButton) settingsTab.findViewById(R.id.secretSettingsButton);

        maxReps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SettingsMaxReps.class);
                startActivity(i);
            }
        });
        superSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SecretInfo.class);
                startActivity(i);
            }
        });
        accessory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SettingsAccessoryExercises.class);
                startActivity(i);
            }
        });
        optionalArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SettingsOptionalArms.class);
                startActivity(i);
            }
        });
        optionalLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SettingsOptionalLegs.class);
                startActivity(i);
            }
        });

        return settingsTab;
    }
}