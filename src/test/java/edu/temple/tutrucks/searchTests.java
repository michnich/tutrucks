/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.tutrucks;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class searchTests {
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
  public void testSearchBar() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("searchbar")).click();
    driver.findElement(By.id("searchbar")).clear();
    driver.findElement(By.id("searchbar")).sendKeys("chicken heaven");
    driver.findElement(By.cssSelector("input.search")).click();
    driver.findElement(By.cssSelector("a > h1.panel-title")).click();
    try {
      assertEquals("Chicken Heaven", driver.findElement(By.cssSelector("h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  
  @Test
  public void testAutocompleteSearch() throws Exception {
    driver.get(baseUrl + "/index.jsp");
    driver.findElement(By.id("ui-id-22")).click();
    driver.findElement(By.id("searchbar")).clear();
    driver.findElement(By.id("searchbar")).sendKeys("Chicken Heaven");
    driver.findElement(By.cssSelector("input.search")).click();
    driver.findElement(By.cssSelector("a > h1.panel-title")).click();
    try {
      assertEquals("Chicken Heaven", driver.findElement(By.cssSelector("h1")).getText());
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