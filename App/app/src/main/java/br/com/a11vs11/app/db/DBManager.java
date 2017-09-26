package br.com.a11vs11.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Locale;

/**
 * Created by TDR on 25/09/2017.
 */

public class DBManager {

    private static final int DB_VERSION = 1;

    public static void updateDB(Context context){
        SQLiteDatabase db = context.openOrCreateDatabase("DB11vs11", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(DB_VERSION);
        db.setLocale(Locale.getDefault());

        for (int i = 1; i <= DB_VERSION; i++) {
            switch (i){
                case 1:
                    try {
//                        creatting tables
                        db.execSQL("create table faq(" +
                                "id integer primary key autoincrement," +
                                "pergunta text," +
                                "resposta text" +
                                ");");
                        db.execSQL("create table plataforma(" +
                                "id integer primary key autoincrement," +
                                "nome text" +
                                ");");
                        db.execSQL("create table clube(" +
                                "id integer primary key autoincrement," +
                                "nome text," +
                                "plataforma integer," +
                                "foreign key(plataforma) references plataforma(id)" +
                                ");");
                        db.execSQL("create table manager(" +
                                "id integer primary key autoincrement," +
                                "nome text," +
                                "telefone text," +
                                "email text," +
                                "clube integer," +
                                "foreign key(clube) references clube(id)" +
                                ");");

//                        insertting data
                        db.execSQL("insert into plataforma (nome) values " +
                                "('XBOX'), ('PS4'), ('PC');");
                        db.execSQL("insert into club");
                    } catch (Exception e) {

                    }
                    break;
            }
        }
    }
}
