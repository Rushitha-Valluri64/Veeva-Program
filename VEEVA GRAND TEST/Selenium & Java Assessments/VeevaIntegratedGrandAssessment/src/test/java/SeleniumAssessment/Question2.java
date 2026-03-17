package SeleniumAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {
	public static void main(String args[]) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//Switch using index to frame1
		driver.switchTo().frame(0);
		System.out.println("Switched to Frame1 using index");
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		System.out.println("Interacted with Frame1");
		
		//Switching back to main content
		driver.switchTo().defaultContent();
		System.out.println("Switched to Main Frame");
		
		//Switch using webelement to frame2
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		System.out.println("Switched to Frame2 using Web Element");
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");
		System.out.println("Interacted with Frame2");
		
		//Switching back to main content
		driver.switchTo().defaultContent();
		System.out.println("Switched to Main Frame");
		
		//Switch to frame3 using webelement
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		System.out.println("Switched to Frame3 using Web Element");
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Automation");
		System.out.println("Interacted with Fram3");
		
		//Switching back to main content
		driver.switchTo().defaultContent();
		System.out.println("Switched to Main Frame");
		driver.quit();
	}
}
