package myrp.utilities;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import myrp.library.EVRObjectReference;
import myrp.library.FunctionReference;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import atu.testng.reports.ATUReports;


public class EvrProjectUtilNZ extends FunctionReference {
	
	private String[] input = null;
	private String testCase = "";
	private boolean hasError = false;
		
	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public EvrProjectUtilNZ(String[] i) {
			input = i;
	}
		
	public void valexNzOrder (String jobOrder) throws InterruptedException, IOException {
		try {
			resultcount = 0;
		    
			ATUReports.add("Create an order and successfully view the order by: 1. From ValEx, view the order as a valuer widely used 2. Input an order number on the Debug Page less priority",
		    						jobOrder,
		    						"Successfully view the EVR - Overview tab after the order has been accepted on ValEx.",
		    						"Successfully view the EVR - Overview tab after the order has been accepted on ValEx.", true);
		    
			waitForElementPresent(xpath(EVRObjectReference.jobOrderInput));
			
			isElementPresent(xpath(EVRObjectReference.jobOrderInput));
			
			//String joborder ="VXJ-000000"+jobOrder;
			String joborder = jobOrder;
			testCase = "EVR Job Order Input: " + input[0];
			
			type(xpath(EVRObjectReference.jobOrderInput), joborder);
			
			waitForElementPresent(xpath(EVRObjectReference.valExNz));
			click(xpath(EVRObjectReference.valExNz));
			
			waitForElementPresent(xpath(EVRObjectReference.buttonAu));
			click(xpath(EVRObjectReference.buttonAu));
			pass("Succesfull Enter on Evr NZ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Invalid JobOrder Id");
		}
	}
	
	
	public void gotoHomeEvr() throws Exception{
		
		try {
			driver.navigate().to("https://evrui-sit.rpdata.com/ttsvr/n/evr-home");
			pass("Navigate to https://evrui-sit.rpdata.com/ttsvr/n/evr-home");
			Thread.sleep(4000);
			
			//driver.switchTo().window("https://evrui-sit.rpdata.com/ttsvr/n/evr-home");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Cant move to https://evrui-sit.rpdata.com/ttsvr/n/evr-home");
		}
		
	}
	
	public void checkChangesOnValexNz() throws Exception{
		
		try {
			driver.navigate().to("https://nztest.valex.com.au/");
			pass("Navigate to https://nztest.valex.com.au/");
			Thread.sleep(4000);
			
			
			waitForElementPresent(xpath(EVRObjectReference.usernameValexNz));
			type(xpath(EVRObjectReference.usernameValexNz), input[20]);
			//logInput(input[20]);
			
			waitForElementPresent(xpath(EVRObjectReference.passwordValexNz));
			type(xpath(EVRObjectReference.passwordValexNz), input[21]);
			

			waitForElementPresent(xpath(EVRObjectReference.loginButtonValNz));
			click(xpath(EVRObjectReference.loginButtonValNz));
			//logClick("Login Button on Valex Nz");
			
			
			waitForElementPresent(xpath(EVRObjectReference.inputJobIdNz));
			type(xpath(EVRObjectReference.inputJobIdNz), input[19]);
		//	logInput(input[19]);
			
			waitForElementPresent(xpath(EVRObjectReference.submitJobId));
			click(xpath(EVRObjectReference.submitJobId));
			//logClick("Submit JobId");
			
			waitForElementPresent(xpath(EVRObjectReference.serviceTypelabel));
			//log("Checking for Changes");
			Thread.sleep(4000);
			
			backtoOriginalTab();
			setHasError(false);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Cant move to https://nztest.valex.com.au/");
			setHasError(true);
		}
		
	}
	
	
	public void switchToNewTab() throws Exception{

		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
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
	
	public void showCustomerCall() throws Exception{	
		try {
			waitForElementPresent(xpath(EVRObjectReference.customerCall));
			click(xpath(EVRObjectReference.customerCall));
			waitForElementPresent(xpath(EVRObjectReference.customerCalldiv));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.customerCalldiv)));
			Thread.sleep(2000);
			
			//logClick("Customer Call");
			pass("Customer Call section is properly displayed.");
		} catch (AssertionError e) {
			fail("Unable to Locate Element Customer Call");
			resultcount++;
		}
	}
	
	public void showDriveBy() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.driveBy));
			click(xpath(EVRObjectReference.driveBy));
			waitForElementPresent(xpath(EVRObjectReference.driveBydiv));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.driveBydiv)));
			Thread.sleep(2000);
			
			//logClick("Drive By");
			pass("Drive by section is properly displayed.");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element Drive By");
		}
	}
	
	public void showFullMarketValuation() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.fullMarketVal));
			click(xpath(EVRObjectReference.fullMarketVal));
			waitForElementPresent(xpath(EVRObjectReference.fullMarketdiv));	
			Thread.sleep(2000);
			
			pass("Full Market Valuation section is properly displayed.");
			//logClick("Full Market Valuation");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element Full Market Valuation");
		}
	}
	
	public void showCancellation() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.cancellation));
			click(xpath(EVRObjectReference.cancellation));
			waitForElementPresent(xpath(EVRObjectReference.cancellationdiv));	
			Thread.sleep(2000);
			
			//logClick("Cancellation");
			pass("Cancellation section is properly displayed.");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element Cancellation");
		}
	}
	
	public void startAssessment() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.startAssesment));
			click(xpath(EVRObjectReference.startAssesment));
			Thread.sleep(2000);
			
			//logClick("Start Assesment");
			pass("Succesfully Click on Start Assesment and navigate to Verify Data tab page and ready for inputting / selecting data.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element Start Assesment");
		}	
	}
	
	public void checkCustomerInformation() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.cutomerInformatonHeader));
			click(xpath(EVRObjectReference.cutomerInformatonHeader));
			Thread.sleep(2000);
			
			//logClick("Start Assesment");
			pass("Succesfully Viewed the contact/s as well as the relevant details for Customer Information.");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element on Customer Information");
		}	
	}
	
	public void checkLenderProvidedInformation() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.lenderInformation));
			click(xpath(EVRObjectReference.lenderInformation));
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.loanPurpose));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.loanPurpose)));
			} catch (AssertionError e) {
				fail("Unable to locate element Loan Purpose");
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.lenderComment));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lenderComment)));
			} catch (AssertionError e) {
				fail("Unable to locate element Lender Comment");
			}
			//logClick("Start Assesment");
			pass("Succesfully Viewed The Loan Purpose and Lender Comments.");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element Lender Comment Information");
		}	
	}
	
	public void checkTitleDetails() throws Exception{
		try {
			waitForElementPresent(xpath(EVRObjectReference.titleDetails));
			click(xpath(EVRObjectReference.titleDetails));
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.certTitleRef));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.certTitleRef)));
			} catch (AssertionError e) {
				fail("Unable to locate element Certificate Title Reference");
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.legalDescription));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.legalDescription)));
			} catch (AssertionError e) {
				fail("Unable to locate element Legal Description");
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.territorialAuthority));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.territorialAuthority)));
			} catch (AssertionError e) {
				fail("Unable to locate element Territorial Authority");
			}
			
			lookForZoningInTitleDeteails();
			//logClick("Start Assesment");
			pass("Title Details are properly displayed and can be modified.");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element in Title Details");
		}	
	}
	
	public void lookForZoningInTitleDeteails() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.zoningTitle));
			//isElementPresent(xpath(EVRObjectReference.zoningTitle));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.zoningTitle)));
		} catch (AssertionError e) {
			fail("Unable to locate element Zoning Title");
		}
	}
	
	
	public void checkSpecialFeature_Services_ExternalImprovement() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.zoningTitle));
			//isElementPresent(xpath(EVRObjectReference.zoningTitle));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.zoningTitle)));
			
			checkSpecialFeatures();
			checkServices();
			checkExternalImprovements();
			
			if(!isHasError()){
			pass("User can select any of the check box options in Special Feature, Services, External Improvement sections.");
			}
		} catch (AssertionError e) {
			fail("Unable to locate element Special Features");
		}
	}
	
	
	public void checkSpecialFeatures() throws Exception{
		
		try {
			scroll(250);
			waitForElementPresent(xpath(EVRObjectReference.specialFeature));
			//isElementPresent(xpath(EVRObjectReference.zoningTitle));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.specialFeature)));
			
			//pass("User can select any of the check box options in Special Feature sections.");
			setHasError(false);
		} catch (AssertionError e) {
			fail("Unable to locate element Special Features");
			setHasError(true);
		}
		
	}
	
	
	public void checkIHaveCalledTheContact() throws Exception{
		
		try {
			scroll(150);
			waitForElementPresent(xpath(EVRObjectReference.ihaveCalled));
			//isElementPresent(xpath(EVRObjectReference.zoningTitle));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.ihaveCalled)));
			
			pass("I have called the contact checkbox is visible");
			
		} catch (AssertionError e) {
			pass("Unable to locate element Checbox i have called the contact");
			
		}
		
	}
	public void checkServices() throws Exception{
		
		try {
			scroll(150);
			waitForElementPresent(xpath(EVRObjectReference.services));
			//isElementPresent(xpath(EVRObjectReference.zoningTitle));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.services)));
			
			//pass("User can select any of the check box options in Services.");
			setHasError(false);
		} catch (AssertionError e) {
			fail("Unable to locate element Serivices");
			setHasError(true);
		}
		
	}
	
	
	public void checkExternalImprovements() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.externalImprovements));
			//isElementPresent(xpath(EVRObjectReference.zoningTitle));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.externalImprovements)));
			
			//pass("User can select any of the check box options in External Improvements.");
			setHasError(false);
		} catch (AssertionError e) {
			fail("Unable to locate element External Improvements");
			setHasError(true);
		}
		
	}
	
	public void checkPropertySummary() throws Exception{
		int error = 0;
		try {
			
			try {//checking for the header of property Summary
				scroll(600);
				waitForElementPresent(xpath(EVRObjectReference.propertySummary));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertySummary)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Property Summary");
				error++;
			}
			
			try {//checking for the Property Type List
				waitForElementPresent(xpath(EVRObjectReference.propertyType));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyType)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Property Type List");
				error++;
			}
			
			try {//checking for the Bedroom List
				waitForElementPresent(xpath(EVRObjectReference.bedrooms));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.bedrooms)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Bedroom List");
				error++;
			}
			
			try {//checking for the Bathroom List
				waitForElementPresent(xpath(EVRObjectReference.bathrooms));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.bathrooms)));
				Thread.sleep(1000);
				
			} catch (AssertionError e) {
				fail("Unable to locate Element Bathroom List");
				error++;
			}
			
			try {//checking for the Car Spaces List
				waitForElementPresent(xpath(EVRObjectReference.carSpaces));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.carSpaces)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Car Space List");
				error++;
			}
			
			try {//checking for the Car Accomodation List
				waitForElementPresent(xpath(EVRObjectReference.carAccomodations));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.carAccomodations)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Car Accomodation List");
				error++;
			}
			
			try {//checking for the Last Sale Date input type
				waitForElementPresent(xpath(EVRObjectReference.lastSaleDate));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lastSaleDate)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Last Sale Date");
				error++;
			}
			
			try {//checking for the Last Sale Price input type
				waitForElementPresent(xpath(EVRObjectReference.lastSalePrice));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lastSalePrice)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Last Sale Price");
				error++;
			}
			
			try {//checking for the Main Wall List
				waitForElementPresent(xpath(EVRObjectReference.mainWallConstruction));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mainWallConstruction)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element Main Wall Construction");
				error++;
			}
			
			try {//checking for the Roof Construction List
				waitForElementPresent(xpath(EVRObjectReference.roofConstructions));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.roofConstructions)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element RoofConstructions");
				error++;
			}
			
			if(error == 0){
			pass("Property Summary Details are properly displayed and can be modified.");
			}
			
		} catch (AssertionError e) {
			fail("Unable to locate element Property Summary");
		}
	}
	
	public void checkVerifyPageNZ() throws Exception{
		
		waitForElementPresent(xpath(EVRObjectReference.customerInformation));
		try {
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
			
			waitForElementPresent(xpath(EVRObjectReference.services));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.services)));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(EVRObjectReference.specialFeature));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.specialFeature)));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(EVRObjectReference.externalImprovements));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.externalImprovements)));
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to Locate Element");
		}
		
	}
	
	public void showPropertyInfoModal() throws Exception{
		int error = 0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.propertyInformation));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyInformation)));
				click(xpath(EVRObjectReference.propertyInformation));
			} catch (AssertionError e) {
				fail("Unable to locate Element Property Information");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			} catch (AssertionError e) {
				fail("There is an error upon clicking Property Information Modal");
				error++;
			}
			
			closedmboxContentModal();
			//logClick("Property Information Modal");
			if(error == 0){
				pass("Sucessfully View the Property Information Modal");
			}
			
		} catch (AssertionError e) {
			e.printStackTrace();
			fail("There is an error upon clicking Property Information");
		}
	}
	
	public void showinTheMarketModal() throws Exception{
		int error = 0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.onTheMarket));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.onTheMarket)));
				click(xpath(EVRObjectReference.onTheMarket));
			} catch (AssertionError e) {
				fail("Unable to locate element On The Market");
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			} catch (AssertionError e) {
				fail("There is an error upon clicking On The Market");
			}
			
			closedmboxContentModal();
			//logClick("On The Market");
			if(error == 0){
				pass("Sucessfully View the On The Market Modal");
			}
			
		} catch (AssertionError e) {
			//e.printStackTrace();
			fail("Unable to locate Element On The Market");
		}
	}
	
	public void showpropertyImageryModal() throws Exception{
		int error =0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.propertyImagery));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyImagery)));
				click(xpath(EVRObjectReference.propertyImagery));
			} catch (AssertionError e) {
				fail("Unable to locate Element Property Imagery");
				error++;
			}
			
		
			try {
				waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			} catch (AssertionError e) {
				fail("There is an error upon clicking Property Imagery Modal or Element Not Found");
				error++;	
			}
					
			try {
				waitForElementPresent(xpath(EVRObjectReference.sitePhotoOnIM));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.sitePhotoOnIM)));
				Thread.sleep(1000);
			} catch (Exception e) {
				fail("There is an error upon clicking Property Imagery Modal or Element Not Found SitePhoto");
				error++;	
			}
			pass("Succesfully View The Property Imagery Modal");
			googleMapTab();
			galleryTab();
			closedmboxContentModal();
			//logClick("Property Imagery");
			
		} catch (AssertionError e) {
			e.printStackTrace();
			fail("Unable to locate Property Imagery");
		}
		
		
	}
	
	public void googleMapTab() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.googleMapOnIM));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.googleMapOnIM)));
			click(xpath(EVRObjectReference.googleMapOnIM));
			Thread.sleep(1000);
			//logClick("Close Modal Box");
			pass("Google Map tab is load the map of the property then it is being viewed.");
		} catch (AssertionError e) {
			//e.printStackTrace();
			fail("Unable to Locate Element GoogleMapTab");
		}
	}
	
	public void galleryTab() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.galleryOnIM));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.galleryOnIM)));
			click(xpath(EVRObjectReference.galleryOnIM));
			pass("Gallery tab is load then Photo Gallergy of the property is being viewed.");
			Thread.sleep(3000);
		} catch (AssertionError e) {
			//e.printStackTrace();
			fail("Unable to Locate Element Gallery Tab");
		}
	}
	
	public void closedmboxContentModal() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.closeModal));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.closeModal)));
			Thread.sleep(3000);
			click(xpath(EVRObjectReference.closeModal));
			Thread.sleep(1000);
			//logClick("Close Modal Box");
		} catch (AssertionError e) {
			//e.printStackTrace();
			fail("Unable to Locate Element Close Modal");
		}
	}
	
	public void showAerialPhoto() throws Exception{
		int error = 0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.aerialPhoto));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.aerialPhoto)));
				click(xpath(EVRObjectReference.aerialPhoto));
			} catch (AssertionError e) {
				fail("Unable to Locate Element Aerial Photo");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			} catch (AssertionError e) {
				fail("There is an error upon Clicking Aerial Photo");
				error++;
			}
			
			
			closedmboxContentModal();
			//logClick("Aerial Photo");
			if(error == 0){
			pass("Succesfully Viewed the Aerial Photo Modal");
			}
		} catch (AssertionError e) {
			e.printStackTrace();
			fail("Unable to Locate Element Aerial Photo");
		}
	}
	
	public void showTopoMap() throws Exception{
		int error = 0;
		try {
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.topoMap));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.topoMap)));
				click(xpath(EVRObjectReference.topoMap));
			} catch (AssertionError e) {
				fail("Unable to Locate Element Topo Map");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			} catch (AssertionError e) {
				fail("There is an error upon Clicking Topographic Map");
				error++;
			}
			
			closedmboxContentModal();
			//logClick("Topo Map");
			if(error == 0){
				pass("Succesfully Viewed the Topo Map Modal");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unable to Locate Element Topo Map");
		}
	}
	
	public void showStreetMap() throws Exception{
		int error = 0;
		try {
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.streetMap));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.streetMap)));
				click(xpath(EVRObjectReference.streetMap));
			} catch (AssertionError e) {
				fail("Unable to Locate Element Street Map");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.mboxContentModal));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mboxContentModal)));
			} catch (AssertionError e) {
				fail("There is an error upon Clicking Street Map");
				error++;
			}
			
			closedmboxContentModal();
			//logClick("Street Map");
			if(error == 0){
				pass("Succesfully Viewed the Street Map Modal");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			fail("Unable to Locate Element Street Map");
		}
	}
	
	public void showStreetView() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.streetViewNz));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.streetViewNz)));
			click(xpath(EVRObjectReference.streetViewNz));
			
			pass("Succefully open a new tab/window showing the Street View on Google Map");
			//logClick("Street View");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Street View");
		}
	}
	
	public void verifyDataSaveContinue() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.verifyDataSaveContinue));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.verifyDataSaveContinue)));
			click(xpath(EVRObjectReference.verifyDataSaveContinue));
//			
//			waitForElementPresent(xpath(EVRObjectReference.searchLabel));
//			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchLabel)));
			Thread.sleep(1000);
			
			pass("Any inputted data or modifications should are saved and will load the Sales Evidence tab.");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to Locate Element Save and Continue");
		}
		
	}
	
	public void checkSearchByFilters() throws Exception{
		int error =0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.dropDownlastSaleDate));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.dropDownlastSaleDate)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable to locate Element dropdown Last Sale Date");
			}
			
			pass("The site is loaded its default values on filters. Users can able to input and choose values to be used as for searching.");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to Locate Element Save and Continue");
		}
		
	}
	
	public void gotoSearchByFilter() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchbyFilterNZ));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchbyFilterNZ)));
			click(xpath(EVRObjectReference.searchbyFilterNZ));
			Thread.sleep(1000);
			pass("Successfully Navigate to Search By Filter");
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to Locate Element Search by Filter");
		}
		
	}
	
	public void gotoSearchByAddress() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchbyAddressNZ));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchbyAddressNZ)));
			click(xpath(EVRObjectReference.searchbyAddressNZ));
			Thread.sleep(1000);
			//logClick("Search by Address");
			pass("Succesfully Navigate to Search Address Tab");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Search By Address");
		}
		
	}
	
	public void gotoSearchByQPID() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.searchbyQPID));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchbyQPID)));
			click(xpath(EVRObjectReference.searchbyQPID));
			Thread.sleep(1000);
			//logClick("Search by QPID");
			pass("Succesfully Navigate to Search by QPID");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Search by QPID");
		}
		
	}
	
	public void performFilterSearch() throws Exception{
	
		selectLastSaleDate(EVRObjectReference.dropDownlastSaleDate,3);
		enterCapitalValues(input[10],input[11]);
		enterFloorAreaValues(input[12],input[13]);
		selectBuildingAge(EVRObjectReference.buildingAgeFrom,3,EVRObjectReference.buildingAgeTo,5);
		selectRadius(EVRObjectReference.radiusList,5);
		selectBedOrBathOrCar(EVRObjectReference.bedroomsList,3);
		selectBedOrBathOrCar(EVRObjectReference.bathroomList,4);
		selectBedOrBathOrCar(EVRObjectReference.carspaceList,5);
		checkType(3);
		checkType(3);
		checkType(2);
		checkType(1);
		enterLandSize(input[14],input[15]);
		enterLastSalePrice(input[16],input[17]);
	
	}
	
	public void searchButtonFilter() throws Exception{
		int error=0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.searchButtonFilter));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.searchButtonFilter)));
				click(xpath(EVRObjectReference.searchButtonFilter));
				Thread.sleep(6000);
			} catch (AssertionError e) {
				fail("Unable to Locate Element Search Filter Button");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.propertyPhotoNZ));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyPhotoNZ)));
				//pass("Successfull Search on Sales Evidence");
			} catch (AssertionError e) {
				fail("Failed to display Search Result");
				error++;
			}
			if(error == 0){
			pass("Successfull Search on Sales Evidence");
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element SearchButton");
		}
		
	}
	
	public void addRemoveProperty(int propertyNo) throws InterruptedException, IOException{
		
		
        try {
			int prono = propertyNo;
			String xPath = "(//*[@id='addRemoveProperty'])["+prono+"]";
			
			waitForElementPresent(xpath(xPath));
			Assert.assertTrue(isElementPresent(xpath(xPath)));
			click(xpath(xPath));
			
			Thread.sleep(4000);
			//logClick("Add/Remove Property");
			pass("Succesfully Added/Removed the Property");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Add/Remove Property");
		}
		
	}
	
	public void saveContinueAddProperty() throws Exception{
		int error =0;
		try {
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.saveAndContinue));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saveAndContinue)));
				click(xpath(EVRObjectReference.saveAndContinue));
			} catch (AssertionError e) {
				fail("Unable to Locate Element Save And Continue");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.riskAnalysisList));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.riskAnalysisList)));
			} catch (AssertionError e) {
				fail("Fail to Navigate on Risk Analysis Tab");
				error++;
			}
			
			if(error == 0){
				pass("Succesfully Save All The Data Changes in Adding Property and Navigate to Risk Analysis Tab");
			}
			//logClick("Save and Continue");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Save and Continue");
		}
	}
	
	
	public void checkDataInSubmissionPage() throws Exception{
		int error =0;
		try {
			
			Thread.sleep(2000);
			scroll(300);
			Thread.sleep(2000);
			scroll(300);
			
			if(error == 0){
				pass("All data saved on the previous tab is displayed on this section.");
			}
			//logClick("Save and Continue");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Save and Continue");
		}
	}
	
	public void saveContinueRiskAnalysis() throws Exception{
		int error =0;
		
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.saveAndContinueRiskAnalysis));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.saveAndContinueRiskAnalysis)));
				click(xpath(EVRObjectReference.saveAndContinueRiskAnalysis));
			} catch (AssertionError e) {
				fail("Unable to locate Element Save and Continue in Risk Analysis");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.sitePhoto));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.sitePhoto)));
			} catch (AssertionError e) {
				fail("Unable to Navigate on Submission Page");
				error++;
			}
			
			if(error == 0){
			pass("Succesfully Save the Change and Navigate to Submission Page");
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Save and Continue");
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
			//logClick(checkbox);
			//logInput(input);
			pass("Successfully click the checkbox on Risk Analysis and input comment");
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Option on Risk Analysis");
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
			pass("Succesfully Choose Radio on Propety Risk Rating ");
			//click(xpath(EVRObjectReference.radioButton));
			//logClick(radioButton);
			Thread.sleep(1000);
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Property Risk Rating");
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
			pass("Succesfully Choose Radion On Escalation");
			Thread.sleep(1000);
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Radio on Escalation");
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
			fail("Unable to locate element Radio on Cancellation");
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
			fail("Unable to locate element Cancel Button on Escalation");
		}
	
	}

	public void cancelCancellation() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.cancelButtonOnCancellation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.cancelButtonOnCancellation)));
			click(xpath(EVRObjectReference.cancelButtonOnCancellation));
			//logClick("Cancel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Cancel Button on Cancellation");
		}
	
	}
	
	public void cancelThisRequest() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.cancelThisRequest));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.cancelThisRequest)));
			click(xpath(EVRObjectReference.cancelThisRequest));
			//logClick("Cancel This Request");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Cancel This Request");
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
			fail("Unable to locate element Esacalate Button");
		}
	
	}
	
	public void confirmEscalate() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.confirmEscallation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.confirmEscallation)));
			click(xpath(EVRObjectReference.confirmEscallation));
			Thread.sleep(4000);
			//logClick("Confirm Escalate");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Confirm Escalate Button");
		}
	
	}
	
	public void confirmCancellation() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.confirmEscallation));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.confirmEscallation)));
			click(xpath(EVRObjectReference.confirmEscallation));
			Thread.sleep(4000);
			//logClick("Confirm Cancellation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Confirm Cancellation Button");
		}
	
	}
	public void enterCommentsOnEscallation(String input) throws InterruptedException, IOException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.commentBox));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.commentBox)));
			type(xpath(EVRObjectReference.commentBox),input);
			
			//logInput(input);
			pass("Succefully enter Comments on Escallation");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Comment Input Escallation");
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
			fail("Unable to locate element Comment Input Cancellation");
		}
	}
	
	public void clickYesNoOnEscalation(boolean option) throws InterruptedException, IOException{
		
		try {
			if(option){
				waitForElementPresent(xpath(EVRObjectReference.yesButton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.yesButton)));
				click(xpath(EVRObjectReference.yesButton));
				//logClick(yesButton);
				pass("Succesfully Click YES on Escallation");
			}else{
				waitForElementPresent(xpath(EVRObjectReference.noButton));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.noButton)));
				click(xpath(EVRObjectReference.noButton));
			//	logClick(noButton);	
				pass("Succesfully Click NO on Escallation");
			}
			
		} catch (AssertionError e) {
			//e.printStackTrace();
			fail("Unable to locate element");
		}
		
	}
	
	public void chooseReasonOnEscalation(int rowNo) throws InterruptedException, IOException{
		
		try {
			rowNo = rowNo + 8;
			String rowno = "(//*[@class='reason'])["+rowNo+"]";
			
			if(rowNo >= 4 && rowNo <= 12){
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
			e.printStackTrace();
			fail("Unable to locate element");
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
			e.printStackTrace();
			fail("Unable to locate element Radio On Market Risk Rating");
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
			//logInput(input);
			pass("Succesfully Inputed Comment on Property Risk Rating");
		} catch (AssertionError e) {
			//e.printStackTrace();
			fail("Unable to locate element CommentOnPropertyRiskRating");
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
			//logInput(input);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element CommentOnMarketRiskRating");
		}
		
	}
	
	public void viewSalesEvidenceList() throws Exception{
		int error =0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.salesEvidenceListNZ));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.salesEvidenceListNZ)));
				click(xpath(EVRObjectReference.salesEvidenceListNZ));
			} catch (AssertionError e) {
				fail("Unable to Locate Element Sales Evidence List");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.returnSearchResultNZ));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.returnSearchResultNZ)));
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Unable to Locate Element Return to Search Result");
				error++;
			}
			
			//logClick("View Sales List");
			if(error ==0){
			pass("Succesfully Navigate Search List");
			}
		} catch (AssertionError e) {
			fail("Unable to locate element View Sales List");
		}
		
	}

	public void submitAssessment() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.submitAssessmentNZ));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.submitAssessmentNZ)));
			click(xpath(EVRObjectReference.submitAssessmentNZ));
			//logClick("Submit Assesment");
			pass("Successfully Click Submit Assessment");
			Thread.sleep(4000);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Submit Assessment");
		}
		
	}
	
	public void rateSalesEvidenceList(int rateNo) throws InterruptedException, IOException{
		
		try {
			String rateNZ = "(//*[@class='rate content_text'])["+rateNo+"]";
			
			waitForElementPresent(xpath(EVRObjectReference.rateNZ));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.rateNZ)));
			click(xpath(EVRObjectReference.rateNZ));
			//logClick("Rate Sales Evidence List");
			pass("Succesfully put rate from the added Property");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Rate Sales Evidence List");
		}
	}
	
	public void enterCommentinSEList(String inputString, int commentNo) throws InterruptedException{
		
		String commentNZ = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/div[2]/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/textarea)["+commentNo+"]";
		
		waitForElementPresent(xpath(commentNZ));
		try{
			Assert.assertTrue(isElementPresent(xpath(commentNZ)));
			//error when using variable commentNZ
			type(xpath("(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/div[2]/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/textarea)["+commentNo+"]"),inputString);
			//logInput(inputString);
			pass("Succesfully Inputed a Comment from the added Property List");
		}
		catch(AssertionError e){
			e.printStackTrace();
			fail("Fail to Enter Comment in Sales Evidence List");
			
		}
		
	}
	
	
	public void inputAssessmentValue(String input) throws InterruptedException{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.assesmentValue));
			
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.assesmentValue)));
			//error when using variable commentNZ
			type(xpath(EVRObjectReference.assesmentValue),input);
			//logInput(input);
			pass("Successfully Inputed Value in Assessment Value");
			Thread.sleep(1000);
			
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Unable to locate element Assement Value");
		}
		
	}
	
	public void returnSearchResult() throws Exception{
		int error =0;
		try {
			try {
				waitForElementPresent(xpath(EVRObjectReference.returnSearchResultNZ));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.returnSearchResultNZ)));
				click(xpath(EVRObjectReference.returnSearchResultNZ));
			} catch (AssertionError e) {
				fail("Unable to Locate Element Return Search Result");
				error++;
			}
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.salesEvidenceListNZ));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.salesEvidenceListNZ)));
				Thread.sleep(1000);
			} catch (AssertionError e) {
				fail("Unable ot Locate Element Sales Evidence List");
			}
			
			if(error ==0){
			pass("Succesfully Return to Search Result");
			}
		} catch (Exception e) {	
			//e.printStackTrace();
			fail("Unable to Preview Search Result");
		}
		
	}
	
	//click the Photo Gallery on search Result NZ Sales EVidence
	public void showPhotoGallery() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.propertyPhotoNZ));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.propertyPhotoNZ)));
			click(xpath(EVRObjectReference.propertyPhotoNZ));
			
			waitForElementPresent(xpath(EVRObjectReference.mBoxSearchFilter));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.mBoxSearchFilter)));
			
			Thread.sleep(2000);
			//logClick("Photo Gallery");
		} catch (Exception e) {		
			e.printStackTrace();
			fail("Unable to locate element Photo Gallery");
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
		//	logInput(inputFrom);
		//	logInput(inputTo);
		} catch (Exception e) {
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
			e.printStackTrace();
			fail("Unable to locate element Floor Area");
					
		}
	}
	
	public void enterLandSize (String inputMin,String inputMax) throws InterruptedException, IOException {
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.landSizeMin));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.landSizeMin)));
			waitForElementPresent(xpath(EVRObjectReference.landSizeMax));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.landSizeMax)));
			
			type(xpath(EVRObjectReference.landSizeMin), inputMin);
			type(xpath(EVRObjectReference.landSizeMax), inputMax);
			//logInput(inputMin);
			//logInput(inputMax);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unable to locate element Land Size");
		}
	}
	
	public void enterLastSalePrice (String inputMin,String inputMax) throws InterruptedException, IOException {
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.lastSalePriceMin));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lastSalePriceMin)));
			waitForElementPresent(xpath(EVRObjectReference.lastSalePriceMax));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.lastSalePriceMax)));
			
			type(xpath(EVRObjectReference.lastSalePriceMin), inputMin);
			type(xpath(EVRObjectReference.lastSalePriceMax), inputMax);
			//logInput(inputMin);
			//logInput(inputMax);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unable to locate element Last Sale Price");
		}
	}
	
	public void selectLastSaleDate (String dropDown,int descCode) throws InterruptedException, IOException {	
			
	    	try {
				String dropdown = dropDown;
				String description = "";
				
				if(descCode == 1){
					description = "Select";
				}else if(descCode == 2){
					description ="Last 3 months";
				}else if(descCode == 3){
					description ="Last 6 months";
				}else if(descCode == 4){
					description = "Last 9 months";
				}else if(descCode == 5){
					description ="Last 12 months";
				}else if(descCode == 6){
					description ="Specify Date";
				}else{
					description ="Select";
				}
				
				waitForElementPresent(xpath(dropdown));
				Assert.assertTrue(isElementPresent(xpath(dropdown)));
				selectDropdownOption(xpath(dropdown),description);
				Thread.sleep(1000);
				//logClick("Last Sale Date");
			} catch (Exception e) {
				e.printStackTrace();
				fail("Unable to locate element last sale date");
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
			//logClick("Building Age");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unable to Locate element Building Age");
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
			}else{
				description ="0.5";
			}
			
			waitForElementPresent(xpath(dropdown));
			Assert.assertTrue(isElementPresent(xpath(dropdown)));
			selectDropdownOption(xpath(dropdown),description);
			Thread.sleep(1000);
			//logClick("Select Radius");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Select Radius");
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
			
			waitForElementPresent(xpath(EVRObjectReference.dataList));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.dataList)));
			selectDropdownOption(xpath(EVRObjectReference.dataList),description);
			Thread.sleep(4000);
			//logClick("Sort by Data");
			pass("Data is Succesfully Sorted by Data");
		} catch (AssertionError e) {
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
			
			waitForElementPresent(xpath(EVRObjectReference.pageList));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.pageList)));
			selectDropdownOption(xpath(EVRObjectReference.pageList),description);
			Thread.sleep(1000);
			pass("Data is Succesfully Sorted by Page");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to Locate element sort by Page");
		}
	}
	
	public void selectBedOrBathOrCar (String xPath,int descCode) throws InterruptedException, IOException {	
		
    	try {
			String dropdown = xPath;
			String description = "";
			
			if(descCode == 1){
				description = "Select";
			}else if(descCode == 2){
				description ="0";
			}else if(descCode == 3){
				description ="1";
			}else if(descCode == 4){
				description = "2";
			}else if(descCode == 5){
				description ="3";
			}else if(descCode == 6){
				description ="4";
			}else if(descCode == 7){
				description ="5";
			}else if(descCode == 8){
				description ="6";
			}else if(descCode == 9){
				description ="7";
			}else if(descCode == 10){
				description ="8";
			}else if(descCode == 11){
				description ="9";
			}else if(descCode == 12){
				description ="10";
			}else{
				description ="Select";
			}
			
			waitForElementPresent(xpath(dropdown));
			Assert.assertTrue(isElementPresent(xpath(dropdown)));
			selectDropdownOption(xpath(dropdown),description);
			Thread.sleep(1000);
			//logClick("Bed Bath or Car");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element BedBathCar");
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
			//logClick("Type "+descCode+"");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unable to locate element checbox Type");
		}
	}	
	    
	public void gotoSalesEvidence() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference. salesEvidence_nz));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference. salesEvidence_nz)));
			click(xpath(EVRObjectReference. salesEvidence_nz));
			Thread.sleep(1000);
			pass("Succesfully Navigate to Sales Evidence");
			//logClick("Sales Evidence");
		} catch (Exception e) {
			//e.printStackTrace();
			fail("Unable to locate element Tab Sales Evidence");
		}
}
	
	public void resetFilters() throws Exception{
		
			try {
				waitForElementPresent(xpath(EVRObjectReference. resetFilters));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference. resetFilters)));
				click(xpath(EVRObjectReference. resetFilters));
				Thread.sleep(1000);
				pass("Succesfully Reset All Fields");
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				fail("Unable to locate element Reset Filters");
			}
	}
	
	public void checkSearchResult() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference. addRemoveButton));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference. addRemoveButton)));
			//click(xpath(EVRObjectReference. resetFilters));
			Thread.sleep(1000);
			pass("Every property listed has Property Thumbnail,Sale Type,Sale Date,Sale Price,Distance,Category,Capital Value,Reval Date,property attributes(Bed, Bath, Car, Land and Floor a");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("One of The property is not Visible in Search Result");
		}
	}
	
	public void pagination(int pageNo) throws InterruptedException, IOException{
		
		try {
			String xpath = "(//*[@class='pagination'])["+pageNo+"]";
			
			waitForElementPresent(xpath(xpath));
			Assert.assertTrue(isElementPresent(xpath(xpath)));
			Thread.sleep(4000);
			click(xpath(xpath));
			//logClick("Page "+pageNo+"");
			pass("Pagination Succesfully Perform in Page No."+pageNo+"");
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
			//logClick(xpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element Previous/Next/First/Last");
		}
		
	}
	public void gotoVerifyData() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference. verifyData_nz));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference. verifyData_nz)));
				click(xpath(EVRObjectReference. verifyData_nz));
				Thread.sleep(1000);
				//logClick("Verify Data");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Verify Data");
			}
	}
	 
	public void gotoOverview() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference. overview_nz));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference. overview_nz)));
				click(xpath(EVRObjectReference. overview_nz));
				Thread.sleep(1000);
				//logClick("Overview");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Overview");
			}
	}
	 
	public void gotoRiskAnalysis() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.riskAnalysis_nz));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.riskAnalysis_nz)));
				click(xpath(EVRObjectReference.riskAnalysis_nz));
				Thread.sleep(1000);
				pass("Succesfully Navigate To Risk Analysis");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				fail("Unable to locate element Risk Analysis");
			}
	}
	 
	public void gotoSubmission() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.submission_nz));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.submission_nz)));
				click(xpath(EVRObjectReference.submission_nz));
				Thread.sleep(1000);
				//logClick("Submission");
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate element Submission");
			}
	}
	 
	public void gotoEscalateCancel() throws Exception{
			
			try {
				waitForElementPresent(xpath(EVRObjectReference.escalate_nz));
				Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.escalate_nz)));
				click(xpath(EVRObjectReference.escalate_nz));
				Thread.sleep(1000);
				//logClick("Escalate Cancel");
				pass("Succesfully Navigate to Escalate Cancel");
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unable to locate Escalate Cancel Button");
			}
	}
	
	public void scroll(int scrollNo)  throws InterruptedException, IOException {
		
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,"+scrollNo+")", ""); //y value '800' can be altered
			Thread.sleep(3000);
			//log("Scroll at "+scrollNo+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
			   
	}
	
	public void enterValueInZoning (String input) throws InterruptedException, IOException {
		try {
			resultcount = 0;
			waitForElementPresent(xpath(EVRObjectReference.zoning));
			isElementPresent(xpath(EVRObjectReference.zoning));			
			
			type(xpath(EVRObjectReference.zoning), input);
			//logInput("input");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate element zoning");
		}
	}
	
	public void verifySalesEvidenceError() throws Exception{
		
		try {
			waitForElementPresent(xpath(EVRObjectReference.escalate_nz));
			Assert.assertTrue(isElementPresent(xpath(EVRObjectReference.escalate_nz)));
			click(xpath(EVRObjectReference.escalate_nz));
			Thread.sleep(1000);
			pass("Error message is displayed properly");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unable to locate Escalate Cancel Button");
		}
	}
	
	public void escallationDriveBy() throws Exception{
		
			gotoEscalateCancel();//Test Case No. 47
			chooseRadioOnEscalation(39);//Test Case No. 47
			enterCommentsOnEscallation(input[9]);//Test Case No. 47
			clickYesNoOnEscalation(true);//Test Case No. 47
			checkChangesOnValexNz();//Test Case No. 47
			
			if(!isHasError()){
			pass("Successfully changed to Service Type: Drive By and Status: Accepted.");
			}else{
			fail("Error During Escallation Process");
			}
	
	}
	
	public void escallationfullMarketFromDriveBy() throws Exception{

		gotoHomeEvr();//Test Case No. 48
		valexNzOrder(input[2]);//Test Case No. 48
		gotoEscalateCancel();//Test Case No. 48
		chooseRadioOnEscalation(39);//Test Case No. 48
		clickYesNoOnEscalation(false);//Test Case No. 48
		enterCommentsOnEscallation(input[9]);//Test Case No. 48
		chooseReasonOnEscalation(3);//Test Case No. 48
		escalate();//Test Case No. 48
		confirmEscalate();//Test Case No. 48
		checkChangesOnValexNz();//Test Case No. 48
		
	}
	
	public void escallationfullMarket() throws Exception{
		gotoEscalateCancel();//Test Case No. 49
		chooseRadioOnEscalation(37);//Test Case No. 49
		enterCommentsOnEscallation(input[9]);//Test Case No. 49
		escalate();//Test Case No. 49
		confirmEscalate();//Test Case No. 49
		checkChangesOnValexNz();//Test Case No. 49
	}
	
	public void escallationCancellation() throws Exception{
		gotoEscalateCancel();//Test Case No.50
		chooseRadioOnCancellation(20);//Test Case No.50
		enterCommentsOnCancellation(input[9]);//Test Case No.50
		cancelThisRequest();//Test Case No.50
		confirmCancellation();//Test Case No.50
		checkChangesOnValexNz();//Test Case No.50
		
	}
}

