package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansGetFreeSuburbUtil extends TestInitReference {
	String search_val = rxml.data("suburb_search_val2");
	String placeholder4 = rxml.data("placeholderEmail");
	String blankEmailMsg = rxml.data("blankEmailM");
	String invalidEmail = rxml.data("invalidEmail");
	String invalidEmailMsg = rxml.data("invalidEmailM");
	String validEmail = rxml.data("validEmail");

	@Test(description = "To test if address is correct")
	public void verifyAddress() throws Exception {
		waitForElementPresent(xpath(resi_address_label_xp));
		try {
			Assert.assertEquals(search_val, getText(xpath(resi_address_label_xp)));
			pass("Suburb address is correct");
		} catch (AssertionError e) {
			fail("Suburb address label is incorrect");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "To test if email placeholder is correct")
	public void verifyPlaceholder() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(By.xpath(placeHolder(placeholder4))));
			pass(placeholder4 + " placeholder is present");
		} catch (AssertionError e) {
			fail(placeholder4 + " Email placeholder text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void getThisFree() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_getFreeSuburb_btn_xp)));
			pass("Get this free button is present");
		} catch (AssertionError e) {
			fail("Get this free button not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("Get this free", getText(xpath(resi_getFreeSuburb_btn_xp)));
			pass("Get this free button label is correct");
		} catch (AssertionError e) {
			fail("Get this free button label is incorrect");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void emailEmpty() throws Exception {
		try {
			// check email field
			click(xpath(resi_getFreeSuburb_btn_xp));
			Assert.assertTrue(isElementPresent(xpath(resi_email_validation_xp)));
			pass(blankEmailMsg + " message is present");

		} catch (AssertionError e) {
			fail("Validation is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			// empty email field
			click(xpath(resi_getFreeSuburb_btn_xp));
			Assert.assertEquals(blankEmailMsg, getText(xpath(resi_email_validation_xp)));
			pass(blankEmailMsg + " message is correct");

		} catch (AssertionError e) {
			fail("Is empty email validation is incorrect");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}

	}
	
	public void emailInvalid() throws Exception {
		try {
			// check email field
			click(xpath(resi_email_field_xp));
			type(xpath(resi_email_field_xp), invalidEmail);
			click(xpath(resi_getFreeSuburb_btn_xp));
			Assert.assertTrue(isElementPresent(xpath(resi_email_validation_xp)));
			pass(invalidEmailMsg + " message is present");

		} catch (AssertionError e) {
			fail("Validation is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(invalidEmailMsg, getText(xpath(resi_email_validation_xp)));
			pass(invalidEmailMsg + " message is correct");

		} catch (AssertionError e) {
			fail("Is email invalid validation is incorrect");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void validEmail() throws Exception {
		try {
			click(xpath(resi_email_field_xp));
			type(xpath(resi_email_field_xp), validEmail);
			click(xpath(resi_getFreeSuburb_btn_xp));
			Assert.assertTrue(isElementPresent(xpath(resi_thankYouFree_xp)));
			pass("Page navigates to Thank You screen");

		} catch (AssertionError e) {
			fail("Page is not navigated to Thank You screen");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void thankYouScreen() throws Exception { 
		try {
			Assert.assertTrue(verifyTextPresent("Thank you. Your report is on its way to"));
			pass("Thank you. Your report is on its way to " + validEmail + " message is present");
		} catch (AssertionError e) {
			fail("Thank you. Your report is on its way to " + validEmail + " message is not present ");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
}
