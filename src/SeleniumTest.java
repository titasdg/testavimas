import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class SeleniumTest {
    WebDriver browser;
    private static final int TIME_OUT_IN_SECONDS = 2;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\moksleivis\\Documents\\inteli\\seleniumas\\Selenium5\\libs\\chromedriver.exe");
         browser = new ChromeDriver();
        browser.get("http://algirdaskuslys.000webhostapp.com/selenium/filmai.php");
    }
    @Test
    public void testAddNew(){
        String pavadinimas = "Baranauskas";
        String zanras = "Baranauskas";
        String rezisierius = "Baranauskas";

        WebElement searchField = browser.findElement(By.xpath("//*[@name='pavadinimas']"));
        waitForElementByXpath(browser, "//*[@name='pavadinimas']");
        searchField.sendKeys(pavadinimas);

        WebElement searchField2 = browser.findElement(By.xpath("//*[@name='zanras']"));
        waitForElementByXpath(browser, "//*[@name='zanras']");
        searchField2.sendKeys(zanras);

        WebElement searchField3 = browser.findElement(By.xpath("//*[@name='rezisierius']"));
        waitForElementByXpath(browser, "//*[@name='rezisierius']");
        searchField3.sendKeys(rezisierius);

        WebElement addButton = browser.findElement(By.xpath("//*[@name='insert']"));
        waitForElementByXpath(browser, "//*[@name='insert']");
        addButton.click();

        WebElement resultCount = browser.findElement(By.className("msg-good"));
        String resultString = resultCount.getText();
        // int skaicius =  Integer.parseInt(resultString.replaceAll("[^0-9]",""));
        System.out.println(resultString);

        String results = "";

        if (resultString=="Duomenys irasyti sekmingai"){
            results="true";
            assertEquals("true",results);
        }

    }

    @Test
    public void testWrongValidation(){
        String pavadinimas = "Baranauskas";
        String rezisierius = "Baranauskas";

        WebElement searchField = browser.findElement(By.xpath("//*[@name='pavadinimas']"));
        waitForElementByXpath(browser, "//*[@name='pavadinimas']");
        searchField.sendKeys(pavadinimas);


        WebElement searchField3 = browser.findElement(By.xpath("//*[@name='rezisierius']"));
        waitForElementByXpath(browser, "//*[@name='rezisierius']");
        searchField3.sendKeys(rezisierius);

        WebElement addButton = browser.findElement(By.xpath("//*[@name='insert']"));
        waitForElementByXpath(browser, "//*[@name='insert']");
        addButton.click();

        WebElement resultCount = browser.findElement(By.className("msg-bad"));
        String resultString = resultCount.getText();
        // int skaicius =  Integer.parseInt(resultString.replaceAll("[^0-9]",""));
        System.out.println(resultString);

        String results = "";

        if (resultString=="Blogai ivesti duomenys kuriant nauja irasa"){
            results="true";
            assertEquals("true",results);
        }
    }
    @Test
    public void edit(){
        String pavadinimas = "REDAGUOTAS";
        String zanras = "REDAGUOTAS";
        String rezisierius = "REDAGUOTAS";
        String id= "345";
        WebElement searchField0 = browser.findElement(By.xpath("//*[@name='id']"));
        waitForElementByXpath(browser, "//*[@name='pavadinimas']");
        searchField0.sendKeys(id);

        WebElement searchField = browser.findElement(By.xpath("//*[@name='pavadinimas']"));
        waitForElementByXpath(browser, "//*[@name='pavadinimas']");
        searchField.sendKeys(pavadinimas);

        WebElement searchField2 = browser.findElement(By.xpath("//*[@name='zanras']"));
        waitForElementByXpath(browser, "//*[@name='zanras']");
        searchField2.sendKeys(zanras);

        WebElement searchField3 = browser.findElement(By.xpath("//*[@name='rezisierius']"));
        waitForElementByXpath(browser, "//*[@name='rezisierius']");
        searchField3.sendKeys(rezisierius);

        WebElement addButton = browser.findElement(By.xpath("//*[@name='update']"));
        waitForElementByXpath(browser, "//*[@name='update']");
        addButton.click();

        WebElement resultCount = browser.findElement(By.className("msg-good"));
        String resultString = resultCount.getText();
        // int skaicius =  Integer.parseInt(resultString.replaceAll("[^0-9]",""));
        System.out.println(resultString);

        String results = "";

        if (resultString=="Irasas redaguotas sekmingai"){
            results="true";
            assertEquals("true",results);
        }

    }
    @Test
    public void editFail(){
        String pavadinimas = "neredaguotas";

        String rezisierius = "neredaguotas";
        String id= "345";
        WebElement searchField0 = browser.findElement(By.xpath("//*[@name='id']"));
        waitForElementByXpath(browser, "//*[@name='pavadinimas']");
        searchField0.sendKeys(id);

        WebElement searchField = browser.findElement(By.xpath("//*[@name='pavadinimas']"));
        waitForElementByXpath(browser, "//*[@name='pavadinimas']");
        searchField.sendKeys(pavadinimas);


        WebElement searchField3 = browser.findElement(By.xpath("//*[@name='rezisierius']"));
        waitForElementByXpath(browser, "//*[@name='rezisierius']");
        searchField3.sendKeys(rezisierius);

        WebElement addButton = browser.findElement(By.xpath("//*[@name='update']"));
        waitForElementByXpath(browser, "//*[@name='update']");
        addButton.click();

        WebElement resultCount = browser.findElement(By.className("msg-bad"));
        String resultString = resultCount.getText();
        // int skaicius =  Integer.parseInt(resultString.replaceAll("[^0-9]",""));
        System.out.println(resultString);

        String results = "";

        if (resultString=="Blogai ivesti duomenys redaguojant irasa"){
            results="true";
            assertEquals("true",results);
        }

    }
    @Test
    public void trinti(){

        String id= "345";
        WebElement searchField0 = browser.findElement(By.xpath("//*[@name='id']"));
        waitForElementByXpath(browser, "//*[@name='pavadinimas']");
        searchField0.sendKeys(id);



        WebElement addButton = browser.findElement(By.xpath("//*[@name='delete']"));
        waitForElementByXpath(browser, "//*[@name='delete']");
        addButton.click();

        WebElement resultCount = browser.findElement(By.className("msg-good"));
        String resultString = resultCount.getText();
        // int skaicius =  Integer.parseInt(resultString.replaceAll("[^0-9]",""));
        System.out.println(resultString);

        String results = "";

        if (resultString=="Irasas istrintas sekmingai"){
            results="true";
            assertEquals("true",results);
        }

    }

    @After
    public void tearDown() throws Exception {
        //browser.close();
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
