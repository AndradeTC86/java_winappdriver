import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

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
    }

    @Test
    public void addition(){
        System.out.println("Running Addition Operation");
    }

    @Test
    public void multiplication(){
        System.out.println("Running Multiplication Operation");
    }

    @Test
    public void division(){
        System.out.println("Running Division Operation");
    }

    @Test
    public void subtraction(){
        System.out.println("Running Subtraction Operation");
    }
}