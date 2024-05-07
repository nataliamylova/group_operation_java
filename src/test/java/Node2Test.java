import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class Node2Test extends BaseTest {

    private static final By MANAGE_JENKINS = By.xpath("//a[contains(.,'Manage Jenkins')]");
    private static final By NODES = By.xpath("//dt[.='Nodes']");
    private static final By NEW_NODE = By.cssSelector(".jenkins-button--primary");
    private static final By NEW_NODE_NAME = By.xpath("//input[@id='name']");
    private static final By LABEL_RADIO = By.tagName("label");
    private static final By BUTTON_CREATE = By.xpath("//button[@id='ok']");
    private static final By BUTTON_SAVE = By.name("Submit");
    private static final By NODE_MENU = By.xpath("//a[.='Nodes']");
    private static final By DELETE = By.xpath("//span[.='Delete Agent']");

    @Test
    public void testRenameFolder() {
        getDriver().findElement(MANAGE_JENKINS).click();
        getDriver().findElement(NODES).click();
        getDriver().findElement(NEW_NODE).click();
        getDriver().findElement(NEW_NODE_NAME).click();
        getDriver().findElement(NEW_NODE_NAME).sendKeys("New Node2");
        getDriver().findElement(LABEL_RADIO).click();
        getDriver().findElement(BUTTON_CREATE).click();
        getDriver().findElement(BUTTON_SAVE).click();
        WebElement newNode = getDriver().findElement(By.xpath("//a[.='New Node2']"));

        Assert.assertTrue(newNode.isDisplayed());
    }
}