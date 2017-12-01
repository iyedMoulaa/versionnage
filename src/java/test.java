
import DAO.dao;
import Model.Beans.Sujet;
import Model.Beans.Utilisateur;
import Model.Beans.commentaire;
import Model.modCom;
import Model.modSujet;
import Model.modTheme;
import Model.modUser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class test {
    
    public static void main(String args[]) 
    {
       /* try
        {
        new dao().ajoutCommentaire(new commentaire("hhh",117,new Utilisateur("zli3a")));
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }*/
         dao d=new dao();    
        List<Sujet> s=new ArrayList<Sujet>();
        s=d.rechercherSujet("argent");
        for(int i = 0; i <s.size(); i++)
            {
                System.out.print(s.get(i).getTitre());
                 System.out.print(s.get(i).getUser().getUsername().toString());
            }  
   
                  
    }
}
   

