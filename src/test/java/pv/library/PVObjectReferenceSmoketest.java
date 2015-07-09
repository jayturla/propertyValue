package pv.library;

public class PVObjectReferenceSmoketest {

	public static String headerNav = "//*[@class='main']";
	public static String slasBox = "id('propertysearch')";
	public static String statNat = "//*[@class='home-graph']";
	public static String topSuburbs = "//*[@class='top-suburbs']";
	
	//HeaderZones
	public static String verifyLogin = "//*[@class='login']";
	public static String clickLogin = "//*[@class='logged-out'][1]";
	public static String verifyLoginPage = "//*[@class='form']";
	public static String userName ="//*[@id='userName']";
	public static String password = "//*[@id='password']";
	public static String loginSite = "//*[@class='form']//button";
	public static String verifyLoginName = "//*[@class='login']";
	public static String clickMenu = "(//*[@class='login']//a)[1]";
	public static String clickLogOut = "(//*[@class='login']//a)[5]";
	public static String selectPropety = "//*[@class='home-slas-def']//ul//li";
	public static String verifyPropertyInsights = "(//*[@class='wbdRichText']//h2)[1]";
	public static String clickAddtoWatchList = "(//*[@class='hidden-xs']//li//a)[1]";
	public static String goToWatclist = "(//*[@class='login']//a)[3]";
	public static String verifyifPropertyisAddedtoWatchlist = "//*[@class='row'][3]";
	public static String checkWatchlist = "//*[@class='DivWidget suburb watchlist']";
	public static String verifyStreetInsights = "//*[@class='col-sm-12 col-md-10']";
	public static String clickLogo = "//*[@class='logo']//a";
	public static String verifySuburbInsights = "//*[@class='col-sm-12 col-md-10']";
	public static String viewSuburbProfile = "//*[@class='default-btn blue-btn hidden-xs hidden-sm']";
	public static String forgottenPassword = "(//*[@class='col-xs-12 col-sm-6 col-md-6 col-lg-6']//a)[1]";
	public static String emailForgottenPassword = "//*[@id='resetPassword_input']";
	public static String verifyResetPW = "//*[@class='user-sign']";
	public static String resetFP = "//*[@id='resetPassword_submit']";
	public static String advanceSearch = "(//*[@class='active']//button)[15]";

}