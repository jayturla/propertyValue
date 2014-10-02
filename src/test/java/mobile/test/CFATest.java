package mobile.test;

import org.testng.annotations.Test;
import static org.openqa.selenium.By.xpath;

import java.util.*;

import myrp.library.TestInitReference;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CFATest extends TestInitReference{

	
	
	@Test
	public void verifyOpenCfa(){
		try{
			pass("Verifying Open CFA form");
			new CFAUtil().openCFA();
			pass("Verifying Open CFA form succeeded");
		}catch(Exception e){
			fail("Verifying Open CFA form failed..");
		}
		
	}
	
	@Test 
	public void verifyCloseCfa(){
		try{
			pass("Verifying Close CFA form");
			new CFAUtil().openCFA();
			new CFAUtil().closeCFA();
			pass("Verifying Close CFA form succeeded");
			
			
		}catch(Exception e){
			fail("Verify Close CFA form failed..");
		}
	}
	
	@Test
	public void verifySearchUsingStreeNumber(){
		try{
			pass("Verifying Search Using street Number");
			new CFAUtil().openCFA();
			new CFAUtil().fillUpFieldsUsingStreetNumber();
			new CFAUtil().clickSearch();
			
			pass("Verifying Search Using street Number succeeded");
			
		}catch(Exception e){
			fail("Verify Search Using Street Number failed..");
		}
	}
	
	
	
	
	
	
}
