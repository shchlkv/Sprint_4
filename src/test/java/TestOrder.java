import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;
import page.OrderPage;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestOrder {

    WebDriver driver = new ChromeDriver();
   //  WebDriver driver = new FirefoxDriver();

    final String buttonOrder;
    final String firstName;
    final String name;
    final String address;
    final String phone;
    final String comment;

    public TestOrder(String buttonOrder, String firstName, String name, String address, String phone, String comment) {
        this.buttonOrder = buttonOrder;
        this.firstName = firstName;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.comment = comment;

    }
    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][] {
                {"0", "Петров", "Иван", "Адрес 1", "+7999999991", "пивка захвати"}, //заказ через верхнюю кнопку
                {"1", "Иванов", "Петр", "Адрес 2", "+7999999992", "без комментариев"} //заказ через нижнюю кнопку
        };
    }

    @Before
    public void startUp() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testOrdering() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.clickButtonCookie();
        objOrderPage.findButtonAndOrder(buttonOrder);
        objOrderPage.userName(firstName);
        objOrderPage.userSecondName(name);
        objOrderPage.userAddress(address);
        objOrderPage.userPhone(phone);
        objOrderPage.metroStation();
        objOrderPage.metroStationChoice();
        objOrderPage.nextPageButton();
        objOrderPage.calendarDate();
        objOrderPage.rentalDuration();
        objOrderPage.scooterColor();
        objOrderPage.userComment(comment);
        objOrderPage.orderButton();
        objOrderPage.confirmButton();
        assertTrue("Тест отработал с ошибкой: ", objOrderPage.createdOrder());
    }

    @After
    public void browserOff()
    {
        driver.quit();
    }
}