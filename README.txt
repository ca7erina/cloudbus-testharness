1.Project Background:
A web UI test program for testing the website http://cloudbus-stg.tibco.com/ (includes 60 checkpoints). And It also includes the following functions:
	reading xml test cases,
	writing html test results.
	sending test results by email.

The whole project developed and based on :Java + selenium 2 + Junit + Maven 

2. Project Structure:
tests:
    testObject:
		TestLinkCase.java
		TestCaseResult.java
		TestResult.java
		TestStep.java
	testSet.java
	
ui:
	
	develop:
		DevelopPage_AfterSignIn.java           //DevelopPage page object 
		ValidateDevelopPage.java		//contains all tests on DevelopPage
    account: 
		AccountDialog.java		//AccountDialog page object 
		ValidateAccountDialog.java		//contains all tests on AccountDialog
		AccountInfoPage_AfterSignIn.java		//AccountInfoPage page object 
		ValidateAccountInfoPage.java		//contains all tests on AccountInfoPage.
	contact:
	home:
	register:
	....
	...
	..
	
util:	//utilities used in the test project
	CfgLoader.java	//load property configure file
	DriverUtil.java		//for prepaing different web driver : firefox, ie ,chrome
	TestWatcheRule.java 	//watch every single test ,make sure take a screen shot if the test fails. Also calculate passed and failed case amount.
	FileDownloader.java		//to download files.
	
	report:	//utilities realted to report the test result
		EmailUtil.java	//for emailing the test result
		EnvDetector.java	//for collecting the test environment data
		ReportUtil.java		//for creating the test result html
		TestCaseLoader.java		//for reading the xml test cases which exported from TestLink.

3. Screenshot:
 ![screenshot](screenshot.png?raw=true)
