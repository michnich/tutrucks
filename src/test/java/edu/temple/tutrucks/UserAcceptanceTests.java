/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.tutrucks;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author michn_000
 */
public class UserAcceptanceTests {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUserSignUpAndProfile() throws Exception {
        driver.get(baseUrl + "/index.jsp");
        driver.findElement(By.linkText("Login/Register")).click();
        driver.findElement(By.xpath("//li[@id='registrationItem']/div")).click();
        driver.findElement(By.id("email_r")).clear();
        driver.findElement(By.id("email_r")).sendKeys("tuf12067@temple.edu");
        driver.findElement(By.id("password_r")).clear();
        driver.findElement(By.id("password_r")).sendKeys("password");
        driver.findElement(By.id("registrationSubmit")).click();
        driver.get(baseUrl + "/index.jsp");
        driver.findElement(By.linkText("My Profile")).click();
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.id("displayname"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("tuf12067", driver.findElement(By.id("displayname")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testChangeDisplayName() throws Exception {
        driver.get(baseUrl + "/index.jsp");
        driver.findElement(By.linkText("My Profile")).click();
        driver.findElement(By.id("changedn")).click();
        driver.findElement(By.id("ndn")).clear();
        driver.findElement(By.id("ndn")).sendKeys("new name");
        driver.findElement(By.id("cdn")).click();
        try {
            assertEquals("new name", driver.findElement(By.id("displayname")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testUserLogOutLogIn() throws Exception {
        driver.get(baseUrl + "/index.jsp");
        driver.findElement(By.id("logout")).click();
        try {
            assertTrue(isElementPresent(By.linkText("Login/Register")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Login/Register")).click();
        driver.findElement(By.xpath("//li[@id='loginItem']/div")).click();
        driver.findElement(By.id("email_l")).clear();
        driver.findElement(By.id("email_l")).sendKeys("tuf12067@temple.edu");
        driver.findElement(By.cssSelector("#loginForm > div.col-lg-4 > input[name=\"password\"]")).clear();
        driver.findElement(By.cssSelector("#loginForm > div.col-lg-4 > input[name=\"password\"]")).sendKeys("password");
        driver.findElement(By.id("submitButton")).click();
        driver.get(baseUrl + "/index.jsp");
        try {
            assertEquals("Logout", driver.findElement(By.id("logout")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
