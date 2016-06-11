package longerinoentertainment.canditoworkout.Week2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import longerinoentertainment.canditoworkout.R;

public class Day1 extends Fragment {

    ImageButton info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View infoTab = inflater.inflate(R.layout.activity_day12, container, false);

        info = (ImageButton) infoTab.findViewById(R.id.infoButton);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),
                        "Still complete the 5 sets of 3 reps regardless even if you do perform less than 8 reps on the MR10 set", Toast.LENGTH_LONG).show();
            }
        });

        return infoTab;
    }
}
