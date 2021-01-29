/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
import model.CommentPK;
import model.Post;
import model.UserInfo;

/**
 *
 * @author User
 */
public class commentServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
         request.setCharacterEncoding("UTF-8");
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ghosttales_PU");
          EntityManager em = emf.createEntityManager();
          HttpSession session = request.getSession();
          
          
          String comment = request.getParameter("comment");
           int id =(int) session.getAttribute("postid");
        //   int id = Integer.parseInt(idpost);
          Post post = em.find(Post.class, id);
          String username = (String) session.getAttribute("userr");
          
          System.out.println(username);
          
          
          LocalDate today = LocalDate.now();
          
//          String sql = "SELECT COUNT(c) FROM Comment c WHERE c.commentPK.postpostid = :postpostid";
//          Query q = em.createQuery(sql);
//          
//           long countt = (long)q.getSingleResult();
//           int count1 = (int) countt;
           
          String sql2= "SELECT COUNT(c) FROM Comment c";
          Query q2 = em.createQuery(sql2);
          
           long countt2 = (long)q2.getSingleResult();
           int count2 = (int) countt2+1;
           System.out.println("--------------*------------------");
           System.out.println(username);
           
           CommentPK cmpk = new CommentPK();
            cmpk.setCommentId(count2);
           cmpk.setPostpostid(id);
      
         
           
           cmpk.setComment(comment);
           cmpk.setCreateTime(java.sql.Date.valueOf(today));
           Comment cm = new Comment();
          cm.setCommentPK(cmpk);
           
         
           System.out.println(comment);
          
           
                    if(username == null){
              String username2 = "Guest";
              cmpk.setUserinfousername(username2);
               UserInfo u = em.find(UserInfo.class, username2);
           cm.setUserInfo(u);
          }else{
                   cmpk.setUserinfousername(username);
                   UserInfo u = em.find(UserInfo.class, username);
                  cm.setUserInfo(u);
               }
           
           cm.setPost(post);
           
           
             em.getTransaction().begin();
            em.persist(cm);
            em.getTransaction().commit();
            
           
            session.setAttribute("comment", cm);
            
            request.getRequestDispatcher("/homepage").forward(request, response);
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
