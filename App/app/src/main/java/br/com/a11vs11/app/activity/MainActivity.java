package br.com.a11vs11.app.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.db.DBManager;

public class MainActivity extends AppCompatActivity {

    private Button btnCbfvStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager.updateDB(this);

        btnCbfvStore = (Button) findViewById(R.id.btnCbfvStore);
        btnCbfvStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cbfvstore.com.br/"));
                startActivity(browserIntent);
            }
        });
    }
}
