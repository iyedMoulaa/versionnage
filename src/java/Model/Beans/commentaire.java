

package Model.Beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class commentaire {

    private int id_commentaire;
    private String text_commentaire;
    private String date_commentaire;
    private int id_sujet;    
    private Utilisateur user;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");



    public commentaire(int id_commentaire, String text_commentaire, String date_commentaire, int id_sujet, Utilisateur user) {
        this.id_commentaire = id_commentaire;
        this.text_commentaire = text_commentaire;
        this.date_commentaire = date_commentaire;
        this.id_sujet = id_sujet;
        this.user = user;
    }

    public commentaire(String contenu, int idSujet, Utilisateur user) {
    this.text_commentaire=contenu;
    this.id_sujet=idSujet;
    this.user=user;
    this.date_commentaire=dateFormat.format(new Date());
    }
    
    
   




    public int getId_commentaire() {
       
        return this.id_commentaire;
    }


    public void setId_commentaire(final int value) {
     
        this.id_commentaire = value;
    }


    public String getText_commentaire() {
   
        return this.text_commentaire;
    }

    public void setText_commentaire(final String value) {
       
        this.text_commentaire = value;
    }
    public commentaire() {
    }

   
    public String getDate_commentaire() {
        
        return this.date_commentaire;
    }

 
    public void setDate_commentaire(final String value) {
        
        this.date_commentaire = value;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    


    public void setId_sujet(int id_sujet) {
        this.id_sujet = id_sujet;
    }

    public int getId_sujet() {
        return id_sujet;
    }
      public DateFormat getDateFormat() {
        return dateFormat;
    }

}
