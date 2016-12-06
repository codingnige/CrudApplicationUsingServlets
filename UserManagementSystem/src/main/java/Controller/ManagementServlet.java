/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SystemuserDao;
import Dao.SystemuserFacade;
import Model.Systemuser;
import Utils.UserException;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nigelantwi-boasiako
 */
public class ManagementServlet extends HttpServlet {

    @EJB
    private SystemuserFacade userFacade;

    private SystemuserDao userDao;

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
            throws ServletException, IOException, UserException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            //In order to user the basic version of the application
            //uncomment the code listed below and replace it with the
            //current by commenting it out.

            String ac = request.getParameter("ac");
            String id = request.getParameter("id");

            String title = request.getParameter("title");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String dob = request.getParameter("dob");

            String status = request.getParameter("status");
            System.out.println(status);

            userDao = new SystemuserDao();

            Systemuser user = new Systemuser();
            user.setTitle(title);
            user.setFirstname(name);
            user.setSurname(surname);
            user.setDateofbirth(dob);
            if (status != null) {
                System.out.println("status");
                user.setStatus("Activate");
            } else {
                user.setStatus("Not Activated");
            }

            if ("Create".equalsIgnoreCase(ac)) {
                userFacade.create(user);
                //userDao.addUser(user);
                //userDao.saveUser();

            } else if ("Delete".equalsIgnoreCase(ac)) {
                if (userFacade.find(id).getStatus().equalsIgnoreCase("Activate")) {
                    throw new UserException("User is active");
                } else {
                    int primary = Integer.parseInt(id);
                    userFacade.removeUser(primary);
                    //userDao.removeUser(user);
                    //userDao.saveUser();
                }
            } else if ("Edit".equalsIgnoreCase(ac)) {
                int primary = Integer.parseInt(id);
                userFacade.editUser(primary);

                //userDao.edit(user);
                //userDao.saveUser();
            }

            //When persisting to the xml file the information in the file is overwritten rather
            //than updated. This below method is a potential way of solving that issue.
           // HttpSession session = request.getSession();
           // List users = (List) session.getAttribute("listOfUsers");
           // if (users == null) {
           //     users = new ArrayList<>();
           //     session.setAttribute("listOfUsers", users);
           // }
           // for (Systemuser u : userDao.findUsers()) {
           //     users.add(u);
           // }

            request.setAttribute("user", user);
            request.setAttribute("userList", userFacade.findAll());
            //request.setAttribute("userList", userDao.findUsers());
            //request.setAttribute("userList", users);
            //System.out.println(users);

            request.getRequestDispatcher("main.jsp").forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (UserException ex) {
            Logger.getLogger(ManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (UserException ex) {
            Logger.getLogger(ManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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
