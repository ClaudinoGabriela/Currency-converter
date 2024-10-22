package com.example.trabalho01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import java.text.DecimalFormat;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class Calculo extends AppCompatActivity {

    EditText nome, valor;
    RadioGroup moedas;
    RadioButton dolar, euro, libra;
    Button voltar;
    TextView resultado;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        nome = findViewById(R.id.TxtNome);
        valor = findViewById(R.id.TxtValor);
        moedas = findViewById(R.id.RadioMoedas);
        dolar = findViewById(R.id.RadioDolar);
        euro = findViewById(R.id.RadioEuro);
        libra = findViewById(R.id.RadioLibra);
        voltar = findViewById(R.id.btnVoltar1);
        resultado = findViewById(R.id.txtResultado);

        DecimalFormat df = new DecimalFormat("#.####");

        moedas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String conversao = "";
                String user = nome.getText().toString();
                Double valorDigitado;

                if (valor.getText().toString().isEmpty()) {
                    Toast.makeText(Calculo.this, "Digite um valor!", Toast.LENGTH_SHORT).show();
                    return;
                }

                valorDigitado = Double.parseDouble(valor.getText().toString());

                if (checkedId == R.id.RadioDolar) {
                    Double convdolar = valorDigitado * 5.0642;
                    conversao = "Prezado(a), " + user + "\nSe você tiver um salário de " + valorDigitado + " USD" +
                            "\nVocê receberá " + df.format(convdolar) + " reais por mês";
                }

                else if (checkedId == R.id.RadioEuro) {
                    Double conveuro = valorDigitado * 5.3087;
                    conversao = "Prezado(a), " + user + "\nSe você tiver um salário de " + valorDigitado + " EUR" +
                            "\nVocê receberá " + df.format(conveuro) + " reais por mês";

                }

                else if (checkedId == R.id.RadioLibra) {
                    Double convlibra = valorDigitado * 6.1137;
                    conversao = "Prezado(a), " + user + "\nSe você tiver um salário de " + valorDigitado + " GBP" +
                            "\nVocê receberá " + df.format(convlibra) + " reais por mês";

                }

                resultado.setText(conversao);
            }
        });

        voltar.setOnClickListener(view -> {
            Intent intent = new Intent(Calculo.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
