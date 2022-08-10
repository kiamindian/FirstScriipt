package TestCasess;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LibararytestNG.LoginPage;
import utils.Apputils;

public class Homepage extends Apputils
{
	static LoginPage lp = new LoginPage();

@BeforeTest
public static void loginPage() throws InterruptedException {
	
	lp.login("Admin", "Qedge123!@#");
	boolean res = lp.isAdminModuleDisplayed();
	Assert.assertTrue(res);
}@AfterTest
public static void logout() throws InterruptedException 
{
	lp.logout();	
}
}
