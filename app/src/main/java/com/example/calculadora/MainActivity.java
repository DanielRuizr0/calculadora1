package com.example.calculadora;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnSumar;
    Button btnRestar;
    Button btnMultiplicar;
    Button btnDividir;
    TextView tvResultado;
    public void irAfactorisActivity(View view) {
        Button btnfactorizar = findViewById(R.id.factorizar);
        if (btnfactorizar != null) {
            btnfactorizar.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, factorisActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }

    public void irAFibonacciActivity(View view) {
        Button btnfibonacci = findViewById(R.id.fibonacci);
        if (btnfibonacci != null) {
            btnfibonacci.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, FibonacciActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }
    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnSumar = findViewById(R.id.suma);
        btnRestar = findViewById(R.id.resta);
        btnMultiplicar = findViewById(R.id.multiplicacion);
        btnDividir = findViewById(R.id.division);
        tvResultado = findViewById(R.id.resultado);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());
                int resultado = Suma.sumar(num1, num2);
                tvResultado.setText(String.valueOf(resultado));
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());
                int resultado = Resta.restar(num1, num2);
                tvResultado.setText(String.valueOf(resultado));
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());
                int resultado = Multiplicacion.multiplicar(num1, num2);
                tvResultado.setText(String.valueOf(resultado));
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());
                if (num2 == 0) {
                    tvResultado.setText("No se puede dividir por cero");
                } else {
                    int resultado = Division.dividir(num1, num2);
                    tvResultado.setText(String.valueOf(resultado));
                }
            }
        });
    }

    public static class Suma {
        public static int sumar(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return sumar(a ^ b, (a & b) << 1);
            }
        }
    }

    public static class Resta {
        public static int restar(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return restar(a ^ b, (~a & b) << 1);
            }
        }
    }

    public static class Multiplicacion {
        public static int multiplicar(int a, int b) {
            if (b == 0) {
                return 0;
            } else if (b > 0) {
                return a + multiplicar(a, b - 1);
            } else {
                return -multiplicar(a, -b);
            }
        }
    }

    public static class Division {
        public static int dividir(int dividend, int divisor) {
            if (divisor == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            } else if (dividend < divisor) {
                return 0;
            } else {
                return 1 + dividir(dividend - divisor, divisor);
            }
        }
    }
}
