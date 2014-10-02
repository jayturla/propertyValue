package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

//TODO
public class RESIHomeLoansEmailReportUtil extends TestInitReference {
	String search_val = rxml.data("address_search_val");
	String placeholder3 = rxml.data("placeholderEmail");
	String high = rxml.data("confidenceH");
	String med = rxml.data("confidenceM");
	String low = rxml.data("confidenceL");
	String blankEmailMsg = rxml.data("blankEmailM");
	String invalidEmail = rxml.data("invalidEmail");
	String invalidEmailMsg = rxml.data("invalidEmailM");
	String validEmail = rxml.data("validEmail");
	String paymentInfo = rxml.data("freePaymentInfo");

	@Test(description = "To test if address is correct")
	public void verifyAddress() throws Exception {
		waitForElementPresent(xpath(resi_address_label_xp));
		try {
			Assert.assertEquals(search_val, getText(xpath(resi_address_label_xp)));
			pass("Page navigates to Email report");
		} catch (AssertionError e) {
			fail("Page is not navigated to Email report");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "To test if buttons are present")
	public void verifyButtons() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_purchase_btn_xp)));
			pass("Purchase now button is present");
		} catch (AssertionError e) {
			fail("Purchase now button is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_getFree_btn_xp)));
			pass("Get this free button is present");
		} catch (AssertionError e) {
			fail("Get this free button is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "To test if buttons label are correct")
	public void verifyButtonsLabel() throws Exception {
		try {
			Assert.assertEquals("Purchase now $39.95", getText(xpath(resi_purchase_btn_xp)));
			pass("Purchase now button label is correct");
		} catch (AssertionError e) {
			fail("Purchase now button is incorrect");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("Get this free", getText(xpath(resi_getFree_btn_xp)));
			pass("Get this free button label is correct");
		} catch (AssertionError e) {
			fail("Get this free button label is incorrect");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "To test if email placeholder is correct")
	public void verifyPlaceholder() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(By
					.xpath(placeHolder(placeholder3))));
			pass(placeholder3 + " placeholder is present");
		} catch (AssertionError e) {
			fail(placeholder3 + " Email placeholder text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "To test if confidence description is present")
	public void verifyConfidence() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_confidence_Icon_xp)));
			pass("Confidence icon is present");
		} catch (AssertionError e) {
			fail("Confidence icon is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_confidence_label_xp)));
			pass("Confidence label is present");
		} catch (AssertionError e) {
			fail("Confidence label is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_tooltip_xp)));
			pass("Confidence Level description is present");
		} catch (AssertionError e) {
			fail("Confidence Level description is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "To test if confidence description is correct")
	public void verifyConfidenceHover() throws Exception {

		// new Actions(driver).moveToElement(
		// driver.findElement(By.className(resi_tooltip))).perform();

		try {

			Actions builder = new Actions(driver);
			WebElement main = driver.findElement(xpath(resi_tooltip_xp));
			builder.moveToElement(main).build().perform();
			// waitForElementPresent(xpath(resi_tooltip));
			// click(xpath(viewDetailsImage_xp));
			// pass("Comment: The Image was clicked");

			//Assert.assertEquals(high, getText(xpath(resi_tooltip_xp)));
			Assert.assertTrue(verifyTextPresent("null"));
			pass("Confidence Level description is correct");
		} catch (AssertionError e) {
			fail("Confidence Level description is not correct");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void verifyConfidenceLevel() throws Exception {

		try {
			waitForOneElementPresent(10, xpath(resi_tooltip_xp));
			// String lvl = getText(xpath(resi_tooltip));
			if (getText(xpath(resi_tooltip_xp)).equals(high)) {
				Assert.assertTrue(true);
				pass(high + " , description is correct");
			} else if (getText(xpath(resi_tooltip_xp)).equals(med)) {
				Assert.assertTrue(true);
				pass(med + " , description is correct");
			} else if (getText(xpath(resi_tooltip_xp)).equals(low)) {
				Assert.assertTrue(true);
				pass(low + " , description is correct");
			} else {
				fail("Confidence level description is incorrect");
			}

		} catch (AssertionError e) {
			fail("Confidence Level description is incorrect");
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
			click(xpath(resi_purchase_btn_xp));
			Assert.assertTrue(isElementPresent(xpath(resi_email_validation_xp)));
			pass(blankEmailMsg + " message is present");

		} catch (AssertionError e) {
			fail("Validation is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			// empty email field
			click(xpath(resi_purchase_btn_xp));
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
			click(xpath(resi_purchase_btn_xp));
			Assert.assertTrue(isElementPresent(xpath(resi_email_validation_xp)));
			pass(invalidEmailMsg + " message is present");

		} catch (AssertionError e) {
			fail("Validation  is not present");
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
	public void purchaseBtn() throws Exception {
		try {
			click(xpath(resi_email_field_xp));
			type(xpath(resi_email_field_xp), validEmail);
			click(xpath(resi_purchase_btn_xp));
			Assert.assertTrue(isElementPresent(xpath("//label[contains(@for,'name')]")));
			pass("Page navigates to Payment screen (PAID)");

		} catch (AssertionError e) {
			fail("Page is not navigated to Payment screen (PAID)");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void getFreeBtn() throws Exception {
		try {
			type(xpath(resi_email_field_xp), validEmail);
			click(xpath(resi_getFree_btn_xp));
			Assert.assertTrue(verifyTextPresent("Just provide some details"));
			pass("Page navigates to Payment screen (FREE)");
		} catch (AssertionError e) {
			fail("Page is not navigated to Payment screen (FREE)");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(paymentInfo, getText(xpath(resi_freePaymentInfo_xp)));
			pass(paymentInfo + " copy is present");
		} catch (AssertionError e) {
			fail(paymentInfo + " copy is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
}
