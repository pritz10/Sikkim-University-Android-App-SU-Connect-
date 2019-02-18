package com.pritz.sikkimuniversity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class Story extends Fragment {
    Uri imageurl=null;
    EditText storymes;
    ImageButton send;
    ImageButton adde;
    ImageButton opner;
    ImageButton cam;
    private final int img=1;
    Bitmap bitmap;
    ImageView image;
    LinearLayout opener1;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int CAMERA_REQUEST = 1888;
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
        opner=(ImageButton)getActivity().findViewById(R.id.opener);
        send=(ImageButton)getActivity().findViewById(R.id.sendbtn);
        image = (ImageView)getActivity().findViewById(R.id.image);
        adde=(ImageButton)getActivity().findViewById(R.id.adde);
        opener1 = (LinearLayout)getActivity().findViewById(R.id.add);
        storymes=(EditText)getActivity().findViewById(R.id.strymsg);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startposting();
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
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

        opner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opener1.getVisibility() == View.GONE)
                    opener1.setVisibility(View.VISIBLE);
                else
                    opener1.setVisibility(View.GONE);
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

        if(requestCode==img && resultCode==RESULT_OK && data!=null){
            Uri path = data.getData();
            try {
                // ArrayList<Uri> image_uris = data.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),path);
                /*Matrix matrix = new Matrix();
                matrix.postRotate(180);
                Bitmap rotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),
                        matrix, true);*/

                //    image.setImageBitmap(rotated);
                image.setImageBitmap(bitmap);
                image.setVisibility(View.VISIBLE);

            } catch (IOException e) {
                e.printStackTrace();
            }

           /* Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void onGenerated(Palette palette) {
                    final Palette.Swatch vibrantSwatch = palette.getDarkVibrantSwatch();
                    if (vibrantSwatch != null) {
                        outerLayout.setBackgroundColor(vibrantSwatch.getRgb());
                        upload.setBackgroundColor(vibrantSwatch.getTitleTextColor());
                        bodyText.setTextColor(vibrantSwatch.getBodyTextColor());
                        choose.setBackgroundColor(vibrantSwatch.getTitleTextColor());
                        camera.setBackgroundColor(vibrantSwatch.getTitleTextColor());
                        bodyText.setBackgroundColor(vibrantSwatch.getTitleTextColor());
                    }
                }
            }); */
        }

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
        }


    }
}
