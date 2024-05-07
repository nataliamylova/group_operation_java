package examplesFirsts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

import static org.example.Main.getPad;
import static org.example.Main.getSum;
import static org.testng.Assert.assertEquals;

public class sampleTest {

    @Test
    public void testUrl() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        Thread.sleep(1000);
// Получаем текущий URL
        String currentUrl = driver.getCurrentUrl();

// Ожидаемый URL
        String expectedUrl = "https://www.selenium.dev/";

// Проверяем, совпадает ли текущий URL с ожидаемым
        Assert.assertEquals(currentUrl, expectedUrl);

        driver.quit();

    }

    @Test
    public void testRefresh() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        Thread.sleep(1000);

        String urlBeforeRefresh = driver.getCurrentUrl();

// Обновляем страницу
        driver.navigate().refresh();

// Получаем текущий URL после обновления страницы
        String urlAfterRefresh = driver.getCurrentUrl();

// Проверяем, что URL остался таким же
        Assert.assertEquals(urlAfterRefresh, urlBeforeRefresh);
        driver.quit();

    }
}