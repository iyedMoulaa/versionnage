/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Beans.Sujet;
import Model.Beans.commentaire;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zliaa
 */
public interface imp {
   public abstract void ajoutSujet(Sujet s);
   public abstract List ListerTheme();
   public abstract List afficherSujets(int id);
   public abstract void ajoutCommentaire(commentaire c);

    public abstract void suuprimerCommentaire(int id);
   public abstract void modifierCommentaire(commentaire c);
   public abstract List afficherCommentaire(int id );
}
