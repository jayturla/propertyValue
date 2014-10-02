package myrp.utilities;


import static org.openqa.selenium.By.xpath;

import java.io.IOException;
import java.util.List;

import myrp.library.EVRObjectReference;
import myrp.library.FunctionReference;
import myrp.library.ObjectReference;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class EvrProjectUtilAUS extends FunctionReference {
	
	private String[] input = null;
	private String testCase = "";
	private boolean checkifAU = true;
	private String joborder ="";
	private boolean contactCalledIsChecked = false;
	private boolean readonly = false;	
	/**
	 * @return the readonly
	 */
	public boolean isReadonly() {
		return readonly;
	}

	/**
	 * @return the contactCalledIsChecked
	 */
	public boolean isContactCalledIsChecked() {
		return contactCalledIsChecked;
	}

	public boolean isCheckifAU() {
		return checkifAU;
	}

	public void setCheckifAU(boolean checkifAU) {
		this.checkifAU = checkifAU;
	}

	public EvrProjectUtilAUS(String[] i) {
			input = i;
	}
		
	public void valexAuOrder (String jobOrder) throws InterruptedException, IOException {
		resultcount = 0;
		try {
			waitForElementPresent(xpath(EVRObjectReference.jobOrderInput));
			isElementPresent(xpath(EVRObjectReference.jobOrderInput));
			
			//String joborder ="VXJ-000000"+jobOrder;
			joborder = jobOrder;
			testCase = "EVR Job Order Input: " + input[0];
			
			type(xpath(EVRObjectReference.jobOrderInput), joborder);
			
			waitForElementPresent(xpath(EVRObjectReference.valEx));
			click(xpath(EVRObjectReference.valEx));
			
			waitForElementPresent(xpath(EVRObjectReference.buttonAu));
			click(xpath(EVRObjectReference.buttonAu));
			checkifNABorAU();
			
			if(isCheckifAU()){
			ATUReports.add("Create an order and successfully view the order by: 1. From ValEx, view the order as a valuer widely used 2. Input an order number on the Debug Page less priority",
					jobOrder,
					"Successfully view the Dekstop EVR - Overview tab after the order has been accepted on ValEx.",
					"Successfully view the Desktop EVR - Overview tab after the order has been accepted on ValEx.", true);
				
				//ATUReports.add("TESTING FAIL", LogAs.FAILED, null);
			}else{
			ATUReports.add("Create an order and successfully view the order by: 1. From ValEx, view the order as a valuer widely used 2. Input an order number on the Debug Page less priority",
						jobOrder,
						"Successfully view the NAB EVR - Verify Data tab after the order has been accepted on ValEx.",
						"Successfully view the NAB EVR - Verify tab after the order has been accepted on ValEx.", true);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Invalid Job Order");
		}
	
	}
	
	public void valexAuOrderAsNonValuer (String jobOrder) throws InterruptedException, IOException {
		resultcount = 0;
		try {
			waitForElementPresent(xpath(EVRObjectReference.jobOrderInput));
			isElementPresent(xpath(EVRObjectReference.jobOrderInput));
			
			
			//String joborder ="VXJ-000000"+jobOrder;
			 joborder = jobOrder;
			testCase = "EVR Job Order Input: " + input[0];
			
			type(xpath(EVRObjectReference.jobOrderInput), joborder);
			
			waitForElementPresent(xpath(EVRObjectReference.valEx));
			click(xpath(EVRObjectReference.valEx));
			
			waitForElementPresent(xpath(EVRObjectReference.logAsNonValuer));
			click(xpath(EVRObjectReference.logAsNonValuer));
			
			waitForElementPresent(xpath(EVRObjectReference.buttonAu));
			click(xpath(EVRObjectReference.buttonAu));
			checkifNABorAU();
			readonly = true;	
			if(isCheckifAU()){
			ATUReports.add("Create an order and successfully view the order by: 1. From ValEx, view the order as a valuer widely used 2. Input an order number on the Debug Page less priority",
					jobOrder,
					"Successfully view the Dekstop EVR - Overview tab after the order has been accepted on ValEx.",
					"Successfully view the Desktop EVR - Overview tab after the order has been accepted on ValEx.", true);
			}else{
			ATUReports.add("Create an order and successfully view the order by: 1. From ValEx, view the order as a valuer widely used 2. Input an order number on the Debug Page less priority",
						jobOrder,
						"Successfully view the NAB EVR - Verify Data tab after the order has been accepted on ValEx.",
						"Successfully view the NAB EVR - Verify tab after the order has been accepted on ValEx.", true);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Invalid Job Order");
		}
	
	}
	
	public void checkOnThumbnailLink()throws Exception{
		
		waitForElementPresent(xpath(EVRObjectReference.propertyInformation));
		isElementPresent(xpath(EVRObjectReference.propertyInformation));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyInformation)));
			ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
					"As an EVR AUS/NAB user I want all the thumbnails link on the the right side of the page be removed",
					"FAILED:thumbnails are still  visible in the right side of the page", true);			
		} catch (AssertionError e) {
			ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
					"As an EVR AUS/NAB user I want all the thumbnails link on the the right side of the page be removed",
					"All thumbnails are not visible in the right side of the page", true);			
			
		}
		
		
	}
	
	public void uploadPhoto(String path)throws Exception{
		String thumbnail = path;
		
		WebElement upload = driver.findElement(By.id("originalFile"));
		try {
			waitForElementPresent(xpath(EVRObjectReference.addPhoto));
			isElementPresent(xpath(EVRObjectReference.addPhoto));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.addPhoto)));
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(thumbnail.equals("none")){
			
		} else {
			upload.sendKeys(thumbnail);
			try {
				waitForElementPresent(xpath(EVRObjectReference.preloader));
				isElementPresent(xpath(EVRObjectReference.preloader));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.preloader)));
				Thread.sleep(3000);
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void checkOnSetAsDefaultImage()throws Exception{
		
		waitForElementPresent(xpath(EVRObjectReference.propertyInformation));
		isElementPresent(xpath(EVRObjectReference.propertyInformation));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyInformation)));
			ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
					"As an EVR AUS/NAB user I want all the thumbnails link on the the right side of the page be removed",
					"FAILED:thumbnails are still  visible in the right side of the page", true);			
		} catch (AssertionError e) {
			ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
					"As an EVR AUS/NAB user I want all the thumbnails link on the the right side of the page be removed",
					"All thumbnails are not visible in the right side of the page", true);			
			
		}
		
		
	}
	
	public void checkAddressMatchModal()throws Exception{
		String modalVal ="";
		Boolean changeAddressModalHasValue = false;
		clickPropertyAddress();
		
		try {
			
			String url = driver.getCurrentUrl();
			String changeAddressModalCurrentPage ="";
			if(url.contains("evr-34")){
				changeAddressModalCurrentPage = "/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div";
			}else{
				 changeAddressModalCurrentPage = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div";
			}
			
			waitForElementPresent(xpath(changeAddressModalCurrentPage));
			isElementPresent(xpath(changeAddressModalCurrentPage));
			Assert.assertTrue(isElementPresent(xpath(changeAddressModalCurrentPage)));
			
			List<WebElement> changeAddressModalList = driver.findElements(By.xpath(changeAddressModalCurrentPage));
			
			for (WebElement element: changeAddressModalList) {
				modalVal = element.getText();
			       if(modalVal.equalsIgnoreCase("If you would like to remove the matched property and use the original ordered\naddress without integrated data, " +
			       		"select Remove Match\n\nIf you would like to search for another address as a potential match,select\nChange Address\nRemove Match\nChange Address\nBack")){
			    	   changeAddressModalHasValue = true;
			    	   break;
			       }else{
			    	   changeAddressModalHasValue = false;
			       }
			}
			
			if(changeAddressModalHasValue){
				ATUReports.add("1.Open order at EVR UI" +
										"2.Navigate to any tab (Verify Data, Sales Evidence or Submission page)" +
										"3.Verify Ordered to and Matched to: text block on the header " +
										"4.Click any part of the address text block ","checkAddressMatchModal",
						"Then the Address Match modal should prompt with the following components:" +
						"Messages:" +
						"If you would like to remove the match property and use the original ordered address " +
						"without integrated data, select Remove Match." +
						"If you would like to search for another address as a potential match, select Change Address" +
						"and, Buttons:" +
						"- Remove Match button" +
						"- Change Address button" +
						"- Back button",
						"Messages in Modal Box are all Correct and there is a Button Remove,Change,Back", true);			
			}else{
				ATUReports.add("1.Open order at EVR UI" +
						"2.Navigate to any tab (Verify Data, Sales Evidence or Submission page)" +
						"3.Verify Ordered to and Matched to: text block on the header " +
						"4.Click any part of the address text block ","checkAddressMatchModal",
						"Then the Address Match modal should prompt with the following components:" +
						"Messages:" +
						"If you would like to remove the match property and use the original ordered address " +
						"without integrated data, select Remove Match." +
						"If you would like to search for another address as a potential match, select Change Address" +
						"and, Buttons:" +
						"- Remove Match button" +
						"- Change Address button" +
						"- Back button",
						"FAILED:Messages in Modal Box are incorrect or there is no Button Remove,Change,Back", true);		
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ATUReports.add("1.Open order at EVR UI" +
					"2.Navigate to any tab (Verify Data, Sales Evidence or Submission page)" +
					"3.Verify Ordered to and Matched to: text block on the header " +
					"4.Click any part of the address text block ","checkAddressMatchModal",
					"Then the Address Match modal should prompt with the following components:" +
					"Messages:" +
					"If you would like to remove the match property and use the original ordered address " +
					"without integrated data, select Remove Match." +
					"If you would like to search for another address as a potential match, select Change Address" +
					"and, Buttons:" +
					"- Remove Match button" +
					"- Change Address button" +
					"- Back button",
					"FAILED:UNABLE TO LOCATE ELEMENT", true);		
		}

	}
	
	public void checkBackButtonAddressMatchModal()throws Exception{
		String beforeUrl = driver.getCurrentUrl();
		clickPropertyAddress();
		clickBackButtonAddressMatchModal();
		String afterUrl = driver.getCurrentUrl();
			
		if(beforeUrl.equals(afterUrl)){
				ATUReports.add("1.Open order at EVR UI" +
						"2.Navigate to any tab (Verify Data, Sales Evidence or Submission page)" +
						"3.Click address and verify Address Match modal appears" +
						"4.Click Back button","checkBackButtonAddressMatchModal",
						"Page should return back to the original state of current tab (If Address match modal was displayed on Sales Evidence, it should go back to Sales Evidence page upon clicking Back button)",
						"Page is back to the original state of current tab", true);			
		}else{
			ATUReports.add("1.Open order at EVR UI" +
					"2.Navigate to any tab (Verify Data, Sales Evidence or Submission page)" +
					"3.Click address and verify Address Match modal appears" +
					"4.Click Back button","checkBackButtonAddressMatchModal",
					"Page should return back to the original state of current tab (If Address match modal was displayed on Sales Evidence, it should go back to Sales Evidence page upon clicking Back button)",
					"FAILED:Page is NOT back to the original state of current tab", true);		
		}
	}
	
	public boolean checkCantFindAddressForml()throws Exception{
		Boolean valueInsideForm = false;
		try {
			
			waitForElementPresent(xpath(EVRObjectReference.cantFindAddressForm));
			isElementPresent(xpath(EVRObjectReference.cantFindAddressForm));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.cantFindAddressForm)));
			
			List<WebElement> cantFindFormList = driver.findElements(By.xpath(EVRObjectReference.cantFindAddressForm));
			
			for (WebElement element: cantFindFormList) {
				String cantFindFormListText = element.getText();
			       if(cantFindFormListText.contains("Unit/Lot Number Street Type\nSuburb *\nSearch RP Back to single line?\nUse typed address")){
			    	   
			    	    try {
							waitForElementPresent(xpath(EVRObjectReference.suburbCantfindAdd));
							isElementPresent(xpath(EVRObjectReference.suburbCantfindAdd));
							Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.suburbCantfindAdd)));
							
							String valueSuburbCantFindAddress = getValue(xpath(EVRObjectReference.suburbCantfindAdd));
							 
							if(valueSuburbCantFindAddress.equals("Enter suburb or postcode")){
								valueInsideForm = true;
							}
							
						} catch (AssertionError e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	   break;
			       }else{
			    	   valueInsideForm = false;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueInsideForm;
	}
	
	public void performUsedTypeAddressDiscardPropertyData()throws Exception{
		clickPropertyAddress();
		clickChangeAddressButtonMatchModal();
		clickCantFindAddress();
		//enterUnitorLotInUseTypedAddress(input[11]);
		enterNumberInUseTypedAddress(input[8]);
		enterStreetInUseTypedAddress(input[9]);
		enterTypeInUseTypedAddress(input[10]);
		enterSuburbInUseTypedAddress(input[7]);
		clickUsedTypedAddress();
		
		if(checkModalForUsedTypeAddress()){
			clickDiscardPropertyData();
			String address = ""+input[8]+" "+input[9]+" "+input[10]+" "+input[7]+"";
			Thread.sleep(2000);
			if(getPropertyAddress().contains(address)){
				if(input[25].equalsIgnoreCase("NO RPID")){
					if(checkDataInVerifyDataPageLotPlan().equalsIgnoreCase("")){
						ATUReports.add(input[12],"performUsedTypeAddressDiscardPropertyData",input[13],input[14], true);
					}else{
						ATUReports.add(input[12],"performUsedTypeAddressDiscardPropertyData",input[13],input[15], true);
					}
				}else if(input[25].equalsIgnoreCase("WITH RPID")){
					if(!checkDataInVerifyDataPageLotPlan().equalsIgnoreCase("")){
						ATUReports.add(input[12],"performUsedTypeAddressDiscardPropertyData",input[13],input[14], true);
					}else{
						ATUReports.add(input[12],"performUsedTypeAddressDiscardPropertyData",input[13],input[15], true);
					}
				}	
			}else{
				ATUReports.add(input[12],"performUsedTypeAddressDiscardPropertyData",input[13],input[15], true);
			}
		}else{
			ATUReports.add(input[12],"performUsedTypeAddressDiscardPropertyData",input[13],input[15], true);
		}
	}
	
	public void checkCopyForwardButton()throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.copyForwardButton));
			isElementPresent(xpath(EVRObjectReference.copyForwardButton));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.copyForwardButton)));
			
			if(input[2].equalsIgnoreCase("NAB")){
				ATUReports.add(input[3],"performUsedTypeAddressDiscardPropertyData",input[4],input[5], true);//passed
			}else{
				ATUReports.add(input[3],"performUsedTypeAddressDiscardPropertyData",input[4],input[6], true);//fail
			}
			
		} catch (AssertionError e) {
			if(input[2].equalsIgnoreCase("NAB")){
				ATUReports.add(input[3],"performUsedTypeAddressDiscardPropertyData",input[4],input[6], true); //failed
			}else{
				ATUReports.add(input[3],"performUsedTypeAddressDiscardPropertyData",input[4],input[5], true);//passed
			}
		}
		
		
	}
	
	public void checkCopyForwardModalBox()throws Exception{
		
			clickCopyForwardButton();
			if(checkCopyForwardModalImportFromPreviousValuation()){
				ATUReports.add(input[7],"performUsedTypeAddressDiscardPropertyData",input[8],input[9], true);//passed
			}else{
				ATUReports.add(input[7],"performUsedTypeAddressDiscardPropertyData",input[8],input[10], true);//fail
			}
		
	}
	
	public void checkCategoriesOnCopyForwardModal()throws Exception{
		
		clickCatagoriesOnCopyForwardModal(1);
		clickCatagoriesOnCopyForwardModal(2);
		
		if(	checkMultipleCategories()){
			ATUReports.add(input[11],"performUsedTypeAddressDiscardPropertyData",input[12],input[13], true);//passed
		}else{
			ATUReports.add(input[11],"performUsedTypeAddressDiscardPropertyData",input[12],input[14], true);//fail
		}
	}

	public void checkBackWhenCopyForward()throws Exception{
		
		gotoSubmission();
		Thread.sleep(3000);
		String previousdata  = driver.getPageSource();
		Thread.sleep(1000);
		
		clickCatagoriesOnCopyForwardModal(1);
		clickCatagoriesOnCopyForwardModal(2);
		enterJobIdTxtFieldInCopyForwardModal(input[19]);
		clickOkButtonInCopyForwardModal();
		Thread.sleep(1000);
		clickBackButtonInImportDataModal();
		Thread.sleep(2000);
		
		if(	previousdata.equals(driver.getPageSource())){
			ATUReports.add(input[15],"checkBackWhenCopyForward",input[16],input[17], true);//passed
		}else{
			ATUReports.add(input[15],"checkBackWhenCopyForward",input[16],input[18], true);//fail
		}
	}
	
	public void checkImportedDatainCopyForward()throws Exception{
		
		clickCopyForwardButton();
		
		clickCatagoriesOnCopyForwardModal(1);
		clickCatagoriesOnCopyForwardModal(2);
		enterJobIdTxtFieldInCopyForwardModal(input[19]);
		clickOkButtonInCopyForwardModal();
		
		if(checkingImportedDataInCopyForward()){
			ATUReports.add(input[20],"checkImportedDatainCopyForward",input[21],input[22], true);//passed
		}else{
			ATUReports.add(input[20],"checkImportedDatainCopyForward",input[21],input[23], true);//fail
		}
	}
	
	
	public boolean checkMultipleCategories() throws Exception{
		boolean categories = false;
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.categorySalesEvidence));
			isElementPresent(xpath(EVRObjectReference.importFromPreviousValuationModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.importFromPreviousValuationModal)));
			
			waitForElementPresent(xpath(EVRObjectReference.categoryRiskAnalysis));
			isElementPresent(xpath(EVRObjectReference.categoryRiskAnalysis));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.categoryRiskAnalysis)));
			
			waitForElementPresent(xpath(EVRObjectReference.categoryAssessmentComment));
			isElementPresent(xpath(EVRObjectReference.categoryAssessmentComment));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.categoryAssessmentComment)));
			
			waitForElementPresent(xpath(EVRObjectReference.categorySitePhoto));
			isElementPresent(xpath(EVRObjectReference.categorySitePhoto));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.categorySitePhoto)));
			
			String categorySE = driver.findElement(By.xpath(EVRObjectReference.importFromPreviousValuationModal)).getAttribute("class");
			String categoryRA = driver.findElement(By.xpath(EVRObjectReference.categoryRiskAnalysis)).getAttribute("class");
			String categoryAC = driver.findElement(By.xpath(EVRObjectReference.categoryAssessmentComment)).getAttribute("class");
			String categorySP = driver.findElement(By.xpath(EVRObjectReference.importFromPreviousValuationModal)).getAttribute("class");
			
			if(!categorySE.equals("") && !categoryRA.equals("")){
				categories = true;
			}else if(!categorySE.equals("") && !categoryAC.equals("")){
				categories = true;
			}else if(!categorySE.equals("") && !categorySP.equals("")){
				categories = true;
			}else if(!categoryRA.equals("") && !categoryAC.equals("")){
				categories = true;
			}else if(!categoryRA.equals("") && !categorySP.equals("")){
				categories = true;
			}
		} catch (AssertionError e) {
			
		}
		
		return categories;
	}
	
	public boolean checkCopyForwardModalImportFromPreviousValuation() throws Exception{
		boolean modalbox = false;
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.importFromPreviousValuationModal));
			isElementPresent(xpath(EVRObjectReference.importFromPreviousValuationModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.importFromPreviousValuationModal)));
			
			String modalBoxCopyForward = getText(xpath(EVRObjectReference.importFromPreviousValuationModal));
			
			if(modalBoxCopyForward.contains("Import From Previous Valuation")){
				modalbox = true;
			}
		} catch (AssertionError e) {
			
		}
		
		return modalbox;
	}
	
	public boolean checkingImportedDataInCopyForward() throws Exception{
		boolean modalbox = false;
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.importDataModal));
			isElementPresent(xpath(EVRObjectReference.importDataModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.importDataModal)));
			
			String modalBoxCopyForward = getText(xpath(EVRObjectReference.importDataModal));
			
			if(modalBoxCopyForward.contains("Import From Previous Valuation")){
				modalbox = true;
			}
		} catch (AssertionError e) {
			
		}
		
		return modalbox;
	}
	
	public void clickCopyForwardButton() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.copyForwardButton));
			isElementPresent(xpath(EVRObjectReference.copyForwardButton));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.copyForwardButton)));
			click(xpath(EVRObjectReference.copyForwardButton));
		} catch (AssertionError e) {
			
		}
		
	}
	
	public void clickBackButtonInCopyForwardModal() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.backButtonInCopyForwardModal));
			isElementPresent(xpath(EVRObjectReference.backButtonInCopyForwardModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.backButtonInCopyForwardModal)));
			click(xpath(EVRObjectReference.backButtonInCopyForwardModal));
		} catch (AssertionError e) {
			
		}
	}
	
	public void clickBackButtonInImportDataModal() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.backButtonInImportDataModal));
			isElementPresent(xpath(EVRObjectReference.backButtonInImportDataModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.backButtonInImportDataModal)));
			click(xpath(EVRObjectReference.backButtonInImportDataModal));
		} catch (AssertionError e) {
			
		}
	}
	
	public void enterJobIdTxtFieldInCopyForwardModal(String input) throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.jobIdTxtFieldInCopyForwardModal));
			isElementPresent(xpath(EVRObjectReference.jobIdTxtFieldInCopyForwardModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.jobIdTxtFieldInCopyForwardModal)));
			
			type(xpath(EVRObjectReference.jobIdTxtFieldInCopyForwardModal),input);
		} catch (AssertionError e) {
			
		}
	}
	
	public void clickOkButtonInCopyForwardModal() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.okButtonInCopyForwardModal));
			isElementPresent(xpath(EVRObjectReference.okButtonInCopyForwardModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.okButtonInCopyForwardModal)));
			click(xpath(EVRObjectReference.okButtonInCopyForwardModal));
		} catch (AssertionError e) {
			
		}
	}
	
	public void clickCatagoriesOnCopyForwardModal(int categories) throws Exception{
		try {
			String category ="(sample waitng for xpath)["+categories+"]";	
			
			waitForElementPresent(xpath(category));
			isElementPresent(xpath(category));
			Assert.assertTrue(isElementPresent(xpath(category)));
			click(xpath(category));
		} catch (AssertionError e) {
			
		}
		
	}
	
	public void performUsedTypeAddressKeepPropertyData()throws Exception{
		String origval = checkDataInVerifyDataPageLotPlan();
		clickPropertyAddress();
		clickChangeAddressButtonMatchModal();
		clickCantFindAddress();
		//enterUnitorLotInUseTypedAddress(input[11]);
		enterNumberInUseTypedAddress(input[8]);
		enterStreetInUseTypedAddress(input[9]);
		enterTypeInUseTypedAddress(input[10]);
		enterSuburbInUseTypedAddress(input[7]);
		clickUsedTypedAddress();
		
		if(checkModalForUsedTypeAddress()){
			clickDiscardPropertyData();
			String address = ""+input[8]+" "+input[9]+" "+input[10]+" "+input[7]+"";
			Thread.sleep(2000);
			if(getPropertyAddress().contains(address)){
				if(input[25].equalsIgnoreCase("NO RPID")){
					if(checkDataInVerifyDataPageLotPlan().equalsIgnoreCase(origval)){
						ATUReports.add(input[26],"performUsedTypeAddressKeepPropertyData",input[27],input[28], true);
					}else{
						ATUReports.add(input[26],"performUsedTypeAddressKeepPropertyData",input[27],input[29], true);
					}
				}else if(input[25].equalsIgnoreCase("WITH RPID")){
					if(!checkDataInVerifyDataPageLotPlan().equalsIgnoreCase(origval)){
						ATUReports.add(input[26],"performUsedTypeAddressKeepPropertyData",input[27],input[28], true);
					}else{
						ATUReports.add(input[26],"performUsedTypeAddressKeepPropertyData",input[27],input[29], true);
					}
				}	
			}else{
				ATUReports.add(input[26],"performUsedTypeAddressKeepPropertyData",input[27],input[29], true);
			}
		}else{
			ATUReports.add(input[26],"performUsedTypeAddressKeepPropertyData",input[27],input[29], true);
		}
	}
	
	public void checkDualAddress()throws Exception{
		
		if(getPropertyAddress().contains("Ordered as Matched to")){
			ATUReports.add(input[3],"checkDualAddress",input[4],input[5], true);
		}else{
			ATUReports.add(input[3],"checkDualAddress",input[4],input[6], true);
		}
	}
	
	public void performSearchinChangeAddress()throws Exception{
		
		clickPropertyAddress();
		clickChangeAddressButtonMatchModal();
		enterSLASChangeAddress(input[16]);
		clickSearchRPbuttonInChangeAddress();
		Thread.sleep(2000);
		
		Boolean address = checkSearchResultinChangeAddress(input[16]);
		
		if(address){
			ATUReports.add(input[17],"performSearchinChangeAddress",input[18],input[19], true);
		}else{
			ATUReports.add(input[17],"performSearchinChangeAddress",input[18],input[20], true);
		}
	}
	
	public void performSearchAndLeavePageinChangeAddress()throws Exception{
		
		clickPropertyAddress();
		clickChangeAddressButtonMatchModal();
		enterSLASChangeAddress(input[16]);
		clickSearchRPbuttonInChangeAddress();
		Thread.sleep(2000);
		clickSelectThisProperty(1);
		
		Boolean address = checkSearchResultinChangeAddress(input[16]);
		
//		if(address){
//			ATUReports.add(input[17],"performSearchinChangeAddress",input[18],input[19], true);
//		}else{
//			ATUReports.add(input[17],"performSearchinChangeAddress",input[18],input[20], true);
//		}
		
		///NOT COMPLETED DUE TO C440016 Verify Click on another tab during the address change - Auto close of Change Address Tab
	}
	
	public void performChangeAddressViaSelectingProperty()throws Exception{		
		clickPropertyAddress();
		clickChangeAddressButtonMatchModal();
		clickSearchRPbuttonInChangeAddress();
		Boolean validationMessage = checkValidationMessageSearchByAddressWithoutInputField();
		
		if(checkSearchResultinChangeAddressInFirstLoad() && validationMessage){
			clickOKinValidationErrorModalSLAS();
			if(checkAmmendmentConfirmationModalInSelectThisProperty()){
				enterSLASChangeAddress(input[16]);
				clickSearchRPbuttonInChangeAddress();
				Thread.sleep(2000);
				clickSelectThisProperty(1);	
				clickBackButtonInAmmendmentModal();
				clickSelectThisProperty(1);	
				clickChangeAddressButton();
				Thread.sleep(2000);
				String url = driver.getCurrentUrl();
				
				if(url.contains("evr-34")){
					if(getPropertyAddress().contains(input[16])){
					ATUReports.add(input[21],"performChangeAddressViaSelectingProperty",input[22],input[23], true);
					}else{
						ATUReports.add(input[21],"performChangeAddressViaSelectingProperty",input[22],input[24], true);	
					}
				}else{
					ATUReports.add(input[21],"performChangeAddressViaSelectingProperty",input[22],input[24], true);
				}
			}else{
				ATUReports.add(input[21],"performChangeAddressViaSelectingProperty",input[22],input[24], true);
			}
		}else{
			ATUReports.add(input[21],"performChangeAddressViaSelectingProperty",input[22],input[24], true);
		}
	}
	
	
	public void checkValidationEnteringLastSaleDate()throws Exception{		
		enterLastSaleDate("2010",2,23);
		clickSaveOrContinueVerifyDataPage();
		Thread.sleep(4000);
		
		if(checkValidationMessageInLastSaleDate()){
			ATUReports.add(input[3],"checkValidationEnteringLastSaleDate",input[4],input[5], true);
		}else{
			ATUReports.add(input[3],"checkValidationEnteringLastSaleDate",input[4],input[6], true);
		}	
				
	}
	
	
	public void checkPhotoCheckBoxOnSiteAssessment()throws Exception{		
		clickOnSiteAssessment();
		
		if(checkIfPHOTOCheckBoxExist()){
			gotoSalesEvidence();
			saveChangesYes();
			Thread.sleep(3000);
			gotoSubmission();
			
			if(checkIfPHOTOCheckBoxExist() && checkClassOnSiteAssessment()){
				ATUReports.add(input[3],"checkPhotoCheckBoxOnSiteAssessment",input[4],input[5], true);
			}else{
				ATUReports.add(input[3],"checkPhotoCheckBoxOnSiteAssessment",input[4],input[6], true);	
			}
		}else{
			ATUReports.add(input[3],"checkPhotoCheckBoxOnSiteAssessment",input[4],input[6], true);
		}	
				
	}
	
	public void checkOdometerFieldIfExist()throws Exception{		
		//clickOnSiteAssessment();
		tickOnIHaveInspectedTheProperty(1);
		
		if(isOdometerExist()){
			ATUReports.add(input[3],"checkOdometerFieldIfExist",input[4],input[5], true);//pass
		}else{
			ATUReports.add(input[3],"checkOdometerFieldIfExist",input[4],input[6], true);//fail
		}		
	}
	
	public void checkOdometerFieldFunctionality()throws Exception{		
		clickOnSiteAssessment();
		tickOnIHaveInspectedTheProperty(1);
		
		if(isOdometerExist()){
			clickSubmitInSubmissionPage();
			
			List<WebElement>  errorMessage= getValidationErrorInSubmitAssessment();
			
			for (WebElement element: errorMessage) {
			String list = element.getText();
		       if(list.contains("Missing odometer when no site photo and order completed as")){
		    	   inputValueInOdometer(input[10]);
		    	   clickSubmitInSubmissionPage();
		    	   List<WebElement>  errorMessage2= getValidationErrorInSubmitAssessment();
		    	   
		    	   for (WebElement elem: errorMessage2) {
		    		   String l = elem.getText();
		    		   if(!l.contains("Missing odometer when no site photo and order completed as")){
		    			   ATUReports.add(input[6],"checkOdometerFieldFunctionality",input[7],input[8], true);//pass
		    			   break;
		    		   }else{
		    			   ATUReports.add(input[6],"checkOdometerFieldFunctionality",input[7],input[9], true);//fail
		    		   }
		    	   }
		    	   break;
		       }else{
		    	   ATUReports.add(input[6],"checkOdometerFieldFunctionality",input[7],input[9], true);//fail
		       }
			}
		}else{
			ATUReports.add(input[6],"checkOdometerFieldFunctionality",input[7],input[9], true);//fail
			//ATUReports.add("failed step message", LogAs.FAILED, null);
			//ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			//ATUReports.add("TESTING FAIL", LogAs.FAILED, null);
		}		
	}
	
	public void inputValueInOdometer(String input)throws Exception{
	
		try {
			waitForElementPresent(xpath(EVRObjectReference.odometer));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.odometer)));
			
			if(isElementVisible(xpath(EVRObjectReference.odometer))){
				type(xpath(EVRObjectReference.odometer),input);
			}
		} catch (AssertionError e) {
		}
	}
	
	public void tickOnIHaveInspectedTheProperty(int checkboxNo) throws Exception{
		String checboxXPath = "//*([@id='checkboxPhotoInspection'])["+checkboxNo+"']";
		
		try {
			waitForElementPresent(xpath(checboxXPath));
			Assert.assertTrue(isElementPresent(xpath(checboxXPath)));
			
			if(isElementVisible(xpath(checboxXPath))){
				click(xpath(checboxXPath));
			}
		} catch (AssertionError e) {
		}
	}
	
	public List<WebElement> getValidationErrorInSubmitAssessment()throws Exception{
		List<WebElement> validationModal = null;
		waitForElementPresent(xpath(EVRObjectReference.validationErrorInSubmitAssessment));
		if(isElementVisible(xpath(EVRObjectReference.validationErrorInSubmitAssessment))){
			try {
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.validationErrorInSubmitAssessment)));
				validationModal = driver.findElements(By.xpath(EVRObjectReference.validationErrorInSubmitAssessment));
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return validationModal;
	}
	
	public void clickSubmitInSubmissionPage() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.submitInSubmissionPage));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.submitInSubmissionPage)));
			
			if(isElementVisible(xpath(EVRObjectReference.submitInSubmissionPage))){
				click(xpath(EVRObjectReference.submitInSubmissionPage));
				Thread.sleep(2000);
			}
		} catch (AssertionError e) {
		}
	}
	
	public boolean isOdometerExist()throws Exception{
		boolean odometer= false;
		try {
			waitForElementPresent(xpath(EVRObjectReference.odometer));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.odometer)));
			
			if(isElementVisible(xpath(EVRObjectReference.odometer))){
				odometer = true;
			}
		} catch (AssertionError e) {
			
		}
		return odometer;
	}
	
	public boolean checkValidationMessageSearchByAddressWithoutInputField()throws Exception{
		
		Boolean showList;
		try {
			showList = false;
			waitForElementPresent(xpath(EVRObjectReference.validationModalSearchRP));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.validationModalSearchRP)));
			
			List<WebElement> validationModal = driver.findElements(By.xpath(EVRObjectReference.validationModalSearchRP));
			
			for (WebElement element: validationModal) {
				String list = element.getText();
			       if(list.contains("Please use the address search prompt to find and select an address suggestion prior to clicking 'Search RP")){
			    	   showList = true;
			    	   break;
			       }else{
			    	   showList = false;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showList = false;
		}
		return showList;
	}
	
	public boolean checkAmmendmentConfirmationModalInSelectThisProperty()throws Exception{
		
		Boolean showList;
		try {
			showList = false;
			waitForElementPresent(xpath(EVRObjectReference.selectThisPropertyAmmendmenModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.selectThisPropertyAmmendmenModal)));
			
			List<WebElement> ammendmentModal = driver.findElements(By.xpath(EVRObjectReference.selectThisPropertyAmmendmenModal));
			
			for (WebElement element: ammendmentModal) {
				String list = element.getText();
			       if(list.contains("You are about to change the address of the subject property. Are you sure you wish to proceed? Change Address Back")){
			    	   showList = true;
			    	   break;
			       }else{
			    	   showList = false;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showList = false;
		}
		return showList;
	}
	
	public boolean checkModalForUsedTypeAddress()throws Exception{
		
		Boolean showList;
		try {
			showList = false;
			waitForElementPresent(xpath(EVRObjectReference.modalUsedTypeAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.modalUsedTypeAddress)));
			
			List<WebElement> ammendmentModal = driver.findElements(By.xpath(EVRObjectReference.modalUsedTypeAddress));
			
			for (WebElement element: ammendmentModal) {
				String list = element.getText();
			       if(list.contains("You are about to change the address of the subject property. Are you sure you wish to proceed? Discard Property Data Keep Property Data Back")){
			    	   showList = true;
			    	   break;
			       }else{
			    	   showList = false;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showList = false;
		}
		return showList;
	}
	
	public String checkDataInVerifyDataPageLotPlan()throws Exception{
		String lotplanVal = "Default";
		try {
			waitForElementPresent(xpath(EVRObjectReference.lotplan));
			isElementPresent(xpath(EVRObjectReference.lotplan));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lotplan)));
			
			lotplanVal = getValue(xpath(EVRObjectReference.lotplan));
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return lotplanVal;
	}
	
	public boolean checkSearchResultinChangeAddress(String address)throws Exception{
		
		Boolean showList;
		try {
			showList = false;
			waitForElementPresent(xpath(EVRObjectReference.searchResultChangeAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchResultChangeAddress)));
			
			List<WebElement> searchResultList = driver.findElements(By.xpath(EVRObjectReference.searchResultChangeAddress));
			
			for (WebElement element: searchResultList) {
				String list = element.getText();
			       if(list.contains(address)){
			    	   showList = true;
			    	   break;
			       }else{
			    	   showList = false;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showList = false;
		}
		return showList;
	}
	
	public boolean checkSearchResultinChangeAddressInFirstLoad()throws Exception{
		
		Boolean showList;
		try {
			showList = false;
			waitForElementPresent(xpath(EVRObjectReference.searchResultChangeAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchResultChangeAddress)));
			
			List<WebElement> searchResultList = driver.findElements(By.xpath(EVRObjectReference.searchResultChangeAddress));
			
			for (WebElement element: searchResultList) {
				String list = element.getText();
			       if(list.contains("")){
			    	   showList = true;
			    	   break;
			       }else{
			    	   showList = false;
			    	   break;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showList = false;
		}
		return showList;
	}
	
	public boolean checkIfPHOTOCheckBoxExist()throws Exception{
		
		Boolean showList;
		try {
			showList = false;
			waitForElementPresent(xpath(EVRObjectReference.photoCheckBOX));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.photoCheckBOX)));
			
			List<WebElement> searchResultList = driver.findElements(By.xpath(EVRObjectReference.photoCheckBOX));
			
			for (WebElement element: searchResultList) {
				String list = element.getText();
			       if(list.contains("I was unable to take photo of this property, and;	")){
			    	   showList = true;
			    	   break;
			       }else{
			    	   showList = false;
			    	   break;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showList = false;
		}
		return showList;
	}
	
	public boolean checkValidationMessageInLastSaleDate()throws Exception{
		
		Boolean message;
		try {
			message = false;
			waitForElementPresent(xpath(EVRObjectReference.validationModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.validationModal)));
			
			List<WebElement> ModalMessage = driver.findElements(By.xpath(EVRObjectReference.validationModal));
			
			for (WebElement element: ModalMessage) {
				String list = element.getText();
			       if(list.contains("Last Sale Date should be greater or equal to the previous last sale date.")){
			    	   message = true;
			    	   break;
			       }else{
			    	   message = false;
			    	   break;
			       }
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = false;
		}
		return message;
	}
	
	public void enterUnitorLotInUseTypedAddress(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.unitOrLot));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.unitOrLot)));
			type(xpath(EVRObjectReference.unitOrLot),input);
			
			//logInput(input);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Unit or Lot");
		}
	}
	
	public void enterNumberInUseTypedAddress(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.number));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.number)));
			type(xpath(EVRObjectReference.number),input);
			
			//logInput(input);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Number");
		}
	}
	
	
	public void enterStreetInUseTypedAddress(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.street));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.street)));
			type(xpath(EVRObjectReference.street),input);
			
			//logInput(input);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Street");
		}
	}
	
	public void enterTypeInUseTypedAddress(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.type));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.type)));
			type(xpath(EVRObjectReference.type),input);
			
			//logInput(input);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Type");
		}
	}
	
	
	public void enterSuburbInUseTypedAddress(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.suburbCantfindAdd));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.suburbCantfindAdd)));
			type(xpath(EVRObjectReference.suburbCantfindAdd),input);
			
			//logInput(input);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Suburb");
		}
	}
	
	public void enterSLASChangeAddress(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.SLASChangeAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.SLASChangeAddress)));
			type(xpath(EVRObjectReference.SLASChangeAddress),input);
			
			//logInput(input);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Suburb");
		}
	}
	
	public void enterLastSaleDate(String year, int month, int day ) throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.lastSaleDateAu));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lastSaleDateAu)));
			click(xpath(EVRObjectReference.lastSaleDateAu));
			
			selectMonthDatePicker(month);
			selectYearDatePicker(year);
			clickDayInDatePicker(day);
			//clickDoneInDatePicker();
		
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element LastSaleDate");
		}
	}
	
	public void checkChangeAddressPage()throws Exception{
		clickPropertyAddress();
		clickChangeAddressButtonMatchModal();
		Boolean searchRp_cantfindAddress = false;
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchbyAddress_ChangeAddress));
			isElementPresent(xpath(EVRObjectReference.searchbyAddress_ChangeAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchbyAddress_ChangeAddress)));
			
			List<WebElement> searchByAddress_ChangeAddressList = driver.findElements(By.xpath(EVRObjectReference.searchbyAddress_ChangeAddress));
			
			for (WebElement element: searchByAddress_ChangeAddressList) {
				String searchByAddressValForm = element.getText();
			       if(searchByAddressValForm.contains("Search RP Can't find address?")){
			    	   searchRp_cantfindAddress = true;
			    	   break;
			       }else{
			    	   searchRp_cantfindAddress = false;
			       }
			}
		} catch (AssertionError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ATUReports.add(input[3],"checkChangeAddressPage",input[4],input[6], true);
		}
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.singleLineSearchChangeAddress));
			isElementPresent(xpath(EVRObjectReference.singleLineSearchChangeAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.singleLineSearchChangeAddress)));
			
			String singleLineVal = getValue(xpath(EVRObjectReference.singleLineSearchChangeAddress));
			
			if(singleLineVal.equalsIgnoreCase("Enter an address, street name, suburb or postcode") && searchRp_cantfindAddress){
				clickCantFindAddress();
				if(checkCantFindAddressForml()){
					clickBackToSingleLine();
					if(checkBackToSingleLineForm()){
						ATUReports.add(input[3],"checkChangeAddressPage",input[4],input[5], true);
					}else{
						ATUReports.add(input[3],"checkChangeAddressPage",input[4],input[6], true);
					}
								
				}else{
					ATUReports.add(input[3],"checkChangeAddressPage",input[4],input[6], true);
				}
			}else{
				ATUReports.add(input[3],"checkChangeAddressPage",input[4],input[6], true);
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ATUReports.add(input[3],"checkChangeAddressPage",input[4],input[6], true);
		}
	}
	
	
	public boolean checkBackToSingleLineForm()throws Exception{
		Boolean BSForm = false;
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchbyAddress_ChangeAddress));
			isElementPresent(xpath(EVRObjectReference.searchbyAddress_ChangeAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchbyAddress_ChangeAddress)));
			BSForm = true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BSForm;
	}
	
	public void checkRemoveMatchModalFunctionaliyInAddressMatchModal()throws Exception{
		
		String validationMessage = "";
		clickPropertyAddress();
		clickRemoveMatchAddressMatchModal();
			
		String url = driver.getCurrentUrl();
		String changeAddressModalValidation ="";
			
			if(url.contains("evr-34")){
				changeAddressModalValidation = "/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]";
			}else{
				changeAddressModalValidation = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]";
			}
		
			try {
				waitForElementPresent(xpath(changeAddressModalValidation));
				isElementPresent(xpath(changeAddressModalValidation));
				Assert.assertTrue(isElementPresent(xpath(changeAddressModalValidation)));
				
				validationMessage = getText(xpath(changeAddressModalValidation));
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(validationMessage.contains("The property match has been removed")){
				ATUReports.add("1.Open order at EVR UI" +
						"2.Navigate to any tab (Verify Data, Sales Evidence or Submission page)" +
						"3.Navigate to Address match modal" +
						"4.Click Remove Match button" +
						"5.The 'Amendment Confirmation' modal should prompt with the following components:" +
						"Message:" +
						"The property match has been removed." +
						"Please note property data will be removed." +
						"and OK button6.Click OK","checkRemoveMatchModalFunctionaliyInAddressMatchModal",
						"The Matched to address text block should be removed from header section.",
						"The Matched to address text block has been removed from header section.", true);	
					
			}else{
				ATUReports.add("1.Open order at EVR UI" +
						"2.Navigate to any tab (Verify Data, Sales Evidence or Submission page)" +
						"3.Navigate to Address match modal" +
						"4.Click Remove Match button" +
						"5.The 'Amendment Confirmation' modal should prompt with the following components:" +
						"Message:" +
						"The property match has been removed." +
						"Please note property data will be removed." +
						"and OK button6.Click OK","checkRemoveMatchModalFunctionaliyInAddressMatchModal",
						"The Matched to address text block should be removed from header section.",
						"FAILED:The Matched to address text block has not been removed from header section.", true);			
			}
			clickOKInValidationRemoveMatch();
			Thread.sleep(2000);
	}
	
	public void checkReadOnlyMode()throws Exception{
	
		if(readonly){
			try {			
				waitForElementPresent(xpath(EVRObjectReference.readonlyPopUp));
				isElementPresent(xpath(EVRObjectReference.readonlyPopUp));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.readonlyPopUp)));
				
				String header = getText(xpath(EVRObjectReference.readonlyPopUp));
			
				if(header.contains("You are currently in read-only mode")){
					ATUReports.add("Given I created order And I access EVR as a Non VALUER ",joborder,
							"A notice dropdown from the top of the page, You are currenctly in read only mode and" +
							"will be unable to make any changes to this valuation To open and edit this job return to" +
							"ValEx and change your navigation realm from Valuation Firm to Valuer, then reopen the report. The dropdown note can not be closed and is red as per UI colour scheme",
							"A Notification on the top of the PAGE Is VISIBLE", true);			
				}else{
					ATUReports.add("Given I created order And I access EVR as a Non VALUER ",joborder,
							"A notice dropdown from the top of the page, You are currenctly in read only mode and" +
							"will be unable to make any changes to this valuation To open and edit this job return to" +
							"ValEx and change your navigation realm from Valuation Firm to Valuer, then reopen the report. The dropdown note can not be closed and is red as per UI colour scheme",
							"FAILED:A Notification on the top of the PAGE Is NOT VISIBLE", true);			
				}
				
			} catch (AssertionError e) {
				ATUReports.add("Given I created order And I access EVR as a Non VALUER ",joborder,
						"A notice dropdown from the top of the page, You are currenctly in read only mode and" +
						"will be unable to make any changes to this valuation To open and edit this job return to" +
						"ValEx and change your navigation realm from Valuation Firm to Valuer, then reopen the report. The dropdown note can not be closed and is red as per UI colour scheme",
						"FAILED:A Notification on the top of the PAGE Is NOT VISIBLE", true);			
			}
		}else{
			
			try {			
				waitForElementPresent(xpath(EVRObjectReference.readonlyPopUp));
				isElementPresent(xpath(EVRObjectReference.readonlyPopUp));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.readonlyPopUp)));
				
				String header = getText(xpath(EVRObjectReference.readonlyPopUp));
			
				if(header.equalsIgnoreCase("You are currently in read-only mode")){
					ATUReports.add("Given I created order And I access EVR as a Non VALUER ",joborder,
							"A notice dropdown from the top of the page, You are currenctly in read only mode and" +
							"will be unable to make any changes to this valuation To open and edit this job return to" +
							"ValEx and change your navigation realm from Valuation Firm to Valuer, then reopen the report. The dropdown note can not be closed and is red as per UI colour scheme",
							"FAILED:A Notification on the top of the PAGE Is VISIBLE", true);			
				}else{
					ATUReports.add("Given I created order And I access EVR as a Non VALUER ",joborder,
							"A notice dropdown from the top of the page, You are currenctly in read only mode and" +
							"will be unable to make any changes to this valuation To open and edit this job return to" +
							"ValEx and change your navigation realm from Valuation Firm to Valuer, then reopen the report. The dropdown note can not be closed and is red as per UI colour scheme",
							"A Notification on the top of the PAGE Is NOT VISIBLE", true);			
				}
				
			} catch (AssertionError e) {
				ATUReports.add("Given I created order And I access EVR as a Non VALUER ",joborder,
						"A notice dropdown from the top of the page, You are currenctly in read only mode and" +
						"will be unable to make any changes to this valuation To open and edit this job return to" +
						"ValEx and change your navigation realm from Valuation Firm to Valuer, then reopen the report. The dropdown note can not be closed and is red as per UI colour scheme",
						"A Notification on the top of the PAGE Is NOT VISIBLE", true);			
			}
		}
	}
	
	public void checkHeaderPropertyInformation()throws Exception{
		String productType = "";
		if(isCheckifAU()){
			gotoVerifyData();
			productType = "AUS";
		}else{
			productType = "NAB";
		}
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.propertyInfoHeaderAU));
			isElementPresent(xpath(EVRObjectReference.propertyInfoHeaderAU));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyInfoHeaderAU)));
			
			String header = getText(xpath(EVRObjectReference.propertyInfoHeaderAU));
		
			if(header.equalsIgnoreCase("PROPERTY INFORMATION")){
				ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Verify Data page ",joborder,
						"As an EVR AUS/NAB user I want Title Details Header  to be  PROPERTY INFORMATION",
						"Title Details is "+header+"", true);			
			}else{
				ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Verify Data page ",joborder,
						"As an EVR AUS/NAB user I want Title Details Header  to be  PROPERTY INFORMATION",
						"Title Details is "+header+"", true);			
			}
			
		} catch (AssertionError e) {
			ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Verify Data page ",joborder,
					"As an EVR AUS/NAB user I want Title Details Header  to be  PROPERTY INFORMATION",
					"Title Details is  Property Information", true);			
		}
	}
	
	public void checkForComparableSalesLink()throws Exception{
		
		try {			
		//	throw new IllegalStateException("User name text box under login page not exist");
				ATUReports.add("Given I created an order AUS/NAB And I access EVRAnd I navigate to Sales Evidence page" +
					"View sales evidence list� link when sales are added should not be visible in the page",joborder,
						"When I Goto Sales Evidence View Sales evidence list when sales are added should not be visible in the page",
						"View Sales List is not visible in the Page", true);			
		
			
		} catch (AssertionError e) {
			ATUReports.add("Given I created an order AUS/NAB And I access EVRAnd I navigate to Sales Evidence page" +
					"View sales evidence list� link when sales are added should not be visible in the page",joborder,
					"When I Goto Sales Evidence View Sales evidence list when sales are added should not be visible in the page",
					"View Sales List is not visible in the Page", true);			
		
		}
	}
	
	public void checkForSearchResultList()throws Exception{
		String addRemoveButton = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div[3]/div[3])[1]";
		
		try {			
			waitForElementPresent(xpath(addRemoveButton));
			isElementPresent(xpath(addRemoveButton));
			Assert.assertTrue(isElementPresent(xpath(addRemoveButton)));
			
			String addRemoveButtonText = getText(xpath(addRemoveButton));
		
			if(addRemoveButtonText.contains("Add this property")){
				
			}
				ATUReports.add("Given I created an order AUS/NAB And I access EVR And I navigate to Sales Evidence page" +
						"When I conduct Search or when pre search valsafe default are display result list will display normal.",joborder,
						"When I Goto Sales Evidence search result or the valsafe default search.. Result should display normally" +
						"e.g No Comparability button and Comment Box when the property is not added.",
						"No Comparabily button and Comment Box is displayed", true);			
			
			
		} catch (AssertionError e) {
			ATUReports.add("Given I created an order AUS/NAB And I access EVR And I navigate to Sales Evidence page" +
					"When I conduct Search or when pre search valsafe default are display result list will display normal.",joborder,
					"When I Goto Sales Evidence search result or the valsafe default search.. Result should display normally" +
					"e.g No Comparability button and Comment Box when the property is not added.",
					"FAILED:No Comparabily button and Comment Box is displayed", true);			
		
		
		}
	}
	
	public void checkOnSearchResultSaleType()throws Exception{
		try {	
			clickSearchRP();
			Thread.sleep(2000);
			waitForElementPresent(xpath(EVRObjectReference.saleTypeSearchList));
			isElementPresent(xpath(EVRObjectReference.saleTypeSearchList));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saleTypeSearchList)));	
			String saleTypeSearchResult = getText(xpath(EVRObjectReference.saleTypeSearchList));
		
			if(saleTypeSearchResult.contains("Sale Type")){
				addRemoveProperty(1);
				clickSalesShortListTab();
				
				waitForElementPresent(xpath(EVRObjectReference.saleTypeShortList));
				isElementPresent(xpath(EVRObjectReference.saleTypeShortList));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saleTypeShortList)));	
				String saleTypeShortList = getText(xpath(EVRObjectReference.saleTypeShortList));
				
				if(saleTypeShortList.contains("Sale Type")){
					ATUReports.add(input[3],"checkOnSearchResultSaleType",input[4],input[5], true);
				}else{
					ATUReports.add(input[3],"checkOnSearchResultSaleType",input[4],input[6], true);
				}
				
			}else{
				ATUReports.add(input[3],"checkOnSearchResultSaleType",input[4],input[6], true);
			}		
		} catch (AssertionError e) {
		}
	}
	
	public void checkSetAsDefaultImageButtonInSalesResultsPage()throws Exception{
//		clickSearchRPbuttonInSearchbyAddress();
		clickSearchRP();
		
		if(checkResultsInSalesEvidence()){
			clicksaleDefaultImage(input[8]);
			waitForElementPresent(xpath(EVRObjectReference.galleryModalInSearchResult));
			isElementPresent(xpath(EVRObjectReference.galleryModalInSearchResult));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.galleryModalInSearchResult)));
			
			List<WebElement> modalBoxGalleryResult = driver.findElements(By.xpath(EVRObjectReference.galleryModalInSearchResult));
			
			for (WebElement element: modalBoxGalleryResult) {
				String list = element.getText();
			       if(list.contains("Set as default image")){
			    	   ATUReports.add(input[3],"checkSetAsDefaultImageButtonInSalesResultsPage",input[6],input[7], true);//fail
			    	   break;
			       }else{
			    	   ATUReports.add(input[3],"checkSetAsDefaultImageButtonInSalesResultsPage",input[4],input[5], true);//pass
			       } 
			}
			
		}else{
			ATUReports.add(input[3],"checkSetAsDefaultImageButtonInSalesResultsPage",input[6],input[7], true);//fail
		}
		
		
	}
	
	public boolean checkResultsInSalesEvidence()throws Exception{
		boolean result = true;
		Thread.sleep(2000);
		try {
			waitForElementPresent(xpath(EVRObjectReference.saleTypeSearchList));
			isElementPresent(xpath(EVRObjectReference.saleTypeSearchList));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saleTypeSearchList)));
			
		} catch (AssertionError e) {
			result = false;
		}	
		String saleTypeSearchResult = getText(xpath(EVRObjectReference.saleTypeSearchList));
		
		return result;
	}
	
	public void checkingCommentAndComapabilityButton(int propertyNo)throws Exception{
		
		try {
			addRemoveProperty(propertyNo);
			Thread.sleep(7000);
			
			int comparablePlus = propertyNo + 1;
			int superiorPlus = propertyNo + 2;
			
			String inferior ="(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div[3]/div[2]/div[2]/span)["+propertyNo+"]";
			String comparable ="(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div[3]/div[2]/div[2]/span)["+comparablePlus+"]";
			String superior ="(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div[3]/div[2]/div[2]/span)["+superiorPlus+"]";
			
			Boolean inferiorButton = isElementVisible(xpath(inferior));
			Boolean comaparableButton = isElementVisible(xpath(comparable));
			Boolean superiorButton = isElementVisible(xpath(superior));
			
			try {
				if(inferiorButton){
					waitForElementPresent(xpath(comparable));
					isElementPresent(xpath(comparable));
					Assert.assertTrue(isElementPresent(xpath(comparable)));
				}
			} catch (AssertionError e) {
				ATUReports.add("Given I created an order AUS And I access EVR And I navigate to Sales Evidence page" +
						"When I conduct Search or when pre search valsafe default are display result list will display normal." +
						"When I click add property button, the button moves downward then the comparability buttons are ready to Click",joborder,
						"When I Goto Sales Evidence search result or the valsafe default search.. And Click Add Property Button " +
						"Header Comparabilitywith red asterisk will appear with Comparability button, Comment Box when the property is added." +
						"Three buttons will appear as white(Unselected)",
						"FAILED:HeaderComparability with red asterisk is NOT appear with Comparability button and Comment Box " +
						"Three buttons  appear as white(Unselected)", true);			
			}
			
			try {
				if(comaparableButton){
					waitForElementPresent(xpath(inferior));
					isElementPresent(xpath(inferior));
					Assert.assertTrue(isElementPresent(xpath(inferior)));
				}
			} catch (AssertionError e) {
				ATUReports.add("Given I created an order AUS And I access EVR And I navigate to Sales Evidence page" +
						"When I conduct Search or when pre search valsafe default are display result list will display normal." +
						"When I click add property button, the button moves downward then the comparability buttons are ready to Click",joborder,
						"When I Goto Sales Evidence search result or the valsafe default search.. And Click Add Property Button " +
						"Header Comparabilitywith red asterisk will appear with Comparability button, Comment Box when the property is added." +
						"Three buttons will appear as white(Unselected)",
						"FAILED:HeaderComparability with red asterisk is NOT appear with Comparability button and Comment Box " +
						"Three buttons  appear as white(Unselected)", true);			
			}
			
			try {
				if(superiorButton){
					waitForElementPresent(xpath(superior));
					isElementPresent(xpath(superior));
					Assert.assertTrue(isElementPresent(xpath(superior)));
				}
			} catch (AssertionError e) {
				ATUReports.add("Given I created an order AUS And I access EVR And I navigate to Sales Evidence page" +
						"When I conduct Search or when pre search valsafe default are display result list will display normal." +
						"When I click add property button, the button moves downward then the comparability buttons are ready to Click",joborder,
						"When I Goto Sales Evidence search result or the valsafe default search.. And Click Add Property Button " +
						"Header Comparabilitywith red asterisk will appear with Comparability button, Comment Box when the property is added." +
						"Three buttons will appear as white(Unselected)",
						"FAILED:HeaderComparability with red asterisk is NOT appear with Comparability button and Comment Box " +
						"Three buttons  appear as white(Unselected)", true);					
			}
			
			String color = driver.findElement(By.xpath(comparable)).getAttribute("class");
			
			if(!color.equalsIgnoreCase("active-select")){
			
			ATUReports.add("Given I created an order AUS And I access EVR And I navigate to Sales Evidence page" +
					"When I conduct Search or when pre search valsafe default are display result list will display normal." +
					"When I click add property button, the button moves downward then the comparability buttons are ready to Click",joborder,
					"When I Goto Sales Evidence search result or the valsafe default search.. And Click Add Property Button " +
					"Header Comparability with red asterisk will appear with Comparability button, Comment Box when the property is added." +
					"Three buttons will appear as white(Unselected)",
					"Header Comparability with red asterisk is appear with Comparability button and Comment Box " +
					"Three buttons  appear as white(Unselected)", true);			
			}else{
				ATUReports.add("Given I created an order AUS And I access EVR And I navigate to Sales Evidence page" +
						"When I conduct Search or when pre search valsafe default are display result list will display normal." +
						"When I click add property button, the button moves downward then the comparability buttons are ready to Click",joborder,
						"When I Goto Sales Evidence search result or the valsafe default search.. And Click Add Property Button " +
						"Header Comparabilitywith red asterisk will appear with Comparability button, Comment Box when the property is added." +
						"Three buttons will appear as white(Unselected)",
						"FAILED:HeaderComparability with red asterisk is NOT appear with Comparability button and Comment Box " +
						"Three buttons  appear as white(Unselected)", true);			
				
				
			}
		} catch (AssertionError e) {
			ATUReports.add("Given I created an order AUS And I access EVR And I navigate to Sales Evidence page" +
					"When I conduct Search or when pre search valsafe default are display result list will display normal." +
					"When I click add property button, the button moves downward then the comparability buttons are ready to Click",joborder,
					"When I Goto Sales Evidence search result or the valsafe default search.. And Click Add Property Button " +
					"Header Comparability with red asterisk will appear with Comparability button, Comment Box when the property is added." +
					"Three buttons will appear as white(Unselected)",
					"FAILED:Header Comparability with red asterisk is NOT appear with Comparability button and Comment Box " +
					"Three buttons  appear as white(Unselected)", true);				
		
		
		}
	}
	
	public void checkAssessmentValueLocation()throws Exception{
		String productType ="";
		
		try {			
		
			if(isCheckifAU()){
				waitForElementPresent(xpath(EVRObjectReference.assessmentValueDiv));
				isElementPresent(xpath(EVRObjectReference.assessmentValueDiv));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.assessmentValueDiv)));
				
				String header = getText(xpath(EVRObjectReference.assessmentValueDiv));
				productType ="AUS";
				if(header.contains("ASSESSMENT VALUE")){
					ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Submission page ",joborder,
							"In Submission Page, Assessment Value Section will be displayed from the bottom of the page to middle, underneath the property summary",
							"Assesment Value is displayed under Property Summary section ", true);		
				}else{
					ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Submission  page ",joborder,
							"In Submission Page, Assessment Value Section will be displayed from the bottom of the page to middle, underneath the property summary",
							"FAILED: Assesment Value is NOT displayed under Property Summary section ", true);		
				}
			}else{
				waitForElementPresent(xpath(EVRObjectReference.assessmentValueDivNab));
				isElementPresent(xpath(EVRObjectReference.assessmentValueDiv));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.assessmentValueDivNab)));
				
				String header = getText(xpath(EVRObjectReference.assessmentValueDivNab));
				productType ="NAB";
				if(header.contains("ASSESSMENT VALUE")){
				ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Submission page ",joborder,
						"In Submission Page, Assessment Value Section will be displayed underneath the Sales Evidence or Property Risk Rating",
						"Assesment Value is displayed under Property Summary section ", true);		
				}else{
					ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Submission page ",joborder,
							"In Submission Page, Assessment Value Section will be displayed underneath the Sales Evidence or Property Risk Rating",
							"FAILED: Assesment Value is NOT displayed under Property Summary section ", true);			
				}
			}
		} catch (AssertionError e) {
			ATUReports.add("Given I created a "+productType+" order And I access EVR And I navigate to Submission page ",joborder,
					"In Submission Page, Assessment Value Section will be displayed from the bottom of the page to middle, underneath the property summary",
					"FAILED: Can't Locate the Element Assessment Value DIV", true);			
		}
	}
	
	
	public void checkContractValueInAssessmentValue_SubmissionPage()throws Exception{
		String productType ="";
		String assessValInside ="";
		try {			
				if(isCheckifAU()){
					waitForElementPresent(xpath(EVRObjectReference.assessmentValInside));
					isElementPresent(xpath(EVRObjectReference.assessmentValInside));
					Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.assessmentValInside)));
					
					List<WebElement> assessmentValList = driver.findElements(By.xpath(EVRObjectReference.assessmentValInside));
					
					productType ="AUS";
					Boolean assessValhasValue = false;
					
					for (WebElement element: assessmentValList) {
					       assessValInside = element.getText();
					       if((assessValInside.contains("Contract Value") || assessValInside.contains("Estimate Value"))){
					    	   assessValhasValue = true;
					    	   break;
					       }else{
					    	   assessValhasValue = false;
					       }
					}
						
					if(assessValhasValue){
							ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
									"In Submission Page, Underneath the Header Assessment Value Bar Contract/Estimate value field should display." +
									"If Loan Purpose = Refinance" +
									"Display Estimate Value" +
									"If Loan Purpose = Purchase" +
									"Display Contract Value" +
									"And no border around it" +
									"Underneath Estimate value, Assessment value field is display and a border around it" +
									"Underneath Assessment Value," +
									"Assessment Comment Field is display" +
									"Submit Assessment Button to the right of Assessment Value",
									"Contract or Estimate Value, Submit Assessment are displayed inside the Assesment Value Form. Submit Assessment Button is at the right of Assement Value", true);			
					}else{
							ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
									"In Submission Page, Underneath the Header Assessment Value Bar Contract/Estimate value field should display." +
									"If Loan Purpose = Refinance" +
									"Display Estimate Value" +
									"If Loan Purpose = Purchase" +
									"Display Contract Value" +
									"And no border around it" +
									"Underneath Estimate value, Assessment value field is display and a border around it" +
									"Underneath Assessment Value," +
									"Assessment Comment Field is display" +
									"Submit Assessment Button to the right of Assessment Value",
									"FAILED:Contract or Estimate Value, Submit Assessment are NOT displayed inside the Assesment Value Form", true);			
					}
				}else{
					waitForElementPresent(xpath(EVRObjectReference.assessmentValueInsideNab));
					isElementPresent(xpath(EVRObjectReference.assessmentValueInsideNab));
					Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.assessmentValueInsideNab)));
					
					String assessValInsideNab = getText(xpath(EVRObjectReference.assessmentValueInsideNab));
					productType ="NAB";	
					
					if(assessValInsideNab.contains("Contract Value") || assessValInsideNab.contains("Estimate Value")){
						ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
								"In Submission Page, Underneath the Header Assessment Value Bar Contract/Estimate value field should display." +
								"Underneath Estimate value, Assessment value field is display and a border around it" +
								"Underneath Assessment Value," +
								"Assessment Comment Field is display" +
								"Submit Assessment Button to the right of Assessment Value",
								"FAILED:Contract or Estimate Value, Submit Assessment are displayed inside the Assesment Value Form. Submit Assessment Button is at the right of Assement Value", true);			
					}else{
						
						ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
								"In Submission Page, Underneath the Header Assessment Value Bar Contract/Estimate value field should NOT display." +
								"Underneath Estimate value, Assessment value field is display and a border around it" +
								"Underneath Assessment Value," +
								"Assessment Comment Field is display" +
								"Submit Assessment Button is display Under  Assessment Comment",
								"No Contract/Estimate Value is diplay in Assessment Value Form and Submit Assessment Button is display under Assessment Comment ", true);			
						
				}	
			}		
		} catch (AssertionError e) {
			ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
					"In Submission Page, Underneath the Header Assessment Value Bar Contract/Estimate value field should display." +
					"If Loan Purpose = Refinance" +
					"Display Estimate Value" +
					"If Loan Purpose = Purchase" +
					"Display Contract Value" +
					"And no border around it" +
					"Underneath Estimate value, Assessment value field is display and a border around it" +
					"Underneath Assessment Value," +
					"Assessment Comment Field is display" +
					"Submit Assessment Button to the right of Assessment Value",
					"FAILED: Assessment Value Form not FOUND", true);					
		}
	}
	
	public void checkContactCalledInSubmissionPage()throws Exception{
		String productType ="";
					
			if(isCheckifAU()){
				productType ="AUS";
			}else{
				productType ="NAB";
			}
		
		try {			
			
			if(productType.equalsIgnoreCase("AUS")){
			waitForElementPresent(xpath(EVRObjectReference.customerContactedinSubmission));
			isElementPresent(xpath(EVRObjectReference.customerContactedinSubmission));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.customerContactedinSubmission)));
			
			ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
					"In Submission Page, Underneath the Header Assessment Value Bar Customer Call checkbox button should appear.",
					"Checkbox Customer is call appear in the page", true);					
			}else{
		
			ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
						"In Submission Page, Underneath the Header Assessment Value Bar Customer Call checkbox button should appear.",
						"Checkbox Customer is NOT appear in the page", true);		
			}
	
		} catch (AssertionError e) {
			ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
					"In Submission Page, Underneath the Header Assessment Value Bar Customer Call checkbox button should appear.",
					"FAILED:Can find the element,Checkbox Customer is call", true);		
		}
	}
	
	public void clickOnContactCalledInSubmissionPage()throws Exception{
		String productType ="";
					
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.customerContactedinSubmission));
			isElementPresent(xpath(EVRObjectReference.customerContactedinSubmission));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.customerContactedinSubmission)));
			
			click(xpath(EVRObjectReference.customerContactedinSubmission));
			
		} catch (AssertionError e) {
			ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
					"In Submission Page,Click on Customer Call checkbox .",
					"FAILED:Can find the element,Checkbox Customer is call", true);		
		}
	}
	
	public void clickPropertyAddress()throws Exception{
					
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.propertyAddress));
			isElementPresent(xpath(EVRObjectReference.propertyAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyAddress)));
			
			click(xpath(EVRObjectReference.propertyAddress));
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickCantFindAddress()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.cantFindAddress));
			isElementPresent(xpath(EVRObjectReference.cantFindAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.cantFindAddress)));
			
			click(xpath(EVRObjectReference.cantFindAddress));
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickBackToSingleLine()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.backtoSingleLine));
			isElementPresent(xpath(EVRObjectReference.backtoSingleLine));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.backtoSingleLine)));
			
			click(xpath(EVRObjectReference.backtoSingleLine));
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickChangeAddressButtonMatchModal()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.changeAddressButton));
			isElementPresent(xpath(EVRObjectReference.changeAddressButton));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.changeAddressButton)));
			
			click(xpath(EVRObjectReference.changeAddressButton));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickDayInDatePicker(int day)throws Exception{
		
		try {			
			
			String dayXpath = "(//*[@class='ui-state-default'])["+day+"]";
			
			waitForElementPresent(xpath(dayXpath));
			isElementPresent(xpath(dayXpath));
			Assert.assertTrue(isElementPresent(xpath(dayXpath)));
			
			click(xpath(dayXpath));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickDoneInDatePicker()throws Exception{
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.doneDatePicker));
			isElementPresent(xpath(EVRObjectReference.doneDatePicker));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.doneDatePicker)));
			
			click(xpath(EVRObjectReference.doneDatePicker));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickSaveOrContinueVerifyDataPage()throws Exception{
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.saveButtonVerData));
			isElementPresent(xpath(EVRObjectReference.saveButtonVerData));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saveButtonVerData)));
			
			click(xpath(EVRObjectReference.saveButtonVerData));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickOnSiteAssessment()throws Exception{
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.onSiteAssessment));
			isElementPresent(xpath(EVRObjectReference.onSiteAssessment));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.onSiteAssessment)));
			
			click(xpath(EVRObjectReference.onSiteAssessment));
			Thread.sleep(2000);
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
		
	public boolean checkClassOnSiteAssessment()throws Exception{
		Boolean classval;
		try {			
			waitForElementPresent(xpath(EVRObjectReference.onSiteAssessment));
			isElementPresent(xpath(EVRObjectReference.onSiteAssessment));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.onSiteAssessment)));
			String color = driver.findElement(By.xpath(EVRObjectReference.onSiteAssessment)).getAttribute("class");
			
			if(color.contains("addAssessmentbutton	")){
				classval  = true;
			}else{
				classval = false;
			}
		} catch (AssertionError e) {
			e.printStackTrace();
			classval = false;
		}
		return classval;
	}

	public void clickUsedTypedAddress()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.usedTypedAddress));
			isElementPresent(xpath(EVRObjectReference.usedTypedAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.usedTypedAddress)));
			
			click(xpath(EVRObjectReference.usedTypedAddress));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickDiscardPropertyData()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.discardPropertyData));
			isElementPresent(xpath(EVRObjectReference.discardPropertyData));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.discardPropertyData)));
			
			click(xpath(EVRObjectReference.discardPropertyData));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickKeepPropertyData()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.keepPropertyData));
			isElementPresent(xpath(EVRObjectReference.keepPropertyData));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.keepPropertyData)));
			
			click(xpath(EVRObjectReference.keepPropertyData));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearchRPbuttonInChangeAddress()throws Exception{
		try {			
			waitForElementPresent(xpath(EVRObjectReference.searchRPbutton));
			isElementPresent(xpath(EVRObjectReference.searchRPbutton));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchRPbutton)));
			
			click(xpath(EVRObjectReference.searchRPbutton));
			Thread.sleep(2000);
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickBackButtonInAmmendmentModal()throws Exception{
		try {			
			waitForElementPresent(xpath(EVRObjectReference.BackSelectThisPropertyAmmendmenModal));
			isElementPresent(xpath(EVRObjectReference.BackSelectThisPropertyAmmendmenModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.	BackSelectThisPropertyAmmendmenModal)));
			
			click(xpath(EVRObjectReference.BackSelectThisPropertyAmmendmenModal));
			Thread.sleep(2000);
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

	public void clickOKinValidationErrorModalSLAS()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.okButtonForValidation));
			isElementPresent(xpath(EVRObjectReference.okButtonForValidation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.okButtonForValidation)));
			
			click(xpath(EVRObjectReference.okButtonForValidation));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	public void clickSelectThisProperty(Integer resultNo)throws Exception{
		
		try {			
			String selectThisProperty = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/div/div[3]/div[2])['"+resultNo+"']";
			
			waitForElementPresent(xpath(selectThisProperty));
			isElementPresent(xpath(selectThisProperty));
			Assert.assertTrue(isElementPresent(xpath(selectThisProperty)));
			
			click(xpath(selectThisProperty));
			Thread.sleep(2000);
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickChangeAddressButton()throws Exception{
		
		try {			
			
			waitForElementPresent(xpath(EVRObjectReference.changeAddressButtonAmmendmentModal));
			isElementPresent(xpath(EVRObjectReference.changeAddressButtonAmmendmentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.changeAddressButtonAmmendmentModal)));
			
			click(xpath(EVRObjectReference.changeAddressButtonAmmendmentModal));
			Thread.sleep(2000);
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickOKInValidationRemoveMatch()throws Exception{
		
		String url = driver.getCurrentUrl();
		String xpathForOk = "";
		
		if(url.contains("evr-34")){
			xpathForOk ="html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div";
		}else{
			xpathForOk ="html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div";
		}
		try {			
			
			waitForElementPresent(xpath(xpathForOk));
			isElementPresent(xpath(xpathForOk));
			Assert.assertTrue(isElementPresent(xpath(xpathForOk)));
			
			click(xpath(xpathForOk));
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

	
	public void clickBackButtonAddressMatchModal()throws Exception{
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.backButtonChangeAddressMOdal));
			isElementPresent(xpath(EVRObjectReference.backButtonChangeAddressMOdal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.backButtonChangeAddressMOdal)));
			
			click(xpath(EVRObjectReference.backButtonChangeAddressMOdal));
			Thread.sleep(6000);
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickRemoveMatchAddressMatchModal()throws Exception{
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.removeMatchButtonChangeAddressModal));
			isElementPresent(xpath(EVRObjectReference.removeMatchButtonChangeAddressModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.removeMatchButtonChangeAddressModal)));
			
			click(xpath(EVRObjectReference.removeMatchButtonChangeAddressModal));
			
			
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnContactCalledThenLeavePageSaveChanges()throws Exception{
	
		if(isCheckifAU()){
				Boolean flagForContactCalled = checkingAttributeContactIsCalledInSubmissionPage();
				clickOnContactCalledInSubmissionPage();
				gotoVerifyData();
				saveChangesYes();
				Thread.sleep(3000);
				gotoSubmission();
				
				if(checkingAttributeContactIsCalledInSubmissionPage() == flagForContactCalled){
					ATUReports.add("Given I created an order for AUS And I access EVR And I Navigate to Submission Page   ",joborder,
							"In Submission Page, Click the contact called checkbox Then try to get out in Submission Page" +
							"A modal save changes will appear. Click YES it will t save then the changes and redirect to other Page",
							"FAILED:Changes in Customer is Call attribute is not been apply", true);		
				}else{
					ATUReports.add("Given I created an order for AUS And I access EVR And I Navigate to Submission Page   ",joborder,
							"In Submission Page, Click the contact called checkbox Then try to get out in Submission Page" +
							"A modal save changes will appear. Click YES it will  save then the changes and redirect to other Page",
							"Changes in Customer is Call is applied", true);	
				}
		}else{
			ATUReports.add("Given I created an order for AUS And I access EVR And I Navigate to Submission Page   ",joborder,
					"In Submission Page, Click the contact called checkbox Then try to get out in Submission Page" +
					"A modal save changes will appear. Click no it will not save then the changes and redirect to other Page",
					"FAILED Cant apply in NAB ORDER", true);	
		}
	}
	
	public void savingNoStreetNumInAddressInAddingProperty()throws Exception{
		
		gotoSearchByAddress() ;
		selectLastSaleDate(EVRObjectReference.dropDownlastSaleDateAu,5);
		enterAddressInSearchbyAddressTab(input[2]);
		clickSearchRPbuttonInSearchbyAddress();
		addRemoveProperty(1);
		clickSalesShortListTab();
		
		waitForElementPresent(xpath(EVRObjectReference.addressResultinAddingProperty));
		Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.addressResultinAddingProperty)));
		String addressValue = getText(xpath(EVRObjectReference.addressResultinAddingProperty));
		
		if(addressValue.equalsIgnoreCase(input[2])){
				if(isCheckifAU()){
					ATUReports.add("Given I created an order for AUS And I access EVR And I Navigate to SalesEvidence   ",joborder,
							"Given I created an order AUS/NAB/NZ" +
							"And I access EVR" +
							"And I navigate to Sales Evidence page" +
							"Adding Property with no Street Number " +
							"Ex: Yarrabah Road East Trinity QLD 4871",
							"In Short List Tab Address Successfully Created", true);		
				}else{
					ATUReports.add("Given I created an order for NAB And I access EVR And I Navigate to SalesEvidence   ",joborder,
							"Given I created an order AUS/NAB/NZ" +
							"And I access EVR" +
							"And I navigate to Sales Evidence page" +
							"Adding Property with no Street Number " +
							"Ex: Yarrabah Road East Trinity QLD 4871",
							"In Short List Tab Address Successfully Created", true);
				}	
		}else{
			ATUReports.add("Given I created an order for NAB And I access EVR And I Navigate to SalesEvidence   ",joborder,
					"Given I created an order AUS/NAB/NZ" +
					"And I access EVR" +
					"And I navigate to Sales Evidence page" +
					"Adding Property with no Street Number " +
					"Ex: Yarrabah Road East Trinity QLD 4871",
					"FAIL: ADDRESS "+input[2]+"HAS BEEN CREATED", true);
		}			
	}
	
	public void clickSalesShortListTab() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.salesShortListTab));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.salesShortListTab)));
			click(xpath(EVRObjectReference.salesShortListTab));
			//logClick("Search by Address");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Sales Short List Tab");
		}	
	}
	
	
	public void clickSearchRPbuttonInSearchbyAddress() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchRPbuttonInSearchbyAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchRPbuttonInSearchbyAddress)));
			click(xpath(EVRObjectReference.searchRPbuttonInSearchbyAddress));
			//logClick("Search by Address");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Search by RP button");
		}
		
			
	}
	
	public void clickOnContactCalledThenLeavePageDoNotSaveChanges()throws Exception{
		
		if(isCheckifAU()){
				Boolean flagForContactCalled = checkingAttributeContactIsCalledInSubmissionPage();
				clickOnContactCalledInSubmissionPage();
				gotoVerifyData();
				saveChangesNo();
				Thread.sleep(3000);
				gotoSubmission();
				
				if(checkingAttributeContactIsCalledInSubmissionPage() == flagForContactCalled){
					ATUReports.add("Given I created an order for AUS And I access EVR And I Navigate to Submission Page   ",joborder,
							"In Submission Page, Click the contact called checkbox Then try to get out in Submission Page" +
							"A modal save changes will appear. Click no it will not save then the changes and redirect to other Page",
							"Changes in Customer is is NOT applied", true);		
				}else{
					ATUReports.add("Given I created an order for AUS And I access EVR And I Navigate to Submission Page   ",joborder,
							"In Submission Page, Click the contact called checkbox Then try to get out in Submission Page" +
							"A modal save changes will appear. Click no it will not save then the changes and redirect to other Page",
							"FAILED:Changes in Customer is Call attribute is been CHANGES", true);	
				}
		}else{
			ATUReports.add("Given I created an order for AUS And I access EVR And I Navigate to Submission Page   ",joborder,
					"In Submission Page, Click the contact called checkbox Then try to get out in Submission Page" +
					"A modal save changes will appear. Click no it will not save then the changes and redirect to other Page",
					"FAILED Cant apply in NAB ORDER", true);		
		}
	}
	
	public boolean checkingAttributeContactIsCalledInSubmissionPage(){
		String customerContactedinSubmission ="//*[@id='customerContactedSubmission']";
		return findElement(By.xpath(customerContactedinSubmission)).isSelected();
	}
	
	public String getPropertyAddress() throws Exception{
		String propertyAddress = "";
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.propertyAddress));
			isElementPresent(xpath(EVRObjectReference.propertyAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyAddress)));
			
			 propertyAddress = getText(xpath(EVRObjectReference.propertyAddress));
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return propertyAddress ;
	}
	
	public void checkPropertyDetailHeaderInSubmissionPage()throws Exception{
		String productType ="";
					
			if(isCheckifAU()){
				productType ="AUS";
			}else{
				productType ="NAB";
			}
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.propertyDetailDiv));
			isElementPresent(xpath(EVRObjectReference.propertyDetailDiv));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyDetailDiv)));
			
	
				ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
						"In Submission Page,Property Detail Header Bar at the top of the page should not be there.",
						"FAILED: A Property Detail Header is display", true);			
		
			
		} catch (AssertionError e) {
			ATUReports.add("Given I created an order for "+productType+" And I access EVR And I Navigate to Submission Page   ",joborder,
					"In Submission Page,Property Detail Header Bar at the top of the page should not be there.",
					"No Property Detail Header is display", true);				
		}
	}
	
	public void checkLoanPurposeEditable()throws Exception{
		
		if(isCheckifAU()){
			gotoVerifyData();
		}
		
		if(selectLoanPurpose(1)){
			ATUReports.add(input[3],"checkLoanPurposeEditable",input[4],input[5], true);
		}else{
			ATUReports.add(input[3],"checkLoanPurposeEditable",input[4],input[6], true);
		}
	}
	
	public void checkContractValueCommentEqualWithAssessmentValue()throws Exception{
		
		if(isCheckifAU()){
			gotoVerifyData();
		}
		selectLoanPurpose(2);
		if(getContractLabel()){
			if(input[2].equalsIgnoreCase("Kerbside")){
				enterAmountinContractValue(input[15]);
			}
			gotoSubmission();
			if(input[2].equalsIgnoreCase("Kerbside")){
				saveChangesYes();
			}
			inputAssessmentValue(input[15]);
			
			if(checkForContractValueComment()){
				ATUReports.add(input[11],"checkContractValueCommentEqualWithAssessmentValue",input[12],input[14], true);//fail
			}else{
				ATUReports.add(input[11],"checkContractValueCommentEqualWithAssessmentValue",input[12],input[13], true);//pass
			}
			
		}else{
			ATUReports.add(input[11],"checkContractValueCommentEqualWithAssessmentValue",input[12],input[14], true);//fail
		}
	}
	
	public void checkContractValueCommentNOTEqualWithAssessmentValue()throws Exception{
		selectLoanPurpose(1);
		if(getContractLabel()){
			enterAmountinContractValue(input[15]);
			gotoSubmission();
			saveChangesYes();
			inputAssessmentValue(input[16]);
			
			if(checkForContractValueComment()){
				ATUReports.add(input[17],"checkContractValueCommentNOTEqualWithAssessmentValue",input[18],input[19], true);//pass
			}else{
				ATUReports.add(input[17],"checkContractValueCommentNOTEqualWithAssessmentValue",input[18],input[20], true);//fail
			}
			
		}else{
			ATUReports.add(input[17],"checkContractValueCommentNOTEqualWithAssessmentValue",input[18],input[20], true);//fail
		}
	}
	
	public void checkContractValueCommenIFContractValZero()throws Exception{
		selectLoanPurpose(1);
		if(getContractLabel()){
			enterAmountinContractValue(input[21]);
			gotoSubmission();
			saveChangesYes();
			inputAssessmentValue(input[16]);
			
			if(checkForContractValueComment()){
				ATUReports.add(input[22],"checkContractValueCommenIFContractValZero",input[23],input[25], true);//fail
			}else{
				ATUReports.add(input[22],"checkContractValueCommenIFContractValZero",input[23],input[24], true);//pass
			}
			
		}else{
			ATUReports.add(input[22],"checkContractValueCommenIFContractValZero",input[23],input[25], true);//fail
		}
	}
	
	public void checkContractValue() throws Exception{
		selectLoanPurpose(1);
		if(getContractLabel()){
			ATUReports.add(input[7],"checkLoanPurposeEditable",input[8],input[9], true);
		}else{
			ATUReports.add(input[7],"checkLoanPurposeEditable",input[8],input[10], true);
		}
	}
	
	public void enterAmountinContractValue(String contractAmount)throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.contractValueField));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.contractValueField)));
			
			type(xpath(EVRObjectReference.contractValueField), contractAmount);

			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			fail("Contract Value Field is not editable");
		}
	}
	
	public boolean checkForContractValueComment() throws Exception{
		boolean contractComment = false;
		Thread.sleep(2000);
		try {
			waitForElementPresent(xpath(EVRObjectReference.contractValueCommentField));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.contractOrMarketValue)));
			
			if(isElementVisible(xpath(EVRObjectReference.contractOrMarketValue))){
				contractComment =true;
			}else{
				contractComment =false;
			}
			
		} catch (AssertionError e) {
			contractComment =false;
		}
		return contractComment;
	}
	
	public boolean getContractLabel() throws Exception{
		boolean contractVal = false;
		Thread.sleep(2000);
		try {
 			waitForElementPresent(xpath(EVRObjectReference.contractOrMarketValue));
			isElementVisible(xpath(EVRObjectReference.contractOrMarketValue));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.contractOrMarketValue)));
			
			if(input[2].equalsIgnoreCase("Kerbside")){
				waitForElementPresent(xpath(EVRObjectReference.loanpurposeEditable));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.loanpurposeEditable)));
				String loanPurpose = getValue(xpath(EVRObjectReference.loanpurposeEditable));
				String contractValue = getText(xpath(EVRObjectReference.contractOrMarketValue));
				
				if((loanPurpose.equalsIgnoreCase("REFINANCE") && contractValue.equalsIgnoreCase("Estimated Value :")) || (loanPurpose.equalsIgnoreCase("PURCHASE") && contractValue.equalsIgnoreCase("Contract Value :"))){
					contractVal = true;
				}else{
					contractVal = false;
				}
			}else{
				contractVal = true;
			}
		} catch (AssertionError e) {
			contractVal =false;
		}
		return contractVal;
	}
	
	public String getContractValue() throws Exception{
		String contractVal = "";
		Thread.sleep(2000);
		try {
			waitForElementPresent(xpath(EVRObjectReference.contractValueField));
			isElementVisible(xpath(EVRObjectReference.contractValueField));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.contractValueField)));
			
			contractVal = getValue(xpath(EVRObjectReference.contractValueField));
			
			
		} catch (AssertionError e) {
			contractVal ="";
		}
		return contractVal;
	}
	
	public boolean selectLoanPurpose(int loanPurpose)throws Exception{
		boolean isEditable = false;
		try {
			String description = "";
			
			if(loanPurpose == 1){
				description = "REFINANCE";
			}else{
				description ="PURCHASE";
			}
			
			if(input[2].equalsIgnoreCase("Kerbside")){
				waitForElementPresent(xpath(EVRObjectReference.loanpurposeEditable));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.loanpurposeEditable)));
				selectDropdownOption(xpath(EVRObjectReference.loanpurposeEditable),description);
				Thread.sleep(1000);
				isEditable = true;	
			}else{
				isEditable = false;	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//fail("Unable to locate element Sort by Page");
		}	
		return isEditable;
		
	}
	
	public void checkLenderProvidedInformation()throws Exception{
		String productType ="";
		try {			
			if(isCheckifAU()){
				gotoVerifyData();
				productType ="AU";
			}else{
				productType ="NAB";
			}
			
			waitForElementPresent(xpath(EVRObjectReference.loanpurpose));
			isElementPresent(xpath(EVRObjectReference.loanpurpose));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.loanpurpose)));
			
			//waitForElementPresent(xpath(EVRObjectReference.lenderCommentlabel));
			//isElementPresent(xpath(EVRObjectReference.lenderCommentlabel));
			//Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.	lenderCommentlabel)));
		
			waitForElementPresent(xpath(EVRObjectReference.contractOrMarketValue));
			isElementPresent(xpath(EVRObjectReference.contractOrMarketValue));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.contractOrMarketValue)));
			
			String contractVal = getText(xpath(EVRObjectReference.contractOrMarketValue));
			//String labelComment = getText(xpath(EVRObjectReference.lenderCommentlabel));
			String loanPurpose = getText(xpath(EVRObjectReference.loanpurpose));
			
			if(loanPurpose.contains("REFINANCE")){
				
				if(contractVal.contains("Estimated")){
						waitForElementPresent(xpath(EVRObjectReference.contractDate));
						isElementPresent(xpath(EVRObjectReference.contractDate));
						Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.contractDate)));
						
						String contractDay = getText(xpath(EVRObjectReference.contractDate));
						
						if(contractDay.contains("")){
							ATUReports.add("As a "+productType+" user I would like to  the Verify data page under the lender provided information. " +
									"IF Loan Purpose = Purchase And Lender Comments  null",joborder,
									"Then I should  see under Lender Provided Information section " +
									"Loan Purpose: Refinance	" +
									"Estimated Value: $100,000" +
									"Lender Comments:" +
									"No text Area below Lender Comments" +
									"Also no box around the fields",
									"Loan Purpose: REFINANCE and Lender Comment is displayed All Field are properly displayed and Contract Date is NOT display", true);			
						}else{
							ATUReports.add("As a "+productType+" user I would like to  the Verify data page under the lender provided information. " +
									"IF Loan Purpose = Purchase And Lender Comments  null",joborder,
									"Then I should  see under Lender Provided Information section " +
									"Loan Purpose: Refinance	" +
									"Estimated Value: $100,000" +
									"Lender Comments:" +
									"No text Area below Lender Comments" +
									"Also no box around the fields",
									"FAILED:Loan Purpose: REFINANCE and Lender Comment is null All Field are properly displayed and Contract Date is display", true);	
						}
				}else{
					ATUReports.add("As a "+productType+" user I would like to  the Verify data page under the lender provided information. " +
							"IF Loan Purpose = Purchase And Lender Comments  null",joborder,
							"Then I should  see under Lender Provided Information section " +
							"Loan Purpose: Refinance	" +
							"Estimated Value: $100,000" +
							"Lender Comments:" +
							"No text Area below Lender Comments" +
							"Also no box around the fields",
							"FAILED:Loan Purpose: REFINANCE and Lender Comment is null, Value Label is Contract Value", true);	
				}	
			}else{
				if(contractVal.contains("Contract Value")){
					waitForElementPresent(xpath(EVRObjectReference.contractDate));
					isElementPresent(xpath(EVRObjectReference.contractDate));
					Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.contractDate)));
					
					String contractDay = getText(xpath(EVRObjectReference.contractDate));
					
					if(contractDay.contains("Contract Date")){
						ATUReports.add("As a "+productType+" user I would like to  the Verify data page under the lender provided information. " +
								"IF Loan Purpose = Purchase And Lender Comments  null",joborder,
								"Then I should  see under Lender Provided Information section " +
								"Loan Purpose: Purchase	" +
								"Contract Value: $100,000" +
								"Contract Date: 01-31-2013" +
								"Lender Comments:" +
								"No text Area below Lender Comments" +
								"Also no box around the fields",
								"Loan Purpose: PURCHASE and Lender Comment is null All Field are properly displayed and Contract Date is display", true);			
					}else{
						ATUReports.add("As a "+productType+" user I would like to  the Verify data page under the lender provided information. " +
								"IF Loan Purpose = Purchase And Lender Comments  null",joborder,
								"Then I should  see under Lender Provided Information section " +
								"Loan Purpose: Refinance	" +
								"Contract Value: $100,000" +
								"Contract Date: 01-31-2013" +
								"Lender Comments:" +
								"No text Area below Lender Comments" +
								"Also no box around the fields",
								"FAILED:Loan Purpose: REFINANCE and Lender Comment is null All Field are properly displayed and Contract Date is NOT display", true);	
					}
				}else{
					ATUReports.add("As a "+productType+" user I would like to  the Verify data page under the lender provided information. " +
							"IF Loan Purpose = Purchase And Lender Comments  null",joborder,
							"Then I should  see under Lender Provided Information section " +
							"Loan Purpose: Purchase	" +
							"Contract Value: $100,000" +
							"Contract Date: 01-31-2013" +
							"Lender Comments:" +
							"No text Area below Lender Comments" +
							"Also no box around the fields",
							"FAILED:Loan Purpose: REFINANCE and Lender Comment is null, Contract Date is not Visible", true);	
					
				}
			}
			
		} catch (AssertionError e) {
			ATUReports.add("As a "+productType+" user I would like to  the Verify data page under the lender provided information. " +
					"IF Loan Purpose = Purchase And Lender Comments  null",joborder,
					"Then I should  see under Lender Provided Information section " +
					"Loan Purpose: Purchase	" +
					"Contract Value: $100,000" +
					"Contract Date: 01-31-2013" +
					"Lender Comments:" +
					"No text Area below Lender Comments" +
					"Also no box around the fields",
					"Some of Fields in Lender Provided information Area was not found", true);	
		}
	}
	
	public void checkVerifyDataPropertyInformationOnTop()throws Exception{
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.propertyInformatonOnTop));
			isElementPresent(xpath(EVRObjectReference.propertyInfoHeaderAU));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyInformatonOnTop)));
			
			String propertyInfo = getText(xpath(EVRObjectReference.propertyInformatonOnTop));
		
			if(!propertyInfo.equalsIgnoreCase("")){
				ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
						"As an EVR AUS/NAB user I want to see Property Information on the top of Verify Data Page that included Property Photo and Property Attributes",
						"Property Photo and Property Attributes are visible in the Page,Property Attributes are "+propertyInfo+"", true);			
			}else{
				ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
						"As an EVR AUS/NAB user I want to see Property Information on the top of Verify Data Page that included Property Photo and Property Attributes",
						"Property Photo and Property Attributes are NOT visible in the Page", true);			
			}
			
		} catch (AssertionError e) {
			ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
					"As an EVR AUS/NAB user I want to see Property Information on the top of Verify Data Page that included Property Photo and Property Attributes",
					"Property Photo and Property Attributes are NOT visible in the Page", true);			
				
		}
	}
	
	public void checkVerifyDataPhotoLink()throws Exception{
		
		try {			
			waitForElementPresent(xpath(EVRObjectReference.propertyImageryonSide));
			isElementPresent(xpath(EVRObjectReference.propertyImageryonSide));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyImageryonSide)));
			
			String photoLink = getText(xpath(EVRObjectReference.propertyImageryonSide));
		
			if(photoLink.equalsIgnoreCase("")){
				ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
						"As an EVR AUS/NAB user Property Photo Link should not visible on the right side side of the page under",
						"On the right side of the page Property Photo Link is not visible in the Page", true);			
			}else{
				ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
						"As an EVR AUS/NAB user Property Photo Link should not visible on the right side side of the page under",
						"On the right side of the page Property Photo Link is still visible in the Page", true);		
			}
			
		} catch (AssertionError e) {
				ATUReports.add("Given I created a NAB order And I access EVR And I navigate to Verify Data page ",joborder,
					"As an EVR AUS/NAB user Property Photo Link should not visible on the right side side of the page under",
					"On the right side of the page Property Photo Link is still visible in the Page", true);					
				
		}
	}
	
	
	
	public void checkAdditionalInformationList()throws Exception{
		String additionalInfo="";
		String salesInfo ="";
		Boolean landUsehasValue = false;
		try {
			waitForElementPresent(xpath(EVRObjectReference.additionalInformation));
			isElementPresent(xpath(EVRObjectReference.additionalInformation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.additionalInformation)));
			List<WebElement> additinalInformationList = driver.findElements(By.xpath(EVRObjectReference.additionalInformation));
			Boolean addInfoValhasValue = false;
			
			for (WebElement element: additinalInformationList) {
				additionalInfo = element.getText();
			       if((additionalInfo.contains("Additional Information") )){
			    	   addInfoValhasValue = true;
			    	   break;
			       }else{
			    	   addInfoValhasValue = false;
			       }
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.landUseAfterZoning));
				isElementPresent(xpath(EVRObjectReference.landUseAfterZoning));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.landUseAfterZoning)));
				List<WebElement> landUseList = driver.findElements(By.xpath(EVRObjectReference.landUseAfterZoning));
				
				for (WebElement element: landUseList) {
					salesInfo = element.getText();
				       if((salesInfo.contains("Land Use 1") )){
				    	   landUsehasValue = true;
				    	   break;
				       }else{
				    	   landUsehasValue = false;
				       }
				}
			} catch (AssertionError e) {
				landUsehasValue = false;
			}
			
			
			checkifNABorAU();
			if(isCheckifAU()){
					if(addInfoValhasValue && !landUsehasValue){
						ATUReports.add("As an EVR AUS/NAB user on  PROPERTY INFORMATION  Additional Information title for list, with the bullet  " +
								"points being those that currently exist in the property information modal as property features is displayed" +
								" For EVR AUS: " +
								"Do not display Land Use 1 " +
								"Do not display Land Use 2" +
								"Site Value" +
								"Date SV" +
								"Owner Code" +
								"Fee Code",joborder,
								"When I redirect to PROPERTY INFORMATION section And I should see Under Ownership field,Additional Information should be displayed.",
								"Under Ownership field Additional Information was displayed and Under Zoning Land Use are not Displayed", true);		
					}else{
						ATUReports.add("As an EVR AUS/NAB user on  PROPERTY INFORMATION  Additional Information title for list, with the bullet  " +
								"points being those that currently exist in the property information modal as property features is displayed" +
								" For EVR AUS: " +
								"Do not display Land Use 1 " +
								"Do not display Land Use 2" +
								"Site Value" +
								"Date SV" +
								"Owner Code" +
								"Fee Code",joborder,
								"When I redirect to PROPERTY INFORMATION section And I should see Under Ownership field,Additional Information should be displayed.",
								"FAILED:Under Ownership field Additional Information was Not displayed or Under Zoning Land Use are Displayed", true);		
					}	
			}else{
				if(addInfoValhasValue && landUsehasValue){
					ATUReports.add("As an EVR AUS/NAB user on  PROPERTY INFORMATION  Additional Information title for list, with the bullet  " +
							"points being those that currently exist in the property information modal as property features is displayed" +
							" For EVR AUS: " +
							"Do not display Land Use 1 " +
							"Do not display Land Use 2" +
							"Site Value" +
							"Date SV" +
							"Owner Code" +
							"Fee Code",joborder,
							"When I redirect to PROPERTY INFORMATION section And I should see Under Ownership field,Additional Information should be displayed.",
							"Under Ownership field Additional Information was displayed and Under Zoning Land Use are  Displayed", true);	
				}else{
					ATUReports.add("As an EVR AUS/NAB user on  PROPERTY INFORMATION  Additional Information title for list, with the bullet  " +
							"points being those that currently exist in the property information modal as property features is displayed" +
							" For EVR AUS: " +
							"Do not display Land Use 1 " +
							"Do not display Land Use 2" +
							"Site Value" +
							"Date SV" +
							"Owner Code" +
							"Fee Code",joborder,
							"When I redirect to PROPERTY INFORMATION section And I should see Under Ownership field,Additional Information should be displayed.",
							"FAILED:Under Ownership field Additional Information was displayed and Under Zoning Land Use are not Displayed", true);	
				}
				
			}
		} catch (AssertionError e) {
			ATUReports.add("As an EVR AUS/NAB user on  PROPERTY INFORMATION  Additional Information title for list, with the bullet  " +
					"points being those that currently exist in the property information modal as property features is displayed" +
					" For EVR AUS: " +
					"Do not display Land Use 1 " +
					"Do not display Land Use 2" +
					"Site Value" +
					"Date SV" +
					"Owner Code" +
					"Fee Code",joborder,
					"When I redirect to PROPERTY INFORMATION section And I should see Under Ownership field,Additional Information should be displayed.",
					"FAILED: NO ELEMENT WAS FOUND", true);	
		}
	}
	
	
	public void checkifNABorAU()throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.overview));
			isElementPresent(xpath(EVRObjectReference.overview));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.overview)));
			Boolean overview = isElementVisible(xpath(EVRObjectReference.overview));
			
			if(overview){
				setCheckifAU(true);
			}else{
				setCheckifAU(false);
			}
				
		} catch (AssertionError e) {
		
		}
	}
	
	public void showCustomerCall()  throws Exception{	
		try {
			waitForElementPresent(xpath(EVRObjectReference.customerCall));
			click(xpath(EVRObjectReference.customerCall));
			waitForElementPresent(xpath(EVRObjectReference.customerCalldiv));
			//logClick(EVRObjectReference.customerCall);
			Thread.sleep(1000);
			//logClick("Customer Call");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Customer Call");
		}
	}
	
	public void showDriveBy() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.driveBy));
			click(xpath(EVRObjectReference.driveBy));
			waitForElementPresent(xpath(EVRObjectReference.driveBydiv));
			//logClick("Drive By");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Drive By");
		}
	}
	
	public void showShortForm() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.shortForm));
			click(xpath(EVRObjectReference.shortForm));
			waitForElementPresent(xpath(EVRObjectReference.shortForm));	
			//logClick("Short Form");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Short Form");
		}
	}
	
	public void showCancellation() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.cancellation));
			click(xpath(EVRObjectReference.cancellation));
			waitForElementPresent(xpath(EVRObjectReference.cancellationdiv));	
			//ogClick("Cancellation");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Cancellation");
		}
	}
	
	public void startAssessment() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.startAssesment));
			click(xpath(EVRObjectReference.startAssesment));
			Thread.sleep(2000);
			//logClick("Start Assessment");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Start Assessment");
		}	
	}
	
	public void checkVerifyPageAUS() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.customerInformation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.customerInformation)));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(EVRObjectReference.lenderInformation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lenderInformation)));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(EVRObjectReference.titleDetails));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.titleDetails)));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(EVRObjectReference.propertySummary));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertySummary)));
			Thread.sleep(2000);
			log("Check Verify Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element on Verify Data Page");
		}
		
		
	}
	
	public void showPropertyInfoModal() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.propertyInformation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyInformation)));
			click(xpath(EVRObjectReference.propertyInformation));
			waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			
			closedmboxContentModal();
			//logClick("Property Informatin Modal");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Property Information Modal");
		}
	}
	
	public void scroll(int scrollNo)  throws InterruptedException, IOException {
		
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,"+scrollNo+")", ""); //y value '800' can be altered
			Thread.sleep(3000);
			log("Scroll at "+scrollNo+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
			   
	}
	
	public void backtoOriginalTab() throws Exception{
		
		//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		//Perform the click operation that opens new window

		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window

		//Close the new window, if that window no more required
		driver.close();

		//Switch back to original browser (first window)

		driver.switchTo().window(winHandleBefore);

		//continue with original browser (first window)
	}
	
	public void showinTheMarketModal() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.onTheMarket));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.onTheMarket)));
			click(xpath(EVRObjectReference.onTheMarket));
			waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			//logClick("In the Market");
			closedmboxContentModal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element In the Market Modal");
		}
	}
	
	public void showpropertyImageryModal() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.propertyImagery));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyImagery)));
			click(xpath(EVRObjectReference.propertyImagery));
			waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			//logClick("Property Imagery Modal");
					
			waitForElementPresent(xpath(EVRObjectReference.sitePhotoOnIM));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.sitePhotoOnIM)));
			Thread.sleep(1000);
			
			waitForElementPresent(xpath(EVRObjectReference.googleMapOnIM));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.googleMapOnIM)));
			click(xpath(EVRObjectReference.googleMapOnIM));
			//logClick("Google Map");
			Thread.sleep(1000);
			
			waitForElementPresent(xpath(EVRObjectReference.galleryOnIM));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.galleryOnIM)));
			click(xpath(EVRObjectReference.galleryOnIM));
			//logClick("Gallery");
			Thread.sleep(3000);
			
			closedmboxContentModal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element inside the Modal PropertyImagery");
		}
		
		
	}
	
	public void closedmboxContentModal() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.closeModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.closeModal)));
			Thread.sleep(3000);
			click(xpath(EVRObjectReference.closeModal));
			//logClick("Modal Close");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element X in Modal Box");
		}
	}
	
	public void showAerialPhoto() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.aerialPhoto));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.aerialPhoto)));
			click(xpath(EVRObjectReference.aerialPhoto));
			waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			//logClick("Aerial Photo");
			closedmboxContentModal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Aerial Photo");
		}
	}
	
	public void showAerialPhotoLong() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.aerialPhoto));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.aerialPhoto)));
			click(xpath(EVRObjectReference.aerialPhoto));
			waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			//logClick("Aerial Photo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Aerial Photo");
		}
		
		
	}
	
	public void pagination(int pageNo) throws InterruptedException, IOException{
		
		try {
			String xpath = "(//*[@class='pagination'])["+pageNo+"]";
			
			waitForElementPresent(xpath(xpath));
			Assert.assertTrue(isElementPresent(xpath(xpath)));
			click(xpath(xpath));
			//logClick("Page "+pageNo+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element pagination");
		}
		
	}
	
	public void pagination(String prev_first_last_next) throws InterruptedException, IOException{
		String xpath ="";
		
		try {
			if(prev_first_last_next =="previous"){
				xpath = "//*[@id='pg_prev']";
			}if(prev_first_last_next =="first"){
				xpath = "//*[@id='pg_first']";
			}if(prev_first_last_next =="last"){
				xpath = "//*[@id='pg_last']";
			}if(prev_first_last_next =="next"){
				xpath = "//*[@id='pg_next']";
			}
			
			waitForElementPresent(xpath(xpath));
			Assert.assertTrue(isElementPresent(xpath(xpath)));
			click(xpath(xpath));
			//ogClick(xpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Previous/Next/First/Last");
		}
		
	}
	
	
	public void showTopoMap() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.topoMap));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.topoMap)));
			click(xpath(EVRObjectReference.topoMap));
			waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			//logClick("Topo Map");
			closedmboxContentModal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Topo Map");
		}
	}
	
	public void saveChangesYes() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.yesButtonSave));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.yesButtonSave)));
			click(xpath(EVRObjectReference.yesButtonSave));
			
			//logClick("Yes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Yes");
		}
	}
	
	public void saveChangesNo() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.noButtonSave));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.noButtonSave)));
			click(xpath(EVRObjectReference.noButtonSave));
			
			//logClick("No");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element No");
		}
	}
	
	
	public void showStreetMap() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.streetMap));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.streetMap)));
			click(xpath(EVRObjectReference.streetMap));
			waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			//logClick("Street Map");
			closedmboxContentModal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Street Map");
		}
	}
	
	public void showStreetView() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.streetViewAu));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.streetViewAu)));
			click(xpath(EVRObjectReference.streetViewAu));
			
			//logClick("Street View");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Street View");
		}
	}
	
	public void verifyDataSaveContinue() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.verifyDataSaveContinue));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.verifyDataSaveContinue)));
			click(xpath(EVRObjectReference.verifyDataSaveContinue));
			
//			waitForElementPresent(xpath(searchLabel));
//			Assert.assertTrue(isElementPresent(xpath(searchLabel)));
			Thread.sleep(1000);
			//logClick("Save and Continue");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Save and Continue");
		}
		
	}
	
	
	
	public void gotoSearchByAddress() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchByAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchByAddress)));
			click(xpath(EVRObjectReference.searchByAddress));
			//logClick("Search by Address");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Search by Address");
		}
		
	}
	
	public void gotoSearchByRadius() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchByRadius));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchByRadius)));
			click(xpath(EVRObjectReference.searchByRadius));
			//logClick("Search By Radius");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable ot locate element Search by Radius");
		}
		
	}
	
	public void performRadiusSearch() throws Exception{
	
		selectLastSaleDate(EVRObjectReference.dropDownlastSaleDateAu,1);
//		enterCapitalValues(input[10],input[11]);
//		enterFloorAreaValues(input[12],input[13]);
//		selectBuildingAge(buildingAgeFrom,3,buildingAgeTo,5);
		selectRadius(EVRObjectReference.dropDownRadiusAu,5);
		selectBedrooms(1);
		selectBedrooms(2);
		selectBathrooms(3);
		selectCarSpace(2);
		selectPropertyType(2);
		selectSaleType();
		checkTargetSuburb();
		enterLandSize(input[14],input[15]);
		enterLastSalePrice(input[16],input[17]);
//	
	}
	
	public void checkTargetSuburb()throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.targetSurburb));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.targetSurburb)));
			click(xpath(EVRObjectReference.targetSurburb));
			
			//logClick("Target Suburb");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element target surburb");
		}
	}
	
	public void searchButtonRadius() throws Exception{
	
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchButtonRadius));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchButtonRadius)));
			click(xpath(EVRObjectReference.searchButtonRadius));
			
			waitForElementPresent(xpath(EVRObjectReference.propertyPhotoAU));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyPhotoAU)));
			//logClick("Search");
			Thread.sleep(4000);
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.refinedSearchResultModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.refinedSearchResultModal)));
				click(xpath(EVRObjectReference.refinedSearchResultModal));
				
			} catch (AssertionError e) {
				
			}
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Search");
		}
		
	}
	
	public void clickSearchRP() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchButtonRadius));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchButtonRadius)));
			click(xpath(EVRObjectReference.searchButtonRadius));
			System.out.println("Click Searh RP Button");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void showDevelopmentPermits() throws Exception{
		
			try {
				waitForElementPresent(xpath(EVRObjectReference.devPermits));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.devPermits)));
				click(xpath(EVRObjectReference.devPermits));
				waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
				
				closedmboxContentModal();
				pass("Succesfully click Development Permits");
			} catch (AssertionError e) {
				fail("Unable to locate element Development Permits");
			}
	
	}
	
	
	
	public void addRemoveProperty(int propertyNo) throws InterruptedException, IOException{
		
		
        try {
			int prono = propertyNo;
			String xPath = "(//*[@class='button addRemoveProperty'])["+prono+"]";
			
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
			
			Thread.sleep(4000);
			//logClick("Add/Remove Property");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Add/Remove Property");
		}
		
	}
	
	public void saveContinueAddProperty() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.saveAndContinueSE));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saveAndContinueSE)));
			click(xpath(EVRObjectReference.saveAndContinueSE));
			waitForElementPresent(xpath(EVRObjectReference.riskAnalysisListAUS));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.riskAnalysisListAUS)));
			
			//logClick("Save Continue Add Property");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Save Continue Add property");
		}
	}
	
	public void saveContinueRiskAnalysis() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.saveContinueRAAus));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saveContinueRAAus)));
			click(xpath(EVRObjectReference.saveContinueRAAus));
			waitForElementPresent(xpath(EVRObjectReference.propertyPhotoAu));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyPhotoAu)));
			
			//logClick("Save Continue");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Save and Continue Risk Analysis");
		}
	}
	
	public void checkOptionOnRiskAnalysis(String input,int checkboxNo) throws InterruptedException, IOException{	
	
		try {
			String checkbox = "(//*[@type='checkbox'])["+checkboxNo+"]";
			String inputText ="(//*[@type='text'])["+checkboxNo+"]";
			
			waitForElementPresent(xpath(checkbox));
			Assert.assertTrue(isElementPresent(xpath(checkbox)));

			waitForElementPresent(xpath(inputText));
			Assert.assertTrue(isElementPresent(xpath(inputText)));
			
			
			click(xpath(checkbox));
			//error when using variable inputText 
			type(xpath("(//*[@type='text'])["+checkboxNo+"]"),input);
		//	logClick("Checkbox "+checkbox+"");
			//logInput(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element checkbox Risk Analysis");
		}
	}
	
	public void chooseRadioOnPropertyRiskRating(int rowNo,int colNo) throws InterruptedException, IOException{	
		
		try {
			colNo = colNo + 1;
			String radioButton ="";
			
			
			if(rowNo == 1){
				 radioButton = "(//*[@id='checkLocations'])["+colNo+"]"; 
			}else if(rowNo == 2){
				 radioButton = "(//*[@id='checkLand'])["+colNo+"]";
			}else if(rowNo == 3){
				 radioButton = "(//*[@id='checkEnvironmental'])["+colNo+"]";
			}else if(rowNo == 4){
				 radioButton = "(//*[@id='checkImprovements'])["+colNo+"]";
			}else{
				 radioButton = "(//*[@id='checkLocations'])["+colNo+"]";
			}
			
			waitForElementPresent(xpath(radioButton));
			Assert.assertTrue(isElementPresent(xpath(radioButton)));

			click(xpath(radioButton));
			//logClick("RadioButton "+colNo+"");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element");
		}
		
	}
	
	
	public void chooseRadioOnEscalation(int rowNo) throws InterruptedException, IOException{	
		
		try {
			String radioButton ="";
			
			radioButton = "//*[@id='escalation"+rowNo+"']";
			
			waitForElementPresent(xpath(radioButton));
			Assert.assertTrue(isElementPresent(xpath(radioButton)));

			click(xpath(radioButton));
			//logClick(radioButton);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Radio on Escallation");
		}
		
	}
	
	public void chooseRadioOnCancellation(int rowNo) throws InterruptedException, IOException{	
		
		try {
			String radioButton ="";
			
			radioButton = "//*[@id='cancellation"+rowNo+"']";
			
			waitForElementPresent(xpath(radioButton));
			Assert.assertTrue(isElementPresent(xpath(radioButton)));

			click(xpath(radioButton));
			//logClick(radioButton);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Radion on Cancellation");
		}
		
	}

	public void cancelEscallation() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.cancelButton));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.cancelButton)));
			click(xpath(EVRObjectReference.cancelButton));
			//logClick("Cancel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Cancel on Escallation");
		}
	
	}

	public void cancelCancellation() throws Exception{
		
			try {
				waitForElementPresent(xpath(EVRObjectReference.cancelButtonOnCancellation));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.cancelButtonOnCancellation)));
				click(xpath(EVRObjectReference.cancelButtonOnCancellation));
				//logClick(EVRObjectReference.cancelButtonOnCancellation);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate Element Cancel on Cancellation");
			}
		
	
	}
	
	public void escalate() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.escalateButton));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.escalateButton)));
			click(xpath(EVRObjectReference.escalateButton));
			//logClick("Escalate");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Escalate");
		}
	
	}
	
	public void enterAddressInSearchbyAddressTab(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.singleLineAddressInSearchbyAddress));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.singleLineAddressInSearchbyAddress)));
			type(xpath(EVRObjectReference.singleLineAddressInSearchbyAddress),input);
			
			//logInput(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Single Line Address");
		}
	}
	
	public void enterCommentsOnEscallation(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.commentBox));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentBox)));
			type(xpath(EVRObjectReference.commentBox),input);
			
			//logInput(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Comment Box On Escallation");
		}
	}
	
	public void enterCommentsAdditionalAttributes(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.spOtherText));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.spOtherText)));
			type(xpath(EVRObjectReference.spOtherText),input);
			//logInput(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Comment Box Additional Attributes");
		}
	}
	
	public void enterCommentsOnCancellation(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.cancellationComment));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.cancellationComment)));
			type(xpath(EVRObjectReference.cancellationComment),input);
			//logInput(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Comment on Cancellation");
		}
	}
	
	public void clickYesNoOnEscalation(boolean option) throws InterruptedException, IOException{
		
		try {
			if(option){
				waitForElementPresent(xpath(EVRObjectReference.yesButton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.yesButton)));
				click(xpath(EVRObjectReference.yesButton));
				//logClick("YES");
			}else{
				waitForElementPresent(xpath(EVRObjectReference.noButton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.noButton)));
				click(xpath(EVRObjectReference.noButton));
				//logClick("NO");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element YES or NO on Escallation");
		}
		
	}
	
	public void chooseReasonOnEscalation(int rowNo) throws InterruptedException, IOException{
		
		try {
			rowNo = rowNo + 8;
			String rowno = "(//*[@class='reason'])["+rowNo+"]";
			
			if(rowNo >= 4 && rowNo <= 8){
			waitForElementPresent(xpath(rowno));
			Assert.assertTrue(isElementPresent(xpath(rowno)));	
			}else{
			rowno = "(//*[@class='reason'])[9]";
			waitForElementPresent(xpath(rowno));
			Assert.assertTrue(isElementPresent(xpath(rowno)));	
			}
			click(xpath(rowno));
			//logClick(rowno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Reason Escallation");
		}	
	}
	
	public void chooseRadioOnMarketRiskRating(int rowNo,int colNo) throws InterruptedException, IOException{	
		
		try {
			colNo = colNo + 1;
			String radioButton ="";
			
			
			if(rowNo == 1){
				 radioButton = "(//*[@id='checkReduced'])["+colNo+"]"; 
			}else if(rowNo == 2){
				 radioButton = "(//*[@id='checkMarketVolatility'])["+colNo+"]";
			}else if(rowNo == 3){
				 radioButton = "(//*[@id='checkLocal'])["+colNo+"]";
			}else if(rowNo == 4){
				 radioButton = "(//*[@id='checkMarketSegment'])["+colNo+"]";
			}else{
				 radioButton = "(//*[@id='checkReduced'])["+colNo+"]";
			}
			
			waitForElementPresent(xpath(radioButton));
			Assert.assertTrue(isElementPresent(xpath(radioButton)));

			click(xpath(radioButton));
			//logClick(radioButton);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Radio on Market Risk Rating");
		}
		
	}
	
	public void inputCommentOnPropertyRiskRating(String input, int rowNo) throws InterruptedException, IOException{	
		
	
		try {
			if(rowNo == 1){
				waitForElementPresent(xpath(EVRObjectReference.commentLocaton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentLocaton)));
				type(xpath(EVRObjectReference.commentLocaton),input);
				
			}else if(rowNo == 2){
				waitForElementPresent(xpath(EVRObjectReference.commentLand));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentLand)));
				type(xpath(EVRObjectReference.commentLand),input);
				
			}else if(rowNo == 3){
				waitForElementPresent(xpath(EVRObjectReference.commentEnvironmental));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentEnvironmental)));
				type(xpath(EVRObjectReference.commentEnvironmental),input);
				
			}else if(rowNo == 4){
				waitForElementPresent(xpath(EVRObjectReference.commentImprovements));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentImprovements)));
				type(xpath(EVRObjectReference.commentImprovements),input);
				
			}else{
				waitForElementPresent(xpath(EVRObjectReference.commentLocaton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentLocaton)));
				type(xpath(EVRObjectReference.commentLocaton),input);
			}
			
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Comment Box on Property Risk Ratings");
		}
		
	}
	
	
	public void inputCommentOnMarketRiskRating(String input, int rowNo) throws InterruptedException, IOException{	
		
		
		try {
			if(rowNo == 1){
				waitForElementPresent(xpath(EVRObjectReference.commentReduced));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentReduced)));
				type(xpath(EVRObjectReference.commentReduced),input);
				
			}else if(rowNo == 2){
				waitForElementPresent(xpath(EVRObjectReference.commentMarketVolatility));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentMarketVolatility)));
				type(xpath(EVRObjectReference.commentMarketVolatility),input);
				
			}else if(rowNo == 3){
				waitForElementPresent(xpath(EVRObjectReference.commentLocal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentLocal)));
				type(xpath(EVRObjectReference.commentLocal),input);
				
			}else if(rowNo == 4){
				waitForElementPresent(xpath(EVRObjectReference.commentMarketSegment));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentMarketSegment)));
				type(xpath(EVRObjectReference.commentMarketSegment),input);
				
			}else{
				waitForElementPresent(xpath(EVRObjectReference.commentReduced));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentReduced)));
				type(xpath(EVRObjectReference.commentReduced),input);
			}
			
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Comment Box on Market Risk Rating");
		}
		
	}
	
	public void viewSalesEvidenceList() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.salesEvidenceListAU));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.salesEvidenceListAU)));
			click(xpath(EVRObjectReference.salesEvidenceListAU));
			//logClick("Sales Evidence List");
			
//			waitForElementPresent(xpath(returnSearchResultAU));
//			Assert.assertTrue(isElementPresent(xpath(returnSearchResultAU)));
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Sales Evidence List");
		}
		
	}

	public void submitAssessment() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.submitAssessment));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.submitAssessment)));
			click(xpath(EVRObjectReference.submitAssessment));
			//logClick("Submit Assesment");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Submit Assessments");
		}
		
	}
	
	public void escallationDriveBy() throws Exception{
		gotoEscalateCancel();//Test Case No. 47
		chooseRadioOnEscalation(39);//Test Case No. 47
		enterCommentsOnEscallation(input[9]);//Test Case No. 47
		clickYesNoOnEscalation(true);//Test Case No. 47
		checkChangesOnValexAU();//Test Case No. 47
	}
	
	public void checkChangesOnValexAU() throws Exception{
		
		try {
			driver.navigate().to("https://vxtest.valex.com.au/");
			pass("Navigate to https://vxtest.valex.com.au/");
			Thread.sleep(4000);
			
			
			waitForElementPresent(xpath(EVRObjectReference.usernameValexNz));
			type(xpath(EVRObjectReference.usernameValexNz), input[20]);
			//logInput(input[20]);
			
			waitForElementPresent(xpath(EVRObjectReference.passwordValexNz));
			type(xpath(EVRObjectReference.passwordValexNz), input[25]);
			

			waitForElementPresent(xpath(EVRObjectReference.loginButtonValNz));
			click(xpath(EVRObjectReference.loginButtonValNz));
			//logClick("Login Button on Valex Nz");
			
			
			waitForElementPresent(xpath(EVRObjectReference.inputJobIdNz));
			type(xpath(EVRObjectReference.inputJobIdNz), input[26]);
			//logInput(input[26]);
			
			waitForElementPresent(xpath(EVRObjectReference.submitJodIDAu));
			click(xpath(EVRObjectReference.submitJodIDAu));
			//logClick("Submit JobId");
			
			waitForElementPresent(xpath(EVRObjectReference.serviceTypelabel));
			log("Checking for Changes");
			Thread.sleep(4000);
			
			backtoOriginalTab();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Cant move to https://nztest.valex.com.au/");
		}
		
	}
	
	public void rateSalesEvidenceList(int rateNo) throws InterruptedException, IOException{
		
		try {
			String rateAU = "(//*[@class='rate content_text'])["+rateNo+"]";
			
			waitForElementPresent(xpath(rateAU));
			Assert.assertTrue(isElementPresent(xpath(rateAU)));
			click(xpath(rateAU));
			//logClick(rateAU);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Rate on Sales Evidence List");
		}
			
	}
	
	public void enterCommentinSEList(String inputString, int commentNo) throws InterruptedException{
		
		String commentNZ = "(//*[@class='comments'])["+commentNo+"]";
		
		waitForElementPresent(xpath(commentNZ));
		try{
			Assert.assertTrue(isElementPresent(xpath(commentNZ)));
			//error when using variable commentNZ
			type(xpath("(//*[@class='comments'])["+commentNo+"]"),inputString);
			//logInput(inputString);
			
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Unable to locate Element Comment Box in Sales List");
		}
		
	}
	
	public void inputAssessmentValue(String input) throws InterruptedException{
		
		waitForElementPresent(xpath(EVRObjectReference.assesmentValue));
		try{
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.assesmentValue)));
			//error when using variable commentNZ
			type(xpath(EVRObjectReference.assesmentValue),input);
			log("Enter Value in Assessment value "+input+"");
			Thread.sleep(1000);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Unable to locate Element Assessment Value");
		}
		
	}
	
	public void returnSearchResult() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.returnSearchResultAU));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.returnSearchResultAU)));
			Thread.sleep(1000);
			click(xpath(EVRObjectReference.returnSearchResultAU));
		//	logClick("Return Search Result");
			
//			waitForElementPresent(xpath(returnSearchResultAU));
//			Assert.assertTrue(isElementPresent(xpath(returnSearchResultAU)));
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Return to Search Result");
		}
		
	}
	
	//click the Photo Gallery on search Result NZ Sales EVidence
	public void showPhotoGallery(int rowNo) throws InterruptedException, IOException{
		
		try {
			if((rowNo%2)==0){
				 // even number
				 rowNo = rowNo + 1;
			}
				  
			String path = "(//*[@class='comparablePhotos evrButtonStyle'])["+rowNo+"]";
			
			waitForElementPresent(xpath(path));
			Assert.assertTrue(isElementPresent(xpath(path)));
			click(xpath(path));
			//logClick("Photo Gallery");
			
			waitForElementPresent(xpath(EVRObjectReference.mBoxSearchFilter));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mBoxSearchFilter)));
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Element Photo Gallery");
		}
		
	}
	
	public void enterCapitalValues (String inputFrom,String inputTo) throws InterruptedException, IOException {
	
		try {
			waitForElementPresent(xpath(EVRObjectReference.capitalValFrom));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.capitalValFrom)));
			waitForElementPresent(xpath(EVRObjectReference.capitalValTo));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.capitalValTo)));
			
			type(xpath(EVRObjectReference.capitalValFrom), inputFrom);
			type(xpath(EVRObjectReference.capitalValTo), inputTo);
			//logInput(inputFrom);
			//logInput(inputTo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Capital Values");
		}
	}
	
	public void enterFloorAreaValues (String inputFrom,String inputTo) throws InterruptedException, IOException {
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.floorAreaFrom));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.floorAreaFrom)));
			waitForElementPresent(xpath(EVRObjectReference.floorAreaTo));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.floorAreaTo)));
			
			type(xpath(EVRObjectReference.floorAreaFrom), inputFrom);
			type(xpath(EVRObjectReference.floorAreaTo), inputTo);
			//logInput(inputFrom);
			//logInput(inputTo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Floor Area Values");
			
		}
	}
	
	public void enterLandSize (String inputMin,String inputMax) throws InterruptedException, IOException {
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.dropDownLandSizeMin));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.dropDownLandSizeMin)));
			waitForElementPresent(xpath(EVRObjectReference.dropDownLandSizeMax));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.dropDownLandSizeMax)));
			
			type(xpath(EVRObjectReference.dropDownLandSizeMin), inputMin);
			type(xpath(EVRObjectReference.dropDownLandSizeMax), inputMax);
			//logInput(inputMin);
			//logInput(inputMax);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element LandSize");
		}
		
	}
	
	public void enterLastSalePrice (String inputMin,String inputMax) throws InterruptedException, IOException {
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.dropDownLastSalePriceMin));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.dropDownLastSalePriceMin)));
			waitForElementPresent(xpath(EVRObjectReference.dropDownLastSalePriceMax));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.dropDownLastSalePriceMax)));
			
			type(xpath(EVRObjectReference.dropDownLastSalePriceMin), inputMin);
			type(xpath(EVRObjectReference.dropDownLastSalePriceMax), inputMax);
			//logInput(inputMin);
			//logInput(inputMax);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element LastSale Price");
		}
	}
	
	public void selectLastSaleDate (String dropDown,int descCode) throws InterruptedException, IOException {	
			
	    	try {
				String dropdown = dropDown;
				String description = "";
				
				if(descCode == 1){
					description = "Select";
				}else if(descCode == 2){
					description ="Last 3 Months";
				}else if(descCode == 3){
					description ="Last 6 Months";
				}else if(descCode == 4){
					description = "Last 9 Months";
				}else if(descCode == 5){
					description ="Last 12 Months";
				}else if(descCode == 6){
					description =" Specify Date";
				}else{
					description ="Select";
				}
				
				waitForElementPresent(xpath(dropdown));
				Assert.assertTrue(isElementPresent(xpath(dropdown)));
				selectDropdownOption(xpath(dropdown),description);
				Thread.sleep(1000);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element select Last Sale Date");
			}
	}
	
	public void selectMonthDatePicker (int descCode) throws InterruptedException, IOException {	
		
    	try {
			String description = "";
			
			if(descCode == 1){
				description = "Jan";
			}else if(descCode == 2){
				description ="Feb";
			}else if(descCode == 3){
				description ="Mar";
			}else if(descCode == 4){
				description = "Apr";
			}else if(descCode == 5){
				description ="May";
			}else if(descCode == 6){
				description ="Jun";
			}else if(descCode == 7){
				description ="Jul";
			}else if(descCode == 8){
				description ="Aug";
			}else if(descCode == 9){
				description ="Sep";
			}else if(descCode == 10){
				description ="Oct";
			}else if(descCode == 11){
				description ="Nov";
			}else if(descCode == 12){
				description ="Dec";
			}
			
			
			waitForElementPresent(xpath(EVRObjectReference.monthDatePicker));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.monthDatePicker)));
			selectDropdownOption(xpath(EVRObjectReference.monthDatePicker),description);
			Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element select Last Sale Date");
		}
	}
	
	
public void selectYearDatePicker (String year) throws InterruptedException, IOException {	
		
    	try {
			waitForElementPresent(xpath(EVRObjectReference.yearDatePicker));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.yearDatePicker)));
			selectDropdownOption(xpath(EVRObjectReference.yearDatePicker),year);
			Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element select Last Sale Date");
		}
	}

	public void selectBuildingAge (String xPathFrom,int descCodeFrom,String xPathTo, int descCodeTo) throws InterruptedException, IOException {	
		
    	
    	try {
			String descriptionFrom = "";
			String descriptionTo ="";
			
			if(descCodeFrom == 1){
				descriptionFrom = "Select here..";
			}else if(descCodeFrom == 2){
				descriptionFrom ="Before 1880";
			}else if(descCodeFrom == 3){
				descriptionFrom ="Before 1920";
			}else if(descCodeFrom == 4){
				descriptionFrom = "1880-89";
			}else if(descCodeFrom == 5){
				descriptionFrom ="1890-99";
			}else if(descCodeFrom == 6){
				descriptionFrom ="1900-09";
			}else if(descCodeFrom == 7){
				descriptionFrom ="1910-19";
			}else if(descCodeFrom == 8){
				descriptionFrom ="1920-29";	
			}else if(descCodeFrom == 9){
				descriptionFrom ="1930-39";
			}else if(descCodeFrom == 10){
				descriptionFrom ="1940-49";
			}else if(descCodeFrom == 11){
				descriptionFrom ="1950-59";	
			}else if(descCodeFrom == 12){
				descriptionFrom ="1960-69";	
			}else if(descCodeFrom == 13){
				descriptionFrom ="1970-79";	
			}else if(descCodeFrom == 14){
				descriptionFrom ="1980-89";	
			}else if(descCodeFrom == 15){
				descriptionFrom ="1990-99";	
			}else if(descCodeFrom == 16){
				descriptionFrom ="2000-2009";	
			}else if(descCodeFrom == 17){
				descriptionFrom ="2010-2019";		
			}else{
				descriptionFrom ="Select here..";
			}
			
			
			if(descCodeTo == 1){
				descriptionTo = "Select here..";
			}else if(descCodeTo == 2){
				descriptionTo ="Before 1880";
			}else if(descCodeTo == 3){
				descriptionTo ="Before 1920";
			}else if(descCodeTo == 4){
				descriptionTo = "1880-89";
			}else if(descCodeTo == 5){
				descriptionTo ="1890-99";
			}else if(descCodeTo == 6){
				descriptionTo ="1900-09";
			}else if(descCodeTo == 7){
				descriptionTo ="1910-19";
			}else if(descCodeTo == 8){
				descriptionTo ="1920-29";	
			}else if(descCodeTo == 9){
				descriptionTo ="1930-39";
			}else if(descCodeTo == 10){
				descriptionTo ="1940-49";
			}else if(descCodeTo == 11){
				descriptionTo ="1950-59";	
			}else if(descCodeTo == 12){
				descriptionTo ="1960-69";	
			}else if(descCodeTo == 13){
				descriptionTo ="1970-79";	
			}else if(descCodeTo == 14){
				descriptionTo ="1980-89";	
			}else if(descCodeTo == 15){
				descriptionTo ="1990-99";	
			}else if(descCodeTo == 16){
				descriptionTo ="2000-2009";	
			}else if(descCodeTo == 17){
				descriptionTo ="2010-2019";		
			}else{
				descriptionTo ="Select here..";
			}
			waitForElementPresent(xpath(xPathFrom));
			Assert.assertTrue(isElementPresent(xpath(xPathFrom)));
			selectDropdownOption(xpath(xPathFrom),descriptionFrom);
			
			waitForElementPresent(xpath(xPathTo));
			Assert.assertTrue(isElementPresent(xpath(xPathTo)));
			selectDropdownOption(xpath(xPathTo),descriptionTo);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Building Age");
		}
	}
	
	public void selectRadius (String xPath,int descCode) throws InterruptedException, IOException {	
		
    	try {
			String dropdown = xPath;
			String description = "";
			
			if(descCode == 1){
				description = "0.5 km";
			}else if(descCode == 2){
				description ="1.0 km";
			}else if(descCode == 3){
				description ="1.5 km";
			}else if(descCode == 4){
				description = "2.0 km";
			}else if(descCode == 5){
				description ="2.5 km";
			}else if(descCode == 6){
				description ="3.0 km";
			}else if(descCode == 7){
				description ="3.5 km";
			}else if(descCode == 8){
				description ="4.0 km";
			}else if(descCode == 9){
				description ="4.5 km";
			}else if(descCode == 10){
				description ="5.0 km";
			}else if(descCode == 11){
				description ="25.0";
			}else if(descCode == 11){
				description ="50.0";
			}else if(descCode == 11){
				description ="100.0";	
			}else{
				description ="0.5";
			}
			
			waitForElementPresent(xpath(dropdown));
			Assert.assertTrue(isElementPresent(xpath(dropdown)));
			selectDropdownOption(xpath(dropdown),description);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Radius");
		}
	}
	
	public void sortByData (int descCode) throws InterruptedException, IOException {	
		
    	try {
			String description = "";
			
			if(descCode == 1){
				description = "Address";
			}else if(descCode == 2){
				description ="Sale Date";
			}else if(descCode == 3){
				description ="Sale Price";
			}else if(descCode == 4){
				description ="Distance";	
			}else{
				description ="Distance";
			}
			
			waitForElementPresent(xpath(EVRObjectReference.sortByData));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.sortByData)));
			selectDropdownOption(xpath(EVRObjectReference.sortByData),description);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Sort by Data");
		}
	}
	
	public void sortByPage (int descCode) throws InterruptedException, IOException {	
		
    	try {
			String description = "";
			
			if(descCode == 1){
				description = "10 per page";
			}else if(descCode == 2){
				description ="20 per page";
			}else if(descCode == 3){
				description ="30 per page";
			}else if(descCode == 4){
				description ="40 per page";	
			}else if(descCode == 5){
				description ="50 per page";	
			}else{
				description ="20 per page";
			}
			
			waitForElementPresent(xpath(EVRObjectReference.sortByPage));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.sortByPage)));
			selectDropdownOption(xpath(EVRObjectReference.sortByPage),description);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//fail("Unable to locate element Sort by Page");
		}
	}
	
	public void selectBedrooms(int checkNo) throws InterruptedException, IOException {	
		
		try {
			String path = "(//*[@id='bedRooms'])["+checkNo+"]";
			waitForElementPresent(xpath(path));
			Assert.assertTrue(isElementPresent(xpath(path)));
			
			click(xpath(path));
			//logClick("Bedrooms "+checkNo+"");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Bedroom");
		}
	}
	
	public void selectBathrooms(int checkNo) throws InterruptedException, IOException {	
		
		try {
			String path = "(//*[@id='bathRooms'])["+checkNo+"]";
			waitForElementPresent(xpath(path));
			Assert.assertTrue(isElementPresent(xpath(path)));
			
			click(xpath(path));
			//logClick("Bathrooms"+checkNo+"");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Bathroom");
		}
	}
	
	public void selectCarSpace(int checkNo) throws InterruptedException, IOException {	
		
		try {
			String path = "//*[@id='carSpaces"+checkNo+"']";
			waitForElementPresent(xpath(path));
			Assert.assertTrue(isElementPresent(xpath(path)));
			
			click(xpath(path));
			//ogClick(path);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Car Space");
		}
	}
	
	public void selectPropertyType(int checkNo) throws InterruptedException, IOException {	
		
		try {
			if(checkNo == 1){
				waitForElementPresent(xpath(EVRObjectReference.checkboxHouse));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.checkboxHouse)));
				click(xpath(EVRObjectReference.checkboxHouse));
				//logClick(checkboxHouse);
				
			}else if(checkNo == 2){
				waitForElementPresent(xpath(EVRObjectReference.checkboxUnits));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.checkboxUnits)));
				click(xpath(EVRObjectReference.checkboxUnits));
				//logClick(checkboxUnits);
				
			}else if(checkNo == 3){	
				waitForElementPresent(xpath(EVRObjectReference.checkboxVacantLand));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.checkboxVacantLand)));
				click(xpath(EVRObjectReference.checkboxVacantLand));
				//logClick(checkboxVacantLand);
				
			}else{
				waitForElementPresent(xpath(EVRObjectReference.checkboxHouse));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.checkboxHouse)));
				click(xpath(EVRObjectReference.checkboxHouse));
				//logClick(checkboxHouse);
			}
			
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Property Tyep");
		}
	}
	
	public void selectSaleType() throws Exception {	
		
			try {
				waitForElementPresent(xpath(EVRObjectReference.checkboxConfirmSale));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.checkboxConfirmSale)));
				click(xpath(EVRObjectReference.checkboxConfirmSale));
				//logClick("Sale Type");
  	
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Sale Type");
			}
	}
	
	
	public void checkType (int descCode) throws InterruptedException, IOException {
		try {
			String xPath ="";
			
			if(descCode == 1){
				xPath = "//*[@id='houses']";
			}else if(descCode == 2){
				xPath = "//*[@id='units']";
			}else if(descCode == 3){
				xPath = "//*[@id='land']";
			}else{
				xPath = "//*[@id='houses']";
			}
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Type");
		}
	}	
	    
	public void gotoSalesEvidence() throws Exception{

		try {
			waitForElementPresent(xpath(EVRObjectReference.salesEvidence));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.salesEvidence)));
			click(xpath(EVRObjectReference.salesEvidence));
			//logClick("Sales Evidence Tab");
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Sales Evidence Tab");
		}
	}
	
	public void resetFilters() throws Exception{
		
			try {
				waitForElementPresent(xpath(EVRObjectReference.resetRadiusFilter));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.resetRadiusFilter)));
				click(xpath(EVRObjectReference.resetRadiusFilter));
				//logClick("Reset Filter");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Reset Filters");
			}
	}
	 
	public void gotoVerifyData() throws Exception{
			
			try {
				Thread.sleep(4000);
				waitForElementPresent(xpath(EVRObjectReference.verifyData));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.verifyData)));
				click(xpath(EVRObjectReference.verifyData));
				System.out.println("Click Verify Data Tab");
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate element Verify Data Tab");
			}
	}
	 
	public void gotoOverview() throws Exception{
	
			try {
				waitForElementPresent(xpath(EVRObjectReference.overview));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.overview)));
				click(xpath(EVRObjectReference.overview));
				//logClick("Overview Tab");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Overview Tab");
			}
	}
	 
	public void gotoRiskAnalysis() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.riskAnalysis));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.riskAnalysis)));
				click(xpath(EVRObjectReference.riskAnalysis));
				//logClick("Risk Analysis Tab");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Risk Analysis");
			}
	}
	 
	public void gotoSubmission() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.submission));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.submission)));
				click(xpath(EVRObjectReference.submission));
				//logClick("Submission Tab");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Submission Tab");
			}
	}
	 
	public void gotoEscalateCancel() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.escalate));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.escalate)));
				click(xpath(EVRObjectReference.escalate));
				Thread.sleep(1000);
				//logClick("Escalate Cancel Tab");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Escalate Cancel Tab");
			}
	}
	
	public void checkAdditionalAttributes(int checkNo) throws InterruptedException, IOException{
		
		try {
			String path = "(//*[@type='checkbox'])["+checkNo+"]";
			
			waitForElementPresent(xpath(path));
			Assert.assertTrue(isElementPresent(xpath(path)));
			click(xpath(path));
			//logClick("Checkbox no."+checkNo+"");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element checkbox Additional Attributes");
		}
		
	}
	
	public void zoomINorOUtAerialPhoto(boolean zoomInOrOut) throws InterruptedException, IOException{
		
		try {
			if(zoomInOrOut){
				waitForElementPresent(xpath(EVRObjectReference.plusButton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.plusButton)));
				click(xpath(EVRObjectReference.plusButton));
				//logClick("ZoomIn");
			}else{
				waitForElementPresent(xpath(EVRObjectReference.minusButton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.minusButton)));
				click(xpath(EVRObjectReference.minusButton));
				//logClick("ZoomOut");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Plus or Minus");
		}
	}

public void clicksaleDefaultImage(String defaultPhoto) throws Exception{
		int defaultPhotoInt = Integer.parseInt(defaultPhoto);//3
		if(defaultPhotoInt == 1){
		}else{
			int muldefaultPhotoInt =  defaultPhotoInt + defaultPhotoInt;
			defaultPhotoInt = (muldefaultPhotoInt - 2) + defaultPhotoInt;		
		}
		
		String pathdefaultPhoto = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div/img)["+defaultPhotoInt+"]";
		               //                            /html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div/img
		try {
			waitForElementPresent(xpath(pathdefaultPhoto));
			Assert.assertTrue(isElementPresent(xpath(pathdefaultPhoto)));
			click(xpath(pathdefaultPhoto));
			//	logClick("Property Thumbnail");
				Thread.sleep(2000);
		//		waitForElementPresent(xpath(""));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Search Results' Property Thumbnail");
			}
}

public void clicksaleShortListDefaultImage() throws Exception{
					
			try {
					waitForElementPresent(xpath(EVRObjectReference.saleShortListDefaultImage));
					Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saleShortListDefaultImage)));
						click(xpath(EVRObjectReference.saleShortListDefaultImage));
					//	logClick("ShortList's Property Thumbnail");
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					fail("Unable to locate element ShorList's Property Thumbnail");
		
	}
			
			
}
}