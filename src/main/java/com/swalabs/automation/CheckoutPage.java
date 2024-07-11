package com.swalabs.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
WebDriver driver;

public CheckoutPage(WebDriver driver) {
	this.driver = driver;
}
public void fill_information() {
	WebElement firstname=driver.findElement(By.id("first-name"));
	firstname.sendKeys("chinni");
	WebElement lastname=driver.findElement(By.id("last-name"));
	lastname.sendKeys("reddy");
	WebElement pincode=driver.findElement(By.id("postal-code"));
	pincode.sendKeys("515671");
	
	
	}
public void contin() {
WebElement contn=driver.findElement(By.id("continue"));
contn.click();
}
public String Error_msg() {
	WebElement err=driver.findElement(By.xpath("//h3[@data-test='error']"));
	String actualerror=err.getText().trim();
	System.out.println(actualerror);
	return actualerror;
	
}








}







