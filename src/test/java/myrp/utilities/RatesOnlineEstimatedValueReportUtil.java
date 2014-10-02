package myrp.utilities;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.By.xpath;
import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

// Sprint 145
@Test
public class RatesOnlineEstimatedValueReportUtil extends TestInitReference {

	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Property Search";
	String search_val = rxml.data("address_search_val");

	@Test
	public void clickAddtoCart() throws Exception {
		waitForElementPresent(xpath(propertyEstimatedReport_btn_xp));
		click(xpath(propertyEstimatedReport_btn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("Thanks for your interest in our Estimated value report."));
			pass("Add to cart Estimated Value Report button is clicked");
		} catch (AssertionError e) {
			fail("Add to cart Estimated Value Report is not clicked");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(verifyTextPresent("Thanks for your interest in our Estimated value report. We are currently running a trial where you can get this report for free (usually $24.95). Just provide some details so Rates Online can call to demonstrate  how they can save money on your home loan and then email you the report."));
			Assert.assertTrue(verifyTextPresent("Alternatively, you may wish to simply buy the report as you normally would. The choice is yours."));
			pass("Est. Value message copy is correct");
		} catch (AssertionError e) {
			fail("Est. Value message copy is incorrect");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void clickGetThisFree() throws Exception {
		click(xpath(ro_getThisFree_btn_xp));
		waitForElementPresent(xpath(form_EstimatedVHeader_label_xp));
		try {
			Assert.assertTrue(verifyTextPresent("Free Estimated Value Report"));
			pass("Free Estimated Value Report form is displayed");
		} catch (AssertionError e) {
			fail("Free Estimated Value Report form is not displayed");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void checkInfoText() throws Exception {
		try {
			Assert.assertTrue(verifyTextPresent("Please provide the details below."));
			pass("Please provide the details below. copy text displayed");
		} catch (AssertionError e) {
			fail("Please provide the details below. copy text displayed");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void checkLabels() throws Exception {
		try {
			Assert.assertTrue(verifyTextPresent("* First Name:"));
			pass("First Name label is present");
		} catch (AssertionError e) {
			fail("First Name label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Last Name:"));
			pass("Last Name label is present");
		} catch (AssertionError e) {
			fail("Last Name label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Email Address:"));
			pass("Email Address label is present");
		} catch (AssertionError e) {
			fail("Email Address label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Contact Number:"));
			pass("Contact Number label is present");
		} catch (AssertionError e) {
			fail("Contact Number label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Suburb:"));
			pass("Suburb label is present");
		} catch (AssertionError e) {
			fail("Suburb label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Loan purpose:"));
			pass("Loan purpose label is present");
		} catch (AssertionError e) {
			fail("Loan purpose label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Time to act:"));
			pass("Time to act label is present");
		} catch (AssertionError e) {
			fail("Time to act label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Loan amount:"));
			pass("Loan amount label is present");
		} catch (AssertionError e) {
			fail("Loan amount label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* Preferred contact time:"));
			pass("Preferred contact time label is present");
		} catch (AssertionError e) {
			fail("Preferred contact time label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("Terms &amp; Conditions"));
			pass("Terms & Conditions label is present");
		} catch (AssertionError e) {
			fail("Terms & Conditions label is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("* I have read and accepted the"));
			pass("I have read and accepted the Terms & Conditions label is present");
		} catch (AssertionError e) {
			fail("I have read and accepted the Terms & Conditions label is not present");
			takeScreenshot();
			resultcount++;
		}

		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void validationEmpty() throws Exception {
		click(xpath(ro_submit_btn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("First name field should not be empty."));
			pass("First name field validation is present");
		} catch (AssertionError e) {
			fail("First name field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(verifyTextPresent("Last name field should not be empty."));
			pass("Last name field validation is present");
		} catch (AssertionError e) {
			fail("Last name field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(verifyTextPresent("Email field should not be empty."));
			pass("Email field validation is present");
		} catch (AssertionError e) {
			fail("Email field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(verifyTextPresent("Contact number field should not be empty."));
			pass("Contact number field validation is present");
		} catch (AssertionError e) {
			fail("Contact number field validation is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(verifyTextPresent("Please select loan purpose to this property."));
			pass("Loan purpose field validation is present");
		} catch (AssertionError e) {
			fail("Loan purpose field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(verifyTextPresent("Loan amount should not be empty."));
			pass("Loan amount field validation is present");
		} catch (AssertionError e) {
			fail("Loan amount field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(verifyTextPresent("Please select the time to act."));
			pass("Time to act field validation is present");
		} catch (AssertionError e) {
			fail("Time to act field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(verifyTextPresent("Please select the preferred contact time."));
			pass("Contact time field validation is present");
		} catch (AssertionError e) {
			fail("Contact time field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(verifyTextPresent("Please accept the Terms &amp; Conditions."));
			pass("Accept terms & conditions field validation is present");
		} catch (AssertionError e) {
			fail("Accept terms & conditions field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void validationSuburbField() throws Exception {
		driver.findElement(xpath(suburb_field_xp)).clear();
		click(xpath(ro_submit_btn_xp));
		
		try {
			Assert.assertTrue(verifyTextPresent("Suburb field should not be empty."));
			pass("Suburb field validation is present");
		} catch (AssertionError e) {
			fail("Suburb field validation is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
		
	@Test
	public void validationInvalidSuburb() throws Exception {
		type(xpath(suburb_field_xp), "Test" );
		click(xpath(ro_submit_btn_xp));
		
		try {
			Assert.assertTrue(verifyTextPresent("Please enter a valid suburb"));
			pass("Invalid suburb validation is present");
		} catch (AssertionError e) {
			fail("Invalid suburb validation is not present");
			takeScreenshot();
			resultcount++;
		} 
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void validSuburb() throws Exception {
		driver.findElement(xpath(suburb_field_xp)).clear();
		type(xpath(suburb_field_xp), "Cremorne NSW 2090" );
		click(xpath(ro_submit_btn_xp));
		try {
			Assert.assertFalse(verifyTextPresent("Suburb field should not be empty."));
			Assert.assertFalse(verifyTextPresent("Please enter a valid suburb"));
			pass("Suburb validation is not displayed when correct suburb name is entered");
		} catch (AssertionError e) {
			fail("Error in Suburb field still displays");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void filloutForm() throws Exception {
		try {
			type(xpath(suburb_field_xp), "Test" );
		} catch (AssertionError e) {
			fail("Error ");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void tick() throws Exception {
		try {
			Assert.assertEquals("accept", getValue(xpath(agreeCb_xp)));
			pass("Checkbox is ticked");
		} catch (AssertionError e) {
			fail("Error ");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
}
