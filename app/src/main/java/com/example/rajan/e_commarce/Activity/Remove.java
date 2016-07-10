package com.example.rajan.e_commarce.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rajan.e_commarce.R;

public class Remove extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);


        Intent i = new Intent(getApplicationContext(),Cart.class);
        startActivityForResult(i,RESULT_OK);
        finish();

    }
}
