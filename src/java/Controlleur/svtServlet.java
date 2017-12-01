/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Model.Beans.Sujet;
import Model.Beans.Utilisateur;
import Model.Beans.commentaire;
import Model.modCom;
import Model.modSujet;
import Model.modTheme;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class svtServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {

        int id=Integer.parseInt(request.getParameter("id"));
        modSujet modsjt = new modSujet();
        modTheme modthm = new modTheme();
        modCom   modcom = new modCom();  
        
                if(request.getParameter("action")!= null)
                    if (request.getParameter("action").equals("X")){
                        if (request.getParameter("conf")!=null)
                        { modsjt.Supprimer(id);
                            response.sendRedirect("svtServlet?id="+request.getParameter("idthm"));
                        }
                            response.sendRedirect("svtServlet?action=listerSujet&id="+id);
                            
                    }
                    else if(request.getParameter("action").equals("listerSujet")){
                        int idSujt=Integer.parseInt(request.getParameter("id"));
                        List<Sujet> Sjt = modsjt.afficherSujet(idSujt);
                        request.setAttribute("Sujet",Sjt.get(0));                        
                       List<commentaire> lstComm =new ArrayList<commentaire>();
                        lstComm=modcom.listeCommentaire(idSujt);
                        request.setAttribute("lstCommentaire", lstComm);                     
                        request.getRequestDispatcher("afficherSujet.jsp").forward(request,response);  
                    
                    }
                    else if(request.getParameter("action").equals("Envoyer")){
                        String titre = request.getParameter("titre");
                        String contenu = request.getParameter("contenu");
                        int idtheme =Integer.parseInt(request.getParameter("id"));
                        Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
                        Sujet sjt=new Sujet(titre,contenu,idtheme,user);               
                        modsjt.Ajouter(sjt); 
     
                    }                   
                    else if(request.getParameter("action").equals("Modifier")){
                        int idSujt=Integer.parseInt(request.getParameter("idsuj"));
                        List<Sujet> Sjt = modsjt.afficherSujet(idSujt);
                        request.setAttribute("Sujet",Sjt.get(0));
                        request.getRequestDispatcher("setSujet.jsp").forward(request,response);     
                    }
                    else if(request.getParameter("action").equals("Appliquer")){
                        int idS=Integer.parseInt(request.getParameter("ids"));
                        String titre = request.getParameter("titre");
                        String contenu = request.getParameter("contenu");
                        Sujet sjt=new Sujet(idS,titre,contenu);              
                        modsjt.Modifier(sjt); 
                   
                        
                    }    
            List<Sujet> lstS = new ArrayList<Sujet>();
            lstS= modsjt.lister(id);
            request.setAttribute("lstSjt",lstS);
        request.getRequestDispatcher("sujet.jsp").forward(request,response);   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(svtServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(svtServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
