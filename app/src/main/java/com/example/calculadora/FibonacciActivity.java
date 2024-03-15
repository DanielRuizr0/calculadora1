package com.example.calculadora;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FibonacciActivity extends AppCompatActivity {

    EditText etNum;
    Button btnCalcular;
    TextView tvResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        etNum = findViewById(R.id.Num1);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(v -> {
            int num = Integer.parseInt(etNum.getText().toString());

            String fibonacciSequence = calcularFibonacci(num);
            tvResultado.setText(fibonacciSequence);
        });
    }
        public void irAMainActivity(View view) {
            Button btnVolverMain = findViewById(R.id.regresar);
            if (btnVolverMain != null) {
                btnVolverMain.setOnClickListener(v -> {
                    Intent intent = new Intent(FibonacciActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                });
            }
        }



    String calcularFibonacci(int n) {
        int a = 0, b = 1;
        StringBuilder sequence = new StringBuilder();
        sequence.append("Secuencia de Fibonacci hasta el término ").append(n).append(": ");

        for (int i = 0; i < n; i++) {
            sequence.append(a).append(", ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        return sequence.toString();
    }
}

