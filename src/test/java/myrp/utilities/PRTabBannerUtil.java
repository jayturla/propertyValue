package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PRTabBannerUtil extends TestInitReference {
	@Test(description = "RP Data Property Report - Property Services Banner")
	public void propertyServicesBanner() throws Exception {
		pass("Test Report: RP Data Property Report - Property Services Banner on " + browser + " browser");
		
		new PropertySearchUtil().propertyAddressSearch();
		waitForElementPresent(xpath(propertyServicesBanner_xp));
		
		try {
			By xpaths[] = { xpath(HubBanner_xp), xpath(CordellBannerPaid_xp) };
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass(" - Test: Property Services Banner & Cordell Banner is present ");
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
