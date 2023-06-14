import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;

public class TestMainPage {

    WebDriver driver = new ChromeDriver();
    //  WebDriver driver = new FirefoxDriver(); // для мозилы

    @Before
    public void startUp() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

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
