package myrp.utilities;

import myrp.library.TestInitReference;
import static org.openqa.selenium.By.xpath;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageFooterUtil extends TestInitReference{
	
	
	
	@Test
	public boolean verifyFacebookLink(){
		try{
			pass("Verifying Facebook Link started");
			Thread.sleep(1000);
			waitForElementPresent(xpath(btnFacebookF_xp));
			String link = getHref(xpath(btnFacebookF_xp));
			String facebookUrl = "https://www.facebook.com/rpdata";
			Assert.assertEquals(link, facebookUrl);
			pass("Verifying Facebook Link Succeeded");
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		
		fail("Verifying Facebook Link failed");
		return false;
	}
	
	
	@Test
	public boolean verifyTwitterLink(){
		try{
			pass("Verifying Twitter Link started");
			Thread.sleep(1000);
			waitForElementPresent(xpath(btnTwitterF_xp));
			String link = getHref(xpath(btnTwitterF_xp));
			String twitterUrl = "https://twitter.com/rpdata";
			Assert.assertEquals(link, twitterUrl);
			pass("Verifying Twitter Link Succeeded");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		fail("Verifying Twitter Link failed");
		return false;
	}
	
	@Test
	public boolean verifyYoutubeLink(){
		try{
			pass("Verifying Youtube Link started");
			Thread.sleep(1000);
			waitForElementPresent(xpath(btnYoutubeF_xp));
			String link = getHref(xpath(btnYoutubeF_xp));
			String youtubeUrl = "http://www.youtube.com/user/RPDataVideos";
			Assert.assertEquals(link, youtubeUrl);
			pass("Verifying Youtube link succeeded");
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		
		fail("Verifying Youtube Link failed");
		return false;
	}
	
	
	@Test
	public boolean verifyBlogLink(){
		try{
			pass("Verifying Blog Link started");
			Thread.sleep(1000);
			waitForElementPresent(xpath(btnBlogF_xp));
			String link = getHref(xpath(btnBlogF_xp));
			String blogUrl = "http://blog.rpdata.com/";
			Assert.assertEquals(link, blogUrl);
			pass("Verifying Blog link succeeded");
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}catch(AssertionError e){
			e.printStackTrace();
		}
		
		fail("Verifying Blog Link failed");
		return false;
	}
	
	
	
}
