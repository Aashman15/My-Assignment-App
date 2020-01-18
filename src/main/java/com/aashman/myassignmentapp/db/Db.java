package com.aashman.myassignmentapp.db;
import java.sql.DriverManager;
public class Db {
    public static java.sql.Connection getDb(){
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/assignmentdb", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }	
}
