package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HSBCDetailedPropertyReportUtil extends TestInitReference {

	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Property Search";
	String search_val2 = rxml.data("address_search_val2");
	String search_val3 = rxml.data("address_search_val3");
	String search_val4 = rxml.data("address_search_val4");

	@Test(description = "Address Search that is not on the postcode list")
	public void propertyAddressSearch2() throws Exception {
		pass("Test Report: RP Data Property Search on " + browser + " browser");
		pass("Channel: " + url);
		type(xpath(search_xp), search_val2);
		click(xpath(search_button_xp));
		waitForElementPresent(xpath(searchAddress_xp));
		try {
			Assert.assertEquals(search_val2, getText(xpath(searchAddress_xp)));
			pass(" - Test: " + search_val2 + " is present");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val2 + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(search_val2, getValue(xpath(search_xp)));
			pass(" - Test: " + search_val2 + " is present in searchbox");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val2 + " is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "Address Search with FSDScore 100")
	public void propertyAddressSearch3() throws Exception {
		pass("Test Report: RP Data Property Search on " + browser + " browser");
		pass("Channel: " + url);
		waitForElementPresent(xpath(search_xp));
		type(xpath(search_xp), search_val3);
		click(xpath(search_button_xp));
		click(xpath("(//h2)[2]"));
		waitForElementPresent(xpath(searchAddress_xp));
		try {
			Assert.assertEquals(search_val3, getText(xpath(searchAddress_xp)));
			pass(" - Test: " + search_val3 + " is present");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val3 + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(search_val3, getValue(xpath(search_xp)));
			pass(" - Test: " + search_val3 + " is present in searchbox");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val3 + " is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test (description = "Address Search with median price less than $550,00")
	public void propertyAddressSearch4() throws Exception {
		pass("Test Report: RP Data Property Search on " + browser + " browser"); pass("Channel: " + url);
		waitForElementPresent(xpath(search_xp));
		type(xpath(search_xp), search_val4);
		click(xpath(search_button_xp));
		waitForElementPresent(xpath(searchAddress_xp));
		try {
			Assert.assertEquals(search_val4, getText(xpath(searchAddress_xp)));
			pass(" - Test: " + search_val4 + " is present");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val4 + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(search_val4, getValue(xpath(search_xp)));
			pass(" - Test: " + search_val4 + " is present in searchbox");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val4 + " is not present");
			takeScreenshot();
			resultcount++;
		}		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "Click Add to cart on Detailed Property Report")
	public void offered() throws Exception {
		waitForElementPresent(xpath(propertyDetailedReport_btn_xp));
		click(xpath(propertyDetailedReport_btn_xp));
		waitForElementPresent(xpath(propertyDetailedModal_xp));
		
		try  {
			Assert.assertTrue(verifyTextPresent("HSBC Bank can discuss your property needs"));
			pass("Modal box is displayed");
		} catch (AssertionError e) {			
			fail("Modal box is not displayed");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "Click Add to cart on Detailed Property Report")
	public void notOffered() throws Exception {
		waitForElementPresent(xpath(propertyDetailedReport_btn_xp));
		click(xpath(propertyDetailedReport_btn_xp));
		//waitForElementPresent(xpath(propertyDetailedModal_xp));
		
		try  {
			Assert.assertTrue(verifyTextPresent("Added to cart"));
			pass("HSBC report is not offerred for property that is not in the postcode list, item is added to cart onclick");
		} catch (AssertionError e) {			
			fail("Modal box is not displayed");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "Click Close button on HSBC modal then go to homepage")
	public void clickClose() throws Exception {
		try {
			waitForElementPresent(xpath(modalCloseBtn_xp));
			Thread.sleep(5000);
			click(xpath(modalCloseBtn_xp));
			pass("Modal box is closed");
		} catch (AssertionError e) {
			fail("Modal box and/or MyRP Logo is not clicked");
			takeScreenshot();
			resultcount++;
		}
		try {
			waitForElementPresent(xpath(rpdataLogo_xp));
			Thread.sleep(5000);
			click(xpath(rpdataLogo_xp));
			pass("MyRP logo is clicked");
		} catch (AssertionError e) {
			fail("Modal box and/or MyRP Logo is not clicked");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

}
