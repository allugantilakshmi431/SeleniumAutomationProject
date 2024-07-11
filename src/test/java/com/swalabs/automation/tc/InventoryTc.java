package com.swalabs.automation.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.swalabs.automation.Inventory;
import com.swalabs.automation.Login;

public class InventoryTc {
	public static void main (String[]args) {
		Tc();
		
	}
	
public static void Tc_Add_To_Cart() {
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
	 boolean isvisible=inv.verify(Inventory.remove);
	 if(isvisible) {
		 System.out.println("tc is passed");
	 }else {
		 System.out.println("tc is failed");
	 }
	inv.open();
	
}
public static void Tc() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	Login log=new Login(driver);
	log.login("standard_user","secret_sauce");
	System.out.println("login sucessfully");
	Inventory inv=new Inventory(driver);
	inv.sort("lohi");
	//inv.price_verify();
	boolean issorted=inv.price_verify();
	if(issorted) {
		System.out.println("tc is passed");
	}else {
		System.out.println("tc is failed");
	}
}
}









