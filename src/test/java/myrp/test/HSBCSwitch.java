package myrp.test;

import myrp.library.TestInitReference;
import myrp.utilities.HSBCDetailedPropertyReportUtil;
import myrp.utilities.PropertySearchUtil;

import org.testng.annotations.Test;

//Sprint 145
public class HSBCSwitch extends TestInitReference {
  @Test
  public void HSBCTest() throws Exception {
	  new PropertySearchUtil().propertyAddressSearch();
	  new HSBCDetailedPropertyReportUtil().offered();
	  new HSBCDetailedPropertyReportUtil().clickClose();
	  new HSBCDetailedPropertyReportUtil().propertyAddressSearch2();
	  new HSBCDetailedPropertyReportUtil().notOffered();
	  Thread.sleep(5000);
	  new HSBCDetailedPropertyReportUtil().propertyAddressSearch3();
	  new HSBCDetailedPropertyReportUtil().offered();
	  new HSBCDetailedPropertyReportUtil().clickClose();
	  Thread.sleep(5000);
	  new HSBCDetailedPropertyReportUtil().propertyAddressSearch4();
	  new HSBCDetailedPropertyReportUtil().offered();
  }
  
}
