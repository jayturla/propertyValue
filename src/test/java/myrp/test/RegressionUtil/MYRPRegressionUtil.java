package myrp.test.RegressionUtil;


import static org.openqa.selenium.By.xpath;

import java.io.IOException;
import java.util.List;

import myrp.library.MYRPObjectReference;
import myrp.library.FunctionReference;
import myrp.library.ObjectReference;
import myrp.library.RegressionObjectReference;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class MYRPRegressionUtil extends FunctionReference {
	
	private String[] input = null;
	private String testCase = "";
		public MYRPRegressionUtil(String[] i) {
			input = i;
	}
		
	public boolean checkLandingPages() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Check Landing Pages");
		try {
			if(gotoReportsAndServices()){
				if(gotoEstimatedValueReport() && gotoEstimatedValueSubscription() && gotoDetailedPropertyReport() && gotoTitleDocument() && gotoSalesHistoryReport()){
					success = true;
					log("All Pages is Succesfully Visit");
					Thread.sleep(2000);
				}else{
					fail("Some of Link Are Unable to Visit");
				}
			}else{
				fail("Some of Link Are Unable to Visit");
			}
		} catch (AssertionError e) {
			fail("Some of Link Are Unable to Visit");
		}
		return success;
	}
		
	public boolean gotoReportsAndServices() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Reports and Services Link");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.reportsAndServices));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.reportsAndServices)));
			click(xpath(MYRPObjectReference.reportsAndServices));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.reportsAndServicesLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.reportsAndServicesLabel)));
			String text = getText(xpath(MYRPObjectReference.reportsAndServicesLabel));
			
			if(text.equalsIgnoreCase("Reports and Services")){
				success = true;
				log("Succesfully Visit the Reports and Services Link");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Element Reports and Service Link");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Reports and Service Link");
		}
		return success;
	}
	
	public boolean gotoPropertyServices() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Property Services Link");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.propertySevicesButton));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.propertySevicesButton)));
			click(xpath(MYRPObjectReference.propertySevicesButton));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.propertySevicesLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.propertySevicesLabel)));
			String text = getText(xpath(MYRPObjectReference.propertySevicesLabel));
			
			if(text.equalsIgnoreCase("Property Services")){
				success = true;
				log("Succesfully Visit the Property Services Link");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Element Property Services Link");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Property Services Link");
		}
		return success;
	}
	
	public boolean gotoDesktopValuation() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Desktop Valuation");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.desktopValuationButton));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.desktopValuationButton)));
			click(xpath(MYRPObjectReference.desktopValuationButton));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.desktopValuationLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.desktopValuationLabel)));
			String text = getText(xpath(MYRPObjectReference.desktopValuationLabel));
			
			if(text.contains("Desktop Valuation")){
				success = true;
				log("Succesfully Visit the Desktop Valuation Report");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Element Desktop Valuation Report");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Desktop Valuation Report");
		}
		return success;
	}
	
	public boolean gotoEstimatedValueReport() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Estimated Value Report");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.estimatedValuereportButton));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.estimatedValuereportButton)));
			click(xpath(MYRPObjectReference.estimatedValuereportButton));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.estimatedValueReportLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.estimatedValueReportLabel)));
			String text = getText(xpath(MYRPObjectReference.estimatedValueReportLabel));
			
			if(text.contains("Estimated Value Report")){
				success = true;
				log("Succesfully Visit the Estimated Value Report");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Element Estimated Value Report");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Estimated Value Report");
		}
		return success;
	}
	
	public boolean gotoEstimatedValueSubscription() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Estimated Value Subscription Link");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.estimatedValueSubscriptionButton));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.estimatedValueSubscriptionButton)));
			click(xpath(MYRPObjectReference.estimatedValueSubscriptionButton));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.estimatedValueSubscriptionLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.estimatedValueSubscriptionLabel)));
			String text = getText(xpath(MYRPObjectReference.estimatedValueSubscriptionLabel));
			
			if(text.contains("Estimated Value Subscription (12 months)")){
				success = true;
				log("Succesfully Visit the Estimated Value Subscription Page");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Element Estimated Value Subscription ");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Estimated Value Subscription Page");
		}
		return success;
	}
	
	public boolean gotoDetailedPropertyReport() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Detailed Property Report Button");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.detailedPropertyReportButton));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.detailedPropertyReportButton)));
			click(xpath(MYRPObjectReference.detailedPropertyReportButton));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.detailedPropertyReportLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.detailedPropertyReportLabel)));
			String text = getText(xpath(MYRPObjectReference.detailedPropertyReportLabel));
			
			if(text.contains("Detailed Property Report")){
				success = true;
				log("Succesfully Visit the Detailed Property Report Page");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Detailed Property Report");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Detailed Property Report");
		}
		return success;
	}
	
	public boolean gotoTitleDocument() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Title Document Button");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.titleDocumentButton));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.titleDocumentButton)));
			click(xpath(MYRPObjectReference.titleDocumentButton));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.titleDocumentLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.titleDocumentLabel)));
			String text = getText(xpath(MYRPObjectReference.titleDocumentLabel));
			
			if(text.contains("Title Document")){
				success = true;
				log("Succesfully Visit the Title Document Report Page");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Title Document Report");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Title Document Report");
		}
		return success;
	}
	
	public boolean gotoSalesHistoryReport() throws Exception{
		boolean success = false;
		System.out.println("========Preparing to Click the Sales History Report Button");
		try {
			waitForElementPresent(xpath(MYRPObjectReference.salesHistoryReportButton));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.salesHistoryReportButton)));
			click(xpath(MYRPObjectReference.salesHistoryReportButton));
			Thread.sleep(2000);
			
			waitForElementPresent(xpath(MYRPObjectReference.salesHistoryReportLabel));
			Assert.assertTrue(isElementPresent(xpath(MYRPObjectReference.salesHistoryReportLabel)));
			String text = getText(xpath(MYRPObjectReference.salesHistoryReportLabel));
			
			if(text.contains("Sales History Report")){
				success = true;
				log("Succesfully Visit the Sales History Report Page");
				Thread.sleep(2000);
			}else{
				fail("Unable to locate Sales History Report");
			}
		} catch (AssertionError e) {
			fail("Unable to locate Element Sales History Report");
		}
		return success;
	}
	
	
}