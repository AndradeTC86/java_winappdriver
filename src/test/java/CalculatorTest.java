import io.appium.java_client.windows.WindowsDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    private WindowsDriver calcsession = null;
    private CalculatorPO calc = null;


    @BeforeClass
    public void setUp(){
        System.out.println("Opening the Calculator");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("appium:deviceName", "WindowsPC");
        capabilities.setCapability("appium:app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try{
            calcsession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            calc = new CalculatorPO(calcsession);
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
        calc.getOperatorButton("clear").click();
    }

    @Test
    public void addition(){
        calc.getNumButton(2).click();
        calc.getOperatorButton("plus").click();
        calc.getNumButton(7).click();
        calc.getOperatorButton("equal").click();
        Assert.assertEquals(calc.GetDisplayResult(), "9");
    }

    @Test
    public void multiplication(){
        calc.getNumButton(6).click();
        calc.getOperatorButton("multiply").click();
        calc.getNumButton(9).click();
        calc.getOperatorButton("equal").click();
        Assert.assertEquals(calc.GetDisplayResult(), "54");
    }

    @Test
    public void division(){
        calc.getNumButton(8).click();
        calc.getOperatorButton("divide").click();
        calc.getNumButton(2).click();
        calc.getOperatorButton("equal").click();
        Assert.assertEquals(calc.GetDisplayResult(), "4");
    }

    @Test
    public void subtraction(){
        calc.getNumButton(9).click();
        calc.getOperatorButton("minus").click();
        calc.getNumButton(3).click();
        calc.getOperatorButton("equal").click();
        Assert.assertEquals(calc.GetDisplayResult(), "6");
    }
}