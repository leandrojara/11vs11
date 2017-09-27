package br.com.a11vs11.app.activity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.db.DBManager;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private ImageView btnCbfvStore;
    private ImageView btnFacebook;
    private ImageView btnTwitter;
    private ImageView btnYoutube;
    private ImageView btnRegulamentos;
    private ImageView btnFaq;
    private ImageView btnContatosXbox;
    private ImageView btnContatosPs4;
    private ImageView btnContatosPc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.bemVindo));
        DBManager.updateDB(this);

        btnCbfvStore = (ImageView) findViewById(R.id.btnCbfvStore);
        btnCbfvStore.setOnClickListener(this);
        btnCbfvStore.setOnTouchListener(this);

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
                view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                ImageView view = (ImageView) v;
                //clear the overlay
                view.getDrawable().clearColorFilter();
                view.invalidate();
                break;
            }
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnCbfvStore)) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cbfvstore.com.br/"));
            startActivity(browserIntent);
        } else
        if (v.equals(btnFacebook)) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ConfederacaoBrasileiraDeFutebolVirtual/"));;
            try {
                ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo("com.facebook.katana", 0);
                if (applicationInfo.enabled) {
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/ConfederacaoBrasileiraDeFutebolVirtual/"));
                }
            } catch (Exception e) {

            }
            startActivity(i);
        }  else
        if (v.equals(btnYoutube)) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCplQu9cxTABF_-t-B-LGEFQ"));;
            try {
                ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo("com.facebook.katana", 0);
                if (applicationInfo.enabled) {
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.youtube.com/channel/UCplQu9cxTABF_-t-B-LGEFQ"));
                }
            } catch (Exception e) {

            }
            startActivity(i);
        }  else
        if (v.equals(btnTwitter)) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/cbfvproclubs"));
            startActivity(browserIntent);
        }
    }
}
