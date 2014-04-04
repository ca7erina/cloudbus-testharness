package ui.integrate;


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
import ui.home.HomePage;
import ui.home.HomePage_AfterSignIn;
import ui.home.VideoXDialog;
import ui.integrate.intergrations.*;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/**

 * This class contains tests on Integrate Page (For Signed in User).
 * @author XiaoXue_Chen
 * 
 */
public class ValidateIntegratePageAsSignedUser {
	private final static Logger logger = LoggerFactory.getLogger(ValidateIntegratePageAsSignedUser.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	static HomePage homePage = BasePage.getPage(HomePage.class);
	static SignInDialog loginDialog = BasePage.getPage(SignInDialog.class);
	static HomePage_AfterSignIn homePageforUser = BasePage.getPage(HomePage_AfterSignIn.class);
	static AccountDialog accountDialog=BasePage.getPage(AccountDialog.class);
	IntegratePage integratePage= BasePage.getPage(IntegratePage.class);

	@Test
	public void $67$Checktibber() throws InterruptedException{
		TibberPage tibber=integratePage.clickTibberLMBtn();
		assertEquals(tibber.PAGE_TITLE,driver.getTitle());
		VideoXDialog videox = tibber.ClickVideo();
		assertTrue(videox.isPresent());
		Thread.sleep(25000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_1");
		videox.closeVideo();
		//
		tibber.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	
	@Test
	public void $61$CheckSalesforce() throws InterruptedException{
		SalesforcePage salesforce=integratePage.clickSaleforceLMBtn();
		assertEquals(salesforce.PAGE_TITLE,driver.getTitle());
		VideoXDialog videox = salesforce.ClickVideo();
		assertTrue(videox.isPresent());
		Thread.sleep(25000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-61");
		videox.closeVideo();
		
		salesforce.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $57$CheckFoursquare() throws InterruptedException{
		FoursquarePage page=integratePage.clickFoursquareLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-57");
		
		//		
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $55$CheckEvernote() throws InterruptedException{
		EvernotePage page=integratePage.clickEvernoteLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		
		//		
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $60$CheckDropbox() throws InterruptedException{
		DropboxPage page=integratePage.clickDropboxLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $56$CheckFacebook() throws InterruptedException{
		FacebookPage page=integratePage.clickFacebookLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $54$CheckSatisfaction() throws InterruptedException{
		SatisfactionPage page=integratePage.clickSatisfactionLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $41$CheckYammer() throws InterruptedException{
		YammerPage page=integratePage.clickYammerLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $66$CheckMailchimp() throws InterruptedException{
		MailchimpPage page=integratePage.clickMailchimpLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $65$CheckInstagram() throws InterruptedException{
		InstagramPage page=integratePage.clickInstagramLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-67_2");
	}
	@Test
	public void $120$CheckSQS() throws InterruptedException{
		SQSPage page=integratePage.clickSQSLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-120");
	}
	@Test
	public void $121$CheckFlickr() throws InterruptedException{
		FlickrPage page=integratePage.clickFlickrLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-121");
	}
	@Test
	public void $122$CheckJigsaw() throws InterruptedException{
		JigsawPage page=integratePage.clickJigsawLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
		//
		page.ClickDownloadLink();
		Thread.sleep(2000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-122");
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
		driver.get(integratePage.PAGE_URL);
		integratePage.isPresent();
	
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
		homePageforUser.isPresent();
		AccountDialog accountDialog = homePageforUser.clickAccountBTN();
		accountDialog.isPresent();
		accountDialog.clickSignOutLink();
	}
}