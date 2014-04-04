package ui.price;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.BasePage;
import ui.integrate.IntegratePage;
import ui.register.RegisterDialog;
import util.CfgLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/**
 * Example: many steps in one single test. --> one test case in testlink.
 * 
 * 
 * @author XiaoXue_Chen
 * 
 */
public class ValidatePricingPage {
	private final static Logger logger = LoggerFactory.getLogger(ValidatePricingPage.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	private PricePage pricePage = BasePage.getPage(PricePage.class);
	String CURRENT_WINDOW=DriverUtil.getDriver().getWindowHandle();
	@Test
	public void $30$validatePricePage() {
		try{
		step1();
		step2();
		step3();
		step4();
		step5();
		step6();
		}catch (Exception e){
			logger.info("30 ValidatePricingPage --> error ",e);
		}
	}
	
	public void step1(){
		assertTrue(pricePage.isPresent());
		
	}
	
	public void step2(){
		RegisterDialog registerDialog=pricePage.clickRegLink();
		assertTrue(registerDialog.isPresent());
	}
	
	public void step3(){
		IntegratePage integratePage= pricePage.clickHereLink();
		assertTrue(integratePage.isPresent());
	}
	
	public void step4() throws InterruptedException{
		driver.get(pricePage.PAGE_URL);
		 pricePage.clickServiceDocLink();
		 Thread.sleep(10000); // wait for the video loaded
		DriverUtil.saveCheckScreenshot("CB-30_4");
	}
	
	public void step5() throws InterruptedException{
	
		 pricePage.clickEmailAdress1();;
		 Thread.sleep(5000); 
		DriverUtil.saveCheckScreenshot("CB-30_5");
	}
	
	public void step6() throws InterruptedException{
		
		 pricePage.clickEmailAdress2();;
		 Thread.sleep(5000); 
		DriverUtil.saveCheckScreenshot("CB-30_6");
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
		driver.get(pricePage.PAGE_URL);
	}

}