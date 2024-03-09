package com.example.appimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText edit_Peso, edit_Altura;
    private TextView tvResultado;
    private Button btn_Calc;

    private View colorIndic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_imc);
//        View v = null;
//
//
//        AlertDialog.Builder aa = new AlertDialog.Builder(v.getContext());
//        aa.setTitle("Olá!");
//        aa.setMessage("IMC é a sigla para Índice de Massa Corpórea, parâmetro adotado pela Organização Mundial de Saúde para calcular o peso ideal de cada pessoa. \n Calcule o seu agora!");
//        aa.setPositiveButton("OK", null);
//        aa.create();
//        aa.show();

    edit_Peso = findViewById(R.id.edit_Peso);
    edit_Altura = findViewById(R.id.edit_Altura);
    btn_Calc = findViewById(R.id.btn_Calc);
    tvResultado = findViewById(R.id.tvResultado);
    colorIndic = findViewById(R.id.colorIndicator);

        for (int i = 9; i>0; i--){


            btn_Calc.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvResultado.setText("");
                    if (!edit_Peso.getText().toString().isEmpty() && !edit_Altura.getText().toString().isEmpty()) {

                        int peso = Integer.parseInt(edit_Peso.getText().toString());
                        float altura = Float.parseFloat(edit_Altura.getText().toString());
                        double imc = peso / (altura * altura);

                        String resultadoimc = String.format("%.2f", imc);


                        if (imc < 16) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n Magreza grau III \n Cuidado!");
                        } else if (imc <= 16.9) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n Magreza grau II \n Cuidado!");
                        } else if (imc <= 18.4) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n Magreza grau I \n Cuidado!");
                        } else if (imc <= 24.9) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n O peso Adequado \nParabens!");
                        } else if (imc <= 29.9) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n Pré Obesidade \n Cuidado!");
                        } else if (imc <= 34.9) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n Obesidade grau I \n Cuidado!");
                        } else if (imc <= 39.0) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n Obesidade grau II \n Cuidado!");
                        } else if (imc >= 40) {
                            updateColorIndicator(imc);
                            tvResultado.setText("Seu IMC é de: " + resultadoimc + " Você está com \n Obesidade grau III \n Cuidado!");
                        } else {

                            tvResultado.setText("Os valores digitados são inválidos, por favor tente novamente \nObrigada");

                        }
                    } else {

                        AlertDialog.Builder a = new AlertDialog.Builder(v.getContext());
                        a.setTitle("Informação!");
                        a.setMessage("Os campos de \"Peso\" e de \"Altura\" não podem estar vazios!\nPor favor, digite os valores e tente novamente!");
                        a.setPositiveButton("OK", null);
                        a.create();
                        a.show();
                        tvResultado.setText("");

                    }
                }
            });

        }


    }

    private void updateColorIndicator(double imc) {
        int colorResId;
        if (imc < 18.5) {
            colorResId = R.color.azul; // Azul
        } else if (imc < 25) {
            colorResId = R.color.verde; // Verde
        } else if (imc < 30) {
            colorResId = R.color.amarelo; // Amarelo
        } else if (imc < 35){
            colorResId = R.color.laranja; //Laranja
        } else {
            colorResId = R.color.vermelho; // Vermelho
        }

        int color = getResources().getColor(colorResId);
        colorIndic.setBackgroundColor(color);
    }



}