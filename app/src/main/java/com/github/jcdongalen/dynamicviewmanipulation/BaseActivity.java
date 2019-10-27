package com.github.jcdongalen.dynamicviewmanipulation;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    protected CharSequence baseFormat(String target, Object... params) {
        return String.format(Locale.getDefault(), String.format(target, params));
    }

}
