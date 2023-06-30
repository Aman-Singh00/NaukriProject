package com.NaukriTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericLibrary.Base_class;

public class LoginTest extends Base_class{
	
	
	@DataProvider(name="LoginData")
	public Object[][] loginData()
	{
		Object[][] data = new Object[1][2];
		data[0][0]="ak6838883@gmail.com";
		data[0][1]="Aman@123";
		return data;
	}

	
	@Test(dataProvider = "LoginData")
	public void login(String username,String password) throws InterruptedException
	{
		driver.findElement(By.id("login_Layer")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Enter your active Email ID / Username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder='Enter your password']")).sendKeys(password);
		driver.findElement(By.className("loginButton")).click();
		
	}

}
