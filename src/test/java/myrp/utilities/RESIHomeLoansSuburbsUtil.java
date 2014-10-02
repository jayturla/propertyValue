package myrp.utilities;

import static org.openqa.selenium.By.xpath;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RESIHomeLoansSuburbsUtil extends TestInitReference {
	String suburbsInfo = rxml.data("suburbs_Info");
	String suburb = rxml.data("suburbfree_price");
	String sample = rxml.data("viewSample_link");
	
	@Test(description = "RP Data Resi Home Loans Report Infos")
	public void verifyReportInfo() throws Exception {
		click(xpath(resiSuburbs_tab_xp));
		try {
			Assert.assertEquals(suburbsInfo, getText(xpath(resi_Info_xp)));
			pass(suburbsInfo + " , Free Suburb Report description is correct" );
		} catch (AssertionError e) {
			fail("Free Suburb Report description is wrong");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	@Test(description = "RP Data Resi Home Loans Report Price")
	public void verifyReportPrice() throws Exception {
		try {
			Assert.assertEquals(suburb, getText(xpath(resi_price_xp)));
			pass("Free Suburb report is " + suburb );
		} catch (AssertionError e) {
			fail("Free Suburb Report price is wrong");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
}
