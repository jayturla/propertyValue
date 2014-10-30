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
		 	waitForElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.usernameLogin)));
			type(xpath(ObjectReferenceSmoketest.usernameLogin), input[10]);
			System.out.println("User name Entered");
	 }

	 
	 public void passwordLogin() throws Exception{
		 	waitForElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.passwordLogin)));
			type(xpath(ObjectReferenceSmoketest.passwordLogin), input[11]);
			System.out.println("Password Entered");
	 }
	 
	 public void loginButton() throws Exception{
		 	waitForElementPresent(xpath(ObjectReferenceSmoketest.LoginRedbutton));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.LoginRedbutton)));
			click(xpath(ObjectReferenceSmoketest.LoginRedbutton));
			System.out.println("Login Button Clicked");
		 
		 
	 }
	 public boolean estimatedValueSubricption() throws Exception{
		boolean success = false;
		System.out.println("Search Address Via CFA");

		try {
			login();
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
			
		} catch (AssertionError e) {
			fail("Was not able to Select Address ");
		}
		return success;
				
	}
	 
	
	 
	 public void login() throws Exception{
		 log("Click Login Button");
			try {
				waitForElementPresent(xpath(ObjectReferenceSmoketest.loginButton));
				Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.loginButton)));
				click(xpath(ObjectReferenceSmoketest.loginButton));
				System.out.println("Login pop up appears");
			
			}catch (AssertionError e) {
			
				fail("Was not able to click Login Button");
			}
		 
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
		log("Estimated Value Subscription added to Cart");
		try{
			waitForElementPresent(xpath(purchaseButton));
			Assert.assertTrue(isElementPresent(xpath(purchaseButton)));
			click(xpath(purchaseButton));
			
			
		}catch (AssertionError e){
			
		}

	
	}	
	
	
	public void gotoMyCart()throws Exception{
		log ("Go to my Cart");
		try{
			waitForElementPresent(xpath(ObjectReferenceSmoketest.gotoMyCart));
			Assert.assertTrue(isElementPresent(xpath(ObjectReferenceSmoketest.gotoMyCart)));
			click(xpath(ObjectReferenceSmoketest.gotoMyCart));
			
		}catch (AssertionError e){
			
		}		
	}
	 
	
	public void payViaMerchant()throws Exception{
		log("Payment Success");
	
		try {
			waitForElementPresent(xpath(ObjectReferenceSmoketest.merchantName));
			type(xpath(ObjectReferenceSmoketest.merchantName), input[10]);
			waitForElementPresent(xpath(ObjectReferenceSmoketest.merchantCard));
			type(xpath(ObjectReferenceSmoketest.merchantCard), input[12]);
			waitForElementPresent(xpath(ObjectReferenceSmoketest.merchantCode));
			type(xpath(ObjectReferenceSmoketest.merchantCode), input[13]);
			click(xpath(ObjectReferenceSmoketest.merchantPaynow));
			
		} catch (AssertionError e) {
			 
			e.printStackTrace();
		}
		
		
		
	}
	
}


