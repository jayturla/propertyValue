package myrp.utilities;

import static org.openqa.selenium.By.xpath;

import java.util.*;

import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobilePropertyTestUtil extends TestInitReference {
	
	String urlMobile = "http://dev.myrp.com/n/myrp-989";
	
	
	String propertyAddress = rxml.data("smokePropertyAddress");
	
	
  @Test
  public void searchProperty(String address){
	  try{
		  pass("Searching for Property.");
		  driver.navigate().to(urlMobile);
		  waitForElementPresent(xpath(mobileTxtSearch_xp));
		  type(xpath(smokeSearchLine_xp), address);
		  click(xpath(mobileBtnSearch_xp));
		  
		  pass("Searching for Property Succeeded.");
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("searchProperty Failed!");
	  }
	 
	  
	  
  }
  
  @Test
  public void checkPropertyImageAndAddress(){
	  try{
		  pass("Checking for checking for property image and address..");
		  waitForElementPresent(xpath(mobileImgProperty_xp));
		  waitForElementPresent(xpath(mobileLabelAddress_xp));
		  
		  
		  pass("Checking for Property Succeeeded..");
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("checking for property image and address failed!");
	  }
  }
  
  
  @Test
  public void checkAttributes(){
	  try{
		  pass("Checking for attributes..");
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileLabelBedAttribute_xp));
		  waitForElementPresent(xpath(mobileLabelBathAttribute_xp));
		  waitForElementPresent(xpath(mobileLabelGarageAttribute_xp));
		  
		  pass("Checking for attributes Succeeded..");
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("Checking for attributes failed..");
	  }
  }
  
  @Test
  public void checkReportButtons(){
	  try{
		  pass("Checking for Report Buttons");
		  Thread.sleep(1000);
		  waitForElementPresent(xpath("mobileBtnDetailedReport_xp"));
		  waitForElementPresent(xpath("mobileEstimatedValueReport_xp"));
		  waitForElementPresent(xpath("mobileBtnStreetReport_xp"));
		  waitForElementPresent(xpath("mobileBtnSuburbReport_xp"));
		  pass("Checking for Report Buttons Succeeded..");
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("Checking for Reportt Buttons failed..");
	  }
  }
  
  
  @Test 
  public void checkIfDetailedReportHasImgAndDescription() {
	  try{
		  pass("Checking if detailed report has image and description started..");
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileBtnDetailedReport_xp));
		  click(xpath(mobileBtnDetailedReport_xp));
		  Thread.sleep(1000);
		  waitForElementPresent(xpath("mobileImgDetailedReport_xp"));
		  waitForElementPresent(xpath("mobileDescDetailedReport_xp"));
		  
		  pass("Checking if detailed report has image and description succeeded..");
		  
		  
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("Checking if detailed report has image and description failed..");
	  }
  }
  
  @Test 
  public void checkIfEstimatedValueReportHasImgAndDescription() {
	  try{
		  pass("Checking if detailed report has image and description started..");
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileBtnDetailedReport_xp));
		  click(xpath(mobileBtnEstimatedValueReport_xp));
		  Thread.sleep(1000);
		  waitForElementPresent(xpath("mobileImgEstimatedValueReport_xp"));
		  waitForElementPresent(xpath("mobileDescEstimatedValueReport_xp"));
		  
		  pass("Checking if estimated value report has image and description succeeded..");
		  
		  
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("Checking if estimated value report has image and description failed..");
	  }
  }
  
  
  @Test
  public void checkIfPropertySalesReportHasImgAndDescription(){
	  try{
		  pass("Checking if property sales report has image and description");
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileBtnPropertySalesReport_xp));
		  click(xpath(mobileBtnDetailedReport_xp));
		  Thread.sleep(1000);
		  waitForElementPresent(xpath("mobileImgSalesReport_xp"));
		  waitForElementPresent(xpath("mobileDescSalesReport_xp"));
		  
		  pass("Checking if property sales report has image and description succeeded..");
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("Checking if property sales report has image and description failed..");
	  }
  }
  
  @Test
  public void checkIfStreetReportHasImgAndDescription(){
	  try{
		  pass("Checking if street report has image and description...");
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileBtnStreetReport_xp));
		  click(xpath(mobileBtnStreetReport_xp));
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileImgStreetReport_xp));
		  waitForElementPresent(xpath(mobileDescStreetReport_xp));
		  
		  pass("Checking if street report has image and description succeeded..");
		  
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("Checking if street report has image and description failed..");
	  }
  }
  
  @Test
  public void checkIfSuburbReportHasImgAndDescription() {
	  try{
		  pass("Checking if suburb report has image and description");
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileBtnSuburbReport_xp));
		  click(xpath(mobileBtnSuburbReport_xp));
		  Thread.sleep(1000);
		  waitForElementPresent(xpath(mobileImgSuburbReport_xp));
		  waitForElementPresent(xpath(mobileDescSuburbReport_xp));
		  pass("Checking if suburb report has image and description has succeeded..");
		  
		  
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  fail("Checking if suburb report has image and description failed..");
	  }
  }
  
  @Test
  public boolean checkIfEstimatedValueReportButtonExist(){
	  try{
		  pass("Checking if estimated value report button exist..");
		  waitForElementPresent(xpath(mobileBtnEstimatedValueReport_xp));
		  Thread.sleep(1000);
		  
		  
		  pass(" Estimated value report button exist..");
		  return true;
	
	  }catch(Exception e){
		  
		  
		  pass("Estimated value report does not exist..");
		  return false;
	  }
  }
  
  @Test
  public boolean checkIfSalesReportButtonExist(){
	  try{
		  pass("Checking if sales report button exist..");
		  waitForElementPresent(xpath(mobileBtnPropertySalesReport_xp));
		  
		  
		  pass("Sales report button exist..");
		  
		  return true;
	  }catch(Exception e){
		  
		  pass("Sales report button does not exist..");
		  return false;
	  }
	  
  }
  
  
  @Test
  public boolean checkIfStreetReportButtonExist() {
	  try{
		  pass("Checking if street report button exist");
		  waitForElementPresent(xpath(mobileBtnStreetReport_xp));
		  
		  pass("Street report button exist..");
		  
		  return true;
	  }catch(Exception e){
		  pass("Street report button does not exist..");
		  return false;
	  }
  }
  
  @Test
  public boolean checkIfSuburbReportButtonExist(){
	  try{
		  pass("Checking if suburb report button exist");
		  waitForElementPresent(xpath(mobileBtnSuburbReport_xp));
		  
		  pass("Suburb report button exist..");
		  
		  return true;
	  }catch(Exception e){
	
		  pass("Suburb report button does not exist..");
		  return false;
	  }
  }
  
  @Test
  public boolean checkIfDetailedReportButtonExist(){
	  try{
		  pass("Checking if detailed report button exist");
		  waitForElementPresent(xpath(mobileBtnDetailedReport_xp));
		  
		  pass("Suburb report button exist..");
		  
		  return true;
	  }catch(Exception e){
	
		  pass("Detailed report button does not exist..");
		  return false;
	  }
  }
  
  
  
  
  
  
  
  
  
}
