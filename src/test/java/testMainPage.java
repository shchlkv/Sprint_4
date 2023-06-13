import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;
//import page.OrderPage;

import java.util.concurrent.TimeUnit;


public class testMainPage {

    WebDriver driver = new ChromeDriver();
    //  WebDriver driver = new FirefoxDriver(); // для мозилы

    @Before
    public void startUp() {


        driver.get("https://qa-scooter.praktikum-services.ru/");
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void testAccordion() {

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickImportantQuestion(); // перебор вопросов
    }

    @After
    public void browserOff() {
        driver.quit();
    }
}
