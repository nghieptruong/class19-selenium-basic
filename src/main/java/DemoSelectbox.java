import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DemoSelectbox {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setBrowserVersion("153");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://www.letskodeit.com/practice");

        By bySelCar = By.id("carselect");
        WebElement selCarWebElement = chromeDriver.findElement(bySelCar);
        Select selCar = new Select(selCarWebElement);
//        selCar.selectByVisibleText("Benz"); // chon bang text nhin thay ben ngoai
//        selCar.selectByIndex(1); // chon bang index (bat dau tu 0)
        selCar.selectByValue("benz");
        String selectedOption = selCar.getFirstSelectedOption().getText();
        System.out.println(selectedOption);

        Thread.sleep(3000);

        chromeDriver.quit();
    }
}
