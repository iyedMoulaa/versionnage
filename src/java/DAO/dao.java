/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Beans.Sujet;
import Model.Beans.Utilisateur;
import Model.Beans.commentaire;
import Model.Beans.theme;
import Utilitaire.singletonConnexion;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class dao implements imp{
    
    Connection con =singletonConnexion.getConn();
    private ArrayList <Sujet> colSjt;
    private ArrayList <commentaire> colCom;
    
    
    public void modifierSujet(Sujet s)
    {
     try
        {
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE sujet SET titreSujet = '"+s.getTitre()+"', txtSujet = '"+s.getText()+"' WHERE idSujet = '"+s.getId_sujet()+"'");
        }
        catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }
     }
    
    @Override
    public List afficherSujets(int id) 
    {
         try
        {
            Statement ps=con.createStatement();
            ResultSet res;
            colSjt=new ArrayList<Sujet>();
            res=ps.executeQuery("select * from Sujet where idThm="+id+" order by(dateSujet) desc");
            while(res.next())
            {
                int idSujet = res.getInt("idSujet");
                String titreSjt=res.getString("titreSujet");
                String txtSjt=res.getString("txtSujet");
                String dateSjt=res.getString("dateSujet");
                int idtheme=res.getInt("idthm");
                String username = res.getString("username");
                Utilisateur user = new Utilisateur(username);
                colSjt.add(new Sujet(idSujet,titreSjt,txtSjt,dateSjt,idtheme,user));
            }
            return colSjt;
        }
          catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }   
          return null;
    }
    
    
        public List afficherSujets() 
    {
         try
        {
            Statement ps=con.createStatement();
            ResultSet res;
            colSjt=new ArrayList<Sujet>();
            res=ps.executeQuery("select * from Sujet order by(dateSujet) desc");
            while(res.next())
            {
                int idSujet = res.getInt("idSujet");
                String titreSjt=res.getString("titreSujet");
                String txtSjt=res.getString("txtSujet");
                String dateSjt=res.getString("dateSujet");
                int idtheme=res.getInt("idthm");
                String username=res.getString("username");
                Utilisateur user = new Utilisateur(username);
                colSjt.add(new Sujet(idSujet,titreSjt,txtSjt,dateSjt,idtheme,user));
            }
            return colSjt;
        }
          catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }   
          return null;
    }
    
    
    @Override
    public void ajoutSujet(Sujet s)
    {
     try
        {
            Statement ps=con.createStatement();
            ps.executeUpdate("insert into sujet values ("+null+",'"+s.getTitre()+"','"+s.getText()+"','"+s.getDate_sujet()+"','"+s.getIdTheme()+"','"+s.getUser().getUsername()+"')");
        }
        catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }
     }

    @Override
    public List ListerTheme() {
        
        ArrayList<theme>coltheme = null;
    try
    {
        Statement ps=con.createStatement();
        ResultSet res;
        coltheme=new ArrayList<theme>();
        res=ps.executeQuery("select * from theme");
            while(res.next())
            {
                int code=res.getInt("idThm");
                String titre=res.getString("titreThm");
                String img=res.getString("iconThm");            
                coltheme.add(new theme(code,titre,img));
            }
    }
    catch(Exception e)
    {
            JOptionPane.showMessageDialog(null,"Erreur d'affichage :\n"+e.getMessage());
    }
     return coltheme;
    }
        
    
    public List rechercherSujet(String crit) 
    {
         try
        {
            Statement ps=con.createStatement();
            ResultSet res;
            colSjt=new ArrayList<Sujet>();
            res=ps.executeQuery("select * from sujet where titreSujet like '%"+crit+"%' or txtSujet like '%"+crit+"%'");
            while(res.next())
            {
                int id=res.getInt("idSujet");
                String titreSjt=res.getString("titreSujet");
                String txtSjt=res.getString("txtSujet");
                String dateSjt=res.getString("dateSujet");
                int idtheme=res.getInt("idThm");
                String user=res.getString("username");
                Utilisateur u=new Utilisateur(user);
                colSjt.add(new Sujet(id,titreSjt,txtSjt,dateSjt,idtheme,u));
            }
            return colSjt;
        }
          catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }   
          return null;
    }
      
    public void supprimerSujet(int id) {
         try
        {
            Statement ps=con.createStatement();
            ps.executeUpdate("delete from Sujet where idSujet = '"+id+"'");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur de suppression\n"+e.getMessage());
        }
    }

    @Override
    public void ajoutCommentaire(commentaire c) {
try
        {
            Statement ps=con.createStatement();
            ps.executeUpdate("insert into commentaire values ("+null+",'"+c.getText_commentaire()+"','"+c.getDate_commentaire()+"','"+c.getId_sujet()+"','"+c.getUser().getUsername()+"')");
        }
        catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }    }

 
    @Override
    public void suuprimerCommentaire(int id) {
        try
        {
            Statement ps=con.createStatement();
            ps.executeUpdate("delete from commentaire where idCom = '"+id+"'");
          
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur de suppression\n"+e.getMessage());
        }
    }

    @Override
    public void modifierCommentaire(commentaire c) {
    try
        {
            Statement ps=con.createStatement();
           ps.executeUpdate("update commentaire set  textCom= '"+c.getText_commentaire()+"',dateCom = '"+c.getDate_commentaire()+"'where idCom='"+c.getId_commentaire()+"'");
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Erreur dde modification\n"+ex.getMessage());
        }   
    }

    @Override
    public List afficherCommentaire(int id ) {
        
        ArrayList<commentaire>colComm = null;
    try
    {
        Statement ps=con.createStatement();
        ResultSet res;
        colComm=new ArrayList<commentaire>();
        
        res=ps.executeQuery("select idCom,txtCom,dateCom,idSujet,commentaire.username,photo,date,type from commentaire,utilisateur  where commentaire.username=utilisateur.username and idSujet="+id+" order by(dateCom) desc");
            while(res.next())
            {
                int code=res.getInt("idCom");
                String titre=res.getString("txtCom");
                String date=res.getString("dateCom"); 
                int idSujet=res.getInt("idSujet");
                String username = res.getString("username");
                String dateIns=res.getString("date");
                String photo=res.getString("photo");
                String type=res.getString("type");
                Utilisateur user = new Utilisateur(username,dateIns,photo,type);
                colComm.add(new commentaire(code,titre,date,idSujet,user));          
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur d'affichage :\n"+e.getMessage());
        }
        return colComm;
        }

   
      public Utilisateur afficherUser(String username,String password) 
    {
        Utilisateur user=null;
         try
        {
            Statement ps=con.createStatement();
            ResultSet res;
            res=ps.executeQuery("select * from Utilisateur where username='"+username+"' and password='"+password+"'");
            while(res.next())
            {
                String adresse=res.getString("adresse");
                String nom=res.getString("nom");
                String prenom=res.getString("prenom");
                String date=res.getString("date");
                String photo=res.getString("photo");
                char etat=(char) res.getByte("Connecter");
                String type=res.getString("type");
                user = new Utilisateur(username,password,adresse,nom,prenom,date,photo,etat,type);    
            } 
        }
          catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }   
       return user;
    }
      
      
    //********* fonction permet de calculer le nbr d'utilisateur connecté pour le moment 
    public int nbrConncter(){
        int nb =0 ;
          try
        {
            Statement ps=con.createStatement();
            ResultSet res ;
            res=ps.executeQuery("select count(*) from Utilisateur where Connecter=1");
            res.next();
            nb=(int)res.getInt(1);
        }
          catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }   
        return nb ;
    }
    //*****************fonction permet de metre l'etat de l"utilisateur conncter dans le base a chaque connexion
    public void userconnecter(Utilisateur user){
    try
        {
            Statement ps=con.createStatement();
            ps.executeUpdate("update Utilisateur set Connecter=1 where username='"+user.getUsername()+"'");            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Erreur dde modification\n"+ex.getMessage());
        }         
    }
    
    public void userdeconnecter(Utilisateur user){
    try
    {
        Statement ps=con.createStatement();
        ps.executeUpdate("update Utilisateur set Connecter=0 where username='"+user.getUsername()+"'");            
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(null,"Erreur dde modification\n"+ex.getMessage());
    }         
    }
    
    
    //********* fonction permet de calculer le nbr d'utilisateur total 
    public List<Utilisateur> ALLuser(){
        List<Utilisateur> lstuser = new ArrayList<Utilisateur>();
        Utilisateur user=null;
         try
        {
            Statement ps=con.createStatement();
            ResultSet res;
            res=ps.executeQuery("select * from Utilisateur order by(date) desc");
            while(res.next())
            {
                String username= res.getString("username");
                String password = res.getString("password");
                String adresse=res.getString("adresse");
                String nom=res.getString("nom");
                String prenom=res.getString("prenom");
                String date=res.getString("date");
                String photo=res.getString("photo");
                char etat=(char) res.getByte("Connecter");
                String type=res.getString("type");
                user = new Utilisateur(username,password,adresse,nom,prenom,date,photo,etat,type);   
                lstuser.add(user);  
            } 
        }
          catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }   
        return lstuser;
    }
        
    public void ajoutUser(Utilisateur u)  {
              
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("insert into utilisateur(username,photo) values(?,?)");
            stmt.setString(1, u.getUsername());
            stmt.setBlob(2,u.getIn());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }     
       
        public List afficherSujet(int id) 
    {
         try
        {
            Statement ps=con.createStatement();
            ResultSet res;
            colSjt=new ArrayList<Sujet>();
            res=ps.executeQuery("select titreSujet,txtSujet,dateSujet,idthm,sujet.username,photo,date,type from sujet,utilisateur where sujet.username=utilisateur.username and  idSujet="+id);
            while(res.next())
            {
               
                String titreSjt=res.getString("titreSujet");
                String txtSjt=res.getString("txtSujet");
                String dateSjt=res.getString("dateSujet");
                int idtheme=res.getInt("idthm");
                String username=res.getString("username");
                String date=res.getString("date");
                
                Blob blob=res.getBlob("photo");
                InputStream in=blob.getBinaryStream();
                int size=in.available();
                OutputStream op=new FileOutputStream("C:\\Users\\zliaa\\Desktop\\forum\\projet\\projet\\web\\images\\"+username+".png");
                byte b[] = new byte[size];
                in.read(b);
                op.write(b);
              
                String type=res.getString("type");
                Utilisateur user = new Utilisateur(username,date,"images/"+username+".png",type);
                colSjt.add(new Sujet(id,titreSjt,txtSjt,dateSjt,idtheme,user));
            }
            return colSjt;
        }
          catch(Exception e)
        {
           System.out.println("Erreur d'ajout\n"+e.getMessage());
        }   
          return null;
    }

}

   

