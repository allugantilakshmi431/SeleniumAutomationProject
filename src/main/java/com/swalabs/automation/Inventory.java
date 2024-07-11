package com.swalabs.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Inventory {
WebDriver driver;
public static String backpack ="add-to-cart-sauce-labs-backpack";
public static String bikelight ="add-to-cart-sauce-labs-bike-light";

public static String tshirt ="add-to-cart-sauce-labs-bolt-t-shirt";
public static String remove="remove-sauce-labs-backpack";
public static String  filter="product_sort_container";
public static String price="inventory_item_price";
public Inventory(WebDriver driver) {
	this.driver = driver;
}
public void addcart(String locator) {
	WebElement cart=driver.findElement(By.id(locator));
	cart.click();
}
public boolean verify(String locator) {
	WebElement element=driver.findElement(By.id(locator));
	if(element.isDisplayed()) {
		return true;
	}else {
		return false;
	}
	
	}
	
public  void sort(String value) {
	WebElement filter=	driver.findElement(By.xpath("//option[contains(@value,'"+value+"')]"));
	filter.click();
	
	
}
public  boolean price_verify() {
	List <WebElement> priselist= driver.findElements(By.className(price));
	for(int i=0;i<priselist.size()-1;i++) {
		WebElement priceindexvalue_1=priselist.get(i);
		String Afterremovingdollar_1=priceindexvalue_1.getText().replace("$", "");
		float fvalue_1=Float.valueOf(Afterremovingdollar_1);
		System.out.println(fvalue_1);
	
	WebElement priceindexvalue_2=priselist.get(i+1);
	String Afterremovingdollar_2=priceindexvalue_2.getText().replace("$", "");
	float fvalue_2=Float.valueOf(Afterremovingdollar_2);
	System.out.println(fvalue_2);

if(fvalue_2<fvalue_1) {
	return false;
}
	}
	return true;
}


/*public void addcart() {
	WebElement cart=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	cart.click();
}
public void addcart2() {
	WebElement cart=driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
	cart.click();
	
}
public void addcart3() {
	WebElement cart=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
	cart.click();
	WebElement opencart=driver.findElement(By.xpath("//span[contains(@data-test,'shopping-cart-badge')]"));
	opencart.click();
}*/
public void open() {
WebElement opencart=driver.findElement(By.xpath("//span[contains(@data-test,'shopping-cart-badge')]"));
opencart.click();
}
public void checkout() {
	WebElement check=driver.findElement(By.id("checkout"));
	check.click();
}
}
