package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    Switch aSwitch;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Fichero de preferencias, lo crea
        prefs = getPreferences(MODE_PRIVATE);


        // ----- TOGGLE BUTTON

        // Con esto pedimos el togglebutton al XML
        toggleButton =findViewById(R.id.toggleButton);
        // Con esta linea indicamos que la variable de TOGGLEBUTON estara en el archivo prefs, en el caso de que dicho archivo no exista el valor por defecto sera false
        toggleButton.setChecked(prefs.getBoolean("TOGGLEBUTTON", false));
        // Con esta linea declaramos que al darle click al boton haga lo de las siguientes lineas
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Esto sirve para que guarde las variable TOGGLEBUTTON en prefs, b es el boolean que hemos marcado arriba de esta linea
                prefs.edit().putBoolean("TOGGLEBUTTON", b).apply();
            }
        });

        // ----- SWITCH

        // Con esto pedimos el togglebutton al XML
        aSwitch =findViewById(R.id.aSwitch);
        // Con esta linea indicamos que la variable de SWITCH estara en el archivo prefs, en el caso de que dicho archivo no exista el valor por defecto sera false
        aSwitch.setChecked(prefs.getBoolean("SWITCH", false));

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Esto sirve para que guarde las variable SWITCH en prefs, b es el boolean que hemos marcado arriba de esta linea
                prefs.edit().putBoolean("SWITCH", b).apply();
            }
        });





    }
}
