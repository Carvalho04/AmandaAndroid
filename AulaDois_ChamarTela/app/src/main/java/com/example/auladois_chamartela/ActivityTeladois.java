
package com.example.auladois_chamartela;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ActivityTeladois extends AppCompatActivity {



    Button btn6, btn7, btn8, btn9, btn10, btn11, btnProximo;
    TextView palavra;
    int aux;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teladois);

        aux = 0;

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button11);
        btn11 = findViewById(R.id.button10);
        palavra = findViewById(R.id.palavra);

        palavra.setText("_as_");

        btn6.setText("c");
        btn7.setText("j");
        btn8.setText("r");
        btn9.setText("o");
        btn10.setText("a");

        aux = 1;


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aux == 1){
                    palavra.setText("cas_");
                    aux = 2;
                }
                else if(aux == 4){
                    palavra.setText("alu_ _");
                    aux = 5;
                }


        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Errou", Toast.LENGTH_LONG).show();

            }
        });

            }
        });




    }






    public boolean onOptionsItemSelected(MenuItem menuItem){
        startActivity(new Intent(this, MainActivity.class));
        finish();

        return true;

    }

}
