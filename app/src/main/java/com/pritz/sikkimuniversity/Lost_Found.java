package com.pritz.sikkimuniversity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.R.attr.data;

public class Lost_Found extends AppCompatActivity {

    ImageButton lost;
    EditText ltitle ;
    EditText ldetail ;
    private  Uri imageurl=null;
    private static final int GALLERY_REQUEST=1;
    private StorageReference mStorageRef;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost__found);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("lost");

        lost = (ImageButton) findViewById(R.id.lost);
        ltitle = (EditText) findViewById(R.id.ltitle);
        ldetail = (EditText) findViewById(R.id.ldetail);
        progressDialog=new ProgressDialog(this);
        lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent,GALLERY_REQUEST);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startposting();
            }
        });
    }
    private void startposting() {
        progressDialog.setMessage("Just Wait....");
        progressDialog.show();
        String title = ltitle.getText().toString().trim();
        String detail = ldetail.getText().toString().trim();
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(detail) && imageurl != null)
        {

            StorageReference reference=mStorageRef.child("Blog_images").child(imageurl.getLastPathSegment());
            reference.putFile(imageurl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot){
                    Uri downloaduri=taskSnapshot.getDownloadUrl();
                    DatabaseReference detail=databaseReference.push();
                    detail.child("title").setValue(ltitle);
                    detail.child("details").setValue(ldetail);
                    detail.child("imageurl").setValue(downloaduri.toString());
                    progressDialog.dismiss();


                }
            });

        }
    }
    @Override
    public  void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==GALLERY_REQUEST && resultCode==RESULT_OK)
        {
            imageurl=data.getData();
            lost.setImageURI(imageurl);
        }
    }

}
