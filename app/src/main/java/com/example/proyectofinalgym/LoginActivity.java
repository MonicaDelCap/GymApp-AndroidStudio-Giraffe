package com.example.proyectofinalgym;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private DBHandler dbHandler;
    private EditText textViewEmail,textViewPassword;
    private Button buttonLogin,buttonSingUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        textViewEmail = findViewById(R.id.textViewEmail);
        textViewPassword = findViewById(R.id.textViewPassword);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonSingUp = findViewById(R.id.buttonSingUp);
        dbHandler = new DBHandler(LoginActivity.this);

        String user = getIntent().getStringExtra("email");
        String pass = getIntent().getStringExtra("password");

        textViewEmail.setText(user);
        textViewPassword.setText(pass);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = "";
                try {
                    String consultaSQL = "select userEmail,password from credentials where userEmail='" + textViewEmail.getText().toString()+"';";
                    SQLiteDatabase bbdd = dbHandler.getWritableDatabase();
                    Cursor ejecucionConsulta = bbdd.rawQuery(consultaSQL, null);
                    ejecucionConsulta.moveToFirst();
                    password = ejecucionConsulta.getString(1);

                    if (textViewPassword.getText().toString().equals(password)){
                        Intent paginaPrincipal = new Intent(LoginActivity.this,PantallaPrincipal.class);
                        paginaPrincipal.putExtra("user",textViewEmail.getText().toString());
                        startActivity(paginaPrincipal);
                    }else {
                        Toast.makeText(LoginActivity.this,"Datos incorrectows",Toast.LENGTH_LONG).show();
                    }

                }catch ( CursorIndexOutOfBoundsException e) {
                    Toast.makeText(LoginActivity.this,"Datos incorrectows",Toast.LENGTH_LONG).show();

                }catch (SQLiteException sqLiteDatabase ){
                    Toast.makeText(LoginActivity.this,"Datos incorrectows",Toast.LENGTH_LONG).show();

                }



            }
        });


        buttonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaRegistro = new Intent(LoginActivity.this,Register.class);
                startActivity(paginaRegistro);
            }
        });


    }


}
