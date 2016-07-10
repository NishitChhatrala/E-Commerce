package com.example.rajan.e_commarce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rajan.e_commarce.database.AppDB;

import static com.example.rajan.e_commarce.Constant.db;

public class BaseActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		if (db == null)
			db = new AppDB(this);
	}
}
