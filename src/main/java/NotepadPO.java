import io.appium.java_client.AppiumBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class NotepadPO {

    private WindowsDriver driver = null;

    public NotepadPO(WindowsDriver wd) {
        driver = wd;
    }

    public WebElement minimizeButton() {
        return driver.findElement(AppiumBy.name("Minimizar"));
    }

    public WebElement maximizeButton() {
        return driver.findElement(AppiumBy.name("Maximizar"));
    }

    public WebElement closeButton() {
        return driver.findElement(AppiumBy.name("Fechar"));
    }

    public WebElement closeGuideButton() {
        return driver.findElement(AppiumBy.accessibilityId("CloseButton"));
    }

    public WebElement createNewGuideButton() {
        return driver.findElement(AppiumBy.accessibilityId("AddButton"));
    }

   public WebElement menuFile() {
        return driver.findElement(AppiumBy.accessibilityId("File"));
    }

    public WebElement menuEdit() {
        return driver.findElement(AppiumBy.accessibilityId("Edit"));
    }

    public WebElement menuView() {
        return driver.findElement(AppiumBy.accessibilityId("View"));
    }

    public WebElement textEditor() {
        return driver.findElement(AppiumBy.name("Editor de texto"));
    }

    public WebElement dialogSaveButton() {
        return driver.findElement(AppiumBy.name("Salvar"));
    }

    public WebElement dialogDontSaveButton() {
        return driver.findElement(AppiumBy.name("Não salvar"));
    }

    public WebElement dialogCancelButton() {
        return driver.findElement(AppiumBy.name("Cancelar"));
    }

}
