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

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad, editTextDni, editTextTelefono, editTextEmail, editTextPassword, editTextPeso, editTextAltura;

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
                if (camposValidos()) {
                    if (checkBoxPolitica.isChecked()) {
                        if (comprobarDni(editTextDni.getText().toString())) {
                            User user = new User(editTextEmail.getText().toString(), editTextPassword.getText().toString()
                                    , editTextDni.getText().toString(), editTextNombre.getText().toString(), editTextPeso.getText().toString(),
                                    editTextAltura.getText().toString(), editTextTelefono.getText().toString(), editTextEdad.getText().toString());


                            dbHandler.addNewUser(user);
                            dbHandler.close();
                            Intent paginaResgistro = new Intent(Register.this, LoginActivity.class);
                            paginaResgistro.putExtra("email", editTextEmail.getText());
                            paginaResgistro.putExtra("password", editTextPassword.getText());
                            startActivity(paginaResgistro);
                        } else {
                            Toast.makeText(Register.this, "El DNI introducido no existe", Toast.LENGTH_LONG).show();

                        }

                    } else {
                        Toast.makeText(Register.this, "Debes aceptar la politica de privacidad", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Register.this, "Faltan campos obligatorios", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean camposValidos() {
        return !editTextDni.getText().toString().equals("") && !editTextEmail.getText().toString().equals("") && !editTextPassword.getText().toString().equals("");
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

    public boolean comprobarDni(String dni) {
        if (dni.length() != 9) {
            return false;
        }
        Map<Integer, String> map = crearMapaDNI();
        String letra = String.valueOf(dni.charAt(dni.length()-1));
        try {
            int n = Integer.parseInt(dni.substring(0, dni.length()-1));
            int num = n%23;
            return map.get(num).equalsIgnoreCase(letra);
        } catch (Exception e) {
            return false;
        }
    }

    private Map<Integer, String> crearMapaDNI() {
        Map<Integer, String> dniMap = new HashMap<>();

        // Asignar números del 0 al 22 con los caracteres correspondientes
        dniMap.put(0, "T");
        dniMap.put(1, "R");
        dniMap.put(2, "W");
        dniMap.put(3, "A");
        dniMap.put(4, "G");
        dniMap.put(5, "M");
        dniMap.put(6, "Y");
        dniMap.put(7, "F");
        dniMap.put(8, "P");
        dniMap.put(9, "D");
        dniMap.put(10, "X");
        dniMap.put(11, "B");
        dniMap.put(12, "N");
        dniMap.put(13, "J");
        dniMap.put(14, "Z");
        dniMap.put(15, "S");
        dniMap.put(16, "Q");
        dniMap.put(17, "V");
        dniMap.put(18, "H");
        dniMap.put(19, "L");
        dniMap.put(20, "C");
        dniMap.put(21, "K");
        dniMap.put(22, "E");

        return dniMap;
    }

}
