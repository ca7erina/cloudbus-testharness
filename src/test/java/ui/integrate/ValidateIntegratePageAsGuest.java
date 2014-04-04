package ui.integrate;

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
import ui.home.VideoXDialog;
import ui.integrate.intergrations.*;
import ui.register.ValidateRegisterDialogAsGuest;
import util.CfgLoader;
import util.DriverUtil;
import util.TestWatcheRule;
/**
 * This class contains tests on Integrate Page(for Guest)
 * @author XiaoXue_Chen
 *
 */
public class ValidateIntegratePageAsGuest {
	private final static Logger logger = LoggerFactory.getLogger(ValidateRegisterDialogAsGuest.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	
	HomePage homePage = BasePage.getPage(HomePage.class);
	IntegratePage integratePage= BasePage.getPage(IntegratePage.class);
	
	@Test
	public void $139$Checktibber() throws InterruptedException{
		TibberPage tibber=integratePage.clickTibberLMBtn();
		assertEquals(tibber.PAGE_TITLE,driver.getTitle());
		VideoXDialog videox = tibber.ClickVideo();
		assertTrue(videox.isPresent());
		Thread.sleep(25000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-139");
		videox.closeVideo();
	}
	
	@Test
	public void $141$CheckSalesforce() throws InterruptedException{
		SalesforcePage salesforce=integratePage.clickSaleforceLMBtn();
		assertEquals(salesforce.PAGE_TITLE,driver.getTitle());
		VideoXDialog videox = salesforce.ClickVideo();
		assertTrue(videox.isPresent());
		Thread.sleep(25000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-141");
		videox.closeVideo();
	}
	@Test
	public void $142$CheckFoursquare(){
		FoursquarePage page=integratePage.clickFoursquareLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $144$CheckEvernote(){
		EvernotePage page=integratePage.clickEvernoteLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $143$CheckDropbox(){
		DropboxPage page=integratePage.clickDropboxLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $145$CheckFacebook(){
		FacebookPage page=integratePage.clickFacebookLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $146$CheckSatisfaction(){
		SatisfactionPage page=integratePage.clickSatisfactionLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $147$CheckYammer(){
		YammerPage page=integratePage.clickYammerLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $148$CheckMailchimp(){
		MailchimpPage page=integratePage.clickMailchimpLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $149$CheckInstagram(){
		InstagramPage page=integratePage.clickInstagramLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $151$CheckSQS(){
		SQSPage page=integratePage.clickSQSLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $152$CheckFlickr(){
		FlickrPage page=integratePage.clickFlickrLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	@Test
	public void $153$CheckJigsaw(){
		JigsawPage page=integratePage.clickJigsawLMBtn();
		assertEquals(page.PAGE_TITLE,driver.getTitle());
	}
	
	
	
	@Rule public TestWatcheRule watcher =new TestWatcheRule(logger,driver);

	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@After
	public void after() {
		// driver.manage().deleteAllCookies();
	}

	@Before
	public void before() {
		driver.get(integratePage.PAGE_URL);
	}
}
