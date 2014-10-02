package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansFooterUtil extends TestInitReference {
	
  @Test(description = "RP Data Resi Home Loans Footer")
  public void verifyFooter() throws Exception {
		waitForElementsPresent(xpath(resiProperties_tab_xp), xpath(resiHeading_label_xp), 10);

		try { 
			Assert.assertEquals("Copyright & Disclaimers", getText(xpath(resi_footer_disclaimer_xp)));
			pass("Copyright & Disclaimers is present");
		} catch (AssertionError e) {
			fail("Copyright & Disclaimers is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("Terms & Conditions", getText(xpath(resi_footer_terms_xp)));
			pass("Terms & Conditions is present");
		} catch (AssertionError e) {
			fail("Terms & Conditions is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("Privacy Policy", getText(xpath(resi_footer_policy_xp)));
			pass("Privacy Policy is present");
		} catch (AssertionError e) {
			fail("Privacy Policy is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
  }
 
  @Test(description = "RP Data Resi Home Loans Footer links")
  public void verifyFooterLinks() throws Exception {
		waitForElementsPresent(xpath(resiProperties_tab_xp), xpath(resiHeading_label_xp), 10);

		try {
			Assert.assertEquals("http://www.rpdata.com/general/copyright_and_disclaimer_notices.html", getHref(By.xpath(resi_footer_disclaimer_xp)));
			pass("Copyright & Disclaimers link is correct");
		} catch (AssertionError e) {
			fail("Copyright & Disclaimers link is incorrect");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("http://www.rpdata.com/general/general_terms_and_conditions.html", getHref(By.xpath(resi_footer_terms_xp)));
			pass("Terms & Conditions link is correct");
		} catch (AssertionError e) {
			fail("Terms & Conditions link is incorrect");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("http://www.rpdata.com/general/privacy_policy.html", getHref(By.xpath(resi_footer_policy_xp)));
			pass("Privacy Policy link is correct");
		} catch (AssertionError e) {
			fail("Privacy Policy link is incorrect");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
  }

	@Test
	public void verifyfooterLogo() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_logo_xp)));
			pass("RESI Logo is present");
		} catch (AssertionError e) {
			fail("RESI Logo is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_myrp_logo_xp)));
			pass("MyRP Logo is present");
		} catch (AssertionError e) {
			fail("MyRP Logo is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
  
  
  // TODO
  @Test
  public void verifyPaymentFooter() throws Exception {
	  
  }
  
}
