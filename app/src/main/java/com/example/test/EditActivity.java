package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditActivity extends AppCompatActivity{
    private EditText editName, editWeb, editDes, editMore;
    private DatabaseReference mDataBase;
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
        mDataBase = FirebaseDatabase.getInstance().getReference(Constant.KEY);
    }


    private void onClickEd(View view)
    {
        Intent i = getIntent();
        if(i != null)
        {
            mDataBase.child(i.getStringExtra(Constant.KEY)).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    task.getResult().getValue(Offer.class);
                }
            });
            String name = editName.getText().toString();
            String web = editWeb.getText().toString();
            String des = editDes.getText().toString();
            String more = editMore.getText().toString();
            Offer newOffer = new Offer(i.getStringExtra(Constant.KEY),name,web,des,more);

            mDataBase.child(i.getStringExtra(Constant.KEY)).setValue(newOffer);
        }
        Intent I = new Intent(EditActivity.this, ShowActivity.class);
        startActivity(I);

    }
}
