package com.example.rajan.e_commarce.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajan.e_commarce.Activity.Cart;
import com.example.rajan.e_commarce.Activity.Product_full_Detail;
import com.example.rajan.e_commarce.Model.Product_Detail;
import com.example.rajan.e_commarce.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.rajan.e_commarce.Constant.db;

/**
 * Created by rajan on 1/4/16.
 */


public class ItemDetailAdapter extends RecyclerView.Adapter<ItemDetailAdapter.MyViewHolder>  {
    public ArrayList<Product_Detail> mArrayList;
    Context context;
    String categary;

    public ItemDetailAdapter(ArrayList<Product_Detail> arrayList,String categary) {
        this.mArrayList = arrayList;
        this.categary = categary;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView description,price;
        public ImageButton add,share,favoutite;
        public ImageView picture;
        public MyViewHolder(final View itemView) {

            super(itemView);
            context = itemView.getContext();
            description = (TextView)itemView.findViewById(R.id.description);
            price = (TextView)itemView.findViewById(R.id.price_digit);
            add = (ImageButton)itemView.findViewById(R.id.add);
            share = (ImageButton)itemView.findViewById(R.id.share);
            favoutite = (ImageButton)itemView.findViewById(R.id.favourite);
            picture = (ImageView)itemView.findViewById(R.id.picture);

            itemView.setClickable(true);





            favoutite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int i = 0;



                    if(i==0) {
                        favoutite.setImageResource(R.drawable.ic_favorite_24dp1);
                        i++;
                    }
                    else if(i==1){
                        favoutite.setImageResource(R.drawable.ic_favorite_24dp);
                        i--;
                    }

                }
            });

        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_item_detail, parent, false);

        context = itemView.getContext();




        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


//        String s = mArrayList.get(position).toString();

       switch (categary){


            case "Newly" :

                for(int i =0;i<mArrayList.size();i++) {
                    holder.description.setText(mArrayList.get(position).getName().toString());
                    holder.price.setText("100");
                    holder.picture.setImageResource(mArrayList.get(position).getImage());
                }
                break;
            case "Rings" :
                for(int i =0;i<mArrayList.size();i++) {
                    holder.description.setText(mArrayList.get(position).getName().toString());
                    holder.price.setText("200");
                    holder.picture.setImageResource(mArrayList.get(position).getImage());
                }
                break;
            case "Bracelets" :
                for(int i =0;i<mArrayList.size();i++) {
                    holder.description.setText(mArrayList.get(position).getName().toString());
                    holder.price.setText("300");
                    holder.picture.setImageResource(mArrayList.get(position).getImage());
                }
                break;
            case "Necklace" :
                for(int i =0;i<mArrayList.size();i++) {
                    holder.description.setText(mArrayList.get(position).getName().toString());
                    holder.price.setText("400");
                    holder.picture.setImageResource(mArrayList.get(position).getImage());
                }
                break;
            case "Ear Rings" :
                for(int i =0;i<mArrayList.size();i++) {
                    holder.description.setText(mArrayList.get(position).getName().toString());
                    holder.price.setText("500");
                    holder.picture.setImageResource(mArrayList.get(position).getImage());
                }
        }




        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                JSONObject objStudent = new JSONObject();
                try {
                    objStudent.put("Id", mArrayList.get(position).getProduct_id());

                    objStudent.put("Name", mArrayList.get(position).getName());
                    objStudent.put("Price", "100");

                    // Log.d("Cart Item", "Item" + objStudent);
                    db.insertStudent(objStudent);

                    Log.d("Cart", "Cart Item" + objStudent);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                Intent i = new Intent(context,Cart.class);
                context.startActivity(i);
//                    ((Activity)context).finish();






            }
        });



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(context, Product_full_Detail.class);
                i.putExtra("Name",mArrayList.get(position).getName().toString());
                i.putExtra("Id",mArrayList.get(position).getProduct_id());
                i.putExtra("Image",mArrayList.get(position).getImage());
                context.startActivity(i);


            }
        });


    }


    @Override
    public int getItemCount() {


        return mArrayList.size();
    }



}
