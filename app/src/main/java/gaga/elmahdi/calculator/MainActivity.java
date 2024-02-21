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

    public void launchActivity(final int orientation) {
        Intent intent;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            intent = new Intent(this, PortraitActivity.class);
        } else {
            intent = new Intent(this, LandscapeActivity.class);
        }
        startActivity(intent);
        finish();
    }
}