package LibararytestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Apputils;

public class AddAdminModule extends Apputils 
{
public boolean addadminmodule(String userrole,String userfirstName,String userlastName,String userusername,String userpassword) throws InterruptedException 
{
	
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.linkText("Add Employee")).click();
	driver.findElement(By.id("firstName")).sendKeys(userfirstName);
	driver.findElement(By.id("lastName")).sendKeys(userlastName);
	driver.findElement(By.id("btnSave")).click();
	
	driver.findElement(By.linkText("Admin")).click();
	driver.findElement(By.id("btnAdd")).click();
	Thread.sleep(50);
	Select ur = new Select(driver.findElement(By.id("systemUser_userType")));
	ur.selectByVisibleText(userrole);
	String EmployeeName = userfirstName+" "+userlastName;
	driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(EmployeeName);
	driver.findElement(By.id("systemUser_userName")).sendKeys(userusername);
	driver.findElement(By.id("systemUser_password")).sendKeys(userpassword);
	driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(userpassword);
	Thread.sleep(500);
	driver.findElement(By.id("btnSave")).click();
	driver.findElement(By.id("searchSystemUser_userName")).sendKeys(userusername);
	driver.findElement(By.id("searchBtn")).click();
	WebElement table = driver.findElement(By.id("resultTable"));
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	for (int i = 1; i < rows.size(); i++) {
		List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
	for (int j = 0; j <col.size(); j++) {
		if(col.get(j).getText().equals(userusername)) 
		{
		
		}
	}
	}
	return true;
}
}
