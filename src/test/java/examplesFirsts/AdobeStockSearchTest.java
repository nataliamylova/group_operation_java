package examplesFirsts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AdobeStockSearchTest {

    @Test
    public static void main(String[] args) {
        searchImagesWithKeyword("ai");
    }

    public static void searchImagesWithKeyword(String keyword) {

        // Создаем экземпляр WebDriver
        WebDriver driver = new ChromeDriver();

        // Указываем полный URL-адрес Adobe Stock
        driver.get("https://stock.adobe.com/pt/");


        WebElement searchField = driver.findElement(By.name("keyword"));
        searchField.click();
        searchField.sendKeys("ai");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='sc-CtfFt sc-laTMn hhdEHh']"));
        searchButton.click();

        // Находим все элементы результата поиска (изображения)
        List<WebElement> searchResults = driver.findElements(By.tagName("picture"));

        // Проверяем, что результаты поиска не пусты
        assert !searchResults.isEmpty() : "Результаты поиска изображений с ключевым словом \"" + keyword + "\" не найдены";

        // Выводим сообщение, что тест успешно завершен, если утверждения не выдали ошибку
        System.out.println("Тест успешно завершен. Найдено " + searchResults.size() + " изображений с ключевым словом \"" + keyword + "\"");

        // Закрываем браузер после выполнения теста
        driver.quit();
    }
}

