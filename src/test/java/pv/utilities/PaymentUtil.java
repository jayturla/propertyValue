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
		
		click(xpath(PVObjectReferenceSmoketest.getPremium));
		click(xpath(PVObjectReferenceSmoketest.premiumBuyNow));
		click(xpath(PVObjectReferenceSmoketest.purchasePremium));
		type(xpath(PVObjectReferenceSmoketest.promoCode), input[code]);
		click(xpath(PVObjectReferenceSmoketest.applyCode));
		type(xpath(PVObjectReferenceSmoketest.PaymentSummaryUserEmail), input[email]);
		click(xpath(PVObjectReferenceSmoketest.btnContinue));
		
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
		click(xpath(PVObjectReferenceSmoketest.premiumBuyNow));
		click(xpath(PVObjectReferenceSmoketest.purchasePremium));
		type(xpath(PVObjectReferenceSmoketest.PaymentSummaryUserEmail), input[email]);
		click(xpath(PVObjectReferenceSmoketest.btnBuyNow));
		click(xpath(PVObjectReferenceSmoketest.btnPayNow));

		waitForElementPresent(xpath(PVObjectReferenceSmoketest.PaymentCheckout));
		type(xpath(PVObjectReferenceSmoketest.cardNumber), "4111111111111111");
		type(xpath(PVObjectReferenceSmoketest.cardHolderName), input[chn]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry1), input[de1]);
		type(xpath(PVObjectReferenceSmoketest.dateExpiry2), input[de2]);
		type(xpath(PVObjectReferenceSmoketest.cardSecurityCode), input[cs]);
		click(xpath(PVObjectReferenceSmoketest.btnSubmit));
		
		driver.navigate().to("https://mail.google.com/mail/u/0/");
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.checkEmail));
		type(xpath(PVObjectReferenceSmoketest.checkEmail), input[gmail]);
		click(xpath(PVObjectReferenceSmoketest.btnNext));
		type(xpath(PVObjectReferenceSmoketest.gmailPasswd), input[gmailPwd]);
		click(xpath(PVObjectReferenceSmoketest.btnSignin));
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
}

