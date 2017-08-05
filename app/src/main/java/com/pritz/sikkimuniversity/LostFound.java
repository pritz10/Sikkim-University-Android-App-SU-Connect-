package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

      ProgressBar progressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_found);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data....");
        progressDialog.show();*/
        progressBar1=(ProgressBar)findViewById(R.id.progressBar);
        progressBar1.setVisibility(View.VISIBLE);
        mdatabase= FirebaseDatabase.getInstance().getReference().child("lost");
        postinsta=(RecyclerView) findViewById(R.id.postinsta);
        postinsta.setHasFixedSize(true);
        mdatabase.keepSynced(true);
        postinsta.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart()
{
    super.onStart();
    FirebaseRecyclerAdapter<post,BlogViewholder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<post, BlogViewholder>
            (post.class,R.layout.postinsta,BlogViewholder.class,mdatabase) {
        @Override
        protected void populateViewHolder(BlogViewholder viewHolder, post model, int position) {
            viewHolder.setUsername(model.getUsername());
            viewHolder.setImage(getApplicationContext(),model.getImage());
            viewHolder.setTitle(model.getTitle());
            viewHolder.setDetail(model.getDetail());
            viewHolder.setDate(model.getDate());

            progressBar1.setVisibility(View.GONE);



        }
    };
    //progressBar.setVisibility(View.GONE);

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
        TextView pname=(TextView)view.findViewById(R.id.losname);
        pname.setText(Username);
    }
    public void setDate(String date)
    {
        TextView date1=(TextView)view.findViewById(R.id.datei);
        date1.setText(date);
    }



} @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forums, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.db) {

            Intent intent=new Intent(LostFound.this,Lost_Found.class);
            startActivity(intent);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
