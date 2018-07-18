package pe.com.automation.exam.steps;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pe.com.automation.exam.fw.ParentScenario;

public class EbayStoreSteps extends ParentScenario {

	@Given("^I go to the Ebay page on URL \"([^\"]*)\"$")
	public void I_go_to_the_Ebay_page_on_url(String url) {
		startChrome();
		landingPage.gotoUrl(url);
		System.out.println("The url loaded correctly");
	}

	@When("^I fill the value \"([^\"]*)\" in the text field$")
	public void I_fill_the_value_in_the_text_field(String product) {
		landingPage.writeProduct(product);
		System.out.println("The product name was correctly written "+product);
	}
	
	@And("^I click on the search button$")
	public void I_click_on_the_search_button(){
		landingPage.clickBtnSearch();
		System.out.println("The search button was correctly clicked");
	}
	
	@And("^I select the brand PUMA$")
	public void I_select_the_brand_PUMA(){
		landingPage.selectChkBrandPuma();
		System.out.println("The puma brand was correctly selected");
	}
	
	@And("^I select the size 10$")
	public void I_select_the_size_10(){
		landingPage.selectSize10();
		System.out.println("The size 10 was correctly selected");
	}
	
	
	@Then("^I should see the number of results$")
	public void I_should_see_the_results_list(){
		String nResultados = landingPage.getNumberResults();
		System.out.println("The number of results is displayed correctly: "+nResultados);
		closeDriver();
	}
	
	@And("^I order by price ascendant$")
	public void I_order_by_price_ascendant(){
		landingPage.orderByPriceAscendant();
		System.out.println("The products list was sorted in ascending order correctly");
	}
	
	@Then("^I should assert the order taking the first 5 results$")
	public void I_should_assert_the_order_taking_the_first_5_results(){
		Assert.assertEquals(landingPage.getNameProduct("1"),"Puma Pop Cat diapositivas (36026523) Sandalias De Playa Flip Flop Zapatos Zapatillas diapositiva");
		Assert.assertEquals(landingPage.getNameProduct("2"),"Pre Puma para hombre starcat Tech se Desliza Sandalias Flipflop con Eva! Elige Tamaño Y Color");
		Assert.assertEquals(landingPage.getNameProduct("3"),"Sandalias Ojotas Puma para hombre negro y rojo Size UK 7,8,9");
		Assert.assertEquals(landingPage.getNameProduct("4"),"Para mujer Pumas Flip Flops Tamaño 10 estilo #P108188-038");
		Assert.assertEquals(landingPage.getNameProduct("5"),"Nuevo Puma Para hombres starcat Tech se Desliza Sandalias Flipflop con Eva! Elige Tamaño Y Color");
		System.out.println("The first 5 results were verified correctly");
		closeDriver();
	}
	
	@Then("^I should print the first 5 products with their prices in console$")
	public void I_should_print_the_first_5_products_with_their_prices_in_console(){
		System.out.println("The first 5 products are:");
		for (int i = 1; i <= 5; i++) {
			System.out.println(landingPage.getNameProduct(""+i)+": "+landingPage.getPriceProduct(""+i));
		}
		closeDriver();
	}
	
	@And("^I order by price descendant$")
	public void I_order_by_price_descendant(){
		landingPage.orderByPriceDescendant();
		System.out.println("The list was sorted in descending order correctly");
	}
	
	@Then("^I should print the first \"([^\"]*)\" products with their prices in descendant mode$")
	public void I_should_print_the_first_products_with_their_prices_in_descendant_mode(String numero){
		System.out.println("The first "+numero+" products in descendant mode are:");
		for (int i = 1; i <= Integer.parseInt(numero); i++) {
			System.out.println(landingPage.getNameProduct(""+i)+": "+landingPage.getPriceProduct(""+i));
		}
		closeDriver();
	}
}
