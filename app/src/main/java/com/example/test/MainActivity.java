package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edName, edWed, edDes, edMore;
    private DatabaseReference mDataBase;
    String KEY = "Offer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init()
    {
        edName = findViewById(R.id.edName);
        edWed = findViewById(R.id.edWeb);
        edDes = findViewById(R.id.edDes);
        edMore = findViewById(R.id.edMore);
        mDataBase = FirebaseDatabase.getInstance().getReference(KEY);
    }

    public void onClickSave(View view)
    {
        String id = mDataBase.getKey();
        String name = edName.getText().toString();
        String web = edWed.getText().toString();
        String des = edDes.getText().toString();
        String more = edMore.getText().toString();

        Offer newOffer = new Offer(id,name,web,des,more);
        //mDataBase.push().setValue(newOffer);

        if(!(TextUtils.isEmpty(name) && TextUtils.isEmpty(web) && TextUtils.isEmpty(des) && TextUtils.isEmpty(more)))
        {
            mDataBase.push().setValue(newOffer);
            Toast.makeText(this,"Save", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickRead(View view)
    {
        Intent i = new Intent(MainActivity.this, ReadActivity.class);
        startActivity(i);
    }

}