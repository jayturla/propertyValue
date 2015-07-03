package myrp.utilities;


import static org.openqa.selenium.By.xpath;

import java.io.IOException;
import java.util.List;

import myrp.library.FunctionReference;
import myrp.library.MYRPObjectReferenceRT_07810;
import myrp.library.ObjectReference;
import myrp.library.ObjectReferenceSmoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class MYRPSmoketestUtil extends FunctionReference {
	
	private String[] input = null;
	
	public MYRPSmoketestUtil(String[] i) {
			input = i;
	}
		
	public void clickSignUp() throws Exception{
		waitForElementPresent(xpath(ObjectReferenceSmoketest.signUp ));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.signUp)));
		click(xpath(ObjectReferenceSmoketest.signUp));
		waitForElementPresent(xpath(ObjectReferenceSmoketest.firstName));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.firstName)));
		System.out.println("Sign Up Pop up appeared");
		
	}

	  public void firstnameSignUp() throws Exception{
	    waitForElementPresent(xpath(ObjectReferenceSmoketest.firstName));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.firstName)));
		type(xpath(ObjectReferenceSmoketest.firstName), input[0]);
		System.out.println("First name entered");
	
	}
	
	  public void lastnameSignUp() throws Exception{
		waitForElementPresent(xpath(ObjectReferenceSmoketest.lastName));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.lastName)));
		type(xpath(ObjectReferenceSmoketest.lastName), input[1]);
		System.out.println("Last name entered");
	
	}

	 public void emailSignUp() throws Exception{
		waitForElementPresent(xpath(ObjectReferenceSmoketest.email));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.email)));
		type(xpath(ObjectReferenceSmoketest.email), input[2]);
		System.out.println("Email entered");
	}
	
	 public void confirmEmailSignUp() throws Exception{
		waitForElementPresent(xpath(ObjectReferenceSmoketest.confirmMail));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.confirmMail)));
		type(xpath(ObjectReferenceSmoketest.confirmMail), input[3]);
		System.out.println("Email Confirmed");
	}
	 
	 public void passwordSignUp() throws Exception{
	    waitForElementPresent(xpath(ObjectReferenceSmoketest.password));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.password)));
		type(xpath(ObjectReferenceSmoketest.password), input[4]);
		System.out.println("Password Entered");

	 }
	 public void confirmPasswordSignUp() throws Exception{
			waitForElementPresent(xpath(ObjectReferenceSmoketest.confirmPassword));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.confirmPassword)));
			type(xpath(ObjectReferenceSmoketest.confirmPassword), input[5]);
			System.out.println("Password Confirmed");
	 }

	 public void securityQuestionSignUp() throws Exception{
	    waitForElementPresent(xpath(ObjectReferenceSmoketest.securityQuestion));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.securityQuestion)));
		type(xpath(ObjectReferenceSmoketest.securityQuestion), input[6]);
		System.out.println("Security Question");
	 }

	 public void confirmsecurityQuestionSignUp() throws Exception{
		waitForElementPresent(xpath(ObjectReferenceSmoketest.confirmSecuritQuestion));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.confirmSecuritQuestion)));
		type(xpath(ObjectReferenceSmoketest.confirmSecuritQuestion), input[7]);
		System.out.println("Security Question Confirm");
	 }	 

	 public void acceptTermsSignUp() throws Exception{
			waitForElementPresent(xpath(ObjectReferenceSmoketest.acceptTerms));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.acceptTerms)));
			click(xpath(ObjectReferenceSmoketest.acceptTerms));
			System.out.println("Terms Accepted");
			
		 	 }

	
	 public void userName() throws Exception{
		 	log("ENtering Username");
		 	try {
				waitForElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin));
				Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin)));
				type(xpath(ObjectReferenceSmoketest.usernameLogin), input[2]);
				System.out.println("User name Entered");
			} catch (AssertionError e) {
				fail("Unable to locate Element username");
			}
	 }

	 
	 public void passwordLogin() throws Exception{
		 	waitForElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin)));
			type(xpath(ObjectReferenceSmoketest.passwordLogin), input[4]);
			System.out.println("Password Entered");
	 }
	 
	 public boolean loginButton() throws Exception{
		 boolean success = false;
		 log ("Preparing to Click Login Button");
		 
		 	try {
				waitForElementPresent(xpath(ObjectReferenceSmoketest.LoginRedbutton));
				Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.LoginRedbutton)));
				click(xpath(ObjectReferenceSmoketest.LoginRedbutton));
				Thread.sleep(3000);
				System.out.println("Login Button Clicked");
			} catch (Exception e) {
				fail("Was not Able to Click Login Button");
				
			}
		return success;
		 
	 }
	 
	 public boolean estimatedValueSubricption() throws Exception{
		boolean success = false;
		System.out.println("Search Address Via CFA");

		try {
			if(login()){
				userName();
				passwordLogin();
				loginButton();
				clickCFAButton();
				enterUnitnumber();
				enterStreetname();
				selectInAjax();
				clickAddtoCartButton(3);
				gotoMyCart();
				payViaMerchant();
				if(successPayment()){ 
					success  = true;
				}
			}
		} catch (AssertionError e) {
			fail("Report was Not Purchased!!");
		}
		return success;
				
	}
	 
	public boolean successPayment() throws Exception{
		boolean success = false;
		log("Click Login Button");
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.purchaseSuccess));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.purchaseSuccess)));
			click(xpath(ObjectReferenceSmoketest.purchaseSuccess));
			System.out.println("Page Directs to Seccessful Purchase page");
			success = true;
		} catch (AssertionError e) {
			fail("Was not able to Direct to Purchase Page");
		}
		return success;
	}
	 
	 public boolean login() throws Exception{
		 boolean success = false;
		 log("Click Login Button");
			try {
				waitForElementPresent(xpath(ObjectReferenceSmoketest.loginButton));
				Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.loginButton)));
				click(xpath(ObjectReferenceSmoketest.loginButton));
				System.out.println("Login pop up appears");
				success = true;
			}catch (AssertionError e) {
				fail("Was not able to click Login Button");
			}
		 return success;
	 }
	 
	 
	 public void clickCFAButton()throws Exception{
		log("Prepareing to click CFA Button");
		try{
			waitForElementPresent(xpath(ObjectReferenceSmoketest.cfaButton));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.cfaButton)));
			click(xpath(ObjectReferenceSmoketest.cfaButton));
			
			log("Succesfully Click CFA BUtton");
			Thread.sleep(2000);
			
		}catch(AssertionError e){
			fail("Unable to locate element CFA Button");
		}
	}

	public void enterUnitnumber()throws Exception{
		log("Entering unit number");
		try{
			waitForElementPresent(xpath(ObjectReferenceSmoketest.unitNumber));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.unitNumber)));
			type(xpath(ObjectReferenceSmoketest.unitNumber), input[8]);
			
		}catch (AssertionError e){
			fail("unable to Enter Unit Number");
	
	}
	
 }

	public void enterStreetname()throws Exception{
		log("Entering Street name");
		try{ 
			waitForElementPresent(xpath(ObjectReferenceSmoketest.streetName));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.streetName)));
			type(xpath(ObjectReferenceSmoketest.streetName), input[9]);	
			Thread.sleep(2000);
			
		}catch (AssertionError e){
			fail("unable to enter street name");
	  }		

   }	
	
	public void selectInAjax()throws Exception{ 
		log("was able to Select in Ajax");
		try{
			waitForElementPresent(xpath(ObjectReferenceSmoketest.ajaxCFA));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.ajaxCFA)));
			click(xpath(ObjectReferenceSmoketest.ajaxCFA));
		
		
		}catch (AssertionError e){
			
	 }
	
	
	
  }

	public void clickAddtoCartButton(int numberOfButton)throws Exception{
		
		String purchaseButton = "(//*[@id='purchaseButton'])["+numberOfButton+"]";
		log("Preparing to Add To Cart");
		try{
			waitForElementPresent(xpath(purchaseButton));
			Assert.assertTrue(isElementPresent(xpath(purchaseButton)));
			click(xpath(purchaseButton));
			log("Report was added to Cart");
			
		}catch (AssertionError e){
			fail("Report Was not Added to Cart!!!");
		}

	
	}	
	
	
	public void gotoMyCart()throws Exception{
		log ("Go to my Cart");
		try{
			waitForElementPresent(xpath(ObjectReferenceSmoketest.gotoMyCart));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.gotoMyCart)));
			click(xpath(ObjectReferenceSmoketest.gotoMyCart));
			log("My Cart Full page Fully Loads");
		}catch (AssertionError e){
			fail("My Card WAs not Able to Load");
			
		}		
	}
	 
	
	public void payViaMerchant()throws Exception{
		log("Preparing to Enter Payment Details");
	
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.merchantName));
			type(xpath(ObjectReferenceSmoketest.merchantName), input[10]);
			waitForElementPresent(xpath(ObjectReferenceSmoketest.merchantCard));
			type(xpath(ObjectReferenceSmoketest.merchantCard), input[12]);
			waitForElementPresent(xpath(ObjectReferenceSmoketest.merchantCode));
			type(xpath(ObjectReferenceSmoketest.merchantCode), input[13]);
			click(xpath(ObjectReferenceSmoketest.merchantPaynow));
			Thread.sleep(2000);
			log("Was able to Pay with Entered Details");
		} catch (AssertionError e) {
			 fail("was not Able to Pay!");
		}
		
		
		
	}
	
	public boolean loginDetailsExistingUser() throws Exception{
		boolean success = false;
		System.out.println("Login Patrick");
	
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.loginButton));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.loginButton)));
			click(xpath(ObjectReferenceSmoketest.loginButton));
			System.out.println("Login pop up appears");
			
			waitForElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin)));
			type(xpath(ObjectReferenceSmoketest.usernameLogin), input[14]);
			System.out.println("User name Entered");
			
			waitForElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin)));
			type(xpath(ObjectReferenceSmoketest.passwordLogin), input[15]);
			System.out.println("Password Entered");
			Thread.sleep(3000);
			success = true;
		}catch (AssertionError e) {
			fail("Details for Existing User is Entered");
		}
		return success;
	}


	public boolean clickAdminTab() throws Exception{ 
		boolean success = false;
		System.out.println("Preparing to Click Admin Button");
		
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.adminButton));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.adminButton)));
			Thread.sleep(1000);
			click(xpath(ObjectReferenceSmoketest.adminButton));
			Thread.sleep(2000);
			log("Was able to click login Button");
			success = true;
			
		}catch (AssertionError e) {
			fail("was not able to click Admin Tab");
			
		}
		return success;
		
	}
	
	
	
	public boolean clickHealthCheck() throws Exception{
		boolean success = false;
		log("healthCheck Clicked");
		
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.healthCheck));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.healthCheck)));
			click(xpath(ObjectReferenceSmoketest.healthCheck));
			Thread.sleep(2000);
		}catch (AssertionError e) {
			fail("Was not Able to click Health check");
			
		}
		return success;
	}

	
	public boolean clickAllConnections() throws Exception{
		boolean success = false;
		log("prepariong to Click all connections");
		
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.checkAllConnections));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.checkAllConnections)));
			click(xpath(ObjectReferenceSmoketest.checkAllConnections));
			Thread.sleep(2000);
		} catch (AssertionError e) {
			fail("Was not able to click All Connections");
			
		}
		 return success;
		
	}
	
	
	
	public boolean clickLogout() throws Exception{ 
	boolean success = false;
	log ("Preparing to Logout!");
	
	try {
		waitForElementPresent(xpath(ObjectReferenceSmoketest.logOutButton));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.logOutButton)));
		click(xpath(ObjectReferenceSmoketest.logOutButton));
		log("User has now Logged Out");
	} catch (AssertionError e) {
		fail("Logout Button not clicked");
		}
	
		return success;
		
	}
	
	
	 public boolean successfulHeakthCheck() throws Exception{
		boolean success = false;
		System.out.println("Waiting for Health Check Results");
		waitForElementPresent(xpath(ObjectReferenceSmoketest.healthCheckResults));
		Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.healthCheckResults)));

		List<WebElement> list = driver.findElements(By
				.xpath(ObjectReferenceSmoketest.healthCheckResults));
		
		String listVal;
		for (WebElement element : list) {
			listVal = element.getText();
			if (listVal.contains("Database connection is OK.") && listVal.contains("BSG connection is OK.") && listVal.contains("BSG 3.0 connection is OK.") && listVal.contains("S3 Bucket access is OK.") && listVal.contains("Manage Reports S3 Bucket access is OK.") && listVal.contains("Access to Payment Gateway is OK.") && listVal.contains("Vision6 connection is OK.") && listVal.contains("Access to RPConnect is OK.") && listVal.contains("Access to Cordell API is OK.") && listVal.contains("Access to Cordel API is OK.") && listVal.contains("Statistics API Connection is OK.") && listVal.contains("CPS is OK.")) {
				success = true;
				log("All Health Check Results are OK");
			}else {
				success = false;
				fail("One Health check Result has Failed");
				break;
			}
		}
		
		return success;
	 }
	
	
	 public boolean loginExistingUser() throws Exception{
			boolean success = false;
			System.out.println("Existing User was Able to Login");

			
			try {
				loginDetailsExistingUser();
				loginButton();
				clickAdminTab();		
				clickHealthCheck();
				clickAllConnections();
				if (successfulHeakthCheck()) {
					
					success = true;					
				
				}
				
			}catch (AssertionError e) {
				fail("Health Check Has Failed");
			}
			
			return success;
	 }
	 
	 
	 public boolean logoutUser() throws Exception{
			boolean success = false;
			System.out.println("Preparing to login User");
	 
			try {
				loginDetailsExistingUser();
				loginButton();
				String text = getText(xpath(ObjectReferenceSmoketest.patName));
				if (text.contains("Pat")) {
					success = true;
					log("Succesfully Patrick has Logged in");
					Thread.sleep(2000);
				} else {
					fail("Unable to Login Patrick");
				}
				clickLogout();
			} catch (Exception e) {
				fail ("User was not Able to Logout!");
			}
	 
	 
	 return success;
	 
	 
	 }
	 
	 
	public boolean preparetoLoginJohny() throws Exception {
		boolean success = false;
		System.out.println("Preparing to login Johnny");

		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.loginButton));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.loginButton)));
			click(xpath(ObjectReferenceSmoketest.loginButton));
			System.out.println("Login pop up appears");

			waitForElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin)));
			type(xpath(ObjectReferenceSmoketest.usernameLogin), input[2]);
			System.out.println("User name Entered");

			waitForElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin)));
			type(xpath(ObjectReferenceSmoketest.passwordLogin), input[4]);
			System.out.println("Password Entered");
			log("Details for Johnny is Entered");

		} catch (AssertionError e) {
			fail("Details for Johnny was Not Entered");

		}

		return success;
	 
	 }
	 
	public boolean clickSuburbReportsButton() throws Exception {
		boolean success = false;
		System.out.println("Preparing to click suburb Reports Button");

		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.suburbReportsButton));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.suburbReportsButton)));
			click(xpath(ObjectReferenceSmoketest.suburbReportsButton));
			Thread.sleep(2000);
			log("Was able to Click Suburb Reports Button");

			waitForElementPresent(xpath(ObjectReferenceSmoketest.suburbReportsLabel));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.suburbReportsLabel)));
			String text = getText(xpath(ObjectReferenceSmoketest.suburbReportsLabel));

			if (text.contains("Suburb Reports")) {
				success = true;
				log("Succesfully Visit the Suburb Reports Tab");
				Thread.sleep(2000);
			} else {
				fail("Unable to locate Element Suburb Reports Tab");
			}
			
		} catch (AssertionError e) {
			fail("Was Not Able to click Suburb Reports Button");
		}

		return success;

	}

	
	public boolean searchSurryHills() throws Exception {
		boolean success = false;
		System.out.println("Preparing to Search in Slas");
	
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.slasField));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.slasField)));
			type(xpath(ObjectReferenceSmoketest.slasField), input[16]);
			Thread.sleep(900);
			log("Surry Hills Entered in SLAS");
			
		} catch (AssertionError e) {
			 fail("Was not Able to Enter Surry Hills");
		}
		return success;

	
	}
		
	
	public boolean selectinSLAS() throws Exception {
		boolean success = false;
		System.out.println("Preparing to Select address in Slas");

		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.selectajax));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.selectajax)));
			click(xpath(ObjectReferenceSmoketest.selectajax));
			Thread.sleep(2000);
			log("Was Able to Select Address in Slas");
			
			
		} catch (AssertionError e) {
			fail("Was Not Able to Select in SLAS");
		}

		return success;
	}

	
	
	public boolean addSuburbSaleshistory() throws Exception {
		boolean success = false;
		System.out.println("Preparing to add Suburb Sales History Report");

		try {
			preparetoLoginJohny();
			loginButton();
			clickSuburbReportsButton();
			searchSurryHills();
			selectinSLAS();
			clickAddtoCartButton(1);
			gotoMyCart();
			payViaMerchant();
			if (successPayment()) {
				success = true;
			}
		} catch (AssertionError e) {
			fail("Report was Not Purchased!!");
		}

		return success;
	}



	public boolean goTosuburbSalesMapSubscription() throws Exception {
		boolean success = false;
		System.out.println("Preparing to add Suburb Sales History Report");

		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.suburbSalesMapSubscription));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.suburbSalesMapSubscription)));
			click(xpath(ObjectReferenceSmoketest.suburbSalesMapSubscription));
			Thread.sleep(2000);
			log("Was able to go to Suburb Sales Map Subscription (3months)");
		} catch (AssertionError e) {
			fail("Was not able to go to Suburb Sales Map Subscription (3months)");
		}
	
		return success;
	
	}

	
	public boolean searchOconnorAct() throws Exception {
		boolean success = false;
		System.out.println("Preparing to Address Search in Slas");

		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.slasField));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.slasField)));
			type(xpath(ObjectReferenceSmoketest.slasField), input[17]);
			log("Occonnor ACT Entered in SLAS");
		} catch (AssertionError e) {
			fail("Was not Able to Enter Occonnor ACT");
		}
		return success;

	}
	
	public boolean 	addSuburbMapSalesSuscription() throws Exception { 
		boolean success = false; 
		
		try {
			preparetoLoginJohny();
			loginButton();
			clickSuburbReportsButton();
			goTosuburbSalesMapSubscription();
			searchOconnorAct();
			selectinSLAS();
			clickAddtoCartButton(2);
			gotoMyCart();
			payButtonCPS();
			////payViaMerchant();
			enterCPSDetails();
			clickSubmitCheckout();
			if(successPayment()){
				
			}
				
		} catch (AssertionError e) {
			fail("Suburb Map Sales Subscription Report was Not Purchased!!!");
		}		
		
		return success;
		
		
	}
	

	
		public boolean payButtonCPS() throws Exception { 
			boolean success = false; 
			log("Preparing to Clic Order Now Button");
			try {
				waitForElementPresent(xpath(ObjectReferenceSmoketest.payNowCPS));
				Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.payNowCPS)));
				click(xpath(ObjectReferenceSmoketest.payNowCPS));
				Thread.sleep(2000);
				log("Pay now Button is Clicked");
			} catch (AssertionError e) {
				fail("pay now button Was not Clicked");
			}
			
		return success; 
		
		}
	
		
	public boolean enterCPSDetails() throws Exception { 
		boolean success = false; 
		log("Preparing to enter Payment Details");
		
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.cardNumber));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.cardNumber)));
			type(xpath(ObjectReferenceSmoketest.cardNumber), input[12]);
			type(xpath(ObjectReferenceSmoketest.cardHolder), input[6]);
			type(xpath(ObjectReferenceSmoketest.monthDate), input[18]);
			type(xpath(ObjectReferenceSmoketest.yearDate), input[19]);
			type(xpath(ObjectReferenceSmoketest.cardSecurutyCode), input[13]);
			log("Payment Details Entered");
		} catch (AssertionError e) {
			fail("Details were Not Entered");
		}
		
		
		return success;
	}
		
		
	public boolean clickSubmitCheckout() throws Exception { 
		boolean success = false; 
		log("Preparing to Submit Payment");
		
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.submitButtonCheckout));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.submitButtonCheckout)));
			click(xpath(ObjectReferenceSmoketest.submitButtonCheckout));
			Thread.sleep(2000);
			log("Submit Button Clicked");
		} catch (AssertionError e) {
			 fail("Submit Button Was Not Clicked");
		}
		
		return success;
		
	}



}


			