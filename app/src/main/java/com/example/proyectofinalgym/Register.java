package com.example.proyectofinalgym;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private EditText editTextNombre,editTextEdad,editTextDni,editTextTelefono,editTextEmail,editTextPassword,editTextPeso,editTextAltura;

    private CheckBox checkBoxPolitica;
    private Button buttonResgitrar;
    private DBHandler dbHandler;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        dbHandler = new DBHandler(Register.this);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextDni = findViewById(R.id.editTextDni);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        checkBoxPolitica = findViewById(R.id.checkBoxPolitica);
        buttonResgitrar = findViewById(R.id.buttonResgitrar);



        buttonResgitrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextDni.getText().toString().equals("") && !editTextEmail.getText().toString().equals("") && !editTextPassword.getText().toString().equals("")){

                    if (checkBoxPolitica.isChecked()){
                        User user = new User(editTextEmail.getText().toString(),editTextPassword.getText().toString()
                                ,editTextDni.getText().toString(),editTextNombre.getText().toString(),editTextPeso.getText().toString(),
                                editTextAltura.getText().toString(),editTextTelefono.getText().toString(),editTextEdad.getText().toString());

                        dbHandler.addNewUser(user);
                        dbHandler.close();
                        Intent paginaResgistro = new Intent(Register.this, LoginActivity.class);
                        paginaResgistro.putExtra("email",editTextEmail.getText());
                        paginaResgistro.putExtra("password",editTextPassword.getText());
                        startActivity(paginaResgistro);
                    }else {
                        Toast.makeText(Register.this,"Debes aceptar la politica de privacidad",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Register.this,"Faltan campos obligatorios",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public EditText getEditTextNombre() {
        return editTextNombre;
    }

    public void setEditTextNombre(EditText editTextNombre) {
        this.editTextNombre = editTextNombre;
    }

    public EditText getEditTextEdad() {
        return editTextEdad;
    }

    public void setEditTextEdad(EditText editTextEdad) {
        this.editTextEdad = editTextEdad;
    }

    public EditText getEditTextDni() {
        return editTextDni;
    }

    public void setEditTextDni(EditText editTextDni) {
        this.editTextDni = editTextDni;
    }

    public EditText getEditTextTelefono() {
        return editTextTelefono;
    }

    public void setEditTextTelefono(EditText editTextTelefono) {
        this.editTextTelefono = editTextTelefono;
    }

    public EditText getEditTextEmail() {
        return editTextEmail;
    }

    public void setEditTextEmail(EditText editTextEmail) {
        this.editTextEmail = editTextEmail;
    }

    public EditText getEditTextPassword() {
        return editTextPassword;
    }

    public void setEditTextPassword(EditText editTextPassword) {
        this.editTextPassword = editTextPassword;
    }

    public EditText getEditTextPeso() {
        return editTextPeso;
    }

    public void setEditTextPeso(EditText editTextPeso) {
        this.editTextPeso = editTextPeso;
    }

    public EditText getEditTextAltura() {
        return editTextAltura;
    }

    public void setEditTextAltura(EditText editTextAltura) {
        this.editTextAltura = editTextAltura;
    }

    public CheckBox getCheckBoxPolitica() {
        return checkBoxPolitica;
    }

    public void setCheckBoxPolitica(CheckBox checkBoxPolitica) {
        this.checkBoxPolitica = checkBoxPolitica;
    }

    public Button getButtonResgitrar() {
        return buttonResgitrar;
    }

    public void setButtonResgitrar(Button buttonResgitrar) {
        this.buttonResgitrar = buttonResgitrar;
    }

    public DBHandler getDbHandler() {
        return dbHandler;
    }

    public void setDbHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }
}
