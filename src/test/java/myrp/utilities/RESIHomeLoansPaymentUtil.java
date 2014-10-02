package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansPaymentUtil extends TestInitReference {
	
	@Test
	public void checkLabels() throws Exception {
		waitForElementPresent(xpath(resiProperties_tab_xp));
		try {
			By xpaths[] = { xpath("//label[contains(@for,'name')]"),
					xpath("//div[4]/label[contains(@for,'card-number')]"),
					xpath("//div[3]/label"), xpath("//div[6]/label"),
					xpath("//div[8]/label[contains(@for,'card-number')]") };
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass("All Payment fields are present (Name, Card number, Expiration Date, Security Code, Terms)");
		} catch (AssertionError e) {
			fail("Not all fields in Payment form are present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	// TODO
	@Test
	public void emptyAll() throws Exception {
		click(xpath(resi_Pay_btn_xp));
		try {
			
		} catch (AssertionError e) {
			fail("Error");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
