package com.swalabs.automation.tc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swalabs.automation.Login;

public class LoginTc extends BaseCls{
	 WebDriver driver;
	/* @Parameters({"browser"})
	@BeforeMethod
	public  void intitbrowser(String browser) {
		/* if(browser.equals("chrome")) {
			 driver= new ChromeDriver();
		 }else {
			 driver=new EdgeDriver();
		 }
	
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	}*/
	@Test (dataProvider= "testdata")
	public  void login_Using_Valid(String un,String pswd) {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	Login log=new Login(driver);
	log.login(un,pswd);
	//verification
	String url_inventory=driver.getCurrentUrl();
	if(url_inventory.contains("inventory")) {
		System.out.println("tc1 is passed");
	}else {
		System.out.println("tc1 is failed");
	}
	driver.quit();
	}
	
	public  void login_Using_InValidname() {
		
		Login log=new Login(driver);
		log.login("standard","secret_sauce");
		String url=driver.getCurrentUrl();
		if(url.contains("inventory")) {
			System.out.println("tc is failed");
		}else {
			System.out.println("tc is passed");
		}
		}
	
	public  void login_Using_InValidpwd() {
		
		Login log=new Login(driver);
		log.login("standard_user","secret");
		String url=driver.getCurrentUrl();
		if(url.contains("inventory")) {
			System.out.println("tc is failed");
		}else {
			System.out.println("tc is passed");
		}
		}
	
	public  void login_Using_empty() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Login log=new Login(driver);
		log.login("","");
		WebElement error=driver.findElement(By.xpath("//h3[contains(@data-test,'error')]"));
		String excepted_error ="Epic sadface: Username is required";
		String actual_error=error.getText();
		if(excepted_error.equals(actual_error)) {
			System.out.println("tc is passed");
		}else {
			System.out.println("tc is fail");
		}
		System.out.println(actual_error);
		}
	public  void login_Using_InValidpwdname() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Login log=new Login(driver);
		log.login("standard","secret");
		WebElement  error1= driver.findElement(By.xpath("//h3[contains(@data-test,'error')]"));
		String expect_error="Epic sadface: Username and password do not match any user in this service";
		String Actual_error=error1.getText();
		if(expect_error.equals(Actual_error)) {
			System.out.println("tc is passes");
		}else {
			System.out.println("tc is failed");
		}
		System.out.println(Actual_error);
		}
}
