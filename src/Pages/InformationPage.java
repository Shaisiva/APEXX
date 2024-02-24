package Pages;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseSetup.ConfigFileReader;

public class InformationPage {
	
	ConfigFileReader CFR = new ConfigFileReader();
	
	String UserAge = CFR.getUserAge(); 
	
WebDriver driver;

@FindBy(xpath = "//h1")
WebElement Header;

@FindBy(xpath = "//*[@id='insured_age']//*[@class='datepicker control']")
WebElement insuredAge;

@FindBy(xpath = "//*[@id='insured_age']//*[@value='2023']/ancestor::select")
WebElement insuredAge_Year_Selection;

@FindBy(xpath = "(.//span[contains(text(),'13')])[1]")
WebElement insuredAge_Date;

@FindBy(xpath = ".//button[contains(text(),'Next: Your Quote')]")
WebElement Next_Your_Quote_Button;



public InformationPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

public void veryHeader() {
String getheadertext = Header.getText();
assertEquals("App & Browser Testing Made Easy", getheadertext);
}
public void clickOninsuredAge() {
	
	insuredAge.click();
	//insuredAge_Year_Selection.
	Select dropdownYear = new Select(insuredAge_Year_Selection);
	dropdownYear.selectByValue(UserAge);
	insuredAge_Date.click();
	
}

public void clickOnNext_Your_Quote_Button() {
	Next_Your_Quote_Button.click();

	
}
}