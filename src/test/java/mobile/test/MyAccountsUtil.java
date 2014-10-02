package mobile.test;

import static org.openqa.selenium.By.xpath;
import myrp.library.ObjectReference;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsUtil extends TestInitReference {
	@Test
	public void tabs() throws Exception {
		pass("Checking if My Reports & My Details");
		waitForElementsPresent(xpath(ObjectReference.MyReportsTab_xp), xpath(ObjectReference.MyDetailsTab_xp),10);
		try {
			Assert.assertEquals(10, areAllElementsPresent(xpath(ObjectReference.MyReportsTab_xp), xpath(ObjectReference.MyDetailsTab_xp)));
			pass("My Reports & My Details Tab are present");
		} catch (Exception e) {
			fail("My Reports and/or My Details Tab are not present");
			takeScreenshot();
			resultcount++;
		}
	}
	
	@Test
	public void heading() throws Exception {
		pass("Checking if heading is present");
		try {
			Assert.assertTrue(verifyTextPresent("My Account"));
			pass("My Accounts heading is present");
		} catch (Exception e) {
			fail("My Accounts heading is not present");
			takeScreenshot();
			resultcount++;
		}
		
	}
}
