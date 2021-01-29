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
import model.Post;

/**
 *
 * @author kankkm
 */
public class search extends HttpServlet {

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
          
          String searchParam = request.getParameter("searchParam");
         
//        if(searchParam == null || searchParam.trim().length()==0) {
//            request.setAttribute("message","ไม่มีชื่อเรื่องนี้" );
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//            return ;
//        }
        String sql = "SELECT p FROM Post p WHERE p.title like :pn ";
        
        Query qry = em.createQuery(sql);
        
        qry.setParameter("pn", "%"+ searchParam+"%");
        /* In line Debugging */
        //System.out.println(qry);
        /*---------------------- */
         javax.persistence.Query query = em.createNamedQuery("Post.findAll");
               
               List<Post> rs = qry.getResultList();
        request.setAttribute("title", rs);
         if(rs.isEmpty()){
               request.setAttribute("message","ไม่มีเรื่องนี้" );
           request.getRequestDispatcher("/index.jsp").forward(request, response);
          }
        request.getRequestDispatcher("/showsearch.jsp").forward(request, response);

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
