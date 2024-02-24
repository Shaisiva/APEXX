package BaseSetup;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.InformationPage;
import Pages.PolicyIssueAndPaymentPage;
import Pages.SummaryPage;
import Pages.YourQuote;


public class setUp {
String driverPath = "C:\\geckodriver.exe";
WebDriver driver;
InformationPage objInformationPage;
YourQuote objYourQuotePage;
PolicyIssueAndPaymentPage ObjPolicyIssueAndPaymentPage;
SummaryPage ObjSummaryPage;

@Parameters("browser")
@BeforeTest

public void setup(String browser) {
	
String path = System.getProperty("user.dir");
if(browser.equalsIgnoreCase("chrome")) {

	
	 
	System.setProperty("webdriver.chrome.driver",path+"\\resources\\chromedriver.exe");
	driver = new ChromeDriver();
} else if(browser.equalsIgnoreCase("edge")) {
	

	 
	System.setProperty("webdriver.edge.driver",path+"\\resources\\msedgedriver.exe");
	driver = new EdgeDriver();
	
	
	
	
}
//Resize current window to the set dimension
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://client-platform2.democrance.com/d2c/policy/critical-illness-one-product/form/information");
}

@Test(priority = 1)
public void navigate_to_homepage_click_on_getstarted() throws InterruptedException {
try {
	objInformationPage = new InformationPage(driver);
	objYourQuotePage = new YourQuote(driver);
	ObjPolicyIssueAndPaymentPage = new PolicyIssueAndPaymentPage(driver);
	ObjSummaryPage = new SummaryPage(driver);
	
	
	objInformationPage.clickOninsuredAge();
	objInformationPage.clickOnNext_Your_Quote_Button();
	
	Thread.sleep(30000);
	
	objYourQuotePage.clickCheckConditionCheckBoxes();
	objYourQuotePage.IsNextButtonEnabled();
	objYourQuotePage.ClickNextButtonEnabled();
	
	Thread.sleep(10000);
	
	ObjPolicyIssueAndPaymentPage.ClickTitle();
	ObjPolicyIssueAndPaymentPage.EnterFull_Name();
	ObjPolicyIssueAndPaymentPage.SelectNationality();
	ObjPolicyIssueAndPaymentPage.EnterEmailAddress();
	ObjPolicyIssueAndPaymentPage.EnterPhoneNumber();
	ObjPolicyIssueAndPaymentPage.EnterEmiratesId();
	ObjPolicyIssueAndPaymentPage.selectExpiryDate();
	
	ObjPolicyIssueAndPaymentPage.ClickNext();
	
	Thread.sleep(10000);
	
	ObjSummaryPage.VerifyInsuredDetails();
	
	ObjSummaryPage.ClickOnConfirmAndBuyButton();
	
	Thread.sleep(10000);
	
	ObjSummaryPage.ClickOnGenerateInvoice();
	
	Thread.sleep(10000);
	
	ObjSummaryPage.ClickOnContinueButton();
	
	Thread.sleep(10000);
	
	ObjSummaryPage.ClickOnDownloadPolicyButton();
	ObjSummaryPage.VerifyDownloadedFile();
	Thread.sleep(10000);
}catch(Exception e) {
	System.out.println("Error Message: "+e.getMessage());
	driver.close();
}
	
	}

	@Test(priority = 2)
	public void enter_userDetails() {


	}
	@AfterTest  
	public void after_test()  
	{  
	    System.out.println("After test execution..");
	    driver.quit();
	}
	
	}
