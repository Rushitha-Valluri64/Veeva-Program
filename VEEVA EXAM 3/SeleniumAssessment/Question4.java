package SeleniumAssessment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question4 {
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		String title="Google";
		if(driver.getTitle().equals(title))
		{
			System.out.println("Title matched with Google!!");
		}
		else
		{
			System.out.println("Title not matched with Google!!");
		}
		
		String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("google.co")) {
            System.out.println("Redirect verification passed");
        } else {
            System.out.println("Redirect verification failed");
        }
	}

}
