package longerinoentertainment.canditoworkout;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import longerinoentertainment.canditoworkout.Week1.Week1;
import longerinoentertainment.canditoworkout.Week2.Week2;


public class MainTabWeeks extends Fragment {
    public Button week1;
    public Button week2;
    public Button week3;
    public Button week4;
    public Button week5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View weekTab = inflater.inflate(R.layout.activity_main_tab_weeks, container, false);

        week1 = (Button) weekTab.findViewById(R.id.week1Button);
        week2 = (Button) weekTab.findViewById(R.id.week2Button);
        week3 = (Button) weekTab.findViewById(R.id.week3Button);
        week4 = (Button) weekTab.findViewById(R.id.week4Button);
        week5 = (Button) weekTab.findViewById(R.id.week5Button);
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

        return weekTab;
    }
}
