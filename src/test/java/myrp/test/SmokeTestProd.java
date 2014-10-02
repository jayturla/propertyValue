package myrp.test;

import myrp.library.TestInitReference;
import myrp.utilities.SmokeTestUtil;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class SmokeTestProd extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist Automation/eclipse/myrp-automation/conf/atu.properties");
	}
	
@Test
	public void verifyExternalConnections(){
		try{
			new SmokeTestUtil().login("admin");
		    new SmokeTestUtil().checkHealth();
			pass("01. HEALTH CHECK - Checking HealthCheck Done!");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
		    new SmokeTestUtil().register();
			pass("02. SIGNUP - Verify that user can signup into myrp");
		    new SmokeTestUtil().changePassword();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			new SmokeTestUtil().login();
		
			//new SmokeTestUtil().isLoggedin();
			new SmokeTestUtil().buyEstimatedValueSubscription();
			new SmokeTestUtil().testCPS();	
			pass("03. ESTIMATED VALUE  SUBSCRIPTION - Verify that Estimated Value Subscription can be purchased as a logged in user");

		}catch(Exception e){
			e.printStackTrace();
			fail("03. ESTIMATED VALUE  SUBSCRIPTION - FAILED");
		}
		try{
		    new SmokeTestUtil().logout();
			pass("06. LOGOUT [Verify that user can log out from myrp]");
		}catch(Exception e){
			e.printStackTrace();
			fail("06. LOGOUT - FAILED");
		}
		try{
			new SmokeTestUtil().buyEstimatedValueReport();
			new SmokeTestUtil().testCPS();			
			pass("08. ESTIMATED VALUE REPORT - Verify that Estimated Value Report can be purchased by a guest user");
		}catch(Exception e){
			e.printStackTrace();
			fail("08. ESTIMATED VALUE REPORT - FAILED");
		}
		try{
			new SmokeTestUtil().buyDetailedPropertyReport();
			new SmokeTestUtil().testCPS();	
			pass("10. DETAILED PROPERTY REPORT -Verify that Detailed Property Report can be purchased by a guest user");
		}catch(Exception e){
			e.printStackTrace();
			fail("10. DETAILED PROPERTY REPORT - FAILED");
		}
		
	}
	

/*//NOT UPDATED
	public void verifyRegistration(){
		try{
		    new SmokeTestUtil().register();
			pass("02. SIGNUP - Verify that user can signup into myrp");
		    new SmokeTestUtil().changePassword();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyEstimatedValueSubscription(){
		try{
			new SmokeTestUtil().login();
		
			//new SmokeTestUtil().isLoggedin();
			new SmokeTestUtil().buyEstimatedValueSubscription();
			new SmokeTestUtil().testCPS();	
			pass("03. ESTIMATED VALUE  SUBSCRIPTION - Verify that Estimated Value Subscription can be purchased as a logged in user");

		}catch(Exception e){
			e.printStackTrace();
			fail("03. ESTIMATED VALUE  SUBSCRIPTION - FAILED");
		}
		
		try{
		    new SmokeTestUtil().logout();
			pass("06. LOGOUT [Verify that user can log out from myrp]");
		}catch(Exception e){
			e.printStackTrace();
			fail("06. LOGOUT - FAILED");
		}
	}
	
	public void verifyEstimatedValueReport(){
		try{
			new SmokeTestUtil().buyEstimatedValueReport();
			new SmokeTestUtil().testCPS();			
			pass("08. ESTIMATED VALUE REPORT - Verify that Estimated Value Report can be purchased by a guest user");
		}catch(Exception e){
			e.printStackTrace();
			fail("08. ESTIMATED VALUE REPORT - FAILED");
		}
	}
	
	public void verifyDetailedPropertyReport(){
		try{
			new SmokeTestUtil().buyDetailedPropertyReport();
			new SmokeTestUtil().testCPS();	
			pass("10. DETAILED PROPERTY REPORT -Verify that Detailed Property Report can be purchased by a guest user");
		}catch(Exception e){
			e.printStackTrace();
			fail("10. DETAILED PROPERTY REPORT - FAILED");
		}
	}*/
	
/*	@Test
	public void verifyKeyStats(){
		try{
			new SmokeTestUtil().checkKeyStats();
			pass("15. KEY STATS TAB - Verify that Key Stats page has been loaded with the correct details");
		}catch(Exception e){
			e.printStackTrace();
			fail("15. KEY STATS TAB - Failed");
		}
		
	}*/
	
	
	//***NOT YET UPDATED***
	/*@Test
	public boolean verifyInvestorPostcodeReport(){
		try{
			new SmokeTestUtil().verifyInvestorInLandingPage();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	} 
	
	@Test
	public void verifySalesHistoryReport(){
		try{
			new SmokeTestUtil().buySalesHistoryReport();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void verifyStreetSalesReport(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifySuburbSalesReport(){
		try{
			new SmokeTestUtil().buySuburbSalesHistory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyFreeSuburbProfileReport(){
		try{
			new SmokeTestUtil().buyFreeSuburbProfileReport();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void verifyInfographics(){
		try{
			new SmokeTestUtil().checkInfographics();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyLocalExperts(){
		try{
			new SmokeTestUtil().checkLocalExperts();
		}catch(Exception e){
		}
	}
	
	@Test
	public void verifyHoamLoans(){
		try{
			new SmokeTestUtil().checkHomeLoan();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void buyReports(){
		try{
			new SmokeTestUtil().checkOut();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void verifySuburbSalesMapSubscription(){
		try{
			new SmokeTestUtil().buyLastThreeYearsSalesMap();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void verifySuburbValueMap(){
		try{
			new SmokeTestUtil().buySuburbValueMap();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void buyReportsAsRegisteredUser(){
		try{
			new SmokeTestUtil().login("user");
			new SmokeTestUtil().checkOut();
			new SmokeTestUtil().logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void verifyMyAccount(){
		try{
			new SmokeTestUtil().verifyPurchasedReport();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyWestpac(){
		try{
			new SmokeTestUtil().verifyWestpacReport();
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
//	
	
}
