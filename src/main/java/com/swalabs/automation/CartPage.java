package com.swalabs.automation;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
public void capture_product(HashMap<String,String>excepteddata) {
	HashMap<String,String>actualdata=new HashMap();

	List<WebElement>cart=driver.findElements(By.className("cart_item"));
for(int i=0;i<cart.size()-1;i++) {
	WebElement currentelement=cart.get(0);
	WebElement productname=currentelement.findElement(By.className("inventory_item_name"));
	System.out.println(productname.getText());
	
	WebElement productprice=currentelement.findElement(By.className("inventory_item_price"));
	System.out.println(productprice.getText());
	actualdata.put(productname.getText().trim(), productprice.getText().trim());
	
	boolean isEqual=excepteddata.equals(actualdata);
	System.out.println(isEqual);
	
}

}

public void click_continue_shoping() {
	WebElement continueshoping =driver.findElement(By.id("continue-shopping"));
	continueshoping.click();





}
	
	
	
}
	
	
	
	
	
	
	

