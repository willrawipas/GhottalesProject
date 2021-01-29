/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Favoritelist;
import model.Post;
import model.UserInfo;

/**
 *
 * @author User
 */
public class getfavoritelist extends HttpServlet {

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
 //     HttpSession session = request.getSession();
         String username = request.getParameter("name");
        
//           String idz = request.getParameter("id");
//           int id =Integer.parseInt(idz);
       
         response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ghosttales_PU");
        EntityManager em = emf.createEntityManager();
         
        
     
         
       
         
         
         String sql= "SELECT f FROM Favoritelist f WHERE f.favoritelistPK.userinfousername = :username" ; 
        Query qry =em.createQuery(sql);
        
         qry.setParameter("username", username);
       List<Favoritelist> fa =  qry.getResultList();
         request.setAttribute("myfavorite",fa);
                      
         for (Favoritelist f : fa){
               System.out.println(f.getPost().getTitle());
          
              }
         
         
         
        String sql2 = "SELECT COUNT(f) FROM Favoritelist f WHERE   f.favoritelistPK.userinfousername = :username  ";
        Query q = em.createQuery(sql2);
     //   q.setParameter("id", id);
      q.setParameter("username", username);
        long count = (long)q.getSingleResult();
        
        
        
        
        request.setAttribute("count",count);
        
         
    
         
         request.getRequestDispatcher("/favoritelist.jsp").forward(request, response);
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
