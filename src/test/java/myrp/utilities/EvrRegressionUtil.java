package myrp.utilities;


import static org.openqa.selenium.By.xpath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import myrp.library.EVRObjectReference;
import myrp.library.FunctionReference;
import myrp.library.ObjectReference;
import myrp.library.RegressionObjectReference;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class EvrRegressionUtil extends FunctionReference {
	
	private String[] input = null;
	private String testCase = "";
	private boolean checkifAU = true;
	private String joborder ="";
	private boolean contactCalledIsChecked = false;
	private boolean readonly = false;	
	public String propertyType = "";
	public String bedrooms = "";
	public String bathrooms ="";
	public String carSpaces = "";
	public String carAccomodations = "";
	public String wall = "";
	public String roof = "";
	public String builtAbout = "";
	public String livingArea = "";
	public String landArea = "";
	public String lotPlan = "";
	public String lga = "";
	public String zoning = "";
	public String lastSaleDate = "";
	public String lastSalePrice ="";
	public String additionalAbout = "";
	
	public String getBedrooms() {
		return bedrooms;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public boolean isContactCalledIsChecked() {
		return contactCalledIsChecked;
	}

	public boolean isCheckifAU() {
		return checkifAU;
	}

	public void setCheckifAU(boolean checkifAU) {
		this.checkifAU = checkifAU;
	}

	public EvrRegressionUtil(String[] i) {
			input = i;
	}
	
	public void completeMandatoryFieldsInVerifyData()throws Exception{
		selectBedRooms(5);
		selectBathrooms(3);
		selectCarSpace(3);
		selectCarAccomodation(3);
		selectWall(3);
		selectRoof(3);
		enterValueInBuiltAbout(input[3]);
		enterValueInLivingArea(input[4]);
		clickIHaveCalledTheContact();
	}
	
	public boolean checkForModalMessageSuccesfullSubmission() throws Exception{
		boolean message = false;
		String text = "";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.modalBoxSuccesfullSubmission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.modalBoxSuccesfullSubmission)));
			text = getText(xpath(RegressionObjectReference.modalBoxSuccesfullSubmission));
			
			if(text.contains("Your valuation has been submitted successfully")){
				message = true;
				log("Modal Message is: "+text+"");
			}
		} catch (Exception e) {
			log("Unable to locate Element ModalBox");
		}
		
		return message;
	}
	
	public boolean checkForModalMessageValidationException() throws Exception{
		boolean message = false;
		String text = "";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.modalBoxSuccesfullSubmission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.modalBoxSuccesfullSubmission)));
			text = getText(xpath(RegressionObjectReference.modalBoxSuccesfullSubmission));
			
			if(text.contains("You have selected one or more sales that have a sales price that greater than")){
				message = true;
				log("Modal Message is: "+text+"");
			}
		} catch (Exception e) {
			log("Unable to locate Element ModalBox");
		}
		
		return message;
	}
	
	public void clickIHaveCalledTheContact() throws Exception{
		try {
			waitForElementPresent(xpath(RegressionObjectReference.iHaveCalledTheContact));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.iHaveCalledTheContact)));
			click(xpath(RegressionObjectReference.iHaveCalledTheContact));
			log("Click on I have called the contact");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element I Have Called the contact");
		}
	}
	
	public void checkingDataPopulatedInVerifyData() throws Exception{
		checkPropertyTypeValue();
		checkBedRoomValue();
		checkBathroomValue();
		checkCarSpaceValue();
		checkCarAccomValue();
		checkBuiltAboutValue();
		checkLandAreaValue();
		checkLivingAreaValue();
		checkMainWallValue();
		checkRoofValue();
		checkLotPlanValue();
		checkLGAValue();
		checkZoningValue();
		checkAdditionalAboutValue();
		checkLastSaleDate();
		checkLastSalePrice();
	}
	
	public ArrayList<String> getAddedPropertyinShortListPage() throws Exception{
		ArrayList<String> addedProperty_shortlist = new ArrayList<String>();
		String address = "";
		
		try {
			waitForElementPresent(xpath(RegressionObjectReference.addressShortList));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.addressShortList)));
			int count= driver.findElements(By.xpath(RegressionObjectReference.addressShortList)).size();
			int c = 1;
			
			while(c <= count){
				waitForElementPresent(xpath("("+RegressionObjectReference.addressShortList+")["+c+"]"));
				Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.addressShortList+")["+c+"]")));
				address = getText(xpath("("+RegressionObjectReference.addressShortList+")["+c+"]"));
				log("Adding On the List "+address+"");
				addedProperty_shortlist.add(address);
				c++;
			}
		} catch (AssertionError e) {
			log("Unable to locate Elemetn short List Container");
		}
		return addedProperty_shortlist;
	}
	
	//checking the Data or Added Property in ShortList Vs Submission Page
	public boolean confirmDataFromSalesEvidenceVsSubmission(ArrayList<String> addedProp1, ArrayList<String> addedProp2)throws Exception{
		boolean vs = false;
		if(addedProp2 != null && addedProp2 != null){
			for (String sl : addedProp1) {
				for (String su : addedProp2) {
					if(su.equalsIgnoreCase(sl)){
						vs = true;
						break;
					}else{
						vs = false;
					}
				}
			}
		}
		return vs;
	}
	
	public ArrayList<String> getAddedPropertyinSubmissionPage() throws Exception{
		ArrayList<String> addedProperty_submission = new ArrayList<String>();
		String address = "";
		int row = 7;
		String se_address = "";
		//path for getting all address that has been added in short list tab
		String addressListinSe = "//*[@class='fontStyle_14 lineHeight_25']//tr//*[@class='salesData'][2]";
	
		try {
			waitForElementPresent(xpath(addressListinSe));
			Assert.assertTrue(isElementPresent(xpath(addressListinSe)));
			int count= driver.findElements(By.xpath(addressListinSe)).size();
			int c = 1;
			
			while(c <= count){
				se_address = "(//*[@class='fontStyle_14 lineHeight_25']//tr)["+row+"]//*[@class='salesData'][2]";
				waitForElementPresent(xpath(se_address));
				Assert.assertTrue(isElementPresent(xpath(se_address)));
				
				address = getText(xpath(se_address));
				log("Adding On the List "+address+"");
				addedProperty_submission.add(address);
				c++; 
				//adding 5 because there is an excess row in the table
				row = row + 5;
			}
		} catch (AssertionError e) {
			log("Unable to locate Elemetn Sales Evidence Container");
		}
		return addedProperty_submission;
	}
	
	//adding vg sales only based on input numLoop
	public void addingPropertyVG(int numLoop) throws Exception{
		waitForElementPresent(xpath(RegressionObjectReference.logoSalesResult));
		Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.logoSalesResult)));
		int count= driver.findElements(By.xpath(RegressionObjectReference.logoSalesResult)).size();
		int c = 1;
		
		while( c <= count ) {
			WebElement element = driver.findElement(By.xpath("("+RegressionObjectReference.logoSalesResult+")["+c+"]"));
			String src = ((JavascriptExecutor)driver).executeScript("return arguments[0].attributes['src'].value;", element).toString();
			
			String labelAddRemove="";
			try {
				waitForElementPresent(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]"));
				Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]")));
				labelAddRemove = getText(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]"));
			} catch (AssertionError e1) {
				
			}
			
			if(src.equalsIgnoreCase("/ttsvr/cropImage/evr.images.evr_i_vgLogo.png") && labelAddRemove.equalsIgnoreCase("Add this property")){
				try {
					Thread.sleep(2000);
					addRemoveProperty(c);
					enterCommentinSEList(input[5], c);
					clickInferior(c);
					System.out.println("Succesfully Add the Property "+c+"");
					numLoop--;
				} catch (AssertionError e) {
					System.out.println("Unable to Locate Element Add Remove "+c+"");
					numLoop--;
				}
				
				if(numLoop == 0){
					break;
				}
			}	
			c++;
	    }
	}
	
	//checking if the comparablilty button is visible according to the number in list
	public boolean isComparabilityButtonVisibleByNumber(int numList)throws Exception{
		boolean isComparabilityButtonVisibleByNumber =false;
		
		try {
			String comparability = "";
					
			waitForElementPresent(xpath("("+RegressionObjectReference.comparbilityButtonContainer+")["+numList+"]"));
			Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.comparbilityButtonContainer+")["+numList+"]")));
			List<WebElement> comparabilityButton = driver.findElements(By.xpath("("+RegressionObjectReference.comparbilityButtonContainer+")["+numList+"]"));
					
			for (WebElement element: comparabilityButton) {
			comparability = element.getText();
				if(comparability.contains("Inferior")){
					isComparabilityButtonVisibleByNumber = true;
					log("Comparability Button is visible");
					break;
				}else{
					isComparabilityButtonVisibleByNumber = false;
				}
			}
		} catch (AssertionError e) {
			fail("Unable to locate elemet comparablity Button containter");
		}
		return isComparabilityButtonVisibleByNumber;
	}
	
	//checking the list if the comparablity button is visible when property is not added
	public boolean isComparabilityButtonVisible()throws Exception{
		boolean isComparabilityButtonVisible = false;
		
		try {
			waitForElementPresent(xpath(RegressionObjectReference.comparbilityButtonContainer));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.comparbilityButtonContainer)));
			int count= driver.findElements(By.xpath(RegressionObjectReference.comparbilityButtonContainer)).size();
			int c = 1;
			String comparability = "";
			while( c <= count ) {
				if(!isPropertyAdded(c)){
					waitForElementPresent(xpath("("+RegressionObjectReference.comparbilityButtonContainer+")["+c+"]"));
					Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.comparbilityButtonContainer+")["+c+"]")));
					List<WebElement> comparabilityButton = driver.findElements(By.xpath("("+RegressionObjectReference.comparbilityButtonContainer+")["+c+"]"));
					
					for (WebElement element: comparabilityButton) {
						comparability = element.getText();
					    if(comparability.contains("Comparability")){
					    	isComparabilityButtonVisible = true;
					    	log("Comparability Button is visible");
					    	break;
					    }else{
					    	isComparabilityButtonVisible = false;
					   }
					}
					
				}
				
				if(isComparabilityButtonVisible){
					break;
				}
			c++;	
			}
		} catch (AssertionError e) {
			fail("Unable to locate elemet comparablity containter");
		}
		
		return isComparabilityButtonVisible;
	}
	
	public boolean isPropertyAdded(int resultNo)throws Exception{
		boolean isPropertyAdded = false;
		int c = resultNo;
		
		String labelAddRemove="";
		try {
			waitForElementPresent(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]"));
			Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]")));
			labelAddRemove = getText(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]"));
			
			if(labelAddRemove.equalsIgnoreCase("Add this property")){
				isPropertyAdded = false;
			}else{
				isPropertyAdded = true;
			}
		} catch (AssertionError e1) {
			
		}
		return isPropertyAdded;
	}
	
	public boolean isPhotoGalleryModalShow()throws Exception{
		boolean isPhotoGalleryModalShow = false;
		try {
			waitForElementPresent(xpath(RegressionObjectReference.photoGalleryModal));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.photoGalleryModal)));
			isPhotoGalleryModalShow = true;
			log("Photo Gallery is visible");
		} catch (AssertionError e1) {
			fail("PHOTO GALLERY MODAL DID NOT SHOW");
		}
		return isPhotoGalleryModalShow;
	}
	
	public boolean isSetAsDefaultImageVisible()throws Exception{
		boolean isSetAsDefaultImageVisible = false;
		String setDefaultImage ="";
		try {
			Thread.sleep(5000);
			waitForElementPresent(xpath(RegressionObjectReference.setAsDefaultImageContainter));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.setAsDefaultImageContainter)));
			List<WebElement> setAsDefaultImageContainer = driver.findElements(By.xpath(RegressionObjectReference.setAsDefaultImageContainter));
			
			for (WebElement element: setAsDefaultImageContainer) {
				setDefaultImage = element.getText();
			    if(setDefaultImage.equalsIgnoreCase("Set as default image")){
			    	isSetAsDefaultImageVisible = true;
			    	log("Photo Gallery is visible");
			    	break;
			    }else{
			    	isSetAsDefaultImageVisible = false;
			   }
			}
		} catch (AssertionError e1) {
		}
		return isSetAsDefaultImageVisible;
	}
	
	public void addingPropertyByAddress(String inputAddress) throws Exception{
		waitForElementPresent(xpath(RegressionObjectReference.logoSalesResult));
		Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.logoSalesResult)));
		
		//getting number of search result within page
		int count= driver.findElements(By.xpath(RegressionObjectReference.logoSalesResult)).size();
		int c = 1;
		
		while( c <= count ) {
			
			String labelAddRemove="";
			String address ="";
			
			try {
				waitForElementPresent(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]"));
				Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]")));
				labelAddRemove = getText(xpath("("+RegressionObjectReference.addRemoveButton+")["+c+"]"));
				
				waitForElementPresent(xpath("("+RegressionObjectReference.addressSerchResult+")["+c+"]"));
				Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.addressSerchResult+")["+c+"]")));
				address = getText(xpath("("+RegressionObjectReference.addressSerchResult+")["+c+"]"));
				
				String[] parts = address.split(",");
				address = ""+parts[0]+""+parts[1]+""+parts[2]+"";
				
			} catch (AssertionError e1) {
				
			}
			
			if(labelAddRemove.equalsIgnoreCase("Add this property") && address.equalsIgnoreCase(inputAddress)){
				try {
					Thread.sleep(2000);
					addRemoveProperty(c);
					enterCommentinSEList(input[5], c);
					clickInferior(c);
					System.out.println("Succesfully Add the Property "+c+"");
					
				} catch (AssertionError e) {
					System.out.println("Unable to Locate Element Add Remove "+c+"");
				}
			}
			c++;
	    }
	}
	public void clickYesinValidationForOnOrMoreSaleAdded() throws Exception{
	    try {
			waitForElementPresent(xpath(RegressionObjectReference.yesButtonValidationException));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.yesButtonValidationException)));
			click(xpath(RegressionObjectReference.yesButtonValidationException));
			log("Click Yes Button in validation Exception");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			fail("Unable to locate element Yes Button in validation Exception");
		}
	}
	
	public void clickContinue() throws Exception{
	    try {
			waitForElementPresent(xpath(RegressionObjectReference.continueButton));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.continueButton)));
			click(xpath(RegressionObjectReference.continueButton));
			log("Click Continue Button");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			fail("Unable to locate element Continue Button");
		}
	}
	
	public boolean checkIfImInSubmissionPage()throws Exception{
		boolean checkIfImInSubmissionPage = false;
		try {
			Thread.sleep(3000);
			waitForElementPresent(xpath(RegressionObjectReference.sitePhoto));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.sitePhoto)));
			log("Yes im in Submission Page");
			checkIfImInSubmissionPage = true;
		} catch (AssertionError e) {
			fail("Unable to locate Element");
		}
		return checkIfImInSubmissionPage;
	}
	
	public boolean checkSaleTypeInSearchResult()throws Exception{
		boolean checkSaleTypeInSearchResult = false;
		try {
			int c = 1;
			waitForElementPresent(xpath("("+RegressionObjectReference.labelSaleTypeSearchResult+")["+c+"]"));
			Assert.assertTrue(isElementPresent(xpath("("+RegressionObjectReference.labelSaleTypeSearchResult+")["+c+"]")));
			int count= driver.findElements(By.xpath(RegressionObjectReference.labelSaleTypeSearchResult)).size();
				
			if(count > 0){
				checkSaleTypeInSearchResult = true;
			}
			
			log("Yes im in Submission Page");
			checkSaleTypeInSearchResult = true;
		} catch (AssertionError e) {
			fail("Unable to locate Element");
		}
		return checkSaleTypeInSearchResult;
	}
	
	public void clickInferior(int inferiorNo) throws Exception{
	    try {
			String xPath = "("+RegressionObjectReference.inferior+")["+inferiorNo+"]";
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
			log("Click Inferior "+inferiorNo+"");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			fail("Unable to locate element Inferior "+inferiorNo+"");
		}
	}
	
	public boolean isInferiorActiveWhenSelected(int numList) throws Exception{
		
		boolean active = false;
		
		try {
			String xPath = "("+RegressionObjectReference.inferior+")["+numList+"]";
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			String color = driver.findElement(By.xpath("("+RegressionObjectReference.inferior+")["+numList+"]")).getAttribute("class");
			
			if(color.equalsIgnoreCase("active-select")){
				active = true;
			}
		} catch (AssertionError e) {
			fail("Unable to Locate element inferior");
		}
		
		return active;
	}
	
	public boolean isAsteriskVisible(int numList) throws Exception{
		
		boolean active = false;
		
//		try {
//			String xPath = "("+RegressionObjectReference.inferior+")["+numList+"]";
//			waitForElementPresent(xpath(xPath));
//			Assert.assertTrue(isElementPresent(xpath(xPath)));
//			String color = driver.findElement(By.xpath("("+RegressionObjectReference.inferior+")["+numList+"]")).getAttribute("class");
//			
//			if(!color.equalsIgnoreCase("active-select")){
//				
//			}
//		} catch (AssertionError e) {
//			fail("Unable to Locate element inferior");
//		}
		
		return active;
	}
	
	public void clickPhotoOnSearchResult(int listNo) throws Exception{
	    try {
			String xPath ="("+RegressionObjectReference.photoOnSearchResult+")["+listNo+"]";
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
			log("Click Photo "+listNo+"");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			fail("Unable to locate element photo "+listNo+"");
		}
	}
	
	public void clickComparable(int comparableNo) throws Exception{
	    try {
			String xPath = "("+RegressionObjectReference.comparble+")["+comparableNo+"]";
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
			log("Click Comparable "+comparableNo+"");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			fail("Unable to locate element Comparable "+comparableNo+"");
		}
	}
	
	public void clickSuperiro(int superiorNo) throws Exception{
	    try {
			String xPath = "("+RegressionObjectReference.comparble+")["+superiorNo+"]";
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
			log("Click Superior "+superiorNo+"");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			fail("Unable to locate element Superior "+superiorNo+"");
		}
	}
	
	public void enterCommentinSEList(String inputString, int commentNo) throws Exception{
		String commentNZ = "(//*[@class='comments'])["+commentNo+"]";
		try{
			Thread.sleep(3000);
			waitForElementPresent(xpath(commentNZ));
			Assert.assertTrue(isElementPresent(xpath(commentNZ)));
			//error when using variable commentNZ
			type(xpath("(//*[@class='comments'])["+commentNo+"]"),inputString);
			log("Enter Comment: "+input[5]+"");
		}
		catch(AssertionError e){
			fail("Unable to locate Element Comment Box in Sales List");
		}
	}

	public void addRemoveProperty(int propertyNo) throws Exception{
		
	    try {
			int prono = propertyNo;
			String xPath = "(//*[@class='button addRemoveProperty'])["+prono+"]";
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
			Thread.sleep(4000);
			log("Click on Add Property "+prono+"");
		} catch (AssertionError e) {
			fail("Unable to locate element Add/Remove Property");
		}
		
	}
	
	public boolean checkSearchResultIfHasValue() throws Exception{
		boolean hasResult = false;
		
		waitForElementPresent(xpath(RegressionObjectReference.searchResultContainer));
		Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.searchResultContainer)));
		
		List<WebElement> resultContainer = driver.findElements(By.xpath(RegressionObjectReference.searchResultContainer));
		
		for (WebElement element: resultContainer) {
			String con = element.getText();
			
		       if(con.equalsIgnoreCase("")){
		    	   hasResult = false;
		    	   break;
		       }else{
		    	   hasResult = true;
		       }
		}
		return hasResult;
	}
	
	public void clickSalesResultTab() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.salesResultTab));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.salesResultTab)));
			click(xpath(EVRObjectReference.salesResultTab));
			log("Click Search Result Tab");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Sales Result Tab");
		}	
	}
	
	//checking the data inputed in Verify Vs Submission Page
	public boolean confirmDataFromVerifyVsSubmission()throws Exception{
		boolean vs = false;
		boolean pt = confirmPropertyTypeValueVerifyDataVsSubmission();
		boolean lp = confirmLotPlanValueVerifyDataVsSubmission();
		boolean lga = confirmLGAValueVerifyDataVsSubmission();
		boolean z = confirmZoningValueVerifyDataVsSubmission();
		boolean lsd = confirmLastSaleDateValueVerifyDataVsSubmission();
		boolean lsp = confirmLastSalePriceValueVerifyDataVsSubmission();
		boolean r = confirmRoofValueVerifyDataVsSubmission();
		boolean ca = confirmCarAccomValueVerifyDataVsSubmission();
		boolean ab = confirmAdditionalAboutValueVerifyDataVsSubmission();
		boolean w = confirmMainWallValueVerifyDataVsSubmission();
		boolean ba = confirmBuiltAboutValueVerifyDataVsSubmission();
		
		if(pt && lp && lga && z && lsd && lsp && r && ca && ab && w && r && ba){
			vs = true;
		}
		return vs;
	}
	
	public boolean checkPropertyInformationOnTop()throws Exception{
		boolean isVisible = false;
		try {			
			waitForElementPresent(xpath(EVRObjectReference.propertyInformatonOnTop));
			isElementPresent(xpath(EVRObjectReference.propertyInformatonOnTop));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyInformatonOnTop)));
			String propertyInfo = getText(xpath(EVRObjectReference.propertyInformatonOnTop));
		
			if(propertyInfo.equalsIgnoreCase("")){
				isVisible = false;	
			}else{
				isVisible = true;	
			}
		} catch (AssertionError e) {
		}
		return isVisible;
	}
	
	public boolean checkAssessmentValueSectionLocation()throws Exception{
		boolean isVisible = false;
		try {			
			waitForElementPresent(xpath(RegressionObjectReference.assessmentValueSection));
			isElementPresent(xpath(RegressionObjectReference.assessmentValueSection));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.assessmentValueSection)));
			
			isVisible = true;	
			
		} catch (AssertionError e) {
		}
		return isVisible;
	}
	
	public boolean checkElementInsideAssessmentValueSection()throws Exception{
		boolean res = false;
		
		try {			
			waitForElementPresent(xpath(RegressionObjectReference.contractVal));
			isElementPresent(xpath(RegressionObjectReference.contractVal));
			isElementVisible(xpath(RegressionObjectReference.contractVal));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.contractVal)));
					
			waitForElementPresent(xpath(RegressionObjectReference.assessmentValueLabel));
			isElementPresent(xpath(RegressionObjectReference.assessmentValueLabel));
			isElementVisible(xpath(RegressionObjectReference.assessmentValueLabel));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.assessmentValueLabel)));
					
			waitForElementPresent(xpath(RegressionObjectReference.assessmentCommentsLabel));
			isElementPresent(xpath(RegressionObjectReference.assessmentCommentsLabel));
			isElementVisible(xpath(RegressionObjectReference.assessmentCommentsLabel));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.assessmentCommentsLabel)));
			
			waitForElementPresent(xpath(RegressionObjectReference.ihavecalledTheContactLabel));
			isElementPresent(xpath(RegressionObjectReference.ihavecalledTheContactLabel));
			isElementVisible(xpath(RegressionObjectReference.ihavecalledTheContactLabel));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.ihavecalledTheContactLabel)));
			
			res = true;
			log("contract Value,Assessment Value,Assessment Comment,i have called are visible inside Assessment Value Section");
		} catch (AssertionError e) {
			//FAIL
		}
		return res;
	}
	
	public boolean isCustomerContactedEditable() throws Exception{
		boolean isEdit = false;
		
		try {
			waitForElementPresent(xpath(RegressionObjectReference.customerContactSubmission));
			isElementPresent(xpath(RegressionObjectReference.customerContactSubmission));
			isElementVisible(xpath(RegressionObjectReference.customerContactSubmission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.customerContactSubmission)));
			
			click(xpath(RegressionObjectReference.customerContactSubmission));
			isEdit = true;
			log("Successfully click the i have called the contact checkbox");
		} catch (AssertionError e) {
			fail("Can't edit the i have called the contact checkbox");
		}
		return isEdit;
	}
	
	public boolean confirmAdditionalAboutValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkAdditionalAboutValueinSubmission();
		boolean isequal = false;
		try {
			if(additionalAbout.equalsIgnoreCase(fromSubmission)){
				isequal = true;
				System.out.println("Additional About Date VerData:"+additionalAbout+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Additional About Date VerData:"+additionalAbout+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element additionalAbout");
		}
		return isequal;
	}

	public boolean confirmBuiltAboutValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkBuiltAboutValueinSubmission();
		boolean isequal = false;
		try {
			if(builtAbout.equalsIgnoreCase(fromSubmission)){
				isequal = true;
				System.out.println("Built About Date VerData:"+builtAbout+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Built About Date VerData:"+builtAbout+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element builtAbout");
		}
		return isequal;
	}

	public boolean confirmCarAccomValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkCarAccomodationValueinSubmission();
		boolean isequal = false;
		try {
			if(carAccomodations.equalsIgnoreCase(fromSubmission)|| carAccomodations.equalsIgnoreCase("Select here..")){
				isequal = true;
				System.out.println("Car Accomodation Date VerData:"+carAccomodations+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Car Accomodation Date VerData:"+carAccomodations+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element carAccomodations");
		}
		return isequal;
	}
	
	public boolean confirmMainWallValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkMainWallValueinSubmission();
		boolean isequal = false;
		try {
			if(wall.equalsIgnoreCase(fromSubmission) || wall.equalsIgnoreCase("Select here..")){
				isequal = true;
				System.out.println("Main Wall VerData:"+wall+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Main Wall Date VerData:"+wall+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element wall");
		}
		return isequal;
	}
	
	public boolean confirmRoofValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkRoofValueinSubmission();
		boolean isequal = false;
		try {
			if(roof.equalsIgnoreCase(fromSubmission) || roof.equalsIgnoreCase("Select here..")){
				isequal = true;
				System.out.println("Roof Date VerData:"+roof+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Roof Date VerData:"+roof+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element roof");
		}
		return isequal;
	}
	
	public boolean confirmLastSaleDateValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkLastSaleDateValueinSubmission();
		boolean isequal = false;
		try {
			if(lastSaleDate.equalsIgnoreCase(fromSubmission)){
				isequal = true;
				System.out.println("Last Sale Date VerData:"+lastSaleDate+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Last Sale Date VerData:"+lastSaleDate+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element lastSaleDate");
		}
		return isequal;
	}
	
	public boolean confirmLastSalePriceValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkLastSalePriceValueinSubmission();
		boolean isequal = false;
		try {
			if(lastSalePrice.equalsIgnoreCase(fromSubmission)){
				isequal = true;
				System.out.println("Last SalePrice VerData:"+lastSalePrice+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Last SalePrice VerData:"+lastSalePrice+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element lastSalePrice");
		}
		return isequal;
	}

	public boolean confirmPropertyTypeValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkPropertyTypeValueinSubmission();
		boolean isequal = false;
		try {
			if(propertyType.equalsIgnoreCase(fromSubmission) || propertyType.equalsIgnoreCase("Select here")){
				isequal = true;
				System.out.println("Property Type VerData:"+propertyType+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Property Type VerData:"+propertyType+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element Property Type");
		}
		return isequal;
	}
	
	public boolean confirmLotPlanValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkLotPlanValueinSubmission();
		boolean isequal = false;
		try {
			if(lotPlan.equalsIgnoreCase(fromSubmission)){
				isequal = true;
				System.out.println("Lot Plan VerData:"+lotPlan+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Lot Plan Type VerData:"+lotPlan+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element Lot Plan");
		}
		return isequal;
	}
	
	public boolean confirmLGAValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkLGAValueinSubmission();
		boolean isequal = false;
		try {
			if(lga.equalsIgnoreCase(fromSubmission)){
				isequal = true;
				System.out.println("LGA VerData:"+lga+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("LGA Type VerData:"+lga+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element LGA");
		}
		return isequal;
	}
	
	public boolean confirmZoningValueVerifyDataVsSubmission()throws Exception{
		
		String fromSubmission  = checkZoningValueinSubmission();
		boolean isequal = false;
		try {
			if(zoning.equalsIgnoreCase(fromSubmission)){
				isequal = true;
				System.out.println("Zoning VerData:"+zoning+" is equal "+fromSubmission+"" );
			}else{
				System.out.println("Zoning Type VerData:"+zoning+" is NOT equal "+fromSubmission+"" );
			}
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Element Zoning");
		}
		return isequal;
	}
	
	public void selectPropertyType(int index)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.propertyType));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.propertyType)));
			selectDropdownOptionbyIndex(xpath(RegressionObjectReference.propertyType),index);
			
			String selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.propertyType))).getFirstSelectedOption().getText();
			propertyType = selectedOption;
			log(propertyType);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void selectBedRooms(int index)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.bedrooms));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.bedrooms)));
			selectDropdownOptionbyIndex(xpath(RegressionObjectReference.bedrooms),index);
			
			String selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.bedrooms))).getFirstSelectedOption().getText();
			bedrooms = selectedOption;
			log(bedrooms);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void selectBathrooms(int index)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.bathrooms));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.bathrooms)));
			selectDropdownOptionbyIndex(xpath(RegressionObjectReference.bathrooms),index);
			
			String selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.bathrooms))).getFirstSelectedOption().getText();
			bathrooms = selectedOption;
			log(bathrooms);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void selectCarSpace(int index)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.carSpaces));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.carSpaces)));
			selectDropdownOptionbyIndex(xpath(RegressionObjectReference.carSpaces),index);
			
			String selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.carSpaces))).getFirstSelectedOption().getText();
			carSpaces = selectedOption;
			log(carSpaces);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void selectCarAccomodation(int index)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.carAccomodations));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.carAccomodations)));
			selectDropdownOptionbyIndex(xpath(RegressionObjectReference.carAccomodations),index);
			
			String selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.carAccomodations))).getFirstSelectedOption().getText();
			carAccomodations = selectedOption;
			log(carAccomodations);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void selectWall(int index)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.mainWall));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.mainWall)));
			selectDropdownOptionbyIndex(xpath(RegressionObjectReference.mainWall),index);
			
			String selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.mainWall))).getFirstSelectedOption().getText();
			wall = selectedOption;
			log(wall);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void selectRoof(int index)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.roofConstructions));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.roofConstructions)));
			selectDropdownOptionbyIndex(xpath(RegressionObjectReference.roofConstructions),index);
			
			String selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.roofConstructions))).getFirstSelectedOption().getText();
			roof = selectedOption;
			log(roof);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void enterValueInBuiltAbout(String value)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.builtAbout));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.builtAbout)));
			
			type(xpath(RegressionObjectReference.builtAbout),value);
			String textVal = getValue(xpath(RegressionObjectReference.builtAbout));
			
			builtAbout = textVal;
			log(builtAbout);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void enterValueInLivingArea(String value)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.livingArea));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.livingArea)));
			
			type(xpath(RegressionObjectReference.livingArea),value);
			String textVal = getValue(xpath(RegressionObjectReference.livingArea));
			
			livingArea = textVal;
			log(livingArea);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public void enterValueInLandArea(String value)throws Exception{
		try {
			
			waitForElementPresent(xpath(RegressionObjectReference.landArea));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.landArea)));
			
			type(xpath(RegressionObjectReference.landArea),value);
			String textVal = getValue(xpath(RegressionObjectReference.landArea));
			
			landArea = textVal;
			log(landArea);
			Thread.sleep(1000);
		} catch (AssertionError e) {
			log("Unable to locate Element");
		}
	}
	
	public String checkPropertyTypeValue() throws Exception{
		String selectedOption;
		try {
			waitForElementPresent(xpath(RegressionObjectReference.propertyType));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.propertyType)));
			selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.propertyType))).getFirstSelectedOption().getText();
			System.out.println("Succesfully check the Value......,Property Type is "+selectedOption+"");
		} catch (AssertionError e) {
			System.out.println("Unable to Locate Property Type");
			selectedOption ="";
		}
		return propertyType = selectedOption;
	}
	
	public String checkBedRoomValue() throws Exception{
		String selectedOption;
		try {
			waitForElementPresent(xpath(RegressionObjectReference.bedrooms));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.bedrooms )));
			selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.bedrooms))).getFirstSelectedOption().getText();
			System.out.println("Succesfully check the Value..........,Bed Room is "+selectedOption+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element bedrooms");
			selectedOption = "";
		}
		return bedrooms = selectedOption;
	}
	
	public String checkBathroomValue() throws Exception{
		String selectedOption ="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.bathrooms));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.bathrooms )));
			selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.bathrooms))).getFirstSelectedOption().getText();
			System.out.println("Succesfully check the Value..........,Bathroom is "+selectedOption+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element bathrooms");
		}
		return bathrooms = selectedOption;
	}
	
	public String checkCarSpaceValue() throws Exception{
		String selectedOption ="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.carSpaces));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.carSpaces )));
			selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.carSpaces))).getFirstSelectedOption().getText();
			System.out.println("Succesfully check the Value..........,Car Space is "+selectedOption+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Car Space");
		}
		return carSpaces = selectedOption;
	}
	
	public String checkCarAccomValue() throws Exception{
		String selectedOption ="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.carAccomodations));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.carAccomodations )));
			selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.carAccomodations))).getFirstSelectedOption().getText();
			System.out.println("Succesfully check the Value..........,Car Accomodation is "+selectedOption+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Car Accomodation");
		}
		return carAccomodations = selectedOption;
	}
	
	public String checkBuiltAboutValue() throws Exception{
		String textVal ="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.builtAbout));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.builtAbout )));
			textVal = getValue(xpath(RegressionObjectReference.builtAbout));
			System.out.println("Succesfully check the Value..........,Built About is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Built About");
		}
		return builtAbout = textVal;
	}
	
	public String checkAdditionalAboutValue() throws Exception{
		String textVal ="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.additionalAbout));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.additionalAbout )));
			textVal = getValue(xpath(RegressionObjectReference.additionalAbout));
			System.out.println("Succesfully check the Value..........,Additional About is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Additional About");
		}
		return additionalAbout = textVal;
	}
	
	public String checkLandAreaValue() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.landArea));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.landArea )));
			textVal = getValue(xpath(RegressionObjectReference.landArea));
			System.out.println("Succesfully check the Value..........,Land Area is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Land Area");
		}
		return landArea = textVal;
	}
	
	public String checkLastSaleDate() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lastSaleDate));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lastSaleDate )));
			textVal = getValue(xpath(RegressionObjectReference.lastSaleDate));
			System.out.println("Succesfully check the Value..........,Last sale date is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Last sale date");
		}
		return lastSaleDate = textVal;
	}
	
	public String checkLastSalePrice() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lastSalePrice));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lastSalePrice )));
			textVal = getValue(xpath(RegressionObjectReference.lastSalePrice));
			System.out.println("Succesfully check the Value..........,Last salePrice is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Last sale price");
		}
		return lastSalePrice = textVal;
	}
	
	public String checkLivingAreaValue() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.livingArea));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.livingArea)));
			textVal = getValue(xpath(RegressionObjectReference.livingArea));
			System.out.println("Succesfully check the Value..........,living area is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Living area");
		}
		return livingArea = textVal;
	}
	
	public String checkMainWallValue() throws Exception{
		String selectedOption="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.mainWall));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.mainWall)));
			selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.mainWall))).getFirstSelectedOption().getText();
			System.out.println("Succesfully check the Value..........,Main Wall is "+selectedOption+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Main Wall");
		}
		return wall = selectedOption;
	}
	
	public String checkRoofValue() throws Exception{
		String selectedOption="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.roofConstructions));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.roofConstructions)));
			selectedOption = new Select(driver.findElement(By.xpath(RegressionObjectReference.roofConstructions))).getFirstSelectedOption().getText();
			System.out.println("Succesfully check the Value..........,Roof is "+selectedOption+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Roof");
		}
		return roof = selectedOption;
	}	
	
	public String checkLotPlanValue() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lotPlan));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lotPlan)));
			textVal = getValue(xpath(RegressionObjectReference.lotPlan));
			System.out.println("Succesfully check the Value..........,Lot Plan is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Lot Plan");
		}
		return lotPlan = textVal;
	}
	
	public String checkLGAValue() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lga));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lga)));
			textVal = getValue(xpath(RegressionObjectReference.lga));
			System.out.println("Succesfully check the Value..........,LGA is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element LGA");
		}
		return lga = textVal;
	}
	
	public String checkZoningValue() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.zoning));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.zoning)));
			textVal = getValue(xpath(RegressionObjectReference.zoning));
			System.out.println("Succesfully check the Value..........,Zoning is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Zoning");
		}
		return zoning = textVal;
	}
	
	public String checkPropertyTypeValueinSubmission() throws Exception{
		String textVal = "";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.propertyType_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.propertyType_submission)));
			textVal = getValue(xpath(RegressionObjectReference.propertyType_submission));
			System.out.println("Succesfully check the Value..........,PropertyType is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element property type");
		}
		return textVal;
	}
	
	public String checkLGAValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lga_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lga_submission)));
			textVal = getValue(xpath(RegressionObjectReference.lga_submission));
			System.out.println("Succesfully check the Value..........,LGA is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element LGA");
		}
		return textVal;
	}
	
	public String checkLotPlanValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lotPlan_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lotPlan_submission)));
			textVal = getValue(xpath(RegressionObjectReference.lotPlan_submission));
			System.out.println("Succesfully check the Value..........,Lot Plan is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Lot Plan");
		}
		return textVal;
	}
	
	public String checkZoningValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.zoning_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.zoning_submission)));
			textVal = getValue(xpath(RegressionObjectReference.zoning_submission));
			System.out.println("Succesfully check the Value..........,Zoning is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Zoning");
		}
		return textVal;
	}
	
	public String checkLastSaleDateValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lastSaleDate_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lastSaleDate_submission)));
			textVal = getValue(xpath(RegressionObjectReference.lastSaleDate_submission));
			System.out.println("Succesfully check the Value..........,Last Saledate is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Last Saledate");
		}
		return textVal;
	}
	
	public String checkLastSalePriceValueinSubmission() throws Exception{
		String part2="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.lastSaleDate_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.lastSaleDate_submission)));
			String textVal = getValue(xpath(RegressionObjectReference.lastSalePrice_submission));
			String text2 = textVal;
			String[] parts = text2.split(" ");
			part2 = parts[1];
			System.out.println("Succesfully check the Value..........,Last SalePrice is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Last SalePrice");
		}
		return part2;
	}
	
	public String checkMainWallValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.mainWall_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.mainWall_submission)));
			textVal = getValue(xpath(RegressionObjectReference.mainWall_submission));
			System.out.println("Succesfully check the Value..........,Main wall is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Main wall");
		}
		return textVal;
	}
	
	public String checkRoofValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.roofConstructions_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.roofConstructions_submission)));
			textVal = getValue(xpath(RegressionObjectReference.roofConstructions_submission));
			System.out.println("Succesfully check the Value..........,Roof is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Roof");
		}
		return textVal;
	}
	
	public String checkCarAccomodationValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.carAccomodations_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.carAccomodations_submission)));
			textVal = getValue(xpath(RegressionObjectReference.carAccomodations_submission));
			System.out.println("Succesfully check the Value..........,Car Accomodation is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Car Accomodation");
		}
		return textVal;
	}
	
	public String checkBuiltAboutValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.builtAbout_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.builtAbout_submission)));
			textVal = getValue(xpath(RegressionObjectReference.builtAbout_submission));
			System.out.println("Succesfully check the Value..........,Built About is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Built About");
		}
		return textVal;
	}
	
	public String checkAdditionalAboutValueinSubmission() throws Exception{
		String textVal="";
		try {
			waitForElementPresent(xpath(RegressionObjectReference.additionalAbout_submission));
			Assert.assertTrue(isElementPresent(xpath(RegressionObjectReference.additionalAbout_submission)));
			textVal = getValue(xpath(RegressionObjectReference.additionalAbout_submission));
			System.out.println("Succesfully check the Value..........,Additional About is "+textVal+"");
		} catch (AssertionError e) {
			System.out.println("Unable to locate element Additional About");
		}
		return textVal;
	}	
}