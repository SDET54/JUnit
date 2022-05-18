package practiceMH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZeroWebappsecurityTest {
    /*
    1. http://zero.webappsecurity.com sayfasina gidin
    2. Signin button'una tiklayin
    3. Login alanina "username" yazdirin
    4. Password alanina "password" yazdirin
    5. Sign in button'una tiklayin
    6. Pay Bills sayfasina gidin
    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    8. tarih kismina “2020-09-10 yazdirin
    9. Pay button'una tiklayin
    10. “The payment was successfully submitted.” mesajinin ciktigini control edin
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void zeroWebbappsecurityTest() {
        //    1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //    2. Signin button'una tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //    3. Login alanina "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //    4. Password alanina "password" yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //    5. Sign in button'una tiklayin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        //Sayfa guvenlik protokolunden dolayi asagidaki islem yapildi
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("300");

        //    8. tarih kismina “"2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        //    9. Pay button'una tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //    10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        driver.findElement(By.xpath("//div[@id='alert_content']")).isDisplayed();
    }

}
