package ui.account;


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
import ui.home.HomePage;
import ui.home.HomePage_AfterSignIn;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/**
 * This Test constitutes  all test cases happens with elements on home
 * page.(For Signed in User)
 * In Testlink: Cloud Bus-Validate Home Page As Guest
 * 
 * @author XiaoXue_Chen
 * 
 */
public class ValidateAccountDialog {
	private final static Logger logger = LoggerFactory.getLogger(ValidateAccountDialog.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	static HomePage homePage = BasePage.getPage(HomePage.class);
	static SignInDialog loginDialog = BasePage.getPage(SignInDialog.class);
	static HomePage_AfterSignIn homePageforUser = BasePage.getPage(HomePage_AfterSignIn.class);
	static AccountDialog accountDialog=null;


	@Test
	public void $137$checkManageAccountLink() throws InterruptedException{
		AccountInfoPage_AfterSignIn accountInfoPage=accountDialog.clickManageAccountLink();
		accountInfoPage.isPresent();
		assertEquals(accountInfoPage.PAGE_TITLE,driver.getTitle());	
	}

	@Test
	public void $138$checkSignOutLink() throws InterruptedException {
		HomePage homePage=accountDialog.clickSignOutLink();
		assertEquals(homePage.PAGE_TITLE,driver.getTitle());
		homePageforUser = getSignedIn();
		assertTrue(homePageforUser.isPresent());
		
	}
	

	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);

	@AfterClass
	public static void afterAllIsSaidAndDone() {
		getSignedOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@After
	public void tearDown() {

	}

	@Before
	public void setUp() throws InterruptedException {
		accountDialog=homePageforUser.clickAccountBTN();
		assertTrue(accountDialog.isPresent());
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
	


	public static void getSignedOut() {
		driver.get(homePageforUser.PAGE_URL);
		AccountDialog accountDialog = homePageforUser.clickAccountBTN();
		accountDialog.clickSignOutLink();
	}
}