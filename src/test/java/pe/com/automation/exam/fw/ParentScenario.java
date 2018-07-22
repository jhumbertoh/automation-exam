package pe.com.automation.exam.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pe.com.automation.exam.page.LandingPage;

public class ParentScenario {

	private WebDriver driver;
	protected static LandingPage landingPage;

	public void startChrome() {

		try {
			driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        //driver.manage().window().setPosition(new Point(0, 0));	
	        //driver.manage().window().maximize();
			
		} catch (Exception e) {
			System.out.println("Exception when registering the Driver " + e);
		}
		
		landingPage = new LandingPage(driver);

	}

	protected void closeDriver() {
		driver.quit();
	}

}
