package br.com.a11vs11.activity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import br.com.a11vs11.app.R;
import br.com.a11vs11.db.DBManager;
import br.com.a11vs11.model.FAQ;
import br.com.a11vs11.model.Manager;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private ImageView btn11vs11Pequeno;
    private ImageView btnFacebook;
    private ImageView btnTwitter;
    private ImageView btnYoutube;
    private ImageView btnRegulamentos;
    private ImageView btnFaq;
    private ImageView btnContatosXbox;
    private ImageView btnContatosPs4;
    private ImageView btnContatosPc;
    private ImageView btn11vs11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.bemVindo));
        DBManager.updateDB(this);

        btn11vs11 = (ImageView) findViewById(R.id.btn11vs11);
        btn11vs11.setOnClickListener(this);
        btn11vs11.setOnTouchListener(this);

        btn11vs11Pequeno = (ImageView) findViewById(R.id.btn11vs11Pequeno);
        btn11vs11Pequeno.setOnClickListener(this);
        btn11vs11Pequeno.setOnTouchListener(this);

        btnFacebook = (ImageView) findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(this);
        btnFacebook.setOnTouchListener(this);

        btnTwitter = (ImageView) findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(this);
        btnTwitter.setOnTouchListener(this);

        btnYoutube = (ImageView) findViewById(R.id.btnYoutube);
        btnYoutube.setOnClickListener(this);
        btnYoutube.setOnTouchListener(this);

        btnRegulamentos = (ImageView) findViewById(R.id.btnRegulamentos);
        btnRegulamentos.setOnClickListener(this);
        btnRegulamentos.setOnTouchListener(this);

        btnFaq = (ImageView) findViewById(R.id.btnFaq);
        btnFaq.setOnClickListener(this);
        btnFaq.setOnTouchListener(this);

        btnContatosXbox = (ImageView) findViewById(R.id.btnContatosXbox);
        btnContatosXbox.setOnClickListener(this);
        btnContatosXbox.setOnTouchListener(this);

        btnContatosPs4 = (ImageView) findViewById(R.id.btnContatosPs4);
        btnContatosPs4.setOnClickListener(this);
        btnContatosPs4.setOnTouchListener(this);

        btnContatosPc = (ImageView) findViewById(R.id.btnContatosPc);
        btnContatosPc.setOnClickListener(this);
        btnContatosPc.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                ImageView view = (ImageView) v;
                //overlay is black with transparency of 0x77 (119)
                if (view.getDrawable() != null) {
                    view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                } else {
                    view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                ImageView view = (ImageView) v;
                //clear the overlay
                if (view.getDrawable() != null) {
                    view.getDrawable().clearColorFilter();
                } else {
                    view.getBackground().clearColorFilter();
                }
                view.invalidate();
                break;
            }
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btn11vs11) || v.equals(btn11vs11Pequeno)) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.link11vs11)));
            startActivity(i);
        } else if (v.equals(btnFacebook)) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.facebookLink)));
            try {
                ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo("com.facebook.katana", 0);
                if (applicationInfo.enabled) {
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=" + getString(R.string.facebookLink)));
                }
            } catch (Exception e) {

            }
            startActivity(i);
        } else if (v.equals(btnYoutube)) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.youtubeLink)));
            startActivity(i);
        } else if (v.equals(btnTwitter)) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.twitterLink)));
            startActivity(i);
        } else if (v.equals(btnContatosXbox) || v.equals(btnContatosPs4) || v.equals(btnContatosPc)) {
            Intent i = new Intent(this, ViewManagersActivity.class);
            List<Manager> managers = null;
            if (v.equals(btnContatosXbox)) {
                i.putExtra("title", getString(R.string.titleContatosXbox));
                managers = new DBManager(this).getManagers(1);
            } else if (v.equals(btnContatosPs4)) {
                i.putExtra("title", getString(R.string.titleContatosPs4));
                managers = new DBManager(this).getManagers(2);
            } else if (v.equals(btnContatosPc)) {
                i.putExtra("title", getString(R.string.titleContatosPC));
                managers = new DBManager(this).getManagers(3);
            }

            if (managers != null && !managers.isEmpty()) {
                i.putExtra("managers", (Serializable) managers);
                startActivity(i);
            } else {
                Toast.makeText(this, getString(R.string.naoPossuiManagers), Toast.LENGTH_SHORT).show();
            }
        } else if (v.equals(btnFaq)) {
            List<FAQ> faqs = new DBManager(this).getFaqs();
            if (faqs != null && !faqs.isEmpty()) {
                Intent i = new Intent(this, ViewFaqActivity.class);
                i.putExtra("faqs", (Serializable) faqs);
                startActivity(i);
            } else {
                Toast.makeText(this, getString(R.string.naoPossuiFaq), Toast.LENGTH_SHORT).show();
            }
        } else if (v.equals(btnRegulamentos)) {
            Intent i = new Intent(this, RegulamentoActivity.class);
            startActivity(i);
        }
    }
}
