package com.example.rajan.e_commarce.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.rajan.e_commarce.Model.Product_Detail;
import com.example.rajan.e_commarce.R;
import com.example.rajan.e_commarce.Volley.AppController;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rajan on 2/24/2016.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Product_Detail> mArrayList;
    LayoutInflater inflater=null;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();




    public GridViewAdapter(Context context, ArrayList<Product_Detail> mArrayList){
        this.mContext = context;
        this.mArrayList=mArrayList;
        inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public interface OnGridItemClickedListener {

        void onGridItemSelected(int position, Product_Detail product_detail);

    }

    private OnGridItemClickedListener onGridItemClickedListener;

    public void setOnGridItemClickedListener(OnGridItemClickedListener onGridItemClickedListener) {
        this.onGridItemClickedListener = onGridItemClickedListener;
    }
    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


            convertView = inflater.inflate(R.layout.datail_item, null);
            imageLoader = AppController.getInstance().getImageLoader();

        TextView name=(TextView)convertView.findViewById(R.id.name);
        ImageView image1=(ImageView)convertView.findViewById(R.id.image1);
        Product_Detail mItem=mArrayList.get(position);
        name.setText(mItem.getName());

        Picasso.with(mContext).load("http://192.168.137.1/photos/"+mItem.getImage()).resize(550,550).into(image1);



        return convertView;
    }
}
