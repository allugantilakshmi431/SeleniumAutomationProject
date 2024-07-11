package com.swalabs.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	WebDriver driver;
	
public Login(WebDriver driver) {
		
		this.driver = driver;
	}

public  void login(String name,String password) {
	WebElement username=	driver.findElement(By.id("user-name"));
	WebElement pwd=	driver.findElement(By.name("password"));
	WebElement login=	driver.findElement(By.id("login-button"));
	username.sendKeys(name);
	pwd.sendKeys(password);
	login.click();
}

}
