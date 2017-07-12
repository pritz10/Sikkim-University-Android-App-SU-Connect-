package com.pritz.sikkimuniversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rob on 12/3/17.
 */

public class forumss extends ArrayAdapter{

    List list = new ArrayList();
    public forumss(Context context, int resource) {
        super(context, resource);

    }
    static class Datahandler{
        EditText dp;
        TextView names;
        TextView details;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }


    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        final Datahandler dh;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.formlayout,parent,false);
            dh = new Datahandler();
            dh.dp=(EditText)row.findViewById(R.id.mainframe);
            dh.names=(TextView)row.findViewById(R.id.name);
            dh.details=(TextView)row.findViewById(R.id.date);
            row.setTag(dh);
        }
        else{
            dh=(Datahandler)row.getTag();
        }
        final GetterandSetter detailsProvider;
        detailsProvider=(GetterandSetter)this.getItem(position);
        dh.dp.setText(detailsProvider.getMessage());
        dh.names.setText(detailsProvider.getname());
        dh.details.setText(detailsProvider.getDate());
            return row;
    }
}
