package mobile.test;

import static org.openqa.selenium.By.xpath;

import java.util.*;

import myrp.library.ObjectReference;
import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CFAUtil extends TestInitReference{
 
	
	String streetNo = rxml.data("cfaStreetNumber");
	String unitNo = rxml.data("cfaUnitNumber");
	String lotNo = rxml.data("cfaLotNumber");
	String streetName = rxml.data("cfaStreetName");
	String streetType = rxml.data("cfaStreetType");
	String suburbStatePostCode = rxml.data("cfaSuburbStatePostcode");
	
	
	
	
	@Test
	public void openCFA(){
		try{
			waitForElementPresent(xpath(ObjectReference.btnOpenCFA_xp));
			click(xpath(ObjectReference.btnOpenCFA_xp));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void closeCFA(){
		try{
			waitForElementPresent(xpath(ObjectReference.btnCloseCFA_xp));
			click(xpath(ObjectReference.btnCloseCFA_xp));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void clearCFAFields(){
		try{
			waitForElementPresent(xpath(ObjectReference.btnClearCFA_xp));
			click(xpath(ObjectReference.btnClearCFA_xp));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void fillUpFieldsUsingStreetNumber(){
		try{
			waitForElementPresent(xpath(ObjectReference.txtStreetNumber_xp));
			type(xpath(ObjectReference.txtStreetNumber_xp), streetNo);
			type(xpath(ObjectReference.txtStreetName_xp), streetName);
			type(xpath(ObjectReference.txtStreetType_xp), streetType);
			type(xpath(ObjectReference.txtSuburbStatePostcode_xp), suburbStatePostCode);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@Test 
	public void clickSearch(){
		try{
			waitForElementPresent(xpath(ObjectReference.btnSearchCFA_xp));
			click(xpath(ObjectReference.btnSearchCFA_xp));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
