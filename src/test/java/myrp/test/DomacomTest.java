package myrp.test;

import myrp.library.ReadXmlData;
import myrp.library.TestInitReference;
import myrp.utilities.DomacomHomepageBannerUtil;
import myrp.utilities.DomacomHomepageLogoUtil;
import myrp.utilities.DomacomHomepageUtil;
import myrp.utilities.DomacomPRTabBannerUtil;
import myrp.utilities.DomacomPRTabLocalExpertsUtil;
import myrp.utilities.DomacomRSTabUtil;
import myrp.utilities.HomepageBannerUtil;
import myrp.utilities.HomepageTilesUtil;
import myrp.utilities.PropertySearchUtil;

import org.testng.annotations.Test;

public class DomacomTest extends TestInitReference {
	//Sprint 142 & 143
	ReadXmlData rxml = new ReadXmlData();
	
  @Test(description = "Test if Domacom logo is present")
  public void domacomTest() throws Exception {
	  if(url.contains("domacom")) {
		  new DomacomHomepageLogoUtil().checkChannelLogo();
		  new DomacomHomepageUtil().homepageTiles();
		  new DomacomHomepageBannerUtil().homepageBanner();
		  new PropertySearchUtil().propertyAddressSearch();
		  new DomacomPRTabBannerUtil().propertyServicesBanner();
		  new DomacomPRTabLocalExpertsUtil().propertylocalExperts();
		  new DomacomRSTabUtil().reportsAndServices();
	  } else {
		  new HomepageBannerUtil().homepagePropertyServicesBanner();
		  new HomepageTilesUtil().homepageTiles();
		  new PropertySearchUtil().propertyAddressSearch();
	  }
  }
  
}
