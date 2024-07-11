package com.swalabs.automation.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.swalabs.automation.CheckOutPage2;
import com.swalabs.automation.CheckoutPage;
import com.swalabs.automation.Inventory;
import com.swalabs.automation.Login;

public class CheckOutPage2Tc {

	public static void main(String[] args) {
		verify_pricelist_Tc();

	}
	public static void verify_pricelist_Tc() {
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
	page.contin();
	CheckOutPage2 chekpag=new CheckOutPage2(driver);
	chekpag.price_of_the_products();
	
}
	
	
}
