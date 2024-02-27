package com.example.proyectofinalgym;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

        //Nombre de la base de datos
        private static final String DB_NAME = "gimnasio";
        private static final int DB_VERSION = 1;


        //Tabla de los datos de registro
        private static final String TABLE_CREDENTIALS= "credentials";
        private static final String ID_CREDENTIALS = "userEmail";

         // below variable is for our course name column
        private static final String PASSWORD_COL = "password";

        //Tabla
        private static final String TABLE_USERDATA= "data";
        private static final String ID_USER = "dni";
        private static final String NAME = "nombre";
        private static final String WEIGHT = "peso";
        private static final String HEIGHT = "altura";
        private static final String NUMBER = "telefono";
        private static final String AGE = "edad";

        public DBHandler(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);

        }

        // below method is for creating a database by running a sqlite query

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryUserData = "CREATE TABLE IF NOT EXISTS " + TABLE_USERDATA + " ("
                + ID_USER + " VARCHAR(50) PRIMARY KEY, "
                + NAME + " VARCHAR(50)," +
                AGE + " VARCHAR(50)," +
                NUMBER + " VARCHAR(50)," +
                WEIGHT + " VARCHAR(50)," +
                HEIGHT + " VARCHAR(50))";
        db.execSQL(queryUserData);

        String queryCredentials = "CREATE TABLE IF NOT EXISTS " + TABLE_CREDENTIALS + " ("
                + ID_CREDENTIALS + " VARCHAR(50) PRIMARY KEY, "
                + PASSWORD_COL + " VARCHAR(50)," +
                ID_USER + " VARCHAR(50))"; // Agrega la columna para la clave foránea
        db.execSQL(queryCredentials);

        // Copiar los datos de la tabla original a una tabla temporal
        db.execSQL("CREATE TABLE temp_data AS SELECT * FROM " + TABLE_USERDATA);

        // Eliminar la tabla original
        db.execSQL("DROP TABLE " + TABLE_USERDATA);

        // Crear una nueva tabla con la restricción de clave externa
        String queryUserDataWithFK = "CREATE TABLE " + TABLE_USERDATA + " ("
                + ID_USER + " VARCHAR(50) PRIMARY KEY, "
                + NAME + " VARCHAR(50)," +
                AGE + " VARCHAR(50)," +
                NUMBER + " VARCHAR(50)," +
                WEIGHT + " VARCHAR(50)," +
                HEIGHT + " VARCHAR(50),"
                + "FOREIGN KEY(" + ID_USER + ") REFERENCES " + TABLE_USERDATA + "(" + ID_USER + "))";
        db.execSQL(queryUserDataWithFK);

        // Copiar los datos de la tabla temporal a la nueva tabla
        db.execSQL("INSERT INTO " + TABLE_USERDATA + " SELECT * FROM temp_data");

        // Eliminar la tabla temporal
        db.execSQL("DROP TABLE temp_data");
    }

    public void create2(SQLiteDatabase db){

            String query2 = "CREATE TABLE IF NOT EXISTS " + TABLE_CREDENTIALS + " ("
                    + ID_CREDENTIALS + " VARCHAR(50) PRIMARY KEY, "
                    + PASSWORD_COL + " VARCHAR(50)," +
                    "CONSTRAINT FK FOREIGN KEY (" + ID_USER + ") REFERENCES " +
                    TABLE_USERDATA+ "(" + ID_USER + "))";

            db.execSQL(query2);
        }

        // this method is use to add new course to our sqlite database.
        public void addNewUser(User user) {

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues valuesData = new ContentValues();

            valuesData.put(ID_USER, user.getDni());
            valuesData.put(NAME, user.getNombre());
            valuesData.put(AGE, user.getEdad());
            valuesData.put(NUMBER, user.getTelefono());
            valuesData.put(WEIGHT, user.getPeso());
            valuesData.put(HEIGHT, user.getAltura());


            db.insert(TABLE_USERDATA, null, valuesData);


            ContentValues valuesCredentials = new ContentValues();
            valuesCredentials.put(ID_CREDENTIALS,user.getEmail());
            valuesCredentials.put(PASSWORD_COL,user.getPassword());
            valuesCredentials.put(ID_USER,user.getDni());

            db.insert(TABLE_CREDENTIALS,null,valuesCredentials);

            db.close();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // this method is called to check if the table exists already.
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREDENTIALS);
            onCreate(db);
        }

    }
