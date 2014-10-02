package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansSearchUtil extends TestInitReference {
	String search_val1 = rxml.data("address_search_val");
	String search_val2 = rxml.data("suburb_search_val");


	@Test(description = "RP Data Resi Home Loans Property Search")
	public void searchAddress() throws Exception {
		waitForElementPresent(xpath(resiProperties_tab_xp));
		click(xpath(resi_slas_text_xp));
		type(xpath(resi_slas_text_xp), search_val1);
		Thread.sleep(5000);
		waitForElementPresent(xpath(resi_slas_select_xp));
		click(xpath(resi_slas_select_xp));
		waitForElementPresent(xpath(resi_address_label_xp));
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_address_label_xp)));
			pass("Searched property: " + search_val1);
		} catch (AssertionError e) {
			fail("Error in searching for property: " + search_val1);
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "RP Data Resi Home Loans Suburb Search")
	public void searchSuburb() throws Exception {
		click(xpath(resiSuburbs_tab_xp));
		click(xpath(resi_slas_text_xp));
		type(xpath(resi_slas_text_xp), search_val2);
		Thread.sleep(5000);
		waitForElementPresent(xpath(resi_slas_select_xp));
		click(xpath(resi_slas_select_xp));
		waitForElementPresent(xpath(resi_address_label_xp));
		try {
			Assert.assertTrue(isElementPresent(xpath(resi_address_label_xp)));
			pass("Searched suburb: " + search_val2);
		} catch (AssertionError e) {
			fail("Error in searching for property suburb: " + search_val2);
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
}
