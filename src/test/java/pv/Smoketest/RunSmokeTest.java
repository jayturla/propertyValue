package pv.Smoketest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import pv.library.ReadXlsData;
import pv.library.TestInitReference;
import pv.utilities.AddtoWatchListUtil;
import pv.utilities.HeaderZoneUtil;
import pv.utilities.PaymentUtil;
import myrp.Smoketest.*;
import myrp.Utilities.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Test
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class RunSmokeTest extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../propertyValue-automation/conf/atu.properties");
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 1)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/healthCheck.xls")
	public void runHealthCheck(Class clzz, String[] input) {
		
		try {
			log("Testing Health Check...");
			HealthCheck_Test testLog = new HealthCheck_Test();
			testLog.testHealthCheck(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 2)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/homepage.xls")
	public void runHomepage(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Homepage...");
			HomePage_Test testLog = new HomePage_Test();
			testLog.testHomePage(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 3)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/signup.xls")
	public void runSignup(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Signup...");
			Signup_Test testLog = new Signup_Test();
			testLog.testSignup(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 4)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/loginSuburbSearchResult.xls")
	public void runLoginSuburbSearchResult(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Logged In Suburb Search Result...");
			LoginSuburbSearchResult_Test testLog = new LoginSuburbSearchResult_Test();
			testLog.testLoginSuburbSearchResult(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 5)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/loginSuburbProfile.xls")
	public void runSuburbProfile(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Suburb Profile...");
			LoginSuburbProfile_Test testLog = new LoginSuburbProfile_Test();
			testLog.testLoginSuburbProfile(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 6)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/postcodeActivityReport.xls")
	public void runPostcodeActivityReport(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Postcode Activity Report...");
			PostcodeActivityReport_Test testLog = new PostcodeActivityReport_Test();
			testLog.testPostcodeActivityReport(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 7)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/explore.xls")
	public void runExplore(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Explore...");
			Explore_Test testLog = new Explore_Test();
			testLog.testExplore(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 8)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/addtoWatchlist.xls")
	public void runAddToWatchlistSuburb(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Suburb Add to watchlist...");
			AddtoWatchListUtil testLog = new AddtoWatchListUtil(input);
			HeaderZoneUtil headZone = new HeaderZoneUtil(input);
			headZone.LoginPV(0, 1, 2, 3, 4, 5, 6,true);
			testLog.selectSuburb(29, 30, 31, 32, 33, 34, 40, true);
			testLog.verifyIfSuburbisAddedtoWatchList(35, 36, 37, 38, 39, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 9)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/headerzone.xls")
	public void runHeaderZone1(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing HeaderZone Logout...");
			HeaderZoneUtil testLog = new HeaderZoneUtil(input);
			testLog.LoginPV(4, 5, 6, 7, 8, 9, 10, true);
			testLog.logOutUser(11, 12, 13, 14, 15, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 10)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/headerzone.xls")
	public void runHeaderZone2(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing HeaderZone Login...");
			HeaderZoneUtil testLog = new HeaderZoneUtil(input);
			testLog.checkLogin(0, 1, 2, 3, true);
			testLog.LoginPV(4, 5, 6, 7, 8, 9, 10, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 11)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/streetDetails.xls")
	public void runStreetDetails(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Street Details...");
			StreetDetails_Test testLog = new StreetDetails_Test();
			testLog.testStreetDetails(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 12)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/addtoWatchlist.xls")
	public void runAddToWatchlistStreet(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Street Add to watchlist...");
			AddtoWatchListUtil testLog = new AddtoWatchListUtil(input);
			HeaderZoneUtil headZone = new HeaderZoneUtil(input);
			headZone.LoginPV(0, 1, 2, 3, 4, 5, 6,true);
			testLog.selectStreet(18, 19, 20, 21, 22, 23, 40,true);
			testLog.verifyIfStreetisAddedtoWatchList(24, 25, 26, 27, 28, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 13)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/advanceSearch.xls")
	public void runAdvanceSearch(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Advanced Search...");
			AdvanceSearch testLog = new AdvanceSearch();
			testLog.advanceSearch(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 14)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/propertyDetails.xls")
	public void runPropertyDetails(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Property Details...");
			PropertyDetails_Test testLog = new PropertyDetails_Test();
			testLog.testPropertyDetails(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 15)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/addtoWatchlist.xls")
	public void runAddToWatchlistProperty(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Property Add to watchlist...");
			AddtoWatchListUtil testLog = new AddtoWatchListUtil(input);
			HeaderZoneUtil headZone = new HeaderZoneUtil(input);
			headZone.LoginPV(0, 1, 2, 3, 4, 5, 6,true);
			testLog.selectProperty(7, 8, 9, 10, 11, 12, true);
			testLog.verifyIfPropertyisAddedtoWatchList(13, 14, 15, 16, 17, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 16)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/myAccount.xls")
	public void runMyAccount(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing MyAccount...");
			MyAccount testLog = new MyAccount();
			testLog.MyAccount(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 17)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/loginPortfolio.xls")
	public void runLoginPortfolio(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Logged In Portfolio...");
			loginPortfolio_Test testLog = new loginPortfolio_Test();
			testLog.testloginPortfolio(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 18)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/portfolioSummary.xls")
	public void runPortfolioSummary(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Portfolio Summary...");
			PortfolioSummary_Test testLog = new PortfolioSummary_Test();
			testLog.testPortfolioSummary(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 19)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/postcodeDetails.xls")
	public void runPostcodeDetails(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Postcode Details...");
			PostcodeDetails_Test testLog = new PostcodeDetails_Test();
			testLog.testPostcodeDetails(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 20)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/suburbSearchResult.xls")
	public void runSuburbSearchResult(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Suburb Search Result...");
			SuburbSearchResult_Test testLog = new SuburbSearchResult_Test();
			testLog.testSuburbSearchResult(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 21)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/propertyprofilereport.xls")
	public void runPropertyProfileReport(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Property Profile Report...");
			PropertyProfileReport_Test testLog = new PropertyProfileReport_Test();
			testLog.testPropertyProfileReport(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 22)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/multipleSearchResult.xls")
	public void runMultipleSearchResult(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Multiple Search Result...");
			MultipleSearchResult_Test testLog = new MultipleSearchResult_Test();
			testLog.testMultipleSearchResult(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 23)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/headerzone.xls")
	public void runForgottenPassword(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Forgotten Password...");
			HeaderZoneUtil testLog = new HeaderZoneUtil(input);
			testLog.resetPassword(16, 17, 18, 19, 20, 21, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 24)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/signupFacebook.xls")
	public void runSignupFB(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Signup w/ Facebook...");
			SignupFacebook_Test testLog = new SignupFacebook_Test();
			testLog.testSignupFacebook(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 25)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/payment.xls")
	public void runPaymentPromoCode(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Payment w/ Promo Code...");
			PaymentUtil testLog = new PaymentUtil(input);
			testLog.promoCode(0, 1, 2, 3, 4, 5, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 26)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/payment.xls")
	public void runReportPurchaseEmail(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Payment w/ Email...");
			PaymentUtil testLog = new PaymentUtil(input);
			testLog.emailPurchase(6, 7, 8, 9, 5, 10, 11, 12, 13, 14, 15, true);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 27)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/revenueReport.xls")
	public void runPVRevenueReport(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Property Value Revenue Report...");
			RevenueReport_Test testLog = new RevenueReport_Test();
			testLog.testRevenueReport(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 28)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/payment.xls")
	public void runPayment(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Payment...");
			Payment_Test testLog = new Payment_Test();
			testLog.testPayment(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 29)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/subscriptionDetails.xls")
	public void runSubscriptionDetails(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Subscription Details...");
			SubscriptionDetails_Test testLog = new SubscriptionDetails_Test();
			testLog.testSubscriptionDetails(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 30)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/premiumSuburbSearch.xls")
	public void runPremiumSuburbSearch(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Premium Suburb Search...");
			PremiumSuburbSearch_Test testLog = new PremiumSuburbSearch_Test();
			testLog.testPremiumSuburbSearch(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 31)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/reportsPortfolioAndWatchlist.xls")
	public void runReportsPortfolioAndWatchlist(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Premium Module Reports, Portfolio, And Watchlist...");
			ReportsPortfolioAndWatchlist_Test testLog = new ReportsPortfolioAndWatchlist_Test();
			testLog.testReportsPortfolioAndWatchlist(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 32)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/compare.xls")
	public void runCompare(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Premium Compare...");
			Compare_Test testLog = new Compare_Test();
			testLog.testCompare(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 33)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/strategiesAndExplore.xls")
	public void runStrategiesAndExplore(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Premium Module Strategies and Explore...");
			StrategiesAndExplore_Test testLog = new StrategiesAndExplore_Test();
			testLog.testStrategiesAndExplore(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 34)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/premiumPropertyDetails.xls")
	public void runPremiumPropertyDetails(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Premium Property Details...");
			PremiumPropertyDetails_Test testLog = new PremiumPropertyDetails_Test();
			testLog.testPremiumPropertyDetails(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 35)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/premiumStreetDetails.xls")
	public void runPremiumStreetDetails(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Premium Street Details...");
			PremiumStreetDetails_Test testLog = new PremiumStreetDetails_Test();
			testLog.testPremiumStreetDetails(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	@Test(dataProvider = "XMLFileLoader", priority = 36)
	@XmlFileParameters(path = "../propertyValue-automation/pvtest-data/suburbProfilePage.xls")
	public void runPremiumSuburbProfilePage(Class clzz, String[] input) {
		
		try {
			System.out.println("");
			log("Testing Premium Suburb Profile Page...");
			SuburbProfilePage_Test testLog = new SuburbProfilePage_Test();
			testLog.testSuburbProfilePage(clzz, input);
			
		} catch (Exception e) {
		}
	}
	
	
	
//	@Test(dataProvider = "XMLFileLoader", priority = 37)
//	@XmlFileParameters(path = "../propertyValue-automation/myrptest-data/Signup.xls")
//	public void runSCSignup(Class clzz, String[] input) {
//		
//		try {
//			System.out.println("");
//			log("Testing Subscriptions Channel Signup...");
//			myrp.Smoketest.Signup_Test testLog = new myrp.Smoketest.Signup_Test();
//			testLog.testSubscriptionsChannelSignup(clzz, input);
//			
//		} catch (Exception e) {
//		}
//	}
//	
//	@Test(dataProvider = "XMLFileLoader", priority = 38)
//	@XmlFileParameters(path = "../propertyValue-automation/myrptest-data/EstimatedValueReport.xls")
//	public void runSCEstimatedValueReport(Class clzz, String[] input) {
//		
//		try {
//			System.out.println("");
//			log("Testing Subscriptions Channel Estimated Value Report...");
//			myrp.Smoketest.EstimatedValueReport_Test testLog = new myrp.Smoketest.EstimatedValueReport_Test();
//			testLog.testSubscriptionsChannelEstimatedValueReport(clzz, input);
//			
//		} catch (Exception e) {
//		}
//	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface XmlFileParameters {
	    String path();
	    String encoding() default "UTF-8";
	}
	
	@DataProvider(name = "XMLFileLoader")
	public static Object[][] getDataFromXmlFile(final Method testMethod) throws IOException {
	    XmlFileParameters parameters = testMethod.getAnnotation(XmlFileParameters.class);

	    if (parameters != null) {
	        String path = parameters.path();
	        String encoding = parameters.encoding();
	        return loadDataFromXmlFile(path, encoding);
	    } else {
	        throw new RuntimeException("Couldn't find the annotation");
	    }
	}
	
	private static Object[][] loadDataFromXmlFile(final String path, final String encoding) throws IOException {
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData(path);
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
