package myrp.test;

import java.io.IOException;

import myrp.library.ReadXlsData;
import myrp.library.TestInitReference;
import myrp.utilities.EvrProjectUtilAUS;
import myrp.utilities.SmokeTestUtil;

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
public class SmokeTest extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "../evr-automation/conf/atu.properties");
	}
	
	String testCase = "T1535038";
		
	@Test(description="T1535038", dataProvider = "Data-Provider-Function")
	  public void buyDetailedPropertyReport(){
		 try{
		  pass("buyDetailedPropertyReport started!");
		 
		  
		  //logged in
		  pass("logging in");
		  new SmokeTestUtil().login("user");
		  pass("Adding Detailed Property Report to cart! ");
		  new SmokeTestUtil().buyDetailedPropertyReport();
		  pass("Purchasing Detailed Property Report!");
//	    new SmokeTestUtil().checkOut();
		  pass("Verifying if report is successfully purchased!");
		  new SmokeTestUtil().verifyPurchasedReport();
		  new SmokeTestUtil().logout();
		  
		  //guest
		  pass("Adding Detailed Property Report to cart! ");
		  new SmokeTestUtil().buyDetailedPropertyReport();
		  pass("Purchasing Detailed Property Report!");
//		  new SmokeTestUtil().checkOut();
		 }
		 catch(Exception e){
			 fail("buyDetailedPropertyReport");
		 }
		  
	  }
	  
	  @Test
	  public void getTitleDocument() {
		  pass("getTitleDocument started!");
		  try{

			  new SmokeTestUtil().getTitleDocument();

		  }catch(Exception e){
			  fail("getTitleDocument");
		  }
	  }
	  
	  @Test
	  public void buyEtsimatedValueReport() {
		  pass("buyEtsimatedValueReport started!");
		  try{

			  new SmokeTestUtil().buyEstimatedValueReport();
			 
		  }catch(Exception e){
			  fail("buyEtsimatedValueReport");
		  }
		  
	  }
	  
	  @Test
	  public void buyEstimatedValueSubscription(){
		  pass("buyEstimatedValueSubscription started!");
		  try{
			
			  new SmokeTestUtil().buyEstimatedValueSubscription();
			  
		  }catch(Exception e){
			  fail("buyEstimatedValueSubscription");
		  }
	  }
	  
	  @Test
	  public void buySalesHistoryReport() {
	    pass("buySalesHistoryReport started!");
		try{
		
			new SmokeTestUtil().buySalesHistoryReport();
			
			
		}catch(Exception e){
			fail("buySalesHistoryReport");
		}
	  }
	  
	  @Test
	  public void buySuburbSalesHistory() {
		pass("buySuburbSalesHistory started!");
		try{
			
			new SmokeTestUtil().buySuburbSalesHistory();
			
			
		}catch(Exception e){
			fail("buySuburbSalesHistory");
		}
	  }
	  
	  @Test
	  public void buyLastThreeYearsSalesMap()  {
		 pass("buyLastThreeYearsSalesMap started!");
		 try{
			new SmokeTestUtil().buyLastThreeYearsSalesMap();
			
			
		}catch(Exception e){
			fail("buyLastThreeYearsSalesMap");
		}
	  }
	  
	  @Test
	  public void buySuburbValueMap() {
		  pass("buySuburbValueMap started!");
		 try{
			
			 new SmokeTestUtil().buySuburbValueMap();
			 
		 }catch(Exception e){
			 fail("buySuburbValueMap");
		 }
	  }
		
	  @Test
	  public void buyFreeSuburbProfileReport(){
		  pass("buyFreeSuburbProfileReport started!");
		  try{
			  new SmokeTestUtil().buyFreeSuburbProfileReport();
			
		  }catch(Exception e){
			  fail("buyFreeSuburbProfileReport");
		  }
	  }
	  
	  @Test
	  public void checkKeyStats()  {
		  pass("checkKeyStats started!");
		  try{
			  new SmokeTestUtil().checkKeyStats();
			  
		  }catch(Exception e){
			  fail("checkKeyStats");
		  }
	  }
	  
	  
	  @Test 
	  public void checkLocalExperts(){
		  pass("checkLocalExperts started!");
		  try{
			  new SmokeTestUtil().checkLocalExperts();
		  }catch(Exception e){
			 fail("checkLocalExperts"); 
		  }
		 
	  }
	  
	  @Test
	  public void checkHomeLoan(){
		  pass("checkHomeLoan started!");
		  try{
			  new SmokeTestUtil().checkHomeLoan();
		  }catch(Exception e){
			  fail("checkHomeLoan");
		  }

	  }
	  
	  @Test
	  public void validateSuburbsInPostCodeList(){
		  pass("validateSuburbsInPostCodeList started!");
		  try{
			  new SmokeTestUtil().validateSuburbsInPostCodeList();
		  }catch(Exception e){
			  fail("validateSuburbsInPostCodeList");
		  }
		
	  }
	  
	  
	  @Test
	  public void validateCouncilSearch(){
		  pass("validateCouncilSearch started!");
		  try{
			  new SmokeTestUtil().searchCouncil();
		  }catch(Exception e){
			  fail("validateCouncilSearch");
		  }
		 
	  }
	  
	  @Test
	  public void validateState(){
		  pass("validateState started!");
		  try{
			  new SmokeTestUtil().searchState();
		  }catch(Exception e){
			  fail("validateState");
		  }
		 
	  }
	  
	  @Test
	  public void checkInfographics(){
		  pass("checkInfographics started!");
		  try{
			  new SmokeTestUtil().checkInfographics();
		  }catch(Exception e){
			  fail("checkInfographics");
		  }
		 
	  }
	  
	  @Test 
	  public void verifyHealth(){
		  pass("verifyHealth started!");
		  try{
			  new SmokeTestUtil().login("admin");
			  new SmokeTestUtil().checkHealth();
			  new SmokeTestUtil().logout();
		  }catch(Exception e){
			  fail("verifyHealth");
		  }
		
	  }
	  
	  @Test 
	  public void verifyLJHookerEstimatedValueReport(){
		  pass("verifyLJHookerEstimatedValueReport started!");
		  try{
			  new SmokeTestUtil().buyLJHookerEstimatedValueReport();
		  }catch(Exception e){
			  fail("verifyLJHookerEstimatedValueReport");
		  }
		 
	  }
	  
	  @Test
	  public void verifyNetBankDetailedPropertyReport(){
		  pass("verifyNetBankDetailedPropertyReport started!");
		  try{
			  new SmokeTestUtil().buyNetBankDetailedPropertyReport();
		  }catch(Exception e){
			  fail("verifyNetBankDetailedPropertyReport");
		  }
		 
	  }
	  
	  @Test
	  public void verifyNetBankSyndicatedReport() {
		  pass("verifyNetBankSyndicatedReport started!");
		  try{
			  new SmokeTestUtil().getNetbankBuyOrRent();
		  }catch(Exception e){
			  fail("verifyNetBankSyndicatedReport");
		  }
		
	  }
	  @Test
	  public void verifyRatesonlineSyndicatedReport() {
		  pass("verifyRatesonlineSyndicatedReport started!");
		  try{
			  new SmokeTestUtil().getRatesonlineBuyOrRent();
		  }catch(Exception e){
			  fail("verifyRatesonlineSyndicatedReport");
		  }
		  
	  }
	  @Test
	  public void verifyMeBankSyndicatedReport() {
		  pass("verifyMeBankSyndicatedReport started!");
		  try{
			  new SmokeTestUtil().getMeBankBuyOrRent();
		  }catch(Exception e){
			  fail("verifyMeBankSyndicatedReport");
		  }
		 
	  }
	  @Test
	  public void verifySpringbuyerSyndicatedReport() {
		  pass("verifySpringbuyerSyndicatedReport started!");
		  try{
			  new SmokeTestUtil().getMeBankBuyOrRent();
		  }catch(Exception e){
			  fail("verifySpringbuyerSyndicatedReport");
		  }
		 
	  }
	  @Test
	  public void searchNabPropertyAddress() {
		  pass("searchNabPropertyAddress started!");
		  try{
			  new SmokeTestUtil().searchNabPropertyAddress();
		  }catch(Exception e){
			  fail("searchNabPropertyAddress");
		  }
		 
	  }
	  @Test
	  public void verifyPlanKeepShoppingLink() {
		  pass("verifyPlanKeepShoppingLink started!");
		  try{
			  new SmokeTestUtil().verifyPlanKeepShoppingLink();
		  }catch(Exception e){
			  fail("verifyPlanKeepShoppingLink");
		  }
		 
	  }
	  @Test
	  public void verifyFastKeepShoppingLink() {
		  pass("verifyFastKeepShoppingLink started!");
		  try{
			  new SmokeTestUtil().verifyFastKeepShoppingLink();
		  }catch(Exception e){
			  fail("verifyFastKeepShoppingLink");
		  }
		 
	  }
	  @Test
	  public void verifyChoiceKeepShoppingLink()throws Exception{
		  pass("verifyChoiceKeepShoppingLink started!");
		  try{
			  new SmokeTestUtil().verifyChoiceKeepShoppingLink();
		  }catch(Exception e){
			  fail("verifyChoiceKeepShoppingLink");
		  }
		  
	  }
	  @Test
	  public void verifyPeoplesChoiceKeepShoppingLink(){
		  pass("verifyPeoplesChoiceKeepShoppingLink started!");
		  try{
			  new SmokeTestUtil().verifyPeoplesChoiceKeepShoppingLink();
		  }catch(Exception e){
			  fail("verifyPeoplesChoiceKeepShoppingLink");
		  }
		
	  }
	  @Test
	  public void verifyPropertyValueSearch() {
		  pass("verifyPropertyValueSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchPropertyValue();
		  }catch(Exception e){
			  fail("verifyPropertyValueSearch");
		  }
		 
	  }
	  @Test
	  public void verifyNetBankSearch() {
		  pass("verifyNetBankSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchNetBank();
		  }catch(Exception e){
			  fail("verifyNetBankSearch");
		  }
		 
	  }
	  @Test
	  public void verifyNewsSearch(){
		  pass("verifyNewsSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchNews();
		  }catch(Exception e){
			  fail("verifyNewsSearch");
		  }
		 
	  }
	  @Test
	  public void verifyHeraldSunSearch(){
		  pass("verifyHeraldSunSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchHeraldSun();
		  }catch(Exception e){
			  fail("verifyHeraldSunSearch");
		  }
		  
	  }
	  @Test
	  public void verifyCourierMailSearch(){
		  pass("verifyCourierMailSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchCourierMail(); 
		  }catch(Exception e){
			  fail("verifyCourierMailSearch");
		  }
		 
	  }
	  @Test
	  public void verifyDailyTelegraphSearch(){
		  pass("verifyDailyTelegraphSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchDailyTelegraph();
		  }catch(Exception e){
			  fail("verifyDailyTelegraphSearch");
		  }
		  
	  }
	  @Test
	  public void verifyAdelaidenowSearch(){
		  pass("verifyAdelaidenowSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchAdelaidenow();
		  }catch(Exception e){
			  fail("verifyAdelaidenowSearch");
		  }
		
	  }
	  @Test
	  public void verifyPerthnowSearch(){
		  pass("verifyPerthnowSearch started!");
		  try{
			  new SmokeTestUtil().verifySearchPerthnow();
		  }catch(Exception e){
			  fail("verifyPerthnowSearch");
		  }
		
	  }
	  
	  
	  @Test
	  public void verifyTextAdLinksInSearches(){
		  pass("verfying Text Ad Link in Searches started!");
		  try{
			  new SmokeTestUtil().verifyTextLinkAds();
		  }catch(Exception e){
			  fail("verfying Text Ad Link Failed!");
		  }
	  }
	  
	  
	  
	  
	//  @Test
	//  public void changePassword(){
//		  try{
//			  new SmokeTestUtil().login();
//			  new SmokeTestUtil().changePassword();
//			  new SmokeTestUtil().logout();
//			  new SmokeTestUtil().login();
//		  }catch(Exception e){
//			  fail("changePassword");
//		  }
	//	
	//  }

	 
	

	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException{
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("../evr-automation/test-data/changeAddress.xls");
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
