package com.example.rajan.e_commarce.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.rajan.e_commarce.Adapter.GridViewAdapter;
import com.example.rajan.e_commarce.BaseActivity;
import com.example.rajan.e_commarce.Model.Product_Detail;
import com.example.rajan.e_commarce.R;

import java.util.ArrayList;

public class Producr_By_Cetogary extends BaseActivity {
    public static String DATA_URL="http://192.168.137.1/GridViewWithVolly/getData.php";
    public static String TAG_IMAGE_URL="image";
    public static String TAG_NAME="name";
    public static String TAG_LIKE="likee";
    public static final String JSON_ARRAY = "result";
    private android.support.v7.widget.Toolbar toolbar;
    private ProgressDialog loading;
    private GridView gridView;
    private ArrayList<Product_Detail> arrayList;
    private GridViewAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producr__by__cetogary);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        gridView=(GridView)findViewById(R.id.gridView);
        arrayList=new ArrayList<Product_Detail>();
        //getData();

        adapter=new GridViewAdapter(getApplicationContext(),arrayList);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"rrrrrrr",Toast.LENGTH_SHORT).show();
            }
        });
    }
/*
    private void getData(){
        loading=ProgressDialog.show(Producr_By_Cetogary.this,"Please wait.....","Feaching...",false,false);


        StringRequest request=new StringRequest(DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                parseJsonFeed(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
            }
        });
        AppController.getInstance().addToRequestQueue(request);
    }
    //  }
*/

   /* private  void parseJsonFeed(String response){
        try {
            JSONObject obj=new JSONObject(response);
            JSONArray array=obj.getJSONArray(JSON_ARRAY);

            for(int i=0;i<array.length();i++){
                JSONObject object=(JSONObject)array.get(i);
                Product_Detail item=new Product_Detail();
                item.setName(object.getString(TAG_NAME));
                item.setImage(object.getString(TAG_IMAGE_URL));
                arrayList.add(item);
            }
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/




}

