/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Model.Beans.Sujet;
import Model.Beans.Utilisateur;
import Model.Beans.theme;
import Model.modSujet;
import Model.modTheme;
import Model.modUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zliaa
 */
public class svtTheme extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = 0;
        modTheme modthm = new modTheme();
        modSujet modsjt = new modSujet();
        modUser moduser= new modUser(); 
        List<theme> lstS = new ArrayList<theme>();
        List<Sujet> lstSj = new ArrayList<Sujet>();
        List<Utilisateur> lstuser= new ArrayList<Utilisateur>();
        int nbruseconnecter =0 ; 
       lstS= modthm.lister_theme();
       lstSj = modthm.afficherSujets();
       lstuser=moduser.alluser();
       nbruseconnecter=moduser.nbruserconn() ;
        
                                                
       request.setAttribute("nbruserconn",nbruseconnecter);
       request.setAttribute("lstTheme",lstS);
       request.setAttribute("lstSujet",lstSj);
       request.setAttribute("lstuser",lstuser);
       
       request.getRequestDispatcher("theme.jsp").forward(request,response); 
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
