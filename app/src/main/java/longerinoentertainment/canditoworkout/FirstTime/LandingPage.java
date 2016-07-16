package longerinoentertainment.canditoworkout.FirstTime;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import longerinoentertainment.canditoworkout.R;

public class LandingPage extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View beginnerTab = inflater.inflate(R.layout.activity_landing_page, container, false);
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
        return beginnerTab;
    }
}