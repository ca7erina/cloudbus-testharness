package ui.deploy;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.BasePage;
import ui.account.AccountDialog;
import ui.account.AccountInfoPage_AfterSignIn;
import ui.home.HomePage;
import ui.home.HomePage_AfterSignIn;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/**
 * This class contains tests at On Premiss Package Page(For Signed in User)
 * @author XiaoXue_Chen
 *
 */
public class ValidateOnPremissPackagePage {
	private final static Logger logger = LoggerFactory.getLogger(ValidateOnPremissPackagePage.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);

	static HomePage homePage = BasePage.getPage(HomePage.class);
	 static HomePage_AfterSignIn homePageforUser = BasePage.getPage(HomePage_AfterSignIn.class);
	static SignInDialog loginDialog = BasePage.getPage(SignInDialog.class);
	OnPremisesEnvironmentPage_AfterSignIn onPremisesEnvPage= BasePage.getPage(OnPremisesEnvironmentPage_AfterSignIn.class);

	
	@Test
	public void $36$test() {
		try{
		step1();
		step2();
		step3();
		step4();
		}catch (Exception e){
			logger.error("Validate on premissPackage page -> error",e);
		}
	}
	
	public void step1() {
		assertTrue(onPremisesEnvPage.isPresent());
		
	}
	
	public void step2() throws InterruptedException{
		onPremisesEnvPage.clickDownloadLinkA();
		Thread.sleep(5000);
		DriverUtil.saveCheckScreenshot("CB-36_1");
	}
	
	public void step3() throws InterruptedException{
		onPremisesEnvPage.clickDownloadLinkB();
		Thread.sleep(5000);
		DriverUtil.saveCheckScreenshot("CB-36_2");
	}
	
	public void step4() throws InterruptedException{
		onPremisesEnvPage.clickLicenseAgreeLink();
		Thread.sleep(5000);
		DriverUtil.saveCheckScreenshot("CB-36_3");
	}
	
	

	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);
	
	
	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@After
	public void tearDown() {

	}
		
	
	@Before
	public void setUp() throws InterruptedException {
		driver.get(onPremisesEnvPage.PAGE_URL);
		onPremisesEnvPage.isPresent();
				
	}


	@BeforeClass
	public static void beforeAllIsSaidAndDone() throws InterruptedException {
		driver.get(homePage.PAGE_URL);
		homePageforUser = getSignedIn();
		homePageforUser.isPresent();
	}
	
	public static HomePage_AfterSignIn getSignedIn() throws InterruptedException {
		loginDialog = homePage.OpenSignInDiv();
		return loginDialog.loginAs(DataLoader.userEmail,DataLoader.userPwd);

	}
}