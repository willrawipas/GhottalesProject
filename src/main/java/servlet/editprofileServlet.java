/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserInfo;

/**
 *
 * @author kankkm
 */
public class editprofileServlet extends HttpServlet {

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
         HttpSession session=request.getSession();
         
                  
          String username =  (String) session.getAttribute("userr");
           UserInfo user=em.find(UserInfo.class,username );
           
            String newpassword = request.getParameter("newpassword");
    String password = request.getParameter("password");
    String fname = request.getParameter("firstname");
    String lname = request.getParameter("lastname"); 
        
     //UserInfo user = new UserInfo();
      if(user.getPassword().equals(password)){
 user.setUsername(username);
  user.setPassword(newpassword);
  user.setFirstName(fname);
  user.setLastName(lname);
  
String EDIT="UPDATE  UserInfo u SET u.username=' " + username + " ' where u.username=' " +user.getUsername() + " ' " ;
String EDIT2="UPDATE  UserInfo u SET u.password=' " + password + " ' where u.username=' " +user.getUsername() + " ' " ;
String EDIT3="UPDATE  UserInfo u SET u.firstName=' " + fname + " ' where u.username=' " +user.getUsername() + " ' " ;
String EDIT4="UPDATE  UserInfo u SET u.lastName=' " + lname + " ' where u.username=' " +user.getUsername() + " ' " ;

        Query q =em.createQuery(EDIT);
         Query q2 =em.createQuery(EDIT2);
          Query q3 =em.createQuery(EDIT3);
           Query q4 =em.createQuery(EDIT4);
        em.getTransaction().begin();
      
        q.executeUpdate();  
        q2.executeUpdate(); 
        q3.executeUpdate(); 
        q4.executeUpdate(); 
        em.getTransaction().commit();
                System.out.println(user.getUsername());
                System.out.println(fname);
           request.getRequestDispatcher("/logout").forward(request, response);  
              }else {
            request.setAttribute("Message", "รหัสปัจจุบันของคุณไม่ถูกต้อง");
            request.getRequestDispatcher("editprofile.jsp").forward(request, response);
  //em.persist(user);
  //em.getTransaction().commit();
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
