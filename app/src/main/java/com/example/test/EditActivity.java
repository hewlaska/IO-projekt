package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditActivity extends AppCompatActivity {
    private EditText edName, edWed, edDes, edMore;
    private DatabaseReference mDataBase;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        init();
    }

    public void init()
    {
        edName = findViewById(R.id.editname);
        edWed = findViewById(R.id.editWeb);
        edDes = findViewById(R.id.editDes);
        edMore = findViewById(R.id.editMore);
        mDataBase = FirebaseDatabase.getInstance().getReference(Constant.OFFER_KEY);
    }

    public void onClickEdit (View view)
    {
        Intent i = getIntent();
        if(i != null)
        {
            id = i.getStringExtra(Constant.OFFER_ID);
        }
        String name = edName.getText().toString();
        String web = edWed.getText().toString();
        String des = edDes.getText().toString();
        String more = edMore.getText().toString();

        mDataBase.child(Constant.OFFER_KEY).child(id).child("name").setValue(name);
        mDataBase.child(Constant.OFFER_KEY).child(id).child("web").setValue(web);
        mDataBase.child(Constant.OFFER_KEY).child(id).child("des").setValue(des);
        mDataBase.child(Constant.OFFER_KEY).child(id).child("more").setValue(more);

        Intent j = new Intent(EditActivity.this, ReadActivity.class);
        startActivity(j);
    }
}
