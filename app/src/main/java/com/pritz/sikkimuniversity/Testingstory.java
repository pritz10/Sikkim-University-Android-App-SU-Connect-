package com.pritz.sikkimuniversity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

 import static com.pritz.sikkimuniversity.R.id.strimage;

public class Testingstory extends AppCompatActivity {
    private RecyclerView pods;
    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testingstory);
        mdatabase= FirebaseDatabase.getInstance().getReference().child("story");
        pods=(RecyclerView)findViewById(R.id.pos);
        pods.setHasFixedSize(true);
        mdatabase.keepSynced(true);
        pods.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void onStart()
    {super.onStart();
        FirebaseRecyclerAdapter<forstory, storyholder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<forstory, storyholder>
                (forstory.class,
                        R.layout.str,
                        storyholder.class,
                        mdatabase) {
            @Override
            protected void populateViewHolder(storyholder viewHolder, forstory model, int position) {
                viewHolder.setStitle(model.getStitle());
                viewHolder.setSdate(model.getSdate());
                viewHolder.setSimage(getApplicationContext(),model.getSimage());
            }
        };
        pods.setAdapter(firebaseRecyclerAdapter);

    }
public  static class storyholder extends RecyclerView.ViewHolder
{
    View mView;
    public storyholder(View itemView) {
        super(itemView);
        mView = itemView;
    }
    public void setStitle(String stitle) {
        TextView ptitle = (TextView) mView.findViewById(R.id.strtitle);
        ptitle.setText(stitle);
    }


    public void setSimage(Context ctx, String simage) {
        ImageView post = (ImageView) mView.findViewById(strimage);
        Picasso.with(ctx).load(simage).into(post);

    }

    public void setSdate(String sdate) {
        TextView date1 = (TextView) mView.findViewById(R.id.strdate);
        date1.setText(sdate);
    }
}


}
