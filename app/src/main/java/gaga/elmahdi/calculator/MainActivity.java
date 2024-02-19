package gaga.elmahdi.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;
        launchActivity(orientation);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        launchActivity(newConfig.orientation);
    }

    private void launchActivity(final int orientation) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            startActivity(new Intent(this, PortraitActivity.class));
        } else {
            startActivity(new Intent(this, LandscapeActivity.class));
        }
    }
}