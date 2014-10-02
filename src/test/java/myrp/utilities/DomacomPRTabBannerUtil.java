package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DomacomPRTabBannerUtil extends TestInitReference {

	@Test(description = "RP Data Property Report - Property Services Banner")
	public void propertyServicesBanner() throws Exception {
		pass("Test Report: RP Data Property Report - Property Services Banner on "
				+ browser + " browser");
		waitForElementPresent(xpath(propertyServicesBanner_xp));
		try {
			// Test if Cordell banner is present
			Assert.assertTrue(isElementPresent(xpath(CordellBannerFree_xp)));
			pass("Cordell Banner is present");
			// Test if Property Services banner is removed
			Assert.assertFalse(isElementPresent(xpath(PropertyServicesBanner_xp)));
			pass("Property Services Banner is removed in Domacom channel");

		} catch (AssertionError e) {
			fail("Error in Property Services Banner " + url);
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

}
