package com.swalabs.automation.tc;

import org.testng.annotations.DataProvider;

public class BaseCls {
	
@DataProvider(name="testdata")
public Object[][] testdata(){
	return new Object[][] {
		{ "standard_user","secret_sauce"},
		{  "visual_user","secret_sauce "} 
			
			
	};
	
}
}
