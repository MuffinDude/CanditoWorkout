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
    private String myPdfUrl = "http://www.canditotraininghq.com/app/download/911765404/Candito+6+Week+Strength+Program.pdf";
    private String url = "http://docs.google.com/gview?embedded=true&url=" + myPdfUrl;
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