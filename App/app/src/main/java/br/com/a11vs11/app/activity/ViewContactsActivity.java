package br.com.a11vs11.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.adapter.ManagerCustomAdapter;
import br.com.a11vs11.app.model.Manager;

public class ViewContactsActivity extends AppCompatActivity {

    private List<Manager> managers;
    private ListView listViewContatos;
    private ManagerCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);
        setTitle(getIntent().getStringExtra("title"));

        managers = (List<Manager>) getIntent().getSerializableExtra("managers");
        listViewContatos = (ListView) findViewById(R.id.listViewContatos);

        adapter = new ManagerCustomAdapter(managers, getApplicationContext());

        listViewContatos.setAdapter(adapter);
    }
}
