package Model.Beans;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class Sujet {


    private int id_sujet;
    private String titre;
    private String text; 
    private String date_sujet;
    private int idTheme;
    private Utilisateur user;
    

DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public Sujet(int id_sujet, String titre, String text) {
        this.id_sujet = id_sujet;
        this.titre = titre;
        this.text = text;;
    }

    public Sujet(int id_sujet, String titre, String text, String date_sujet, int idTheme, Utilisateur user) {
        this.id_sujet = id_sujet;
        this.titre = titre;
        this.text = text;
        this.date_sujet = date_sujet;
        this.idTheme = idTheme;
        this.user = user;
    }

    public Sujet(String titre, String contenu, int idtheme, Utilisateur user) {
    this.titre=titre;
    this.text=contenu;
    this.idTheme=idtheme;
    this.user=user;
    this.date_sujet = dateFormat.format(new Date());
    }

   

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    



    public int getId_sujet() {

        return this.id_sujet;
    }

    public void setId_sujet(final int value) {
        this.id_sujet = value;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(final String value) {
        this.titre = value;
    }

    public String getDate_sujet() {
        return this.date_sujet;
    }

    public void setDate_sujet(final String value) {
        this.date_sujet = value;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String value) {
        this.text = value;
    }
    
    public Sujet(String titre, String text,int id){
        this.titre = titre;
        this.text = text;  
        this.date_sujet =dateFormat.format(new Date());
        this.idTheme=id;
    }
    public Sujet(String titre, String text, String d, int id) {
        this.titre = titre;
        this.text = text; 
        this.date_sujet =d;
        this.idTheme=id;
    }

    public Sujet(int id_sujet, String titre, String text, String date_sujet, int idTheme) {
        this.id_sujet = id_sujet;
        this.titre = titre;
        this.text = text;
        this.date_sujet = date_sujet;
        this.idTheme = idTheme;
    }
    

    public int getIdTheme() {
        return idTheme;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

}
