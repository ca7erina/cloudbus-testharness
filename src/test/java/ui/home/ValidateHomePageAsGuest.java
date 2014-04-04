package ui.home;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

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
import ui.contact.ContactPage;
import ui.integrate.IntegratePage;
import ui.learn.LearnPage;
import ui.price.PricePage;
import ui.register.RegisterDialog;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/**
 * This Test constitutes  all test cases happens with elements on home
 * page.(For Guest)
 * In Testlink: Cloud Bus-Validate Home Page As Guest
 * 
 * @author XiaoXue_Chen
 * 
 */
public class ValidateHomePageAsGuest {
	private final static Logger logger = LoggerFactory.getLogger(ValidateHomePageAsGuest.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	HomePage homePage = BasePage.getPage(HomePage.class);
	

	/**
	 * Check the "key feature"  video on Home page.
	 * @throws InterruptedException
	 */
	@Test
	public void $25_1$checkVideo1() throws InterruptedException {
		VideoXDialog videox = homePage.OpenVideo1();
		assertTrue(videox.isPresent());
		Thread.sleep(25000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-25");
		videox.closeVideo();
	}


	/**
	 * Check the copyRight on home page.
	 */
	@Test
	public void $38_1$checkCopyRight() {
		homePage.isPresent();
		assertTrue(homePage.getCopyRightTxt().indexOf("Copyright " + Calendar.getInstance().get(Calendar.YEAR)+" TIBCO Software Inc. All rights reserved.") > 0);
	}


	/**
	 * Check the video "why cloud bus" on Home Page.
	 * @throws InterruptedException
	 */
	@Test
	public void $40_1$checkVideo2() throws InterruptedException {
		VideoXDialog videox = homePage.OpenVideo2();
		assertTrue(videox.isPresent());
		Thread.sleep(25000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-40");
		videox.closeVideo();
	}

	
	/**
	 * Check video "cloud bus end to end" on Home page.
	 * @throws InterruptedException
	 */
	@Test
	public void $42_1$checkVideo3() throws InterruptedException {
		VideoXDialog videox = homePage.OpenVideo3();
		assertTrue(videox.isPresent());
		Thread.sleep(25000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-42");
		videox.closeVideo();

	}
	


	/**
	 * Click banner img ,then check the register dialog.
	 */
	@Test
	public void $43_1$clickBanner() {
		RegisterDialog register = homePage.clickBannerImg();
		assertTrue(register.isPresent());
	}
	
	
	@Test
	public void $45_1$checkIntegrateBtn() {
		IntegratePage integratePage = homePage.clickIntegrateBtn();
		assertTrue(integratePage.isPresent());
		assertTrue(driver.getTitle().equals("Integrations and QuickConnects"));
	}
	

	/**
	 * Open sign link
	 * @throws Exception
	 */
	@Test
	public void $46_1$LoginThenCheck() throws Exception {
		SignInDialog loginDialog = homePage.OpenSignInDiv();
		assertTrue(loginDialog.isPresent());
	
	}
	

	/**
	 * Open contact link on the homepage.
	 */
	@Test
	public void $47_1$openContactLink() {

		ContactPage contactPage = homePage.OpenContactPage();
		assertTrue(contactPage.isPresent());// Make sure pageIsOpen
		assertEquals("Contact Cloud Bus", driver.getTitle()); // Make sure the
																// title
																// isRight.

	}
	
	@Test
	public void $48_1$CheckRegButton(){
		RegisterDialog registerDialog=homePage.OpenRegisterDiv();
		assertTrue(registerDialog.isPresent());	
	}

	
	/**
	 * Open learn page from "leanrn" tab.
	 */
	@Test
	public void $49_1$openLearnPage() {
		try {
			@SuppressWarnings("unchecked")
			List<String> handle = (List<String>) driver.getWindowHandles();
			LearnPage learnPage = homePage.clickLearnBtn();
			driver.switchTo().window(handle.get(handle.size() - 1));
			assertTrue(learnPage.isPresent());
			assertEquals("Cloud Bus Help Center", driver.getTitle());
		} catch (ClassCastException e) {
			
		}

	}
	
	@Test
	public void $50_1$CheckPricingBtn(){
		try{
		PricePage pricePage=homePage.clickPricingBtn();
		assertEquals(pricePage.PAGE_TITLE,driver.getTitle());
		}catch (Exception e){
			logger.error("Check pricing btn then checking title error",  e );
		}
	}
	
	
	@Test
	public void $169_1$CheckHomeBtn(){
		try{
		HomePage ReloadedhomePage=homePage.clickHomeBtn();
		assertEquals(driver.getTitle(),ReloadedhomePage.PAGE_TITLE);	
		}catch(Exception e){
			logger.error("check home reloaded error", e);
		}
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
	public void setUp() {
		driver.get(homePage.PAGE_URL);
		homePage.isPresent();
	}

	@BeforeClass
	public static void beforeAllIsSaidAndDone() {
		driver.manage().deleteAllCookies();
	}


}