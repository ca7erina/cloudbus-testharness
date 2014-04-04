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
import ui.account.AccountDialog;
import ui.contact.ContactPage;
import ui.deploy.DeployPage_AfterSignIn;
import ui.develop.DevelopPage_AfterSignIn;
import ui.integrate.IntegratePage;
import ui.learn.LearnPage;
import ui.price.PricePage;
import ui.register.RegisterDialog;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/** 
 * This Test constitutes  all testcases happens with elements on home
 * page.(For Signed in User)
 * 
 * @author XiaoXue_Chen
 * 
 */
public class ValidateHomePageAsSignedUser {
	private final static Logger logger = LoggerFactory.getLogger(ValidateHomePageAsSignedUser.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	static HomePage homePage = BasePage.getPage(HomePage.class);
	static HomePage_AfterSignIn homePageforUser = BasePage.getPage(HomePage_AfterSignIn.class);
	static SignInDialog signInDialog = BasePage.getPage(SignInDialog.class);



	@Test
	public void $128$checkAccountBtn() {
		AccountDialog accountDialog= homePageforUser.clickAccountBTN();
		assertTrue(accountDialog.isPresent());
		
	}


	@Test
	public void $129$CheckDevelopTab()  {
	
		DevelopPage_AfterSignIn developPage = homePageforUser.clickDevelopBtn();
		assertTrue(developPage.isPresent());
		assertEquals(DevelopPage_AfterSignIn.PAGE_TITLE,driver.getTitle());
		
	}

	
	@Test
	public void $130$checkDeployTab() {
		
		DeployPage_AfterSignIn deployPage = homePageforUser.clickDeployBtn();
		assertTrue(deployPage.isPresent());
		assertEquals(DeployPage_AfterSignIn.PAGE_TITLE,driver.getTitle());
		
	}
	

//	@Test
//	public void $131$CheckSubscribeBtn() {
//	
//		SubscribeDialog subcribeDialog = homePageforUser.clickSubscribeBTN();
//		assertTrue(subcribeDialog.isPresent());
//		subcribeDialog.clickCloseBtn();
//	
//	}
//	
	
	@Test
	public void $132$checkIntegrateImg() {
		try{
		IntegratePage integratePage = homePageforUser.clickIntegrateImg();
		assertTrue(integratePage.isPresent());
		assertEquals(integratePage.PAGE_TITLE,driver.getTitle());
		}catch (Exception e){
			logger.info("check integrateIMg linking to integrate page --> error ",e);
		}
	}
	

	
	@Test
	public void $133$checkDevelopImg() {

		DevelopPage_AfterSignIn developPage = homePageforUser.clickDevelopImg();
		assertTrue(developPage.isPresent());
		assertEquals(DevelopPage_AfterSignIn.PAGE_TITLE,driver.getTitle());
	}
	

	@Test
	public void $134$checkDeployImg() {
		DeployPage_AfterSignIn deployPage = homePageforUser.clickDeployImg();
		assertTrue(deployPage.isPresent());
		assertEquals(DeployPage_AfterSignIn.PAGE_TITLE,driver.getTitle());
	}
	

	public static   HomePage_AfterSignIn getSignedIn() throws InterruptedException {
		signInDialog=homePage.OpenSignInDiv();	
		return signInDialog.loginAs(DataLoader.userEmail,DataLoader.userPwd);
		
	}
	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);
	
	@BeforeClass
	public static void beforeAllIsSaidAndDone() throws InterruptedException  {
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
	public void setUp()  {
		driver.get(homePageforUser.PAGE_URL);
		homePageforUser.isPresent();
		
	}



}