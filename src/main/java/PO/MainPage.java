package PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MainPage extends BasePage {

    public MainPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public MainPage click_goBtn() {
        mainPageLoadingWait();
        go_button = driver.findElementByAccessibilityId(go_button_id);
        go_button.click();
        return this;
    }

    public MainPage valuesGetting() {
        testEndingWait();
        valuesList = driver.findElementsByAndroidUIAutomator(values_resourceID);
        titlesList = driver.findElementsByAndroidUIAutomator(titles_resourceID);
        return this;
    }

    public void showResults() {
        System.out.println("<===========================================>");
        for (int i = 0; i < valuesList.size(); i++) {
            if (i > 2)
                System.out.println(titlesList.get(i).getText()
                                + ": " + valuesList.get(i).getText() + " Mbps");
            else System.out.println(titlesList.get(i).getText()
                    + ": " + valuesList.get(i).getText());
        }
    }
}
