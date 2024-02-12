package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.DentistPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC_001_SearchingDentists extends BaseClass {

	@Test(priority = 1)
	public void searchingDentists() throws InterruptedException, IOException {
		logger.info("*** STARTING TC_001_SearchingDentists TESTCASE ***");
		try {

			takeSnapshot(driver, "HomePage");
			HomePage hp = new HomePage(driver);
			hp.setLocSearchBox().click();
			hp.setLocSearchBox().clear();
			hp.setLocSearchBox().sendKeys("Bangalor");
			
			Thread.sleep(1000);
			hp.getBangaloreCity().click();
			hp.setTypeSearchBox().click();
			hp.setTypeSearchBox().sendKeys("Dentist");
			hp.setDentistType().click();
			logger.info("Searching for dentists in Bangalore");
		} catch (Exception e) {
			Assert.fail();
			logger.fatal("Failed to search dentists in Bangalore");
			System.out.println("searchingDentists test Failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "searchingDentists")
	public void gettingDentists() throws InterruptedException, IOException {
		try {
			logger.info("Now in the dentist page");
			DentistPage dp = new DentistPage(driver);
			logger.info("Applying filters");
			dp.getPatientStoriesFilter().click();
			Thread.sleep(1000);
			dp.getPatientStoriesOptionOne().click();
			Thread.sleep(2000);
			dp.getExperienceFilter().click();
			Thread.sleep(1000);
			dp.getPatientStoriesOptionOne().click();
			Thread.sleep(2000);
			dp.getAllFilters().click();
			Thread.sleep(2000);
			dp.getAboveRs500().click();
			Thread.sleep(2000);
			dp.getAllFilters().click();
			dp.getAvailableToday().click();
			dp.getAllFilters().click();
			Thread.sleep(2000);
			dp.getRelevanceFilter().click();
			dp.getRelevanceOptionTwo().click();
			logger.info("Applied all the required filters");
			takeSnapshot(driver, "Dentists_Page");
			logger.info("Get the data of top 5 dentists");
			String totalDentists = dp.getTotalDoctors().getText();
			System.out.println(totalDentists);
			System.out.println("All the Available Doctors");
			System.out.println("=====================================");

			ExcelUtility et = new ExcelUtility(System.getProperty("user.dir") + "\\testData\\doctors.xlsx");

			List<WebElement> dentistsNames = dp.getDentists();
			List<WebElement> dentistsExperience = dp.getDentistsExperience();
			List<WebElement> dentistsLocation = dp.getDentistsLocation();
			List<WebElement> detnistsClinic = dp.getDentistsClinic();
			List<WebElement> dentistsConsulationFees = dp.getDentistsConsulationFees();
			List<WebElement> dentistsRating = dp.getDentistsRating();

			for (int i = 0; i < 5; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView()", dentistsNames.get(i));
				Thread.sleep(1000);
				takeSnapshot(driver, "dentist" + (i + 1));

				System.out.println("\nDoctor " + (i + 1));
				System.out.println("Name: " + dentistsNames.get(i).getText());

				System.out.println("Experience: " + dentistsExperience.get(i).getText());
				System.out.println("Location: " + dentistsLocation.get(i).getText());
				System.out.println("Clinic: " + detnistsClinic.get(i).getText());
				System.out.println(dentistsConsulationFees.get(i).getText() + " consulation fees");
				System.out.println("Rating: " + dentistsRating.get(i).getText());

				et.setCellData("Doctor", i, 0, dentistsNames.get(i).getText());
				System.out.println();
			}
		} catch (Exception e) {
			logger.fatal("Failed to get the details of the dentists");
			System.out.println("gettingDentists test is failed" + e.getMessage());
			Assert.fail();
		}
		logger.info("*** FINISHED TC_001_SearchingDentists TESTCASE ***");
	}
}
