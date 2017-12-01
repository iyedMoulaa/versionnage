/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import Model.Beans.Sujet;
import Model.Beans.commentaire;
import Model.modCom;
import Model.modSujet;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class main {
    public static void main(String[]args){
     
        modCom mod = new modCom();

        List<commentaire> colcom = new ArrayList<commentaire>();
        
        colcom=mod.listeCommentaire(111);
       
        for(int i=0;i<colcom.size();i++){
         System.out.println(colcom.get(i).getText_commentaire());
        }

        
    }
}
