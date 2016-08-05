package longerinoentertainment.canditoworkout.FirstTime;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import longerinoentertainment.canditoworkout.MainActivity;
import longerinoentertainment.canditoworkout.R;

public class EndingPage extends Fragment {

    Button finishUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View beginnerTab = inflater.inflate(R.layout.activity_ending_page, container, false);

        finishUp = (Button) beginnerTab.findViewById(R.id.finishButton);

        finishUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });
        return beginnerTab;
    }
}