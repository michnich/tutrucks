/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.controller;

import edu.temple.tutrucks.HibernateUtil;
import edu.temple.tutrucks.Tag;
import edu.temple.tutrucks.Truck;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author michn_000
 */
public class TruckEditServlet extends HttpServlet {

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
            PrintWriter writer = resp.getWriter();
            writer.print("<html>");
            Enumeration params = req.getParameterNames();
            while (params.hasMoreElements()) {
                String paramName = (String) params.nextElement();
                writer.print("<h2>Parameter Name - " + paramName + ", Value - " + req.getParameter(paramName) +"</h2>");
            }
            
            Truck insertTruck = Truck.getTruckByName(req.getParameter("edittedTruck"));
            String truckName = req.getParameter("truckName");
            insertTruck.setTruckName(truckName);
            double lat = Double.parseDouble(req.getParameter("latitude"));
            insertTruck.setLatitude(lat);
            double lng = Double.parseDouble(req.getParameter("longitude"));
            insertTruck.setLongitude(lng);
            Time openingTime = Time.valueOf(req.getParameter("openTime"));
            insertTruck.setOpeningTime(openingTime);
            Time closingTime = Time.valueOf(req.getParameter("closeTime"));
            insertTruck.setClosingTime(closingTime);
            String tagString = req.getParameter("tags");
            List<String> tagList = Arrays.asList(tagString.split("'"));
            Set<Tag> tagSet = new TreeSet();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(insertTruck);
            writer.print("<h2>updated</h2>");
            session.flush();
            session.close();
            session.close();

        } catch (Exception e) {

        }
    }

}
