package com.example.rajan.e_commarce.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajan.e_commarce.Activity.Remove;
import com.example.rajan.e_commarce.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.rajan.e_commarce.Constant.db;

/**
 * Created by DELL I5547 on 09-05-2016.
 */
public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.MyViewHolder>  {
    Activity activity;
    Context context;
    ArrayList<JSONObject> listStudents;
public class MyViewHolder extends RecyclerView.ViewHolder{



    public TextView title,remove1,wishlist1;
    public Button remove,wishlist;
    public ImageView picture;
     public MyViewHolder(View itemView) {

        super(itemView);
        title = (TextView)itemView.findViewById(R.id.title);
        remove1 = (TextView)itemView.findViewById(R.id.remove);
        picture = (ImageView)itemView.findViewById(R.id.picture);
    }
}

    String name;
    int id,image;

    public RecylerAdapter(Activity activity,ArrayList<JSONObject> listStudents,String name,int id,int image){
        this.activity = activity;
        this.listStudents = listStudents;
        this.id = id;
        this.name = name;
        this.image = image;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_inside, parent, false);

        context = itemView.getContext();

        JSONObject oasa = listStudents.get(viewType);
        System.out.print("Ojasas" + oasa.toString());


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



        final JSONObject objStudent = listStudents.get(position);

        try {
            holder.title.setText(objStudent.getString("Name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        holder.remove1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String id1 = "2";
                try {
                    id1 = objStudent.getString("id").toString();
                } catch (JSONException e) {
                    e.printStackTrace();

                }

                db.removeStudent(Integer.parseInt(id1));


                listStudents = db.getStudents();
                Intent i = new Intent(context, Remove.class);
                context.startActivity(i);
                ((Activity)context).finish();



                return false;
            }
        });


    }

    @Override
    public int getItemCount() {


        return listStudents.size();
    }
}
