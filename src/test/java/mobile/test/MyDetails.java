package mobile.test;

import myrp.library.TestInitReference;
import static org.openqa.selenium.By.xpath;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyDetails extends TestInitReference {

	@Test
	public void checkFields() throws Exception {
		pass("Checking the labels in My Details");
		try {
			Assert.assertTrue(verifyTextPresent("First Name"));
			Assert.assertTrue(verifyTextPresent("Last Name"));
			Assert.assertTrue(verifyTextPresent("Email"));
			Assert.assertTrue(verifyTextPresent("Security Question"));
			Assert.assertTrue(verifyTextPresent("Answer to security question"));
			Assert.assertTrue(verifyTextPresent("Password"));
			Assert.assertTrue(verifyTextPresent("Change Password"));
			Assert.assertTrue(verifyTextPresent("Communication preference"));
			Assert.assertTrue(verifyTextPresent("I wish to receive MyRp Newsletter and other RPData communucations"));
			pass("My Details labels are all present");
		} catch (AssertionError e) {
			fail("My Details labels are not all present");
			takeScreenshot();
			resultcount++;
		}
	}
	
	@Test
	public void changePassword() throws Exception {
		
	}
	
	@Test
	public void fieldsValidation() throws Exception {
		
	}
	

}
