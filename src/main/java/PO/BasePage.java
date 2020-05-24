package PO;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public AndroidDriver<AndroidElement> driver;
    public WebDriverWait wait;

    String next_button_text = "text(\"Next\")";
    String continue_button_text = "text(\"Continue\")";
    String deny_button_text = "text(\"DENY\")";
    MobileBy.ByAccessibilityId goBtn;
    MobileBy.ByAndroidUIAutomator testAgainText;
    String go_button_id;
    AndroidElement next_button;
    AndroidElement continue_button;
    AndroidElement deny_button;
    AndroidElement go_button;
    String values_resourceID = "resourceId(\"org.zwanoo.android.speedtest:id/txt_test_result_value\")";
    String titles_resourceID = "resourceId(\"org.zwanoo.android.speedtest:id/txt_test_result_title\")";

    List<AndroidElement> valuesList = new ArrayList<>();
    List<AndroidElement> titlesList = new ArrayList<>();

    public BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 70);
    }

    public void skipSplashScreens() {
        if (!driver.findElements(new MobileBy.ByAndroidUIAutomator(next_button_text)).isEmpty()) {
            next_button = driver.findElementByAndroidUIAutomator(next_button_text);
            next_button.click();
        }
        if (!driver.findElements(new MobileBy.ByAndroidUIAutomator(continue_button_text)).isEmpty()) {
            continue_button = driver.findElementByAndroidUIAutomator(continue_button_text);
            wait.until(ExpectedConditions.visibilityOf(continue_button));
            continue_button.click();
        }
        if (!driver.findElements(new MobileBy.ByAndroidUIAutomator(continue_button_text)).isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(deny_button));
            deny_button = driver.findElementByAndroidUIAutomator(deny_button_text);
            deny_button.click();
            wait.until(ExpectedConditions.visibilityOf(deny_button));
            deny_button.click();
        }
    }

    public void mainPageLoadingWait() {
        go_button_id = "Start a Speedtest";
        goBtn = new MobileBy.ByAccessibilityId(go_button_id);
        wait.until(ExpectedConditions.visibilityOfElementLocated(goBtn));
    }

    public void testEndingWait() {
        testAgainText = new MobileBy.ByAndroidUIAutomator("text(\"Test Again\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(testAgainText));
    }
}