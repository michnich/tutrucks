/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.controller;

import edu.temple.tutrucks.HibernateUtil;
import edu.temple.tutrucks.Tag;
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
@WebServlet(name = "TagDeleteServlet", urlPatterns = {"/TagDeleteServlet"})
public class TagDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String tagName = req.getParameter("name");
            Tag deleteTag = Tag.findTag(tagName);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Object persistentInstance = session.load(Tag.class, deleteTag.getId());
            session.beginTransaction();
            if (persistentInstance != null) {
                session.delete(persistentInstance);
            }
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }


}
