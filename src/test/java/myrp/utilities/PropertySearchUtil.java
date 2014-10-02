package myrp.utilities;

import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class PropertySearchUtil extends TestInitReference {

	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Property Search";
	String search_val = rxml.data("address_search_val");

	@Test (description = "RP Data Address Search")
	public void propertyAddressSearch() throws Exception {
		pass("Test Report: RP Data Property Search on " + browser + " browser"); pass("Channel: " + url);
		waitForElementPresent(xpath(search_xp));
		type(xpath(search_xp), search_val);
		click(xpath(search_button_xp));
		waitForElementPresent(xpath(searchAddress_xp));
		try {
			Assert.assertEquals(search_val, getText(xpath(searchAddress_xp)));
			pass(" - Test: " + search_val + " is present");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(search_val, getValue(xpath(search_xp)));
			pass(" - Test: " + search_val + " is present in searchbox");
		} catch (AssertionError e) {
			fail(" - Test: " + search_val + " is not present");
			takeScreenshot();
			resultcount++;
		}		
		if (resultcount != 0) {
			Assert.fail();
		}
	}

}