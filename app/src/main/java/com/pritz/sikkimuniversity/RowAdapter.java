package com.pritz.sikkimuniversity;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rob on 12/3/17.
 */

public class RowAdapter extends ArrayAdapter{

    List list = new ArrayList();
    public RowAdapter(Context context, int resource) {
        super(context, resource);

    }
    static class Datahandler{
        ImageView dp;
        TextView names;
        TextView details;
        Button phonenuber;
        Button adder;
        Button emailID;
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
            row=inflater.inflate(R.layout.custom_view,parent,false);
            dh = new Datahandler();
            dh.dp=(ImageView)row.findViewById(R.id.image);
            dh.names=(TextView)row.findViewById(R.id.name);
            dh.details=(TextView)row.findViewById(R.id.details);
            dh.phonenuber=(Button)row.findViewById(R.id.call);
            dh.adder=(Button)row.findViewById(R.id.add);
            dh.emailID=(Button)row.findViewById(R.id.email);
            row.setTag(dh);
        }
        else{
            dh=(Datahandler)row.getTag();
        }
        final TeacherDetailsProvider detailsProvider;
        detailsProvider=(TeacherDetailsProvider)this.getItem(position);
        dh.dp.setImageResource(detailsProvider.getImage());
        dh.names.setText(detailsProvider.getTeacher_name());
        final String x = dh.names.getText().toString();
        dh.details.setText(detailsProvider.getTeacher_details());
        final String y= detailsProvider.getPhno();
        final String z= detailsProvider.getEmailid();
        dh.emailID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uriText =
                        "mailto:"+z+
                                "?subject=" + Uri.encode("test subject");
                Uri uri= Uri.parse(uriText);

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

                Intent i = Intent.createChooser(emailIntent, "Send email to the developer...");
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                getContext().startActivity(i);

            }
        });
        dh.phonenuber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("tel:" + detailsProvider.getPhno().trim()));
                getContext().startActivity(intent);

            }
        });
        dh.adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList <ContentProviderOperation> ops = new ArrayList <> ();

                ops.add(ContentProviderOperation.newInsert(
                        ContactsContract.RawContacts.CONTENT_URI)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                        .build());


                ops.add(ContentProviderOperation.newInsert(
                        ContactsContract.Data.CONTENT_URI)
                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE,
                                ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                        .withValue(
                                ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
                                x).build());
                ops.add(ContentProviderOperation.
                        newInsert(ContactsContract.Data.CONTENT_URI)
                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE,
                                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,y)
                        .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
                                ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                        .build());
                ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE,
                                ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Email.DATA,z)
                        .withValue(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                        .build());

                try {
                    getContext().getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
                    Toast.makeText(getContext(),"Details Added to your contact",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return row;
    }
}