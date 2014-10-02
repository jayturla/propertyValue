package mobile.test;

import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class SearchUtil extends TestInitReference {

	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Property Search";
	String streetSearch = rxml.data("streetSearchMobile_val");
	
	@Test
	public void streetSearch() throws Exception {
		waitForElementPresent(xpath(slasMobile_xp));
		type(xpath(slasMobile_xp), streetSearch);
//		click(xpath(slasMobile_xp));
		 Thread.sleep(5000);
	}
}
