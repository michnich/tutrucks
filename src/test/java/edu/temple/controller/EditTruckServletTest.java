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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author michn_000
 */
public class EditTruckServletTest extends ServletTest {
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
    public void testEditTruck() {
    }
}
