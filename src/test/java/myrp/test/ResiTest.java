package myrp.test;

import myrp.library.TestInitReference;
import myrp.utilities.RESIHomeLoansEmailReportUtil;
import myrp.utilities.RESIHomeLoansFooterUtil;
import myrp.utilities.RESIHomeLoansGetFreePropertyUtil;
import myrp.utilities.RESIHomeLoansGetFreeSuburbUtil;
import myrp.utilities.RESIHomeLoansPaymentUtil;
import myrp.utilities.RESIHomeLoansPropertiesUtil;
import myrp.utilities.RESIHomeLoansSearchUtil;
import myrp.utilities.RESIHomeLoansSuburbsUtil;
import myrp.utilities.RESIHomeLoansUtil;

import org.testng.annotations.Test;

//Sprint 144
public class ResiTest extends TestInitReference {

	@Test(description = "RP Data Resi Home Loan Tabs, SLAS & Footer")
	public void resiTest() throws Exception {
		new RESIHomeLoansUtil().verifyHeading();
		new RESIHomeLoansUtil().verifyTabs();
		new RESIHomeLoansUtil().tabClick();
		new RESIHomeLoansUtil().verifySLAS();
		new RESIHomeLoansUtil().verifyPlaceholder();
		new RESIHomeLoansFooterUtil().verifyFooter();
		new RESIHomeLoansFooterUtil().verifyFooterLinks();
		new RESIHomeLoansFooterUtil().verifyfooterLogo();
	}
	
	@Test(description = "RP Data Resi Home Loan - Properties")
	public void resiTestProperties() throws Exception {
		new RESIHomeLoansUtil().verifySampleReportLink();
		new RESIHomeLoansPropertiesUtil().verifyReportInfo();
		new RESIHomeLoansPropertiesUtil().verifyReportPrice();
		new RESIHomeLoansUtil().searchBtn();
		new RESIHomeLoansUtil().CFAbtn();
		new RESIHomeLoansSearchUtil().searchAddress();
		new RESIHomeLoansFooterUtil().verifyFooter();
		new RESIHomeLoansFooterUtil().verifyFooterLinks();
		new RESIHomeLoansFooterUtil().verifyfooterLogo();
		new RESIHomeLoansUtil().verifySampleReportLink();
		new RESIHomeLoansEmailReportUtil().verifyAddress();
		new RESIHomeLoansEmailReportUtil().verifyButtons();
		new RESIHomeLoansEmailReportUtil().verifyButtonsLabel();
		new RESIHomeLoansEmailReportUtil().verifyPlaceholder();
		new RESIHomeLoansEmailReportUtil().verifyConfidence();
//		new RESIHomeLoansEmailReportUtil().verifyConfidenceHover(); //not yet working
//		new RESIHomeLoansEmailReportUtil().verifyConfidenceLevel(); //not yet working
//		new RESIHomeLoansEmailReportUtil().emailEmpty(); // TODO dev
//		new RESIHomeLoansEmailReportUtil().emailInvalid();
//		new RESIHomeLoansEmailReportUtil().purchaseBtn();
//		new RESIHomeLoansPaymentUtil().checkLabels();
//		new RESIHomeLoansEmailReportUtil().getFreeBtn();
//		new RESIHomeLoansGetFreePropertyUtil().verifyLabels();
//		new RESIHomeLoansGetFreePropertyUtil().cancelBtnEmpty();
	}
	
	@Test(description = "RP Data Resi Home Loan - Suburbs")
	public void resiTestSuburbs() throws Exception {
		new RESIHomeLoansSuburbsUtil().verifyReportInfo(); 		// Suburbs tab
		new RESIHomeLoansSuburbsUtil().verifyReportPrice();
		new RESIHomeLoansUtil().verifySampleReportLink();
		new RESIHomeLoansUtil().searchBtn();
		new RESIHomeLoansUtil().removeCFAbtn();
		new RESIHomeLoansFooterUtil().verifyFooter();
		new RESIHomeLoansFooterUtil().verifyFooterLinks();
		new RESIHomeLoansFooterUtil().verifyfooterLogo();
		new RESIHomeLoansSearchUtil().searchSuburb(); 			// To suburb landing screen
		new RESIHomeLoansUtil().verifySampleReportLink();
		new RESIHomeLoansGetFreeSuburbUtil().verifyAddress();
		new RESIHomeLoansGetFreeSuburbUtil().verifyPlaceholder();
		new RESIHomeLoansGetFreeSuburbUtil().getThisFree();
		new RESIHomeLoansGetFreeSuburbUtil().emailEmpty();
		new RESIHomeLoansGetFreeSuburbUtil().emailInvalid();
		new RESIHomeLoansGetFreeSuburbUtil().validEmail();
		new RESIHomeLoansGetFreeSuburbUtil().thankYouScreen();		// Thank you screen
		new RESIHomeLoansFooterUtil().verifyFooter();
		new RESIHomeLoansFooterUtil().verifyFooterLinks();
		new RESIHomeLoansFooterUtil().verifyfooterLogo();
	}
	
}
