package myrp.test;

import static org.openqa.selenium.By.xpath;

import java.util.*;

import myrp.library.TestInitReference;
import myrp.utilities.MobilePropertyTestUtil;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobilePropertyTest extends TestInitReference{
	
	String address = "";
	String adressWithoutEVR = "";
	String addressWithoutSalesReport = "";
	String addressWithoutStreetReport = "";
	String addressWithoutSuburbReport = "";
	
	
	@Test
	public void verifyProperty() throws Exception{
		new MobilePropertyTestUtil().searchProperty(address);
		new MobilePropertyTestUtil().checkPropertyImageAndAddress();
		new MobilePropertyTestUtil().checkAttributes();
		new MobilePropertyTestUtil().checkReportButtons();
		
		
	}
	
	@Test
	public void verifyDetailedPropertyReport() throws Exception{
		new MobilePropertyTestUtil().searchProperty(address);
		new MobilePropertyTestUtil().checkIfDetailedReportHasImgAndDescription();
		
	}
	
	@Test
	public void verifyEstimatedValueReport() throws Exception{
		new MobilePropertyTestUtil().searchProperty(address);
		new MobilePropertyTestUtil().checkIfDetailedReportHasImgAndDescription();
		
	}
	
	@Test
	public void verifyPropertySalesReport() throws Exception{
		new MobilePropertyTestUtil().searchProperty(address);
		new MobilePropertyTestUtil().checkIfPropertySalesReportHasImgAndDescription();
		
	}
	
	@Test 
	public void verifyStreetReport() throws Exception{
		new MobilePropertyTestUtil().searchProperty(address);
		new MobilePropertyTestUtil().checkIfStreetReportHasImgAndDescription();
		
	}
	
	@Test
	public void verifySuburbReport() throws Exception {
		new MobilePropertyTestUtil().searchProperty(address);
		new MobilePropertyTestUtil().checkIfSuburbReportHasImgAndDescription();
		
	}
	
	
	@Test
	public void verifyIfEstimatedValueReportExist() throws Exception{
		new MobilePropertyTestUtil().searchProperty(adressWithoutEVR);
		if(new MobilePropertyTestUtil().checkIfEstimatedValueReportButtonExist()){
			
			fail("verifyIfEstimatedValueReportExist failed..");
		}else{
			pass("verifyIfEstimatedValueReportExist succeeded..");
		}
		
	}
	
	@Test
	public void verifyPropertySalesReportExist() throws Exception{
		new MobilePropertyTestUtil().searchProperty(addressWithoutSalesReport);
		if(new MobilePropertyTestUtil().checkIfSalesReportButtonExist()){
			fail("verifyPropertySalesReportExist failed..");
		}else{
			pass("verifyPropertySalesReportExist succeeded..");
		}
		
		
	}
	
	
	@Test
	public void verifyStreetReportExist() throws Exception {
		new MobilePropertyTestUtil().searchProperty(addressWithoutStreetReport);
		if(new MobilePropertyTestUtil().checkIfStreetReportButtonExist()){
			fail("verifyStreetReportExist failed..");
		}else{
			pass("verifyStreetReportExist succeeded..");
		}
		
	}
	
	@Test
	public void verifySuburbReportExist() throws Exception {
		new MobilePropertyTestUtil().searchProperty(addressWithoutSuburbReport);
		if(new MobilePropertyTestUtil().checkIfSuburbReportButtonExist()){
			fail("verifyStreetReportExist failed..");
		}else{
			pass("verifyStreetReportExist succeeded..");
		}
	}
	
	
	@Test
	public void verifyDetailedReportExist() throws Exception {
		new MobilePropertyTestUtil().searchProperty(adressWithoutEVR);
		if(new MobilePropertyTestUtil().checkIfSuburbReportButtonExist()){
			fail("verifyStreetReportExist failed..");
		}else{
			pass("verifyStreetReportExist succeeded..");
		}
	}
	
	
	
	
	
 
}
