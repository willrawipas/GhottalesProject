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
import model.FavoritelistPK;

import model.Post;
import model.UserInfo;

/**
 *
 * @author User
 */
public class favoritelistServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ghosttales_PU");
        EntityManager em = emf.createEntityManager();
        HttpSession session = request.getSession();

        String idpost = request.getParameter("id");
        String username = request.getParameter("username");
        int id = Integer.parseInt(idpost);
        Post post = em.find(Post.class, id);
        UserInfo us = em.find(UserInfo.class, username);
//        Favoritelist fa = em.find(Favoritelist.class,id);
        String sql= "SELECT f FROM Favoritelist f WHERE f.favoritelistPK.postpostid = :id AND f.favoritelistPK.userinfousername = :username" ; 
        Query qry =em.createQuery(sql);
        qry.setParameter("id", id);
         qry.setParameter("username", username);
        List  <Favoritelist> fa =   qry.getResultList();
        
        for (Favoritelist favoritelist : fa) {
            System.out.println(favoritelist);
        }
        
        
        
        if(!fa.isEmpty()){
            String sql2 =   "DELETE FROM Favoritelist f WHERE f.favoritelistPK.postpostid = :id AND f.favoritelistPK.userinfousername = :username";
            Query qry2 =em.createQuery(sql2);
            qry2.setParameter("id", id);
            qry2.setParameter("username", username);
            
            em.getTransaction().begin();
            qry2.executeUpdate();
            em.getTransaction().commit();
            
              request.getRequestDispatcher("/getpost").forward(request, response);
    } else{
                   
         Favoritelist fav = new Favoritelist(id, username);
        
        int min = 0;
        int max = 100000;
        int random_int = (int) (Math.random() * (max - min + 1) + min);
        
        fav.setPost(post);
        fav.setUserInfo(us);
        

        em.getTransaction().begin();
        em.persist(fav);
        em.getTransaction().commit();

        session.setAttribute("favorite", fav);


         
        request.getRequestDispatcher("/getpost").forward(request, response);
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
