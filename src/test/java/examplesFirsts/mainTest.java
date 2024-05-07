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

public class mainTest {

    @Test
    public void testTest () {
    WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

//    String title = driver.getTitle();
//        Assert.assertEquals("Web form", title);


    WebElement textBox = driver.findElement(By.name("my-text"));
        textBox.sendKeys("Selenium");

     WebElement textArea = driver.findElement(By.name("my-textarea"));
     textArea.sendKeys("Sergey");


    WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();



    WebElement message = driver.findElement(By.id("message"));
    String value = message.getText();
    assertEquals("Received!", value);

        driver.quit();
    }

//    @Test
//    public void testYoutube() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.youtube.com/");
//
//        WebElement text = driver.findElement(By.id("search-input"));
//        text.sendKeys("Selenium");
//
////        Thread.sleep(1000);
//
//        WebElement button = driver.findElement(By.id("search-icon-legacy"));
//        button.click();
//
//         driver.quit();
  //  }

    @Test
    public void testDentist() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        WebElement searchField = driver.findElement(By.name("keyword"));
        searchField.sendKeys("exotic");




//        Thread.sleep(1000);

         driver.quit();
    }

    @Test
    public void testPageButtons() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        WebElement link = driver.findElement(By.linkText("Add/Remove Elements"));
        link.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        submitButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        deleteButton.click();

        Thread.sleep(1000);

        boolean isDeleteButtonPresent = driver.findElements(By.xpath("//button[text()='Delete']")).isEmpty();
        Assert.assertTrue(isDeleteButtonPresent, "Delete button should not be present");

        driver.quit();
    }


    @Test
    public void testPage() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.linkText("JavaScript Alerts")).click();

//        driver.navigate().forward();
//
//        driver.findElement(By.linkText("JavaScript Alerts")).click();

        Thread.sleep(500);

        WebElement jsalert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsalert.click();
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");

        driver.quit();
    }

    public void testHyperlink() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.linkText("Redirect Link")).click();
        Thread.sleep(500);

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 200 status code."));
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        driver.findElement(By.linkText("here")).click();

        driver.quit();
    }

//    public void checkBoxes()  {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/checkboxes");
//
//        driver.findElement(By.linkText("Dropdown")).click();
//
//        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
//        check(checkbox1);
//        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());
//
//        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
//        check(checkbox2);
//        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());
//
//        driver.quit();
//    }




    }
