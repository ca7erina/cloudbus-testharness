package ui.signIn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.BasePage;
import ui.home.HomePage;
import ui.home.HomePage_AfterSignIn;
import ui.register.ResetPwdPage;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/**
 * This Test constitutes by all test cases happens with elements on Login
 * dialogue of home page (for Guest)
 * 
 * @author XiaoXue_Chen
 * 
 */
public class ValidateSignInDialogAsGuest {
	private final static Logger logger = LoggerFactory.getLogger(ValidateSignInDialogAsGuest.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	private SignInDialog loginDialog = BasePage.getPage(SignInDialog.class);
	private HomePage homePage = BasePage.getPage(HomePage.class);


	/**
	 * Check the reset pwd link
	 * @throws Exception
	 */
	@Test
	public void $44_1$OpenResetPwdLink() throws Exception {
		homePage.OpenSignInDiv();
		driver.get(loginDialog.GetUrlOfResetPwdPage());
		assertEquals(true,BasePage.getPage(ResetPwdPage.class).isPresent());
	}

	
	/**
	 * login with bad email and password
	 * @throws Exception
	 */
	@Test public void $51_1$loginWithBadInput() throws Exception {
		homePage.OpenSignInDiv();
		loginDialog.failLoginAs("tapuser", "tibco123");
		assertEquals("The email or password you entered is invalid!",
				loginDialog.getErrorMessage());
	}
	
	/**
	 * Login with valid email and password.
	 * @throws Exception
	 */
	@Test
	public void $52_1$LoginThenCheck() throws Exception {
		homePage.OpenSignInDiv();
		HomePage_AfterSignIn homePageforUser = loginDialog.loginAs(DataLoader.userEmail,DataLoader.userPwd);
		assertTrue(homePage.isPresent());
		assertEquals(DataLoader.userName, homePageforUser.getUserWelcomeMsg());
	}
	
	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);

	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Before
	public void setUp() {
		driver.get(homePage.PAGE_URL);
	}

}