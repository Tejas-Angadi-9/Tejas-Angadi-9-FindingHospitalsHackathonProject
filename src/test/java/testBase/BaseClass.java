package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Properties prop;

	@Parameters({ "os","browser" })
	@BeforeClass
	public void setup(String os, String browser) throws IOException {
		// setting properties
		prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\2303536\\eclipse-workspace\\FindingHospitalsHackathonProject\\src\\test\\resources\\config.properties");
		prop.load(file);

		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// OS
			if(os.equalsIgnoreCase("windows"))
				capabilities.setPlatform(Platform.WIN11);
			else if(os.equalsIgnoreCase("mac"))
				capabilities.setPlatform(Platform.MAC);
			else {
				System.out.println("No matching OS....");
				return;
			}
		}
		
		// setting webDriver
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
			System.out.println("Invalid browser name");

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
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\screenshots\\"+photoName+".png");
		FileUtils.copyFile(src, trg);
	}

	public static String captureScreen(String name) {
		String timeStamp = new SimpleDateFormat().format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String targetPath = System.getProperty("user.dir")+"\\extentScreenshots\\+"+name+".png";
		File trg = new File(targetPath);
		
		src.renameTo(trg);
		return targetPath;
	}
}
