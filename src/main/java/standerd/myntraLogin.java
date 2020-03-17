package standerd;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import GenericUtilities.Gneenric;
import GenericUtilities.genericUtilities;;

public class myntraLogin extends genericUtilities{
	public static WebDriver driver;
	public static void main(String[] args) throws AWTException, IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dhilip\\Downloads\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Actions Action = new Actions(driver);
		 WebElement A1 = driver.findElement(By.xpath("//div[@class='desktop-user']"));
		 Action.moveToElement(A1).perform();
		 driver.findElement(By.xpath("//div//a[contains(text(),'log in')]")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		
		Properties obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\element.properties");									
	    obj.load(objfile);	
		String username = "thupatidileep@gmail.com";
		String password = "dileep335";
//		waitforelement(By.xpath(obj.getProperty("usernamexapth")));
		driver.findElement(By.xpath(obj.getProperty("usernamexapth"))).sendKeys(username);
		System.out.println("User enter the username ::"+ username);
		driver.findElement(By.xpath(obj.getProperty("passwordxapth"))).sendKeys(password);
		System.out.println("User enter the password :: "+password);
		waitforelement(By.xpath(obj.getProperty("clickOnLoginBtn")));
//		waitforelement(By.xpath("//div//button[@class='login-login-button']"));
		System.out.println("waitforelement");
		driver.findElement(By.xpath(obj.getProperty("clickOnLoginBtn"))).click();
	}
	
//	public static void waitforelement(By by) {
////		WebDriver driver = null;
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//		
//	}

}
