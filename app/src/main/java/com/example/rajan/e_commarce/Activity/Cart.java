package com.example.rajan.e_commarce.Activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import com.example.rajan.e_commarce.Adapter.RecylerAdapter;
import com.example.rajan.e_commarce.BaseActivity;
import com.example.rajan.e_commarce.R;

import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.rajan.e_commarce.Constant.db;

public class Cart extends BaseActivity {


    ListView listView;
    ArrayList<JSONObject> listStudents;
    Button button;
    RecylerAdapter mRecylerAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



        String name;
        int id,image;

        name = getIntent().getStringExtra("Name");
        id = getIntent().getIntExtra("Id", 0);
        image = getIntent().getIntExtra("Image",0);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
       /* RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
       */ LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mRecylerAdapter);
        listStudents = db.getStudents();

        Log.d("Students", "Students" + db.getStudents());


        if(listStudents!=null && listStudents.size()>0){
            mRecylerAdapter= new RecylerAdapter(Cart.this,listStudents,name,id,image);
            recyclerView.setAdapter(mRecylerAdapter);
        }


    }
}
