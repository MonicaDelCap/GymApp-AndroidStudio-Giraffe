package com.example.proyectofinalgym;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DatosUsuario_fragment extends Fragment {


    private TextView textViewName,textViewEdad,textViewPeso,textViewAltura,textViewMasaCorporal;

    private User user;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_datos_usuario_fragment, container, false);
        user = PantallaPrincipal.user;
        textViewAltura=rootView.findViewById(R.id.textViewAltura);
        textViewName=rootView.findViewById(R.id.textViewName);
        textViewEdad=rootView.findViewById(R.id.textViewEdad);
        textViewPeso=rootView.findViewById(R.id.textViewPeso);
        textViewMasaCorporal=rootView.findViewById(R.id.textViewMasaCorporal);


        textViewName.setText(user.getNombre());
        textViewEdad.setText(user.getEdad());
        textViewPeso.setText(user.getPeso()+" Kg");
        textViewAltura.setText(user.getAltura()+ " cm");


        double indiceMasaCorporal = Double.parseDouble(user.getPeso()) / (Double.parseDouble(user.getAltura())* Double.parseDouble(user.getAltura()));
        String formato = "%.2f";
        String parteDecimalStr = String.format(formato, indiceMasaCorporal);
        textViewMasaCorporal.setText("IMS --> "+ parteDecimalStr);

        return rootView;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}