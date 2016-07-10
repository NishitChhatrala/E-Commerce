package com.example.rajan.e_commarce.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rajan.e_commarce.BaseActivity;
import com.example.rajan.e_commarce.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.rajan.e_commarce.Constant.db;


public class Product_full_Detail extends BaseActivity {

    ArrayList<JSONObject> liststudents;


    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_onclick);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final String name;
        final int id,image;

        name = getIntent().getStringExtra("Name");
        id = getIntent().getIntExtra("Id", 1);
        image = getIntent().getIntExtra("Image",0);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject objStudent = new JSONObject();
                try {
                    objStudent.put("Id", id);

                    objStudent.put("Name", name);
                    objStudent.put("Price", "100");

                    // Log.d("Cart Item", "Item" + objStudent);
                    db.insertStudent(objStudent);

                    Log.d("Cart", "Cart Item" + objStudent);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Intent i = new Intent(getApplicationContext(), Cart.class);
                i.putExtra("Name",name);
                i.putExtra("Id",id);
                i.putExtra("Image",image);
                startActivityForResult(i, RESULT_OK);


            }
        });
    }

}
