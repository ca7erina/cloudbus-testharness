package ui.develop;


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
import ui.deploy.OnPremisesEnvironmentPage_AfterSignIn;
import ui.home.HomePage;
import ui.home.HomePage_AfterSignIn;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;
import util.TestWatcheRule;
/**
 * This class contains all tests on DevelopPage (For Signed in User)
 * @author XiaoXue_Chen
 *
 */
public class ValidateDevelopPage {
	private final static Logger logger = LoggerFactory.getLogger(ValidateDevelopPage.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);

	static HomePage homePage = BasePage.getPage(HomePage.class);
	static HomePage_AfterSignIn homePageforUser = BasePage.getPage(HomePage_AfterSignIn.class);
	static SignInDialog signInDialog = BasePage.getPage(SignInDialog.class);
	DevelopPage_AfterSignIn developPage= BasePage.getPage(DevelopPage_AfterSignIn.class);

	
	@Test
	public void $158$checkVideo() throws InterruptedException{
		developPage.clickVideo();
		Thread.sleep(20000);
		DriverUtil.saveCheckScreenshot("CB-158");
	}
	@Test
	public void $159$checkDownload() throws InterruptedException{
		developPage.clickDownloadLink();
		Thread.sleep(5000);
		DriverUtil.saveCheckScreenshot("CB-159");
	}
	@Test
	public void $160$checkEULALink() throws InterruptedException{
		developPage.clickLicenseAgreenmentLink();
		Thread.sleep(5000);
		DriverUtil.saveCheckScreenshot("CB-160");
		
	}
	
	public static   HomePage_AfterSignIn getSignedIn() throws InterruptedException {
		signInDialog=homePage.OpenSignInDiv();	
		return signInDialog.loginAs(DataLoader.userEmail,DataLoader.userPwd);
		
	}
	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);
	
	@BeforeClass
	public static void beforeAllIsSaidAndDone1() throws InterruptedException {
		driver.get(homePage.PAGE_URL);
		homePageforUser=getSignedIn();
		homePageforUser.isPresent();
	}
	
	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@After
	public void tearDown() {
	
	}
		
	
	@Before
	public void setUp() throws InterruptedException {
		driver.get(developPage.PAGE_URL);
		developPage.isPresent();
		
		
	}



}