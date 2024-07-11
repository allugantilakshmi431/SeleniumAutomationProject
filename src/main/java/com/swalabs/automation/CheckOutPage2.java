package com.swalabs.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CheckOutPage2 {
WebDriver driver;
 public CheckOutPage2(WebDriver driver) {
	this.driver = driver;
}
public void price_of_the_products() {
	List<WebElement> pricelist=driver.findElements(By.className("inventory_item_price"));
	float sum=0;
	for(int i=0;i<pricelist.size();i++) {
	WebElement list=pricelist.get(i);
	//	System.out.println(list.getText());
		String price=list.getText();
		String afterremoving$=price.replace("$", "");
		float pricef=Float.valueOf(afterremoving$);
	//	System.out.println(afterremoving$);
		System.out.println(pricef);
		sum=sum+pricef;
	}
	System.out.println(sum);
    WebElement total=driver.findElement(By.className("summary_subtotal_label"));
	String totalitems=total.getText();
	String afterremoving$totalitems=totalitems.replace("item total : $","" );
	float totalitemsfloat= Float.valueOf(afterremoving$totalitems);
	
	System.out.println(" subtotalamt"+ afterremoving$totalitems);
	/*if(sum==totalitemsfloat) {
		System.out.println("item total sum matched");
	}else{
		System.out.println("item total sum not matched");
	}
 float amt;
	WebElement Tax=driver.findElement(By.className("summary_tax_label"));
	String taxitem=Tax.getText();
	String Afterremoving$intax=taxitem.replace("$", "");
	float taxf=Float.valueOf(Afterremoving$intax);
	amt=taxf+totalitemsfloat;
System.out.println(amt);
	WebElement totalamt =driver.findElement(By.className("summary_total_label"));
	String totalstr=total.getText();
	String total$removing =totalstr.replace("$", "");
	float totalfloat=Float.valueOf(total$removing);
    if(amt==totalfloat) {
	System.out.println("final amt matched");
     }else {
	System.out.println("final amt not matched");*/
}
}



