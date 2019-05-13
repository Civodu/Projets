package com.db;

//import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		Connection conn;
		Statement etat;
		ResultSet result;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ges_cons","root","");
			etat=(Statement) conn.createStatement();
			result = etat.executeQuery("SELECT matricule,nom,tel,dateNaisse FROM patient");
			
			while(result.next()) {
System.out.println("Matricule :"+result.getString("matricule")+"Nom"+result.getString("nom")+"Telephone :"+result.getString("tel")+"Date de Naissance :"+result.getDate("dateNaisse"));
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
	}
}
