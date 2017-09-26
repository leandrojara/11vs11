package br.com.a11vs11.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.db.DBManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager.updateDB(this);
    }
}
