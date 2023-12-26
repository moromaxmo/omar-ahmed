package com.swag;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SwagLabsLoginTest {
    WebDriver driver;
    String edgeDriverProperty = "webdriver.edge.driver";
    String edgeDriverPath = "src\\test\\java\\com\\swag\\driver\\msedgedriver.exe";// ms edge driver directory
    String swagLabsUrl = "https://www.saucedemo.com";
    String swagLabsHomeTabTitle = "Swag Labs";
    String swagLabsProductsUrl = "/inventory.html";
    String userNameId = "user-name";
    String passwdId = "password";
    String validUserName = "standard_user";
    String validPasswd = "secret_sauce";
    WebElement loginButton;
    String errorMessageXPath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";// XPath for the msg box

    // this method sets few things up for the test cases including
    // launching the browser, openning the site url, and
    @BeforeMethod
    public void openTab() {
        System.setProperty(edgeDriverProperty, edgeDriverPath);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(swagLabsUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        loginButton = driver.findElement(By.id("login-button"));
        Assert.assertEquals(driver.getTitle(), swagLabsHomeTabTitle);
    }

    // closing the browser after each test case is finished
    @AfterMethod
    public void closeTab() {
        driver.quit();
    }

    // regular happy scenario
    @Test
    public void testValidCredentials() {
        WebElement username = driver.findElement(By.id(userNameId));
        WebElement password = driver.findElement(By.id(passwdId));
        username.sendKeys(validUserName);
        password.sendKeys(validPasswd);
        loginButton.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = swagLabsUrl + swagLabsProductsUrl;
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    // A Method to decide whether the login has failed (true) or not (false)
    private Boolean loginFailureState() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            Boolean errorMessageExists = driver.findElement(By.xpath(errorMessageXPath)).isDisplayed();
            return errorMessageExists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // invalid username only
    @Test
    public void testInvalidUserName() {
        WebElement username = driver.findElement(By.id(userNameId));
        WebElement password = driver.findElement(By.id(passwdId));
        username.sendKeys("invalid");
        password.sendKeys(validPasswd);
        loginButton.click();
        Assert.assertTrue(loginFailureState());
    }

    // invalid password only
    @Test
    public void testInvalidPassword() {
        WebElement username = driver.findElement(By.id(userNameId));
        WebElement password = driver.findElement(By.id(passwdId));
        username.sendKeys(validUserName);
        password.sendKeys("invalid");
        loginButton.click();
        Assert.assertTrue(loginFailureState());
    }

    // invalid both username && password
    @Test
    public void testInvalidAllCredentials() {
        WebElement username = driver.findElement(By.id(userNameId));
        WebElement password = driver.findElement(By.id(passwdId));
        username.sendKeys("invalid");
        password.sendKeys("invalid");
        loginButton.click();
        Assert.assertTrue(loginFailureState());
    }

    // testing behavior when a user trying to login without entering any credentials
    @Test
    public void testBlankCredentials() {
        WebElement username = driver.findElement(By.id(userNameId));
        WebElement password = driver.findElement(By.id(passwdId));
        username.sendKeys("");
        password.sendKeys("");
        loginButton.click();
        Assert.assertTrue(loginFailureState());
    }

    // ensuring the password is not visible (i.e. the chars do not appear on screen)
    @Test
    public void testPasswordVisibilty() {
        WebElement password = driver.findElement(By.id(passwdId));
        String inputType = password.getAttribute("type");
        Assert.assertEquals(inputType, "password");
    }

    // trying to hit Enter key ont the device
    private void pressEnterKey() {
        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(500);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // trying to hit the Enter key to login instead of a mouse click
    @Test
    public void testEnterKey() {
        WebElement username = driver.findElement(By.id(userNameId));
        WebElement password = driver.findElement(By.id(passwdId));
        username.sendKeys("standard_user");
        password.sendKeys(validPasswd);
        pressEnterKey();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = swagLabsUrl + swagLabsProductsUrl;
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    // trying to login by navigating forward to the inventory page
    @Test
    public void testLoginByNavigatingForward() {
        WebElement username = driver.findElement(By.id(userNameId));
        WebElement password = driver.findElement(By.id(passwdId));
        username.sendKeys("standard_user");
        password.sendKeys(validPasswd);
        loginButton.click(); // normal login scenario
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = swagLabsUrl + swagLabsProductsUrl;
        Assert.assertEquals(expectedUrl, currentUrl); // ensuring that the normal login scenario has succeeded
        driver.navigate().back(); // moving back to the login page
        driver.navigate().forward(); // moving forward to the inventory page without logging in
        Assert.assertTrue(loginFailureState());
    }

    // testing direct navigation to the inventory url without passing through the login page
    @Test
    public void testUrlNavigationWithoutLoggingIn() {
        driver.get(swagLabsUrl + swagLabsProductsUrl);
        Assert.assertTrue(loginFailureState());
    }

}