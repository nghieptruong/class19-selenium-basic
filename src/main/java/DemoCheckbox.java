import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoCheckbox {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setBrowserVersion("153");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://www.letskodeit.com/practice");

        By byChkBmw = By.id("bmwcheck");
//        WebElement chkBmw = chromeDriver.findElement(byChkBmw);
//        chkBmw.click();
//        System.out.println(chkBmw.isSelected()); // true

        setCheckbox(chromeDriver, byChkBmw, false);

        Thread.sleep(3000);

        chromeDriver.quit();
    }

    public static void setCheckbox(WebDriver driver, By locator, boolean status) {
        WebElement checkboxElement = driver.findElement(locator);
        //kiem tra trang thai hien co != trang thai mong doi
        if(checkboxElement.isSelected() != status) {
            checkboxElement.click();
        }
    }
}
