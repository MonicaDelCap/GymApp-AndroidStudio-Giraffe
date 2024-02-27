package com.example.proyectofinalgym;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {
    private Button buttonEmpezar;

    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_activity);

        buttonEmpezar=findViewById(R.id.buttonEmpezar);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.GONE);

        buttonEmpezar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent paginaLogin = new Intent(InicioActivity.this, LoginActivity.class);
                        startActivity(paginaLogin);
                    }
                }, 1000);
            }
        });
    }
}
