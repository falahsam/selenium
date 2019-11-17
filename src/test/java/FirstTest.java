
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;

public class FirstTest {

    static long CurruntTimeNum = System.currentTimeMillis();
    @Test(groups = {"Database Test"}, description = "TC001: Verify IBIS Home Page")
    public void verifyHomePage(Method method) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://www.google.com";
        // launch chrome and direct it to the Base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();

        WebElement TextSearchBox = driver.findElement(By.name("q"));
        WebElement SearchBotton = driver.findElement(By.name("btnK"));
        WebElement GoogleLogo = driver.findElement(By.id("hplogo"));
        TextSearchBox.sendKeys("NHIEC");
        GoogleLogo.click();
        Thread.sleep(3000);
        SearchBotton.sendKeys(Keys.RETURN);

        WebElement NHIECGoogleLink = driver.findElement(By.className("S3Uucc"));
        NHIECGoogleLink.click();


        // Home Page is displayed
        WebElement HomePageLink = driver.findElement(By.linkText("North Hudson Islamic Educational Center"));
        assertTrue(HomePageLink.isDisplayed());
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (HomePageLink.isDisplayed()) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        //close Fire fox
        driver.close();

    }
}


