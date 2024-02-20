package gaga.elmahdi.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_CURRENT_ORIENTATION = "current_orientation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;
        if (savedInstanceState != null) {
            orientation = savedInstanceState.getInt(KEY_CURRENT_ORIENTATION, orientation);
        }

        launchActivity(orientation);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_CURRENT_ORIENTATION, getResources().getConfiguration().orientation);
    }

    private void launchActivity(final int orientation) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            startActivity(new Intent(this, PortraitActivity.class));
        } else {
            startActivity(new Intent(this, LandscapeActivity.class));
        }
        finish();
    }
}