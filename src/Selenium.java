import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Selenium {

    public static final int TIME_OUT_IN_SECONDS = 2;

    public static void main(String[] args) {
        System.out.println("Selenium + JUnit");

    }
    private static void waitForElementById(WebDriver browser, String id){
        WebDriverWait waitSubmit = new WebDriverWait(browser, TIME_OUT_IN_SECONDS);
        waitSubmit.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    private static void waitForElementByClassName(WebDriver browser, String classOfElement){
        WebDriverWait waitSubmit = new WebDriverWait(browser, TIME_OUT_IN_SECONDS);
        waitSubmit.until(ExpectedConditions.visibilityOfElementLocated(By.className(classOfElement)));
    }

    private static void waitForElementByXpath(WebDriver browser, String elmXpath){
        WebDriverWait waitSubmit = new WebDriverWait(browser, TIME_OUT_IN_SECONDS);
        waitSubmit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elmXpath)));
    }

}
