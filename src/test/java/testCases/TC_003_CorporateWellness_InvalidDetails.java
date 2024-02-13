package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CorporateWellnessPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_003_CorporateWellness_InvalidDetails extends BaseClass {

	@Test(groups = { "sanity" })
	public void checkingInvalidDetails() throws IOException, InterruptedException {
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
			cw.setEmail().sendKeys(prop.getProperty("InvalidEmail"));
			logger.info("Entered the invalid email address");
			if (!cw.getScheduleButton().isEnabled()) {
				takeSnapshot(driver, "Invalid Details Form");
				System.out.println("Schedule button is disabled");
				logger.info("Schedule button is disabled");
			}
			// else {
			cw.getOrgranizationSize();
			Select select1 = new Select(cw.getSelectOption1());
			select1.selectByVisibleText("<500");
			logger.info("Selected the \"<500\" option the from the orginization size dropdown");
			cw.getInterestedIn();
			Select select2 = new Select(cw.getSelectOption2());
			select2.selectByVisibleText("Taking a demo");
			logger.info("Selected the \"Taking a demo\" option the from the orginization size dropdown");
			cw.getScheduleButton();
			logger.info("Trying to click the schedule button, but it's not possible as the button is disabled");
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println("TC_003_CorporateWellness_InvalidDetails test failed" + e.getMessage());
			logger.fatal("Failed to enter the details in the form");
			Assert.fail();
		}
		logger.info("*** FINISHED TC_003_CorporateWellness_InvalidDetails TESTCASE ***");
	}
}
