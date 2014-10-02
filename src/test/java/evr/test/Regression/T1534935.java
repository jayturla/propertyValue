package evr.test.Regression;

import java.io.IOException;
import java.util.ArrayList;

import myrp.library.ReadXlsData;
import myrp.library.TestInitReference;
import myrp.utilities.EvrProjectUtilAUS;
import myrp.utilities.EvrRegressionUtil;

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
public class T1534935 extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../evr-automation/conf/atu.properties");
	}
	
	String testCase = "T1534935";
		
	@Test(description="T1534935", dataProvider = "Data-Provider-Function")
	public void T1534935(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[2];
		int x = 1;
		
		try {
			EvrProjectUtilAUS au = new EvrProjectUtilAUS(input);
			EvrRegressionUtil reg = new EvrRegressionUtil(input);
			au.valexAuOrder(input[1]);
			au.gotoSalesEvidence();
			reg.clickContinue();
			
			if(reg.checkIfImInSubmissionPage()){
				log("PASSED: Yes im on Submission Page");
				ATUReports.add(input[6],"T1534935",input[7],input[8], true);
			}else{
				fail("Im not able to navigate in Submission Page");
				ATUReports.add(input[6],"T1534935",input[7],input[9], true);
			}
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
		ReadXlsData rxd = new ReadXlsData("../evr-automation/test-data/T1534935.xls");
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
        ATUReports.indexPageDescription = "EVR";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}
