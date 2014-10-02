package myrp.utilities;

import static org.openqa.selenium.By.xpath;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;

import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

public class DomacomHomepageUtil extends TestInitReference {
	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Domacom Channel Homepage";

	@Test(description = "RP Data Domacome Homepage - Property Tiles")
	public void homepageTiles() throws Exception {
		pass("Test Report: RP Data Homepage - Property Tiles on " + browser
				+ " browser");
		pass("Channel: " + url);
		waitForElementPresent(xpath("//a[.='Property reports']"));
		try {
			By xpaths[] = { xpath("//a[.='Property reports']"),
					xpath("//a[.='Street reports']"),
					xpath("//a[.='Suburb reports']") };
			// check if 3 tiles are present
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass(" - Test: Property reports, Street reports, Suburb report tiles are present");
			// check if Property services tile is removed
			Assert.assertFalse(isElementPresent(xpath("//a[.='Property services']")));
			pass(" - Test: Property services tile is removed");
		} catch (AssertionError e) {
			//
			fail(" - Error: Property tiles");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
