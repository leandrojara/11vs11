package br.com.a11vs11.app.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.activity.ViewManagersActivity;
import br.com.a11vs11.app.model.Manager;

/**
 * Created by Leandro Jara on 27/09/2017.
 */

public class ManagerCustomAdapter extends ArrayAdapter<Manager> {

    private List<Manager> dataSet;
    private Context mContext;
    private Activity activity;
    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 619;
    public String telefoneAfterPermission;

    private static class ViewHolderManager {
        ImageView imgDrawableClube;
        TextView txtNomeManager;
        TextView txtNomeClube;
        TextView txtTelefoneManager;
        TextView txtEmailManager;
    }

    public ManagerCustomAdapter(List<Manager> dataSet, Context context, Activity activity) {
        super(context, R.layout.manager_row_item, dataSet);
        this.dataSet = dataSet;
        this.mContext = context;
        this.activity = activity;
    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        final Manager manager = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolderManager viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolderManager();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.manager_row_item, parent, false);
            viewHolder.imgDrawableClube = (ImageView) convertView.findViewById(R.id.imgDrawableClube);
            viewHolder.txtNomeManager = (TextView) convertView.findViewById(R.id.txtNomeManager);
            viewHolder.txtNomeClube = (TextView) convertView.findViewById(R.id.txtNomeClube);
            viewHolder.txtTelefoneManager = (TextView) convertView.findViewById(R.id.txtTelefoneManager);
            viewHolder.txtEmailManager = (TextView) convertView.findViewById(R.id.txtEmailManager);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderManager) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.animator.up_from_bottom : R.animator.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.imgDrawableClube.setImageResource(manager.getClube() != null ? manager.getClube().getDrawable() > 0 ? manager.getClube().getDrawable() : R.mipmap.ic_avatar : R.mipmap.ic_avatar);
        viewHolder.txtNomeManager.setText(manager.getNome());
        viewHolder.txtNomeClube.setText(manager.getClube() != null ? manager.getClube().getNome() : "");
        viewHolder.txtTelefoneManager.setText(manager.getTelefone());
        viewHolder.txtEmailManager.setText(manager.getEmail());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (manager.getTelefone() != null && !manager.getTelefone().trim().isEmpty()) {
                    if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        telefoneAfterPermission = manager.getTelefone();
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    } else {
                        abrirDiscador(manager.getTelefone());
                    }
                }
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

    public void abrirDiscador(String telefone){
        mContext.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefone)));
    }
}
