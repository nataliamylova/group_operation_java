package examplesFirsts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Test

public class jenkinsTests {

    @Test
    public void testUrl() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        Thread.sleep(1000);

        WebElement usernameField = driver.findElement(By.id("j_username"));
        usernameField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.id("j_password"));
        passwordField.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.name("Submit"));
        loginButton.click();

        driver.findElement(By.cssSelector("[it='hudson.model.Hudson@57458ec6'] [fill='none']")).click();
        Thread.sleep(500);
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.click();
        nameInput.sendKeys("firstName1");
        Thread.sleep(500);

        WebElement project = driver.findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']"));
        project.click();

        WebElement buttonOk = driver.findElement(By.id("ok-button"));
        buttonOk.click();

        WebElement buttonSave = driver.findElement(By.name("Submit"));
        buttonSave.click();

        WebElement dashboard = driver.findElement(By.xpath("//a[.='Dashboard']"));
        dashboard.click();

        WebElement nameDashboard = driver.findElement(By.xpath("//span[.='firstName1']"));
        nameDashboard.click();

        Thread.sleep(1500);

        WebElement addDescription = driver.findElement(By.id("description-link"));
        addDescription.click();
        addDescription.sendKeys("Description");

        WebElement buttonSubmit = driver.findElement(By.name("Submit"));
        buttonSubmit.click();

        WebElement dissableProject = driver.findElement(By.name("Submit"));
        dissableProject.click();

        WebElement dashboardAgain = driver.findElement(By.xpath("//a[.='Dashboard']"));
        dashboardAgain.click();

        WebElement dissable = driver.findElement(By.xpath("//tr[@class='disabledJob job-status-disabled']/td[@class='jenkins-table__cell--tight jenkins-table__icon']"));




        // Assert.assertEquals(nameDashboard.getText(), "firstName1");

        driver.quit();
    }
}