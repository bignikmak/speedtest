import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

public class TestSetUp {
    public AndroidDriver<AndroidElement> driver;
    String pathToApp = "C:\\Users\\User\\IdeaProjects\\appflame_test\\speed.apk";
    //path can be changed to actual locale address

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                desiredCapabilities);
        if (!driver.isAppInstalled("org.zwanoo.android.speedtest")) {
            System.out.println("App is not installed. Installing...");
            driver.installApp(pathToApp);
        } else System.out.println("App is installed. Starting...");
        driver.quit();
        desiredCapabilities.setCapability("appPackage", "org.zwanoo.android.speedtest");
        desiredCapabilities.setCapability("appActivity", "com.ookla.mobile4.screens.main.MainActivity");
        desiredCapabilities.setCapability("noReset", true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                desiredCapabilities);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
