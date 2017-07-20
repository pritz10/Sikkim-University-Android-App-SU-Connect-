package com.pritz.sikkimuniversity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.R.attr.data;
import static android.R.id.message;

public class Lost_Found extends AppCompatActivity {

    ImageButton lost;
    EditText ltitle;
    EditText ldetail;
    private Uri imageurl = null;
    private static final int GALLERY_REQUEST = 1;
    private StorageReference mStorageRef;
    DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("lost");

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost__found);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        //initialization//
        lost = (ImageButton) findViewById(R.id.lost);
        ltitle = (EditText) findViewById(R.id.ltitle);
        ldetail = (EditText) findViewById(R.id.ldetail);
        progressDialog = new ProgressDialog(this);
        lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent, GALLERY_REQUEST);
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
        progressDialog.setMessage("Just Wait.....");

        final String title = ltitle.getText().toString().trim();
        final String detail = ldetail.getText().toString().trim();
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(detail) && imageurl != null) {
            progressDialog.show();
            progressDialog.setCancelable(false);
            StorageReference reference = mStorageRef.child("Blog_images").child(imageurl.getLastPathSegment());
            reference.putFile(imageurl).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                    System.out.println("Upload is " + progress + "% done");
                   progressDialog.setMessage("Finishing Up \t " + progress + "% done !");

                }
            }).addOnPausedListener(new OnPausedListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onPaused(UploadTask.TaskSnapshot taskSnapshot) {
                    System.out.println("Upload is paused");
                    progressDialog.setMessage("Upload was paused");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploadsccessfull
                    progressDialog.setMessage("Upload Unsuccessful !");
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloaduri = taskSnapshot.getDownloadUrl();

                    DatabaseReference databaseReference = mref.push();
                    databaseReference.child("title").setValue(title);
                    databaseReference.child("detail").setValue(detail);
                    databaseReference.child("image").setValue(downloaduri.toString());


                    SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                    String name = sharedPreferences.getString("s_name", "");

                    databaseReference.child("Username").setValue(name);
                    final String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
                    databaseReference.child("date").setValue(currentDateTimeString);
                    progressDialog.dismiss();

                    Intent i = new Intent(Lost_Found.this, LostFound.class);
                    finish();
                    startActivity(i);


                }
            });


        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            imageurl = data.getData();
            CropImage.activity(imageurl)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this);

        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                imageurl = result.getUri();
                lost.setImageURI(imageurl);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}

