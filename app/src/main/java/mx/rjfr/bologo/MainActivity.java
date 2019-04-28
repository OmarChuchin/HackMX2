package mx.rjfr.bologo;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {
            public void onPermissionRequest(final PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    request.grant(request.getResources());
                }
            }

            public void onPageFinished(WebView view, String url) {

                // Successfully logged in, load your logged in activity
                if (url.contains("https://cooperatorstravelinsurance.com/CookiesPrepLanding.aspx?pid=2po1fs&lang=en&C=1&checkCookie=true&Source=/TravelInsurance.aspx&Reason=No%20Cookies&AutoClose=1")) {
                    launcActivity();
                }

            }


        });
        webView.loadUrl("http://quenoscumpla.mx/ad_developer/pruebas/hackmx19/");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);

        webView.setWebChromeClient(new WebChromeClient(){
            // Need to accept permissions to use the camera
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    request.grant(request.getResources());
                }
            }


        });

    }

    public void launcActivity(){
        Intent hello = getPackageManager().getLaunchIntentForPackage("com.mygdx.game");
        startActivity(hello);


    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            //super.onBackPressed();
            webView.loadUrl("http://quenoscumpla.mx/ad_developer/pruebas/hackmx19/");
        }
    }

}
