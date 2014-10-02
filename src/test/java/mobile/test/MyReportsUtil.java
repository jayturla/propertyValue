package mobile.test;

import static org.openqa.selenium.By.xpath;
import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyReportsUtil extends TestInitReference {

	ReadXmlData rxml = new ReadXmlData();
	String testCase0 = "RP Data Mobile - My Reports";
	String RPDisclaimerCopyright = rxml.data("RPDisclaimerCopyright");
	String RPDisclaimer = rxml.data("RPDisclaimer");
	String AVMDisclaimer = rxml.data("AVMDisclaimer");

	@Test
	public void buttons() throws Exception {
		pass("Checking buttons in My Reports tab");
		waitForMultipleElements(10, xpath(MyPurchasesBtn_xp),
				xpath(MyValuationsBtn_xp), xpath(MyTrackedPropertiesBtn_xp),
				xpath(MyMapsBtn_xp));
		try {
			Assert.assertTrue(verifyMultipleElements(10,
					xpath(MyPurchasesBtn_xp), xpath(MyValuationsBtn_xp),
					xpath(MyTrackedPropertiesBtn_xp), xpath(MyMapsBtn_xp)));
			pass("All buttons in My Reports tab are present");
		} catch (AssertionError e) {
			fail("Not all buttons are present");
			takeScreenshot();
			resultcount++;
		}
	}

	public void checkDisclaimer() throws Exception {
		pass("Checking the Disclaimer in My Reports tab");
		try {
			Assert.assertTrue(verifyTextPresent(RPDisclaimerCopyright));
			Assert.assertTrue(verifyTextPresent(RPDisclaimer));
			Assert.assertTrue(verifyTextPresent(AVMDisclaimer));
			pass("RP Data Disclaimer and AVM Diclaimer is present");
		} catch (AssertionError e) {
			fail("RP Data Disclaimer and/or AVM Diclaimer not present or incorrect");
			takeScreenshot();
			resultcount++;
		}
	}

	@Test
	public void withNoPurchases() throws Exception {
		// User has no purchases
		pass("Checking the copy text if user has no purchases in My Purchases page");
		click(xpath(loginMButton_xp));
		waitForElementPresent(xpath(MyPurchasesBtn_xp));
		click(xpath(MyPurchasesBtn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("You do not have any report purchases yet."));
			pass("Copy text for My Purchases is correct");
		} catch (AssertionError e) {
			fail("Copy text for My Purchases incorrect");
			takeScreenshot();
			resultcount++;
		}
		// User has no valuations
		pass("Checking the copy text if user has no valuations in My Valuations page");
		click(xpath(loginMButton_xp));
		waitForElementPresent(xpath(MyValuationsBtn_xp));
		click(xpath(MyValuationsBtn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("You do not have any valuation report purchases yet."));
			pass("Copy text for My Valuations is correct");
		} catch (AssertionError e) {
			fail("Copy text for My Valuations incorrect");
			takeScreenshot();
			resultcount++;
		}
		// User has no tracked properties
		pass("Checking the copy text if user has no portfolio in My Tracked Properties page");
		click(xpath(loginMButton_xp));
		waitForElementPresent(xpath(MyTrackedPropertiesBtn_xp));
		click(xpath(MyTrackedPropertiesBtn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("You currently have no properties in your portfolio."));
			pass("Copy text for My Tracked Properties is correct");
		} catch (AssertionError e) {
			fail("Copy text for My Tracked Properties incorrect");
			takeScreenshot();
			resultcount++;
		}
		// User has no map subscriptions
		pass("Checking the copy text if user has no map subscriptions in My Maps page");
		click(xpath(loginMButton_xp));
		waitForElementPresent(xpath(MyMapsBtn_xp));
		click(xpath(MyMapsBtn_xp));
		try {
			Assert.assertTrue(verifyTextPresent("What do you think it’s worth?"));
			Assert.assertTrue(verifyTextPresent("RP Property Estimate Map is myrpdata’s latest product. This product provides a fully automated estimate for most residential properties in Australia."));
			Assert.assertTrue(verifyTextPresent("Do you want to know the most recent sales price of every property in a suburb?"));
			Assert.assertTrue(verifyTextPresent("My Property Sales Map is myrpdata's newest product."));
			Assert.assertTrue(verifyTextPresent("It gives you the ability to find a sales price and sale date of every house and unit in a suburb within the past 3 years."));
			Assert.assertTrue(verifyTextPresent("Get started now by selecting the suburbs of your interests (not available for the State of Victoria)."));
			pass("Copy text for My Maps is correct");
		} catch (AssertionError e) {
			fail("Copy text for My Maps incorrect");
			takeScreenshot();
			resultcount++;
		}
	}



	public void withPurchases() throws Exception {

	}

	public void myValuations() throws Exception {

	}

	public void myTrackedProperties() throws Exception {

	}

	public void myMaps() throws Exception {

	}
}
