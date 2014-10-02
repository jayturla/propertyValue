package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PropertyUnavailableUtil extends TestInitReference{
	
	@Test
	public boolean verifySuburbLink(){
		try{
			pass("Verifying Property Unavailable Page if Suburb Link Exists started");
			searchAddress("23 Clocktower Court Berwick VIC 3806");
			Thread.sleep(1500);
			waitForElementPresent(xpath(btnSuburbPU_xp));
			Assert.assertTrue(verifyTextPresent("View other properties in"));
			pass("Verifying Property Unavailable Page if Suburb Link Exists succeeded");
			return true;
		}catch(AssertionError e){
			
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		fail("Verifying Property Unavailable Page if Suburb Link Exists failed");
		return false;
	}
	
	@Test
	public boolean verifySuburbRedirection(){
		try{
			pass("Verifying Property Unavailable Page Redirection started");
			searchAddress("23 Clocktower Court Berwick VIC 3806");
			String url = getHref(xpath(btnSuburbPU_xp));
			Thread.sleep(1500);
			click(xpath(btnSuburbPU_xp));
			Thread.sleep(1500);
			String windowUrl = driver.getCurrentUrl();
			if(url.equalsIgnoreCase(windowUrl)){
				pass("Verifying Property Unavailable Page Redirection succeeded");
				return true;
			}
		}catch(AssertionError e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		fail("Verifying Property Unavailable Page Redirection");
		return false;
	}
	
	public void searchAddress(String address) throws Exception {
		waitForElementPresent(xpath(smokeSearchLine_xp));
		
		type(xpath(smokeSearchLine_xp), address);
		click(xpath(search_button_xp));
		waitForElementPresent(xpath(smokeSearchAddress_xp));
		
		try{
			pass(" - Test: " + address + " is present");
		}
		catch(Exception e){
			fail(" - Test: " + address + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	
	
}
