package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver ;
	public static Properties prop ;

	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(

					"C:\\Users\\91888\\Desktop\\Automation\\kiteZerodhaNew\\src\\main\\java\\com\\qa\\config\\config.properties");

			prop.load(ip);
		}
		catch(FileNotFoundException e) {

		}
		catch(IOException e) {		
		}		
	}
//	@SuppressWarnings("deprecation")
	public static void intilization() {
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\91888\\Desktop\\chromedriver latest\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browserName.equals("gecko")) {
			System.setProperty("webdriver.gecko.driver", "path");
			driver = new FirefoxDriver();
		}

		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "path");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait ,TimeUnit.SECONDS);
	
		
		
		driver.get(prop.getProperty("url"));

	}
}
