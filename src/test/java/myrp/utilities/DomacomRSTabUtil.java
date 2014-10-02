package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.FunctionReference;
import myrp.library.ReadXmlData;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DomacomRSTabUtil extends FunctionReference {
	ReadXmlData rxml = new ReadXmlData();
	String testCase = "RP Data Reports and Services";
	String RSLabel = rxml.data("reportsServicesLabel");

	@Test(description = "RP Data Reports and Services")
	public void reportsAndServices() throws Exception {
		pass("Test Report: RP Data Reports and Services " + browser
				+ " browser");
		waitForElementPresent(xpath(footerReportsAndServices_link_xp));
		click(xpath(footerReportsAndServices_link_xp));
		waitForElementPresent(xpath(reportsAndServices_label_xp));
		try {
			Assert.assertEquals(RSLabel,
					getText(xpath(reportsAndServices_label_xp)));
		} catch (AssertionError e) {
			fail(RSLabel + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			By xpaths[] = { xpath("//div/a[.='Property Reports']"),
					xpath("//div/a[.='Street Reports']"),
					xpath("//div/a[.='Suburb Reports']"),
					xpath("//div/a[.='Infographic']") };
			Assert.assertTrue(verifyMultipleElements(10, xpaths));
			pass("Property Reports, Street Reports, Suburb Reports, Infographic are displayed on Reports and Services page");

			boolean elementPresent = isElementPresent(xpath("//div/a[.='Property Services']"));
			Assert.assertFalse(elementPresent);
			pass("Property service tab is removed on the page");

		} catch (AssertionError e) {
			fail("Error: Reports and Services tab(s)");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
