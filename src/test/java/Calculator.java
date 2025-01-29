import io.appium.java_client.AppiumBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Calculator {

    private WindowsDriver calcsession = null;
    private WebElement calcresult = null;

    @BeforeClass
    public void setUp(){
        System.out.println("Opening the Calculator");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("appium:deviceName", "WindowsPC");
        capabilities.setCapability("appium:app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try{
            calcsession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Failed to create session. Ensure Appium server is running.");
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Closing the Calculator");
        if (calcsession != null) {
            calcsession.quit();
        }
    }

    @BeforeMethod
    public void clear(){
        System.out.println("Clearing the Calculator");
        calcsession.findElement(AppiumBy.accessibilityId("clearButton")).click();
    }

    @Test
    public void addition(){
        System.out.println("Running Addition Operation");
        calcsession.findElement(AppiumBy.accessibilityId("num2Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("plusButton")).click();
        calcsession.findElement(AppiumBy.accessibilityId("num7Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("equalButton")).click();
        Assert.assertEquals(GetDisplayResult(), "9");
    }

    @Test
    public void multiplication(){
        System.out.println("Running Multiplication Operation");
        calcsession.findElement(AppiumBy.accessibilityId("num6Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("multiplyButton")).click();
        calcsession.findElement(AppiumBy.accessibilityId("num9Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("equalButton")).click();
        Assert.assertEquals(GetDisplayResult(), "54");
    }

    @Test
    public void division(){
        System.out.println("Running Division Operation");
        calcsession.findElement(AppiumBy.accessibilityId("num8Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("divideButton")).click();
        calcsession.findElement(AppiumBy.accessibilityId("num2Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("equalButton")).click();
        Assert.assertEquals(GetDisplayResult(), "4");
    }

    @Test
    public void subtraction(){
        System.out.println("Running Subtraction Operation");
        calcsession.findElement(AppiumBy.accessibilityId("num9Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("minusButton")).click();
        calcsession.findElement(AppiumBy.accessibilityId("num3Button")).click();
        calcsession.findElement(AppiumBy.accessibilityId("equalButton")).click();
        Assert.assertEquals(GetDisplayResult(), "6");
    }

    public String GetDisplayResult(){
        WebDriverWait wait = new WebDriverWait(calcsession, Duration.ofSeconds(10));
        calcresult = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("CalculatorResults")));
        return calcresult.getText().replace("A exibição é", "").trim();
    }
}