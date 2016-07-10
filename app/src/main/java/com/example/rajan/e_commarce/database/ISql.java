package com.example.rajan.e_commarce.database;

public interface ISql {
	
	String INSERT_STUDENT = "INSERT OR REPLACE INTO Cart1(Id, Name, Price,ImageId) values (%s, '%s', '%s',%s)";
	String GET_STUDENT = "SELECT Id,Name,Price FROM Cart1";
	String REMOVE_STUDENT = "DELETE FROM Cart1 WHERE Id = %d";
	String COUNT_STUDENT = "SELECT count(Id) from Cart1";
	
	//String GET_STUDENTS = "Select * from tblStudent";
}
