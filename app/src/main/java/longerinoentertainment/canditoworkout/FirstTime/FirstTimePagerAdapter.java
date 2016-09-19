package longerinoentertainment.canditoworkout.FirstTime;

/**
 * Created by Rauno on 19.09.2016.
 */
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Random;

public class FirstTimePagerAdapter extends PagerAdapter {

    private final Random random = new Random();
    private int mSize;

    public FirstTimePagerAdapter() {
        mSize = 6;
    }

    public FirstTimePagerAdapter(int count) {
        mSize = count;
    }

    @Override public int getCount() {
        return mSize;
    }

    @Override public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override public Object instantiateItem(ViewGroup view, int position) {
        TextView textView = new TextView(view.getContext());
        textView.setText(String.valueOf(position + 1));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(48);
        view.addView(textView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return textView;
    }

}