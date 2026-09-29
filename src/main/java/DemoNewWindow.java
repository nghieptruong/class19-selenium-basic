import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DemoNewWindow {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setBrowserVersion("153");
        WebDriver chromeDriver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));

        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://www.letskodeit.com/practice");

        String mainWindowId = chromeDriver.getWindowHandle();
        System.out.println("Main Window ID: " + mainWindowId);

        By byBtnOpenWindow = By.id("openwindow");
        WebElement btnOpenWindow = wait.until(ExpectedConditions.elementToBeClickable(byBtnOpenWindow));
        btnOpenWindow.click();

        //new window popup
        Set<String> allWindows = chromeDriver.getWindowHandles();
        System.out.println(allWindows);

        String newWindowId = "";
        for(String id : allWindows) {
            if(!id.equals(mainWindowId)) {
                newWindowId = id;
            }
        }
        System.out.println("New Window ID: " + newWindowId);

        //switch to new window
        chromeDriver.switchTo().window(newWindowId);
        By byLblAllCourses = By.xpath("//h1[text()='All Courses']");
        WebElement lblAllCourses = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblAllCourses));
        System.out.println("Is Displayed: " + lblAllCourses.isDisplayed());

        chromeDriver.quit();

    }
}
