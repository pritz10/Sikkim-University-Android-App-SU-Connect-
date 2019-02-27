package com.pritz.sikkimuniversity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentBlood extends Fragment {
    private RecyclerView postinsta;
    private DatabaseReference mdatabase;
    ProgressBar progressBar1;
    Button bp;

    public fragmentBlood() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_blood, container, false);

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar1 = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        progressBar1.setVisibility(View.VISIBLE);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("blood_donation");
        postinsta = (RecyclerView) getActivity().findViewById(R.id.blodlife);
        postinsta.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mdatabase.keepSynced(true);
        postinsta.setLayoutManager(mLayoutManager);
        bp=(Button) getActivity().findViewById(R.id.b);

        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                String uid=user.getUid();
            String comare=mdatabase.orderByChild("User").startAt(uid).toString();

                if(uid.equals(comare)) {
                    Toast.makeText(getActivity(), comare, Toast.LENGTH_LONG).show();

                }
                else
                {
                    fragmentDonateblood p=new fragmentDonateblood();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,p).commit();}

            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<blood_gettersetter,BlogViewholderblood> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<blood_gettersetter,BlogViewholderblood>(
                blood_gettersetter.class,R.layout.blod,BlogViewholderblood.class,mdatabase.orderByChild("blodgrp").startAt("A")
        ) {
            @Override
            protected void populateViewHolder(BlogViewholderblood viewHolder, blood_gettersetter model, int position) {
                viewHolder.setName(model.getName());
                 viewHolder.setImage(getActivity().getApplicationContext(),model.getImage());
                viewHolder.setBlodgrp(model.getBlodgrp());
                final String pskey=getRef(position).getKey();
                progressBar1.setVisibility(View.GONE);
                viewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Calling...", Toast.LENGTH_LONG).show();

                        mdatabase.child(pskey).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String number=(String)dataSnapshot.child("Phone").getValue();
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                intent.setData(Uri.parse("tel:"+number));
                                startActivity(intent);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });
            }
        };

        postinsta.setAdapter(firebaseRecyclerAdapter);
        mdatabase.keepSynced(true);
    }




    public static class BlogViewholderblood extends RecyclerView.ViewHolder{

        View view;
        public BlogViewholderblood(View itemView) {
            super(itemView);
            view=itemView;

        }
        public void setName(String name)
        {
            TextView blodgropu=(TextView) view.findViewById(R.id.name1);
            blodgropu.setText(name);
        }
        public void setBlodgrp(String blodgrp)        {
            TextView f=(TextView) view.findViewById(R.id.bldgrp);
            f.setText(blodgrp);
        }

        public void setImage(Context ctx, String image)
        {
            ImageView il = (ImageView) view.findViewById(R.id.pico);
          //  ImageView post=(ImageView)view.findViewById(R.id.postimage);
            Picasso.with(ctx).load(image).resize(100, 100).centerCrop().into(il);
          //Picasso.with(ctx).load(image).resize(100,100).into(il);

        }



    }
}

