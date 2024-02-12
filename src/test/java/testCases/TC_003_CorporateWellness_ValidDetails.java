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
			logger.info("*** STARTING TC_003_CorporateWellness_InvalidDetails TESTCASE ***");
			HomePage hp = new HomePage(driver);
			hp.getForCorporates();
			logger.info("Clicked on the Corporates link");
			hp.getWellnessPlans();
			logger.info("Then navigated to wellness plans option");

			CorporateWellnessPage cw = new CorporateWellnessPage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			cw.setName();
			logger.info("Entered the name");
			cw.setOrganizationName();
			logger.info("Entered the orginization name");
			cw.setContactNumber();
			logger.info("Entered the contact number");
			cw.setEmail().sendKeys(prop.getProperty("validEmail"));
			logger.info("Entered the valid email address");
			cw.getOrgranizationSize();
			Select select1 = new Select(cw.getSelectOption1());
			select1.selectByVisibleText("<500");
			logger.info("Selected the \"<500\" option the from the orginization size dropdown");
			cw.getInterestedIn();
			Select select2 = new Select(cw.getSelectOption2());
			select2.selectByVisibleText("Taking a demo");
			logger.info("Selected the \"Taking a demo\" option the from the orginization size dropdown");
			if (cw.getScheduleButton().isEnabled()) {
				System.out.println("Schedule button is enabled!");
				logger.info("Schedule button is enabled");
			}
			cw.getScheduleButton().click();
			logger.info("Clicked on the schedule button");
			Thread.sleep(6000);

			logger.info("Capturing the details from the thank you modal");
			takeSnapshot(driver, "Valid details");
			String heading = cw.getThankYou();
			String paragraph = cw.getThankYouParagraph();
			System.out.println(heading);
			System.out.println(paragraph);
			logger.info("Successfully captured the details from the thank you modal");
			
		} catch (Exception e) {
			logger.fatal("Failed to enter the valid details in the form");
			System.out.println("TC_003_CorporateWellness_ValidDetails failed " + e.getMessage());
			Assert.fail();
		}
	}
}
