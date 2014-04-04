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
import ui.develop.DevelopPage_AfterSignIn;
import ui.home.HomePage;
import ui.home.HomePage_AfterSignIn;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;
import util.TestWatcheRule;
/**
 * This class contains all tests on Deploy page (For Signed in User).
 * @author XiaoXue_Chen
 *
 */
public class ValidateDeployPage {
	private final static Logger logger = LoggerFactory.getLogger(ValidateDeployPage.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);

	static HomePage homePage = BasePage.getPage(HomePage.class);
	static HomePage_AfterSignIn homePageforUser = BasePage.getPage(HomePage_AfterSignIn.class);
	static SignInDialog loginDialog = BasePage.getPage(SignInDialog.class);

	DeployPage_AfterSignIn deployPage= BasePage.getPage(DeployPage_AfterSignIn.class);
	OnPremisesEnvironmentPage_AfterSignIn onPreEnvPage= BasePage.getPage(OnPremisesEnvironmentPage_AfterSignIn.class);
	
	@Test
	public void $161$CheckResendCredentials() throws InterruptedException{
		//
	}
	@Test
	public void $162$CheckLicenseAgreement() throws InterruptedException{
		deployPage.clickLicenseLink();
		Thread.sleep(5000);
		DriverUtil.saveCheckScreenshot("CB162");
	}
	@Test
	public void $163$CheckOnPremisePackage() throws InterruptedException{
		onPreEnvPage=deployPage.clickOnPremisesEnvBtn();
		assertEquals(driver.getTitle(),onPreEnvPage.PAGE_TITLE);
		
	}
	@Test
	public void $164$RegisterNewEvn() throws InterruptedException{
		DeployPage_AfterSignIn dp = deployPage.registerNewEnv("testname1", "http://www.w3.org/1999/xhtml", "Test On-premises evironments");
		
	}
	@Test
	public void $165$checkEdit() throws InterruptedException{
		
		
	}
	@Test
	public void $166$checkDeleteLink() throws InterruptedException{
		
		
	}
	@Test
	public void $167$checkReconnectLink() throws InterruptedException{
		
		
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

	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);

	@AfterClass
	public static void afterAllIsSaidAndDone() {

		driver.manage().deleteAllCookies();
		driver.quit();
		
	}
	

	


	@After
	public void tearDown() {
	
	}
		
	
	@Before
	public void setUp() throws InterruptedException {
		driver.get(deployPage.PAGE_URL);
		deployPage.isPresent();
		
		
	}



}