package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	By locSearchBox = By.xpath(
			"//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--locality']//div[@class='c-omni-searchbox_wrapper ']/input");
	
	@FindBy(xpath = "//body/div[@id='root']/div/div/div[@class='content']/div[@class='c-omni-wrapper u-d__inline-block']/div[@id='c-omni-container']/div[@class='c-omni u-clearfix']/div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--locality']/div[@class='c-omni-suggestion-list']/div[@class='c-omni-suggestion-group']/div[1]/span[1]")
	WebElement bangaloreCity;

	By typeSearchBox = By.xpath(
			"//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--keyword']//div[@class='c-omni-searchbox_wrapper ']/input");
	
	@FindBy(xpath = "//div[@class='c-omni-suggestion-list']/div[1]/div[1]/span[1]")
	WebElement dentistType;
	
	@FindBy(xpath = "//div[contains(text(),'Surgeries')]")
	WebElement surgeries;
	
	@FindBy(xpath = "//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']")
	WebElement forCorporates;

	@FindBy(xpath = "//div[@class='u-d nav-dropdown text-left active-state']/div[1]/a")
	WebElement wellnessPlans;

	public WebElement setLocSearchBox() {
		return driver.findElement(locSearchBox);
	}
	
	public WebElement setTypeSearchBox() {
		return driver.findElement(typeSearchBox);
	}
	
	public WebElement getBangaloreCity() {
		return bangaloreCity;
	}	
	
	public WebElement setDentistType() {
		return dentistType;
	}
	
	public WebElement getSurgeries() {
		return surgeries;
	}
	
	public void getForCorporates() {
		forCorporates.click();
	}

	public void getWellnessPlans() {
		wellnessPlans.click();
	}

}
