package com.github.jcdongalen.dynamicviewmanipulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import java.util.Locale;

public class DynamicViewActivity extends BaseActivity {

    private static final String TAG = DynamicViewActivity.class.getSimpleName();

    View overlay;
    View camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view);

        overlay = findViewById(R.id.overlay);
        camera = findViewById(R.id.camera);

        final ViewTreeObserver vto = overlay.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                vto.removeOnGlobalLayoutListener(this);
                Log.i(TAG, "ViewTreeObserver has been detected the layout change.");
                int width = overlay.getWidth();
                int height = overlay.getHeight();
                Toast.makeText(DynamicViewActivity.this, baseFormat("overlay(width: %d, height: %d)", width, height), Toast.LENGTH_LONG).show();
            }
        });
        Log.i(TAG, "ViewTreeObserver has been registered.");

    }
}
