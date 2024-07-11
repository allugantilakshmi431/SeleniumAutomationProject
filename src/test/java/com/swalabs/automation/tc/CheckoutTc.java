package com.swalabs.automation.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.swalabs.automation.CheckoutPage;
import com.swalabs.automation.Inventory;
import com.swalabs.automation.Login;

public class CheckoutTc {

	public static void main(String[] args) {
		verify_error();

	}
public static void verify_checkout() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	Login log=new Login(driver);
	log.login("standard_user","secret_sauce");
	System.out.println("login sucessfully");
	Inventory inv=new Inventory(driver);
	inv.addcart(Inventory.backpack);
	inv.addcart(Inventory.bikelight);
	inv.addcart(Inventory.tshirt);
	inv.open();
	inv.checkout();
	CheckoutPage page=new CheckoutPage(driver);
	page.fill_information();
}

public static void verify_error() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	Login log=new Login(driver);
	log.login("standard_user","secret_sauce");
	System.out.println("login sucessfully");
	Inventory inv=new Inventory(driver);
	inv.addcart(Inventory.backpack);
	
	inv.open();
	inv.checkout();
	CheckoutPage page=new CheckoutPage(driver);
	page.fill_information();
	page.Error_msg();
	page.contin();
String exceptederror= "Error: Last Name is required";
String actualerror=page.Error_msg();
if(exceptederror.equals(actualerror)) {
	System.out.println("tc is pass");
}else {
	System.out.println("tc is fail");
}


}










}
