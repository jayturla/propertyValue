package mobile.test;

import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class StreetReportPageUtil extends TestInitReference {

	@Test
	public void addToCartStreet() throws Exception {
		waitForElementPresent(xpath(streetReportAccordion_xp));
		click(xpath(streetReportAccordion_xp));
		waitForElementPresent(xpath(streetReportBtnMobile_xp));
		click(xpath(streetReportBtnMobile_xp));
		Thread.sleep(5000);
		click(xpath(basketIcon_xp));
		try {
			Assert.assertTrue(verifyTextPresent("Street Sales Report"));
			pass(" - Street report added to cart");
			Assert.assertTrue(verifyTextPresent("Darley Road"));
			Assert.assertTrue(verifyTextPresent("Manly NSW 2095"));
			pass(" - Darley Road Manly NSW 2095 address name is present");
			Assert.assertTrue(verifyTextPresent("(359 Properties)"));
			pass(" - Sales count is present");
		} catch (Exception e) {
			fail("Street report not added to cart");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void streetReport() throws Exception {
		waitForElementPresent(xpath(streetReportAccordion_xp));
		
		
	}
}
