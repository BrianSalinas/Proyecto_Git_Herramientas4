package com.example.laboratorio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Inicio extends AppCompatActivity {
    ProgressBar nprogressBar;
    Button btnsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        nprogressBar = findViewById(R.id.progressBar);
        btnsiguiente =findViewById(R.id.button);
        nprogressBar.setVisibility(View.INVISIBLE);
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nprogressBar.setVisibility(View.VISIBLE);
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        nprogressBar.setVisibility(View.GONE);
        startActivity(new Intent(Inicio.this, MainActivity.class));
    }
}, 3000);

            }
        });
    }
}