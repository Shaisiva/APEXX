package Pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseSetup.ConfigFileReader;

public class PolicyIssueAndPaymentPage {
	
		ConfigFileReader CFR = new ConfigFileReader();
		
		String UserName = CFR.getUserName(); 	
		
		String EmailInfo = CFR.getEmail();
		
		String ExpiryYear = CFR.getEmiratesIdExpiryYear();
		
		String UserPhoneNumber = CFR.getPhoneNumber();
				
		String UserEmiratesId = CFR.getEmiratesId();
	
WebDriver driver;


//@FindBy(xpath = ".//*[contains(text(),'I acknowledge reading and accepting the ')]/ancestor::*[2]/input")
@FindBy(xpath = "(.//*[contains(text(),'Mr')])[1]")
WebElement Title;

//@FindBy(xpath = ".//*[contains(text(),' modules.products.your-quote.termsAndConditions')]/ancestor::*[2]/input")
@FindBy(xpath = ".//input[@name='full_name']")
WebElement Full_Name;

@FindBy(xpath = ".//input[@data-e2e='field-nationality']")
WebElement Nationality_Dropdown;

@FindBy(xpath = "(.//*[contains(text(),'United Arab Emirates')])[1]")
WebElement National_Selection;

@FindBy(xpath = ".//*[@name='email_address']")
WebElement emailAddress;

@FindBy(xpath = ".//*[@data-e2e='field-input-telephone']")
WebElement PhoneNumber;

@FindBy(xpath = ".//*[@data-e2e='field-emirates_id']")
WebElement EmiratesId;

@FindBy(xpath = ".//*[@data-e2e='field-emirates_id_expiry_date']")
WebElement EmiratesIdExpiryDropdown;

@FindBy(xpath = ".//*[@value='2025']/ancestor::select")
WebElement EmiratesIdExpiryYear;

@FindBy(xpath = ".//span[contains(text(),'13')]")
WebElement EmiratesIdExpiryDate;

@FindBy(xpath = ".//button[contains(text(),'Next: Summary')]")
WebElement NextButton;


public PolicyIssueAndPaymentPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}


public void ClickTitle() {
	Title.click();
}

public void EnterFull_Name() {
	Full_Name.sendKeys(UserName);
}

public void SelectNationality() {
	Nationality_Dropdown.click();
	National_Selection.click();	
}

public void EnterEmailAddress() {
	emailAddress.sendKeys(EmailInfo);
}

public void EnterPhoneNumber() {
	PhoneNumber.sendKeys(UserPhoneNumber);
}

public void EnterEmiratesId() {
	EmiratesId.click();
	EmiratesId.sendKeys(UserEmiratesId);
}

public void selectExpiryDate() {

	try {
	EmiratesIdExpiryDropdown.click();
	
	Select dropdownYear = new Select(EmiratesIdExpiryYear);
	dropdownYear.selectByValue(ExpiryYear);
	EmiratesIdExpiryDate.click();
	Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}

public void ClickNext() {
	NextButton.click();;
}

}