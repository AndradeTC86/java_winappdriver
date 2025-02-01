import io.appium.java_client.AppiumBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPO {

    private WindowsDriver driver = null;

    public CalculatorPO(WindowsDriver wd){
        driver = wd;
    }

    public WebElement getNumButton(int num){
        return driver.findElement(AppiumBy.accessibilityId("num" + num + "Button"));
    }

    public WebElement getOperatorButton(String operator){
        return driver.findElement(AppiumBy.accessibilityId(operator + "Button"));
    }

    public String GetDisplayResult(){
        return driver.findElement(AppiumBy.accessibilityId("CalculatorResults"))
                .getText().replace("A exibição é ", "").trim();
    }
}
