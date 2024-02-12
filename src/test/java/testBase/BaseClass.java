package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Properties prop;
	public Logger logger;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String browser) throws IOException {
		// setting properties
		prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\2303536\\eclipse-workspace\\FindingHospitalsHackathonProject\\src\\test\\resources\\config.properties");
		prop.load(file);

		// loading log4j file
		logger = LogManager.getLogger(this.getClass());

		if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// OS
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching OS....");
				return;
			}

			// Browser
			switch (browser.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser..");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} else if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			// launching browser based on condition - locally
			switch (browser.toLowerCase()) {
			case "browser":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver = null;
	}

	public void takeSnapshot(WebDriver driver, String photoName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "\\screenshots\\" + photoName + ".png");
		FileUtils.copyFile(src, trg);
	}

	public static String captureScreen(String name) {
		String timeStamp = new SimpleDateFormat().format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String targetPath = System.getProperty("user.dir") + "\\extentScreenshots\\+" + name + ".png";
		File trg = new File(targetPath);

		src.renameTo(trg);
		return targetPath;
	}
}
