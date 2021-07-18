package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import resources.base;

import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class StepDefinition extends base{

	
	List<WebElement> secondrow;
	WebElement test;
	WebElement table;
	
	int total = 0;
	int item1,item2,item3,item4;
	int min;
	


	
	
	   @Given("^I add four different products to my wish list$")
	    public void i_add_four_different_products_to_my_wish_list() throws Throwable {
	        System.out.println("1");
	        driver =initialiseDriver();
	        driver.get("http://testscriptdemo.com/");
	        
	        for(int i=0;i<4;i++) {
	        	driver.findElement(By.cssSelector("button.products")).click();
	        }
	       
	    }

	    @When("^I view my wishlist table$")
	    public void i_view_my_wishlist_table() throws Throwable {
	    	WebElement table=driver.findElement(By.id("product"));
	    	secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
	    	
	    	
	    	// get the number of items in wishlist
	    	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='tablewishlist']/tbody/tr"));
	    	int count = rows.size();
	    	System.out.println("ROW COUNT : "+count);
	    	
	    	
	    }

	    @When("^I search for lowest price product$")
	    public void i_search_for_lowest_price_product() throws Throwable {
	    	
    		//get the lowest price item
    		min = Math.min(Math.max(item1,item2),Math.max(item3,item4));
	    }

	    @Then("^I find total four selected items in my Wishlist$")
	    public void i_find_total_four_selected_items_in_my_wishlist() throws Throwable {			
			
			item1 = Integer.parseInt(secondrow.get(0).getText());
			item2 = Integer.parseInt(secondrow.get(1).getText());
			item3 = Integer.parseInt(secondrow.get(2).getText());
			item4 = Integer.parseInt(secondrow.get(3).getText());
	    	total = item1 + item2 + item3 + item4;
			System.out.println("Price of 4 items in wishlist : "+total);
			
			//Add an item to the cart
	    	driver.findElement(By.cssSelector("img[alt='wishlist']")).click();
	    }

	    @Then("^I am able to verify the item in my cart$")
	    public void i_am_able_to_verify_the_item_in_my_cart() throws Throwable {
	    	WebDriverWait w = new WebDriverWait(driver,5);
	    	
	    	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	    	
	    	test = driver.findElement(By.id("product"));
	    	
			driver.findElement(By.cssSelector("button.promoBtn")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
	    }

	    @And("^I am able to add the lowest price item to my cart$")
	    public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws Throwable {

	    		
	    		// Find the element containing the lowest price of an item
	    		List<WebElement> options = driver.findElements(By.id("autocomplete"));
	    		
	    		String minString = String.valueOf(Integer(123));

	    		for (WebElement option : options){
	    			if (option.getText().equalsIgnoreCase(minString)){
	    				option.click();
	    				break;
	    			}
	    		}
	    	
	    }

		private char[] Integer(int i) {
			// TODO Auto-generated method stub
			return null;
		}
    
}