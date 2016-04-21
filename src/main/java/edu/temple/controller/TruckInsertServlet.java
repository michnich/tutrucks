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
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author michn_000
 */
@WebServlet(name = "TruckInsertServlet", urlPatterns = {"/truckInsert"})
public class TruckInsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Truck insertTruck = new Truck();
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
            session.save(insertTruck);
            session.flush();
            session.close();
        } catch (Exception e) {

        }
    }

}
