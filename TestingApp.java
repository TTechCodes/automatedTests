package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");
		
		//Sign In Check: nothing entered 
		WebElement signIn = driver.findElement(By.linkText("Sign in"));
		signIn.click();
		WebElement signInConfirm = driver.findElement(By.name("SubmitLogin"));
		signInConfirm.click();
		boolean error1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p")).isDisplayed();
		
		if(error1) {
			System.out.println("Case 1");
			System.out.println("Pass: No data was entered and <p> tag displays error message");
		
		}else {
			System.out.print("Fail: no trigger");
		}
		
		//invalid email and password
		WebElement emailSignIn = driver.findElement(By.name("email"));
		emailSignIn.sendKeys("asdf");//not in a normal email format 
		WebElement password = driver.findElement(By.name("passwd"));
		password.sendKeys("asdf");//password must be 5 character min 
		driver.findElement(By.name("SubmitLogin")).click();
		
		if(error1) {
			System.out.println("Case 2");
			System.out.println("Pass: Incorrect data was entered and <p> tag displays error message");
		
		}else {
			System.out.print("Fail: no trigger");
		}
		
		//Positive case 
		Thread.sleep(3000);
		driver.get("http://automationpractice.com/index.php");
		WebElement signIn2 = driver.findElement(By.linkText("Sign in"));
		signIn2.click();
		
		WebElement acceptedSignIn = driver.findElement(By.name("email"));
		acceptedSignIn.sendKeys("okgbejqn@sharklasers.com");
		WebElement acceptPassword = driver.findElement(By.name("passwd"));
		acceptPassword.sendKeys("asdfg");
		WebElement signInConfirm2 = driver.findElement(By.name("SubmitLogin"));
		signInConfirm2.click();
		
		String actualRegisterPageUrl = driver.getCurrentUrl();
		String expectedRegisterPageUrl = "http://automationpractice.com/index.php?controller=my-account";
		
		if(actualRegisterPageUrl.equals(expectedRegisterPageUrl)) {
			System.out.println("Case 3");
			System.out.println("Passed: navigated to account site");
		}else {
			System.out.println("Failed: did not redirect to account site");
			System.out.println("Actual: "+ actualRegisterPageUrl);
			System.out.println("Expected: "+ expectedRegisterPageUrl);
		}



	}
}
