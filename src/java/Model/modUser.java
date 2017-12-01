/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.dao;
import Model.Beans.Utilisateur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public class modUser {
    
    private dao service = new dao();
    
    public Utilisateur lister(String username,String password)
    {
        return this.service.afficherUser(username, password);
    }
    public List<Utilisateur>  alluser(){
        return this.service.ALLuser();
    }
    
    public int  nbruserconn(){
        return this.service.nbrConncter();
    }
 
    public void userconnecter(Utilisateur user){
        this.service.userconnecter(user);
    }
    public void userdeconnecter(Utilisateur user){
        this.service.userdeconnecter(user);
    }
}
