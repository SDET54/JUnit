package practiceMH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {

    /*
    ●Bir class olusturun: Alerts
    ●https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ●Bir metod olusturun: acceptAlert
        ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        “You successfully clicked an alert” oldugunu test edin
    ●Bir metod olusturun: dismissAlert
        ○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin
    ●Bir metod olusturun: sendKeysAlert
        ○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
     */

    static WebDriver driver;

    // ●https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    //●Bir metod olusturun: acceptAlert
    //    ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //    “You successfully clicked an alert” oldugunu test edin
    @Test
    public void acceptAlert() {
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();

        String expectedResultMessage = "You successfully clicked an alert";
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(expectedResultMessage, actualResultMessage);
    }

    //●Bir metod olusturun: dismissAlert
    //    ○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //    “successfuly” icermedigini test edin
    @Test
    public void dismissAlert() {
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();

        String istenmeyenKelime = "successfuly";
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertFalse(actualResultMessage.contains(istenmeyenKelime));
    }

    //●Bir metod olusturun: sendKeysAlert
    //    ○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @Test
    public void senKeysAlert() {
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Vasif");
        driver.switchTo().alert().accept();

        String gonderilenMetin = "Vasif";
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertTrue(actualResultMessage.contains(gonderilenMetin));
    }
}
