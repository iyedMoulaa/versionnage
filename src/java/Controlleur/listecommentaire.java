/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

 
import Model.Beans.commentaire;
import Model.modCom;
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
public class listecommentaire extends HttpServlet {

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
        modCom modcom = new modCom();
        int idSujt=Integer.parseInt(request.getParameter("id"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        List<commentaire> lstComm =new ArrayList<commentaire>();
        lstComm=modcom.listeCommentaire(idSujt);
            for (int i=0 ; i<lstComm.size();i++){             
                out.println("<div class='container'><div class='row'>");
                out.println("<div id='main-area' class='col-sm-12'><div id='content' class='column'><a id='main-content'></a>");
                out.println("<div class='region region-content'><div id='block-system-main' class='block block-system'>");
                out.println("<div class='block-inner'><div class='content'><div id='forum-topic-header' class='forum-topic-header clearfix'>");
                out.println("<a id='forum-topic-top'></a></div><div id='post-69' class='forum-post clearfix en posted-by-1'>");
                out.println("<div class='forum-post-info clearfix'><div class='forum-posted-on'>");
                out.println(lstComm.get(i).getDate_commentaire());
                out.println("</div><span class='forum-post-number'><a href='/forum-plus/en/forum/learn-d7-coding-or-d8' class='active'></a></span>");
                out.println("</div><div class='forum-post-wrapper'><div class='forum-post-panel-sub'>");
                out.println("<div class='author-pane'><div class='author-pane-inner'>");
                out.println("<div class='author-pane-section author-pane-general'><div class='status-picture'>");
                out.println("<div class='picture'>");
                out.println("<img src='"+lstComm.get(i).getUser().getImage()+"' alt='image_user' title='dmin&#039;s picture' /></div></div> ");
                out.println("<div class='author-pane-line author-name'></br><span class='username'>");
                out.println(lstComm.get(i).getUser().getUsername());
                out.println("</span></div><div class='author-pane-line author-joined'>");
                out.println("<span class='author-pane-label'>Rejoint:</span> ");
                out.println(lstComm.get(i).getUser().getDateInscri());
                out.println("<br>");
                out.println("<span>Comme : "+lstComm.get(i).getUser().getType()+"</span>");
                out.println("</div></div><div class='author-pane-section author-pane-contact'></div>");
                out.println("<div class='author-pane-section author-pane-admin'></div></div></div>");
                out.println("</div>");
                out.println("<div class='forum-post-panel-main clearfix'>");
                out.println("<div class='forum-post-title'></div>  ");
                out.println("<div class='field field-name-body field-type-text-with-summary field-label-hidden'>");
                out.println("<div class='field-items'><div class='field-item even'>");
                out.println("<p>"+lstComm.get(i).getText_commentaire()+"</p></div></div></div>");
                out.println("<div class='field field-name-field-vote field-type-fivestar field-label-hidden'>");
                out.println("<div class='field-items'><div class='field-item even'>");
                out.println("<form class='fivestar-widget' action='svtCommentaire' method='post' id='fivestar-custom-widget' accept-charset='UTF-8'>");
                out.println("<div><div  class='clearfix  fivestar-combo-text fivestar-smart-stars fivestar-average-stars fivestar-form-item fivestar-basic'>");
                out.println("<div class='form-item form-type-fivestar form-item-vote'>");
                out.println("<div class='fivestar-static-form-item'><div class='form-item form-type-item'></div>");
                out.println("</div></div></div></div></form></div></div></div></div></div></div></div></div></div></div>");
                out.println("</div></div></div></div></section>");
     
            }
        

        }
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
