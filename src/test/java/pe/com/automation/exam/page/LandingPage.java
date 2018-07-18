package pe.com.automation.exam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.automation.exam.fw.ParentPage;

public class LandingPage extends ParentPage{
	
	public LandingPage (WebDriver driver){
		super(driver);
	}
	
	By TXT_SEARCH_PRODUCT = By.xpath("//div[@id='gh-ac-box2']/input");
	By BTN_SEARCH = By.id("gh-btn");
	By CHK_BRAND_PUMA = By.xpath("//input[@aria-label='PUMA']");
	By CHK_SIZE_10 = By.xpath("//input[@aria-label='10']");
	By H1_COUNT_RESULTS = By.className("srp-controls__count-heading");
	By CBX_SORT_RESULTS = By.xpath("//button[@id='srp-river-results-SEARCH_STATUS_MODEL_V2-w0-w1_btn']/DIV[1]"); 
	By LNK_SORT_BY_PRICE_ORDER_ASCENDANT = By.xpath("//DIV[@class='srp-sort']/UL/LI[4]/A");
	By LNK_SORT_BY_PRICE_ORDER_DESCENDANT = By.xpath("//DIV[@class='srp-sort']/UL/LI[5]/A");

	
	public void gotoUrl(String url)
	{
		gotoURL(url);
	}
	
	public void clickBtnSearch()
	{
		click(BTN_SEARCH);
	}
	
	public void writeProduct(String product)
	{
		sendKeys(TXT_SEARCH_PRODUCT, product);
	}
	
	public void selectChkBrandPuma()
	{
		click(CHK_BRAND_PUMA);
	}
	
	public void selectSize10()
	{
		click(CHK_SIZE_10);
	}
	
	public String getNumberResults()
	{
		return getElementValue(H1_COUNT_RESULTS);
	}
	
	public void orderByPriceAscendant()
	{
		mouseOverByLocator(CBX_SORT_RESULTS);
		click(LNK_SORT_BY_PRICE_ORDER_ASCENDANT);
	}
	
	public void orderByPriceDescendant()
	{
		mouseOverByLocator(CBX_SORT_RESULTS);
		click(LNK_SORT_BY_PRICE_ORDER_DESCENDANT);
	}
	
	public String getNameProduct(String numberProduct)
	{
		String xpath = "//DIV[@class='srp-river-results clearfix']/UL/LI["+numberProduct+"]/DIV/DIV[2]/A";
		return getElementValue(By.xpath(xpath));
	}
	
	public String getPriceProduct(String numberProduct)
	{
		String xpath = "//DIV[@class='srp-river-results clearfix']/UL/LI["+numberProduct+"]/DIV/DIV[2]/DIV[3]/DIV[1]/SPAN";
		return getElementValue(By.xpath(xpath));
	}
	
}
