package SeleniumAssessment;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

    WebDriver driver;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        return ExcelUtil.getLoginData();
    }

    @Test(dataProvider = "loginData")
    void loginTest(String username, String password) {

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("submit")).click();

        System.out.println("Tested with: " + username + " and " + password);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}