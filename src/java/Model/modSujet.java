/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.dao;
import Model.Beans.Sujet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public class modSujet {
    
    private dao service = new dao();

    public modSujet() {
    }
    public void Modifier(Sujet sjt) {
    
        this.service.modifierSujet(sjt);
    }
    
    public void Ajouter(Sujet sjt)
    {
        this.service.ajoutSujet(sjt);
    }
    
    public void Supprimer(int id)
    {
        this.service.supprimerSujet(id);
    }
    
    public List lister(int id) throws SQLException
    {
        return this.service.afficherSujets(id);
    }
    
        
    public List afficherSujet(int id) 
    {
        return this.service.afficherSujet(id);
    }
    
    public List Rechercher(String crit) 
    {   
        return this.service.rechercherSujet(crit);
    }
}
