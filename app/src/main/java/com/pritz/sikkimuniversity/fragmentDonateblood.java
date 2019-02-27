package com.pritz.sikkimuniversity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentDonateblood extends Fragment {
    Spinner spinner;
    String photol;
    EditText ph;
    ImageView pdf2;
    Uri img = null;
    String bloodgroup,phone;
    private static final int GALLERY_REQUEST = 1;
    private StorageReference mStorageRefe = FirebaseStorage.getInstance().getReference();
    private ProgressDialog progressDialog;
    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    String uid=user.getUid();
    final DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("blood_donation");
    ArrayAdapter<CharSequence> adapter;

    public fragmentDonateblood() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_donateblood, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = (Spinner) getActivity().findViewById(R.id.spinner);
        ph = (EditText) getActivity().findViewById(R.id.phnumber);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.bloodgrp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        progressDialog = new ProgressDialog(getActivity());
        pdf2 =(ImageView)getActivity().findViewById(R.id.pdf);
        pdf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent, GALLERY_REQUEST);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), parent.getItemAtPosition(position) + "", Toast.LENGTH_LONG).show();
                //bloodgroup = parent.getItemAtPosition(position) + "";
                bloodgroup = spinner.getSelectedItem().toString();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button button = (Button) getActivity().findViewById(R.id.seng);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = ph.getText().toString();

                 progressDialog.setMessage("Just Wait.....\n" +
                        "\nYou are a real life hero. Salute to you. You will get a call when any one need blood. So if you are willing to give then you can donate otherwise you can tell them that you are not interested right now!");
                if ((img != null && !TextUtils.isEmpty(phone)) && !bloodgroup.equals("Enter Your Blood Group")) {

                    progressDialog.show();
                    progressDialog.setCancelable(false);
                    StorageReference reference = mStorageRefe.child("blodn").child(img.getLastPathSegment());
                    reference.putFile(img).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Uri downloaduri=taskSnapshot.getDownloadUrl();


                            DatabaseReference databaseReference=mref.push();
                            databaseReference.child("blodgrp").setValue(bloodgroup.toString());
                            databaseReference.child("Phone").setValue(phone);
                            databaseReference.child("image").setValue(downloaduri.toString());
                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                            String name = sharedPreferences.getString("s_name","");
                            databaseReference.child("name").setValue(name);
                            progressDialog.dismiss();


                                            }
                    });

                }



            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            Uri imageurl = data.getData();
            CropImage.activity(imageurl)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1)
                    .start(getContext(), this);

        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                img = result.getUri();
                pdf2.setImageURI(img);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


}
