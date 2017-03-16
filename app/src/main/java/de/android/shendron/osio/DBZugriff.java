package de.android.shendron.osio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jackl on 28.02.2017.
 */

public class DBZugriff extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    // Konstruktor

    public DBZugriff (Context activity, String dbName){
        super(activity, dbName, null, 1);
        db = getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase db){
        try {
            // Tabelle anlegen
            String sql = "Create Table Quizkarte " +
                    "(quizkarteID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "frage VARCHAR(60) NOT NULL)";
            db.execSQL(sql);

            sql = "Create Table Antwort " +
                    "(antwortID INTEGER PRIMARY KEY," +
                    "moeglicheAntwort VARCHAR(20) NOT NULL" +
                    "istAntwortRichtig INTEGER" +
                    "FOREIGN KEY (antwortID) REFERENCES Quizkarte(quizkarteID))";
            db.execSQL(sql);
        }catch (Exception ex){
            Log.e("osio", ex.getMessage());
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // auf Versionswechsel reagieren
    }

    public synchronized void close(){
        if(db != null){
            db.close();
            db = null;
        }

        super.close();
    }
}
