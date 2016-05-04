/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.controller;

import javax.servlet.annotation.MultipartConfig;
import edu.temple.tutrucks.HibernateUtil;
import edu.temple.tutrucks.Permissions;
import edu.temple.tutrucks.Truck;
import edu.temple.tutrucks.User;
import edu.temple.tutrucks.Visualizable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.hibernate.Session;
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
/**
 *
 * @author nickdellosa
 */
public class UploadImageServlet extends HttpServlet {
    
    private static final String IMAGE_UPLOADS = "uploads/";
    
    static {
        File uploadsDir = new File(IMAGE_UPLOADS);
        if (!uploadsDir.exists()) {
            uploadsDir.mkdir();
        }
        File truckDir = new File(IMAGE_UPLOADS + "truck");
        if (!truckDir.exists()) {
            truckDir.mkdir();
        }
        File userDir = new File(IMAGE_UPLOADS + "user");
        if (!userDir.exists()) {
            userDir.mkdir();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Part imagePart = req.getPart("image");
            String entityType = req.getParameter("type");
            int id = -1;
            Visualizable v = null;
            switch (entityType) {
                case "truck":
                    User admin = (User)req.getSession().getAttribute("user");
                    if (admin.getPermissions() != Permissions.ADMIN) {
                        resp.sendError(HttpServletResponse.SC_FORBIDDEN, "You do not have permission to perform this action.");
                        return;
                    }
                    id = Integer.parseInt(req.getParameter("id"));
                    v = Truck.getTruckByID(id);
                    if (v == null) {
                        // error handling
                        return;
                    }
                    break;
                case "user":
                    User user = (User)req.getSession().getAttribute("user");
                    if (user == null) {
                        // error handling
                        return;
                    }
                    id = user.getId();
                    v = user;
                    break;
                default:
                    //error handling
                    return;
            }
            BufferedImage image;
            image= ImageIO.read(imagePart.getInputStream());
            String path=IMAGE_UPLOADS + entityType + "/" + id + ".png";
            File output;
            output= new File(path);
            boolean b=ImageIO.write(image, "PNG", output);
            
            if (v!=null){v.setAvatar(path);
            v.save();}
        } catch (IOException | ServletException | NumberFormatException | ClassCastException ex) {
        }
    }
    
}
