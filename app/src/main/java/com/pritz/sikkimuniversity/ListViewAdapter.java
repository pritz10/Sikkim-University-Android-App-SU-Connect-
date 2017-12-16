package com.pritz.sikkimuniversity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Contactboo_kGettersetter> details = null;
    private ArrayList<Contactboo_kGettersetter> arraylist;

    public ListViewAdapter(Context context, List<Contactboo_kGettersetter> worldpopulationlist) {
        mContext = context;
        this.details = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Contactboo_kGettersetter>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        ImageButton rank;   //l//
        TextView country;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Contactboo_kGettersetter getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            ///hgggg//
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (ImageButton) view.findViewById(R.id.rank);
            holder.country = (TextView) view.findViewById(R.id.country);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
       final String x ="03592"+details.get(position).getNumber();
        holder.rank.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                              Intent intent = new Intent(Intent.ACTION_CALL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("tel:"+x));
                mContext.startActivity(intent);
            }
        });
        holder.country.setText(details.get(position).getName());

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("tel:"+x));
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        details.clear();
        if (charText.length() == 0) {
            details.addAll(arraylist);
        }
        else
        {
            for (Contactboo_kGettersetter wp : arraylist)
            {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    details.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}