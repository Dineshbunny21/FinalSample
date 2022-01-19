package org.step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class Steplogin {
	WebDriver driver;
	@Given("User is on amazon product home page")
	public void user_is_on_amazon_product_home_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User is searching for iphone")
	public void user_is_searching_for_iphone() {
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
	driver.findElement(By.xpath("//input[@type='submit']")).click();}

	@When("User adds product to cart")
	public void user_adds_product_to_cart() {
		driver.findElement(By.xpath("//span[text()='Apple iPhone XR (64GB) - White']")).click();
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindowhandle = driver.getWindowHandles();
		
		for(String currentwindowhandle : allwindowhandle) {
			System.out.println(currentwindowhandle);
			if(!currentwindowhandle.equalsIgnoreCase(parentwindow)) {
			
				driver.switchTo().window(currentwindowhandle);
				
				try {
					driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					
				}
				driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")).click();	
				driver.findElement(By.xpath("//input[@id=\"ap_email\"]")).sendKeys("dineshbunny21@gmail.com");
				driver.findElement(By.xpath("//input[@id='continue']")).click();
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("dineshbunny21@");
				driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
			}	
		}
		}

	@When("User goes out to cart information and enter valid information for checkout.")
	public void user_goes_out_to_cart_information_and_enter_valid_information_for_checkout() {
		String  expmessgae ="Successful";
		String actmessage = driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText();
		assertTrue(" mesaage ",expmessgae.equals(actmessage));
		assertEquals(" message 2",expmessgae, actmessage);
	    }

	@When("User proceed to checkout")
	public void user_proceed_to_checkout() {
		
	}


}
;