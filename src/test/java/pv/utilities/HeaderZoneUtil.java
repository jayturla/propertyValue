
package pv.utilities;


import static org.openqa.selenium.By.xpath;
import pv.atu_utilities.copy.ATUUtil;
import pv.library.FunctionReference;
import pv.library.PVObjectReferenceSmoketest;
import org.testng.Assert;

public class HeaderZoneUtil extends FunctionReference {
	
	private String[] input = null;
	private ATUUtil atu = new ATUUtil();
	public HeaderZoneUtil(String[] i) {
			input = i;
	}
	
	//Checking Header if available in the homepage
	
	public boolean checkLogin(int steps, int inputVal, int expected, int actual,boolean withATU)  throws Exception{
		boolean available = false;
		
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.verifyLogin)));
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyLogin));

		if (text.contains("Log in")) {
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
			pass("Login is available in the page");
		}else {
			fail("Login is NOT AVAILABLE in the page");
		}
		return available;
	
	}

	public void clickLogin()  throws Exception{
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.clickLogin));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.clickLogin)));
		click(xpath(PVObjectReferenceSmoketest.clickLogin));
		
	}

	public void enterUserName(int inputval) throws Exception{
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.userName));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.userName)));
		type(xpath(PVObjectReferenceSmoketest.userName), input[inputval]);
	}
	
	public void enterPassword(int inputval) throws Exception{
		
		waitForElementPresent(xpath(PVObjectReferenceSmoketest.password));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.password)));
		type(xpath(PVObjectReferenceSmoketest.password), input[inputval]);
	}
	

	public void loginSite() throws Exception{

		waitForElementPresent(xpath(PVObjectReferenceSmoketest.loginSite));
		Assert.assertTrue(isElementPresent(xpath(PVObjectReferenceSmoketest.loginSite)));
		click(xpath(PVObjectReferenceSmoketest.loginSite));
	
	}

	public boolean LoginPV(int steps, int inputVal, int expected, int actualPass,int actualFail,int userName,int password,boolean withATU)  throws Exception{
		boolean available = false;
		
		clickLogin();
		enterUserName(userName);
		enterPassword(password);
		loginSite();
		
		String text = getText(xpath(PVObjectReferenceSmoketest.verifyLoginName));
		if (text.contains("Pat")) {
			available = true;	
		}
		
		if(withATU) {
			if(available){
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualPass],true,true);//pass
			}else {
				atu.performATU(input[steps],input[inputVal],input[expected],input[actualFail],true,false);//fail
			}
		}
		if(available){
			pass("Existing User was able to Login!");
		}else {
			fail("Existing User was not able to Login!");
		}
		

		return available;
	}

}

