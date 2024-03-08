package com.salinas.temperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.salinas.temperatura.model.Temperatura;


import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerOrigen;
    private Spinner spinnerDestino;
    private EditText editTextValor;
    private Button buttonConvertir;
    private Button buttonNuevo;
    private Button buttonSalir;

    String [] opcionesTemperatura = {
            "-SELECCIONE TEMPERATURA-",
            "Celsius",
            "Fahreheit",
            "Kelvin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerOrigen = findViewById(R.id.spinnerOrigen);
        spinnerDestino = findViewById(R.id.spinnerDestino);
        editTextValor = findViewById(R.id.editTextValor);
        buttonConvertir = findViewById(R.id.buttonConvertir);
        buttonNuevo = findViewById(R.id.buttonNuevo);
        buttonSalir = findViewById(R.id.buttonSalir);

        ArrayAdapter<String> adapTemperatureOrigen = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,opcionesTemperatura);
        ArrayAdapter<String> adapTemperatureDestino = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,opcionesTemperatura);

        spinnerOrigen.setAdapter(adapTemperatureOrigen);
        spinnerDestino.setAdapter(adapTemperatureDestino);

        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorString = editTextValor.getText().toString();
                if (valorString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor ingrese un valor", Toast.LENGTH_SHORT).show();
                    return;
                }
                double valor = Double.parseDouble(valorString);
                Temperatura temperaturaOrigen = new Temperatura(valor, spinnerOrigen.getSelectedItemPosition());
                double resultado = temperaturaOrigen.convertir(spinnerDestino.getSelectedItemPosition());
                String resultadoString = String.format("%.2f", resultado);
                String mensaje = valorString + " ° " + spinnerOrigen.getSelectedItem().toString()
                        + " son " + "\n" + resultadoString + " ° " + spinnerDestino.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();


            }
        });

        buttonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextValor.setText("");
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
