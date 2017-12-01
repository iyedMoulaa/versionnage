/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.dao;
import Model.Beans.Sujet;
import Model.Beans.commentaire;
import java.util.List;

/**
 *
 * @author Bosse
 */
public class modCom {
     private dao service = new dao();

    public modCom() {
    }
     
     


    
    public void AjouterCom(commentaire c)
    {
        this.service.ajoutCommentaire(c);
    }
    public List<commentaire> listeCommentaire (int id){
        return this.service.afficherCommentaire(id);
    }
    public void SupprimerCommentaire(int id)
    {
        this.service.suuprimerCommentaire(id);
    }
}
