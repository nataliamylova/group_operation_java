

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class OrganizationFolder2Test extends BaseTest{
//создание папки

    @Test
    public void testCreateOrganizationFolder() {
        getDriver().findElement(By.xpath("//a[.='New Item']")).click();
        getDriver().findElement(By.id("name")).click();
        getDriver().findElement(By.id("name")).sendKeys("New Organization Folder");
        getDriver().findElement(By.xpath("//label[.='Organization Folder']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.name("Submit")).click();

        getDriver().findElement(By.xpath("//a[.='Dashboard']")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//span[.='New Organization Folder']")).isDisplayed());
    }

    //Natalia
    @Test(dependsOnMethods = "testCreateOrganizationFolder")
    public void testRenameOrganizationFolder() {
        getDriver().findElement(By.xpath("//span[.='New Organization Folder']")).click();
        getDriver().findElement(By.xpath("//a[contains(.,'Rename')]")).click();
        getDriver().findElement(By.xpath("//input[@name='newName']")).clear();
        getDriver().findElement(By.xpath("//input[@name='newName']")).sendKeys(
                "Organization Folder");
        getDriver().findElement(By.xpath("//button[@name='Submit']")).click();

        getDriver().findElement(By.xpath("//a[.='Dashboard']")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath(
                "//span[.='Organization Folder']")).isDisplayed());
    }

    //Natasha
    @Test(dependsOnMethods = "testRenameOrganizationFolder")
    public void testOrganizationFolderAddDescription(){

        getDriver().findElement(By.xpath("//span[.='Organization Folder']")).click();
        getDriver().findElement(By.xpath("//*[@href='/job/Organization%20Folder/configure']")).click();

        getDriver().findElement(By.xpath("//textarea[@name='_.description']")).sendKeys("Some description of the folder");
        getDriver().findElement(By.xpath("//div/*[@name='Submit']")).click();

        String textOfDescription = getDriver().findElement(By.xpath("//div/*[@id='view-message']")).getText();

        Assert.assertEquals(textOfDescription,"Some description of the folder");
    }

    @Test(dependsOnMethods = "testOrganizationFolderAddDescription")
    public void testDisableOrganizationFolder() {
        getDriver().findElement(By.xpath("//span[.='Organization Folder']")).click();
        getDriver().findElement(By.xpath("//button[@name='Submit']")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//form[@id='enable-project']")).isDisplayed());
    }

    @Test(dependsOnMethods = "testDisableOrganizationFolder")
    public void testEnableOrganizationFolder() {
        getDriver().findElement(By.xpath("//span[.='Organization Folder']")).click();
        getDriver().findElement(By.xpath("//button[@name='Submit']")).click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//form[@id='disable-project']")).isDisplayed());
    }

    //Elena
    @Test(dependsOnMethods = "testEnableOrganizationFolder")
    public void testDeleteOrganizationFolder() {

        getDriver().findElement(By.xpath("//span[.='Organization Folder']")).click();

        getDriver().findElement(By.xpath("//a[@data-title='Delete Organization Folder']")).click();

        getDriver().findElement(By.xpath("//button[@data-id='ok']")).click();

        List<WebElement> jobList = getDriver().findElements(
                By.xpath("//span[.='Organization Folder']"));

        Assert.assertTrue(jobList.isEmpty());
    }

    private void createOrganizationFolder(String folderName) {
        getDriver().findElement(By.xpath("//a[.='New Item']")).click();
        getDriver().findElement(By.id("name")).click();
        getDriver().findElement(By.id("name")).sendKeys(folderName);
        getDriver().findElement(By.xpath("//label[.='Organization Folder']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.name("Submit")).click();
        getDriver().findElement(By.xpath("//a[.='Dashboard']")).click();
    }

    @Test(dependsOnMethods = "testDeleteOrganizationFolder")
    public void testCreateMultipleOrganizationFoldersSecond() {

        for (int i = 1; i <= 9; i++) {
            createOrganizationFolder("New Organization Folder " + i);
        }

        getDriver().findElement(By.xpath("//a[@href='/newView']")).click();
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("New view 2");

        getDriver().findElement(By.xpath("//label[.='List View']")).click();
        getDriver().findElement(By.xpath("//button[@id='ok']")).click();

        for (int i = 1; i <= 9; i += 2) { // начиная с 2 и шаг 2, чтобы добавить только четные номера
            if (i % 2 != 0) {
                getDriver().findElement(By.xpath("//label[.='New Organization Folder " + i + "']")).click();
            }
        }
        getDriver().findElement(By.xpath("//button[@name='Submit']"))
                .click();

        getDriver().findElement(By.xpath("//a[@href='/newView']")).click();
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("New view 3");

        getDriver().findElement(By.xpath("//label[.='List View']")).click();
        getDriver().findElement(By.xpath("//button[@id='ok']")).click();

        for (int i = 2; i <= 9; i += 2) { // начиная с 2 и шаг 2, чтобы добавить только четные номера
            if (i % 2 == 0) {
                getDriver().findElement(By.xpath("//label[.='New Organization Folder " + i + "']")).click();
            }
        }
        getDriver().findElement(By.xpath("//button[@name='Submit']"))
                .click();

        Assert.assertTrue(getDriver().findElement(By.xpath("//a[.='New view 2']"))
                .isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//a[.='New view 3']"))
                .isDisplayed());
        }

}


