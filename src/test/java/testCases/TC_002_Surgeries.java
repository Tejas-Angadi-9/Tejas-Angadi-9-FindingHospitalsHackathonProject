package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SurgeriesPage;
import testBase.BaseClass;

public class TC_002_Surgeries extends BaseClass {
	@Test(priority = 1, groups = { "sanity" })
	public void topSurgeries() throws IOException, InterruptedException {
		logger.info("*** STARTING TC_002_Surgeries TESTCASE ***");
		try {

			HomePage hp = new HomePage(driver);
			hp.getSurgeries().click();
			logger.info("Clicked on surgeries button");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 600)");

			Thread.sleep(1000);
			SurgeriesPage sp = new SurgeriesPage(driver);
			takeSnapshot(driver, "Surgeries");
			logger.info("Capturing the details of top surgeries");
			System.out.println("Top surgeries");
			System.out.println("=================================");
			List<WebElement> surgeries = sp.getSurgeries();
			for (WebElement surgery : surgeries) {
				System.out.println(surgery.getText());
			}
			logger.info("Successfully captured the details of top surgeries");
			logger.info("Capturing the details of surgies from each department");
			System.out.println("\nSurgery based on Departments");
			System.out.println("=================================");
		} catch (Exception e) {
			logger.info("Failed to get details of the top surgeries");
			System.out.println("topSurgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 2, groups = { "sanity" })
	public void generalSurgeries() throws IOException {
		try {
			
			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType1().click();
			logger.info("Capturing general surgeries details");
			List<WebElement> generalSurgeries = sp.getSurgeryByDepartment();

			System.out.println("\nGeneral Surgeries");
			System.out.println("=================================");
			takeSnapshot(driver, "General Surgeries");
			for (WebElement surgery : generalSurgeries) {
				System.out.println(surgery.getText());
			}
			if (sp.getCloseModal().isDisplayed()) {
				sp.getCloseModal().click();
			}
			logger.info("Successfully captured general surgeries details");
		} catch (Exception e) {
			logger.fatal("Failed to capture general surgeries details");
			System.out.println("General Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 3, groups = { "sanity" })
	public void practologySurgeries() throws IOException {
		try {
			
			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType2().click();
			logger.info("Capturing Practology surgeries details");
			List<WebElement> surgeries = sp.getSurgeryByDepartment();
			System.out.println("\nPractology Surgeries");
			System.out.println("=================================");
			takeSnapshot(driver, "Practology Surgeries");
			for (WebElement surgery : surgeries) {
				System.out.println(surgery.getText());
			}
			if (sp.getCloseModal().isDisplayed()) {
				sp.getCloseModal().click();
			}
			logger.info("Successfully captured Practology surgeries details");
		} catch (Exception e) {
			logger.fatal("Failed to capture the Practology surgeries details");
			System.out.println("Practology Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 4, groups = { "sanity" })
	public void ophtomologySurgeries() throws IOException {
		try {
			
			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType3().click();
			logger.info("Capturing Ophtomology surgeries details");
			List<WebElement> surgeries = sp.getSurgeryByDepartment();
			System.out.println("\nOphtomology Surgeries");
			System.out.println("=================================");
			takeSnapshot(driver, "Opthomology Surgeries");
			for (WebElement surgery : surgeries) {
				System.out.println(surgery.getText());
			}
			if (sp.getCloseModal().isDisplayed()) {
				sp.getCloseModal().click();
			}
			logger.info("Successfully captured the Ophtomology surgeries details");
		} catch (Exception e) {
			logger.fatal("Failed to capture the Ophtomology surgeries details");
			System.out.println("Opthomology Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 5, groups = { "sanity" })
	public void urologySurgeries() throws IOException {
		try {
			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType4().click();
			
			logger.info("Capturing Urology surgeries details");
			List<WebElement> surgeries = sp.getSurgeryByDepartment();
			System.out.println("\nUrology Surgeries");
			System.out.println("=================================");
			takeSnapshot(driver, "Nurology Surgeries");
			for (WebElement surgery : surgeries) {
				System.out.println(surgery.getText());
			}
			if (sp.getCloseModal().isDisplayed()) {
				sp.getCloseModal().click();
			}
			logger.info("Successfully captured the Urology surgeries details");
		} catch (Exception e) {
			logger.fatal("Failed to capture the Urology surgeries details");
			System.out.println("Urology Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 6, groups = { "sanity" })
	public void cosmeticSurgeries() throws IOException {
		try {
			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType5().click();

			logger.info("Capturing Cosmetic surgeries details");
			List<WebElement> surgeries = sp.getSurgeryByDepartment();
			System.out.println("\ncosmetic Surgeries");
			System.out.println("=================================");
			takeSnapshot(driver, "Cosmetic Surgeries");
			for (WebElement surgery : surgeries) {
				System.out.println(surgery.getText());
			}
			if (sp.getCloseModal().isDisplayed()) {
				sp.getCloseModal().click();
			}
			logger.info("Sucessfully captured the Cosmetic surgeries details");
		} catch (Exception e) {
			logger.fatal("Failed to capture the Cosmetic surgeries details");
			System.out.println("Cosmetic Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 3, groups = { "sanity" })
	public void orthopedicSurgeries() throws IOException {
		try {
			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType6().click();

			logger.info("Capturing Orthopedic surgeries details");
			List<WebElement> surgeries = sp.getSurgeryByDepartment();
			System.out.println("\nOrthopedic Surgeries");
			System.out.println("=================================");
			takeSnapshot(driver, "Orthopedic Surgeries");
			for (WebElement surgery : surgeries) {
				System.out.println(surgery.getText());
			}
			if (sp.getCloseModal().isDisplayed()) {
				sp.getCloseModal().click();
			}
			logger.info("Successfully captured the Orthopedic surgeries details");
		} catch (Exception e) {
			logger.fatal("Failed to capture the Orthopedic surgeries details");
			System.out.println("Orthopedic Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}
}
