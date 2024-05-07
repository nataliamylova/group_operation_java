//package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class FolderRenameTest extends BaseTest {
    private static final By NEW_NAME = By.xpath("//input[@name='newName']");


    private static final By MANAGE_JENKINS = By.xpath("//span[.='Manage Jenkins']");
    private static final By NODES = By.xpath("//dt[.='Nodes']");
    private static final By NEW_NODE = By.cssSelector(".jenkins-button--primary");



    private void createNewFolder(String folderName) {
        getDriver().findElement(By.xpath("//a[.='New Item']")).click();
        getDriver().findElement(By.id("name")).click();
        getDriver().findElement(By.id("name")).sendKeys(folderName);
        getDriver().findElement(By.xpath("//label[.='Folder']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.name("Submit")).click();
    }
    @Test
    public void testRenameFolder() {
        final String folderName = "New folder";
        createNewFolder(folderName);

        getDriver().findElement(By.linkText("Rename")).click();
        getDriver().findElement(NEW_NAME).clear();
        getDriver().findElement(NEW_NAME).sendKeys("Newest Folder");
        getDriver().findElement(By.xpath("//button[@name='Submit']")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//h1[contains(.,'Newest Folder')]")).isDisplayed());
    }
}
