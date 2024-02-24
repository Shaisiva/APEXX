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

public class YourQuote {
WebDriver driver;
WebDriverWait wait;


//@FindBy(xpath = ".//*[contains(text(),'I acknowledge reading and accepting the ')]/ancestor::*[2]/input")
@FindBy(xpath = "(.//input[@type='checkbox'])[1]")
WebElement Term_and_Condition_Checkbox;

//@FindBy(xpath = ".//*[contains(text(),' modules.products.your-quote.termsAndConditions')]/ancestor::*[2]/input")
@FindBy(xpath = "(.//input[@type='checkbox'])[2]")
WebElement Module_Product_Checkbox;

@FindBy(xpath = ".//*[contains(text(),'Next: Policy issuance and Payment')]")
WebElement Next_Policy_Payment_Button;

@FindBy(xpath = ".//h1[contains(text(),'Terms & Conditions')]")
WebElement Header;

@FindBy(xpath = ".//button[contains(text(),'Back to Form')]")
WebElement Back_To_Form;


public YourQuote(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}


public void IsHeadingDisplayed() {
	Header.isDisplayed();
}

public void IsNextButtonEnabled() {
	Next_Policy_Payment_Button.isEnabled();
}

public void ClickBack_To_Form() {
	Back_To_Form.click();
}

public void ClickNextButtonEnabled() {
	Next_Policy_Payment_Button.click();
}
public void clickCheckConditionCheckBoxes() {
//	wait = new WebDriverWait(driver,30);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(Header));
	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//WebElement element = driver.findElement(By.xpath("//div[@class='footer']"));
	Actions actions = new Actions(driver);
	actions.moveToElement(Module_Product_Checkbox).click().build().perform();
	
	actions.moveToElement(Term_and_Condition_Checkbox).click().build().perform();
	
	//Module_Product_Checkbox.click();
	//insuredAge_Year_Selection.
	//Term_and_Condition_Checkbox.click();
	
	}

}