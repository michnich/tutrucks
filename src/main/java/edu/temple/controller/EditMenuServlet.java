/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.controller;

import edu.temple.tutrucks.HibernateUtil;
import edu.temple.tutrucks.Menu;
import edu.temple.tutrucks.Truck;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author michn_000
 */
@WebServlet(name = "EditMenuServlet", urlPatterns = {"/EditMenuServlet"})
public class EditMenuServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Menu> updatedMenu = Truck.getTruckByName(req.getParameter("truckName")).getMenus();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(updatedMenu);
            
            session.flush();
            session.close();
            session.close();

        } catch (Exception e) {

        }
    }

}
