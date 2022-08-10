package TestCasess;

import org.testng.Assert;
import org.testng.annotations.Test;

import LibararytestNG.AddAdminModule;
import LibararytestNG.AddEmployee;
import LibararytestNG.LoginPage;

public class addmodule extends Homepage {
	AddAdminModule aam = new AddAdminModule();
	AddEmployee ae = new AddEmployee();

	@Test
	public void addempmodule() throws InterruptedException {
		boolean res = aam.addadminmodule("Admin", "kranthi", "kumar", "kranthikumar2", "Qedge123!@#");
		Assert.assertTrue(res);
	}

	@Test(dependsOnMethods = { "addempmodule" })
	public void addemployee() throws InterruptedException {
		boolean res = ae.Addemployee("sri", "ram", "sriram2", "Qedge123!@#");
		Assert.assertTrue(res);
	}
}
