package myrp.utilities;


import static org.openqa.selenium.By.xpath;

import java.io.IOException;
import java.util.List;
import myrp.library.FunctionReference;
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
}	 