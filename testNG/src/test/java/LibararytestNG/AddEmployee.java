package LibararytestNG;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import utils.Apputils;

public class AddEmployee extends Apputils
{
public boolean Addemployee(String firstName,String lastName,String username,String userpassword) throws InterruptedException 
{
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.linkText("Add Employee")).click();
	driver.findElement(By.id("firstName")).sendKeys(firstName);
	driver.findElement(By.id("lastName")).sendKeys(lastName);
	String employeeId = driver.findElement(By.id("employeeId")).getAttribute("value");

	WebElement checkbox = driver.findElement(By.id("chkLogin"));
	if (!checkbox.isSelected()) {
		checkbox.click();
	}
	driver.findElement(By.id("user_name")).sendKeys(username);
	driver.findElement(By.id("user_password")).sendKeys(userpassword);
	driver.findElement(By.id("re_password")).sendKeys(userpassword);
	driver.findElement(By.id("btnSave")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Employee List")).click();
	driver.findElement(By.id("empsearch_id")).sendKeys(employeeId);
	driver.findElement(By.id("searchBtn")).click();

	WebElement table = driver.findElement(By.id("resultTable"));
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	for (int i = 1; i <rows.size(); i++) {
		List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
		for (int j = 0; j <col.size(); j++) {
			if (col.get(j).getText().equals(employeeId)) 
			{
			return true;	
			}

		}
	}
	return false;
}
}
