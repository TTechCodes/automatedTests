package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailSignup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");
		
		//Case 1: invalid email format
		WebElement signIn = driver.findElement(By.linkText("Sign in"));
		signIn.click();
		
		WebElement emailCreate = driver.findElement(By.name("email_create"));
		emailCreate.sendKeys("qwert");
		driver.findElement(By.name("SubmitCreate")).click();
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		
		if(currentURL.equals(expectedURL)) {
			System.out.println("Case 1");
			System.out.println("Passed: list tag displays invalid email");		
		}else {
			System.out.println("Failed: tag did not appear");
		emailCreate.clear();
		}
		
		//Case 2: valid format and email account exists 
		Thread.sleep(3000);
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();
				
		driver.findElement(By.name("email_create")).sendKeys("zxcvbb456@gmail.com");//Note this email was used to register a previous user
		driver.findElement(By.name("SubmitCreate")).click();
		
		if(currentURL.equals(expectedURL)) {
				System.out.println("Case 2");
				System.out.println("Passed: directed to proper site");		
		}else {
				System.out.println("Failed: not directed to proper site");
		}
		driver.findElement(By.name("email_create")).clear();

		//Case 3: valid format and email account does not exist
		Thread.sleep(3000);
		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();
				
		driver.findElement(By.name("email_create")).sendKeys("dgfhdfg456@gmail.com");//Note this email was used to register a previous user
		driver.findElement(By.name("SubmitCreate")).click();
		
		if(currentURL.equals(expectedURL)) {
				System.out.println("Case 3");
				System.out.println("Passed: directed to proper site ");		
		}else {
				System.out.println("Failed: not directed to proper site");
		}
		driver.findElement(By.name("email_create")).clear();
		
		//Case 4: nothing entered 
		Thread.sleep(3000);
		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();
				
		driver.findElement(By.name("SubmitCreate")).click();
		
		if(currentURL.equals(expectedURL)) {
				System.out.println("Case 4");
				System.out.println("Passed: list tag displays invalid email");		
		}else {
				System.out.println("Failed: tag did not appear");
		}
		driver.findElement(By.name("email_create")).clear();
		


	}

}
