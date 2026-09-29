import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoAlert {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setBrowserVersion("153");
        WebDriver chromeDriver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));

        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://the-internet.herokuapp.com/javascript_alerts");

        By byBtnClickAlert = By.xpath("//button[text()='Click for JS Alert']");
        WebElement btnClickAlert = wait.until(ExpectedConditions.elementToBeClickable(byBtnClickAlert));
        btnClickAlert.click();

        //switch to alert
        Alert normalAlert = chromeDriver.switchTo().alert();
        System.out.println(normalAlert.getText());
        normalAlert.accept();

        By byBtnConfirmAlert = By.xpath("//button[text()='Click for JS Confirm']");
        WebElement btnConfirmAlert = wait.until(ExpectedConditions.elementToBeClickable(byBtnClickAlert));
        btnConfirmAlert.click();

        //switch to confirm alert
        Alert confirmAlert = chromeDriver.switchTo().alert();
        confirmAlert.accept(); // click OK
//        confirmAlert.dismiss(); // click Cancel

        By byLblResult = By.id("result");
        WebElement lblResult = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblResult));
        System.out.println(lblResult.getText());

        chromeDriver.quit();
    }
}
