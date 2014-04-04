package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.account.ValidateAccountDialog;
import ui.account.ValidateAccountInfoPage;
import ui.contact.ValidateContactPageAsGuest;
import ui.deploy.ValidateOnPremissPackagePage;
import ui.develop.ValidateDevelopPage;
import ui.home.ValidateHomePageAsGuest;
import ui.home.ValidateHomePageAsSignedUser;
import ui.integrate.ValidateIntegratePageAsGuest;
import ui.integrate.ValidateIntegratePageAsSignedUser;
import ui.learn.ValidateLearnPage;
import ui.price.ValidatePricingPage;
import ui.register.ValidateRegisterDialogAsGuest;
import ui.register.ValidateWhyRegisterPageAsGuest;
import ui.signIn.ValidateSignInDialogAsGuest;
import util.report.ReportUtil;

/**
 * This test set contains 2 test suite.
 * 
 * @author XiaoXue_Chen
 * 
 */
public class TestSet {
	private final static Logger logger = LoggerFactory.getLogger(TestSet.class);
	long currentTime = System.currentTimeMillis();
	Result result;
	static int runCount =0 ;
	static int failCount=0 ;
	static int ignoreCount=0 ;
	static long duration=0;
	
	
	synchronized public void updateCount(){
		runCount += result.getRunCount();
		failCount += result.getFailureCount();
		ignoreCount += result.getIgnoreCount();
		duration+=result.getRunTime();
	}
	
	@Test
	public void testAsSignedUser() {
		result = org.junit.runner.JUnitCore.runClasses(
				ValidateIntegratePageAsSignedUser.class,
				ValidateAccountDialog.class,ValidateAccountInfoPage.class,				
				ValidateHomePageAsSignedUser.class,ValidateDevelopPage.class,
				ValidateOnPremissPackagePage.class,
				ValidatePricingPage.class, ValidateIntegratePageAsGuest.class
				);	
		updateCount();
		logger.info("testAsSignedUser -> run count:" + runCount + "    run failure:" + failCount+ "    ignore count:" + ignoreCount);
	}
	
	@Test
	public void testAsGuest() {
		result = org.junit.runner.JUnitCore.runClasses(
				ValidateSignInDialogAsGuest.class, ValidateRegisterDialogAsGuest.class,
				ValidateLearnPage.class, ValidateHomePageAsGuest.class,
				ValidateWhyRegisterPageAsGuest.class,ValidateContactPageAsGuest.class
				);
		updateCount();
		logger.info("testAsGuest ->run count:" + runCount + "    run failure:" + failCount+ "    ignore count:" + ignoreCount);
	}
	
	@Before
	public void setup() {
		
	}
	@BeforeClass
	public static void beforeAllIsSaidAndDone() throws InterruptedException {
		ReportUtil.getReport();
	}
	
	@After
	public void tearDown() {

	}
	
	@AfterClass
	public static void afterAllIsSaidAndDone() {
		ReportUtil.updateValuePrepare(runCount, failCount, duration);
	}

}
