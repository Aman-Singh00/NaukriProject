package com.NaukriTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericLibrary.Base_class;

public class ApplyJobTest extends Base_class{
	
	
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
		driver.findElement(By.cssSelector("input[placeholder='Enter your active Email ID / Username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder='Enter your password']")).sendKeys(password);
		driver.findElement(By.className("loginButton")).click();
		Thread.sleep(2000);
		WebElement job = driver.findElement(By.xpath("//ul[@class='nI-gNb-menus']/descendant::a[1]/div[1]"));
		WebElement job_recuirter = driver.findElement(By.xpath("(//div[text()='Jobs from recruiters'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(job).click(job_recuirter).perform();
		
		
		
	}
	

}
