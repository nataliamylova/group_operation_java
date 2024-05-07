//package school.redrover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class NodeTest extends BaseTest {

    private static final By MANAGE_JENKINS = By.xpath("//a[contains(.,'Manage Jenkins')]");
    private static final By NODES = By.xpath("//dt[.='Nodes']");
    private static final By NEW_NODE = By.cssSelector(".jenkins-button--primary");
    private static final By NEW_NODE_NAME = By.xpath("//input[@id='name']");
    private static final By LABEL_RADIO = By.tagName("label");
    private static final By BUTTON_CREATE = By.xpath("//button[@id='ok']");
    private static final By BUTTON_SAVE = By.name("Submit");
    private static final By NODE_MENU = By.xpath("//a[.='Nodes']");
    private static final By DELETE = By.xpath("//span[.='Delete Agent']");



    private void createNewFolder(String folderName) {
//        getDriver().findElement(By.xpath("//a[.='New Item']")).click();
//        getDriver().findElement(By.id("name")).click();
//        getDriver().findElement(By.id("name")).sendKeys(folderName);
//        getDriver().findElement(By.xpath("//label[.='Folder']")).click();
//        getDriver().findElement(By.id("ok-button")).click();
//        getDriver().findElement(By.name("Submit")).click();
    }
//    @Test
//    public void testRenameFolder() {
//        getDriver().findElement(MANAGE_JENKINS).click();
//        getDriver().findElement(NODES).click();
//        getDriver().findElement(NEW_NODE).click();
//        getDriver().findElement(NEW_NODE_NAME).click();
//        getDriver().findElement(NEW_NODE_NAME).sendKeys("New Node");
//        getDriver().findElement(LABEL_RADIO).click();
//        getDriver().findElement(BUTTON_CREATE).click();
//        getDriver().findElement(BUTTON_SAVE).click();

        // for delete - disconect node and in left menu
        // как проверить, что node не активен.
        // как найти N/A именно в нужной строчке?
            }


//By.xpath("//table[@id='computers']//tr[1]/td[4]")
//    By.xpath("//table[@id='computers']//tr[1]/td[4]")