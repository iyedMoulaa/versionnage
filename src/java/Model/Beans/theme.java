package Model.Beans;
import java.util.ArrayList;
import java.util.List;
import Model.Beans.Sujet;



public class theme {
   
    private int id_theme;
    private String image;
    private String titre;
    public List<Sujet> sujet = new ArrayList<Sujet> ();

    public theme(int id_theme,  String titre,String image) {
        this.id_theme = id_theme;
        this.image = image;
        this.titre = titre;
    }   

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId_theme() {
       
        return this.id_theme;
    }


    public void setId_theme(final int value) {
        
        this.id_theme = value;
    }


    public String getTitre() {
     
        return this.titre;
    }

    public void setTitre(final String value) {
      
        this.titre = value;
    }
}
