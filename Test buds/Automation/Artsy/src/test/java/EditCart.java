import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class EditCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://artsysilver.co/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"block-template--16727121887461__2dc87c0a-2e9a-4c60-853c-f99b8effb971-695d9b5f-446a-49c8-aa63-e105be8fcb48\"]/div[1]/div/product-item[1]/div[1]/a/img[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"AddToCart\"]/span[1]")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"block-template--16727121887461__2dc87c0a-2e9a-4c60-853c-f99b8effb971-695d9b5f-446a-49c8-aa63-e105be8fcb48\"]/div[1]/div/product-item[4]/div[1]/a/img[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"AddToCart\"]/span[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"mini-cart-form\"]/line-item[2]/div/div[1]/line-item-quantity/div/input")).sendKeys("2");





//        Thread.sleep(2000);
//        driver.quit();


    }
}
