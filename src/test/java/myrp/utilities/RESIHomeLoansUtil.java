package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansUtil extends TestInitReference {
	String testCase0 = "RESI Home Loans";
	String heading = rxml.data("heading_val");
	
	String sample = rxml.data("viewSample_link");
	String placeholder1 = rxml.data("placeholderProperties");
	String placeholder2 = rxml.data("placeholderSuburbs");

	@Test(description = "RP Data Resi Home Loans - Heading")
	public void verifyHeading() throws Exception {
		waitForElementPresent(xpath(resiHeading_label_xp));

		try {
			Assert.assertTrue(isElementPresent(xpath(resiHeading_label_xp)));
			pass(heading + " is present");
		} catch (AssertionError e) {
			fail(heading + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals(heading, getText(xpath(resiHeading_label_xp)));
			pass(heading + " is correct");
		} catch (AssertionError e) {
			fail(heading + " is incomplete");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "RP Data Resi Home Loans Tab")
	public void verifyTabs() throws Exception {
		waitForElementPresent(xpath(resiHeading_label_xp));

		try {
			By xpaths[] = { xpath(resiProperties_tab_xp), xpath(resiSuburbs_tab_xp) };
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass("Properties and Suburbs tab are present");
		} catch (AssertionError e) {
			fail(" Properties and Suburbs tab are not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "RP Data Resi Home Loans on tab click")
	public void tabClick() throws Exception {
		waitForElementPresent(xpath(resiHeading_label_xp));
		click(xpath(resiProperties_tab_xp));
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_Info_xp)));
			pass("Properties tab is highlighted");
		} catch (AssertionError e) {
			fail("Properties tab is not clicked");
			takeScreenshot();
			resultcount++;
		}
		try {
			click(xpath(resiSuburbs_tab_xp));
			Assert.assertTrue(isElementPresent(xpath(resi_Info_xp)));
			pass("Suburbs tab is highlighted");
		} catch (AssertionError e) {
			fail("Suburbs tab is not clicked");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "RP Data Resi Home Loans Report SLAS")
	public void verifySLAS() throws Exception {
		waitForElementPresent(xpath(resiHeading_label_xp));
		click(xpath(resiProperties_tab_xp));
		try { // To test if SLAS is present
			Assert.assertTrue(isElementPresent(xpath(resi_slas_xp)));
			pass("SLAS is present");
		} catch (AssertionError e) {
			fail("SLAS is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "RP Data Resi Home Loans Report SLAS placeholder")
	public void verifyPlaceholder() throws Exception {
		waitForElementPresent(xpath(resiHeading_label_xp));
		click(xpath(resiProperties_tab_xp));
		try { 
			Assert.assertTrue(isElementPresent(By.xpath(placeHolder(placeholder1))));
			pass(placeholder1 + " placeholder is present");
		} catch (AssertionError e) {
			fail(placeholder1 + " Properties tab placeholder is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			click(xpath(resiSuburbs_tab_xp));
			Assert.assertTrue(isElementPresent(By
					.xpath(placeHolder(placeholder2))));
			pass(placeholder2 + " placeholder is present");
		} catch (AssertionError e) {
			fail(placeholder2 + " Suburbs tab placeholder text is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "Verify if search button is present")
	public void searchBtn() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_searchbtn_xp)));
			pass("Search button is present");
		} catch (AssertionError e) {
			fail("Search button is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "Verify if CFA button is present")
	public void CFAbtn() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_CFAbtn_xp)));
			pass("Can't Find Address button is present");
		} catch (AssertionError e) {
			fail("Can't Find Address button is not present");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "Verify if CFA button is removed")
	public void removeCFAbtn() throws Exception {
		try {
			Assert.assertFalse(isElementPresent(xpath(resi_CFAbtn_xp)));
			pass("Can't Find Address button is removed");
		} catch (AssertionError e) {
			fail("Can't Find Address button is not removed");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	@Test(description = "To test if View sample report link is present")
	public void verifySampleReportLink() throws Exception {
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_viewSampleReport_xp)));
			pass("View sample report link is present");
		} catch (AssertionError e) {
			fail("View sample report link is not present");
			takeScreenshot();
			resultcount++;
		}
		try { // To test if link text is correct
			Assert.assertEquals(sample, getText(xpath(resi_viewSampleReport_xp)));
			pass(sample + " in Suburbs tab is correct");
		} catch (AssertionError e) {
			fail(sample + " in Suburbs tab is not correct");
			takeScreenshot();
			resultcount++;
		}
		try { // To test if link can be clicked
			click(xpath(resi_viewSampleReport_xp));
			pass(sample + " in Properties tab is clickable");
		} catch (AssertionError e) {
			fail(sample + " in Properties tab is not clickable");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
