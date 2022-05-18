package practiceE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3_AddDeleteElement {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted

    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */

    WebDriver driver;

    @Test
    public void test01() {
        int creat = 100;
        int delete = 50;

        if (creat > delete) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

            createButtons(creat);
            deleteButtonsAndValidate(delete);

            WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']"));
            String[] deleteButtonArr = deleteButton.getText().split("ete");
            Assert.assertEquals(creat - delete, deleteButtonArr.length);
        } else System.out.println("Creat Delete'den kucuk ve ya Delete'ye esit olamaz");

        driver.close();
    }

    public void createButtons(int a) {
        for (int i = 0; i < a; i++) {
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        }
    }

    public void deleteButtonsAndValidate(int a) {
        for (int i = 0; i < a; i++) {
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        }
    }

}
