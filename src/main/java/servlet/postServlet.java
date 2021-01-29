/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.FormatStyle;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.List;
//import javafx.util.converter.LocalDateStringConverter;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PrePersist;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AddImage;
import model.Post;
import model.UserInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author BALL IT24
 */
@WebServlet(name = "postServlet", urlPatterns = {"/postServlet"})
public class postServlet extends HttpServlet {

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
     
    
    //String file = request.getParameter("file");
   
      
      String content = request.getParameter("content");
     // String content = "oiadjioajdoiajdiajsi";
        System.out.println("---1---");
       String title = request.getParameter("title");
        String author = (String) session.getAttribute("userr");
        UserInfo u = em.find(UserInfo.class, author);
        LocalDate today = LocalDate.now();
        
       System.out.println(u.getUsername());
        
//        if(content != null && title !=null) {

      // String sql2 = "SELECT COUNT(p) FROM Post p";
    String sql2 ="SELECT p.postId FROM Post p";
        Query q = em.createQuery(sql2);
     
        List <Post>ps =q.getResultList() ;
  
       
      
//        long countt = (long)q.getSingleResult();
//        int count = (int) countt+1;
        
        
             Post post = new Post();           
        int num =    ps.size();
        if(num==0){
           int countt = num+1 ;
            int count = countt;
            post.setPostId(count);
            session.setAttribute("num",count);
        }else{
             int countt = (int) q.getResultList().get(num-1);
        int count = countt+1;
            System.out.println(num);
            System.out.println(countt);
            System.out.println(count);
        post.setPostId(count);
        session.setAttribute("num",count);
        }
            
           post.setTitle(title);
            post.setContent(content);
            post.setCreateTime(java.sql.Date.valueOf(today));
            post.setUpdateTime(null);
            post.setTotallike(0);
            post.setTotalcomment(0);
            post.setUserinfousername(u);
            System.out.println("-----2-----");
            
            
   
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
            
            
    
     
 
            session.setAttribute("show", post);
            
            
//            post = em.find(Post.class, random_int);
//            session.setAttribute("post", post.getContent());
//            post = em.find(Post.class, random_int);
//            session.setAttribute("title", post.getTitle());
//            post = em.find(Post.class, random_int);
//            session.setAttribute("author", post.getUserinfousername().toString());
//            post = em.find(Post.class, random_int);
//            session.setAttribute("day", post.getCreateTime());
            
      

    request.getRequestDispatcher("/addimage.jsp").forward(request, response);

        }
//
// request.setAttribute("Message","กรุณากรอกข้อมูลให้ครบด้วยครับ");
//  request.getRequestDispatcher("/post.jsp").forward(request, response);
//    
//
//        
//        }


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
