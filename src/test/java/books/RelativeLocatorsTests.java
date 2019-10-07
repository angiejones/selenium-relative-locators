package books;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import static org.testng.Assert.assertEquals;

public class RelativeLocatorsTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://automationbookstore.dev/");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

    @Test
    public void test_book5_is_left_of_book6_and_below_book1(){
        String id = driver.findElement(withTagName("li")
                .toLeftOf(By.id("pid6"))
                .below(By.id("pid1")))
                .getAttribute("id");
        assertEquals(id, "pid5");
    }

    @Test
    public void test_book2_is_above_book6_and_right_of_book1(){
        String id = driver.findElement(withTagName("li")
                        .above(By.id("pid6"))
                        .toRightOf(By.id("pid1")))
                .getAttribute("id");
        assertEquals(id, "pid2");
    }
}
