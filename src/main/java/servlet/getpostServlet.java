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
import model.Comment;
import model.Favoritelist;
import model.Post;

import model.Favoritelist;

import model.Post;

/**
 *
 * @author User
 */
public class getpostServlet extends HttpServlet {

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
        
    HttpSession session = request.getSession();

      String hrefname = request.getParameter("id");
      String username = (String) session.getAttribute("userr");
        int id =Integer.parseInt(hrefname);
         response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ghosttales_PU");
        EntityManager em = emf.createEntityManager();
         javax.persistence.Query query = em.createNamedQuery("Post.findByPostId");
         query.setParameter("postId", id);
         Post ps =  (Post) query.getSingleResult();
         
          
        session.setAttribute("post", ps);
        session.setAttribute("postid", ps.getPostId());
         System.out.println(ps.getContent());
         
         String sql= "SELECT f FROM Favoritelist f WHERE f.favoritelistPK.postpostid = :id AND f.favoritelistPK.userinfousername = :username" ; 
        Query qry =em.createQuery(sql);
        qry.setParameter("id", id);
         qry.setParameter("username", username);
        List  <Favoritelist> fa =   qry.getResultList();
        

        
        if(!fa.isEmpty()){
               session.setAttribute("follow", true);
        }else{
             session.setAttribute("follow", false);
        }
         
         
 String sql2 = "SELECT COUNT(f) FROM Favoritelist f WHERE   f.favoritelistPK.postpostid = :id  ";
        Query q = em.createQuery(sql2);
       q.setParameter("id", id);
      //q.setParameter("username", username);
        long countt = (long) q.getSingleResult();
        
        
        int count = (int) countt;
        Post post = em.find(Post.class, id);
         post.setTotallike(count);
         
         
          String update = "UPDATE  Post p SET p.totallike=" + count + " where p.postId="+ id +"";
            
          Query q2 = em.createQuery(update);
          
            em.getTransaction().begin();
            //em.persist(post);
            q2.executeUpdate();
            em.getTransaction().commit();
            
            
         String sql3 = "SELECT c FROM Comment c WHERE c.commentPK.postpostid = :id ORDER BY c.commentPK.commentId DESC " ; 
        Query qry3 =em.createQuery(sql3);
        qry3.setParameter("id",id);
        List  <Comment> cm =   qry3.getResultList();
        
        String sql4 = "SELECT COUNT(c) FROM Comment c WHERE c.commentPK.postpostid = :id  " ; 
        Query qry4 =em.createQuery(sql4);
        qry4.setParameter("id",id);
        long numm =  (long) qry4.getSingleResult();
        
        int num = (int) numm;
        
        
//         String sql5 = "SELECT c FROM Comment c WHERE c.commentPK.postpostid = :id ";
//        Query q5 = em.createQuery(sql5);
//       q5.setParameter("id", id);
//      //q.setParameter("username", username);
//        long countz = (long) q5.getSingleResult();
//        
//        
//        int countc = (int) countz;
       
         post.setTotalcomment(num);
         
         
          String update2 = "UPDATE  Post p SET p.totalcomment=" + num + " where p.postId="+ id +"";
            
          Query q6 = em.createQuery(update2);
          
            em.getTransaction().begin();
            //em.persist(post);
            q6.executeUpdate();
            em.getTransaction().commit();
        
        
        
        
        
        
        
        
        
        
        
        request.setAttribute("num", num);
        request.setAttribute("count",count);
         
         session.setAttribute("cm",cm);
         
         
         
         
         
         
         
         request.getRequestDispatcher("/dopost.jsp").forward(request, response);
        
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
