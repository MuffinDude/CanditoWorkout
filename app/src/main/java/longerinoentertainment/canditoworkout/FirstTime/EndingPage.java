package longerinoentertainment.canditoworkout.FirstTime;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import longerinoentertainment.canditoworkout.R;

public class EndingPage extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View beginnerTab = inflater.inflate(R.layout.activity_ending_page, container, false);

        return beginnerTab;
    }
}