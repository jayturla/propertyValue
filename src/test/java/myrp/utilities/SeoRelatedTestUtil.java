package myrp.utilities;

import static org.openqa.selenium.By.xpath;

import org.testng.Assert;
import org.testng.annotations.Test;

import myrp.library.TestInitReference;
import myrp.utilities.SmokeTestUtil;

public class SeoRelatedTestUtil extends TestInitReference {
	private String propertyAddress = "12 Atami Place Picnic Point NSW 2213";
	private String streetAddress = "Maxwell Street South Turramurra NSW 2074";
	private String suburbAddress = "Lane Cove North NSW 2066";
	private String suburb = "";
	private String street = "";
	private String council = "";
	private String state = "";
	private String verifySuburbPhrase = "";
	private String verifyStreetPhrase = "";
	private String verifyCouncilPhrase = "";
	private String verifyStatePhrase = "";
	private String firstStreet = "";
	private String secondStreet = "";
	private String thirdStreet = "";
	private String fourthStreet = "";
	private String verifyFirstStreetPhrase = "";
	private String verifySecondStreetPhrase = "";
	private String verifyThirdStreetPhrase = "";
	private String verifyFourthStreetPhrase = "";
	private String firstSuburb = "";
	private String secondSuburb = "";
	private String thirdSuburb = "";
	private String fourthSuburb = "";
	private String verifyFirstSuburbPhrase = "";
	private String verifySecondSuburbPhrase = "";
	private String verifyThirdSuburbPhrase = "";
	private String verifyFourthSuburbPhrase = "";

	
	
	
	@Test
	public boolean verifyRelatedSearchPropertyTab() {
		try{
			pass("Verifying Related Searches in Property Tab started");
			searchAddress(propertyAddress);
			waitForElementPresent(xpath(smokeSuburbBreadCrumb_xp));
			suburb = getText(xpath(smokeSuburbBreadCrumb_xp));
			street = getText(xpath(smokeStreetBreadCrumb_xp));
			council = getText(xpath(smokeCouncilBreadCrumb_xp));
			state = getText(xpath(smokeStateBreadCrumb_xp));
			verifySuburbPhrase = "House Prices in " + suburb;
			verifySuburbPhrase = "House Prices in " + suburb;
			verifyCouncilPhrase = council + " property values";
			verifyStatePhrase = state + " property prices";
			Assert.assertEquals(verifySuburbPhrase, getText(xpath(txtSuburbSEO_xp)));
			Assert.assertEquals(verifyStreetPhrase, getText(xpath(txtStreetSEO_xp)));
			Assert.assertEquals(verifyCouncilPhrase, getText(xpath(txtCouncilSEO_xp)));
			Assert.assertEquals(verifyStatePhrase, getText(xpath(txtStateSEO_xp)));
			pass("Verifying Related Searches in Property Tab succeeded");
			return true;
		}catch(AssertionError e){
			fail("Verifying Related Searches in Property Tab failed");
			e.printStackTrace();
		}catch(Exception e){
			pass("Verifying Related Searches in Property Tab failed");
			e.printStackTrace();
		}
		return false;
	}
	
	@Test
	public boolean verifyRelatedSearchStreetTab() {
		try{
			pass("Verifying Related Searches in Street Tab started");
			searchAddress(streetAddress);
			waitForElementPresent(xpath(txt1stStreet_xp));
			firstStreet = getText(xpath(txt1stStreet_xp));
			secondStreet = getText(xpath(txt2ndStreet_xp));
			thirdStreet = getText(xpath(txt3rdStreet_xp));
			fourthStreet = getText(xpath(txt4thStreet_xp));
			verifyFirstStreetPhrase = firstStreet + " real estate sales";
			verifySecondStreetPhrase = secondStreet + " house hold prices";
			verifyThirdStreetPhrase = "real estate sales " + thirdStreet;
			verifyFourthStreetPhrase = fourthStreet + " recent sale prices";
			waitForElementPresent(xpath(txtFirstStreetPhraseSEO_xp));
			Assert.assertEquals(verifyFirstStreetPhrase, getText(xpath(txtFirstStreetPhraseSEO_xp)));
			Assert.assertEquals(verifySecondStreetPhrase, getText(xpath(txtSecondStreetPhraseSEO_xp)));
			Assert.assertEquals(verifyThirdStreetPhrase, getText(xpath(txtThirdStreetPhraseSEO_xp)));
			Assert.assertEquals(verifyFourthStreetPhrase, getText(xpath(txtFourthStreetPhraseSEO_xp)));
			pass("Verifying Related Searches in Street Tab succeeded");
			return true;
		}catch(AssertionError e){
			fail("Verifying Related Searches in Street Tab failed");
			e.printStackTrace();
		}catch(Exception e){
			fail("Verifying Related Searches in Street Tab failed");
			e.printStackTrace();
		}
		return false;
	}
	
	@Test
	public boolean verifyRelatedSearchSuburbTab() {
		try{
			pass("Verifying Related Searches in Suburb Tab started");
			searchAddress(suburbAddress);
			waitForElementPresent(xpath(txt1stSuburb_xp));
			firstSuburb = getText(xpath(txt1stSuburb_xp));
			secondSuburb = getText(xpath(txt2ndSuburb_xp));
			thirdSuburb = getText(xpath(txt3rdSuburb_xp));
			fourthSuburb = getText(xpath(txt4thSuburb_xp));
			verifyFirstSuburbPhrase = "House Prices " + firstSuburb;
			verifySecondSuburbPhrase = "Property Data Mount " + secondSuburb;
			verifyThirdSuburbPhrase = "Sold Prices " + thirdSuburb;
			verifyFourthSuburbPhrase = "Sold Property Prices " + fourthSuburb;
			
			waitForElementPresent(xpath(txtFirstSuburbPhraseSEO_xp));
			Assert.assertEquals(verifyFirstSuburbPhrase, getText(xpath(txtFirstSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifySecondSuburbPhrase, getText(xpath(txtSecondSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifyThirdSuburbPhrase, getText(xpath(txtThirdSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifyFourthSuburbPhrase, getText(xpath(txtFourthSuburbPhraseSEO_xp)));
			
			pass("Verifying Related Searches in Suburb Tab succeeded");
			return true;
		}catch(AssertionError e){
			fail("Verifying Related Searches in Suburb Tab failed");
			e.printStackTrace();
		}catch(Exception e){
			fail("Verifying Related Searches in Suburb Tab failed");
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Test
	public boolean verifyRelatedSearchSuburbMap() {
		try{
			pass("Verifying Related Searches in Suburb Map started");
			searchAddress(suburbAddress);
			waitForElementPresent(xpath(btnSuburbMapSEO_xp));
			click(xpath(btnSuburbMapSEO_xp));
			waitForElementPresent(xpath(txtFirstSuburbPhraseSEO_xp));
			Assert.assertEquals(verifyFirstSuburbPhrase, getText(xpath(txtFirstSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifySecondSuburbPhrase, getText(xpath(txtSecondSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifyThirdSuburbPhrase, getText(xpath(txtThirdSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifyFourthSuburbPhrase, getText(xpath(txtFourthSuburbPhraseSEO_xp)));
			pass("Verifying Related Searches in Suburb Map succeeded");
			return true;
		}catch(AssertionError e){
			fail("Verifying Related Searches in Suburb Map failed");
			e.printStackTrace();
		}catch(Exception e){
			fail("Verifying Related Searches in Suburb Map failed");
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	@Test
	public boolean verifyRelatedSearchKeyStats(){
		try{
			pass("Verifying Related Searches in Key Stats started");
			searchAddress(suburbAddress);
			waitForElementPresent(xpath(btnKeyStatsSEO_xp));
			click(xpath(btnKeyStatsSEO_xp));
			waitForElementPresent(xpath(txtFirstSuburbPhraseSEO_xp));
			Assert.assertEquals(verifyFirstSuburbPhrase, getText(xpath(txtFirstSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifySecondSuburbPhrase, getText(xpath(txtSecondSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifyThirdSuburbPhrase, getText(xpath(txtThirdSuburbPhraseSEO_xp)));
			Assert.assertEquals(verifyFourthSuburbPhrase, getText(xpath(txtFourthSuburbPhraseSEO_xp)));
			pass("Verifying Related Searches in Key Stats succeeded");
			return true;
		}catch(AssertionError e){
			fail("Verifying Related Searches in Key Stats failed");
			e.printStackTrace();
		}catch(Exception e){
			fail("Verifying Related Searches in Key Stats failed");
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Test
	public boolean verifyRelatedSearchLocalExpertsTab(){
		try{
			
			String verifyLocalExpertsStatePhrase = state + " Property Prices";
			String verifyLocalExpertsCouncilPhrase = "House Sales " + council;
			String verifyLocalExpertsPropertyPhrase = "Property Report";
			String verifyLocalExpertsTitlePhrase = "Title Search";
			pass("Verifying Related Searches in Local Experts started");
			searchAddress(propertyAddress);
			waitForElementPresent(xpath(btnLocalExpertsSEO_xp));
			click(xpath(btnLocalExpertsSEO_xp));
			waitForElementPresent(xpath(txtFirstLocalExpertPhraseSEO_xp));
			Assert.assertEquals(verifyLocalExpertsStatePhrase, getText(xpath(txtFirstLocalExpertPhraseSEO_xp)));
			Assert.assertEquals(verifyLocalExpertsCouncilPhrase, getText(xpath(txtSecondLocalExpertPhraseSEO_xp)));
			Assert.assertEquals(verifyLocalExpertsPropertyPhrase, getText(xpath(txtThirdLocalExpertPhraseSEO_xp)));
			Assert.assertEquals(verifyLocalExpertsTitlePhrase, getText(xpath(txtFourthLocalExpertPhraseSEO_xp)));
			pass("Verifying Related Searches in Local Experts succeeded");
			return true;
		}catch(AssertionError e){
			fail("Verifying Related Searches in Local Experts failed");
			e.printStackTrace();
			
		}catch(Exception e){
			fail("Verifying Related Searches in Local Experts failed");
			e.printStackTrace();
			
		}
		
		return false;
	}
	
	@Test
	public boolean verifyRelatedSearchStreetWithLessThanFourBorderingStreet(){
		try{
			pass("Verifying Related Searches with less than four bordering street started");
			searchAddress("Cavenagh Road Anmatjere NT 0872");
			waitForElementPresent(xpath(txt1stStreet_xp));
			firstStreet = getText(xpath(txt1stStreet_xp));
			verifyFirstStreetPhrase = firstStreet + " real estate sales";
			verifySecondStreetPhrase = firstStreet + " house hold prices";
			verifyThirdStreetPhrase = "real estate sales " + firstStreet;
			verifyFourthStreetPhrase = firstStreet + " recent sale prices";
			Assert.assertEquals(verifyFirstStreetPhrase, getText(xpath(txtFirstStreetPhraseSEO_xp)));
			Assert.assertEquals(verifySecondStreetPhrase, getText(xpath(txtSecondStreetPhraseSEO_xp)));
			Assert.assertEquals(verifyThirdStreetPhrase, getText(xpath(txtThirdStreetPhraseSEO_xp)));
			Assert.assertEquals(verifyFourthStreetPhrase, getText(xpath(txtFourthStreetPhraseSEO_xp)));
			pass("Verifying Related Searches in Local Experts succeeded");
			return true;
		}catch(AssertionError e){
			fail("Verifying Related Searches with less than four bordering street failed");
			e.printStackTrace();
		}catch(Exception e){
			fail("Verifying Related Searches with less than four bordering street failed");
			e.printStackTrace();
		}
		return false;
	}
	
	@Test
	public boolean verifyRelatedSearchSuburbWithoutRelatedSearch(){
		try{
			pass("Verifying Related Search Suburb without related search started");
			searchAddress("Port Lincoln SA 5606");
			Thread.sleep(2000);	
			if(isRelatedSuburbSearchPresent()){
				pass("Verifying Related Search Suburb without related search failed");
				return false;
			}else{
				pass("Verifying Related Search Suburb without related search succeeded");
				return true;
			}
		}catch(AssertionError e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pass("Verifying Related Search Suburb without related search failed");
		return false;
	}
	
	
	
	
	
	
	
	public void searchAddress(String address) throws Exception {
		waitForElementPresent(xpath(smokeSearchLine_xp));
		
		type(xpath(smokeSearchLine_xp), address);
		click(xpath(search_button_xp));
		waitForElementPresent(xpath(smokeSearchAddress_xp));
		
		try{
			pass(" - Test: " + address + " is present");

		}
		catch(Exception e){
			fail(" - Test: " + address + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}
	
	public boolean isRelatedSuburbSearchPresent(){
		try{
			Assert.assertTrue(verifyTextPresent("txtFirstSuburbPhraseSEO_xp"));
			return true;
		}catch(Exception e){
			
		}catch(AssertionError e){
		
		}
		
		
		return false;
	}
	
	
	
}
