package com.swalabs.automation.tc;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.swalabs.automation.CartPage;
import com.swalabs.automation.Inventory;
import com.swalabs.automation.Login;

public class OpenCartTest {

	public static void main(String[] args) {
		verify_continue_shoping();

	}
public static void cart_tc() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	Login log=new Login(driver);
	log.login("standard_user","secret_sauce");
	System.out.println("login sucessfully");
	Inventory inv=new Inventory(driver);
	HashMap<String,String>excepted_testdata=new HashMap();
	excepted_testdata.put("Sauce Labs Backpack","$29.99");
	excepted_testdata.put("Sauce Labs Bike Light","$9.99");
	excepted_testdata.put("Sauce Labs Bolt T-Shirt","$15.99");
	excepted_testdata.put("Sauce Labs Fleece Jacket","$49.99");
	inv.addcart(Inventory.backpack);
	inv.addcart(Inventory.bikelight);
	inv.addcart(Inventory.tshirt);
	 boolean isvisible=inv.verify(Inventory.remove);
	 if(isvisible) {
		 System.out.println("tc is passed");
	 }else {
		 System.out.println("tc is failed");
	 }
	inv.open();
	CartPage pag=new CartPage(driver);
	pag.capture_product(excepted_testdata);
	}
public static void verify_continue_shoping() {
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
	CartPage pag=new CartPage(driver);
	pag.click_continue_shoping();
	String expected_url="https://www.saucedemo.com/inventory.html";
String actual_inventry_url =driver.getCurrentUrl();
System.out.println(actual_inventry_url);
if(expected_url.equals(actual_inventry_url)) {
	System.out.println("verify_continue_shoping is passed");
}else {
	System.out.println("verify_continue_shoping is failed");

}
driver.quit();













}






















	
}

