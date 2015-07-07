package myrp.library;

public class RegressionObjectReference {

	public static String continueButton = "//*[@class='dynamicSaveCon']";
	
	//Verify Data Page	
	public static String propertyType = "//*[@id='propertyType']";
	public static String bedrooms = "//*[@id='bedrooms']";
	public static String bathrooms = "//*[@id='bathrooms']";
	public static String carSpaces = "//*[@id='carSpaces']";
	public static String carAccomodations = "//*[@id='carAccomodations']";
	public static String builtAbout = "//*[@id='builtAbout']";
	public static String additionalAbout = "//*[@id='additionalAbout']";
	public static String customerContacted = "//*[@id='customerContacted']";
	public static String landArea = "//*[@id='landArea']";
	public static String mainWall = "//*[@id='mainWallConstruction']";
	public static String livingArea  = "//*[@id='areaUnderMainRoof']";
	public static String roofConstructions = "//*[@id='roofConstructions']";
	public static String lastSaleDate = "//*[@id='lastSaleDate']";
	public static String lastSalePrice = "//*[@id='lastSalePrice']";
	public static String lotPlan = "//*[@id='lotPlanNumber']";
	public static String lga = "//*[@id='municipality']";
	public static String zoning = "//*[@id='zoningEffect']";
	public static String iHaveCalledTheContact = "//*[@id='customerContacted']";
	
	//Submission Page
	public static String lotPlan_submission = "(//input[@class='label evr_textbox'])[1]";
	public static String lga_submission = "(//input[@class='label evr_textbox'])[2]";
	public static String zoning_submission = "(//input[@class='label evr_textbox'])[3]";
	public static String propertyType_submission = "(//input[@class='label evr_textbox'])[4]";
	public static String lastSaleDate_submission = "(//input[@class='label evr_textbox'])[5]";
	public static String lastSalePrice_submission = "(//input[@class='label evr_textbox'])[6]";
	public static String mainWall_submission = "//*[@id='mainWall']";
	public static String roofConstructions_submission = "//*[@id='roofCon']";
	public static String carAccomodations_submission = "(//input[@class='label evr_textbox'])[9]";
	public static String builtAbout_submission = "(//input[@class='label evr_textbox'])[10]";
	public static String additionalAbout_submission = "(//input[@class='label evr_textbox'])[11]";
	public static String modalBoxSuccesfullSubmission = "(//div[@id='mboxContent'])[2]//*[@class='info']";
	public static String yesButtonValidationException = "(//*[@id='mboxContent']//*[@id='yesbutton'])[2]";//You have selected one or more sales that have a sales price that greater than +/- 15%
	public static String sitePhoto = "//*[@id='sitephoto']";
	public static String assessmentValueSection = "(//*[@class='sectionHeading pLeft_30'])[1]";
	
	//Submission Page > Sales Evidence Area
	public static String se_address = "(//*[@class='fontStyle_14 lineHeight_25']//tr)[11]//*[@class='salesData'][2])";
	
	//Submission Page > Assessment Value Section 
	public static String contractVal = "(//*[@id='form-valuepage']//*[@class='form_label fontStyle_14 lineHeight_31'])[1]";
	public static String assessmentValueLabel = "(//*[@id='form-valuepage']//*[@class='form_label fontStyle_14 lineHeight_31'])[4]";
	public static String ihavecalledTheContactLabel = "(//*[@id='form-valuepage']//*[@class='form_label fontStyle_14 lineHeight_31'])[6]";
	public static String assessmentCommentsLabel = "(//*[@id='form-valuepage']//*[@class='form_label fontStyle_14 lineHeight_31'])[7]";
	public static String customerContactSubmission = "//*[@id='customerContactedSubmission']";
	
	//Sales Evidence
	public static String logoSalesResult = "//*[@class='agentAdLogo']";
	public static String addRemoveButton = "//div[@class='button addRemoveProperty']";
	public static String searchResultContainer = "//*[@id='search_data_container']";
	public static String comments = "//*[@class='comments']";
	public static String inferior = "//span[text()='Inferior']";
	public static String comparble = "//span[text()='Comparable']";
	public static String superior = "//span[text()='Superior']";
	public static String shortlistContainer = "//*[@id='search_shortlist_data_container']";
	public static String addressShortList = "//*[@id='search_shortlist_data_container']//div[@class='address streetMapAddress']";
	public static String addressSerchResult = "//*[@id='search_data_container']//div[@class='address streetMapAddress']";
	public static String photoOnSearchResult = "//*[@id='search_data_container']//*[@class='comparablePhotos evrButtonStyle']";
	public static String photoOnShortList = "//*[@id='search_shortlist_data_container']//*[@class='comparablePhotos evrButtonStyle']";
	public static String photoGalleryModal = "(//*[@id='mboxContent'])[2]";
	public static String setAsDefaultImageContainter = "(//*[@id='mboxBody'])[2]";
	public static String comparbilityButtonContainer = "//*[@class='attributes']";
	public static String labelSaleTypeSearchResult = "//*[@id='search_data_container']//*[text()='Sale Type: ']";
	public static String labelSaleTypeShortList = "//*[@id='search_shortlist_data_container']//*[text()='Sale Type: ']";
	
}