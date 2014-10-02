package myrp.library;

public class EVRObjectReference {

	// Input JobOrder EVR
	public static String jobOrderInput = "//input[@id='orderNumber']";
	public static String valEx = "(//*[@id='group1'])[1]";
	public static String valExNz = "(//*[@id='group1'])[2]";
	public static String vms = "(//*[@id='group1'])[3]";
	public static String buttonAu = "//input[@id='submit']";
	public static String logAsNonValuer = "//*[@id='chkUserType']";
	public static String readonlyPopUp = "//*[@id='mynotification']";

	// EVR NAV
	public static String overview = "//div[@id='evr-33']";
	public static String verifyData = "//div[@id='evr-34']";
	public static String salesEvidence = "//div[@id='evr-36']";
	public static String riskAnalysis = "//div[@id='evr-37']";
	public static String submission = "//div[@id='evr-38']";
	public static String escalate = "//div[@id='evr-35']";
	public static String saveclose = "//*[@id='menuSaveAndCloseBtn']";

	// EVR NZ
	public static String overview_nz = "//div[@id='evr-66']";
	public static String verifyData_nz = "//div[@id='evr-67']";
	public static String salesEvidence_nz = "//div[@id='evr-68']";
	public static String riskAnalysis_nz = "//div[@id='evr-69']";
	public static String submission_nz = "//div[@id='evr-70']";
	public static String escalate_nz = "//div[@id='evr-71']";

	// NZ Overview
	public static String customerCall = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td/table/tbody/tr[1]/td[3]/a";
	public static String customerCalldiv = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td/table/tbody/tr/td[1]/span";
	public static String driveBy = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td/table/tbody/tr[3]/td[3]/a";
	public static String driveBydiv = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[8]/td/table/tbody/tr/td[1]/span";
	public static String fullMarketVal = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td/table/tbody/tr[5]/td[3]/a";
	public static String fullMarketdiv = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[11]/td/table/tbody/tr/td[1]/span/p";
	public static String cancellation = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td/table/tbody/tr[7]/td[3]/a";
	public static String cancellationdiv = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[14]/td/table/tbody/tr/td[1]/span";
	public static String startAssesment = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[5]/td/table/tbody/tr[1]/td/div/div";

	// AUS modal save message alert
	public static String yesButtonSave = "(//*[@id='yesbutton'])[3]";
	public static String noButtonSave = "(//*[@id='nobutton'])[3]";

	// AUS Overview
	public static String shortForm = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td/table/tbody/tr[5]/td[3]/a";
	public static String plusButton = "(//*[@id='zoomIn'])[4]";
	public static String minusButton = "(//*[@id='zoomOut'])[4]";

	// AUS Verify Data
	public static String spOtherText = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/form/div/table/tbody/tr[11]/td/table/tbody/tr[5]/td/textarea";
	public static String devPermits = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[28]/td/div";
	public static String propertyInfoHeaderAU = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/form/div/table/tbody/tr[3]/td/table/tbody/tr/td/span";
	public static String propertyInfoHeaderNab = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/form/div/table/tbody/tr[3]/td/table/tbody/tr/td/span";
	public static String additionalInformation = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/form/div/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody";
	public static String landUseAfterZoning = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/form/div/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[10]/td/table/tbody/tr/td/ul";
	public static String loanpurpose = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2])[1]";
	public static String loanpurposeEditable = "//*[@id='loanPurpose']";
	public static String contractOrMarketValue = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/form/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[1]";
	public static String contractDate = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[5]/td/label";
	public static String lenderCommentlabel = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[2]/td/table/tbody/tr[7]/td/label";
	public static String lastSaleDateAu = "//*[@id='lastSaleDate']";
	public static String monthDatePicker = "//*[@class='ui-datepicker-month']";
	public static String yearDatePicker = "//*[@class='ui-datepicker-year']";
	public static String dayDatePicker = "//*[@class='ui-state-default']";
	public static String doneDatePicker = "/html/body/div/div[2]/button[2]";
	public static String validationModal = "/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div";
	public static String saveButtonVerData = "//*[@id='verifydata_save_continue']";
	public static String lotplan = "Waitingn FOR PATH";
	public static String contractValueField = "//*[@id='contractVal']";
	public static String contractValueCommentField = "//*[@id='contractValueComments']";

	// AUS Risk Analysis
	public static String saveContinueRAAus = "//*[@id='submit']";

	// NZ Verify Data
	public static String customerInformation = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/table/tbody/tr/td/span";
	public static String cutomerInformatonHeader = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/span)[1]";
	public static String lenderInformation = "//*[@id='verifyDataForm']/div/table/tbody/tr[1]/td/table/tbody/tr/td/span";
	public static String loanPurpose = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/label)[1]";
	public static String lenderComment = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/label)[2]";
	public static String certTitleRef = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[5]/td/table/tbody/tr/td/label)[1]";
	public static String legalDescription = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[5]/td/table/tbody/tr/td/label)[2]";
	public static String territorialAuthority = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[5]/td/table/tbody/tr/td/label)[3]";
	public static String zoningTitle = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[5]/td/table/tbody/tr/td/label)[4]";
	public static String titleDetails = "//*[@id='verifyDataForm']/div/table/tbody/tr[4]/td/table/tbody/tr/td/span";
	public static String propertySummary = "//*[@id='verifyDataForm']/div/table/tbody/tr[7]/td/table/tbody/tr/td/span";
	public static String propertyType = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[8]/td/table/tbody/tr[2]/td/select";
	public static String bedrooms = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[8]/td/table/tbody/tr[5]/td/table/tbody/tr/td/select";
	public static String bathrooms = "//select[@id='bathrooms']";
	public static String carSpaces = "//select[@id='carSpaces']";
	public static String carAccomodations = "//select[@id='carAccomodations']";
	public static String lastSaleDate = "//input[@id='lastSaleDate']";
	public static String lastSalePrice = "//input[@id='lastSalePrice']";
	public static String mainWallConstruction = "//select[@id='mainWallConstruction']";
	public static String roofConstructions = "//select[@id='roofConstructions']";
	public static String specialFeature = "//*[@id='verifyDataForm']/div/table/tbody/tr[10]/td/table/tbody/tr/td/span";
	public static String services = "//*[@id='verifyDataForm']/div/table/tbody/tr[13]/td/table/tbody/tr/td/span";
	public static String externalImprovements = "//*[@id='verifyDataForm']/div/table/tbody/tr[16]/td/table/tbody/tr/td/span";
	public static String propertyInformation = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/div";
	public static String mboxContentModal = "//*[@id='mboxContent']";
	public static String onTheMarket = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div";
	public static String closeModal = "//*[@id='cboxClose']/img";
	public static String propertyImagery = "(//*[@id='sitephoto'])[1]";
	public static String aerialPhoto = "//*[@id='arealphoto']";
	public static String topoMap = "(//*[@id='sitephoto'])[2]";
	public static String streetMap = "(//*[@id='sitephoto'])[3]";
	public static String streetViewNz = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[23]/td/div";
	public static String verifyDataSaveContinue = "//*[@id='verifydata_save_continue']";
	public static String streetViewAu = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[24]/td/div";
	public static String zoning = "//*[@id='zoningEffect']";
	public static String ihaveCalled = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/form/div/table/tbody/tr[18]/td/ul/li/input";
	public static String propertyInformatonOnTop = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td)[1]";
	public static String propertyImageryonSide = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td";
	public static String addPhoto = "//*[@id='originalFile']";
	public static String preloader = "//*[@id='preloader']";
	
	// NZ Verify Data propertyImager Modal
	public static String chooseFile = "//*[@id='originalFile']";
	public static String submit = "//*[@id='submitCanvasPhoto']";
	public static String sitePhotoOnIM = "(/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div)[1]";
	public static String googleMapOnIM = "(/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div)[2]";
	public static String galleryOnIM = "(/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div)[3]";

	// NZ Sales Evidence Page
	public static String searchLabel = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td/span)[1]";
	public static String searchbyFilterNZ = "//*[@id='refineSearchFilterTab']";
	public static String searchbyAddressNZ = "//*[@id='singleLineSearchTab']";
	public static String searchbyQPID = "//*[@id='qpidSearchTab']";

	// NZ Sales Evidence >Search by Filter
	public static String dropDownlastSaleDate = "//*[@id='lastSaleDate']";
	public static String searchButtonFilter = "//*[@id='refineFilter']";
	public static String searchResultNZ = "//*[@id='propertyList-main-container']/div[3]/table/tbody/tr[3]/th/div[1]";
	public static String propertyPhotoNZ = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/div[3]/table/tbody/tr[3]/th/div[3]/div/img)[1]";
	public static String mBoxSearchFilter = "(//*[@id='mboxContent'])[2]";
	public static String photoInMBox = "//*[@id='tableImage']";
	public static String specificDateFrom = "//*[@id='lastSaleDateFrom']";
	public static String specificDateTo = "//*[@id='lastSaleDateTo']";
	public static String capitalValFrom = "//*[@id='capitalValueFrom']";
	public static String capitalValTo = "//*[@id='capitalValueTo']";

	public static String floorAreaFrom = "//*[@id='floorAreaFrom']";
	public static String floorAreaTo = "//*[@id='floorAreaTo']";
	public static String buildingAgeFrom = "//*[@id='buildingAgeFrom']";
	public static String buildingAgeTo = "//*[@id='buildingAgeTo']";
	public static String radiusList = "//*[@id='radius']";
	public static String bedroomsList = "//*[@id='bedroomText']";
	public static String bathroomList = "//*[@id='bathroomText']";
	public static String carspaceList = "//*[@id='carSpaceText']";
	public static String boxHouse = "//*[@id='houses']";
	public static String boxUnits = "//*[@id='units']";
	public static String boxLand = "//*[@id='land']";
	public static String landSizeMin = "//*[@id='minLandSize']";
	public static String landSizeMax = "//*[@id='maxLandSize']";
	public static String lastSalePriceMin = "//*[@id='minPrice']";
	public static String lastSalePriceMax = "//*[@id='maxPrice']";
	public static String resetFilters = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td/div/div[2]";
	public static String salesEvidenceListNZ = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/div[3]/table/tbody/tr[7]/th/table/tbody/tr/td/div";
	public static String returnSearchResultNZ = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/span/a";

	// AUS Sales Evidence
	public static String searchByRadius = "//*[@id='sbRadiusId']";
	public static String searchByAddress = "//*[@id='sbAddressId']";
	public static String dropDownlastSaleDateAu = "//*[@id='lastSaleDate']";
	public static String dropDownRadiusAu = "//*[@id='radiusField']";
	public static String dropDownLastSalePriceMin = "//*[@id='txt_lastSalePriceMin']";
	public static String dropDownLastSalePriceMax = "//*[@id='txt_lastSalePriceMax']";
	public static String dropDownLandSizeMin = "//*[@id='txt_landSizeMin']";
	public static String dropDownLandSizeMax = "//*[@id='txt_landSizeMax']";
	public static String targetSurburb = "//*[@id='targetSuburb']";
	public static String checkboxHouse = "//*[@id='radio_House']";
	public static String checkboxUnits = "//*[@id='radio_Units']";
	public static String checkboxVacantLand = "//*[@id='radio_VLand']";
	public static String checkboxConfirmSale = "//*[@id='radio_VGSale']";
	public static String resetRadiusFilter = "//html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[4]/td/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr[6]/td/div[2]";
	public static String searchButtonRadius = "//*[@id='btnRadiusRP']";
	public static String salesEvidenceListAU = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/span/ul/li[2]/a";
	public static String returnSearchResultAU = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/table/tbody/tr/td/table/tbody/tr/td[2]/span/ul/li[2]/a";
	public static String singleLineAddressInSearchbyAddress = "//*[@id='singleLineSearch']";
	public static String searchRPbuttonInSearchbyAddress = "//*[@id='btnAddressRP']";
	public static String saveAndContinueSE = "//*[@id='saveAndContBtn']";
	public static String salesShortListTab = "//*[@id='salesShortList']";
	public static String salesResultTab = "//*[@id='salesResults']";
	public static String addressResultinAddingProperty = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div[2]/table/tbody/tr/td/div/div/div[2]/div";
	public static String comparabilityButton = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[3]/div/div/table/tbody/tr[3]/td/div/div/div[3]/div[2]";
	public static String refinedSearchResultModal = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[3]/div";
	public static String saleTypeSearchList = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div[2]/ul/li[3]/div[2]";
	public static String saleTypeShortList = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div[2]/table/tbody/tr/td/div/div/div[2]/ul/li[3]/div[2]";
	public static String saleDefaultImage = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div/table/tbody/tr[3]/td/div/div/div/img)[1]";
	public static String saleShortListDefaultImage = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/div/table/tbody/tr[7]/td/div/div[2]/div/div[2]/table/tbody/tr/td/div/div/div/img)[1]";
	public static String galleryModalInSearchResult = "(/html/body/table/tbody/tr[2]/td/div/table/tbody/tr/td[2])";

	// EVR UI NAB COPY FORWARD

	public static String copyForwardButton = "//*[@id='btnCopyForwardModal']";
	public static String importFromPreviousValuationModal = "//*[@id='mboxHeader']";
	public static String categoriesOnCopyForwardModal = "";
	public static String categorySalesEvidence = "";
	public static String categoryRiskAnalysis = "";
	public static String categoryAssessmentComment = "";
	public static String categorySitePhoto = "";
	public static String backButtonInCopyForwardModal = "(//*[@class='buttonCopyForwardBackStyleRedonly'])[3]";
	public static String okButtonInCopyForwardModal = "(//*[@class='buttonCopyForwardButtons'])[3]";
	public static String jobIdTxtFieldInCopyForwardModal = "";
	public static String backButtonInImportDataModal = "";
	public static String importDataModal = "";

	// AUS Sales Evidence Search Result
	public static String propertyPhotoAU = "//*[@id='search_data_container']/div[1]";
	public static String sortByData = "//*[@id='sortByDropDown']";
	public static String sortByPage = "//*[@id='pageSizeDropDown']";

	// NZ Sales Evidence Search Result
	public static String dataList = "//*[@id='sortData']";
	public static String pageList = "//*[@id='noDataPerPage']";
	public static String sortingTD = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/div[3]/table/tbody/tr/th/table/tbody/tr/td[2]";
	public static String addRemoveButton = "(//*[@id='addRemoveProperty'])[1]";
	// public static String DefaultImage =// "(//*[@id="row-DefaultImage"]/div[1]/img[1]";

	// NZ Sales Evidence Search List Result
	public static String rateNZ = "//*[@class='rate content_text']";
	public static String commentsNZ = "(//*[@class='comments'])[1]";
	public static String saveAndContinue = "//*[@id='saveAndCont']";

	// RISK ANALYSIS PAGE AUS
	public static String riskAnalysisListAUS = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/table/tbody/tr/td";

	// RISK ANALYSIS PAGE NZ
	public static String riskAnalysisList = "//*[@id='riskAnalysisForm']/table[1]/tbody/tr/td";
	public static String commentLocaton = "//*[@id='commentLocations']";
	public static String commentLand = "//*[@id='commentLand']";
	public static String commentEnvironmental = "//*[@id='commentEnvironmental']";
	public static String commentImprovements = "//*[@id='commentImprovements']";
	public static String commentReduced = "//*[@id='commentReduced']";
	public static String commentMarketVolatility = "//*[@id='commentMarketVolatility']";
	public static String commentLocal = "//*[@id='commentLocal']";
	public static String commentMarketSegment = "//*[@id='commentMarketSegment']";
	public static String saveAndContinueRiskAnalysis = "//*[@id='submit']";

	// Submission PAGE NZ
	public static String sitePhoto = "//*[@id='sitephoto']";
	public static String assesmentValue = "//*[@id='midPoint']";
	public static String submitAssessmentNZ = "//*[@id='submitAssessment']";

	// Escalation CAncel PAGE NZ
	public static String mboxContentEscalation = "//*[@id='mboxContent']";
	public static String escalateButton = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[5]/div[2]";
	public static String cancelButton = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[5]/div";
	public static String commentBox = "(//*[@id='commentBox'])[3]";

	// Escalation CAncel PAGE NZ > inside moxContentEscalation
	public static String yesButton = "//*[@id='optionYes']";
	public static String noButton = "//*[@id='optionNo']";
	public static String cancellationComment = "(//*[@id='cancellationComment'])[3]";
	public static String cancelButtonOnCancellation = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[4]/div";
	public static String confirmEscallation = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/div[2]";
	public static String cancelEscallation = "//*[@id='mboxBody']/div/div[2]/div[1]";
	public static String cancelThisRequest = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[4]/div[2]";

	// Submission Page EVR
	public static String submitAssessment = "//div[@id='submitAssessment']";
	public static String validationError = "//html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[3]/div";
	public static String cbInspected = "//input[@name='photoInspectionCb1']";
	public static String buttonOk = "//html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/div";
	public static String buttonSE005 = "//html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[3]/div";
	public static String optionDangerous = "//option[@value='DANGEROUS']";
	public static String dropDownReason = "//select[@id='reasonForPhoto']";
	public static String editPropertyDetails = "//*[@id='editLinkPropertyDetail']";
	public static String editPopMessageNo = "(//div[@id='nobutton'])[4]";
	public static String editPopMessageYes = "//div[@id='yesbutton']";
	public static String messageHasEdited = "//*[@id='mboxHeader']";
	public static String standardAssessment = "(//*[@id='assessmentType'])[1]";
	public static String inOfficeAssesment = "(//*[@id='assessmentType'])[3]";
	public static String onSiteAssessment = "(//*[@id='assessmentType'])[2]";
	public static String editSalesEvidence = "(//*[@id='assessmentType'])[3]";
	public static String propertyPhotoAu = "//*[@id='sitephoto']";
	public static String assessmentValueDiv = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/table/tbody/tr/td/div/table/tbody/tr/td)[1]";
	public static String assessmentValueDivNab = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[12]/td/form/table/tbody/tr/td/div/table/tbody/tr/td)[1]";
	public static String propertyDetailDiv = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[3]/form/div/div";
	public static String assessmentValInside = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td/form/table/tbody/tr/td/div/table/tbody/tr/td";
	public static String assessmentValueInsideNab = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[12]/td/form/table/tbody/tr/td/div/table/tbody/tr/td";
	public static String customerContactedinSubmission = "//*[@id='customerContactedSubmission']";
	public static String photoCheckBOX = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[12]/td/form/div[3]/table/tbody";

	// //Change Address EVR
	public static String propertyAddress = "//*[@id='nab_property_address']";
	public static String changeAddressModalVerData = "/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div";
	public static String changeAddressModalSalesEvidenceorSubmissionorChangeAddress = " /html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div";
	public static String backButtonChangeAddressMOdal = "(//*[@id='back'])[3]";
	public static String removeMatchButtonChangeAddressModal = "(//*[@id='removeMatch'])[3]";
	public static String removeMatchValidationMessageVerData = "/html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]";
	public static String removeMatchValidationMessageSalesEvidenceorSubmissionorChangeAddres = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]";
	public static String changeAddressButton = "(//*[@id='changeAddress'])[3]";
	public static String searchbyAddress_ChangeAddress = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table";
	public static String singleLineSearchChangeAddress = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div/div/table/tbody/tr/td/span/input)[1]";
	public static String singleLineSearchParcelChangeAddress = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div/div/table/tbody/tr/td/span/input)[2]";
	public static String cantFindAddress = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div/div/table/tbody/tr/td[2]/div[2]";
	public static String cantFindAddressForm = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div";
	public static String suburbCantfindAdd = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div/div[3]/table/tbody/tr/td/table/tbody/tr[6]/td/input";
	public static String backtoSingleLine = "(/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div/div[3]/table/tbody/tr/td[3]/table/tbody/tr/td[3]/div)[1]";
	public static String usedTypedAddress = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/form/div/div[2]/div/div[3]/table/tbody/tr/td[3]/table/tbody/tr[3]/td[3]/div";
	public static String discardPropertyData = "WAIT FOR PATH";
	public static String keepPropertyData = "WAIT FOR PATH";
	public static String SLASChangeAddress = "//*[@id='singleLineSearch']";
	public static String searchRPbutton = "(//*[@id='btnAddressRP'])[1]";
	public static String validationModalSearchRP = "//*[@id='bsgServiceInfo']";
	public static String okButtonForValidation = "(//*[@id='evrExceptionButton'])[4]";
	public static String odometer = "//*[@id='odometer']";
	public static String submitInSubmissionPage = "//*[@id='submitChangeAdd']";
	public static String validationErrorInSubmitAssessment = "/html/body/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div[2]";

	// Search Result in Nab Address CHange

	public static String searchResultChangeAddress = "//*[@id='search_data_container']";
	public static String selectThisPropertyAmmendmenModal = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div";
	public static String modalUsedTypeAddress = "NO PATH AVALABLE WAITING FOR DEPLOYMENT";
	public static String BackSelectThisPropertyAmmendmenModal = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[5]/div";
	public static String changeAddressButtonAmmendmentModal = "(//*[@id='saveChangeAddress'])[3]";

	// Can't find address form
	public static String unitOrLot = "//*[@id='salExUnit']";
	public static String number = "//*[@id='salExNumber']";
	public static String street = "//*[@id='salExStreet']";
	public static String type = "//*[@id='salExType']";

	// Submission Page input text field
	public static String riskComments = "//*[@id='riskComments']";
	public static String buildVal = "//*[@id='asses_buildVal']";
	public static String assesLand = "//*[@id='asses_land']";
	public static String assessComments = "//*[@id='assessmentComments']";

	// VALEX NZ
	public static String usernameValexNz = "//*[@id='username']";
	public static String passwordValexNz = "//*[@id='password']";
	public static String loginButtonValNz = "//*[@id='login']";
	public static String inputJobIdNz = "//*[@id='job_id']";
	public static String submitJobId = "/html/body/div/div[5]/div[4]/form/input[2]";
	public static String serviceTypelabel = "/html/body/div[5]/div[2]/table/tbody/tr/td/div/table/tbody/tr/th";

	// VALEX AU
	public static String submitJodIDAu = "//*[@id='goto_job']";

}