package com.example.proyectofinalgym;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

public class ejerciciosFragment extends Fragment {


    private ListView listView;

    private String[] items = {"10 repeticiones x 3 series",
            "8 repeticiones x 4 series",
            "20 minutos",
            "10 minutos",
            "20 minutos",
            "10 repeticiones x 3 series",
            "12 repeticiones x 3 series",
            "8 repeticiones x 4 series",
            "10 repeticiones x 3 series",
            "1 minuto"};

    private String[] items2 = {"Sentadilla Búlgara",
            "Press de banca",
            "Carrera continua"
            ,"Estiramientos"
            ,"Bicicleta"
            ,"Aperturas"
            ,"Prensa",
            "Remo unilateral",
            "Hipthrust",
            "Plancha"};
    //private Drawable[] image = {ContextCompat.getDrawable(getContext(), R.mipmap.grasacorporal)};;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_ejercicios, container, false);
        listView=rootView.findViewById(R.id.listView);
        Drawable[] image = {ContextCompat.getDrawable(getContext(), R.mipmap.sentadilla),
                ContextCompat.getDrawable(getContext(), R.mipmap.pressbanca),
                ContextCompat.getDrawable(getContext(), R.mipmap.carrera),
                ContextCompat.getDrawable(getContext(), R.mipmap.estiramiento),
                ContextCompat.getDrawable(getContext(), R.mipmap.biciestatica),
                ContextCompat.getDrawable(getContext(), R.mipmap.aperturas),
                ContextCompat.getDrawable(getContext(), R.mipmap.prensa),
                ContextCompat.getDrawable(getContext(), R.mipmap.remounilateral),
                ContextCompat.getDrawable(getContext(), R.mipmap.hipthrust),
                ContextCompat.getDrawable(getContext(), R.mipmap.plancha),

        };;

        ArrayAdapter<String> adapter = new ArrayAdapter(requireContext(), R.layout.card_item, R.id.textViewCard1, items){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView1 = view.findViewById(R.id.textViewCard1); // Asegúrate de que textView1 y textView2 están en tu layout card_item
                TextView textView2 = view.findViewById(R.id.textViewCard2);
                ImageView imageView = view.findViewById(R.id.imageView3);


                textView1.setText(items[position]);
                textView2.setText(items2[position]);

                imageView.setBackground(image[position]);

                return view;
            }
        };

        listView.setAdapter(adapter);
        return rootView;


    }
}