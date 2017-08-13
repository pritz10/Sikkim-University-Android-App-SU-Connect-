package com.pritz.sikkimuniversity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static com.pritz.sikkimuniversity.R.id.pictures;
import static com.pritz.sikkimuniversity.R.id.postimage;

public class Notificaion extends AppCompatActivity {
    private RecyclerView postinsta;
    private DatabaseReference mdatabase;
    ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaion);
        progressBar1=(ProgressBar)findViewById(R.id.progressBar);
        progressBar1.setVisibility(View.VISIBLE);
        mdatabase= FirebaseDatabase.getInstance().getReference().child("Importantnotifications");
        postinsta=(RecyclerView) findViewById(R.id.posti);
       postinsta.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
       // recyclerView.setLayoutManager(mLayoutManager);
        mdatabase.keepSynced(true);
        postinsta.setLayoutManager(mLayoutManager);
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<imp, BlogViewholder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<imp, BlogViewholder>(
                imp.class,R.layout.posti, BlogViewholder.class,mdatabase.limitToLast(8)) {
            @Override
            protected void populateViewHolder(BlogViewholder viewHolder, imp model, int position) {
                viewHolder.setname(model.getname());
                viewHolder.setImage(getApplicationContext(),model.getImage());
                viewHolder.setMessage(model.getMessage());
                viewHolder.setDate(model.getDate());
                progressBar1.setVisibility(View.GONE);
              /*  v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(), "Loading...", Toast.LENGTH_LONG).show();
                        mref.child(pskey).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                Intent intent = new Intent(MainActivity.this,Important.class);
                                intent.putExtra("gte",pskey);
                                startActivity(intent);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                });

*/
            }
        };
        postinsta.setAdapter(firebaseRecyclerAdapter);
        mdatabase.keepSynced(true);
    }




    public static class BlogViewholder extends RecyclerView.ViewHolder{

        View view;
        public BlogViewholder(View itemView) {
            super(itemView);
            view=itemView;

        }
        public void setname(String name)
        {
            TextView ptitle=(TextView)view.findViewById(R.id.name);
            ptitle.setText(name);
        }
        public void setMessage(String message)
        {
            TextView pdetail=(TextView)view.findViewById(R.id.mainframe);
            pdetail.setText(message);
        }

        public void setImage(Context ctx, String image)
        {
            ImageView post=(ImageView)view.findViewById(pictures);
            Picasso.with(ctx).load(image).into(post);

        }

        public void setDate(String date)
        {
            TextView date1=(TextView)view.findViewById(R.id.date);
            date1.setText(date);
        }
    }
}
