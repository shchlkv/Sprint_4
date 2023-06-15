package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainPage {
    private final WebDriver driver;
    private final By arrowExpandText; // стрелка раскрыть список
    private final By answerText;
    public MainPage(WebDriver driver, int questionIndex) {
        this.driver = driver;
        arrowExpandText = By.id(String.format("accordion__heading-%d", questionIndex));
        answerText = By.id(String.format("accordion__panel-%d", questionIndex));
    }
    public void clickArrow() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(arrowExpandText));
        WebElement element = driver.findElement(arrowExpandText);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    public String getAnswer() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(answerText));
        return driver.findElement(answerText).getText();
    }
}