package myrp.utilities;

import static org.openqa.selenium.By.xpath;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;

import myrp.library.TestInitReference;

public class HomepageTilesUtil extends TestInitReference {
	String testCase0 = "RP Data Homepage";

	@Test(description = "RP Data Homepage - Property Tiles")
	public void homepageTiles() throws Exception {
		pass("Test Report: RP Data Homepage - Property Tiles on " + browser + " browser"); pass("Channel: " + url);
		waitForElementPresent(xpath("//a[.='Property reports']"));
		try { 
			By xpaths[] = { xpath("//a[.='Property reports']"),
					xpath("//a[.='Street reports']"),
					xpath("//a[.='Property services']"),
					xpath("//a[.='Suburb reports']") };
				Assert.assertTrue(verifyMultipleElements(10, xpaths));
				pass("All tiles are displayed on the page ");
				pass(" - Test: All tiles are present");
		} catch (AssertionError e) {
			// 
			fail(" - Test 2: Property tiles are not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
