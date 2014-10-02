package myrp.test;

import myrp.library.TestInitReference;
import myrp.utilities.SmokeTestUtil;

import org.testng.annotations.Test;

public class NewTest extends TestInitReference {
  @Test
  public void f() {
	  try{
		  new SmokeTestUtil().verifySearchNetBank();
	  }catch(Exception e){
		  fail("verifyNetBankSearch");
	  }
}
  
}
