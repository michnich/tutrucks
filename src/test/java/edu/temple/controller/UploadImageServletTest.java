/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.controller;

import edu.temple.tutrucks.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author nickdellosa
 */
public class UploadImageServletTest {
    
    private static final String TEST_IMAGE = UploadImageServletTest.class.getClassLoader().getResource("TestImage.jpg").getFile();
    private static final String TEST_IMAGE2 = UploadImageServletTest.class.getClassLoader().getResource("TestImage2.jpg").getFile();
    
    public UploadImageServletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDoPostTruck() throws FileNotFoundException, IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        Part imagePart = mock(Part.class);
        when(request.getPart("image")).thenReturn(imagePart);
        when(request.getParameter("type")).thenReturn("truck");
        when(request.getParameter("id")).thenReturn("7");
        UploadImageServlet servlet = new UploadImageServlet();
        File testFile = new File(TEST_IMAGE);
        File realFile = new File("uploads/truck/7.png");
        System.out.println(realFile.getAbsolutePath());
        if (realFile.exists()) {
            realFile.delete();
        }
        realFile.createNewFile();
        try (FileInputStream fileStream = new FileInputStream(testFile)) {
            when(imagePart.getInputStream()).thenReturn(fileStream);
            servlet.doPost(request, response);
        }
        assertTrue(realFile.exists());
    }
    
    @Test
    public void testDoPostUser() throws FileNotFoundException, IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        User fakeUser = new User();
        fakeUser.setId(0);
        fakeUser.setAvatar("null");
        Part imagePart = mock(Part.class);
        when(request.getPart("image")).thenReturn(imagePart);
        when(request.getParameter("type")).thenReturn("user");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(fakeUser);
        UploadImageServlet servlet = new UploadImageServlet();
        File testFile = new File(TEST_IMAGE2);
        File realFile = new File("uploads/user/0.png");
        System.out.println(realFile.getAbsolutePath());
        if (realFile.exists()) {
            realFile.delete();
        }
        realFile.createNewFile();
        try (FileInputStream fileStream = new FileInputStream(testFile)) {
            when(imagePart.getInputStream()).thenReturn(fileStream);
            servlet.doPost(request, response);
        }
        assertTrue(realFile.exists());
        assertTrue(!fakeUser.getAvatar().equals("null"));
    }
}