package br.com.a11vs11.app.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.adapter.ManagerCustomAdapter;
import br.com.a11vs11.app.model.Manager;

public class ViewManagersActivity extends AppCompatActivity {

    private List<Manager> managers;
    private ListView listViewContatos;
    private ManagerCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_managers);
        setTitle(getIntent().getStringExtra("title"));

        managers = (List<Manager>) getIntent().getSerializableExtra("managers");
        listViewContatos = (ListView) findViewById(R.id.listViewContatos);

        adapter = new ManagerCustomAdapter(managers, getApplicationContext(), ViewManagersActivity.this);

        listViewContatos.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case ManagerCustomAdapter.MY_PERMISSIONS_REQUEST_CALL_PHONE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    adapter.abrirDiscador(adapter.telefoneAfterPermission);
                } else {
                    Toast.makeText(this, getString(R.string.semPermissaoDiscador), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
