package com.example.rajan.e_commarce.vertical;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.rajan.e_commarce.Activity.Producr_By_Cetogary;
import com.example.rajan.e_commarce.R;


public class IngredientViewHolder extends ChildViewHolder {

    private TextView mIngredientTextView;

    public IngredientViewHolder(View itemView, final Context context) {
        super(itemView);
        mIngredientTextView = (TextView) itemView.findViewById(R.id.ingredient_textview);
        mIngredientTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(context,"rfbekr",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, Producr_By_Cetogary.class);

                context.startActivity(intent);

                return false;
            }
        });
    }

    public void bind(String ingredient) {
        mIngredientTextView.setText(ingredient)
        ;
    }
}
