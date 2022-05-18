package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {

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

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        int creat = 100;
        createButtons(creat);
        int delete = 50;
        if (creat > delete) {
            deleteButtonsAndValidate(delete);
            WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']"));
            String[] deleteButtonArr = deleteButton.getText().split("ete");
            Assert.assertEquals(creat - delete, deleteButtonArr.length);
        } else System.out.println("Creat Delete'den kucuk ve ya Delete'ye esit olamaz");


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
