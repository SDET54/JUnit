package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase_1_RegisterUser {
    /*
    Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    WebDriver driver;

    // 1. Launch browser
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//li/a[@href='/']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Vasif");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("techpro2@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("test1234");

        WebElement daysDdM = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDays = new Select(daysDdM);
        selectDays.selectByValue("4");

        WebElement monthsDdM = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonths = new Select(monthsDdM);
        selectMonths.selectByValue("2");

        WebElement yearsDdM = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYears = new Select(yearsDdM);
        selectYears.selectByValue("1988");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //First name
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Vasif");
        //Last name
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Amrahov");
        //Company
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("TechPro");
        //Address
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Devlet mahallesi");
        //Address2
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("Ugur apartmani");
        //Country
        WebElement countryDdM = driver.findElement(By.xpath("//select[@data-qa='country']"));
        Select selectCountry = new Select(countryDdM);
        selectCountry.selectByVisibleText("United States");
        //State
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Arizona");
        //City
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Ankara");
        //Zipcode
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("US5400");
        //Mobile Number
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("0503699929");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-qa='account-created']")).isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a")).isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //     Bunlar sitede gozukmuyor.

    }
}
