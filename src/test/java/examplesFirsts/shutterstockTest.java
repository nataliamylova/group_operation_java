package examplesFirsts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class shutterstockTest {
    @Test
    public void testUrl() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.shutterstock.com/pt/g/vectorfusionart/video?q=");
        Thread.sleep(1000);

        WebElement search = driver.findElement(By.id("search-bar"));
        search.click();
       search.sendKeys("flower");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorSecondary MuiIconButton-sizeLarge mui-f9dpvf-searchButton-searchIcon']"));
        searchButton.click();
    }
//    @Test
//    public void testAdobe() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://stock.adobe.com/pt/");
//        Thread.sleep(1000);
//
//        WebElement search = driver.findElement(By.name("keyword"));
//        search.click();
//        search.sendKeys("ai");
//
//
//        WebElement searchButton = driver.findElement(By.xpath("//button[@class='sc-CtfFt sc-laTMn hhdEHh']"));
//        searchButton.click();
//
//        WebElement nameDashboard = driver.findElement(By.("strong.text-sregular"));
//
//        Assert.assertEquals(nameDashboard.getText(), "resultados");
//
//// Находим все элементы результата поиска
//        List<WebElement> searchResults = driver.findElements(By.className("searchResult"));
//
//        // Проверяем, что результаты поиска не пусты
//        assert !searchResults.isEmpty() : "Результаты поиска не найдены";
//
//        // Проверяем, что результаты поиска содержат ожидаемый текст
//        boolean found = false;
//        for (WebElement result : searchResults) {
//            if (result.getText().contains(searchQuery)) {
//                found = true;
//                break;
//            }
//        }
//        assert found : "Результаты поиска не содержат ожидаемый текст";
//
//        // Выводим сообщение, что тест успешно завершен, если утверждения не выдали ошибку
//        System.out.println("Тест успешно завершен");
//
//
//    }





}
