package com.pritz.sikkimuniversity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import static android.R.id.message;
import static com.pritz.sikkimuniversity.R.id.postimage;

public class LostFound extends AppCompatActivity {
private RecyclerView postinsta;
    private DatabaseReference mdatabase;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_found);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data....");
        progressDialog.show();
        mdatabase= FirebaseDatabase.getInstance().getReference().child("lost");
        postinsta=(RecyclerView) findViewById(R.id.postinsta);
        postinsta.setHasFixedSize(true);
        mdatabase.keepSynced(true);
        postinsta.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Lost_Found .class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onStart()
{
    super.onStart();
    FirebaseRecyclerAdapter<post,BlogViewholder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<post, BlogViewholder>
            (post.class,R.layout.postinsta,BlogViewholder.class,mdatabase) {
        @Override
        protected void populateViewHolder(BlogViewholder viewHolder, post model, int position) {

            viewHolder.setTitle(model.getTitle());
            viewHolder.setDetail(model.getDetail());
            viewHolder.setUsername(model.getUserame());
            viewHolder.setImage(getApplicationContext(),model.getImage());



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
    public void setTitle(String title)
    {
        TextView ptitle=(TextView)view.findViewById(R.id.posttitle);
        ptitle.setText(title);
    }
    public void setDetail(String detail)
    {
        TextView pdetail=(TextView)view.findViewById(R.id.postdetail);
        pdetail.setText(detail);
    }

    public void setImage(Context ctx, String image)
    {
        ImageView post=(ImageView)view.findViewById(postimage);
        Picasso.with(ctx).load(image).into(post);

    }
    public void setUsername(String Username)
    {
        TextView pname=(TextView)view.findViewById(R.id.postname);
        pname.setText("Pritam Shah(Computer Applications)");
    }



}
}
