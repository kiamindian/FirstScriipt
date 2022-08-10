package TestCasess;

import org.testng.Assert;
import org.testng.annotations.Test;

import LibararytestNG.LoginPage;
import utils.Apputils;

public class login extends Apputils 
{
	static LoginPage lp = new LoginPage();

	@Test
	public static void loginPage() throws InterruptedException {
		
		lp.login("Admin", "Qedge123!@#");
		boolean res = lp.isAdminModuleDisplayed();
		lp.logout();
		Assert.assertTrue(res);
	}

	@Test(dependsOnMethods = { "loginPage" })
	public static void EmpModuleDislpayed() throws InterruptedException {
		
		lp.login("lasyarani", "Qedge123!@#");
		boolean res = lp.isEmpModuleDisplayed();
		lp.logout();
		Assert.assertTrue(res);
	}

	@Test(dependsOnMethods = { "EmpModuleDislpayed" })
	public void isErrorMsgDisplayed() {
		
		lp.login("Admin", "Qedge1234!@#");
		boolean res = lp.isErrorMsgDisplayed();
		Assert.assertTrue(res);
	}
}
