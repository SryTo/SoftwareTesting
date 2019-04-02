package com.seleniumtest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium {
  private static WebDriver driver;
  private static final String baseUrl = "http://121.193.130.195:8800";
  private static boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  //private static String sid = "3016218137";
  //private static String spassword = "218137";
  //private static String sinformation = "https://github.com/SryTo/SoftwareTesting.git";
  public static String getInformation(String sid,String spassword) {
	  WebElement id = driver.findElement(By.name("id"));
	  WebElement password = driver.findElement(By.name("password"));
	  //WebElement login = driver.findElement(By.className("btn btn-primary"));   
	  id.click();
	  //driver.findElement(By.id("kw")).click();
	  id.clear();
	  id.sendKeys(sid);
	  password.click();
	  password.sendKeys(spassword);
	  WebElement login = driver.findElement(By.id("login_form"));
	  login.submit();
	  if(isAlertPresent()) {
	      System.out.println(closeAlertAndGetItsText());
	  }
	    /*if(isElementPresent(By.id("found-section"))) {
	    	System.out.println("µÇÂ½Ê§°Ü");
	    }
	    else {
	    	System.out.println("µÇÂ½³É¹¦");
	    }*/
	  String res = "";
	  if(isElementPresent(By.id("pricing-section"))){
	      res = driver.findElement(By.id("student-git")).getText();
	  }
	  return res;
  }
  public void logoutFromInformation() {
	  WebElement logout = driver.findElement(By.id("btn_logout"));
	  logout.click();
	  WebElement returnToPage = driver.findElement(By.id("btn_return"));
	  returnToPage.click();
  }
  /*public static void main(String args[]) {
	  System.out.println(getInformation(sid,spassword));
  }*/
  
  /*@Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "https://www.baidu.com/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }*/
  /*
  @Test
  public void testBaidu() throws Exception {
    driver.get(baseUrl + "/");
    WebElement id = driver.findElement(By.name("id"));
    WebElement password = driver.findElement(By.name("password"));
    //WebElement login = driver.findElement(By.className("btn btn-primary"));   
    id.click();
    //driver.findElement(By.id("kw")).click();
    id.clear();
    id.sendKeys(sid);
    password.click();
    password.sendKeys(spassword);
    WebElement login = driver.findElement(By.id("login_form"));
    login.submit();
    if(isAlertPresent()) {
    	System.out.println(closeAlertAndGetItsText());
    }
    /*if(isElementPresent(By.id("found-section"))) {
    	System.out.println("µÇÂ½Ê§°Ü");
    }
    else {
    	System.out.println("µÇÂ½³É¹¦");
    }*/
    /*
     * String result = "";
    if(isElementPresent(By.id("pricing-section"))){
    	result = driver.findElement(By.id("student-git")).getText();
    }
    driver.close();
    driver.quit();
    //System.out.println(result);
    assertEquals(sinformation, result);
    
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }
  */

  private static boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private static boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private static String closeAlertAndGetItsText() {
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

