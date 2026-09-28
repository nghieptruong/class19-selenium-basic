import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoTable {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setBrowserVersion("153");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://www.letskodeit.com/practice");

        String value = getTableCellValue(chromeDriver,"//table/tbody", 1, 2);
        System.out.println(value);

        Thread.sleep(3000);

        chromeDriver.quit();
    }

    public static String getTableCellValue(WebDriver driver, String tableLocator, int row, int col) {
//        String xpathCell = tableLocator + "/tr[" + (row + 1) + "]/td[" + col + "]";
        String cellTemplate = tableLocator + "/tr[%d]/td[%d]";
        String xpathCell = String.format(cellTemplate, row + 1, col);
        By byCell = By.xpath(xpathCell);
        WebElement cellElement = driver.findElement(byCell);
        String text = cellElement.getText();

        return text;
    }

    public static String getTableHeader(WebDriver driver, String tableLocator, int col) {
        return "";
    }

    public static String getTableCellByColumnName(WebDriver driver, String tableLocator, String columnName) {
        return "";
    }

    public static boolean isCellValueExist(WebDriver driver, String tableLocator, String value) {
        return true;
    }


}
