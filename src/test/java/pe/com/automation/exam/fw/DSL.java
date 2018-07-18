package pe.com.automation.exam.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is use for send some text to Element
	 * 
	 * @param locator
	 * @param textToSend
	 */
	public void sendKeys(By locator, String textToSend) {
		driver.findElement(locator).sendKeys(textToSend);
	}

	/**
	 * This a method returns the text value of some Element
	 * 
	 * @param locator
	 */
	public String getElementValue(By locator) {
		return driver.findElement(locator).getText();
	}

	/**
	 * This method is used for send click to Element
	 * 
	 * @param locator
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * This a method to wait for an Element
	 * 
	 * @param locator
	 */
	public void handlingWaitToElement(By locator) {
		final WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This a method clear the Text value of any Component
	 * 
	 * @param locator
	 **/
	public void clearTextValue(By locator) {
		driver.findElement(locator).clear();
	}

	/**
	 * This a method wait for a component with any Variable Text this method is
	 * only for locator type xpath
	 * 
	 * @param locator
	 * @param textValue
	 **/
	public void handlingWaitsToNewElementByText(By locator, String textValue) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		By newLocator = By.xpath(
				locator.toString().replaceAll("(By.xpath: )|(\\[@text.*?\\])", "") + "[@text='" + textValue + "']");
		wait.until(ExpectedConditions.presenceOfElementLocated(newLocator));
	}

	/**
	 * This a method for do a click on one element with a specific text this
	 * method contain a handling wait by new element this method is only for
	 * locator type xpath
	 * 
	 * @param locator
	 * @param textValue
	 **/
	public void clickElementByTextValue(By locator, String textValue) {
		By newLocator = By.xpath(
				locator.toString().replaceAll("(By.xpath: )|(\\[@text.*?\\])", "") + "[@text='" + textValue + "']");
		handlingWaitToElement(newLocator);
		click(newLocator);
	}
	
	public void gotoURL(String url)
	{
		driver.get(url);
	}

	public void mouseOverByLocator(By locator){
		WebElement webElement = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).perform();
	}
}
