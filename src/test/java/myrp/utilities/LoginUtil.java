package myrp.utilities;

import myrp.library.TestInitReference;

import static org.openqa.selenium.By.xpath;

import org.testng.annotations.Test;

@Test
public class LoginUtil extends TestInitReference {
	
  public void loginForm() throws Exception {
	  waitForElementPresent(xpath(loginButton_xp));
	  
  }
}
