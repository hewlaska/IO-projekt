package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void onClickDodaj(View view)
    {
        Intent i = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void onClickZobacz(View view)
    {
        Intent i = new Intent(MenuActivity.this, ReadActivity.class);
        startActivity(i);
    }
}
