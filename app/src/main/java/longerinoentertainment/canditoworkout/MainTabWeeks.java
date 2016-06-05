package longerinoentertainment.canditoworkout;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainTabWeeks extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View weekTab = inflater.inflate(R.layout.activity_main_tab_weeks, container, false);
        return weekTab;
    }
}
