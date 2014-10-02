package myrp.utilities;

import static org.openqa.selenium.By.xpath;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;

import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

public class HomepageBannerUtil extends TestInitReference {
	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Homepage";
	
	@Test(description = "RP Data Homepage - Property Banner")
	public void homepagePropertyServicesBanner() throws Exception {
		pass("Test Report: RP Data Homepage - Property Banner on " + browser + " browser"); pass("Channel: " + url);
		try {
			By xpaths[] = { xpath(PropertyServicesBanner_xp), xpath(CordellBannerPaid_xp) };
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass(" - Test: Property Services Banner & Cordell Banner is present ");
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
	
