package focallocal.org.focallocal;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        CustomTabsMethod();
    }
    public void CustomTabsMethod() {
        String url = "https://focallocal.org/sign-in";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        int primaryOrange = Color.parseColor("#f97a25");
        CustomTabsIntent customTabsIntent = builder.build();
        builder.setToolbarColor(primaryOrange);
        customTabsIntent.intent.putExtra(Intent.EXTRA_REFERRER,Uri.parse(url));

        // Sets sign-in URL to be called correctly (Focal Local only)
        customTabsIntent.launchUrl(this, Uri.parse(url));

        // Sets URL back to Focal Local Home page so onLoad Home is loaded
        url = "https://focallocal.org/";
        customTabsIntent.launchUrl(this, Uri.parse(url));

    }
}
