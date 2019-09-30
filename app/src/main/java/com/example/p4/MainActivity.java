package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    Switch aSwitch;
    ToggleButton toggleButton;
    CheckBox checkBox;
    CheckedTextView checkedTextView;
    RadioGroup radioGroup;


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

        // ----- CHECKBOX
        checkBox =findViewById(R.id.checkBox);
        checkBox.setChecked(prefs.getBoolean("CHECKBOX", false));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                prefs.edit().putBoolean("CHECKBOX", b).apply();
            }
        });


        // ----- CHECKEDTEXTVIEW
        checkedTextView =findViewById(R.id.checkedTextView);
        checkedTextView.setChecked(prefs.getBoolean("CHECKEDTEXTVIEW",false));

        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView.toggle();
                prefs.edit().putBoolean("CHECKEDTEXTVIEW", checkedTextView.isChecked()).apply();
            }
        });

        // ----- RADIO GROUP
        radioGroup =findViewById(R.id.radioGroup);
        radioGroup.check(prefs.getInt("RADIOGROUP", radioGroup.getCheckedRadioButtonId()));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            // El int i es donde guardamos la casilla que se ha seleccionado en el radioGroup y la guardaremos en el archivo RADIOGROUP
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                prefs.edit().putInt("RADIOGROUP", i).apply();
            }
        });


    }
}
