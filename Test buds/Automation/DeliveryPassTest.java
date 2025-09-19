import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DeliveryPassTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/checkouts/cn/Z2NwLXVzLWNlbnRyYWwxOjAxSlZSR1FLV044UjhYUlM1QkhYWjhKSFdS");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        email.sendKeys("mohamedsaad2010@gmail.com");
        System.out.println("Email entered.");

   
        Thread.sleep(2000);

        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TextField0")));
        firstNameField.sendKeys("Ahmed");

        WebElement lastNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TextField1")));
        lastNameField.sendKeys("Ali");

        WebElement addressField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TextField2")));
        addressField.sendKeys("123 Cairo St");

        WebElement apartmentField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TextField3")));
        apartmentField.sendKeys("Apt 4");

        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TextField4")));
        cityField.sendKeys("El Mahala");

        WebElement governorateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("Select1")));
        Select selectGovernorate = new Select(governorateDropdown);
        selectGovernorate.selectByVisibleText("Gharbia"); // اختار المحافظة

        WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TextField6")));
        phoneField.sendKeys("+20123456789");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("save_shipping_information")));
        saveButton.click();
        System.out.println("Shipping info saved.");

        Thread.sleep(3000); // انتظار تحميل صفحة الدفع

        WebElement cashOnDelivery = wait.until(ExpectedConditions.elementToBeClickable(By.id("basic-paymentOnDelivery")));
        cashOnDelivery.click();

        WebElement sameAsShipping = wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_address_selector-shipping_address")));
        sameAsShipping.click();

        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-pay-button")));
        if (confirmation.isDisplayed()) {
            System.out.println("Pass: Delivery address saved successfully and moved to payment.");
        } else {
            System.out.println("Fail: Delivery address not saved correctly.");
        }

        driver.quit();
        System.out.println("Test completed.");
    }
}
