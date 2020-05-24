import PO.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MainTest extends TestSetUp {
    private MainPage mainPage;

    @BeforeMethod
    public void testSetUp() throws MalformedURLException {
        mainPage = new MainPage(this.driver);
    }

    @Test
    public void testSpeedTestFunctionality() {
        mainPage.skipSplashScreens();
        mainPage.click_goBtn()
                .valuesGetting()
                .showResults();
    }
}
