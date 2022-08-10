package LibararytestNG;


import org.openqa.selenium.By;

import utils.Apputils;

public class LoginPage extends Apputils 
{
	public void login(String username,String password) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
	}
	public boolean isAdminModuleDisplayed() 
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed()) 
		{
			return true;
		}else {
		return false;
		}
	}
	public boolean isEmpModuleDisplayed()
	{
		try 
		{
			driver.findElement(By.linkText("Admin"));
			return false;
		} catch (Exception e) 
		{
			return true;
		}		
	}	
	public boolean isErrorMsgDisplayed() 
	{
		if(driver.findElement(By.id("spanMessage")).isDisplayed())
		{
			return true;
		}
		return false;
	}
	public boolean logout() throws InterruptedException 
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		if (driver.findElement(By.id("btnLogin")).isDisplayed())
		{
		return true;	
		}
		return false;
	}
}

