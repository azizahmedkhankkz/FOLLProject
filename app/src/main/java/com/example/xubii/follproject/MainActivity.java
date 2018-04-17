package com.example.xubii.follproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xubii.follproject.database.ground;
import com.example.xubii.follproject.database.groundFB;
import com.example.xubii.follproject.database.myDataBase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private groundFB groundObj;
    private DatabaseReference firebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        groundObj = new groundFB();
        firebase= FirebaseDatabase.getInstance().getReference();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void  uploadPic(View v)
    {
        startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), 1);

    }
    public void submit(View v)
    {
        EditText a = findViewById(R.id.editText);
        if(a.length()!=0)
        groundObj.setOwnerName(a.getText().toString());
        a=findViewById(R.id.editText2);
        if(a.length()!=0)
        groundObj.setGroundName(a.getText().toString());
        a=findViewById(R.id.editText3);
        if(a.length()!=0)
        groundObj.setPhone(a.getText().toString());
        a=findViewById(R.id.editText4);
        if(a.length()!=0)
        groundObj.setEmail(a.getText().toString());
        a=findViewById(R.id.editText5);
        if(a.length()!=0)
        groundObj.setLocation(a.getText().toString());

       // new TestDatabaseAsyncTask(this,groundObj).execute();

        firebase.child("groundFB").child("g1").setValue(groundObj);
         Intent i = new Intent(this,temp.class);
                 startActivity(i);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==1 && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            groundObj.setImage(selectedImage);

            
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                ImageView ig = findViewById(R.id.imageView);
                ig.setImageBitmap(bitmap);
             //   groundObj.setImage(bitmap);
               /*
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                groundObj.setImage(byteArray);
                 */

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

 class TestDatabaseAsyncTask extends AsyncTask<Void, Void, Boolean>
 {
    Context c;
    ground gg;
    TestDatabaseAsyncTask(Context con, ground g)
    {
        c = con;
        gg=g;
    }

     @Override
     protected Boolean doInBackground(Void... grounds)
     {
         myDataBase myDb = myDataBase.getAppDatabase(c);
         myDb.groundDao().insertAll(gg);
         return true;
     }

     @Override
     protected void onPostExecute(Boolean aBoolean) {
         super.onPostExecute(aBoolean);
         if (aBoolean)
            Toast.makeText(c,"Ground Added Successfully",Toast.LENGTH_SHORT).show();
         else
            Toast.makeText(c,"Ground Adding FAILED",Toast.LENGTH_SHORT).show();

     }
 }