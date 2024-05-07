
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.List;


public class SmokeTest extends BaseTest {


        @Test
        public void testWelcome() {
            WebElement welcomeText = getDriver().findElement(By.cssSelector(".empty-state-block > h1"));

            Assert.assertEquals(welcomeText.getText(), "Welcome to Jenkins!");
        }

    @Test
    public void testFreestyleProject(){
         // Correct locator
        getDriver().findElement(By.xpath("//a[.='New Item']")).click();

        //error
        //getDriver().findElement(By.cssSelector("[it='hudson.model.Hudson@57458ec6'] [fill='none']")).click();

        WebElement nameInput = getDriver().findElement(By.id("name"));
        nameInput.click();
        nameInput.sendKeys("FreestyleProject");

        WebElement project = getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']"));
        project.click();

        WebElement buttonOk = getDriver().findElement(By.id("ok-button"));
        buttonOk.click();

        WebElement buttonSave = getDriver().findElement(By.name("Submit"));
        buttonSave.click();

        WebElement dashboard = getDriver().findElement(By.xpath("//a[.='Dashboard']"));
        dashboard.click();

        WebElement nameDashboard = getDriver().findElement(By.xpath("//span[.='FreestyleProject']"));
        Assert.assertEquals(nameDashboard.getText(), "FreestyleProject");
    }

    @Test
    public void testDissableFreestyleProject() throws InterruptedException {
        // To press button Disable and to confirm this in main menu
        //open jenkins, log in

        //find New Item, press and input "FreestyleProject"
        getDriver().findElement(By.xpath("//a[.='New Item']")).click();
        Thread.sleep(2500);

        WebElement nameInput = getDriver().findElement(By.id("name"));
        nameInput.click();
        nameInput.sendKeys("FreestyleProject");
        Thread.sleep(2500);

        //Press FreestyleProject (locator?)
        WebElement project = getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']"));
        project.click();
        Thread.sleep(2500);
        WebElement buttonOk = getDriver().findElement(By.id("ok-button"));
        buttonOk.click();
        Thread.sleep(2500);


        WebElement writeDescription = getDriver().findElement(By.name("description"));
        writeDescription.click();
        writeDescription.sendKeys("Description");
        Thread.sleep(2500);
        WebElement buttonSubmit = getDriver().findElement(By.name("Submit"));
        buttonSubmit.click();
        Thread.sleep(2500);
        //Dissable Project
        WebElement dissableProject = getDriver().findElement(By.name("Submit"));
        dissableProject.click();
        Thread.sleep(2500);
        WebElement dashboardAgain = getDriver().findElement(By.xpath("//a[.='Dashboard']"));
        dashboardAgain.click();
        Thread.sleep(3500);
    }


    @Test
    public void testCreateNewFolder() throws InterruptedException {

        getDriver().findElement(By.xpath("//a[.='New Item']")).click();
        getDriver().findElement(By.id("name")).click();
        getDriver().findElement(By.id("name")).sendKeys("NewFolder");
        getDriver().findElement(By.xpath("//label[.='Folder']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.name("Submit")).click();

        getDriver().findElement(By.xpath("//a[.='Dashboard']")).click();

        WebElement element1 = getDriver().findElement(By.xpath("//span[.='NewFolder']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element1).perform();

        getDriver().findElement(By.xpath("//tr[@id='job_NewFolder']//button[@class='jenkins-menu-dropdown-chevron']")).click();


        getDriver().findElement(By.cssSelector("[href='/job/NewFolder/doDelete']")).click();

        getDriver().findElement(By.xpath("//button[@class='jenkins-button jenkins-button--primary ']")).click();

        Assert.assertEquals(getDriver().findElement(By.cssSelector(".empty-state-block > h1")).getText(), "Welcome to Jenkins!");
    }
}