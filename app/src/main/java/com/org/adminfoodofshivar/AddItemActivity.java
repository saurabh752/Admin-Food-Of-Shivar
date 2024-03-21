package com.org.adminfoodofshivar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.org.adminfoodofshivar.adapter.Model;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;
import java.util.Random;

public class AddItemActivity extends AppCompatActivity {
    TextView img_select_btn;
    EditText item_namee, item_pricee, item_short_description, item_Ingredients;
    Button add_item_btn;
    ImageView image_vieww, back_btn;
    private FirebaseAuth firebaseAuth;
    Uri filepath;
    Bitmap bitmap;


    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        img_select_btn = findViewById(R.id.img_select_btn);

        add_item_btn = findViewById(R.id.add_item_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        image_vieww = findViewById(R.id.image_vieww);
        back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        img_select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(AddItemActivity.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent, "select image file"), 1);


                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        add_item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadDataInFirebase();
            }
        });


    }

    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==1 && resultCode==RESULT_OK){
            filepath=data.getData();
        try {
            InputStream inputStream=getContentResolver().openInputStream(filepath);
            bitmap= BitmapFactory.decodeStream(inputStream);
            image_vieww.setImageBitmap(bitmap);
            }catch (Exception e)
        {
            e.printStackTrace();
        }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void UploadDataInFirebase() {

        ProgressDialog dialog= new ProgressDialog(this);
        dialog.setTitle(" File Update");
        dialog.show();

        item_namee = findViewById(R.id.item_namee);
        item_pricee = findViewById(R.id.item_pricee);
        item_short_description = findViewById(R.id.item_short_description);
        item_Ingredients = findViewById(R.id.item_Ingredients);

        FirebaseStorage db=FirebaseStorage.getInstance();
        StorageReference upload=db.getReference("Image1"+new Random().nextInt(50));
        upload.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        upload.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                dialog.dismiss();
                                FirebaseDatabase db=FirebaseDatabase.getInstance();
                                DatabaseReference root=db.getReference("Menu");

                                Model obj=new Model(item_namee.getText().toString(),item_pricee.getText().toString(),uri.toString(),item_short_description.getText().toString(),item_Ingredients.getText().toString());
                                root.push().setValue(obj);
                                item_namee.setText("");
                                item_pricee.setText("");
                                item_short_description.setText("");
                                item_short_description.setText("");
                                image_vieww.setImageResource(R.drawable.photo);
                                Toast.makeText(AddItemActivity.this, "upload", Toast.LENGTH_SHORT).show();


                            }
                        });

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        float percent = (100.0f * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                        dialog.setMessage("upload : " + (int) percent + " %");


                    }
                });




    }

}