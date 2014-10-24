package myrp.Smoketest;

import java.io.IOException;
import java.util.ArrayList;

import myrp.library.ObjectReferenceSmoketest;
import myrp.library.ReadXlsData;
import myrp.library.TestInitReference;
import myrp.utilities.MYRPSmoketestUtil;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class RT07933 extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../myrp-automation/conf/atu.properties");
	}
	
	String testCase = "T1534935";
		
	@Test(description="T1534935", dataProvider = "Data-Provider-Function")
	public void T1534935(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[2];
		int x = 1;
		
		try {
			MYRPSmoketestUtil myrp = new MYRPSmoketestUtil(input);
			
			myrp.clickSignUp();
			myrp.firstnameSignUp();
			myrp.lastnameSignUp();
			myrp.emailSignUp();
			myrp.confirmEmailSignUp();
			myrp.passwordSignUp();
			myrp.confirmPasswordSignUp();
			myrp.securityQuestionSignUp();
			myrp.confirmsecurityQuestionSignUp();
			myrp.acceptTermsSignUp();
			
		}catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
	}

	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../myrp-automation/test-data/testdata.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "MYRP";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}
