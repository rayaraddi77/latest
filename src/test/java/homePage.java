

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import resources.base;

public class homePage extends base{

	public WebDriver driver;
	
	
	
	public void initialise() throws IOException {
		driver=initialiseDriver();
		
		//driver.get(prop.getProperty("url"));
	}
	
	
	public void tearDown() {
		driver.close();
	}
	
}
