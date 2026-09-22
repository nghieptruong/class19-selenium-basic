import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        //co the khai bao bang ChromeDriver hoac WebDriver (cha cua tat ca cac class driver)
//        ChromeDriver chromeDriver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://demo1.cybersoft.edu.vn/sign-up");

        //Step 1: Enter account textbox
        By byAccountTextbox = By.id("taiKhoan");
        WebElement accountTextbox = chromeDriver.findElement(byAccountTextbox);
        accountTextbox.sendKeys("JohnTesting19_01");

        Thread.sleep(1000);

        //Step 2: Enter password
        By byTxtPassword = By.name("matKhau");
        WebElement txtPassword = chromeDriver.findElement(byTxtPassword);
        txtPassword.sendKeys("123456");

//        FirefoxDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("https://demo1.cybersoft.edu.vn/");

//        SafariDriver safariDriver = new SafariDriver();
//        safariDriver.get("https://demo1.cybersoft.edu.vn/");

        Thread.sleep(3000);

        //Close browser & kill process chromedriver
        chromeDriver.quit();
    }
}
