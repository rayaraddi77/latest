package resources;

import java.io.File;
//import org.apache.commons.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initialiseDriver() throws IOException {
		
	
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil.rayaraddi\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	

}
