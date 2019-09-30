package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;

    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getPreferences(MODE_PRIVATE);

        toggleButton =findViewById(R.id.toggleButton);
        toggleButton.setChecked(prefs.getBoolean("TOGGLEBUTTON", false));

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            //Esto sirve para que guarde las variables en el archivo TOGGLEBUTTON
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                prefs.edit().putBoolean("TOGGLEBUTTON", b).apply();
            }
        });
    }
}
