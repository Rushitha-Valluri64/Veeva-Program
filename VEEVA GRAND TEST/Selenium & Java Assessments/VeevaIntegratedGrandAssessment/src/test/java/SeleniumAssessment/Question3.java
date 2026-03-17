package SeleniumAssessment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Question3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        System.out.println("Browser Launched and URL Opened");
    }

 
    @Test(priority = 1)
    public void loginTestValid() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("login")).click();

        System.out.println("Valid Login Test Executed");
    }

    @Test(priority = 2)
    public void loginTestInvalid() {
        driver.findElement(By.id("username")).sendKeys("Student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("login")).click();

        System.out.println("Invalid Login Test Executed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Browser Closed");
    }
}