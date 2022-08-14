package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RadioTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.linkText("Women")).click();
		WebElement tops = driver.findElement(By.name("layered_category_4"));
		tops.click();
	//	driver.navigate().refresh();
	//	driver.findElement(By.name("layered_category_8")).click();
	

		boolean fadedShortSleeve = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).isDisplayed();
		boolean blouse = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")).isDisplayed();
		
		System.out.println("Case: Tops");
		System.out.println("fadedShortSleeve: " + fadedShortSleeve);
		System.out.println("blouse: " + blouse);

		Thread.sleep(3000);
		driver.navigate().refresh();

		WebElement dresses = driver.findElement(By.name("layered_category_8"));
		dresses.click();
		
		boolean printedDress1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).isDisplayed();
		boolean printedDress2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")).isDisplayed();
		boolean printedSDress1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")).isDisplayed();
		boolean printedSDress2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[1]/div/a[1]/img")).isDisplayed();
		boolean printedCDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[1]/div/a[1]/img")).isDisplayed();
		
		System.out.println();

		System.out.println("Case: Dresess");
		System.out.println("printedDress1: " +printedDress1);
		System.out.println("printedDress2: "+printedDress2);
		System.out.println("printedSDress1: "+printedSDress1);
		System.out.println("printedSDress2: " + printedSDress2);
		System.out.println("printedCDress: " +printedCDress);
		
		//Case 3: Tops and Dresses
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		driver.findElement(By.name("layered_category_4")).click();
		Thread.sleep(3000);
		
		WebElement dresses2 = driver.findElement(By.name("layered_category_8"));
		dresses2.click();

		System.out.println();
		System.out.println("Case: Dresess and Tops");
		fadedShortSleeve = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).isDisplayed();
		blouse = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")).isDisplayed();
		printedDress1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")).isDisplayed();
		printedDress2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[1]/div/a[1]/img")).isDisplayed();
		printedSDress1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[1]/div/a[1]/img")).isDisplayed();
		printedSDress2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[6]/div/div[1]/div/a[1]/img")).isDisplayed();
		printedCDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[7]/div/div[1]/div/a[1]/img")).isDisplayed();
	
		System.out.println("fadedShortSleeve: " + fadedShortSleeve);
		System.out.println("blouse: " + blouse);
		System.out.println("printedDress1: " +printedDress1);
		System.out.println("printedDress2: "+printedDress2);
		System.out.println("printedSDress1: "+printedSDress1);
		System.out.println("printedSDress2: " + printedSDress2);
		System.out.println("printedCDress: " +printedCDress);

	}

}
