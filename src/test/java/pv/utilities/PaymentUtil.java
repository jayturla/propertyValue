package pv.utilities;


import static org.openqa.selenium.By.xpath;



import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;

import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class PaymentUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	
	public PaymentUtil(String[] i) {
			input = i;
	}
	
	//PUrchase any product using promo code
	public boolean promoCode(int steps, int inputVal, int expected, int actual, int code, int email, boolean withATU)  throws Exception {
		boolean available = false;
		
		clickgetPremium(0,0,0,0,false);
		clickpremiumBuyNow(0,0,0,0,false);
		clickpurchasePremium(0,0,0,0,false);
		type(xpath(PVObjectReferenceSmoketest.promoCode), input[code]);
		clickapplyCode(0,0,0,0,false);
		type(xpath(PVObjectReferenceSmoketest.PaymentSummaryUserEmail), input[email]);
		clickbtnContinue(0,0,0,0,false);
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.paymentSuccess));
		String text = getText(xpath(PVObjectReferenceSmoketest.paymentSuccess));
		
		if (text.contains("Your payment has been successful!")) {
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Can purchase any product using promo code.");
		}else {
			fail("Cannot purchase any product using promo code.");
		}
		return available;
		
	}
	
	public boolean emailPurchase(int steps, int inputVal, int expected, int actual, int email,int chn, int de1, int de2, int cs, int gmail, int gmailPwd, boolean withATU)  throws Exception {
		boolean available = false;
		driver.navigate().to("http://dev.propertyvalue.com.au/upgrade");
		clickpremiumBuyNow(0,0,0,0,false);
		clickpurchasePremium(0,0,0,0,false);
		type(xpath(PVObjectReferenceSmoketest.PaymentSummaryUserEmail), input[email]);
		clickbtnBuyNow(0,0,0,0,false);
		clickbtnPayNow(0,0,0,0,false);

		waitForElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout));
		type(xpath(PVObjectReferenceSmoketest.cardNumber), "4111111111111111");
		type(xpath(PVObjectReferenceSmoketest.cardHolderName), input[chn]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry1), input[de1]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry2), input[de2]);
		type(xpath(PVObjectReferenceSmoketest.cardSecurityCode), input[cs]);
		clickbtnSubmit(0,0,0,0,false);
		
		driver.navigate().to("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkEmail));
		type(xpath(PVObjectReferenceSmoketest.checkEmail), input[gmail]);
		clickbtnNext(0,0,0,0,false);
		type(xpath(PVObjectReferenceSmoketest.gmailPasswd), input[gmailPwd]);
		clickbtnSignin(0,0,0,0,false);
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkGmail));
		String text = getText(xpath(PVObjectReferenceSmoketest.checkGmail));
		
		if (text.contains("Thanks for your Property Value purchase")) {
			available = true;
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		if(available){
			pass("Can receive email on the Purchased Reports and Attached Report is correct");
		}else {
			fail("Cannot receive email on the Purchased Reports and Attached Report is correct");
		}
		return available;
	}
	
	public boolean clickgetPremium(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.getPremium));
			click(xpath(PVObjectReferenceSmoketest.getPremium));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickpremiumBuyNow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.premiumBuyNow));
			click(xpath(PVObjectReferenceSmoketest.premiumBuyNow));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickpurchasePremium(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.purchasePremium));
			click(xpath(PVObjectReferenceSmoketest.purchasePremium));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickapplyCode(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.applyCode));
			click(xpath(PVObjectReferenceSmoketest.applyCode));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnContinue(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnContinue));
			click(xpath(PVObjectReferenceSmoketest.btnContinue));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnBuyNow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnBuyNow));
			click(xpath(PVObjectReferenceSmoketest.btnBuyNow));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnPayNow(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnPayNow));
			click(xpath(PVObjectReferenceSmoketest.btnPayNow));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnSubmit(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnSubmit));
			click(xpath(PVObjectReferenceSmoketest.btnSubmit));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnNext(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnNext));
			click(xpath(PVObjectReferenceSmoketest.btnNext));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
	public boolean clickbtnSignin(int steps, int inputVal, int expected, int actual, boolean withATU) throws Exception {
		boolean click = false;
		
		try{
			waitForElementPresent(xpath(PVObjectReferenceSmoketest.btnSignin));
			click(xpath(PVObjectReferenceSmoketest.btnSignin));
			click = true;
		}catch(Exception e){
		}
		
		if(withATU) {
			if(click){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actual],true,false);//fail
			}
		}
		
		return click;
	}
}


