package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class MainPage {

    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    //вопросы о важном. сравниваем, что вопросы в массиве == вопросам на странице

    public void clickImportantQuestion() {
        String[] expectedText = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."}; //можешь чего-нибудь исправить, чтобы получить ошибку

        for (int i = 0; i <8 ; i++) {

            By item = By.id("accordion__heading-"+i);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(item));
            driver.findElement(item).click();

            By item2 = By.id("accordion__panel-"+i); // рабочий вариант
            // By item2 =  By.xpath("//div[@id='accordion__panel-"+i+"']"); // тоже рабочий вариант

            System.out.println(expectedText[i]);
            try {
                Thread.sleep(500); // задержка , чтобы при необходимости, визуально проконтролировать, что все пункты "О важном" перебраны
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            String actualText = driver.findElement(item2).getText();

            //  System.out.println(actualText);
            assertEquals("Текст не совпадает для строки " + i, expectedText[i], actualText);
        }

    }
}

