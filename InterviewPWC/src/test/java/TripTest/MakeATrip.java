package TripTest;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import config.PropertiesFile;

public class MakeATrip {

	public static String urlAddress = null;
	public static String fromCity = null;
	public static String toCity = null;
	//public static String monthYear = "June 2021";
	//public static String startDate = "30";
	WebDriver driver = null;

	@BeforeClass
	public void setUp() {
		PropertiesFile.getProperties();
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlAddress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void BookTrip()
	{
		PropertiesFile.getProperties();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.cssSelector("input[placeholder=From]")).clear();
		driver.findElement(By.cssSelector("input[placeholder=From]")).sendKeys(fromCity);
		driver.findElement(By.cssSelector("input[placeholder=From]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("input[placeholder=From]")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("input[placeholder=To]")).sendKeys(toCity);
		driver.findElement(By.cssSelector("input[placeholder=To]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("input[placeholder=To]")).sendKeys(Keys.ENTER);
		

		driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--selected']//p[contains(text(),'30')]")).click();
		driver.findElement(By.cssSelector("a[class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		driver.findElement(By.xpath("//button[@id='bookbutton-RKEY:0001f958-e239-4e38-8af1-c3a272d09a2b:7_0']/span[@class='appendRight8']")).click();
		driver.findElement(By.xpath("//div[@class='viewFareBtnCol']//button[@id='bookbutton-RKEY:0001f958-e239-4e38-8af1-c3a272d09a2b:7_0']")).click();
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();
		
		// Now iterate using Iterator
		java.util.Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);		
		String details = driver.findElement(By.xpath("//span[normalize-space()='BOM-CCU']")).getText();
		if(details.equals("BOM-CCU")) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test case Failed");
		}
		driver.close();
		}

		}
		

		
		System.out.println("Browser lauch successfully");
	}

	

}
