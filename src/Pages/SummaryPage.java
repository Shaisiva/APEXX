package Pages;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseSetup.ConfigFileReader;

public class SummaryPage {
	
	


		
		ConfigFileReader CFR = new ConfigFileReader();
		
		String VerifyEmailData = CFR.getEmail(); 
	
WebDriver driver;

@FindBy(xpath = ".//*[@data-sequence-name='Insured Details']")
WebElement InsuredDetails;

@FindBy(xpath = ".//span[contains(text(),'Generate Invoice')]")
WebElement GenerateInvoice;

@FindBy(xpath = ".//span[contains(text(),'Continue')]")
WebElement ContinueButton;

@FindBy(xpath = ".//*[contains(text(),'Download Policy schedule')]/ancestor::button")
WebElement DownloadPolicyButton;

@FindBy(xpath = ".//button[contains(text(),'Confirm and Buy Now')]")
WebElement ConfirmAndBuyButton;

@FindBy(xpath = ".//h3")
WebElement DownloadHeading;



public SummaryPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

public void VerifyInsuredDetails() {
String getInsuredDetailstext = InsuredDetails.getText();
getInsuredDetailstext.contains(VerifyEmailData);

}
public void ClickOnGenerateInvoice() {
	GenerateInvoice.click();	
}

public void ClickOnContinueButton() {
	ContinueButton.click();	
}


public void ClickOnDownloadPolicyButton() {
	DownloadPolicyButton.click();	
}

public void ClickOnConfirmAndBuyButton() {
	ConfirmAndBuyButton.click();

	}

public void VerifyDownloadedFile() {
	String PageHeading = DownloadHeading.getText();
	
	String PageHeading_firstCharChange = PageHeading.replace("#", "");
	
	String downloadFileName = PageHeading_firstCharChange.replace("/", "-");
	
	String downloadcompleteUrl= "https://platform2.democrance.com/en/api/v3/policy/UAE%2FCIbF5uosx/coi/?last_name="+"Periyasamy"; 	
	
	System.out.println(downloadcompleteUrl);
	
    String FILES_DIRECTORY = "C:\\Users\\sivaelango.periyasam\\Downloads";
    File Folder = new File(FILES_DIRECTORY);
    File[] allFiles = new File(Folder.getPath()).listFiles();
    for (File file : allFiles) {
        String eachFile = file.getName();
        if (eachFile.contains(downloadFileName))
            System.out.println("--Verified: File : " + downloadFileName + " Has Been Download.");
        else continue;
    }

	}
}