package myrp.test;

import myrp.library.TestInitReference;
import myrp.utilities.HomePageFooterUtil;
import myrp.utilities.PropertyUnavailableUtil;
import myrp.utilities.SeoRelatedTestUtil;

import org.testng.annotations.Test;

public class RegressionTest extends TestInitReference{
	private int testCount = 0;
	private int successCount = 0;
	
	
	
	
	//Property Unavailable Tests
	@Test
	private void PropertUnavailableTest(){
		
		if(new PropertyUnavailableUtil().verifySuburbLink()){
			successCount++;
			testCount++;
		}
		
		if(new PropertyUnavailableUtil().verifySuburbRedirection()){
			successCount++;
			testCount++;
		}
		
	}
	
	//SEO related tests
	@Test
	private void SeoRelatedTest(){
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchPropertyTab()){
			successCount++;
			testCount++;
		}
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchStreetTab()){
			successCount++;
			testCount++;
		}
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchSuburbTab()){
			successCount++;
			testCount++;
		}
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchSuburbMap()){
			successCount++;
			testCount++;
		}
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchKeyStats()){
			successCount++;
			testCount++;
		}
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchLocalExpertsTab()){
			successCount++;
			testCount++;
		}
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchStreetWithLessThanFourBorderingStreet()){
			successCount++;
			testCount++;
		}
		
		if(new SeoRelatedTestUtil().verifyRelatedSearchSuburbWithoutRelatedSearch()){
			successCount++;
			testCount++;
		}
		
	}
	
	//Home Page Footer 
	@Test
	private void HomePageFooterTest(){
		if(new HomePageFooterUtil().verifyFacebookLink()){
			successCount++;
			testCount++;
		}
		
		if(new HomePageFooterUtil().verifyTwitterLink()){
			successCount++;
			testCount++;
		}
		
		if(new HomePageFooterUtil().verifyYoutubeLink()){
			successCount++;
			testCount++;
		}
		
		if(new HomePageFooterUtil().verifyBlogLink()){
			successCount++;
			testCount++;
		}
	}
	
	
	
	
	
}
