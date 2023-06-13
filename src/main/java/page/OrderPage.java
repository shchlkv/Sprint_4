package page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.By.*;

public class OrderPage {
    private final WebDriver driver;
    //1я страница
    private final By buttonCookie = id("rcc-confirm-button"); //кнопка антикуки
    //private final By buttonOrderUp = className("Button_Button__ra12g"); //кнопка Заказать верхняя
    // private final By buttonOrderDawn = xpath("//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']"); //кнопка Заказать нижняя
    //2я страница
    private final By fieldName = xpath("//input[@placeholder='* Имя']"); //Имя.
    private final By fieldSecondName = xpath("//div[@class='Input_InputContainer__3NykH']//input[@placeholder='* Фамилия']"); //Фамилия
    private final By fieldAddress = xpath("//div[@class='Input_InputContainer__3NykH']//input[@placeholder='* Адрес: куда привезти заказ']"); //Адрес: Куда привезти
    private final By fieldPhone = xpath("//div[@class='Order_Form__17u6u']/div[5]/input"); //Телефон: на него позвонит курьер
    private final By fieldMetro = xpath("//div[@class='Order_Form__17u6u']/div[4]"); //Станция метро
    private final By metroStationChoice = xpath("//div[@class='select-search__select']/ul/li/button/div[2]"); //Выбрать станцию
    private final By nextPageButton = xpath("//button[contains(@class, 'Button_Button__ra12g') and text()='Далее']"); // "Далее"
    //3я страница
    private final By calendarDate = xpath("//div[@class='Order_Form__17u6u']/div/div/div/input");  //Когда привезти самокат
    private final By rentPeriod = xpath("//div[@class='Dropdown-control']"); //Срок аренды
    private final By rentChoice = xpath("//div[@class='Dropdown-menu']/div[4]"); //Выбор срока аренды (из выпадающего списка)
    private By scooterColor = xpath("//div[@class='Order_Checkboxes__3lWSI']//label[1]/input"); // Цвет самоката 1 чекбокс
    //private final By scooterColor = xpath("//div[@class='Order_Checkboxes__3lWSI']/label[2]"); //Цвет самоката 2 чекбокс
    private final By userComment = xpath("//div[contains(@class, 'Input_InputContainer')]/input[contains(@class, 'Input_Input') and contains(@class, 'Input_Responsible') and @placeholder='Комментарий для курьера']");  //Комментарий для курьера
    private final By orderButton = xpath("//div[@class='Order_Buttons__1xGrp']/button[2]"); //"Заказать"
    private final By confirmButton = xpath("//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]"); //"Да"
    private final By orderCreated = xpath("//*[contains(text(), 'Заказ оформлен')]"); //Заказ оформлен
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // Форматирование даты
    String date = LocalDate.now().plusMonths(1).format(formatter); // Добавить месяц к текущей дате
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonCookie() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonCookie));
        driver.findElement(buttonCookie).click();
    }
    public void findButtonAndOrder(By buttonOrder) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonOrder));
        Object elementOrderButton = driver.findElement(buttonOrder);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementOrderButton);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(buttonOrder));
        driver.findElement(buttonOrder).click();
    }
    public void userName(String firstName){
        driver.findElement(fieldName).sendKeys(firstName);
    }
    public void userSecondName(String name) {
        driver.findElement(fieldSecondName).sendKeys(name);
    }
    public void userAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }
    public void userPhone(String phone) {
        driver.findElement(fieldPhone).sendKeys(phone);
    }
    public void metroStation() {
        driver.findElement(fieldMetro).click();
    }
    public void metroStationChoice() {
        driver.findElement(metroStationChoice).click();
    }
    public void nextPageButton() {
        driver.findElement(nextPageButton).click();
    }
    public void calendarDate() {
        driver.findElement(calendarDate).click();
        driver.findElement(calendarDate).sendKeys(date); //дата доставки
        driver.findElement(calendarDate).sendKeys(Keys.ENTER);
    }
    public void rentalDuration() {
        driver.findElement(rentPeriod).click();
        driver.findElement(rentChoice).click();
    }
    public void scooterColor() {
        driver.findElement(scooterColor).click();
    }
    public void userComment(String comment) {
        driver.findElement(userComment).sendKeys(comment);
    }
    public void orderButton() {
        driver.findElement(orderButton).click();
    }
    public void confirmButton() {
        driver.findElement(confirmButton).click();
    }


    public boolean CreatedOrder() {
        try {
            return driver.findElement(orderCreated).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}