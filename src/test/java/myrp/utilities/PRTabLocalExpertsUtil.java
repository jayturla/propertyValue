package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.FunctionReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PRTabLocalExpertsUtil extends FunctionReference{
	@Test(description = "RP Data Property Local Experts")
	public void propertylocalExperts() throws Exception {
		pass("Test Report: RP Data Property Report - Local Experts (Agent sites) on " + browser + " browser");
		
		new PropertySearchUtil().propertyAddressSearch();
		waitForElementPresent(xpath(searchAddress_xp));
		
		try {
			By xpaths[] = { xpath(propertyRelatedSearches_label_xp), xpath(localExpertsAgentSites_label_xp) };
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass("Local Experts (Agent sites) & Related Searches is present in the right panel");
		} catch (AssertionError e) {
			fail("Error in Local Experts (Agent sites) ");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
