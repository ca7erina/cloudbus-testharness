package util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;


import util.report.ReportUtil;



/**
 * 
 * @author XiaoXue_Chen
 *
 */
public class TestWatcheRule  implements MethodRule {
	Logger logger;
	WebDriver driver;
	String directoryName;
	
	public TestWatcheRule(Logger logger,WebDriver driver){
		super();
		this.driver=driver;
		this.logger=logger;
		this.driver = driver;
		directoryName = getDirectoryName();
	}
	    public Statement apply(final Statement base, final FrameworkMethod method,
	            Object target) {
	        return new Statement() {
	            @Override
	            public void evaluate() throws Throwable {
	                starting(method);
	                try {
	                    base.evaluate();
	                    succeeded(method);
	                } catch (AssumptionViolatedException e) {
	                	e.printStackTrace();
	                    throw e;
	                } catch (Throwable t) {
	                	captureScreenshot(method.getName()); 
	                    failed(t, method);
	                    logger.error("test case failed :", t);
	                    throw t;// re-throw to allow the failure to be reported toJUnit
	                } finally {
	                    finished(method);
	                }
	            }
	             public void captureScreenshot(String fileName) {
	        		try {
	        			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	        			BufferedImage capture = new Robot().createScreenCapture(screenRect);
	        			File screenshot= new File("temp");
	        			ImageIO.write(capture, "png", screenshot);
	        			FileUtils.copyFile(screenshot, new File(directoryName+ "screenshot-" + fileName + "-" + getTime()	+ ".png"));
	        			screenshot.delete();
	        		} catch (Exception e) {
	        			// No need to crash the tests if the screenshot fails
	        		}

	        	}

//	            public void captureScreenshot(String fileName) {
//					try {
//						new File(directoryName).mkdirs(); // Insure directory is
//															// there
//						FileOutputStream out = new FileOutputStream(directoryName
//								+ "screenshot-" + fileName + "-" + getTime()
//								+ ".png");
//						out.write(((TakesScreenshot) driver)
//								.getScreenshotAs(OutputType.BYTES));
//						out.close();
//					} catch (Exception e) {
//							e.printStackTrace();
//						// No need to crash the tests if the screenshot fails
//					}
//				}
	            
	        };
	    }

	    /**
	     * Invoked when a test method succeeds
	     */
	    public void succeeded(FrameworkMethod method) {
	    	try{
//	    	logger.info( "{}: succeeded",method.getName());
	    	ReportUtil.report(method.getName(),true);
//	    	DriverUtil.savePassScreenshot(method.getName());
	    	} catch (Exception e) {
	    		e.printStackTrace();
				// No need to crash the tests
			}
	    }

	    /**
	     * Invoked when a test method fails
	     */
	    public void failed(Throwable e, FrameworkMethod method) {
	    	try{
	    	logger.info("{}: failed",method.getName() );
	    	ReportUtil.report(method.getName(),false);
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
				// No need to crash the tests
			}
	    }

	    /**
	     * Invoked when a test method is about to start
	     */
	    public void starting(FrameworkMethod method) {
	    	try{
//	    	logger.info("{}: starting",method.getName());
	    	} catch (Exception e) {
	    		e.printStackTrace();
				// No need to crash the tests 
			}
	    }


	    /**
	     * Invoked when a test method finishes (whether passing or failing)
	     */
	    public void finished(FrameworkMethod method) {
//	    	logger.info("{}: finished",method.getName() );
	    }
	    
	    private String getDirectoryName() {
			return "target/screenshot" + "_" + getDate() + "/" + "failed/";

		}

		private String getDate() {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			return fmt.format(new Date(System.currentTimeMillis()));
		}

		private String getTime() {
			SimpleDateFormat fmt = new SimpleDateFormat("HH-mm-ss");
			return fmt.format(new Date(System.currentTimeMillis()));
		}

}
