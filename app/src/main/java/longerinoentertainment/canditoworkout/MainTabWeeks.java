package longerinoentertainment.canditoworkout;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import longerinoentertainment.canditoworkout.Week1.Week1;


public class MainTabWeeks extends Fragment {
    public Button week1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View weekTab = inflater.inflate(R.layout.activity_main_tab_weeks, container, false);

        week1 = (Button) weekTab.findViewById(R.id.week1Button);
        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), Week1.class);
                startActivity(i);
            }
        });

        return weekTab;
    }
}
