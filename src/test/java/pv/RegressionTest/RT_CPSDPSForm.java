package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_CPSDPSFormUtil;
import pv.library.ReadXlsData;
import pv.library.TestInitReference;

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
public class RT_CPSDPSForm extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression CPSDPSForm";
		
	@Test(description="Regression CPS & DPS Form Payment", dataProvider = "Data-Provider-Function")
	public void testRegressionCPSDPSForm(Class clzz, String[] input) {
		RT_CPSDPSFormUtil pvRegression = new RT_CPSDPSFormUtil(input);
		

		try {
			//check if can navigate to Postcode Activity Report screen when buypostcodereport button is clicked
			pvRegression.BuyPostcodeReport(0, 1, 2, 3, 4, 5, true);
			//Check if Get This Report button can navigate to Payment Summary Screen
			pvRegression.GetThisReport(6, 1, 7, 8, 4, true);
			//check if pay now button will navigate to Payment Checkout
			pvRegression.PayNow(9, 1, 10, 11, 4, 12, true);
			//check if cancel payment will navigate to payment cancel screen and messages are correct
			pvRegression.cancelPayment(13, 1, 14, 15, 4, 16, true);
			
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTCPSDPSForm.xls");
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
        ATUReports.indexPageDescription = "PROPERTY VALUE";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}
