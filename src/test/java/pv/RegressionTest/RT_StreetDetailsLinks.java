package pv.RegressionTest;

import java.io.IOException;

import pv.RegressionUtil.RT_StreetDetailsLinksUtil;
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
public class RT_StreetDetailsLinks extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	String testCase = "Regression Street Details Links";
		
	@Test(description="Regression Street Details Links", dataProvider = "Data-Provider-Function")
	public void testRegressionStreetDetailsLinks(Class clzz, String[] input) {
		RT_StreetDetailsLinksUtil pvRegression = new RT_StreetDetailsLinksUtil(input);
		

		try {
			//verify if breadcrumbs are clickable and will navigate to relevant page
			pvRegression.breadcrumbsNav(0, 1, 2, 3, 4, 5, 18, 19, true);
			//switch between property types
			pvRegression.switchPropertyType(6, 1, 7, 8, 4, true);
			//check if upgrade to premium is clickable
			pvRegression.upgradePremiumNav(9, 1, 10, 11, 4, true);
			//check if can buy postcode report when available
			pvRegression.postcodeReportNav(12, 1, 13, 14, 4, true);
			//check if can add to watchlist
			pvRegression.btnAddToWatchlist(15, 1, 16, 17, 4, true);
			//check if can share the suburb profile to social 
			pvRegression.btnShare(20, 1, 21, 22, 4, true);
			//check if can click links on left nav bar to anchor specific page
			pvRegression.leftNavBar(23, 1, 24, 25, 4, true);
			//view toolip details
			pvRegression.tooltipView(26, 1, 27, 28, 4, true);
			//check if learn more link will prompt the street composition sample modal
			pvRegression.learnMore(29, 1, 30, 31, 4, true);
			//verify if can switch between for sale, recently sold and for rent on suburb property prices section
			pvRegression.switchSuburbPropertyPrices(32, 1, 33, 34, 4, true);
			//verify if Properties on either map or list are clickable
			pvRegression.clickProperties(35, 1, 36, 37, 4, true);
			//check if upgrade to premium on other section if clickable
			pvRegression.getPremiumOtherSection(38, 1, 39, 40, 4, true);
			//check it the council name from suburb information is clickable and navigate to explore region page
			pvRegression.councilNameNav(41, 1, 42, 43, 4, true);
			//check if view suburb profile from suburb information section is clickable and navigate to suburb profile
			pvRegression.viewSuburbProfile(47, 1, 48, 49, 4, true);
			//check if can toggle the legend of each statistics chart
			pvRegression.toggleLegend(44, 1, 45, 46, 4, true);
		} catch (Exception e) {
		}
	}


	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../propertyValue-automation/pvRTest-data/RTStreetDetailsLinks.xls");
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
