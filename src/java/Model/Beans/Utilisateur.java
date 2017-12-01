/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

import java.io.InputStream;
import static java.lang.System.in;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Utilisateur {

    private String username;
    private String password;
    private String adresse;
    private String nom;
    private String prenom;
    private String dateInscri;
    private String image;
    private InputStream in;
    private char etat;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String type;

    public Utilisateur(String username, InputStream in) {
        this.username = username;
        this.in = in;
    }
    
    

    public Utilisateur(String username, String password, String adresse, String nom, String prenom, String image, char etat) {
        this.username = username;
        this.password = password;
        this.adresse = adresse;
        this.dateInscri=dateFormat.format(new Date());
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.etat=etat;   
    }

    public Utilisateur(String username, String password, String adresse, String nom, String prenom, String dateInscri, String image , char etat,String type) {
        this.username = username;
        this.password = password;
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscri = dateInscri;
        this.image = image;
        this.etat=etat;
        this.type=type;
    }

    public Utilisateur(String username) {
    this.username = username;
    }

    public Utilisateur(String username, String date, String photo,String type) {
    this.username=username;
    this.dateInscri=date;
    this.image=photo;
    this.type=type;
    }

    public Utilisateur(String string, String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }


    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateInscri() {
        return dateInscri;
    }

    public void setDateInscri(String dateInscri) {
        this.dateInscri = dateInscri;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }
    
    
    
}
