package myrp.test;

import myrp.library.FunctionReference;
import myrp.utilities.HomepageBannerUtil;
import myrp.utilities.HomepageTilesUtil;

import org.testng.annotations.Test;

public class DefaultTest extends FunctionReference {

	@Test(description = "RP Data Homepage Test")
	public void defaultTest() throws Exception {
		new HomepageTilesUtil();
		new HomepageBannerUtil();
	}
}
