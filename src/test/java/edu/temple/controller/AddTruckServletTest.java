/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.controller;

import edu.temple.tutrucks.Permissions;
import edu.temple.tutrucks.Tag;
import edu.temple.tutrucks.Truck;
import edu.temple.tutrucks.User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import javax.servlet.ServletException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author michn_000
 */
public class AddTruckServletTest extends ServletTest {
    private static User realUser;
    private static Truck testTruck;
    private static Tag testTag;
    @BeforeClass
    public static void setUpClass() {
        realUser = User.createUser("addreviewservlettest@test.com", "password", false, null, null, null);
        realUser.setPermissions(Permissions.ADMIN);
        testTag = Tag.retrieveTag("testing", true);
    }
    
    @AfterClass
    public static void tearDownClass() {
        realUser.delete();
        testTag = Tag.retrieveTag("testing", false);
        testTag.delete();
        testTruck.delete();
    }
    
    @Test
    public void test1AddTruck() throws ServletException, IOException {
        when(session.getAttribute("user")).thenReturn(realUser);
        when(request.getParameter("name")).thenReturn("test truck");
        when(request.getParameter("lat")).thenReturn("75.34");
        when(request.getParameter("lng")).thenReturn("72.64");
        when(request.getParameter("open")).thenReturn("08:00:00");
        when(request.getParameter("close")).thenReturn("20:00:00");
        when(request.getParameter("tags")).thenReturn("testing");      
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
            try (PrintWriter writer = new PrintWriter(baos, true)) {
                when(response.getWriter()).thenReturn(writer);
                new AddTruckServlet().doPost(request, response);
                writer.flush();
                assertEquals("Truck added", new String(baos.toByteArray()));
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            fail();
        }
        
        testTruck = Truck.getTruckByName("test truck");
        testTruck.loadTags();
        assertEquals("test truck", testTruck.getTruckName());
        assertEquals(75.34, testTruck.getLatitude(), 1e-15);
        assertEquals(72.64, testTruck.getLongitude(), 1e-15);
        assertEquals(Time.valueOf("08:00:00"), testTruck.getOpeningTime());
        assertEquals(Time.valueOf("20:00:00"), testTruck.getClosingTime());
        assertEquals(true, testTruck.getTags().contains(testTag));        
    }
    @Test
    public void test2DeleteTruck() throws ServletException, IOException {
        int truckId = testTruck.getId();
        System.out.println("truck id is " + truckId);
        when(session.getAttribute("user")).thenReturn(realUser);
        when(request.getParameter("truckId")).thenReturn(Integer.toString(truckId));
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
            try (PrintWriter writer = new PrintWriter(baos, true)) {
                System.out.println("got the writer");
                when(response.getWriter()).thenReturn(writer);
                new DeleteTruckServlet().doPost(request, response);
                System.out.println("called the thing");
                writer.flush();
                System.out.println("flushed the writer");
                assertEquals("Truck deleted", new String(baos.toByteArray()));
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            fail();
        }
        Truck deleted = Truck.getTruckByID(truckId);
        assertEquals(null, deleted);
        
    }
    
}
