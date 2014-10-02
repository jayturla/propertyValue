package myrp.utilities;

import static org.openqa.selenium.By.xpath;

import java.util.*;

import myrp.library.ObjectReference;
import myrp.library.ObjectReference;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTestUtil extends TestInitReference {
	
	private boolean isPasswordChanged = false;
	private String environment = rxml.data("environment");
	private String urlHome = "";
	private String urlPropertyValue = "";
	private String urlNetBank = "";
	private String urlVerifySearchNews = "";
	private String urlSearchHeraldSun = "";
	private String urlVerifySearchCourierMail = "";
	private String urlVerifySearchDailyTelegraph = "";
	private String urlVerifySearchAdelaidenow = "";
	private String urlVerifySearchPerthnow = "";
	
	
	

	String firstName = rxml.data("smokeFirstName");
	String lastName = rxml.data("smokeLastName");
	String email = rxml.data("smokeEmail");
	String confirmEmail = rxml.data("smokeConfirmEmail");
	String password = rxml.data("smokePassword");
	String confirmPassword = rxml.data("smokeConfirmPassword");
	String changePassword = rxml.data("smokeChangePassword");
	String securityQuestion = rxml.data("smokeSecurityQuestion");
	String securityQuestionAnswer = rxml.data("smokeSecurityQuestionAnswer");
	String contactNumber = rxml.data("smokeContactNumber");
	String propertyAddress = rxml.data("smokePropertyAddress");
	String stateBreadCrumb = rxml.data("smokeStateBreadcrumb");
	String councilBreadCrumb = rxml.data("smokeCouncilBreadcrumb");
	String suburbBreadCrumb = rxml.data("smokeSuburbBreadcrumb");
	String streetBreadCrumb = rxml.data("smokeStreetBreadcrumb");
	String loanAmount = rxml.data("smokeLoanAmount");
	String suburbAddress = rxml.data("smokeSuburbAddress");
	String postCode = rxml.data("smokePostCode");
	String userName = rxml.data("smokeUserName");
	String cardNumber = rxml.data("smokeCardNumber");
	String securityCode = rxml.data("smokeSecurityCode");
	String alternatePassword = rxml.data("smokeAlternatePassword");
	String alternateRePassword = rxml.data("smokeAlternateRePassword");
	String streetAddress = rxml.data("smokeStreetAddress");
	
	public SmokeTestUtil(){
		checkEnvironmentUrl();
	}
	
	public void checkEnvironmentUrl() {
		if(environment.equalsIgnoreCase("dev")){
			urlHome = "dev.myrp.com.au";
		}else if(environment.equalsIgnoreCase("stage")){
			urlHome = "http://myrp:myrp999@stage.myrp.com.au";
		}else if(environment.equalsIgnoreCase("prod")){
			urlHome = "http://www.myrp.com.au/";
		}
	}
	
	//Registration
	@Test
	public void register() throws Exception {
		waitForElementPresent(xpath(ObjectReference.signup_button_xp));
		click(xpath(ObjectReference.signup_button_xp));
		waitForElementPresent(xpath(ObjectReference.smokeFirstName_xp));
		try{
			type(xpath(ObjectReference.smokeFirstName_xp), firstName);
			type(xpath(ObjectReference.smokeLastName_xp),  lastName);
			type(xpath(ObjectReference.smokeEmail_xp),  email);
			type(xpath(ObjectReference.smokeConfirmEmail_xp),  confirmEmail);
			type(xpath(ObjectReference.smokePassword_xp),  password );
			type(xpath(ObjectReference.smokeConfirmPassword_xp), confirmPassword );
			type(xpath(ObjectReference.smokeSecurityQuestion_xp), securityQuestion );
			type(xpath(ObjectReference.smokeSecurityQuestionAnswer_xp), securityQuestionAnswer);
			click(xpath(ObjectReference.smokeTermsAndConditions_xp));
			Thread.sleep(8000);
			click(xpath(ObjectReference.smokeBtnDone_xp));
			waitForElementPresent(xpath(ObjectReference.smokeSuccessRegister));
			Assert.assertTrue(verifyTextPresent("You have successfully signed in to myRPData and you are now logged in."));
			pass("02. SIGNUP [Verify that user can signup into myrp]");
		
		}catch(AssertionError e){
			fail("Did not register successfully!");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	//Search address
	@Test
	public void searchPropertyAddress() throws Exception {
		waitForElementPresent(xpath(ObjectReference.smokeSearchLine_xp));
		type(xpath(ObjectReference.smokeSearchLine_xp), propertyAddress);
		click(xpath(ObjectReference.search_button_xp));
		waitForElementPresent(xpath(ObjectReference.smokeSearchAddress_xp));
		try{
			Assert.assertEquals(propertyAddress, getText(xpath(ObjectReference.smokeSearchAddress_xp)));
			Assert.assertEquals(stateBreadCrumb, getText(xpath(ObjectReference.smokeStateBreadCrumb_xp)));
			Assert.assertEquals(councilBreadCrumb, getText(xpath(ObjectReference.smokeCouncilBreadCrumb_xp)));
			Assert.assertEquals(suburbBreadCrumb, getText(xpath(ObjectReference.smokeSuburbBreadCrumb_xp)));
			Assert.assertEquals(streetBreadCrumb, getText(xpath(ObjectReference.smokeStreetBreadCrumb_xp)));
			
			pass(" - Test: " + propertyAddress + " is present");

		}
		catch(Exception e){
			fail(" - Test: " + propertyAddress + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
		
		
	}
	
	public void searchPropertyAddress(String method) throws Exception {
		waitForElementPresent(xpath(ObjectReference.smokeSearchLine_xp));
		
		if(method.equals("getTitleDocument")){
			propertyAddress = rxml.data("smokePropertyAddress1");
		}else if(method.equals("buyEstimatedValueReport")){
			propertyAddress = rxml.data("smokePropertyAddress2");
		}else if(method.equals("buyEstimatedValueSubscription")){
			propertyAddress = rxml.data("smokePropertyAddress3");
		}else if(method.equals("buySalesHistoryReport")){
			propertyAddress = rxml.data("smokePropertyAddress4");
		}
		type(xpath(ObjectReference.smokeSearchLine_xp), propertyAddress);
		click(xpath(ObjectReference.search_button_xp));
		waitForElementPresent(xpath(ObjectReference.smokeSearchAddress_xp));
		
		try{
			pass(" - Test: " + propertyAddress + " is present");

		}
		catch(Exception e){
			fail(" - Test: " + propertyAddress + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
		
		
	}
	
	public void buyDetailedPropertyReport() throws Exception {
		searchPropertyAddress();
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToCartDetailedPropertyReport_xp));
			click(xpath(ObjectReference.smokeBtnAddToCartDetailedPropertyReport_xp));
			Thread.sleep(1000);
			waitForElementPresent(xpath(ObjectReference.smokeBtnContinueBuyingDetailedPropertyReport_xp));
			click(xpath(ObjectReference.smokeBtnContinueBuyingDetailedPropertyReport_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnGoToCart_xp));
			click(xpath(ObjectReference.smokeBtnGoToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Detailed Property Report"));
			
		
		}catch(Exception e){
			fail("Unable to buy Detailed Property Report");
		}catch(AssertionError e){
			fail(" - Test: " + propertyAddress + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
	}
	
	public void getTitleDocument() throws Exception {
		searchPropertyAddress("getTitleDocument");
		try{
			
			waitForElementPresent(xpath(ObjectReference.smokeBtnGetTitleDocument_xp));
			
		}
			
		catch(Exception e){
			takeScreenshot();
		}
		
		catch(AssertionError e){
			takeScreenshot();
		}
		
	}
	
	public void buyEstimatedValueReport() throws Exception {
		searchPropertyAddress("buyEstimatedValueReport");
		
		try{
			//gets free report
//			click(xpath(smokeBtnGetThisFree_xp));
//			waitForElementPresent(xpath(smokeFirstName_xp));
//			type(xpath(smokeFirstName_xp), firstName);
//			type(xpath(smokeLastName_xp),  lastName);
//			type(xpath(smokeEmailLead_xp),  email);
//			type(xpath(smokeContactNumber_xp), contactNumber);
//			selectOption(xpath(smokeRelationShipOnProperty_xp), "Refinancing/Consolidation");
//			selectOption(xpath(smokeTimeToAct_xp), "Unsure");
//			type(xpath(smokeLoanAmount_xp), loanAmount);
//			selectOption(xpath(smokePreferredContactTime), "Afternoon");
//			click(xpath(smokeBtnIAgree_xp));
//			Thread.sleep(800);
//			click(xpath(smokeBtnSubmitDetails_xp));
//			Thread.sleep(1500);
//	//		Assert.assertTrue(verifyTextPresent("We hope you find your chat with them useful."));
//			Thread.sleep(1500);
//			waitForElementPresent(xpath(smokeBtnGetThisFreeClose_xp));
//			click(xpath(smokeBtnGetThisFreeClose_xp));
			//buys report
			Thread.sleep(1500);
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToCartEstimatedValueReport_xp));
			click(xpath(ObjectReference.smokeBtnAddToCartEstimatedValueReport_xp));
			Thread.sleep(1000);
			click(xpath(ObjectReference.btnCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Estimated Value Report"));
			pass("buyEstimatedValueReport");
			
		}catch(Exception e ){
			takeScreenshot();
			fail("buyEstimatedValueReport");
			
		}catch(AssertionError e){
			e.printStackTrace();
		}
	}
	
	public void buyEstimatedValueSubscription() throws Exception {
		searchPropertyAddress("buyEstimatedValueSubscription");
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToCartEstimatedValueSubscription_xp));
			click(xpath(ObjectReference.smokeBtnAddToCartEstimatedValueSubscription_xp));
			click(xpath(ObjectReference.smokeBtnGoToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Estimated Value Subscription"));
			pass("buyEstimatedValueSubscription");
			
		}catch(Exception e){
			takeScreenshot();
			e.printStackTrace();
			fail("buyEstimatedValueSubscription()");
		}
		
	}
	
	public void buySalesHistoryReport() throws Exception {
		searchPropertyAddress("buySalesHistoryReport");
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToCartSalesHistoryReport_xp));
			click(xpath(ObjectReference.smokeBtnAddToCartSalesHistoryReport_xp));
			click(xpath(ObjectReference.smokeBtnGoToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Sales History Report"));
			pass("buyEstimatedValueSubscription");
			
		}catch(Exception e){
			takeScreenshot();
			fail("buySalesHistoryReport");
		}
		
	}
	
	public void searchSuburb() throws Exception {
		
		waitForElementPresent(xpath(ObjectReference.smokeSearchLine_xp));
		type(xpath(ObjectReference.smokeSearchLine_xp), suburbAddress);
		click(xpath(ObjectReference.search_button_xp));
		waitForElementPresent(xpath(ObjectReference.smokeSearchAddress_xp));
		try{
			
			pass(" - Test: " + suburbAddress + " is present");

		}
		catch(Exception e){
			fail(" - Test: " + suburbAddress + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	public void searchSuburb(String address) throws Exception {
		
		waitForElementPresent(xpath(ObjectReference.smokeSearchLine_xp));
		type(xpath(ObjectReference.smokeSearchLine_xp), address);
		click(xpath(ObjectReference.search_button_xp));
		waitForElementPresent(xpath(ObjectReference.smokeSearchAddress_xp));
		try{
			
			pass(" - Test: " + suburbAddress + " is present");

		}
		catch(Exception e){
			fail(" - Test: " + suburbAddress + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
public void searchSuburb(int method) throws Exception {
		if(method ==1){
			suburbAddress = rxml.data("smokeSuburbAddress1");
		}else if(method ==2){
			suburbAddress = rxml.data("smokeSuburbAddress2");
		}else if(method ==3){
			suburbAddress = rxml.data("smokeSuburbAddress3");
		}else if(method ==4){
			suburbAddress = rxml.data("smokeSuburbAddress4");
		}
		
		waitForElementPresent(xpath(ObjectReference.smokeSearchLine_xp));
		type(xpath(ObjectReference.smokeSearchLine_xp), suburbAddress);
		click(xpath(ObjectReference.search_button_xp));
		waitForElementPresent(xpath(ObjectReference.smokeSearchAddress_xp));
		try{
			
			pass(" - Test: " + suburbAddress + " is present");

		}
		catch(Exception e){
			fail(" - Test: " + suburbAddress + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	
	
	public void buySuburbSalesHistory() throws Exception {
		searchSuburb();
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToCartSuburbSalesHistoryReport_xp));
			click(xpath(ObjectReference.smokeBtnAddToCartSuburbSalesHistoryReport_xp));
			click(xpath(ObjectReference.smokeBtnGoToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Suburb Sales Report"));
			
			
			pass("buySuburbSalesHistory");
		}catch(Exception e){
			takeScreenshot();
			fail("buySuburbSalesHistory");
		}
	}
	
	public void buyLastThreeYearsSalesMap() throws Exception {
		searchSuburb(1);
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToLastThreeYearsSalesMap_xp));
			click(xpath(ObjectReference.smokeBtnAddToLastThreeYearsSalesMap_xp));
			click(xpath(ObjectReference.smokeBtnGoToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Last 3 Years Suburb Sales Map Subscription"));
			pass("buySuburbSalesHistory");
		}catch(Exception e){
			takeScreenshot();
			fail("buySuburbSalesHistory");
		}
	}
	
	public void buySuburbValueMap() throws Exception{
		searchSuburb(2);
		try{
			
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToSuburbValueMap_xp));
			click(xpath(ObjectReference.smokeBtnAddToSuburbValueMap_xp));
			click(xpath(ObjectReference.smokeBtnGoToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Suburb Value Map"));
			pass("buySuburbValueMap");
			
		}catch(Exception e){
			takeScreenshot();
			fail("buySuburbValueMap");
		}
	}
	
	public void buyFreeSuburbProfileReport() throws Exception {
		searchSuburb(3);
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAddToFreeSuburbProfileReport_xp));
			click(xpath(ObjectReference.smokeBtnAddToFreeSuburbProfileReport_xp));
			waitForElementPresent(xpath(ObjectReference.smokeFreePackageEmail_xp));
			type(xpath(ObjectReference.smokeFreePackageEmail_xp), email);
			click(xpath(ObjectReference.smokeBtnFreePackageSubmit_xp));
			Assert.assertTrue(verifyTextPresent("Thank you. Your Free suburb profile report has been emailed."));
			click(xpath(ObjectReference.smokeBtnGetThisFreeClose_xp));
			
			pass("buyFreeSuburbProfileReport");
		}catch(Exception e){
			takeScreenshot();
			fail("buyFreeSuburbProfileReport");
		}
	}
	
	public void checkKeyStats() throws Exception {
		searchSuburb();
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnKeyStats_xp));
			click(xpath(ObjectReference.smokeBtnKeyStats_xp));
			checkImgAgeSexRatio();
			checkImgIncome();
			checkImgStructure();
			checkImgOccupancy();
		}catch(Exception e){
			takeScreenshot();
			fail("checkKeyStats");
		}
	}
	
	public void checkImgAgeSexRatio() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAgeSexRatio_xp));
			click(xpath(ObjectReference.smokeBtnAgeSexRatio_xp));
			waitForElementPresent(xpath(ObjectReference.smokeImgAgeSexRatio_xp));
			Thread.sleep(500);
		}catch(Exception e){
			takeScreenshot();
			fail("checkImgAgeSexRatio");
		}
		
	}
	
	public void checkImgIncome() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnIncome_xp));
			click(xpath(ObjectReference.smokeBtnIncome_xp));
			waitForElementPresent(xpath(ObjectReference.smokeImgIncome_xp));
			Thread.sleep(500);
		}catch(Exception e){
			takeScreenshot();
			fail("checkImgIncome");
		}
	}
	
	public void checkImgStructure() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnStructure_xp));
			click(xpath(ObjectReference.smokeBtnStructure_xp));
			waitForElementPresent(xpath(ObjectReference.smokeImgStructure_xp));
			Thread.sleep(500);
		}catch(Exception e){
			takeScreenshot();
			fail("checkImgStructure");
		}
	}
	
	public void checkImgOccupancy() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnOccupancy_xp));
			click(xpath(ObjectReference.smokeBtnOccupancy_xp));
			waitForElementPresent(xpath(ObjectReference.smokeImgOccupancy_xp));
			Thread.sleep(500);
		}catch(Exception e){
			takeScreenshot();
			fail("checkImgOccupancy");
		}
	}
	
	public void checkLocalExperts() throws Exception{
		searchSuburb();
		String addressWithExpert = suburbAddress;
		String addressWithoutExpert = rxml.data("suburbAddressWithoutExpert");
		boolean flag1 = false;
		boolean flag2 = false;
		if(doesLocalExpertExist(addressWithExpert)){
			flag1 = true;
		}
		if(doesLocalExpertExist(addressWithoutExpert)){
			flag2 = true;
		}
		
		if(flag1== true && flag2 == true){
			pass("checkLocalExperts passed");
		}else{
			fail("checkLocalExperts");
		}
	}
	
	public boolean doesLocalExpertExist(String address) throws Exception{
		
		try{
			searchSuburb(address);
			waitForElementPresent(xpath(ObjectReference.smokeBtnLocalExperts_xp));
			
			return true;
		}catch(Exception e){
			takeScreenshot();
			return false;
			
		}
	}
	
	public void checkHomeLoan() throws Exception{
		searchSuburb();
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnHomeLoans_xp));
			pass("checkHomeLoan");
		}catch(Exception e){
			takeScreenshot();
			fail("checkHomeLoan");
		}
	}
	
	public void searchPostCode() throws Exception{
		waitForElementPresent(xpath(ObjectReference.smokeSearchLine_xp));
		type(xpath(ObjectReference.smokeSearchLine_xp), postCode);
		click(xpath(ObjectReference.search_button_xp));
		waitForElementPresent(xpath(ObjectReference.smokeSearchAddress_xp));
		try{
			
			pass(" - Test: " + postCode + " is present");

		}
		catch(Exception e){
			fail(" - Test: " + postCode + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
		
	}
	
	public void validateSuburbsInPostCodeList() throws Exception {
		driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au");
		searchPostCode();
		try{
			By xpaths[] = {xpath(ObjectReference.moonbria),
					xpath(ObjectReference.morago),
					xpath(ObjectReference.prettyPine),
					xpath(ObjectReference.steamPlains),
					xpath(ObjectReference.studPark),
					xpath(ObjectReference.wakool),
					xpath(ObjectReference.wandook),
					xpath(ObjectReference.wanganella),
					xpath(ObjectReference.warragoon),
					xpath(ObjectReference.willurah),
					xpath(ObjectReference.barratta),
					xpath(ObjectReference.birganbigil),
					xpath(ObjectReference.booroorban),
					xpath(ObjectReference.bullatale),
					xpath(ObjectReference.calimo),
					xpath(ObjectReference.caldwell),
					xpath(ObjectReference.conargo),
					xpath(ObjectReference.coree),
					xpath(ObjectReference.deniliquin),
					xpath(ObjectReference.hartwood),
					xpath(ObjectReference.lindiferron),
					xpath(ObjectReference.mathoura)};
			
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass("validateSuburbsInPostCodeList");
			
		}catch(Exception e){
			fail("validateSuburbsInPostCodeList");
			
		}
	}
	
	public void searchCouncil() throws Exception {
		searchPropertyAddress();
		try{
			waitForElementPresent(xpath(ObjectReference.smokeCouncilBreadCrumb_xp));
			click(xpath(ObjectReference.smokeCouncilBreadCrumb_xp));
			waitForElementPresent(xpath(ObjectReference.councilReport_xp));
			waitForElementPresent(xpath(ObjectReference.mostRecentSales_xp));
			pass("searchCouncil");
		}catch(Exception e){
			takeScreenshot();
			fail("searchCouncil");
		}
		
	}
	
	public void searchState() throws Exception {
		searchPropertyAddress();
		try{
			waitForElementPresent(xpath(ObjectReference.smokeStateBreadCrumb_xp));
			click(xpath(ObjectReference.smokeStateBreadCrumb_xp));
			pass("searchState");
			
		}catch(Exception e){
			takeScreenshot();
			fail("searchState");
		}
	}
	
	public void checkInfographics() throws Exception {
		searchPropertyAddress();
		try{
			waitForElementPresent(xpath(ObjectReference.SmokeBtnInfographics_xp));
			click(xpath(ObjectReference.SmokeBtnInfographics_xp));
			
			pass("checkInfographics");
		}catch(Exception e){
			takeScreenshot();
			fail("checkInfographics");
		}
	}
	
	public void login(String user) throws Exception {
		driver.navigate().to(urlHome);
		if(user.equals("admin")){
			userName = rxml.data("smokeUserName");
			//password = rxml.data("smokeAlternatePassword");
		}else{
			userName = rxml.data("smokeEmail");
			changePassword = rxml.data("smokeChangePassword");
			alternatePassword = rxml.data("smokePassword");
		}
		
		try{
			if(isPasswordChanged()){
				waitForElementPresent(xpath(ObjectReference.smokeBtnLogin_xp));
				click(xpath(ObjectReference.smokeBtnLogin_xp));
				
				waitForElementPresent(xpath(ObjectReference.smokeUserNameLogin_xp));
				type(xpath(ObjectReference.smokeUserNameLogin_xp), userName);
				
				waitForElementPresent(xpath(ObjectReference.smokePasswordLogin_xp));
				type(xpath(ObjectReference.smokePasswordLogin_xp), changePassword);
				
				waitForElementPresent(xpath(ObjectReference.smokeBtnSubmitLogin_xp));
				click(xpath(ObjectReference.smokeBtnSubmitLogin_xp));
				
				waitForElementPresent(xpath(ObjectReference.smokeBtnMyAccount_xp));
			}else{
				waitForElementPresent(xpath(ObjectReference.smokeBtnLogin_xp));
				click(xpath(ObjectReference.smokeBtnLogin_xp));
				waitForElementPresent(xpath(ObjectReference.smokeUserNameLogin_xp));
				type(xpath(ObjectReference.smokeUserNameLogin_xp), userName);
				waitForElementPresent(xpath(ObjectReference.smokePasswordLogin_xp));
				type(xpath(ObjectReference.smokePasswordLogin_xp), alternatePassword);
				waitForElementPresent(xpath(ObjectReference.smokeBtnSubmitLogin_xp));
				click(xpath(ObjectReference.smokeBtnSubmitLogin_xp));
				waitForElementPresent(xpath(ObjectReference.smokeBtnMyAccount_xp));
			}

			
			
			pass("login");
		}catch(Exception e){
			takeScreenshot();
			fail("login");
		}
	}
	
	public void checkOut() throws Exception{
		try{
			if(environment.equals("prod")){
				if(isLoggedin()){
					driver.navigate().to(urlHome);
					waitForElementPresent(xpath(ObjectReference.smokeBtnGoToCart_xp));
					click(xpath(ObjectReference.smokeBtnGoToCart_xp));
					waitForElementPresent(xpath(ObjectReference.smokeTxtPromoCode_xp));
					type(xpath(ObjectReference.smokeTxtPromoCode_xp), "victorytr");
					waitForElementPresent(xpath(ObjectReference.smokeBtnPayNow_xp));
					click(xpath(ObjectReference.smokeBtnPromoCode_xp));
					waitForElementPresent(xpath(ObjectReference.smokePurchasedSuccessful_xp));
					Assert.assertTrue(verifyTextPresent("Your order has been successfully completed."));
					pass("Successfully purchased!");
				}else{
					driver.navigate().to(urlHome);
					waitForElementPresent(xpath(ObjectReference.smokeBtnGoToCart_xp));
					click(xpath(ObjectReference.smokeBtnGoToCart_xp));
					waitForElementPresent(xpath(ObjectReference.smokeGuest_xp));
					type(xpath(ObjectReference.smokeGuest_xp), email);
					waitForElementPresent(xpath(ObjectReference.smokeTxtPromoCode_xp));
					type(xpath(ObjectReference.smokeTxtPromoCode_xp), "victorytr");
					waitForElementPresent(xpath(ObjectReference.smokeBtnPayNow_xp));
					click(xpath(ObjectReference.smokeBtnPromoCode_xp));
					waitForElementPresent(xpath(ObjectReference.smokePurchasedSuccessful_xp));
					Assert.assertTrue(verifyTextPresent("Your order has been successfully completed."));
					pass("Successfully purchased!");
				}
				
			}else{
				if(isLoggedin()){
					waitForElementPresent(xpath(ObjectReference.smokeCardName_xp));
					type(xpath(ObjectReference.smokeCardName_xp), firstName);
					type(xpath(ObjectReference.smokeCardNumber_xp), cardNumber);
					type(xpath(ObjectReference.smokeSecurityCode_xp), securityCode);
					waitForElementPresent(xpath(ObjectReference.smokeBtnPayNow_xp));
					click(xpath(ObjectReference.smokeBtnPayNow_xp));
					waitForElementPresent(xpath(ObjectReference.smokePurchasedSuccessful_xp));
					Assert.assertTrue(verifyTextPresent("Your order has been successfully completed."));
					pass("Successfully purchased!");
				}else{
					waitForElementPresent(xpath(ObjectReference.smokeGuest_xp));
					type(xpath(ObjectReference.smokeGuest_xp), email);
					waitForElementPresent(xpath(ObjectReference.smokeCardName_xp));
					type(xpath(ObjectReference.smokeCardName_xp), firstName);
					type(xpath(ObjectReference.smokeCardNumber_xp), cardNumber);
					type(xpath(ObjectReference.smokeSecurityCode_xp), securityCode);
					waitForElementPresent(xpath(ObjectReference.smokeBtnPayNow_xp));
					click(xpath(ObjectReference.smokeBtnPayNow_xp));
					waitForElementPresent(xpath(ObjectReference.smokePurchasedSuccessful_xp));
					Assert.assertTrue(verifyTextPresent("Your order has been successfully completed."));
					pass("Successfully purchased!");
				}
			}
		}catch(Exception e){
			takeScreenshot();
			
		}
	}
	
	
	
	
	
	public boolean isLoggedin() throws Exception{
		try{
			Assert.assertTrue(verifyTextPresent("LOGIN"));
			return false;
		}catch(Exception e){
			
			return true;
		}
		catch(AssertionError e){
			return true;
		}
	}
	
	public void verifyPurchasedReport() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnMyAccount_xp));
			click(xpath(ObjectReference.smokeBtnMyAccount_xp));
			Assert.assertTrue(verifyTextPresent("Suburb Sales Map Subscription"));
			
		}catch(Exception e){
			
			takeScreenshot();
			
		}
	}
	
	public void changePassword() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnMyAccount_xp));
			click(xpath(ObjectReference.smokeBtnMyAccount_xp));
			
			waitForElementPresent(xpath(ObjectReference.smokeBtnMyDetails_xp));
			click(xpath(ObjectReference.smokeBtnMyDetails_xp));
			
			waitForElementPresent(xpath(ObjectReference.smokeBtnChangePassword_xp));
			click(xpath(ObjectReference.smokeBtnChangePassword_xp));
			type(xpath(ObjectReference.smokeChangePassword_xp), changePassword);
			type(xpath(ObjectReference.smokeRePassword_xp), changePassword);
			
			waitForElementPresent(xpath(ObjectReference.smokeBtnUpdate_xp));
			click(xpath(ObjectReference.smokeBtnUpdate_xp));
			Thread.sleep(1000);
			setPasswordChanged(true);
			
			waitForElementPresent(xpath(ObjectReference.smokeBtnLogout_xp));
			click(xpath(ObjectReference.smokeBtnLogout_xp));
			
			pass("19. FORGOTTEN PASSWORD [Verify that password can be reset via the Forgotten Password Form]");
		}catch(Exception e){
			fail("changePassword");
			takeScreenshot();
		}
	}
	
	public void logout() throws Exception{
		try{
			if(isLoggedin()){
				waitForElementPresent(xpath(ObjectReference.smokeBtnLogout_xp));
				click(xpath(ObjectReference.smokeBtnLogout_xp));
				pass("06. LOGOUT [Verify that user can log out from myrp]");
			}
		}catch(Exception e){
			takeScreenshot();
		}

	}
	
	
	public void checkHealth() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.smokeBtnAdmin_xp));
			click(xpath(ObjectReference.smokeBtnAdmin_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnHealthCheck_xp));
			click(xpath(ObjectReference.smokeBtnHealthCheck_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnCheckAllConnections_xp));
			click(xpath(ObjectReference.smokeBtnCheckAllConnections_xp));
			Thread.sleep(15000);
			
			pass("Checking Database Connection");
			try{
				
				Assert.assertTrue(verifyTextPresent("Database connection is OK."));
				pass("Database Connection OK!");
				
			}catch(AssertionError e){
				fail("Database Connection failed!");
			}
			
			pass("Checking BSG Connection");
			try{
				Assert.assertTrue(verifyTextPresent("BSG connection is OK."));
				pass("BSG Connection OK!");
			}catch(AssertionError e){
				
				fail("BSG Connection Failed!");
			}
			
			pass("Checking BSG 3.0 Connection");
			try{
				Assert.assertTrue(verifyTextPresent("BSG 3.0 connection is OK."));
				pass("BSG 3.0 Connection OK!");
			}catch(AssertionError e){
				fail("BSG 3.0 Connection Failed!");
			}
			
			pass("Checking S3 Bucket access");
			try{
				Assert.assertTrue(verifyTextPresent("S3 Bucket access is OK."));
				pass("Checking S3 Bucket access is OK.!");
			}catch(AssertionError e){
				fail("Checking SS3 Bucket access Failed!");
			}
			
			pass("Checking Manage Reports S3 Bucket access");
			try{
				Assert.assertTrue(verifyTextPresent("Manage Reports S3 Bucket access is OK."));
				pass("Checking Manage Reports S3 Bucket access is OK.!");
			}catch(AssertionError e){
				fail("Checking Manage Reports S3 Bucket access Failed!");
			}
			
			pass("Checking Access to Payment Gateway");
			try{
				Assert.assertTrue(verifyTextPresent("Access to Payment Gateway is OK."));
				pass("Access to Payment Gateway OK!");
				
			}catch(AssertionError e){
				fail("Access to Payment Gateway failed!");
			}
			
			pass("Checking Vision6 connection");
			try{
				Assert.assertTrue(verifyTextPresent("Vision6 connection is OK."));
				pass("Checking Vision6 connection is OK.!");
			}catch(AssertionError e){
				fail("Checking Vision6 connection failed!");
			}
			
			pass("Checking Access to RPConnect");
			try{
				Assert.assertTrue(verifyTextPresent("Access to RPConnect is OK."));
				pass("Checking Access to RPConnect OK!");
			}catch(AssertionError e){
				fail("Checking Access to RPConnect failed!");
			}
			
			pass("Checking Access to Cordell");
			try{
				Assert.assertTrue(verifyTextPresent("Access to Cordell API is OK."));
				pass("Checking Access to Cordell OK!");
			}catch(AssertionError e){
				fail("Checking Access to Cordell failed!");
			}
			
			pass("Checking Statistics API Connection");
			try{
				Assert.assertTrue(verifyTextPresent("Statistics API Connection is OK."));
				pass("Checking Statistics API Connection is OK.!");
			}catch(AssertionError e){
				fail("Checking Statistics API Connection failed!");
			}
			
			pass("Checking CPS");
			try{
				Assert.assertTrue(verifyTextPresent("CPS is OK."));
				pass("Checking CPS is OK.!");
			}catch(AssertionError e){
				fail("Checking CPS failed!");
			}
			
			pass("01. HEALTH CHECK - Checking HealthCheck Done!");
			
			
		}catch(Exception e){
			takeScreenshot();
			
		}
	}
	
	
	public void buyLJHookerEstimatedValueReport() throws Exception{
		try{
			String url = urlHome + "/n/myrp-557";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/n/myrp-557");
//			driver.navigate().to("http://awsdev.myrp.com.au/n/myrp-557");
//		   driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/n/myrp-557");
			waitForElementPresent(xpath(ObjectReference.smokeBtnBuyLJHookerReport_xp));
			click(xpath(ObjectReference.smokeBtnBuyLJHookerReport_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnLJHookerContinueBuying_xp));
			click(xpath(ObjectReference.smokeBtnLJHookerContinueBuying_xp));
			type(xpath(ObjectReference.smokeSearchLJHooker_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnLJHookerFindProperty_xp));
			waitForElementPresent(xpath(ObjectReference.smokeLJHookerCboxWrapper_xp));
			
		}catch(Exception e){
			takeScreenshot();
			
		}
	}
	
	public void buyNetBankDetailedPropertyReport() throws Exception{
		try{
			String url = urlHome + "/n/myrp-554";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/n/myrp-554");
//			driver.navigate().to("http://awsdev.myrp.com.au/n/myrp-554");
//			driver.navigate().to("http://myrp:myrp999@netbank-stage.myrp.com.au/n/myrp-554");
			waitForElementPresent(xpath(ObjectReference.smokeBtnBuyLJHookerReport_xp));
			click(xpath(ObjectReference.smokeBtnBuyLJHookerReport_xp));
			type(xpath(ObjectReference.smokeSearchLJHooker_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnLJHookerFindProperty_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnNetBankAddToCart_xp));
			click(xpath(ObjectReference.smokeBtnNetBankAddToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnGoToCart_xp));
			click(xpath(ObjectReference.smokeBtnGoToCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeCartLabel_xp));
			Assert.assertTrue(verifyTextPresent("Detailed Property Report"));
			
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	public void getNetbankBuyOrRent() throws Exception{
		try{
			String url = urlHome + "/cbabuyorrent";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/cbabuyorrent");
//			driver.navigate().to("http://awsdev.myrp.com.au/cbabuyorrent");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/cbabuyorrent");
			waitForElementPresent(xpath(ObjectReference.smokeEmailLead_xp));
			type(xpath(ObjectReference.smokeEmailLead_xp), email);
			waitForElementPresent(xpath(ObjectReference.smokeTickAppointment_xp));
			click(xpath(ObjectReference.smokeTickAppointment_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBrokerName_xp));
			type(xpath(ObjectReference.smokeBrokerName_xp), firstName);
			type(xpath(ObjectReference.smokeBrokerContactNumber_xp), contactNumber);
			type(xpath(ObjectReference.smokeBrokerSuburb_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBrokerGetReport_xp));
			Thread.sleep(5000);
			Assert.assertTrue(verifyTextPresent("Thank you. Your reports have been emailed. Depending on your internet connection they may take up to 10 minutes to arrive. You may also need to check your junk mail folder."));
			
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	public void getRatesonlineBuyOrRent() throws Exception{
		try{
			String url = urlHome + "/investorsguide";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/investorsguide");
//			driver.navigate().to("http://awsdev.myrp.com.au/investorsguide");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/investorsguide");
			waitForElementPresent(xpath(ObjectReference.smokeEmailLead_xp));
			type(xpath(ObjectReference.smokeEmailLead_xp), email);
			click(xpath(ObjectReference.smokeBrokerGetReport_xp));
			Thread.sleep(5000);
			Assert.assertTrue(verifyTextPresent("Thank you. Your reports have been emailed. Depending on your internet connection they may take up to 10 minutes to arrive. You may also need to check your junk mail folder."));
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	public void getMeBankBuyOrRent() throws Exception {
		try{
			String url = urlHome + "/meinvestorsguide";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/meinvestorsguide");
//			driver.navigate().to("http://awsdev.myrp.com.au/meinvestorsguide");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/meinvestorsguide");
			waitForElementPresent(xpath(ObjectReference.smokeEmailLead_xp));
			type(xpath(ObjectReference.smokeEmailLead_xp), email);
			waitForElementPresent(xpath(ObjectReference.smokeTickAppointment_xp));
			click(xpath(ObjectReference.smokeTickAppointment_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBrokerName_xp));
			type(xpath(ObjectReference.smokeBrokerName_xp), firstName);
			type(xpath(ObjectReference.smokeBrokerContactNumber_xp), contactNumber);
			type(xpath(ObjectReference.smokeBrokerSuburb_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBrokerGetReport_xp));
			Thread.sleep(5000);
			Assert.assertTrue(verifyTextPresent("Thank you. Your reports have been emailed. Depending on your internet connection they may take up to 10 minutes to arrive. You may also need to check your junk mail folder."));
			
		}catch(Exception e){
			takeScreenshot();
		}
		
		
	}
	
	public void getSpringbuyerBuyOrRent() throws Exception {
		try{
			String url = urlHome + "/springbuyersguide";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/springbuyersguide");
//			driver.navigate().to("http://awsdev.myrp.com.au/springbuyersguide");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/springbuyersguide");
			waitForElementPresent(xpath(ObjectReference.smokeEmailLead_xp));
			type(xpath(ObjectReference.smokeEmailLead_xp), email);
			waitForElementPresent(xpath(ObjectReference.smokeTickAppointment_xp));
			click(xpath(ObjectReference.smokeTickAppointment_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBrokerName_xp));
			type(xpath(ObjectReference.smokeBrokerName_xp), firstName);
			type(xpath(ObjectReference.smokeBrokerContactNumber_xp), contactNumber);
			type(xpath(ObjectReference.smokeBrokerSuburb_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBrokerGetReport_xp));
			Thread.sleep(5000);
			Assert.assertTrue(verifyTextPresent("Thank you. Your reports have been emailed. Depending on your internet connection they may take up to 10 minutes to arrive. You may also need to check your junk mail folder."));
			
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	
	public void searchNabPropertyAddress() throws Exception {
		try{
			String url = urlHome + "/nab";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/nab/");
//			driver.navigate().to("http://awsdev.myrp.com.au/nab/");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/nab/");
			waitForElementPresent(xpath(ObjectReference.smokeNabSearchLine_xp));
			type(xpath(ObjectReference.smokeNabSearchLine_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnNabSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeNabStreetAddress_xp));
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	
	public void verifyPlanKeepShoppingLink()throws Exception{
		try{
			String url = urlHome + "/plan";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/plan");
//			driver.navigate().to("http://awsdev.myrp.com.au/plan");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/plan");
			waitForElementPresent(xpath(ObjectReference.smokeBtnMyCart_xp));
			click(xpath(ObjectReference.smokeBtnMyCart_xp));
			click(xpath(ObjectReference.smokeBtnKeepShopping));
			Thread.sleep(2000);
			Assert.assertTrue(verifyTextPresent("Interested in finding out more?"));
			
			
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	public void verifyFastKeepShoppingLink()throws Exception{
		try{
			String url = urlHome + "/fast";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/fast");
//			driver.navigate().to("http://awsdev.myrp.com.au/fast");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/fast");
//			waitForElementPresent(xpath(smokeBtnMyCart_xp));
			click(xpath(ObjectReference.smokeBtnMyCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnGetThisFreeClose_xp));
			click(xpath(ObjectReference.smokeBtnGetThisFreeClose_xp));
			click(xpath(ObjectReference.smokeBtnKeepShopping));
			Thread.sleep(2000);
			Assert.assertTrue(verifyTextPresent("Interested in finding out more?"));
			
			
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	public void verifyChoiceKeepShoppingLink()throws Exception{
		try{
			String url = urlHome + "/choice";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/choice");
//			driver.navigate().to("http://awsdev.myrp.com.au/choice");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/choice");
			waitForElementPresent(xpath(ObjectReference.smokeBtnMyCart_xp));
			click(xpath(ObjectReference.smokeBtnMyCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnGetThisFreeClose_xp));
			click(xpath(ObjectReference.smokeBtnGetThisFreeClose_xp));
			click(xpath(ObjectReference.smokeBtnKeepShopping));
			Thread.sleep(2000);
			Assert.assertTrue(verifyTextPresent("Interested in finding out more?"));
			
			
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	public void verifyPeoplesChoiceKeepShoppingLink() throws Exception{
		try{
			String url = urlHome + "/peopleschoice";
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod.myrp.com.au/peopleschoice");
//			driver.navigate().to("http://awsdev.myrp.com.au/peopleschoice");
//			driver.navigate().to("http://myrp:myrp999@stage.myrp.com.au/peopleschoice");
			waitForElementPresent(xpath(ObjectReference.smokeBtnMyCart_xp));
			click(xpath(ObjectReference.smokeBtnMyCart_xp));
			waitForElementPresent(xpath(ObjectReference.smokeBtnGetThisFreeClose_xp));
			click(xpath(ObjectReference.smokeBtnGetThisFreeClose_xp));
			click(xpath(ObjectReference.smokeBtnKeepShopping));
			Thread.sleep(2000);
			Assert.assertTrue(verifyTextPresent("Interested in finding out more?"));
			
			
			
		}catch(Exception e){
			takeScreenshot();
		}
	}
	
	
	public void verifySearchPropertyValue() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "propertyvalue.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "propertyvalue-stage.myrp.com.au";
			}else{
				url = "propertyvalue-dev.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod-propertyvalue.myrp.com.au");
//			driver.navigate().to("http://awsdev-propertyvalue.myrp.com.au");
//			driver.navigate().to("http://myrp:myrp999@propertyvalue-stage.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			fail("verifySearchPropertyValue()");
		}
	}
	
	public void verifySearchNetBank() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "netbank.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "netbank-stage.myrp.com.au";
			}else{
				url = "netbank-dev.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://myrp:myrp999@netbank-stage.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			e.printStackTrace();
			fail("verifySearchPropertyValue()");
		}
	}
	
	public void verifySearchNews() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "news.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "stage-news.myrp.com.au";
			}else{
				url = "dev-news.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod-netbank.myrp.com.au");
//			driver.navigate().to("http://awsdev-netbank.myrp.com.au");
//			driver.navigate().to("http://myrp:myrp999@stage-news.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			fail("verifySearchPropertyValue()");
		}
	}
	public void verifySearchHeraldSun() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "heraldsun.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "stage-heraldsun.myrp.com.au";
			}else{
				url = "dev-heraldsun.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod-heraldsun.myrp.com.au");
//			driver.navigate().to("http://awsdev-heraldsun.myrp.com.au");
//			driver.navigate().to("http://myrp:myrp999@stage-heraldsun.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			fail("verifySearchPropertyValue()");
		}
	}
	public void verifySearchCourierMail() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "couriermail.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "stage-couriermail.myrp.com.au";
			}else{
				url = "dev-couriermail.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod-couriermail.myrp.com.au");
//			driver.navigate().to("http://awsdev-couriermail.myrp.com.au");
//			driver.navigate().to("http://myrp:myrp999@stage-couriermail.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			fail("verifySearchPropertyValue()");
		}
	}
	public void verifySearchDailyTelegraph() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "dailytelegraph.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "stage-dailytelegraph.myrp.com.au";
			}else{
				url = "dev-dailytelegraph.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://awspreprod-dailytelegraph.myrp.com.au");
//			driver.navigate().to("http://awsdev-dailytelegraph.myrp.com.au");
//			driver.navigate().to("http://myrp:myrp999@stage-dailytelegraph.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			fail("verifySearchPropertyValue()");
		}
	}
	
	public void verifySearchAdelaidenow() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "adelaidenow.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "stage-adelaidenow.myrp.com.au";
			}else{
				url = "dev-adelaidenow.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://awsdev-adelaidenow.myrp.com.au");
//			driver.navigate().to("http://awspreprod-adelaidenow.myrp.com.au");
//			driver.navigate().to("http://myrp:myrp999@stage-adelaidenow.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			fail("verifySearchPropertyValue()");
		}
	}
	
	public void verifySearchPerthnow() throws Exception{
		try{
			String url = "";
			if(environment.equals("prod")){
				url = "perthnow.myrp.com.au";
			}else if(environment.equals("stage")){
				url = "stage-perthnow.myrp.com.au";
			}else{
				url = "dev-perthnow.myrp.com.au";
			}
			driver.navigate().to(url);
//			driver.navigate().to("http://awsdev-perthnow.myrp.com.au");
//			driver.navigate().to("http://myrp:myrp999@stage-perthnow.myrp.com.au");
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), propertyAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			Thread.sleep(3000);
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			Assert.assertTrue(verifyTextPresent("Here you can find everything you need to know about"));
			type(xpath(ObjectReference.smokeAddressSearch_xp), suburbAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), postCode);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			pass("verifySearchPropertyValue()");
		}catch(Exception e){
			takeScreenshot();
			fail("verifySearchPropertyValue()");
		}
	}
	
	
	public void verifyTextLinkAds() throws Exception {
		try{
			searchPropertyAddress();
			waitForElementPresent(xpath(ObjectReference.txtPropertyAdLink_xp));
			searchSuburb();	
			waitForElementPresent(xpath(ObjectReference.txtSuburbAdLink_xp));
			waitForElementPresent(xpath(ObjectReference.smokeAddressSearch_xp));
			type(xpath(ObjectReference.smokeAddressSearch_xp), streetAddress);
			click(xpath(ObjectReference.smokeBtnAddressSearch_xp));
			waitForElementPresent(xpath(ObjectReference.txtSuburbAdLink_xp));
			
			
		}catch(Exception e){
			takeScreenshot();
			fail("verify Text Link Ads");
		}
	}
	
	
	public void verifyInvestorInsights() throws Exception {
		try{
			
			
			
		}catch(Exception e){
			takeScreenshot();
			fail("verify Investor Insights failed..");
		}
	}
	
	public void verifyInvestorInsightText() throws Exception {
		String investorPhrase = "access our Investor Insight Tool and postcode reports";
		try{
			Assert.assertEquals(investorPhrase, xpath(ObjectReference.txtInvestor_xp));
			
		}catch(Exception e){
			takeScreenshot();
		}catch(AssertionError e){
			takeScreenshot();
			e.printStackTrace();
		}
	}
	
	public void verifyInvestorImage() throws Exception{
		try{
			waitForElementPresent(xpath(ObjectReference.imgInvestorLink_xp));
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyInvestorLinkExists() throws Exception {
		try{
			waitForElementPresent(xpath(ObjectReference.txtInvestorLink_xp));
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void verifyInvestorInLandingPage() throws Exception {
		try{
			searchSuburb();
			waitForElementPresent(xpath(ObjectReference.btnInvestorLandingPage_xp));
			click(xpath(ObjectReference.btnInvestorLandingPage_xp));
			verifyInvestorInLandingPageIntroText();
			verifyInvestorInLandingPagePurchaseButton();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyInvestorInLandingPageIntroText() throws Exception {
		try{
			waitForElementPresent(xpath(ObjectReference.txtIntroInvestorLandingPage_xp));
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyInvestorInLandingPagePurchaseButton() throws Exception {
		try{
			waitForElementPresent(xpath(ObjectReference.btnPurchaseInvestorLandingPage_xp));
			Thread.sleep(1000);
			click(xpath(ObjectReference.btnPurchaseInvestorLandingPage_xp));
		}catch(Exception e){
			
		}
	}
	
	
	
	
	
	public boolean verifyLandingPagesUrl() {
		try{
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError ex){
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyEstimatedValueLandingPageUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnPropertyPages_xp));
			click(xpath(ObjectReference.btnPropertyPages_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Estimated-Value-Report/myrp-537";
			String actualTitle = driver.getTitle();
			String expectedTitle = "EstimatedValueReport";
			if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedTitle)){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyEstimatedValueSubscriptionUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnPropertyPages_xp));
			click(xpath(ObjectReference.btnPropertyPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownEstimatedValueSubscription_xp));
			click(xpath(ObjectReference.btnCutdownEstimatedValueSubscription_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Estimated-Value-Subscription/myrp-538";
			String actualTitle = driver.getTitle();
			String expectedTitle = "EstimatedValueSubscription";
			if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedTitle) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public boolean verifyDetailedPropertyReportUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnPropertyPages_xp));
			click(xpath(ObjectReference.btnPropertyPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownDetailedPropertyReport_xp));
			click(xpath(ObjectReference.btnCutdownDetailedPropertyReport_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Detailed-Property-Report/myrp-539";
			String actualTitle = driver.getTitle();
			String expectedTitle = "DetailedPropertyReport";
			if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedTitle) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyTitleDocumentUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnPropertyPages_xp));
			click(xpath(ObjectReference.btnPropertyPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownTitleDocument_xp));
			click(xpath(ObjectReference.btnCutdownTitleDocument_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Title-Document/myrp-540";
			String actualTitle = driver.getTitle();
			String expectedTitle = "TitleDocument";
			if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedTitle) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean verifySalesHistoryReportUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnPropertyPages_xp));
			click(xpath(ObjectReference.btnPropertyPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownSalesHistory_xp));
			click(xpath(ObjectReference.btnCutdownSalesHistory_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Sales-History-Report/myrp-941";
			String actualTitle = driver.getTitle();
			String expectedTitle = "SalesHistoryReport";
			if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedTitle) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyDesktopValuationUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnServicesPages_xp));
			click(xpath(ObjectReference.btnServicesPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownDesktopValuationUrl_xp));
			click(xpath(ObjectReference.btnCutdownDesktopValuationUrl_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "n/Desktop-Valuation/myrp-541";
			if(actualUrl.equals(expectedUrl)){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyShortFormUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnServicesPages_xp));
			click(xpath(ObjectReference.btnServicesPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownShortForm_xp));
			click(xpath(ObjectReference.btnCutdownShortForm_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Short-Form-Valuation/myrp-542";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyLongFormUrl(){
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnServicesPages_xp));
			click(xpath(ObjectReference.btnServicesPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownLongForm_xp));
			click(xpath(ObjectReference.btnCutdownLongForm_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Long-Form-Valuation/myrp-543";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyAgentsValuersBrokersUrl(){
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnServicesPages_xp));
			click(xpath(ObjectReference.btnServicesPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownLongForm_xp));
			click(xpath(ObjectReference.btnCutdownLongForm_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Agents,-Valuers-and-Brokers/myrp-544";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public boolean verifyStreetPageUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnStreetPage_xp));
			click(xpath(ObjectReference.btnStreetPage_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Street-Sales-Report/myrp-549";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyFreeSuburbProfileUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnSuburbPages_xp));
			click(xpath(ObjectReference.btnSuburbPages_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Free-Suburb-Profile/myrp-545";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifySuburbSalesReportUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnSuburbPages_xp));
			click(xpath(ObjectReference.btnSuburbPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownSuburbSalesReport_xp));
			click(xpath(ObjectReference.btnCutdownSuburbSalesReport_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Suburb-Sales-Report/myrp-546";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifySuburbSalesMapSubscriptionUrl() {
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnSuburbPages_xp));
			click(xpath(ObjectReference.btnSuburbPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownSuburbSalesMapSubscription_xp));
			click(xpath(ObjectReference.btnCutdownSuburbSalesMapSubscription_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Suburb-Sales-Map-Subscription/myrp-547";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifySuburbValueMapSubscriptionUrl(){
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnSuburbPages_xp));
			click(xpath(ObjectReference.btnSuburbPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownSuburbValueMapSubscription_xp));
			click(xpath(ObjectReference.btnCutdownSuburbValueMapSubscription_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Suburb-Value-Map-Subscription/myrp-548";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean verifyRentalInsightReport(){
		try{
			driver.navigate().to(urlHome);
			waitForElementPresent(xpath(ObjectReference.btnSuburbPages_xp));
			click(xpath(ObjectReference.btnSuburbPages_xp));
			waitForElementPresent(xpath(ObjectReference.btnCutdownRentalInsightReport_xp));
			click(xpath(ObjectReference.btnCutdownRentalInsightReport_xp));
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = urlHome + "/n/Rental-Insights-Report/myrp-591";
			if(actualUrl.equals(expectedUrl) ){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean verifyWestpacReport(){
		String promoCode = "victorytr";
		String address = "75 maxwell street south turramurra nsw 2074";
		try{
			
			driver.navigate().to(urlHome + "/westpac");
			waitForElementPresent(xpath(ObjectReference.westpacTxtPromoCode_xp));
			type(xpath(ObjectReference.westpacTxtPromoCode_xp), promoCode);
			click(xpath(ObjectReference.westpacBtnPromoCode_xp));
			waitForElementPresent(xpath(ObjectReference.westpacTxtSlas_xp));
			type(xpath(ObjectReference.westpacTxtSlas_xp), address);
			click(xpath(ObjectReference.westpacBtnSearch_xp));
			waitForElementPresent(xpath(ObjectReference.westpacBtnPurchase_xp));
			click(xpath(ObjectReference.westpacBtnPurchase_xp));
			fillupWestpacLeadForm();
			
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void fillupWestpacLeadForm(){
		String firstName = "";
		String lastName = "";
		String email = "";
		String phoneNumber = "";
		String postCode = "";
		try{
			waitForElementPresent(xpath(ObjectReference.westpacTxtFirstName_xp));
			type(xpath(ObjectReference.westpacTxtFirstName_xp), firstName);
			type(xpath(ObjectReference.westpacTxtLastName_xp), lastName);
			type(xpath(ObjectReference.westpacTxtEmail_xp), lastName);
			type(xpath(ObjectReference.westpacTxtPhoneNumber_xp), phoneNumber);
			type(xpath(ObjectReference.westpacTxtPostCode_xp), postCode);
			type(xpath(ObjectReference.westpacTxtPostCode_xp), email);
			Thread.sleep(1000);
			click(xpath(ObjectReference.westpacBtnIAgree_xp));
			click(xpath(ObjectReference.westpacBtnSubmit_xp));
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
	}
	
	
	
	
	

	public boolean isPasswordChanged() {
		return isPasswordChanged;
	}

	public void setPasswordChanged(boolean isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}


	public String getUrlHome() {
		return urlHome;
	}

	public void setUrlHome(String urlHome) {
		this.urlHome = urlHome;
	}

	public String getUrlPropertyValue() {
		return urlPropertyValue;
	}

	public void setUrlPropertyValue(String urlPropertyValue) {
		this.urlPropertyValue = urlPropertyValue;
	}

	public String getUrlNetBank() {
		return urlNetBank;
	}

	public void setUrlNetBank(String urlNetBank) {
		this.urlNetBank = urlNetBank;
	}

	public String getUrlVerifySearchNews() {
		return urlVerifySearchNews;
	}

	public void setUrlVerifySearchNews(String urlVerifySearchNews) {
		this.urlVerifySearchNews = urlVerifySearchNews;
	}

	public String getUrlSearchHeraldSun() {
		return urlSearchHeraldSun;
	}

	public void setUrlSearchHeraldSun(String urlSearchHeraldSun) {
		this.urlSearchHeraldSun = urlSearchHeraldSun;
	}

	public String getUrlVerifySearchCourierMail() {
		return urlVerifySearchCourierMail;
	}

	public void setUrlVerifySearchCourierMail(String urlVerifySearchCourierMail) {
		this.urlVerifySearchCourierMail = urlVerifySearchCourierMail;
	}

	public String getUrlVerifySearchDailyTelegraph() {
		return urlVerifySearchDailyTelegraph;
	}

	public void setUrlVerifySearchDailyTelegraph(
			String urlVerifySearchDailyTelegraph) {
		this.urlVerifySearchDailyTelegraph = urlVerifySearchDailyTelegraph;
	}

	public String getUrlVerifySearchAdelaidenow() {
		return urlVerifySearchAdelaidenow;
	}

	public void setUrlVerifySearchAdelaidenow(String urlVerifySearchAdelaidenow) {
		this.urlVerifySearchAdelaidenow = urlVerifySearchAdelaidenow;
	}

	public String getUrlVerifySearchPerthnow() {
		return urlVerifySearchPerthnow;
	}

	public void setUrlVerifySearchPerthnow(String urlVerifySearchPerthnow) {
		this.urlVerifySearchPerthnow = urlVerifySearchPerthnow;
	}
	
	
}
