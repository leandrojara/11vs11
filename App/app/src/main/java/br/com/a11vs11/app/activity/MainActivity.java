package br.com.a11vs11.app.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.db.DBManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager.updateDB(this);

        DBManager dbManager = new DBManager(this);
        dbManager.getAllManagers();
    }
}
