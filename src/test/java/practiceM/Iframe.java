package practiceM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Iframe {

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://html.com/tags/iframe/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)", "");

        WebElement frameElementi = driver.findElement(By.xpath("//*[@id=\"post-164\"]/div/div[3]/iframe"));
        driver.switchTo().frame(frameElementi);

        driver.findElement(By.xpath("//body[@class='date-20220518 en_US ltr  site-center-aligned site-as-giant-card webkit webkit-537']")).click();

        driver.close();

    }

}
