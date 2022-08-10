package LibararytestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.Apputils;

public class deleteModule extends Apputils
{

public boolean deleteEmployee(String DelEmployeeName) throws InterruptedException 
{
	driver.findElement(By.linkText("Admin")).click();
	driver.findElement(By.id("searchSystemUser_userName")).sendKeys(DelEmployeeName);
	driver.findElement(By.id("searchBtn")).click();
	
	WebElement table = driver.findElement(By.id("resultTable"));
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	for (int i = 1; i <rows.size(); i++) {
		List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
		for (int j = 0; j <col.size(); j++) {
			col.get(j).getText().equals(DelEmployeeName);
			col.get(0).click();
		}
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
	
	return true;
	}
	return false;
	
}
	
}
