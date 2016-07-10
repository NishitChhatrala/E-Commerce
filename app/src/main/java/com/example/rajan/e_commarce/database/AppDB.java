package com.example.rajan.e_commarce.database;

import android.content.Context;
import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AppDB extends DBConnect {
	
	public AppDB(Context context) {
		super(context);
	}

	/**
	 * To insert student
	 * @param value
	 */
	public void insertStudent(JSONObject objStudent) {
		String sqlCards;
		
		try {
			System.out.println("Hello"+objStudent.toString());
			sqlCards = String.format(ISql.INSERT_STUDENT, Integer.parseInt(objStudent.getString("Id")),
					objStudent.getString("Name"),
					objStudent.getString("Price"));
			
			execNonQuery(sqlCards);			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 
	/**
	 * To remove Student
	 */
	public void removeStudent(int rollNo)
	{
		if(rollNo>0)
		{
			String sqlRemoveRegCard = String.format(ISql.REMOVE_STUDENT, rollNo);
			execNonQuery(sqlRemoveRegCard);
		}
	}
	
	/**
	 * To count no. of Students
	 * @return
	 */
	public int countStudent()
	{
		Cursor cursor = execQuery(ISql.COUNT_STUDENT);
		int cntCards = 0;
		
		if(cursor!=null && cursor.getCount()>0) {
			cursor.moveToNext();
			cntCards = Integer.parseInt(cursor.getString(0));
		}
		
		if(cursor!= null) {
			cursor.close();
		}
			
		return cntCards;
	}
	
	/**
	 * To get all the Students
	 * @return
	 */
	public ArrayList<JSONObject> getStudents() {
		Cursor cursor = execQuery(ISql.GET_STUDENT);

		ArrayList<JSONObject> listStudent = new ArrayList<JSONObject>();
		JSONObject objStudent;
		
		if (cursor != null && cursor.getCount() > 0) {

			if (cursor.moveToNext()) {

				do {
					objStudent = new JSONObject();
					
					try {
						objStudent.put("Id", String.valueOf(cursor.getInt(cursor.getColumnIndex("Id"))));
						objStudent.put("Name", cursor.getString(cursor.getColumnIndex("Name")));
						objStudent.put("Price", cursor.getString(cursor.getColumnIndex("Price")));
						listStudent.add(objStudent);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} while (cursor.moveToNext());
			}
		}

		if (cursor != null) {
			cursor.close();
		}

		return listStudent;
	}
}
