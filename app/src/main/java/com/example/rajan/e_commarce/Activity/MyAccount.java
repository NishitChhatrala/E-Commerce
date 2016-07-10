package com.example.rajan.e_commarce.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rajan.e_commarce.R;

public class MyAccount extends AppCompatActivity {
    Button save, reset, show;
    EditText setpassword,conformpassword,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        save = (Button)findViewById(R.id.save);
        reset =(Button) findViewById(R.id.reset);
        show = (Button)findViewById(R.id.show);
        password = (EditText)findViewById(R.id.password);
        setpassword = (EditText)findViewById(R.id.setPassword);
        conformpassword = (EditText)findViewById(R.id.conformpassword);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (reset.getText().toString().equals("RESET")) {
                    password.setVisibility(View.GONE);
                    setpassword.setVisibility(View.VISIBLE);
                    conformpassword.setVisibility(View.VISIBLE);
                    show.setVisibility(View.GONE);
                    reset.setText("Save");
                } else {
                    password.setVisibility(View.VISIBLE);
                    setpassword.setVisibility(View.GONE);
                    conformpassword.setVisibility(View.GONE);
                    show.setVisibility(View.VISIBLE);
                    reset.setText("RESET");
                }
            }
            });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}