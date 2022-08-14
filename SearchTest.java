package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");
		
		//Case 1: Nothing entered
		//WebElement searchBar = driver.findElement(By.name("search_query"));
		driver.findElement(By.name("submit_search")).click();
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=&submit_search=";
		
		if(currentURL.equals(expectedURL)) {
			System.out.println("Case 1");
			System.out.println("Passed: Expected URL appears");		
		}else {
			System.out.println("Failed: URL did not appear");
		}
			
		//Case 2: List of expected terms example "dress"
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.name("search_query")).sendKeys("dress");
		driver.findElement(By.name("submit_search")).click();
		currentURL = driver.getCurrentUrl();
		expectedURL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
			
		if(currentURL.equals(expectedURL)) {
				System.out.println("Case 2");
				System.out.println("Passed: Expected URL appears");		
		}else {
				System.out.println("Failed: URL did not appear");	
		}
		
		driver.findElement(By.name("search_query")).clear();

		//Case 3: name from list does not appear
		Thread.sleep(3000);
		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.name("search_query")).sendKeys("car");
		driver.findElement(By.name("submit_search")).click();
		currentURL = driver.getCurrentUrl();
		expectedURL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=car&submit_search=";
			
		if(currentURL.equals(expectedURL)) {
				System.out.println("Case 3");
				System.out.println("Passed: Expected URL appears");		
		}else {
				System.out.println("Failed: URL did not appear");	
		}
		
	}

}
