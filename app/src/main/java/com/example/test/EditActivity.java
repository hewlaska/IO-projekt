package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditActivity extends AppCompatActivity{
    private EditText editName, editWeb, editDes, editMore;
    private DatabaseReference mDataBase;
    String KEY = "Offer";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        init();
    }

    private void init()
    {
        editName = findViewById(R.id.editname);
        editWeb = findViewById(R.id.editWeb);
        editDes = findViewById(R.id.editDes);
        editMore = findViewById(R.id.editMore);
        mDataBase = FirebaseDatabase.getInstance().getReference(KEY);
    }

    private void onClickEd(View view)
    {
        String id = mDataBase.getKey();
        String name = editName.getText().toString();
        String web = editWeb.getText().toString();
        String des = editDes.getText().toString();
        String more = editMore.getText().toString();
        Offer newOffer = new Offer(id,name,web,des,more);

        mDataBase.push().setValue(newOffer);
    }
}
