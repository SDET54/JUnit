package basicAuthentication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicAuthentication {

    /*
    1.Bir class olusturun : BasicAuthentication
    2.https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3.asagidaki yontem ve test datalarini kullanarak authentication’i yapin
         Html komutu : https://username:password@URL
         Username : admin
         password : admin
    4.Basarili sekilde sayfaya girildigini dogrulayin
     */

    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Thread.sleep(4000);
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Thread.sleep(4000);
        WebElement afterAuthenticationMessage = driver.findElement(By.cssSelector(".example"));
        System.out.println("afterAuthenticationMessage = " + afterAuthenticationMessage.getText());
        Assert.assertTrue(afterAuthenticationMessage.isDisplayed());

        driver.close();

    }

}
