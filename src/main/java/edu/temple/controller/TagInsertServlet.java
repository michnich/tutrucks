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
@WebServlet(name = "TagInsertServlet", urlPatterns = {"/TagInsertServlet"})
public class TagInsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Tag insertTag = new Tag();
            String tagName = req.getParameter("tagName");
            insertTag.setTagName(tagName);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(insertTag);
            session.flush();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }

}
