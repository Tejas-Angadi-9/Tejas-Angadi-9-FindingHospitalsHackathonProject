package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CorporateWellnessPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_003_CorporateWellness_ValidDetails extends BaseClass {
	@Test
	public void checkingValidDetails() throws IOException, InterruptedException {
		try {

			HomePage hp = new HomePage(driver);
			hp.getForCorporates();
			hp.getWellnessPlans();
			CorporateWellnessPage cw = new CorporateWellnessPage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			cw.setName();
			cw.setOrganizationName();
			cw.setContactNumber();
			cw.setEmail().sendKeys(prop.getProperty("validEmail"));
			cw.getOrgranizationSize();
			Select select1 = new Select(cw.getSelectOption1());
			select1.selectByVisibleText("<500");
			cw.getInterestedIn();
			Select select2 = new Select(cw.getSelectOption2());
			select2.selectByVisibleText("Taking a demo");
			if (cw.getScheduleButton().isEnabled()) {
				System.out.println("Schedule button is enabled!");
			}
			cw.getScheduleButton().click();
			Thread.sleep(6000);

//			if (cw.getThankYouModal()) {
				takeSnapshot(driver, "Valid details");
				String heading = cw.getThankYou();
				String paragraph = cw.getThankYouParagraph();
				System.out.println(heading);
				System.out.println(paragraph);
//			}
		} catch (Exception e) {
			System.out.println("TC_003_CorporateWellness_ValidDetails failed "+e.getMessage());
			Assert.fail();
		}
	}
}
