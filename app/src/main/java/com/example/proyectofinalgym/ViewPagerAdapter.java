package com.example.proyectofinalgym;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

public ViewPagerAdapter(FragmentManager fm) {
    super(fm);
}

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new datosUsuario_fragment();
        } else if (position == 1) {
            fragment = new ejerciciosFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Datos Personales";
        } else if (position == 1) {
            title = "Ejercicios Favoritos";
        }
        return title;
    }
}