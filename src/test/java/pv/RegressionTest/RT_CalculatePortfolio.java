package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_CalculatePortfolioUtil;
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
public class RT_CalculatePortfolio extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression Portfolio";
		
	@Test(description="Regression Portfolio Calculate", dataProvider = "Data-Provider-Function")
	public void testCalculatePortfolio(Class clzz, String[] input) {
		RT_CalculatePortfolioUtil pvRegression = new RT_CalculatePortfolioUtil(input);
		
		try {
			//Check if portfolio summary is available
			pvRegression.portfolioSummary(0, 1, 2, 3, 4, 5, 6, 7, true);
			//check if calcualte equity modal is presented and allowed to enter current loan balance
			pvRegression.CalculateModal(8, 1, 9, 10, 4, true);
			//check if total equity will be calculated
			pvRegression.enterLoan(11, 1, 12, 13, 4, 14, true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTCalculatePortfolio.xls");
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
