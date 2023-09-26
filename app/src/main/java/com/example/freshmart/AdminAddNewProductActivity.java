package com.example.freshmart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.freshmart.Model.Products;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class AdminAddNewProductActivity extends AppCompatActivity {

    Button AddNewProductButton;
    EditText InputProductName,InputProductDescription, InputProductPrice, InputProductCategory;
    ImageButton InputProductImage;
    DatabaseReference reff;
    Products products;
   StorageReference storageRef;
    Uri imguri;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        reff = FirebaseDatabase.getInstance().getReference("Products");
        products=new Products();

        AddNewProductButton=findViewById(R.id.add_new_product);
        InputProductImage=findViewById(R.id.select_product_image);
        InputProductDescription=findViewById(R.id.product_description);
        InputProductName=findViewById(R.id.product_name);
        InputProductPrice=findViewById(R.id.product_price);
        InputProductCategory=findViewById(R.id.product_category);
        progressDialog = new ProgressDialog(AdminAddNewProductActivity.this);

        InputProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
                uploadImage(imguri);
            }
        });

        AddNewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String imageid = System.currentTimeMillis()+"."+getExtension(imguri);
                products.setPname(InputProductName.getText().toString().trim());
                products.setDescription(InputProductDescription.getText().toString().trim());
                products.setPrice(InputProductPrice.getText().toString().trim());
                products.setCategory(InputProductCategory.getText().toString().trim());
                //products.setImageUrl(imguri.toString());

                reff.push().setValue(products);
                Toast.makeText(AdminAddNewProductActivity.this, "Product Uploaded Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Filechooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imguri = data.getData();
           // Picasso.with(AdminAddNewProductActivity.this).load(imguri).into(InputProductImage);
            //uploadImage(imguri);
            InputProductImage.setImageURI(imguri);
        }
    }

    private void uploadImage(Uri imguri) {

        storageRef= FirebaseStorage.getInstance().getReference("Images").child("imageUrl");
        if (imguri != null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

          String imageid = System.currentTimeMillis()+"."+getExtension(imguri);
           StorageReference ref = storageRef.child(imageid);

            ref.putFile(imguri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    progressDialog.dismiss();
                                    //reff.push().setValue(uri.toString());
                                    products.setImageUrl(uri.toString());
                                    Toast.makeText(AdminAddNewProductActivity.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(AdminAddNewProductActivity.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(
                                UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        }
    }

    private String getExtension(Uri imguri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(imguri));
    }

}