package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class LoginPage{
    public LoginPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    WebDriver webDriver;

     By emailBy =  By.id("email");
     By passwordBy = By.id("password");
     By submitBy   = By.id("loginButton");
     By button = By.cssSelector(".btnSignIn");



    public void login(String email, String password){

        webDriver.findElement(button).click();
        webDriver.findElement(emailBy).sendKeys(email);
        webDriver.findElement(passwordBy).sendKeys(password);
        webDriver.findElement(submitBy).click();

    }
}

