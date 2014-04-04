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
 * Example : Serveral steps in one case.
 * This Test constitutes all test cases happens with elements on home page
 * ((For Signed in User))
 * 
 * @author XiaoXue_Chen
 * 
 */
public class ValidateAccountInfoPage {
	private final static Logger logger = LoggerFactory
			.getLogger(ValidateAccountInfoPage.class);
	private static WebDriver driver = DriverUtil
			.getDriver(CfgLoader.browserType);
	AccountInfoPage_AfterSignIn accountInfoPage = BasePage.getPage(AccountInfoPage_AfterSignIn.class);
	static HomePage homePage = BasePage.getPage(HomePage.class);
	static HomePage_AfterSignIn homePageforUser = BasePage
			.getPage(HomePage_AfterSignIn.class);
	static SignInDialog loginDialog = BasePage.getPage(SignInDialog.class);
	AccountDialog accountDialog = BasePage.getPage(AccountDialog.class);

	@Test
	public void $33$checkEditProfileLink() throws InterruptedException {
		accountDialog = homePageforUser.clickAccountBTN();
		accountDialog.isPresent();
		AccountInfoPage_AfterSignIn accountInfoPage = accountDialog
				.clickManageAccountLink();
		accountInfoPage.isPresent();
		accountInfoPage.clickEditlink();
//		System.out.println(driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().indexOf("/storefront") >= 0);
	}





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
		driver.get(homePageforUser.PAGE_URL);
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
	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);
}