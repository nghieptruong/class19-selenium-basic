import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.UUID;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        //co the khai bao bang ChromeDriver hoac WebDriver (cha cua tat ca cac class driver)
        //        FirefoxDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("https://demo1.cybersoft.edu.vn/");

//        SafariDriver safariDriver = new SafariDriver();
//        safariDriver.get("https://demo1.cybersoft.edu.vn/");


        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver chromeDriver = new ChromeDriver(options);

//        //khai báo implicit wait là 10s (khi findElement ko thấy thì sẽ đợi maximum 10s)
//        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //khai bao explicit wait
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        FluentWait<WebDriver> wait = new FluentWait<>(chromeDriver);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.ignoring(NotFoundException.class);

        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://demo1.cybersoft.edu.vn/sign-up");

        //Step 1: Enter account textbox
        By byAccountTextbox = By.id("taiKhoan");
        WebElement accountTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byAccountTextbox));

        String account = UUID.randomUUID().toString();
        String email = account + "@example.com";
        System.out.println("Account: " + account);
        System.out.println("Email: " + email);

        accountTextbox.sendKeys(account);

        //Step 2: Enter password
        By byTxtPassword = By.name("matKhau");
        WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
        txtPassword.sendKeys("123456");

        //Step 3: Re-enter password
        By byTxtConfirmPassword = By.id("confirmPassWord");
        WebElement txtConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));
        txtConfirmPassword.sendKeys("123456");

        //Step 4: Enter full name
        By byTxtFullname = By.id("hoTen");
        WebElement txtFullName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtFullname));
        txtFullName.sendKeys("John Johnson");

        //Step 5: Enter email
        By byTxtEmail = By.id("email");
        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));
        txtEmail.sendKeys(email);

        //Step 6: Click register
        By byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");
        WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(byBtnRegister));
        btnRegister.click();

        Thread.sleep(10000);

        //Close browser & kill process chromedriver
        chromeDriver.quit();
    }
}
