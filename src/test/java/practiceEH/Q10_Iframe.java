package practiceEH;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Q10_Iframe {
    /*
  // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
  // web sitesini maximize yapin
  // ikinci emojiye tıklayın
  // tüm ikinci emoji öğelerini tıklayın
  // parent iframe e geri donun
  // formu doldurun,(Formu istediğiniz metinlerle doldurun)
  //  apply button a basin
*/
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // web sitesini maximize yapin
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // ikinci emojiye tıklayın
        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> ikinciEmojiOgeleriList = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));
        for (WebElement each : ikinciEmojiOgeleriList) {
            each.click();
        }

        // parent iframe e geri donun
        driver.switchTo().parentFrame();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        WebElement personalizeText = driver.findElement(By.xpath("//input[@id='text']"));
        actions.click(personalizeText).perform();
        for (int i = 0; i < 11; i++) {
            actions.sendKeys(faker.name().username()).
                    sendKeys(Keys.TAB).perform();
        }
        //  apply button a basin
        actions.sendKeys(Keys.ENTER).perform();

        driver.close();

    }

}
