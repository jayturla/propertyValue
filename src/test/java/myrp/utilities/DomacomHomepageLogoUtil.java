package myrp.utilities;

import static org.openqa.selenium.By.*;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DomacomHomepageLogoUtil extends TestInitReference {
	
	String testCase = "RP Data Channel";

	@Test(description = "RP Data Channel Logo")
	public void checkChannelLogo() throws Exception {
		pass("Test Report: RP Data Channel Logo on " + browser + " browser");
		pass("Channel: " + url);
		waitForElementPresent(xpath(rpdataLogo_xp));
		waitForElementPresent(xpath(domacomLogo_xp));
		boolean elementPresent = isElementPresent(xpath(domacomLogo_xp));
		
		try {
			// check if Domacom logo is present
			Assert.assertTrue(elementPresent);
			pass(" - Test: Domacom logo is present");
		} catch (AssertionError e) {
			fail(" - Error: Domacom logo");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}

	}
}

