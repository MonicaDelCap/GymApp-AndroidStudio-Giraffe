package com.example.proyectofinalgym;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private String[] items = {"Ejercicios Gluteo", "Ejercicios Gluteo", "Ejercicios Gluteo", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        // Crear un adaptador personalizado
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.card_item, R.id.textViewCard1, items);
        // Asignar el adaptador al ListView
        listView.setAdapter(adapter);
    }
}