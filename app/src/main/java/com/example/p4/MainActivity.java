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


        // ----- TOGGLE BUTTON
        prefs = getPreferences(MODE_PRIVATE);
        // Con esto pedimos el togglebutton al XML
        toggleButton =findViewById(R.id.toggleButton);
        // Con esta linea indicamos que la variable de prefs estara en el archivo TOGGLEBUTTON, en el caso de que dicho archivo no exista el valor por defecto sera true
        toggleButton.setChecked(prefs.getBoolean("TOGGLEBUTTON", false));
        // Con esta linea declaramos que al darle click al boton haga lo de las siguientes lineas
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Esto sirve para que guarde las variables en el archivo TOGGLEBUTTON
                prefs.edit().putBoolean("TOGGLEBUTTON", b).apply();
            }
        });







    }
}
