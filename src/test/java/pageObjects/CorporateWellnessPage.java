package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CorporateWellnessPage extends BasePage {
	public CorporateWellnessPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//header[@id='header']//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//header[@id='header']//input[@id='organizationName']")
	WebElement organizationName;
	@FindBy(xpath = "//header[@id='header']//input[@id='contactNumber']")
	WebElement contactNumber;
	@FindBy(xpath = "//header[@id='header']//input[@id='officialEmailId']")
	WebElement email;
	@FindBy(xpath = "//header[@id='header']//select[@id='organizationSize']")
	WebElement organizationSize;
	@FindBy(xpath = "//header[@id='header']//select[@id='interestedIn']")
	WebElement interestedIn;

	@FindBy(xpath = "//body[1]/div[4]/div[1]/div[1]")
	WebElement thankYouModal;
	@FindBy(xpath = "//body/div[4]/div[1]/div[1]/div[1]/div[1]")
	WebElement thankYou;
	@FindBy(xpath = "//body/div[4]/div[1]/div[1]/div[1]/div[2]")
	WebElement thankYouParagraph;

	@FindBy(xpath = "//header[@id='header']//select[@id='organizationSize']")
	WebElement selectOption1;

	@FindBy(xpath = "//header[@id='header']//select[@id='interestedIn']")
	WebElement selectOption2;

	@FindBy(xpath = "//header[@id='header']//button[@type='submit'][normalize-space()='Schedule a demo']")
	WebElement scheduleButton;

	public void setName() {
		name.sendKeys("Test");
	}

	public void setOrganizationName() {
		organizationName.sendKeys("TestOrg");
	}

	public void setContactNumber() {
		contactNumber.sendKeys("9876543210");
	}

	public WebElement setEmail() {
		return email;
	}

	public void getOrgranizationSize() {
		organizationSize.click();
	}

	public void getInterestedIn() {
		interestedIn.click();
	}

	public WebElement getScheduleButton() {
		return scheduleButton;
	}

	public boolean getThankYouModal() {
		return thankYouModal.isDisplayed();
	}

	public String getThankYou() {
		return thankYou.getText();
	}

	public String getThankYouParagraph() {
		return thankYouParagraph.getText();
	}

	public WebElement getSelectOption1() {
		return selectOption1;
	}

	public WebElement getSelectOption2() {
		return selectOption2;
	}
}
