package com.example.proyectofinalgym;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class PantallaPrincipal extends AppCompatActivity {


    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public static User user = null;

    TabLayout tabLayout;

    DBHandler dbHandler;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);

        dbHandler = new DBHandler(PantallaPrincipal.this);
        String userName = getIntent().getStringExtra("user");

        String consultaSQL = "select d.nombre,d.edad,d.peso,d.altura from data d join " +
                "credentials c on c.dni=d.dni where userEmail='" + userName+"';";
        SQLiteDatabase bbdd = dbHandler.getWritableDatabase();
        Cursor ejecucionConsulta = bbdd.rawQuery(consultaSQL, null);
        ejecucionConsulta.moveToFirst();
        String nombre = ejecucionConsulta.getString(0);
        String edad = ejecucionConsulta.getString(1);
        String peso = ejecucionConsulta.getString(2);
        String altura = ejecucionConsulta.getString(3);
        user= new User(userName,nombre,edad,peso,altura);


        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



     /*   NotificationCompat.Builder builder = new NotificationCompat.Builder(PantallaPrincipal.this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Mi notificación")
                .setContentText("Este es el texto de mi notificación")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
        //crearla lista con las cards

      */


    }


    public ViewPager getViewPager() {
        return viewPager;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public ViewPagerAdapter getViewPagerAdapter() {
        return viewPagerAdapter;
    }

    public void setViewPagerAdapter(ViewPagerAdapter viewPagerAdapter) {
        this.viewPagerAdapter = viewPagerAdapter;
    }


    public DBHandler getDbHandler() {
        return dbHandler;
    }

    public void setDbHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }
}
