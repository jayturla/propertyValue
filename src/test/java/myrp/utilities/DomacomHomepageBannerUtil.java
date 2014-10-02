package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DomacomHomepageBannerUtil extends TestInitReference {

	@Test(description = "RP Data Homepage Homepage banner")
	public void homepageBanner() throws Exception {
		pass("Test Report: RP Data Homepage - Property Banner on " + browser
				+ " browser");
		pass("Channel: " + url);
		try {
			// Test if Cordell Banner is present in homepage
			Assert.assertTrue(isElementPresent(xpath(CordellBannerFree_xp)));
			pass(" - Test: Cordell Banner is present ");
			// Test if Property Service Banner is removed
			Assert.assertFalse(isElementPresent(xpath(PropertyServicesBanner_xp)));
			pass(" - Test: Property Services Banner is removed ");
		} catch (AssertionError e) {
			fail(" - Error: Homepage Banner(s)");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

}
