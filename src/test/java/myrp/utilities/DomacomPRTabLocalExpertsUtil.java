package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.FunctionReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DomacomPRTabLocalExpertsUtil extends FunctionReference {
	
	@Test(description = "RP Data Property Local Experts")
	public void propertylocalExperts() throws Exception {
		pass("Test Report: RP Data Property Report - Local Experts (Agent sites) on "
				+ browser + " browser");
		
		waitForElementPresent(xpath(searchAddress_xp));
		try {
			Assert.assertTrue(isElementPresent(xpath(propertyRelatedSearches_label_xp)));
			pass("Related Searches is present in the right panel");
			Assert.assertFalse(isElementPresent(xpath(localExpertsAgentSites_label_xp)));
			pass("Local Experts (Agent sites) is removed in Domacom channel");
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
