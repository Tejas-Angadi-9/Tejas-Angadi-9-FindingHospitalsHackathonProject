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
	@Test(priority = 1)
	public void topSurgeries() throws IOException, InterruptedException {
		try {

			HomePage hp = new HomePage(driver);
			hp.getSurgeries().click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 600)");

			Thread.sleep(1000);
			SurgeriesPage sp = new SurgeriesPage(driver);
			takeSnapshot(driver, "Surgeries");

			System.out.println("Top surgeries");
			System.out.println("=================================");
			List<WebElement> surgeries = sp.getSurgeries();
			for (WebElement surgery : surgeries) {
				System.out.println(surgery.getText());
			}

			System.out.println("\nSurgery based on Departments");
			System.out.println("=================================");
		} catch (Exception e) {
			System.out.println("topSurgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void generalSurgeries() throws IOException {
		try {

			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType1().click();
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
		} catch (Exception e) {
			System.out.println("General Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void practologySurgeries() throws IOException {
		try {

			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType2().click();
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
		} catch (Exception e) {
			System.out.println("Practology Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 4)
	public void ophtomologySurgeries() throws IOException {
		try {

			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType3().click();
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
		} catch (Exception e) {
			System.out.println("Opthomology Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 5)
	public void urologySurgeries() throws IOException {
		try {

			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType4().click();
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
		} catch (Exception e) {
			System.out.println("Urology Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 6)
	public void cosmeticSurgeries() throws IOException {
		try {

			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType5().click();
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
		} catch (Exception e) {
			System.out.println("Cosmetic Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void orthopedicSurgeries() throws IOException {
		try {

			SurgeriesPage sp = new SurgeriesPage(driver);
			sp.getSurgeryType6().click();
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
		} catch (Exception e) {
			System.out.println("Orthopedic Surgeries failed: " + e.getMessage());
			Assert.fail();
		}
	}
}
