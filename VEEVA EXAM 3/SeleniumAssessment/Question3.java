package SeleniumAssessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {
	
	public static void main(String args[])
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Login into HRM
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String str="My Info";
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("in");
		List<WebElement>options=driver.findElements(By.xpath("//a[@class='oxd-main-menu-item']"));
		for(WebElement option:options)
		{
			String element=option.getText();
			if(element.equalsIgnoreCase(str))
			{
				option.click();
				System.out.println("Desired option is : "+str);
				System.out.print("Selected option is : "+element);
				break;
			}
		}
	}

}
