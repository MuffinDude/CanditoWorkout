package longerinoentertainment.canditoworkout;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

public class MainTabInfo extends Fragment {
    private String url = "file:///android_asset/candito6weekINTRO.htm";
    private WebView mWebView;
    private static final String TAG = "YOUR-TAG-NAME";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View infoTab = inflater.inflate(R.layout.activity_main_tab_info, container, false);
        mWebView = (WebView) infoTab.findViewById(R.id.webView);
        Log.i(TAG, "Opening PDF: " + url);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        return infoTab;
    }
}