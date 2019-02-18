package com.pritz.sikkimuniversity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import static android.app.Activity.RESULT_OK;


public class Story extends Fragment {
      Uri imageurl=null;
    EditText storymes;
    ImageButton send;
    ImageButton adde;
    ImageButton cam;
    private static final int GALLERY_REQUEST=1;
    private StorageReference mStorageRef;
    public ProgressDialog progressDialog;
    public Story() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_story, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        cam=(ImageButton)getActivity().findViewById(R.id.cameras);

        adde=(ImageButton)getActivity().findViewById(R.id.addpic);
        send=(ImageButton)getActivity().findViewById(R.id.sendbtn);
        storymes=(EditText)getActivity().findViewById(R.id.strymsg);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startposting();
            }
        });

        adde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent, GALLERY_REQUEST);
            }
        });
    }
    private void startposting(){
        final DatabaseReference mref=FirebaseDatabase.getInstance().getReference().child("story");
        mStorageRef= FirebaseStorage.getInstance().getReference();
        progressDialog.setMessage("Just Wait.....");
        final String title = storymes.getText().toString().trim();
        if (!TextUtils.isEmpty(title))
        {
            DatabaseReference databaseReference=mref.push();
            databaseReference.child("title").setValue(title);
        }

        if (!TextUtils.isEmpty(title)   && imageurl != null)
        {
            progressDialog.show();
            StorageReference reference=mStorageRef.child("storypics").child(imageurl.getLastPathSegment());
            reference.putFile(imageurl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot){
                    Uri downloaduri=taskSnapshot.getDownloadUrl();
                    DatabaseReference databaseReference=mref.push();
                    databaseReference.child("title").setValue(title);
                     databaseReference.child("image").setValue(downloaduri.toString());
                    progressDialog.dismiss();






                }
            });

        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            Uri l = data.getData();
            CropImage.activity(l)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(getContext(), this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                imageurl = result.getUri();
               // pdf2.setImageURI(imageurl);
                adde.setImageURI(imageurl);            }
                else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
