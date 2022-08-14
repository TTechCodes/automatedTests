package basicweb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.citibank.com/");
		
		//By ID
		WebElement searchTxtBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTxtBox.sendKeys("apple");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(3000);
		
		//By Link text
		driver.navigate().back();
		driver.findElement(By.linkText("Sell products on Amazon")).click();  
		
		//By Xpath
		driver.navigate().back();
		JavascriptExecutor js = (JavascriptExecutor)driver;  
        js.executeScript("scrollBy(0, 4500)");
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]/table/tbody/tr[1]/td[1]/a")).click();
		
		Thread.sleep(3000);
		
		//By class
		driver.get("https://www.amazon.com/");
		driver.findElement(By.linkText("Sign in securely")).click();  
		
		WebElement emaiText = driver.findElement(By.name("email"));  
		emaiText.sendKeys("asdf@gmail.com");
		driver.findElement(By.className("a-button-input")).click();
		
		
		/*
		List<WebElement> elements = driver.findElements(By.));
	      // iterate over list
			for(WebElement element:elements) {
				System.out.print(element.getAttribute("type"));
				System.out.print(element.getAttribute("class"));
			}
        
        */
		
		

		//driver.close();   

	}

}
