package mx.edu.ittepic.tpdm_u5_practica2_juanmejia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Base extends SQLiteOpenHelper {

    public Base(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE HEROES("+
                "ID INTEGER PRIMARY KEY,"+
                "HEROE VARCHAR(200))");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (1,'DEADPOOL') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (2,'BATMAN') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (3,'WOLVERINE') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (4,'SUPERMAN') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (5,'IRONMAN') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (6,'SPIDERMAN') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (7,'RAVEN') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (8,'MISS MARVEL') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (9,'THOR') ");
        db.execSQL("INSERT INTO HEROES (ID,HEROE) VALUES (10,'WONDER WOMAN') ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
