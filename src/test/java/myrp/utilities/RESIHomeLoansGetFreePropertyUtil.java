package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansGetFreePropertyUtil extends TestInitReference {
	String paymentInfo = rxml.data("freePaymentInfo");
	
	@Test
	public void verifyLabels() throws Exception {
		try {
			By xpaths[] = { xpath(resi_paymentFName_xp),
					xpath(resi_paymentLName_xp), xpath(resi_paymentEmail_xp),
					xpath(resi_paymentNumber_xp), xpath(resi_paymentSuburb_xp),
					xpath(resi_paymentRelationship_xp),
					xpath(resi_paymentTime_xp), xpath(resi_paymentPurpose_xp),
					xpath(resi_paymentContact_xp), xpath(resi_paymentTerms_xp) };
					//xpath(resi_paymentAcceptTerms_xp) };
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass("All labels are present");
		} catch (AssertionError e) {
			fail("Not all labels are present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(paymentInfo, getText(xpath(resi_freePaymentInfo_xp)));
			pass(paymentInfo + " copy text is correct");
		} catch (AssertionError e) {
			fail(paymentInfo + " copy text is incorrect");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void cancelBtnEmpty() throws Exception {
		waitForElementPresent(xpath(resi_paymentCancelBtn_xp));
		click(xpath(resi_paymentCancelBtn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("First name field should not be empty."));
		} catch (AssertionError e) {
			fail("Error in First Name field");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
