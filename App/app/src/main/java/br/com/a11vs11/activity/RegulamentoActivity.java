package br.com.a11vs11.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.a11vs11.app.R;

public class RegulamentoActivity extends AppCompatActivity {

    private TextView txtRegulamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulamento);
        setTitle(getString(R.string.regulamentos));

        txtRegulamento = (TextView) findViewById(R.id.txtRegulamento);
        txtRegulamento.setText(getString(R.string.regulamentoCompleto));
    }
}
