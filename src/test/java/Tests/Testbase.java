package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testbase {
	public WebDriver driver;

	@Test
	public void initializeTest() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.navigate().to("https://www.expedia.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement flightsTab = driver.findElement(By.cssSelector("a[href='?pwaLob=wizard-flight-pwa']"));
		flightsTab.click();
		WebElement fromCityBtn = driver.findElement(By.className("uitk-faux-input"));
		fromCityBtn.sendKeys("Egypt");
		WebElement fromResults = driver.findElement(By.cssSelector(
				".uitk-button.uitk-button-small.uitk-button-fullWidth.uitk-button-typeahead.uitk-type-left.has-subtext"));
		fromResults.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement switchBtn = driver.findElement(By.className("SwapLocationsDesktop"));
		switchBtn.click();

		fromCityBtn = driver.findElement(By.className("uitk-faux-input"));
		fromCityBtn.sendKeys("Germany");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement fromResults2 = driver
				.findElement(By.cssSelector(".is-child.uitk-typeahead-result-item.has-subtext"));
		fromResults2.click();

		WebElement searchBtn = driver.findElement(By.cssSelector(
				".uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-1.uitk-layout-grid-item-columnspan-medium-2.uitk-layout-grid-item-columnspan-large-2"));
		searchBtn.click();
		Select sortList = new Select(driver.findElement(By.id("listings-sort")));
		sortList.selectByVisibleText("Arrival (Earliest)");
		
	/*	String Actualtext = driver.getCurrentUrl();
		Assert.assertEquals(Actualtext, "https://www.expedia.com/Flights-Search" );*/
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement resultCard = driver.findElement(By.className("uitk-card-link"));
		resultCard.click();
		
	}

}
