import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NotepadTest {

    private WindowsDriver notepadSession = null;
    private NotepadPO notepad = null;


    @BeforeClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("appium:deviceName", "WindowsPC");
        capabilities.setCapability("appium:app", "C:\\Windows\\System32\\notepad.exe");
        try{
            notepadSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            notepad = new NotepadPO(notepadSession);
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Failed to create session. Ensure Appium server is running.");
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (notepadSession != null) {
            notepadSession.quit();
        }
    }

    @Test
    public void testNotepad() {
        notepad.textEditor().sendKeys("Test Automation with WinAppDriver");
        Assert.assertEquals(notepad.textEditor().getText(), "Test Automation with WinAppDriver");
        notepad.textEditor().sendKeys(Keys.chord(Keys.CONTROL, "w"));
        notepad.dialogCancelButton().click();
        Assert.assertEquals(notepad.textEditor().getText(), "Test Automation with WinAppDriver");
        notepad.textEditor().sendKeys(Keys.chord(Keys.CONTROL, "w"));
        notepad.dialogDontSaveButton().click();
    }
}
