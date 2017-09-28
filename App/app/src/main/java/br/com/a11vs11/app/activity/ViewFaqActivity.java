package br.com.a11vs11.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.List;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.adapter.FaqCustomAdapter;
import br.com.a11vs11.app.model.FAQ;

public class ViewFaqActivity extends AppCompatActivity {

    private ExpandableListView listViewFaq;
    private List<FAQ> faqs;
    private FaqCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faq);
        setTitle(getString(R.string.titleFaq));

        faqs = (List<FAQ>) getIntent().getSerializableExtra("faqs");
        listViewFaq = (ExpandableListView) findViewById(R.id.listViewFaq);

        adapter = new FaqCustomAdapter(faqs, getApplicationContext());

        listViewFaq.setAdapter(adapter);
    }
}
