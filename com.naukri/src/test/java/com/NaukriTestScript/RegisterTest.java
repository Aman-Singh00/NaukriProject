package com.NaukriTestScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericLibrary.Base_class;

public class RegisterTest extends Base_class {
	
	
	@DataProvider(name="RegisterData")
	public Object[][] RegisterData()
	{
		Random r = new Random();
		int num = r.nextInt(1000);
		Object[][] data = new Object[1][5];
		data[0][0]="Aman singh";
		data[0][1]="ramsingh"+num+"@gmail.com";
		data[0][2]="vivek@123";
		data[0][3]="9050489751";
		data[0][4]="Bangalore";
		return data;
	}
	
	
	@Test(dataProvider = "RegisterData")
	public void register(String name,String email,String pwd,String phoneno,String location) throws AWTException
	{
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		System.out.println(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(phoneno);
		driver.findElement(By.xpath("//div[@data-val='fresher']")).click();
		driver.findElement(By.xpath("//input[@id='currentCity']")).sendKeys(location);
		driver.findElement(By.xpath("//div[@id='sa-dd-scrollcurrentCity']/descendant::li[1]/span/span[3]")).click();
		driver.findElement(By.className("uploadResume")).click();
		//select path
		StringSelection path = new StringSelection("D:\\Resume\\Aman[Resume].pdf");
		//copy
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(path, null);
		//paste
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.className("submitbtn")).click();
		
		WebElement welcome = driver.findElement(By.xpath("//span[text()='Welcome, Aman singh']"));
		
		Assert.assertEquals(welcome.getText(), "Welcome, Aman singh");
		
		
		
		
	}

}
