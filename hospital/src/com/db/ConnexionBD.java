package com.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnexionBD {

    static Connection conn;
    static Statement etat;
    static ResultSet result;
    
    
    public static  Connection getConnexion()
    {
    	
         String connexionBase = "com.mysql.jdbc.Driver";
         String url="jdbc:mysql://localhost:3306/ges_cons";
         String login="root";
         String motdepass="";
         
        try {
            Class.forName(connexionBase);
             try {
                 conn = (Connection) DriverManager.getConnection(url,login,motdepass);
           //      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ges_cons","root", "");
                
             } catch (SQLException err) 
             {
            	 err.printStackTrace();
             }
            } 
        catch (ClassNotFoundException err) {
        	err.printStackTrace();
        }
       return conn;
    }

    public static int  executeMAJ(String sql){
        int tmp =0;
        
        try {
            conn = getConnexion();
            etat = (Statement) conn.createStatement();
            tmp = etat.executeUpdate(sql);
            
        } catch (SQLException err) {
        	err.printStackTrace();
        }
       
        return tmp;
    }
    
   public static ResultSet requette(String sql)
   {
         conn = getConnexion();
        try {
            etat = (Statement) conn.createStatement();
            result = etat.executeQuery(sql);
         
        } catch (SQLException ex) {
        	 ex.printStackTrace();
        }

      return result;         
   }
   
}
