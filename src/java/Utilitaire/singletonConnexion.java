package Utilitaire;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer C
 */
public class singletonConnexion {
    
   private static Connection connect;
   
   static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/jeune_forum","root","");
        }
        catch(Exception e)
        {
            System.out.println("connexion echouee : \n"+e.getMessage());
        }
    }
   public static Connection getConn()
   {
       return connect;
   }
    
    
}
