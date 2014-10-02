package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansPropertiesUtil extends TestInitReference {
	String testCase0 = "RESI Home Loans";
	String propertiesInfo = rxml.data("properties_Info");
	String detailed = rxml.data("detailed_price");
	String sample = rxml.data("viewSample_link");

	@Test(description = "RP Data Resi Home Loans Report Infos")
	public void verifyReportInfo() throws Exception {
		waitForElementPresent(xpath(resiHeading_label_xp));
		click(xpath(resiProperties_tab_xp));
		try {
			Assert.assertEquals(propertiesInfo, getText(xpath(resi_Info_xp)));
			pass(propertiesInfo + " , Detailed Property Report description is correct" );
		} catch (AssertionError e) {
			fail("Detailed Property Report description is wrong");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "RP Data Resi Home Loans Report Price")
	public void verifyReportPrice() throws Exception {
		waitForElementPresent(xpath(resiHeading_label_xp));
		click(xpath(resiProperties_tab_xp));
		try {
			Assert.assertEquals(detailed, getText(xpath(resi_price_xp)));
			pass("Detailed report price is " + detailed);
		} catch (AssertionError e) {
			fail("Detailed Report price is wrong");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
}
