package com.pritz.sikkimuniversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rob on 17/3/17.
 */

public class List_class extends ArrayAdapter {
    List list1 = new ArrayList();

    public List_class(Context context, int resource) {
        super(context, resource);

    }

    static class Deptdata {
        ImageView dp;
        TextView names;
        ListView listView;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list1.add(object);
    }
    @Override
    public int getCount() {
        return this.list1.size();
    }
    @Override
    public Object getItem(int position) {
        return this.list1.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        List_class.Deptdata dh;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layoutofdeptlist, parent, false);
            dh = new List_class.Deptdata();
            dh.names = (TextView) row.findViewById(R.id.dnames);
            String deptname = dh.names.getText().toString();
            dh.listView=(ListView)row.findViewById(R.id.list_view);
            row.setTag(dh);
        } else {
            dh= (List_class.Deptdata) row.getTag();
        }
        TeacherDetailsProvider detailsProvider;
        detailsProvider=(TeacherDetailsProvider)this.getItem(position);
        dh.names.setText(detailsProvider.getAss());
        return row;
    }
}
