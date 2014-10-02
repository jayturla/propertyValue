package mobile.test;

import static org.openqa.selenium.By.xpath;
import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyPurchasesUtil extends TestInitReference {
	
	String ThanksNoteDPR = rxml.data("ThanksNoteDPR");
	String RPDisclaimerCopyright = rxml.data("RPDisclaimerCopyright");
	String RPDisclaimer = rxml.data("RPDisclaimer");
	String AVMDisclaimer = rxml.data("AVMDisclaimer");

	@Test
	public void checkMyPurchasesPage() throws Exception {

		// Login user with purchases
		// Heading
		pass("Checking the heading in My Purchases");
		// click(xpath(loginMButton_xp));
		waitForElementPresent(xpath(MyPurchasesBtn_xp));
		click(xpath(MyPurchasesBtn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("My Purchases"));
			pass("My Purchases heading is present");
		} catch (AssertionError e) {
			fail("My Purchases heading is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Total purchase count
		pass("Checking the total number of purchased reports");
		try {
			Assert.assertTrue(verifyTextPresent("6 Reports"));
			pass("Total count of purchased report is present");
		} catch (AssertionError e) {
			fail("Total count of purchased report is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Fields
		pass("Checking the fields & link in the list");
		try {
			Assert.assertTrue(verifyTextPresent("Generated date:"));
			Assert.assertTrue(verifyTextPresent("Expiration date:"));
			Assert.assertTrue(verifyTextPresent("View report"));
			pass("Generated date, Expiration date and View report link is present");
		} catch (AssertionError e) {
			fail("Generated date, Expiration date and View report link is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	// Detailed Property Report
	@Test
	public void DetailedPropertyReportPage() throws Exception {
		// TODO
		// Background: Given user is on My Purchases page
		// And is about to view a Detailed Property Report (HTML)
		pass("Checking the report link navigates to html page");
		click(xpath("sample"));
		waitForElementPresent(xpath("sample"));
		try {
			Assert.assertTrue(verifyTextPresent("Detailed Property Report"));
			pass("User is navigated to Detailed property report html version");
		} catch (AssertionError e) {
			fail("User is not navigated to Detailed Property report");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void propertyDetail() throws Exception {
		// MYRP Logo
		pass("Checking property logo");
		try {
			waitForElementPresent(xpath(""));
			Assert.assertTrue(isElementPresent(xpath("")));
			pass("MyRP Logo is present");
		} catch (AssertionError e) {
			fail("MyRp Logo is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Property address is correct
		pass("Checking property address");
		try {
			Assert.assertTrue(verifyTextPresent(""));
			pass("Property address is present");
		} catch (AssertionError e) {
			fail("Property address is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Property attributes
		pass("Checking property attributes");
		try {
			waitForElementsPresent(xpath(""), xpath(""), 10);
			Assert.assertTrue(verifyMultipleElements(10, xpath(""), xpath("")));
			pass("Property attributes are present");
		} catch (AssertionError e) {
			fail("Property attributes is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Property photo
		pass("Checking property photo");
		try {
			waitForElementPresent(xpath(""));
			Assert.assertTrue(isElementPresent(xpath("")));
			pass("Property Photo is present");
		} catch (AssertionError e) {
			fail("Property Photo is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Estimated value
		pass("Checking Estimated value label");
		try {
			Assert.assertTrue(verifyTextPresent("ESTIMATED VALUE"));
			pass("Estimated Value text is present");
		} catch (AssertionError e) {
			fail("Estimated Value text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Estimated value range
		pass("Checking the Estimated Value Range label");
		try {
			Assert.assertTrue(verifyTextPresent("Estimated Value Range"));
			pass("Estimated Value Range text is present");
		} catch (AssertionError e) {
			fail("Estimated Value Range text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// FSD
		pass("Checking the Estimated value label");
		try {
			Assert.assertTrue(verifyTextPresent("FSD"));
			pass("Estimated Value text is present");
		} catch (AssertionError e) {
			fail("Estimated Value text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		// Fields & components
		pass("Checking the fields for Property detail");
		try {
			Assert.assertTrue(verifyTextPresent("Primary Land Use"));
			Assert.assertTrue(verifyTextPresent("Secondary Land Use"));
			Assert.assertTrue(verifyTextPresent("Municipality"));
			Assert.assertTrue(verifyTextPresent("Zoning"));
			Assert.assertTrue(verifyTextPresent("Lot / Plan"));
			Assert.assertTrue(verifyTextPresent("RPD"));
			Assert.assertTrue(verifyTextPresent("Owners"));
			Assert.assertTrue(verifyTextPresent("Description"));
			Assert.assertTrue(verifyTextPresent("AutoVal Date"));
			Assert.assertTrue(verifyTextPresent("Property Type"));
			Assert.assertTrue(verifyTextPresent("UCV"));
			Assert.assertTrue(verifyTextPresent("UCV Date"));
			pass("Fields are all present");
		} catch (AssertionError e) {
			fail("Not all fields are present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void propertySalesHistory() throws Exception {
		// Fields & components
		pass("Checking the Sales History heading");
		try {
			Assert.assertTrue(verifyTextPresent("PREVIOUS SALES FOR THIS PROPERTY"));
			pass("Previous sales for this property heading is present");
		} catch (AssertionError e) {
			fail("Previous sales for this property heading is not present");
			takeScreenshot();
			resultcount++;
		}
		pass("Checking the fields for property sales history");
		try {
			Assert.assertTrue(verifyTextPresent("Source"));
			Assert.assertTrue(verifyTextPresent("Sale Type"));
			Assert.assertTrue(verifyTextPresent("Sale Date"));
			Assert.assertTrue(verifyTextPresent("Sale Price"));
			Assert.assertTrue(verifyTextPresent("Agent Name"));
			Assert.assertTrue(verifyTextPresent("Agency"));
			pass("Fields are all present");
		} catch (Exception e) {
			fail("Not all fields are present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void propertyListingAdvertisingHistory() throws Exception {
		//Fields & components
		pass("Checking the Advertising History heading");
		try {
			Assert.assertTrue(verifyTextPresent("LISTING ADVERTISING HISTORY"));
			pass("Listing Advertising History heading is present");
		} catch (AssertionError e) {
			fail("Listing Advertising History heading is not present");
			takeScreenshot();
			resultcount++;
		}
		pass("Checking the fields for listing advertising history");
		try {
			Assert.assertTrue(verifyTextPresent("Agency"));
			Assert.assertTrue(verifyTextPresent("Agent"));
			Assert.assertTrue(verifyTextPresent("Last Advertised"));
			Assert.assertTrue(verifyTextPresent("Advertised Price"));
			Assert.assertTrue(verifyTextPresent("Days Listed"));
			Assert.assertTrue(verifyTextPresent("Listing Type"));
			pass("Fields are all present");
		} catch (Exception e) {
			fail("Not all fields are present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void propertyRecentSuburbSales() throws Exception {
		// Fields & components
		pass("Checking the Recent Suburb Sales heading");
		try {
			Assert.assertTrue(verifyTextPresent("RECENT SUBURB SALES - HOUSES"));
			Assert.assertTrue(verifyTextPresent("RECENT SUBURB SALES - UNITS"));
			Assert.assertTrue(verifyTextPresent("RECENT SUBURB SALES - LAND"));
			pass("Recent Suburb Sales heading is present");
		} catch (AssertionError e) {
			fail("Recent Suburb Sales heading is not present");
			takeScreenshot();
			resultcount++;
		}
		pass("Checking the fields for Recent suburb sales");
		try {
			Assert.assertTrue(verifyTextPresent("Sale Date"));
			Assert.assertTrue(verifyTextPresent("Land Use"));
			Assert.assertTrue(verifyTextPresent("Zoning"));
			Assert.assertTrue(verifyTextPresent("Attributes"));
			pass("Fields are all present");
		} catch (Exception e) {
			fail("Not all fields are present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void propertyAreaProfile() throws Exception {
		// Fields & components
		pass("Checking the Area Profile headings & Sub-headings");
		try {
			Assert.assertTrue(verifyTextPresent("AREA PROFILE"));
			
			waitForElementPresent(xpath("Age to Sex Ratio"));
			Assert.assertTrue(verifyTextPresent("Age to Sex Ratio"));
			
			Assert.assertTrue(isElementPresent(xpath("")));
			waitForElementPresent(xpath("Household Income"));
			Assert.assertTrue(verifyTextPresent("Household Income"));
			
			Assert.assertTrue(isElementPresent(xpath("")));
			waitForElementPresent(xpath("Household Structure"));
			Assert.assertTrue(verifyTextPresent("Household Structure"));
			
			Assert.assertTrue(isElementPresent(xpath("")));
			waitForElementPresent(xpath("Household Occupancy"));
			Assert.assertTrue(verifyTextPresent("Household Occupancy"));
			Assert.assertTrue(isElementPresent(xpath("")));
			
			Assert.assertTrue(verifyTextPresent("HOUSE STATISTICS"));
			
			waitForElementPresent(xpath("Median Prices (12 Months)"));
			Assert.assertTrue(verifyTextPresent("Median Prices (12 Months)"));
			Assert.assertTrue(isElementPresent(xpath("")));
			
			waitForElementPresent(xpath("Median Prices (3 Years)"));
			Assert.assertTrue(verifyTextPresent("Median Prices (3 Years)"));
			Assert.assertTrue(isElementPresent(xpath("")));
			
			waitForElementPresent(xpath("Median Prices (10 Years)"));
			Assert.assertTrue(verifyTextPresent("Median Prices (10 Years)"));
			Assert.assertTrue(isElementPresent(xpath("")));
			
			Assert.assertTrue(verifyTextPresent("UNIT STATISTICS"));
			
			waitForElementPresent(xpath("Median Prices (12 Months)"));
			Assert.assertTrue(verifyTextPresent("Median Prices (12 Months)"));
			Assert.assertTrue(isElementPresent(xpath("")));
			
			waitForElementPresent(xpath("Median Prices (3 Years)"));
			Assert.assertTrue(verifyTextPresent("Median Prices (3 Years)"));
			Assert.assertTrue(isElementPresent(xpath("")));
			
			waitForElementPresent(xpath("Median Prices (10 Years)"));
			Assert.assertTrue(verifyTextPresent("Median Prices (10 Years)"));
			Assert.assertTrue(isElementPresent(xpath("")));
			
			Assert.assertTrue(verifyTextPresent("CADASTRAL MAP"));
			Assert.assertTrue(verifyTextPresent("AERIAL MAP"));
			Assert.assertTrue(verifyTextPresent("AREA MAP"));
			Assert.assertTrue(verifyTextPresent("DISCLAIMERS"));
			pass("Area Profile heading & chart headings are present");
		} catch (AssertionError e) {
			fail("Area Profile heading & chart headings are not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test
	public void reportCopyText() throws Exception {
		// Copy text for Thank you note
		pass("Checking the Thank You copy text");
		try {
			Assert.assertTrue(verifyTextPresent(ThanksNoteDPR));
			pass("Thank you copy text is present");
		} catch (AssertionError e) {
			fail("Thank you copy text is not present");
			takeScreenshot();
			resultcount++;
		}
		//Copy text Contact RP data
		pass("Checking the Contact RP data copy text");
		try {
			Assert.assertTrue(verifyTextPresent("Contact RP Data Pty Ltd:"));
			Assert.assertTrue(verifyTextPresent("If you have any questions about myrp.com.au, RP Data's Property Reports or RP Data Pty Ltd's other services please contact RP Data Pty Ltd by phone or email."));
			Assert.assertTrue(verifyTextPresent("Within Australia"));
			Assert.assertTrue(verifyTextPresent("1300 734 318"));
			Assert.assertTrue(verifyTextPresent("Outside Australia"));
			Assert.assertTrue(verifyTextPresent("(+61) 73114 9999"));
			Assert.assertTrue(verifyTextPresent("Email us: support@myrp.com.au"));
			pass("Contact RP Data details are present");
		} catch (AssertionError e) {
			fail("Contact RP Data details are not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test
	public void reportDisclaimers() throws Exception {
		pass("Checking the RP Data Disclaimers copy text");
		try {
			Assert.assertTrue(verifyTextPresent(RPDisclaimerCopyright));
			Assert.assertTrue(verifyTextPresent(RPDisclaimer));
			Assert.assertTrue(verifyTextPresent(AVMDisclaimer));
			pass("Diclaimer copy text is present");
		} catch (AssertionError e) {
			fail("Disclaimer copy text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
		
		// Check the State Disclaimer
		
		// GST Note
		pass("Checking the GST Note copy text");
		try {
			Assert.assertTrue(verifyTextPresent("All Prices are in Australian Dollars and include GST"));
			pass("GST Note copy text is present");
		} catch (AssertionError e) {
			fail("GST Note copy text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
