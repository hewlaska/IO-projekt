package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
    private TextView tvName, tvWeb, tvDes, tvMore;
    String id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        init();
        getInitentMain();
    }

    private void init()
    {
        tvName = findViewById(R.id.tvName);
        tvWeb = findViewById(R.id.tvWeb);
        tvDes = findViewById(R.id.tvDes);
        tvMore = findViewById(R.id.tvMore);
    }

    private void getInitentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvName.setText(i.getStringExtra(Constant.OFFER_NAME));
            tvWeb.setText(i.getStringExtra(Constant.OFFER_WEB));
            tvDes.setText(i.getStringExtra(Constant.OFFER_DES));
            tvMore.setText(i.getStringExtra(Constant.OFFER_MORE));
            id = i.getStringExtra(Constant.OFFER_ID);
        }
    }

    public void onClickEd (View view)
    {
        Intent i = new Intent(ShowActivity.this, EditActivity.class);
        i.putExtras(getIntent());
        startActivity(i);
    }

    public void onClickWroc4()
    {
        Intent i = new Intent(ShowActivity.this,ReadActivity.class);
        startActivity(i);
    }

}