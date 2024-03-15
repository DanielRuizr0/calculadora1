package com.example.calculadora;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class factorisActivity extends AppCompatActivity {

    EditText etNum;
    Button btnFactorizar;
    TextView tvResultado;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factoris);

        etNum = findViewById(R.id.Num1);
        btnFactorizar = findViewById(R.id.Factorizar);
        tvResultado = findViewById(R.id.tvResultado);


        btnFactorizar.setOnClickListener(v -> {

            String numStr = etNum.getText().toString();
            if (!numStr.isEmpty()) {
                int num = Integer.parseInt(numStr);


                int factorial = calcularFactorial(num);


                tvResultado.setText("El factorial de " + num + " es: " + factorial);
            } else {
                tvResultado.setText("Por favor, ingrese un número.");
            }
        });
    }

    public void irAMainActivity(View view) {
        Button btnVolverMain = findViewById(R.id.regresar);
        if (btnVolverMain != null) {
            btnVolverMain.setOnClickListener(v -> {
                Intent intent = new Intent(factorisActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }
    int calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFactorial(n - 1);
        }
    }
}

