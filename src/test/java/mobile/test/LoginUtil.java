package mobile.test;

import static org.openqa.selenium.By.xpath;
import myrp.library.ObjectReference;
import myrp.library.TestInitReference;
import myrp.library.ReadXmlData;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUtil extends TestInitReference {

	// private String[] input;
	// private String testCase = "";
	//
	// public LoginUtil(String[] i) {
	// input = i;
	// }
	//
	// @Test(dataProvider = "Data-Provider-Function")
	// public void login() throws Exception {
	// testCase = "MyRP Mobile Login: " + input[0];
	// resultcount = 0;
	//
	// waitForElementPresent(xpath(userIcon_xp));
	// click(xpath(userIcon_xp));
	// waitForElementPresent(xpath(loginMButton_xp));
	// click(xpath(loginMButton_xp));
	// type(xpath(emailMField_xp), input[1]);
	// type(xpath(password_xp), input[2]);
	//
	// }

	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Mobile - Login";
	String validEmail = rxml.data("validEmail");
	String validPassword = rxml.data("smokePassword");

	@Test
	public void login() throws Exception {
		waitForElementPresent(xpath(ObjectReference.userIcon_xp));
		click(xpath(ObjectReference.userIcon_xp));
		waitForElementPresent(xpath(ObjectReference.loginMButton_xp));
		click(xpath(ObjectReference.loginMButton_xp));
		type(xpath(ObjectReference.emailMField_xp), validEmail);
		type(xpath(ObjectReference.passwordMField_xp), validPassword);
		click(xpath(ObjectReference.login2mButton_xp));
		pass("User successfully logged-in");
		try {
			Assert.assertTrue(verifyTextPresent("My Account"));
			pass("User successfully logged-in and redirected to My Account page");
		} catch (Exception e) {
			fail("Did not login successfully");
			takeScreenshot();
			resultcount++;
		}
	}
	
	@Test
	public void loginNoPurchase() throws Exception {
		waitForElementPresent(xpath(ObjectReference.userIcon_xp));
		click(xpath(ObjectReference.userIcon_xp));
		waitForElementPresent(xpath(ObjectReference.loginMButton_xp));
		click(xpath(ObjectReference.loginMButton_xp));
		type(xpath(ObjectReference.emailMField_xp), "twistqatest01@test.com");
		type(xpath(ObjectReference.passwordMField_xp), "123456");
		click(xpath(ObjectReference.login2mButton_xp));
		pass("User successfully logged-in");
		try {
			Assert.assertTrue(verifyTextPresent("My Account"));
			pass("User successfully logged-in and redirected to My Account page");
		} catch (Exception e) {
			fail("Did not login successfully");
			takeScreenshot();
			resultcount++;
		}
	}
}
