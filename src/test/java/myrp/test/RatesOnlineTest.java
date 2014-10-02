package myrp.test;

import myrp.library.TestInitReference;
import myrp.utilities.PropertySearchUtil;
import myrp.utilities.RatesOnlineEstimatedValueReportUtil;

import org.testng.annotations.Test;

public class RatesOnlineTest extends TestInitReference {
	
  @Test
  public void ratesOnlineTest() throws Exception {
	  new PropertySearchUtil().propertyAddressSearch();
	  new RatesOnlineEstimatedValueReportUtil().clickAddtoCart();
	  new RatesOnlineEstimatedValueReportUtil().clickGetThisFree();
	  new RatesOnlineEstimatedValueReportUtil().checkInfoText();
	  new RatesOnlineEstimatedValueReportUtil().checkLabels();
	  new RatesOnlineEstimatedValueReportUtil().validationEmpty();
	  new RatesOnlineEstimatedValueReportUtil().validationSuburbField();
	  new RatesOnlineEstimatedValueReportUtil().validationInvalidSuburb();
	  new RatesOnlineEstimatedValueReportUtil().validSuburb();
	  new RatesOnlineEstimatedValueReportUtil().tick();
	  
  }
}
