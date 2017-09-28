package br.com.a11vs11.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.model.FAQ;

/**
 * Created by Leandro Jara on 28/09/2017.
 */

public class FaqCustomAdapter extends BaseExpandableListAdapter {

    private List<FAQ> faqs;
    private Context context;

    public FaqCustomAdapter(List<FAQ> faqs, Context context) {
        this.faqs = faqs;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return faqs.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return faqs.get(groupPosition).getPergunta();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return faqs.get(groupPosition).getResposta();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return faqs.get(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return faqs.get(groupPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.faq_row_expandable_item, null);
        }

        TextView txtFaq = (TextView) convertView.findViewById(R.id.txtFaq);
        txtFaq.setText((CharSequence) getGroup(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.faq_row_expandable_item, null);
        }

        TextView txtFaq = (TextView) convertView.findViewById(R.id.txtFaq);
        txtFaq.setText((CharSequence) getChild(groupPosition, childPosition));

        convertView.setBackgroundColor(Color.LTGRAY);
        txtFaq.setTextColor(Color.WHITE);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
